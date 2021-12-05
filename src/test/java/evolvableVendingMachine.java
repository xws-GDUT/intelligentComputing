import com.vsen.expriment.Evaluator;
import com.vsen.expriment.MaxProfitFunction;
import com.vsen.expriment.Bound;
import com.vsen.expriment.Individual;
import org.junit.jupiter.api.Test;

import java.util.*;

public class evolvableVendingMachine {
    public static final int NP=20;
    public static final int VARS=10;
    public static final double RATE_OF_MUTATION = 0.1;
    public static final double RATE_OF_CROSSOVER = 0.75;
    public static final int GENERATION = 3000;              //
    @Test
    public void test(){
        Bound<Integer> bound= new Bound(1,14);
        Evaluator evaluator = new MaxProfitFunction();

        List<Individual> bestInPerGeneration = new ArrayList<>();
        // 遗传算法基本过程
        // 种群初始化
        List<Individual> pop = init(NP, VARS, bound);
        // 评价函数
        evaluator.evaluate(pop);
//        System.out.println(pop);
        for (int i = 0; i < GENERATION; i++) {
            bestInPerGeneration.add(Collections.max(pop));
            // 选择
            List<Individual> offspring=select(pop);
//            System.out.println(offspring);
            // 交叉
            crossover(offspring);
//            System.out.println(offspring);
            // 变异
            mutate(offspring,bound);
            // 评价
            evaluator.evaluate(offspring);
            pop=offspring;
        }
        System.out.println(Collections.max(bestInPerGeneration));
    }
    public static List<Individual> init(int popsize, int vars, Bound bound){

        List<Individual> pop = new ArrayList<>();
        for (int i = 0; i < popsize; i++) {
            Individual<Integer> newIndividual = new Individual<>();
            List<Integer> solution = new ArrayList<>();
            for (int j = 0; j < vars; j++) {
                solution.add(new Random().nextInt((Integer) bound.getUpperBound())+1);
            }
            newIndividual.setSolution(solution);
            pop.add(newIndividual);
        }
        return pop;
    }
    public static List<Individual> select(List<Individual> pop){
        List<Individual> tmpPop = new ArrayList<>();;
        //轮盘赌选择法
        Double sumFit = 0.0;
        for (int i = 0; i < pop.size(); i++) {
            sumFit += pop.get(i).getFitness();
        }
        List<Double> probability = new ArrayList<Double>();
        for (int i = 0; i < pop.size(); i++) {
            probability.add(pop.get(i).getFitness() / sumFit);
        }

        for (int i = 0; i < pop.size(); i++) {
            int k = -1; //轮盘选择到的个体
            double p = new Random().nextDouble();
            double sumProbability = 0;
            for (int j = 0; j < pop.size(); j++) {
                sumProbability+=probability.get(j);
                if(sumProbability>p){
                    k=j;
                    break;
                }
            }
            try {
                tmpPop.add((Individual) pop.get(k).clone());
            } catch (CloneNotSupportedException e ) {
                e.printStackTrace();
            }
        }


        return tmpPop;
    }
    public static void crossover(List<Individual> pop){
        for (int i = 0; i < pop.size(); i+=2) {
            double p = new Random().nextDouble();
            if(p < RATE_OF_CROSSOVER){
//                pop.get(i) pop.get(i+1)
                for(int j = 0; j< VARS; j++){
                    p = new Random().nextDouble();
                    if(p < RATE_OF_CROSSOVER){
                        int temp = (int) pop.get(i).getSolution().get(j);
                        pop.get(i).getSolution().set(j,pop.get(i+1).getSolution().get(j));
                        pop.get(i+1).getSolution().set(j,temp);
                    }
                }

            }
        }
    }

    public static void mutate(List<Individual> pop,Bound bound){
        int numOfMutation = (int) Math.round(NP*RATE_OF_MUTATION);
        List<Integer> numOfRandom = getNumOfRandom(bound, numOfMutation);
        for (int i = 0; i < numOfRandom.size(); i++) {
            for (int j = 0; j < VARS; j++) {
                double p = new Random().nextDouble();
                if(p< RATE_OF_MUTATION){
                    pop.get(numOfRandom.get(i)).getSolution().set(j,new Random().nextInt((Integer) bound.getUpperBound())+1);
                }
            }
        }
    }

    public static List<Integer> getNumOfRandom(Bound bound,int amount){
        Set<Integer> randomNum = new HashSet<>();
        while(randomNum.size()<amount){
            randomNum.add(new Random().nextInt((Integer) bound.getUpperBound())+1);
        }
        return new ArrayList<>(randomNum);
    }
    @Test
    public void testRandom(){
        List<Integer> list= new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new Random().nextInt(14)+1);
        }
        for (Integer integer : list) {
            if(integer<1 || integer >14 ){
                System.out.println("integer<1 || integer >14");
            }
            if(Integer.valueOf("1").equals(integer)){
                System.out.println("contain 1");
            }
            if(Integer.valueOf("14").equals(integer)){
                System.out.println("contain 14");
            }
        }
    }
    @Test
    public void testRandom2(){
        List<Double> list= new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
//            list.add(Math.round(new Random().nextDouble()*100)/100.0);
            list.add(Math.round(Math.random()*100)/100.0);
        }
        for (Double num : list) {
            if(num<0 || num >1 ){
                System.out.println("num<0 || num >1");
            }else if(Double.valueOf("0").equals(num)){
                System.out.println("contain 0");
            }else if(Double.valueOf("1").equals(num)){
                System.out.println("contain 1");
            }else{
                System.out.println(num);
            }
        }
    }
    @Test
    public void test3(){
//        for (int i = 0; i < 20; i+=2) {
//            System.out.println(i);
//        }
//        System.out.println(NP*RATE_OF_MUTATION);
//        System.out.println(Math.round(NP*RATE_OF_MUTATION));
//        int numOfMutation = (int) Math.round(NP*RATE_OF_MUTATION);
//        System.out.println(numOfMutation);

        List<Integer> numOfRandom = getNumOfRandom(new Bound(1, 14), 2);
        System.out.println(numOfRandom);
    }

}
