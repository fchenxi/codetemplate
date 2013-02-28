package com.dream.algorithm.math.sequence;

import com.dream.algorithm.math.number.Matrix;

/**
 * fibonacci number<br>
 * 斐波那契数
 * 
 * @author liushaohui
 * @version 1.0.0 since Aug 27 ,2009
 */
public class Fibonacci {
	private Matrix mat = new Matrix(new int[][] { { 1, 1 }, { 0, 1 } });

	/**
	 * 前n个Fibonacci
	 * 
	 * @param n
	 * @return
	 */
	public int[] nFibs(int n) {
		int[] ret = new int[n];
		ret[0] = 0;
		ret[1] = 1;
		for (int i = 2; i < n; i++) {
			ret[i] = ret[i - 1] + ret[i - 2];
		}
		return ret;
	}

	/**
	 * 前n个Fibonacci
	 * 
	 * @param n
	 * @return
	 */
	public int[] nFibs(int n, int mod) {
		int[] ret = new int[n];
		ret[0] = 0 % mod;
		ret[1] = 1 % mod;
		for (int i = 2; i < n; i++) {
			ret[i] = (ret[i - 1] + ret[i - 2]) % mod;
		}
		return ret;
	}

	/**
	 * 第n个Fibonacci
	 * 
	 * @param n
	 * @return
	 */
	public int nthFib(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return mat.pow(n - 1).get(0, 1);
		}
	}

	/**
	 * 第n个Fibonacci
	 * 
	 * @param n
	 * @return
	 */
	public int nthFib(int n, int mod) {
		if (n == 0) {
			return 0 % mod;
		} else if (n == 1) {
			return 1 % mod;
		} else {
			return mat.pow(n - 1, mod).get(0, 1);
		}
	}

}
