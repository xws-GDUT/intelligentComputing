package com.vsen.benchmark;

/**
 * Created by wansenxu@163.com on 2020/12/10
 */
public class Bound {
    private double lowerBound;
    private double upperBound;

    public Bound() {
    }

    public Bound(double lowerBound, double upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public double getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(double lowerBound) {
        this.lowerBound = lowerBound;
    }

    public double getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(double upperBound) {
        this.upperBound = upperBound;
    }
}
