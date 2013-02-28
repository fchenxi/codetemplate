package com.dream.algorithm.math;

/**
 * 复数类
 * 
 * @author liushaohui
 * 
 */
public final class Complex {
	/** 复数的实部 */
	private double re;
	/** 复数的虚部 */
	private double im;

	/**
	 * 构造一个复数
	 * 
	 * @param re
	 * @param im
	 */
	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}

	/**
	 * 构造一个复数
	 * 
	 * @param re
	 * @param im
	 * @return
	 */
	public static Complex valueOf(double re, double im) {
		return new Complex(re, im);
	}

	/**
	 * 共轭复数
	 * 
	 * @return
	 */
	public Complex conjugate() {
		return new Complex(re, -im);
	}

	/**
	 * 加法
	 * 
	 * @param that
	 * @return
	 */
	public Complex add(Complex that) {
		return new Complex(re + that.re, im + that.im);
	}

	/**
	 * 减法
	 * 
	 * @param that
	 * @return
	 */
	public Complex sub(Complex that) {
		return new Complex(re - that.re, im - that.im);
	}

	/**
	 * 乘以一个实数
	 * 
	 * @param d
	 * @return
	 */
	public Complex mul(double d) {
		return new Complex(re * d, im * d);
	}

	/**
	 * 乘以复数
	 * 
	 * @param that
	 * @return
	 */
	public Complex mul(Complex that) {
		return new Complex(re * that.re - im * that.im, re * that.im + im
				* that.re);
	}

	/**
	 * 除以一个实数
	 * 
	 * @param d
	 * @return
	 */
	public Complex div(double d) {
		return new Complex(re / d, im / d);
	}

	/**
	 * 除以一个复数
	 * 
	 * @param that
	 * @return
	 */
	public Complex div(Complex that) {
		return mul(that.conjugate()).div(that.abs2());
	}

	/**
	 * 模平方
	 * 
	 * @return
	 */
	public double abs2() {
		return re * re + im * im;
	}

	/**
	 * 复数的模
	 * 
	 * @return
	 */
	public double abs() {
		return Math.sqrt(abs2());
	}

	/**
	 * 设置虚步
	 * 
	 * @param im
	 */
	public void setImag(double im) {
		this.im = im;
	}

	/**
	 * 获取虚步
	 * 
	 * @return
	 */
	public double getImag() {
		return im;
	}

	/**
	 * 设置实步
	 * 
	 * @param re
	 */
	public void setReal(double re) {
		this.re = re;
	}

	/**
	 * 获取实步
	 * 
	 * @return
	 */
	public double getReal() {
		return re;
	}

	@Override
	public String toString() {
		return String.format("(%1$f,%2$f)", re, im);
	}
}
