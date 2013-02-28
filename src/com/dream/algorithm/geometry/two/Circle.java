
package com.dream.algorithm.geometry.two;

public class Circle implements Comparable<Circle> {
    private Point center;
    private double r;

    public Circle(Point center, double r) {
        this.center = center;
        this.r = Math.abs(r);
    }

    public Point getCenter() {
        return center;
    }

    public double getR() {
        return r;
    }

    public Circle(double x, double y, double r) {
        this.center = new Point(x, y);
        this.r = Math.abs(r);
    }

    @Override
    public int compareTo(Circle that) {
        if (this.r < this.r) {
            return -1;
        } else {
            return 1;
        }
    }

    public double distance(Point point) {
        return 0.0;
    }

    public boolean inClircle(Point point) {
        return false;
    }

    /**
     * 获取圆的面积
     * 
     * @return
     */
    public double getArea() {
        return Math.PI * r * r;
    }

    /**
     * 是否包含另一个圆
     * 
     * @param that
     * @return
     */
    public boolean contains(Circle that) {
        double dist = this.center.distance(that.center);
        if (dist <= Math.abs(this.r - that.r)) {
            return true;
        }
        return false;
    }

    public double commonArea(Circle that) {
        return 0.0;
    }
}
