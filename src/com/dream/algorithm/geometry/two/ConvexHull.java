package com.dream.algorithm.geometry.two;

import java.util.ArrayList;
import java.util.List;

/**
 * 二维凸包
 * 
 * @author Administrator
 * 
 */
public class ConvexHull {
	// 点的个数
	private int n;
	// 平面上的所有点
	private List<Point> points;

	public ConvexHull(List<Point> points) {
		this.n = points.size();
		this.points = points;
	}

	public List<Point> getConvex() {
		List<Point> convexPoints = new ArrayList<Point>();
		return convexPoints;
	}
}
