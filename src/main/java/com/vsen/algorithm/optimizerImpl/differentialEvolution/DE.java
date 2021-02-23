package com.vsen.algorithm.optimizerImpl.differentialEvolution;

import com.vsen.algorithm.*;
import com.vsen.benchmark.Bound;
import com.vsen.benchmark.Evaluator;
import com.vsen.pojo.Individual;

import java.util.*;

/**
 * Created by wansenxu@163.com on 2020/12/10
 */
public class DE implements Optimizer {
    private MutateType mutateType;
    private CrossoverType crossoverType;
    private int differentialVectorNo;


    private final int POPSIZE=100;
    private final int DIMENSION=30;
    private final double rateOfCrossover=0.9;
    private final double F=0.5;
    private final double LAMBADA=0.5;
    //实验参数（仅存在于实验条件）
    private final int evolutionCount =3000;  //进化次数

    /**
     * 通过给定的评价目标（evaluator），随机生成一个组解（即种群pop）依据该评价目标不断进行优化最终得到最优解
     * @param evaluator
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public List<Individual> optimize(Evaluator evaluator){
        List<Individual> bestPerGeneration=new ArrayList<>();
        List<Individual> pop=initPop(POPSIZE,evaluator.getBound(),DIMENSION);
        evaluate(pop,evaluator);
        for (int k = 0; k < evolutionCount; k++) {
            //差分变异
            List<Individual> mutatedPop = mutate(pop,evaluator.getBound());
            //交叉
            List<Individual> offspring = crossover(pop, mutatedPop);
            evaluate(offspring,evaluator);
            //从pop和offspring种群中选择最优个体作为下一代种群的个体
            pop=selectOptimalIndividual(pop, offspring);
            //记录每一代的最优个体，观察该算法的收敛趋势
            bestPerGeneration.add(Collections.min(pop));
        }
        return bestPerGeneration;
    }

    private void evaluate(List<Individual> pop,Evaluator evaluator){
        for (Individual individual : pop) {
            individual.setFitness(evaluator.evaluate(individual.getSolution()));
        }
    }

    public List<Individual> selectOptimalIndividual(List<Individual> pop, List<Individual> offspring) {
        List<Individual> nextPop=new ArrayList<>();
        for (int i=0;i<pop.size();i++){
            if(pop.get(i).getFitness()>offspring.get(i).getFitness()){
                nextPop.add(offspring.get(i));
            }else{
                nextPop.add(pop.get(i));
            }
        }
        return nextPop;
    }

    public List<Individual> crossover(List<Individual> pop, List<Individual> mutatedPop) {
        List<Individual> offspring;
        CrossoverType crossoverType = this.crossoverType;
        switch (crossoverType){
            case BIN:
                offspring = crossoverByBin(pop,mutatedPop);
                break;
            case EXP:
                offspring = crossoverByExp(pop,mutatedPop);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + crossoverType);
        }
        return offspring;
    }

    private List<Individual> crossoverByExp(List<Individual> pop, List<Individual> mutatedPop) {
        List<Individual> offspring = new ArrayList<>();
        for(int i=0;i<pop.size();i++){
            Individual individual = new Individual();
            List<Double> solution = new ArrayList<>();
            int popisitonOfCrossover = new Random().nextInt(pop.get(0).getSolution().size());
            int k=0;
            for(k=0;k<popisitonOfCrossover;k++){
                solution.add(pop.get(i).getSolution().get(k));
            }
            solution.add(mutatedPop.get(i).getSolution().get(k));
            for(k= k+1 ;k< pop.get(0).getSolution().size(); k++) {
                double p = Math.random();
                if (p <= rateOfCrossover) {
                    solution.add(mutatedPop.get(i).getSolution().get(k));
                }else{
                    break;
                }
            }
            while(k < pop.get(0).getSolution().size()){
                solution.add(pop.get(i).getSolution().get(k));
                k++;
            }

            individual.setSolution(solution);
            offspring.add(individual);
        }
        return offspring;
    }

    private List<Individual> crossoverByBin(List<Individual> pop, List<Individual> mutatedPop) {
        List<Individual> offspring = new ArrayList<>();
        for(int i=0;i<mutatedPop.size();i++){
            int popisitonOfCrossover = new Random().nextInt(pop.get(0).getSolution().size());
//            Individual tmpIndividual = mutatedPop.get(i);
            Individual individual = new Individual();
            List<Double> solution = new ArrayList<>();
            for(int j = 0; j< pop.get(0).getSolution().size(); j++){
                double p = Math.random();
                if( p > rateOfCrossover && popisitonOfCrossover != j){
                    solution.add(j,pop.get(i).getSolution().get(j));
                }else{
                    solution.add(j,mutatedPop.get(i).getSolution().get(j));
                }
            }
            individual.setSolution(solution);
            offspring.add(individual);
        }
        return offspring;
    }
    public double handleOutOfBoundary(Double value,double lowerBoundary, double upperBoundary){
//        if(value<lowerBoundary ){
//            value = lowerBoundary;
//        }else if(value > upperBoundary) {
//            value = upperBoundary;
//        }
        if(value<lowerBoundary || value > upperBoundary){
            value = lowerBoundary+new Random().nextDouble()*(upperBoundary-lowerBoundary);
        }
        return value;
    }

    private List<Individual> rand_1(List<Individual> pop, Bound bound){
        List<Individual> mutatedPop = new ArrayList<Individual>();
        for (int i = 0; i < pop.size(); i++) {
            Individual individual =new Individual();
            List<Double> solution = new ArrayList<Double>();
            List<Integer> indexes = getRamdonExceptX(pop.size(),3,i);
            for (int j = 0; j < pop.get(0).getSolution().size(); j++) {
                double value= pop.get(indexes.get(0)).getSolution().get(j)
                        +F
                        *(pop.get(indexes.get(1)).getSolution().get(j)-pop.get(indexes.get(2)).getSolution().get(j));
                value=handleOutOfBoundary(value,bound.getLowerBound(),bound.getUpperBound());
                solution.add(value);
            }
            individual.setSolution(solution);
            mutatedPop.add(individual);
        }
        return mutatedPop;
    }
    private List<Individual> rand_2(List<Individual> pop,Bound bound) {
        List<Individual> mutatedPop = new ArrayList<Individual>();
        for (int i = 0; i < pop.size(); i++) {
            Individual individual = new Individual();
            List<Double> solution = new ArrayList<Double>();
            //获得五个在[0,99]且两两不等的五个数
            List<Integer> indexes = getRamdonExceptX(pop.size(),5,i);
            for (int j = 0; j < pop.get(0).getSolution().size(); j++) {
                double value = pop.get(indexes.get(0)).getSolution().get(j) + F * (pop.get(indexes.get(1)).getSolution().get(j) + pop.get(indexes.get(2)).getSolution().get(j) - pop.get(indexes.get(3)).getSolution().get(j) - pop.get(indexes.get(4)).getSolution().get(j));
                value=handleOutOfBoundary(value,bound.getLowerBound(),bound.getUpperBound());
                solution.add(value);
            }
                individual.setSolution(solution);
                mutatedPop.add(individual);
            }
        return mutatedPop;
    }
    private List<Individual> best_1(List<Individual> pop,Bound bound) {
        List<Individual> mutatedPop = new ArrayList<Individual>();
//        Individual bestIndividual = (Individual) pop.stream().min(Individual::compareTo).get().clone();
        Individual bestIndividual = null;
        try {
            bestIndividual = (Individual) Collections.min(pop).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < pop.size(); i++) {
            Individual individual = new Individual();
            List<Double> solution = new ArrayList<Double>();
            List<Integer> indexes = getRamdonExceptX(pop.size(),2,i);
            for (int j = 0; j < pop.get(0).getSolution().size(); j++) {
                double value = bestIndividual.getSolution().get(j) + F * (pop.get(indexes.get(0)).getSolution().get(j) - pop.get(indexes.get(1)).getSolution().get(j));
                value=handleOutOfBoundary(value,bound.getLowerBound(),bound.getUpperBound());
                solution.add(value);
            }
            individual.setSolution(solution);
            mutatedPop.add(individual);
        }
        return mutatedPop;
    }
    private List<Individual> best_2(List<Individual> pop,Bound bound){
        List<Individual> mutatedPop = new ArrayList<Individual>();
//        Individual bestIndividual = (Individual) pop.stream().min(Individual::compareTo).get().clone();
        Individual bestIndividual = null;
        try {
            bestIndividual = (Individual) Collections.min(pop).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        try {
            bestIndividual = (Individual) Collections.min(pop).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < pop.size(); i++) {
            Individual individual = new Individual();
            List<Double> solution = new ArrayList<Double>();
            List<Integer> indexes = getRamdonExceptX(pop.size(),4,i);
            for (int j = 0; j < pop.get(0).getSolution().size(); j++) {
                double value = bestIndividual.getSolution().get(j)+F
                        *(pop.get(indexes.get(0)).getSolution().get(j)+pop.get(indexes.get(1)).getSolution().get(j)
                        -pop.get(indexes.get(2)).getSolution().get(j)- pop.get(indexes.get(3)).getSolution().get(j));

                value=handleOutOfBoundary(value,bound.getLowerBound(),bound.getUpperBound());
                solution.add(value);
            }
            individual.setSolution(solution);
            mutatedPop.add(individual);
        }
        return mutatedPop;
    }
    private List<Individual> randToBest_1(List<Individual> pop,Bound bound){
        List<Individual> mutatedPop = new ArrayList<Individual>();
//        Individual bestIndividual = (Individual) pop.stream().min(Individual::compareTo).get().clone();
        Individual bestIndividual = null;
        try {
            bestIndividual = (Individual) Collections.min(pop).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < pop.size(); i++) {
            Individual individual = new Individual();
            List<Double> solution = new ArrayList<Double>();
            List<Integer> indexes = getRamdonExceptX(pop.size(),2,i);
            for (int j = 0; j < pop.get(0).getSolution().size(); j++) {
                double value = pop.get(i).getSolution().get(j)
                        +LAMBADA*(bestIndividual.getSolution().get(j)
                        -pop.get(i).getSolution().get(j))
                        +F * (pop.get(indexes.get(0)).getSolution().get(j)
                        - pop.get(indexes.get(1)).getSolution().get(j));
                value=handleOutOfBoundary(value,bound.getLowerBound(),bound.getUpperBound());
                solution.add(value);
            }
            individual.setSolution(solution);
            mutatedPop.add(individual);
            if(i==99)break;
        }
        return mutatedPop;
    }
    public List<Individual> mutate(List<Individual> pop,Bound bound) {
        List<Individual> mutatedPop = null;
        MutateType mutateType = this.mutateType;
        switch (mutateType) {
            case RAND:
                if (differentialVectorNo == 1) {
                    mutatedPop = rand_1(pop,bound);
                } else if (differentialVectorNo == 2) {
                    mutatedPop = rand_2(pop,bound);
                }
                break;
            case BEST:
                if (differentialVectorNo == 1) {
                    mutatedPop = best_1(pop,bound);
                } else if (differentialVectorNo == 2) {
                    mutatedPop = best_2(pop,bound);
                }
                break;
            case RANDtoBest:
                if (differentialVectorNo == 1) {
                    mutatedPop = randToBest_1(pop,bound);
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + mutateType);
        }
        return mutatedPop;
    }


    public List<Individual> initPop(int popsize, Bound bound, int dimension) {
        List<Individual> pop = new ArrayList<>();
        for (int i = 0; i < popsize; i++) {
            Individual individual = initIndividual(dimension,bound);
            pop.add(individual);
        }
        return pop;
    }
    private Individual initIndividual(int dimension,Bound bound){
        Individual individual = new Individual();
        List<Double> solution = new ArrayList<>();
        for (int j = 0; j < dimension; j++) {
            solution.add(bound.getLowerBound()+new Random().nextDouble()*(bound.getUpperBound()-bound.getLowerBound()));
        }
        individual.setSolution(solution);
        return individual;
    }
    public List<Integer> getRamdon(int bound,int amount){
        List list = new ArrayList();
        while(list.size()<amount){
            list.add(new Random().nextInt(bound));
        }
        return list;
    }
    public List<Integer> getRamdonExceptX(int bound,int amount,int excluded){
        List list = getRamdon(bound,amount);
        if(list.contains(excluded)){
            list.remove(Integer.valueOf(excluded));
            int number = -1;
            do{
                number = new Random().nextInt(100);
            }while(number != excluded) ;
            list.add(number);
        }
        return  list;
    }

    public MutateType getMutateType() {
        return mutateType;
    }

    public void setMutateType(MutateType mutateType) {
        this.mutateType = mutateType;
    }

    public CrossoverType getCrossoverType() {
        return crossoverType;
    }

    public void setCrossoverType(CrossoverType crossoverType) {
        this.crossoverType = crossoverType;
    }

    public int getDifferentialVectorNo() {
        return differentialVectorNo;
    }

    public void setDifferentialVectorNo(int differentialVectorNo) {
        this.differentialVectorNo = differentialVectorNo;
    }

}

