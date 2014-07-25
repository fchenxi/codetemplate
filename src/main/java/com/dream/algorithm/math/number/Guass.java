package com.dream.algorithm.math.number;

/**
 * 
 * 高斯消元算法<br>
 * 需要改进处理那些没有解，或者无穷解的情况
 * 
 * @author liushaohui
 * @version 1.0.0 since Aug 30, 2009
 */
public class Guass {
	public static Guass instance = new Guass();

	public static Guass getInstance() {
		return instance;
	}

	public double[] guass(double[][] a, double[] b) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int k = i;
			for (int j = i + 1; j < n; j++) {
				if (Math.abs(a[j][i]) > Math.abs(a[k][i])) {
					k = j;
				}
			}
			double[] tmp = a[i];
			a[i] = a[k];
			a[k] = tmp;
			double t = b[i];
			b[i] = b[k];
			b[k] = t;
			for (int j = i + 1; j < n; j++) {
				if (a[j][i] != 0) {
					double d = a[j][i] / a[i][i];
					for (int p = i; p < n; p++) {
						a[j][p] -= d * a[i][p];
					}
					b[j] -= d * b[i];
				}
			}
		}
		double[] x = new double[n];
		for (int k = n - 1; k >= 0; k--) {
			x[k] = b[k];
			for (int i = k + 1; i < n; i++) {
				x[k] -= x[i] * a[k][i];
			}
			x[k] /= a[k][k];
		}
		return x;
	}
}