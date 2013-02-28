package com.dream.algorithm.dp;

/**
 * MSS<br>
 * Maxisum sum sequence<br>
 * 最大连续子段和
 * 
 * @author liushaohui
 * @version 1.0.0
 */
public class MSS {
	/**
	 * 动态规划
	 * 
	 * @param array
	 *            数组
	 * @return 最大连续字段和
	 */
	public int getMSS(int array[]) {
		int res = array[0];
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
			if (sum > res) {
				res = sum;
			}
			if (sum < 0) {
				sum = 0;
			}
		}
		return res;
	}
}
