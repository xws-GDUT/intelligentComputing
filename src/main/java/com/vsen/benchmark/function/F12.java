package com.vsen.benchmark.function;

import com.vsen.benchmark.Bound;
import com.vsen.benchmark.Evaluator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wansenxu@163.com on 2020/12/11
 */
@Component("f12")
public class F12 implements Evaluator {
    @Resource(name = "f12_bound")
    private Bound bound;
    @Override
    public Double evaluate(List<Double> solution) {
        double sum=0;
        double tmp1=0;
        for (int i=0;i<solution.size();i++){
            tmp1+=U(solution.get(i),10,100,4);
        }
        double tmp2=0;
        for(int i=0;i<solution.size()-1;i++) {
            tmp2+=Math.pow(Y(solution.get(i))-1,2)*(1+10*Math.pow((Math.sin(Math.PI*Y(solution.get(i+1)))),2));
        }
        return sum=Math.PI/solution.size()*(10*Math.pow(Math.sin(Math.PI*Y(solution.get(0))),2)+tmp2+Math.pow(Y(solution.get(solution.size()-1))-1,2))+tmp1;
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
    private double Y(double x){
        return 1+1/4.0*(x+1);
    }

    @Override
    public Bound getBound() {
        return bound;
    }

    public void setBound(Bound bound) {
        this.bound = bound;
    }
}
