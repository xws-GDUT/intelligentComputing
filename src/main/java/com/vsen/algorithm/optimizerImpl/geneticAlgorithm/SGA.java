package com.vsen.algorithm.optimizerImpl.geneticAlgorithm;

import com.vsen.benchmark.Bound;
import com.vsen.algorithm.Optimizer;
import com.vsen.benchmark.Evaluator;
import com.vsen.pojo.Individual;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by wansenxu@163.com on 2020/12/10
 */
public class SGA implements Optimizer {
    private final int POPSIZE=100;
    private final int DIMENSION=30;
    private final double rateOfCrossover=0.85;
    private final double rateOfMutation=0.02;
    //实验参数（仅在存在于实验条件）
    private final int evolutionCount =3000;  //进化次数

    @Override
    public List<Individual> optimize(Evaluator evaluator)  {
        List<Individual> pop = null;
        List<Individual> bestIndividualPerGeneration = new ArrayList<>();
        List<Individual> convergence = new ArrayList<>();
        for(int j = 0; j<=evolutionCount; j++){
            if(j==0){
                //种群初始化
                pop = initPop(DIMENSION,evaluator.getBound());
            }else{
                //种群演化
//                for (Individual individual : pop) {
//                    individual.setFitness(evaluator.evaluate(individual.getSolution()));
//                }
                pop = select(pop);
                crossover(pop);
                mutate(pop,evaluator.getBound());
            }
            for (Individual individual : pop) {
                individual.setFitness(evaluator.evaluate(individual.getSolution()));
            }
//            System.out.println("--");
            try {
                bestIndividualPerGeneration.add((Individual) pop.stream().min(Individual::compareTo).get().clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
//            if(j%500==0){
//                convergence.add((Individual) bestIndividualPerGeneration.stream().min(Individual::compareTo).get().clone());
//            }
        }
        return convergence;
    }

    public void mutate(List<Individual> pop,Bound bound) {
        for (int i = 0; i < pop.size(); i++) {
            for (int j = 0; j < pop.get(i).getSolution().size(); j++) {
                double p = Math.random();
                if (p < rateOfMutation) {
                    pop.get(i).getSolution().set(j,bound.getLowerBound()+new Random().nextDouble()*(bound.getUpperBound()-bound.getLowerBound()));
                }
            }
        }
    }

    public void crossover(List<Individual> pop) {
        int x = 0;//存放待交叉个体的下标
        int count = 0;
        for (int i = 0; i < POPSIZE; i++) {
            double p = Math.random();
            if (p < rateOfCrossover) {
                count++;
                if (count % 2 == 0) {
                    //x,i分别是两个待交叉个体的下标
                    double tmp = 0;
                    int j = (int) (Math.random() * pop.get(0).getSolution().size());
                    tmp = pop.get(x).getSolution().get(j);
                    pop.get(x).getSolution().set(j, pop.get(i).getSolution().get(j));
                    pop.get(i).getSolution().set(j, tmp);
                } else {
                    x = i;
                }
            }
        }
    }

    public List<Individual> select(List<Individual> pop) {
        List<Individual> tmpPop = new ArrayList<Individual>();;
        //轮盘赌选择法
        Double sumReciprocalOfFit = 0.0;
        for (int i = 0; i < pop.size(); i++) {
            sumReciprocalOfFit += 1.0 / pop.get(i).getFitness();
        }
        List<Double> probability = new ArrayList<Double>();
        for (int i = 0; i < pop.size(); i++) {
            probability.add(1.0 / pop.get(i).getFitness() / sumReciprocalOfFit);
        }
        for (int i = 0; i < POPSIZE; i++) {
            double p = Math.random();
            double sumProbability = 0;
            Iterator<Double> iterator = probability.iterator();
            int count = -1;
            while (iterator.hasNext() && sumProbability < p) {
                sumProbability += iterator.next();
                count++;
            }
            try {
                tmpPop.add((Individual) pop.get(count).clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        return tmpPop;
    }

    public List<Individual> initPop(int dimension, Bound bound) {
        List<Individual> pop=new ArrayList<>();
        for (int i = 0; i < POPSIZE; i++) {
            Individual individual = initIndividual(dimension,bound);
            pop.add(individual);
        }
        return pop;
    }

    private Individual initIndividual(int dimension, Bound bound) {
        Individual individual = new Individual();
        List<Double> solution = new ArrayList<>();
        for (int j = 0; j < dimension; j++) {
            solution.add(bound.getLowerBound()+new Random().nextDouble()*(bound.getUpperBound()-bound.getLowerBound()));
        }
        individual.setSolution(solution);
        return individual;
    }
}
