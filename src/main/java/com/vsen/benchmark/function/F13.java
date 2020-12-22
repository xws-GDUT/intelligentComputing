package com.vsen.benchmark.function;

import com.vsen.benchmark.Bound;
import com.vsen.benchmark.Evaluator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wansenxu@163.com on 2020/12/11
 */
@Component("f13")
public class F13 implements Evaluator {
    @Resource(name = "f13_bound")
    private Bound bound;
    @Override
    public Double evaluate(List<Double> solution) {
        double sum=0;
        double tmp1=0;
        for(int i=0;i<solution.size()-1;i++) {
            tmp1+= Math.pow((solution.get(i)-1),2)*(1+Math.pow(Math.sin(3*Math.PI*solution.get(i+1)),2));
        }
        double tmp2=0;
        for(int i=0;i<solution.size();i++) {
            tmp2+=U(solution.get(i),5,100,4);
        }
        return sum = (0.1)*(Math.pow(Math.sin(Math.PI*3*solution.get(0)),2)+tmp1+Math.pow(solution.get(solution.size()-1),2)*(1+Math.pow(Math.sin(2*Math.PI*solution.get(solution.size()-1)),2)))+tmp2;
    }
    private double U(double x,double a,double k,double m){
        if(x>a){
            return k*Math.pow((x-a),m);
        }else if(x>=-a&&x<=a){
            return 0;
        }else{
            return k*Math.pow((-x-a),m);
        }
    }

    @Override
    public Bound getBound() {
        return bound;
    }

    public void setBound(Bound bound) {
        this.bound = bound;
    }
}
