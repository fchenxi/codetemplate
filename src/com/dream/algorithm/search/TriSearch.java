package com.dream.algorithm.search;

import com.dream.algorithm.math.MathEx;

/**
 * 三分法求解单峰(单谷)的极
 * 
 * @author liushaohui
 * 
 */
public abstract class TriSearch {
	/**
	 * 峰值函数
	 * 
	 * @param x
	 * @return
	 */
	public abstract double function(double x);

	/**
	 * 求单峰区间的峰值
	 * 
	 * @param begin
	 *            左端点
	 * @param end
	 *            右端点
	 * @return
	 */
	public double getMax(double begin, double end) {
		double left, right;
		while (MathEx.isZero(begin - end, 1e-8)) {
			left = begin + (end - begin) / 3.0;
			right = end - (end - begin) / 3.0;
			if (function(left) < function(right)) {
				begin = left;
			} else {
				end = right;
			}
		}
		return begin;
	}
}
