import com.vsen.algorithm.Optimizer;
import com.vsen.benchmark.Evaluator;
import com.vsen.pojo.Individual;
import com.vsen.service.BestService;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wansenxu@163.com on 2020/12/11
 */
public class TestStrategyForF6 {
    ApplicationContext applicationContext;
    Evaluator evaluator;
    BestService bestService;

    @BeforeEach
    public void init(){
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        evaluator = (Evaluator) applicationContext.getBean("f6");
        bestService = (BestService) applicationContext.getBean("bestServiceImpl");
    }
    @Test
    public void rand_1_bin(){
        String strategy = "rand-1-bin";
//        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        evaluator = (Evaluator) applicationContext.getBean("f6");
//        bestService = (BestService) applicationContext.getBean("bestServiceImpl");
        Optimizer optimizer = (Optimizer) applicationContext.getBean(strategy);
        try {

            List<Double> sum = new ArrayList<>();
            for (int i = 0; i < 3000; i++) {
                sum.add(0.0);
            }
            for (int i = 0; i < 30; i++) {
                List<Individual> bestPerGeneration = optimizer.optimize(evaluator);
                List<Double> fitnessPerGeneration = bestPerGeneration.stream().map(Individual::getFitness).collect(Collectors.toList());
                for (int j = 0; j < sum.size(); j++) {
                    sum.set(j,sum.get(j)+fitnessPerGeneration.get(j));
                }
                System.out.println(fitnessPerGeneration);
            }
            for (int i = 0; i < 3000; i++) {
                sum.set(i,sum.get(i)/30.0);
            }
            System.out.println(sum);
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < sum.size(); i++) {
                str.append((i+1)+"\t"+sum.get(i)+"\n");
            }
            Double fitness = sum.stream().min(Double::compareTo).get();
            bestService.updateF6(strategy,fitness);
            FileUtils.write(new File("convergence/rand_1_bin/f6.txt"),str,"UTF-8",false);
        } catch (CloneNotSupportedException | IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void rand_2_bin(){
        String strategy = "rand-2-bin";
        Optimizer optimizer = (Optimizer) applicationContext.getBean(strategy);
        try {

            List<Double> sum = new ArrayList<>();
            for (int i = 0; i < 3000; i++) {
                sum.add(0.0);
            }
            for (int i = 0; i < 30; i++) {
                List<Individual> bestPerGeneration = optimizer.optimize(evaluator);
                List<Double> fitnessPerGeneration = bestPerGeneration.stream().map(Individual::getFitness).collect(Collectors.toList());
                for (int j = 0; j < sum.size(); j++) {
                    sum.set(j,sum.get(j)+fitnessPerGeneration.get(j));
                }
                System.out.println(fitnessPerGeneration);
            }
            for (int i = 0; i < 3000; i++) {
                sum.set(i,sum.get(i)/30.0);
            }
            System.out.println(sum);
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < sum.size(); i++) {
                str.append((i+1)+"\t"+sum.get(i)+"\n");
            }
            Double fitness = sum.stream().min(Double::compareTo).get();
            bestService.updateF6(strategy,fitness);
            FileUtils.write(new File("convergence/rand_2_bin/f6.txt"),str,"UTF-8",false);
        } catch (CloneNotSupportedException | IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void rand_1_exp(){
        String strategy = "rand-1-exp";
        Optimizer optimizer = (Optimizer) applicationContext.getBean(strategy);
        try {

            List<Double> sum = new ArrayList<>();
            for (int i = 0; i < 3000; i++) {
                sum.add(0.0);
            }
            for (int i = 0; i < 30; i++) {
                List<Individual> bestPerGeneration = optimizer.optimize(evaluator);
                List<Double> fitnessPerGeneration = bestPerGeneration.stream().map(Individual::getFitness).collect(Collectors.toList());
                for (int j = 0; j < sum.size(); j++) {
                    sum.set(j,sum.get(j)+fitnessPerGeneration.get(j));
                }
                System.out.println(fitnessPerGeneration);
            }
            for (int i = 0; i < 3000; i++) {
                sum.set(i,sum.get(i)/30.0);
            }
            System.out.println(sum);
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < sum.size(); i++) {
                str.append((i+1)+"\t"+sum.get(i)+"\n");
            }
            Double fitness = sum.stream().min(Double::compareTo).get();
            bestService.updateF6(strategy,fitness);
            FileUtils.write(new File("convergence/rand_1_exp/f6.txt"),str,"UTF-8",false);
        } catch (CloneNotSupportedException | IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void rand_2_exp(){
        String strategy = "rand-2-exp";
        Optimizer optimizer = (Optimizer) applicationContext.getBean(strategy);
        try {

            List<Double> sum = new ArrayList<>();
            for (int i = 0; i < 3000; i++) {
                sum.add(0.0);
            }
            for (int i = 0; i < 30; i++) {
                List<Individual> bestPerGeneration = optimizer.optimize(evaluator);
                List<Double> fitnessPerGeneration = bestPerGeneration.stream().map(Individual::getFitness).collect(Collectors.toList());
                for (int j = 0; j < sum.size(); j++) {
                    sum.set(j,sum.get(j)+fitnessPerGeneration.get(j));
                }
                System.out.println(fitnessPerGeneration);
            }
            for (int i = 0; i < 3000; i++) {
                sum.set(i,sum.get(i)/30.0);
            }
            System.out.println(sum);
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < sum.size(); i++) {
                str.append((i+1)+"\t"+sum.get(i)+"\n");
            }
            Double fitness = sum.stream().min(Double::compareTo).get();
            bestService.updateF6(strategy,fitness);
            FileUtils.write(new File("convergence/rand_2_exp/f6.txt"),str,"UTF-8",false);
        } catch (CloneNotSupportedException | IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void best_1_bin(){
        String strategy = "best-1-bin";
        Optimizer optimizer = (Optimizer) applicationContext.getBean(strategy);
        try {

            List<Double> sum = new ArrayList<>();
            for (int i = 0; i < 3000; i++) {
                sum.add(0.0);
            }
            for (int i = 0; i < 30; i++) {
                List<Individual> bestPerGeneration = optimizer.optimize(evaluator);
                List<Double> fitnessPerGeneration = bestPerGeneration.stream().map(Individual::getFitness).collect(Collectors.toList());
                for (int j = 0; j < sum.size(); j++) {
                    sum.set(j,sum.get(j)+fitnessPerGeneration.get(j));
                }
                System.out.println(fitnessPerGeneration);
            }
            for (int i = 0; i < 3000; i++) {
                sum.set(i,sum.get(i)/30.0);
            }
            System.out.println(sum);
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < sum.size(); i++) {
                str.append((i+1)+"\t"+sum.get(i)+"\n");
            }
            Double fitness = sum.stream().min(Double::compareTo).get();
            bestService.updateF6(strategy,fitness);
            FileUtils.write(new File("convergence/best_1_bin/f6.txt"),str,"UTF-8",false);
        } catch (CloneNotSupportedException | IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void best_2_bin(){
        String strategy = "best-2-bin";
        Optimizer optimizer = (Optimizer) applicationContext.getBean(strategy);
        try {

            List<Double> sum = new ArrayList<>();
            for (int i = 0; i < 3000; i++) {
                sum.add(0.0);
            }
            for (int i = 0; i < 30; i++) {
                List<Individual> bestPerGeneration = optimizer.optimize(evaluator);
                List<Double> fitnessPerGeneration = bestPerGeneration.stream().map(Individual::getFitness).collect(Collectors.toList());
                for (int j = 0; j < sum.size(); j++) {
                    sum.set(j,sum.get(j)+fitnessPerGeneration.get(j));
                }
                System.out.println(fitnessPerGeneration);
            }
            for (int i = 0; i < 3000; i++) {
                sum.set(i,sum.get(i)/30.0);
            }
            System.out.println(sum);
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < sum.size(); i++) {
                str.append((i+1)+"\t"+sum.get(i)+"\n");
            }
            Double fitness = sum.stream().min(Double::compareTo).get();
            bestService.updateF6(strategy,fitness);
            FileUtils.write(new File("convergence/best_2_bin/f6.txt"),str,"UTF-8",false);
        } catch (CloneNotSupportedException | IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void best_1_exp(){
        String strategy = "best-1-exp";
        Optimizer optimizer = (Optimizer) applicationContext.getBean(strategy);
        try {

            List<Double> sum = new ArrayList<>();
            for (int i = 0; i < 3000; i++) {
                sum.add(0.0);
            }
            for (int i = 0; i < 30; i++) {
                List<Individual> bestPerGeneration = optimizer.optimize(evaluator);
                List<Double> fitnessPerGeneration = bestPerGeneration.stream().map(Individual::getFitness).collect(Collectors.toList());
                for (int j = 0; j < sum.size(); j++) {
                    sum.set(j,sum.get(j)+fitnessPerGeneration.get(j));
                }
                System.out.println(fitnessPerGeneration);
            }
            for (int i = 0; i < 3000; i++) {
                sum.set(i,sum.get(i)/30.0);
            }
            System.out.println(sum);
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < sum.size(); i++) {
                str.append((i+1)+"\t"+sum.get(i)+"\n");
            }
            Double fitness = sum.stream().min(Double::compareTo).get();
            bestService.updateF6(strategy,fitness);
            FileUtils.write(new File("convergence/best_1_exp/f6.txt"),str,"UTF-8",false);
        } catch (CloneNotSupportedException | IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void best_2_exp(){
        String strategy = "best-2-exp";
        Optimizer optimizer = (Optimizer) applicationContext.getBean(strategy);
        try {

            List<Double> sum = new ArrayList<>();
            for (int i = 0; i < 3000; i++) {
                sum.add(0.0);
            }
            for (int i = 0; i < 30; i++) {
                List<Individual> bestPerGeneration = optimizer.optimize(evaluator);
                List<Double> fitnessPerGeneration = bestPerGeneration.stream().map(Individual::getFitness).collect(Collectors.toList());
                for (int j = 0; j < sum.size(); j++) {
                    sum.set(j,sum.get(j)+fitnessPerGeneration.get(j));
                }
                System.out.println(fitnessPerGeneration);
            }
            for (int i = 0; i < 3000; i++) {
                sum.set(i,sum.get(i)/30.0);
            }
            System.out.println(sum);
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < sum.size(); i++) {
                str.append((i+1)+"\t"+sum.get(i)+"\n");
            }
            Double fitness = sum.stream().min(Double::compareTo).get();
            bestService.updateF6(strategy,fitness);
            FileUtils.write(new File("convergence/best_2_exp/f6.txt"),str,"UTF-8",false);
        } catch (CloneNotSupportedException | IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void randToBest_1_bin(){
        String strategy = "randToBest-1-bin";
        Optimizer optimizer = (Optimizer) applicationContext.getBean(strategy);
        try {

            List<Double> sum = new ArrayList<>();
            for (int i = 0; i < 3000; i++) {
                sum.add(0.0);
            }
            for (int i = 0; i < 30; i++) {
                List<Individual> bestPerGeneration = optimizer.optimize(evaluator);
                List<Double> fitnessPerGeneration = bestPerGeneration.stream().map(Individual::getFitness).collect(Collectors.toList());
                for (int j = 0; j < sum.size(); j++) {
                    sum.set(j,sum.get(j)+fitnessPerGeneration.get(j));
                }
                System.out.println(fitnessPerGeneration);
            }
            for (int i = 0; i < 3000; i++) {
                sum.set(i,sum.get(i)/30.0);
            }
            System.out.println(sum);
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < sum.size(); i++) {
                str.append((i+1)+"\t"+sum.get(i)+"\n");
            }
            Double fitness = sum.stream().min(Double::compareTo).get();
            bestService.updateF6(strategy,fitness);
            FileUtils.write(new File("convergence/randToBest_1_bin/f6.txt"),str,"UTF-8",false);
        } catch (CloneNotSupportedException | IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void randToBest_1_exp(){
        String strategy = "randToBest-1-exp";
        Optimizer optimizer = (Optimizer) applicationContext.getBean(strategy);
        try {

            List<Double> sum = new ArrayList<>();
            for (int i = 0; i < 3000; i++) {
                sum.add(0.0);
            }
            for (int i = 0; i < 30; i++) {
                List<Individual> bestPerGeneration = optimizer.optimize(evaluator);
                List<Double> fitnessPerGeneration = bestPerGeneration.stream().map(Individual::getFitness).collect(Collectors.toList());
                for (int j = 0; j < sum.size(); j++) {
                    sum.set(j,sum.get(j)+fitnessPerGeneration.get(j));
                }
                System.out.println(fitnessPerGeneration);
            }
            for (int i = 0; i < 3000; i++) {
                sum.set(i,sum.get(i)/30.0);
            }
            System.out.println(sum);
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < sum.size(); i++) {
                str.append((i+1)+"\t"+sum.get(i)+"\n");
            }
            Double fitness = sum.stream().min(Double::compareTo).get();
            bestService.updateF6(strategy,fitness);
            FileUtils.write(new File("convergence/randToBest_1_exp/f6.txt"),str,"UTF-8",false);
        } catch (CloneNotSupportedException | IOException e) {
            e.printStackTrace();
        }
    }
}
