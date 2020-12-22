package com.vsen.benchmark.function;

import com.vsen.benchmark.Bound;
import com.vsen.benchmark.Evaluator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wansenxu@163.com on 2020/12/11
 */
@Component("f9")
public class F9 implements Evaluator {
    @Resource(name = "f9_bound")
    private Bound bound;
    @Override
    public Double evaluate(List<Double> solution) {
        double sum=0;
        for (int i=0;i<solution.size();i++){
            sum+=(Math.pow(solution.get(i),2)-10*Math.cos(2*Math.PI*solution.get(i))+10);
        }
        return sum;
    }

    @Override
    public Bound getBound() {
        return bound;
    }

    public void setBound(Bound bound) {
        this.bound = bound;
    }
}
