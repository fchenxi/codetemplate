package com.dream.algorithm.geometry.three;

/**
 * 球类
 * 
 * @author Administrator
 * 
 */
public class Ball {
	// 球的中心
	private Point3D center;
	// 球的半徑
	private double r;

	public Ball(Point3D center, double r) {
		super();
		this.center = center;
		this.r = r;
	}

	public Point3D getCenter() {
		return center;
	}

	public void setCenter(Point3D center) {
		this.center = center;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}
}
