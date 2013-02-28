package com.dream.algorithm.math.number;

/**
 * 基本矩阵运算
 * 
 * @author liushaohui
 * @version 1.0.0 since Aug 27 ,2009
 */
public final class Matrix {

	private int[][] mat;

	public Matrix(int n) {
		this.mat = new int[n][n];
	}

	public Matrix(int r, int c) {
		this.mat = new int[r][c];
	}

	public Matrix(int[][] mat) {
		this.mat = mat;
	}

	public int rowNum() {
		return mat.length;
	}

	public int colNum() {
		return mat[0].length;
	}

	public void set(int i, int j, int v) {
		mat[i][j] = v;
	}

	public int get(int i, int j) {
		return mat[i][j];
	}

	/**
	 * 矩阵乘法
	 * 
	 * @param that
	 * @return
	 */
	public Matrix mul(Matrix that) {
		Matrix ret = new Matrix(this.rowNum(), that.colNum());
		for (int i = 0; i < this.rowNum(); i++) {
			for (int j = 0; j < that.colNum(); j++) {
				int t = 0;
				for (int k = 0; k < this.colNum(); k++) {
					t += mat[i][k] * that.get(k, j);
				}
				ret.set(i, j, t);
			}
		}
		return ret;
	}

	/**
	 * 带模矩阵乘法
	 * 
	 * @param that
	 * @param mod
	 * @return
	 */
	public Matrix mul(Matrix that, int mod) {
		Matrix ret = new Matrix(this.rowNum(), that.colNum());

		for (int i = 0; i < this.rowNum(); i++) {
			for (int j = 0; j < that.colNum(); j++) {
				int t = 0;
				for (int k = 0; k < this.colNum(); k++) {
					t = (t + mat[i][k] % mod * that.get(k, j) % mod) % mod;
				}
				ret.set(i, j, t);
			}
		}
		return ret;
	}

	/**
	 * 矩阵阶乘
	 * 
	 * @param k
	 * @return
	 */
	public Matrix pow(int k) {
		if (k == 1) {
			return this;
		} else if (k % 2 == 0) {
			Matrix ret = this.pow(k / 2);
			return ret.mul(ret);
		} else {
			Matrix ret = this.pow(k / 2);
			return this.mul(ret).mul(ret);
		}
	}

	/**
	 * 带模矩阵阶乘
	 * 
	 * @param k
	 * @return
	 */
	public Matrix pow(int k, int mod) {
		if (colNum() != rowNum()) {
			System.err.println("wrong! row!=col,can not pow!");
			return new Matrix(rowNum(), colNum());
		}
		if (k == 0) {
			return Matrix.One(colNum());
		} else if (k == 1) { // 注意k=1的时候取模
			Matrix ret = new Matrix(rowNum(), colNum());
			for (int i = 0; i < rowNum(); i++) {
				for (int j = 0; j < colNum(); j++) {
					ret.set(i, j, get(i, j) % mod);
				}
			}
			return ret;
		} else if (k % 2 == 0) {
			Matrix ret = this.pow(k / 2);
			return ret.mul(ret, mod);
		} else {
			Matrix ret = this.pow(k / 2);
			return this.mul(ret, mod).mul(ret, mod);
		}
	}

	/**
	 * 单位矩阵
	 * 
	 * @param n
	 * @return
	 */
	public static Matrix One(int n) {
		Matrix ret = new Matrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ret.set(i, j, i == j ? 1 : 0);
			}
		}
		return ret;
	}
}
