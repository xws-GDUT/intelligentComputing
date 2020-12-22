package com.vsen.benchmark.function;

import com.vsen.benchmark.Bound;
import com.vsen.benchmark.Evaluator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wansenxu@163.com on 2020/12/11
 */
@Component("f4")
public class F4 implements Evaluator {
    @Resource(name = "f4_bound")
    private Bound bound;
    @Override
    public Double evaluate(List<Double> solution) {
        double max;
        max=Math.abs(solution.get(0));
        for (int i = 1; i < solution.size(); i++){
            if(max<Math.abs(solution.get(i))){
                max=Math.abs(solution.get(i));
            }
        }
        return max;
    }

    @Override
    public Bound getBound() {
        return bound;
    }

    public void setBound(Bound bound) {
        this.bound = bound;
    }
}
