package com.dream.algorithm.geometry.three;

/**
 * 三维上的点
 * 
 * @author liushaohui
 * 
 */
public class Point3D {
	public double x;
	public double y;
	public double z;

	public Point3D(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * 加法
	 * 
	 * @param Point3D
	 * @return
	 */
	Point3D add(Point3D that) {
		return new Point3D(x + that.x, y + that.y, z + that.z);
	}

	/**
	 * 减法
	 * 
	 * @param Point3D
	 * @return
	 */
	Point3D sub(Point3D that) {
		return new Point3D(x - that.x, y - that.y, z - that.z);
	}

	/**
	 * 扩大
	 * 
	 * @param d
	 * @return Point3D
	 */
	Point3D mul(double d) {
		return new Point3D(x * d, y * d, z * d);
	}

	/**
	 * 缩小
	 * 
	 * @param d
	 * @return Point3D
	 */
	Point3D div(double d) {
		return new Point3D(x / d, y / d, z / d);
	}

	double abs() {
		return Math.sqrt(abs2());
	}

	double abs2() {
		return x * x + y * y + z * z;
	}

	public String toString() {
		return String.format("(%.2f, %.2f,%.2f)", x, y, z);
	}
}
