package success_rate;

import com.vsen.algorithm.Optimizer;
import com.vsen.benchmark.Evaluator;
import com.vsen.pojo.Individual;
import com.vsen.service.SuccessRateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wansenxu@163.com on 2020/12/11
 */
public class TestStrategyForF1 {
    ApplicationContext applicationContext;
    Evaluator evaluator;
    SuccessRateService successRateService;
    String targetFunction;

    @BeforeEach
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        evaluator = (Evaluator) applicationContext.getBean("f1");
        successRateService = (SuccessRateService) applicationContext.getBean("successRateImpl");
        targetFunction="F1";
    }

    @Test
    public void rand_1_bin() {
        int successCount = 0;
        String strategy = "rand-1-bin";
        Optimizer optimizer = (Optimizer) applicationContext.getBean(strategy);
        try {
            for (int i = 0; i < 100; i++) {
                List<Individual> bestPerGeneration = optimizer.optimize(evaluator);
                List<Double> fitnessPerGeneration = bestPerGeneration.stream().map(Individual::getFitness).collect(Collectors.toList());
                Double fitness = fitnessPerGeneration.stream().min(Double::compareTo).get();
                if (fitness <= 0.01) {
                    successCount++;
                }
                System.out.println(strategy+"优化"+targetFunction+"执行第" + (i + 1) + "次");
            }
            successRateService.updateF1(strategy,successCount);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void rand_1_exp() {
        int successCount = 0;
        String strategy = "rand-1-exp";
        Optimizer optimizer = (Optimizer) applicationContext.getBean(strategy);
        try {
            for (int i = 0; i < 100; i++) {
                List<Individual> bestPerGeneration = optimizer.optimize(evaluator);
                List<Double> fitnessPerGeneration = bestPerGeneration.stream().map(Individual::getFitness).collect(Collectors.toList());
                Double fitness = fitnessPerGeneration.stream().min(Double::compareTo).get();
                if (fitness <= 0.01) {
                    successCount++;
                }
                System.out.println(strategy+"优化"+targetFunction+"执行第" + (i + 1) + "次");
            }
            successRateService.updateF1(strategy,successCount);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void best_1_bin() {
        int successCount = 0;
        String strategy = "best-1-bin";
        Optimizer optimizer = (Optimizer) applicationContext.getBean(strategy);
        try {
            for (int i = 0; i < 100; i++) {
                List<Individual> bestPerGeneration = optimizer.optimize(evaluator);
                List<Double> fitnessPerGeneration = bestPerGeneration.stream().map(Individual::getFitness).collect(Collectors.toList());
                Double fitness = fitnessPerGeneration.stream().min(Double::compareTo).get();
                if (fitness <= 0.01) {
                    successCount++;
                }
                System.out.println(strategy+"优化"+targetFunction+"执行第" + (i + 1) + "次");
            }
            successRateService.updateF1(strategy,successCount);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void best_1_exp() {
        int successCount = 0;
        String strategy = "best-1-exp";
        Optimizer optimizer = (Optimizer) applicationContext.getBean(strategy);
        try {
            for (int i = 0; i < 100; i++) {
                List<Individual> bestPerGeneration = optimizer.optimize(evaluator);
                List<Double> fitnessPerGeneration = bestPerGeneration.stream().map(Individual::getFitness).collect(Collectors.toList());
                Double fitness = fitnessPerGeneration.stream().min(Double::compareTo).get();
                if (fitness <= 0.01) {
                    successCount++;
                }
                System.out.println(strategy+"优化"+targetFunction+"执行第" + (i + 1) + "次");
            }
            successRateService.updateF1(strategy,successCount);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void rand_2_bin() {
        int successCount = 0;
        String strategy = "rand-2-bin";
        Optimizer optimizer = (Optimizer) applicationContext.getBean(strategy);
        try {
            for (int i = 0; i < 100; i++) {
                List<Individual> bestPerGeneration = optimizer.optimize(evaluator);
                List<Double> fitnessPerGeneration = bestPerGeneration.stream().map(Individual::getFitness).collect(Collectors.toList());
                Double fitness = fitnessPerGeneration.stream().min(Double::compareTo).get();
                if (fitness <= 0.01) {
                    successCount++;
                }
                System.out.println(strategy+"优化"+targetFunction+"执行第" + (i + 1) + "次");
            }
            successRateService.updateF1(strategy,successCount);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void rand_2_exp() {
        int successCount = 0;
        String strategy = "rand-2-exp";
        Optimizer optimizer = (Optimizer) applicationContext.getBean(strategy);
        try {
            for (int i = 0; i < 100; i++) {
                List<Individual> bestPerGeneration = optimizer.optimize(evaluator);
                List<Double> fitnessPerGeneration = bestPerGeneration.stream().map(Individual::getFitness).collect(Collectors.toList());
                Double fitness = fitnessPerGeneration.stream().min(Double::compareTo).get();
                if (fitness <= 0.01) {
                    successCount++;
                }
                System.out.println(strategy+"优化"+targetFunction+"执行第" + (i + 1) + "次");
            }
            successRateService.updateF1(strategy,successCount);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void best_2_bin() {
        int successCount = 0;
        String strategy = "best-2-bin";
        Optimizer optimizer = (Optimizer) applicationContext.getBean(strategy);
        try {
            for (int i = 0; i < 100; i++) {
                List<Individual> bestPerGeneration = optimizer.optimize(evaluator);
                List<Double> fitnessPerGeneration = bestPerGeneration.stream().map(Individual::getFitness).collect(Collectors.toList());
                Double fitness = fitnessPerGeneration.stream().min(Double::compareTo).get();
                if (fitness <= 0.01) {
                    successCount++;
                }
                System.out.println(strategy+"优化"+targetFunction+"执行第" + (i + 1) + "次");
            }
            successRateService.updateF1(strategy,successCount);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void best_2_exp() {
        int successCount = 0;
        String strategy = "best-2-exp";
        Optimizer optimizer = (Optimizer) applicationContext.getBean(strategy);
        try {
            for (int i = 0; i < 100; i++) {
                List<Individual> bestPerGeneration = optimizer.optimize(evaluator);
                List<Double> fitnessPerGeneration = bestPerGeneration.stream().map(Individual::getFitness).collect(Collectors.toList());
                Double fitness = fitnessPerGeneration.stream().min(Double::compareTo).get();
                if (fitness <= 0.01) {
                    successCount++;
                }
                System.out.println(strategy+"优化"+targetFunction+"执行第" + (i + 1) + "次");
            }
            successRateService.updateF1(strategy,successCount);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void randToBest_1_bin() {
        int successCount = 0;
        String strategy = "randToBest-1-bin";
        Optimizer optimizer = (Optimizer) applicationContext.getBean(strategy);
        try {
            for (int i = 0; i < 100; i++) {
                List<Individual> bestPerGeneration = optimizer.optimize(evaluator);
                List<Double> fitnessPerGeneration = bestPerGeneration.stream().map(Individual::getFitness).collect(Collectors.toList());
                Double fitness = fitnessPerGeneration.stream().min(Double::compareTo).get();
                if (fitness <= 0.01) {
                    successCount++;
                }
                System.out.println(strategy+"优化"+targetFunction+"执行第" + (i + 1) + "次");
            }
            successRateService.updateF1(strategy,successCount);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void randToBest_1_exp() {
        int successCount = 0;
        String strategy = "randToBest-1-exp";
        Optimizer optimizer = (Optimizer) applicationContext.getBean(strategy);
        try {
            for (int i = 0; i < 100; i++) {
                List<Individual> bestPerGeneration = optimizer.optimize(evaluator);
                List<Double> fitnessPerGeneration = bestPerGeneration.stream().map(Individual::getFitness).collect(Collectors.toList());
                Double fitness = fitnessPerGeneration.stream().min(Double::compareTo).get();
                if (fitness <= 0.01) {
                    successCount++;
                }
                System.out.println(strategy+"优化"+targetFunction+"执行第" + (i + 1) + "次");
            }
            successRateService.updateF1(strategy,successCount);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}