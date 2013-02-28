package com.dream.algorithm.datastructure;

import com.dream.algorithm.math.MathEx;

/**
 * Range Minimum Query<br>
 * 区间最小查询<br>
 * 适合查询,不适合修改 如果需要修改,使用线段树
 * 
 * @author liushaohui
 */

public class RMQ {
	private int n;
	private int logN;
	private int[] value;
	private int[][] rmq;

	private RMQ(int[] value) {
		this.n = value.length;
		this.value = value;
		this.logN = MathEx.highBin(n) + 1;
		this.rmq = new int[logN][n];
		init();
	}

	/**
	 * 初始化的复杂度:o(n*log(n))
	 */
	public void init() {
		for (int i = 0; i < n; i++) {
			rmq[0][i] = i;
		}
		for (int k = 1; k < logN; k++) {
			for (int i = 0; i < n - (1 << k) + 1; i++) {
				if (cmp(rmq[k - 1][i], rmq[k - 1][i + (1 << (k - 1))])) {
					rmq[k][i] = rmq[k - 1][i];
				} else {
					rmq[k][i] = rmq[k - 1][i + (1 << (k - 1))];
				}
			}
		}
	}

	/**
	 * 比较函数
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private boolean cmp(int a, int b) {
		if (value[a] <= value[b]) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 询问区间[from,to]的最大/最小数值的位置<br>
	 * 时间复杂度:O(e)
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	public int queryPos(int from, int to) {
		int len = to - from + 1;
		int k = MathEx.highBin(len);
		if (cmp(rmq[k][from], rmq[k][to - (1 << k) + 1])) {
			return rmq[k][from];
		} else {
			return rmq[k][to - (1 << k) + 1];
		}
	}

	/**
	 * 询问区间[from,to]的最大/最小数值<br>
	 * 时间复杂度:O(e)
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	public int query(int from, int to) {
		return value[queryPos(from, to)];
	}
}
