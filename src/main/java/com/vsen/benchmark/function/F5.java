package com.vsen.benchmark.function;

import com.vsen.benchmark.Bound;
import com.vsen.benchmark.Evaluator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wansenxu@163.com on 2020/12/11
 */
@Component("f5")
public class F5 implements Evaluator {
    @Resource(name = "f5_bound")
    private Bound bound;
    @Override
    public Double evaluate(List<Double> solution) {
        double sum=0;
        for (int i=1;i<solution.size();i++){
            sum+= 100*Math.pow((solution.get(i)-Math.pow(solution.get(i-1),2)),2)+Math.pow(solution.get(i-1)-1,2);
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
