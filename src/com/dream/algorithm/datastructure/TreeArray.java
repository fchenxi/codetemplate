package com.dream.algorithm.datastructure;

/**
 * Tree Array : 一维树状数组
 * 
 * @author liushaohui
 * @version 1.0.0 since Aug 27，2009
 */

public class TreeArray {

	private int[] treeArray;

	public TreeArray(int n) {
		treeArray = new int[n];
	}

	/**
	 * 取得x的最低的为1的位的大小
	 * 
	 * @param x
	 *            整数
	 * @return x的最低的为1的位的大小
	 */
	private int lowbits(int x) {
		return x & (~x);
	}

	/**
	 * 获取区间[1,k]的和
	 * 
	 * @param k
	 *            区间结尾
	 * @return 区间和
	 */
	private int getSum(int k) {
		int sum = 0;
		while (k > 0) {
			sum += treeArray[k];
			k = k - lowbits(k);
		}
		return sum;
	}

	/**
	 * 获得区间[from,to]的和
	 * 
	 * @param from
	 *            区间左端点
	 * @param to
	 *            区间右端点
	 * @return 区间和
	 */
	public int getSum(int from, int to) {
		return getSum(to) - getSum(from - 1);
	}

	/**
	 * 改变数组某一位的值
	 * 
	 * @param pos
	 *            需要改变的数组的位置
	 * @param v
	 *            增加改变的值
	 */
	public void addValue(int pos, int v) {
		while (pos < treeArray.length) {
			treeArray[pos] += v;
			pos += lowbits(pos);
		}
	}
}
