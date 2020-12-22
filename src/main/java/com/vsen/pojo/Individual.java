package com.vsen.pojo;

import java.util.List;

/**
 * Created by wansenxu@163.com on 2020/12/10
 */
public class Individual implements Cloneable,Comparable<Individual> {
    List<Double> solution;
    double fitness;


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Individual{" +
                "solution=" + solution +
                ", fitness=" + fitness +
                '}';
    }


    public List<Double> getSolution() {
        return solution;
    }

    public void setSolution(List<Double> solution) {
        this.solution = solution;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }


    @Override
    public int compareTo(Individual o) {
        if(this.getFitness()==o.getFitness()){
            return 0;
        }else if(this.getFitness()>o.getFitness()){
            return 1;
        }else{
            return -1;
        }
    }
}

