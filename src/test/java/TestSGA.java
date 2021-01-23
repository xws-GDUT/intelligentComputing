import com.vsen.benchmark.Bound;
import com.vsen.algorithm.optimizerImpl.geneticAlgorithm.SGA;
import com.vsen.benchmark.Evaluator;
import com.vsen.benchmark.function.F1;
import com.vsen.pojo.Individual;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestSGA {
    @Test
    public void testInit(){
        SGA sga = new SGA();
        Bound bound = new Bound(5, -5);
        List<Individual> individuals = sga.initPop(5, bound);
        individuals.stream().forEach(System.out::println);
    }
    @Test
    public void testSelect(){
        SGA sga = new SGA();
        Bound bound = new Bound(5, -5);
        List<Individual> individuals = sga.initPop(5, bound);
        for (Individual individual : individuals) {
            individual.setFitness(new F1().evaluate(individual.getSolution()));
        }
        individuals.stream().forEach(System.out::println);
        individuals = sga.select(individuals);
        System.out.println("----------选择后--------------");
        individuals.stream().forEach(System.out::println);

    }
    @Test
    public void test(){
        String str="QJPRJGoo4BImVTzkrXhkjN1/s/moc.udiab.nap";
        char[] chars = str.toCharArray();
        for (int i = chars.length-1; i >= 0; i--) {
            System.out.print(chars[i]);
        }
    }




}
