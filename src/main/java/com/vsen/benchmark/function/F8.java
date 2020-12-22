package com.vsen.benchmark.function;

import com.vsen.benchmark.Bound;
import com.vsen.benchmark.Evaluator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wansenxu@163.com on 2020/12/11
 */
@Component("f8")
public class F8 implements Evaluator {
    @Resource(name = "f8_bound")
    private Bound bound;
    @Override
    public Double evaluate(List<Double> solution) {
        double sum=0;
        for (int i=0;i<solution.size();i++){
            sum-= (solution.get(i))*Math.sin(Math.sqrt(Math.abs(solution.get(i))));
        }
        return Math.abs(Math.abs(sum)-Math.abs(12569.5));
//        return sum;
    }

    @Override
    public Bound getBound() {
        return bound;
    }

    public void setBound(Bound bound) {
        this.bound = bound;
    }
}
