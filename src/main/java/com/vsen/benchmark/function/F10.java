package com.vsen.benchmark.function;

import com.vsen.benchmark.Bound;
import com.vsen.benchmark.Evaluator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wansenxu@163.com on 2020/12/11
 */
@Component("f10")
public class F10 implements Evaluator {
    @Resource(name = "f10_bound")
    private Bound bound;
    @Override
    public Double evaluate(List<Double> solution) {
        double sum;
        double tmp1=0;
        double tmp2=0;
        for (int i = 0; i < solution.size(); i++){
            tmp1 += Math.pow(solution.get(i),2);
            tmp2 += Math.cos(2*Math.PI*solution.get(i));
        }
        sum= -20*Math.exp(-0.2*Math.sqrt(tmp1/solution.size()))-Math.exp(tmp2/solution.size())+20+Math.exp(1);
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
