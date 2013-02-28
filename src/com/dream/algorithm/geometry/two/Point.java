package com.dream.algorithm.geometry.two;

/**
 * 
 * 点类
 * 
 * @author liushaohui
 * 
 */
public class Point {
	private double x;
	private double y;

	Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	/**
	 * 加法
	 * 
	 * @param Point
	 * @return
	 */
	Point add(Point that) {
		return new Point(x + that.x, y + that.y);
	}

	/**
	 * 减法
	 * 
	 * @param Point
	 * @return
	 */
	Point sub(Point that) {
		return new Point(x - that.x, y - that.y);
	}

	/**
	 * 扩大
	 * 
	 * @param d
	 * @return
	 */
	Point mul(double d) {
		return new Point(x * d, y * d);
	}

	/**
	 * 缩小
	 * 
	 * @param d
	 * @return
	 */
	Point div(double d) {
		return new Point(x / d, y / d);
	}

	/**
	 * 点乘
	 * 
	 * @param Point2D
	 * @return
	 */
	double dot(Point Point2D) {
		return x * Point2D.x + y * Point2D.y;
	}

	/**
	 * 除法
	 * 
	 * @param Point
	 * @return
	 */
	public double det(Point that) {
		return x * that.y - y * that.x;
	}

	public double abs() {
		return Math.hypot(x, y);
	}

	public double abs2() {
		return x * x + y * y;
	}

	/**
	 * 另一个点的距离
	 * 
	 * @param that
	 * @return
	 */
	public double distance(Point that) {
		return Math.hypot(this.x - that.x, this.y - that.y);
	}

	/**
	 * 旋转90度
	 * 
	 * @return
	 */
	Point rot90() {
		return new Point(-y, x);
	}

	public String toString() {
		return String.format("(%.2f, %.2f)", x, y);
	}
}