package com.vsen.benchmark.function;

import com.vsen.benchmark.Bound;
import com.vsen.benchmark.Evaluator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wansenxu@163.com on 2020/12/10
 */
@Component("f1")
public class F1 implements Evaluator {
    @Resource(name = "f1_bound")
    private Bound bound;
    @Override
    public Double evaluate(List<Double> solution) {
        Double fitness = solution.stream()
                .reduce(0.0, (acc, e) ->acc + Math.pow(e,2));
        return fitness;
    }

    public Bound getBound() {
        return bound;
    }

    public void setBound(Bound bound) {
        this.bound = bound;
    }
}
