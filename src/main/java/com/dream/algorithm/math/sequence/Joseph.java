package com.dream.algorithm.math.sequence;

/**
 * 约瑟夫问题
 * 
 * @author liushaohui
 * 
 */
public class Joseph {
	public static int lastId(int n, int m) {
		int ret = 0;
		for (int i = 0; i < n - 1; i++) {
			ret = (ret + m) % (i + 2);
		}
		return ret;
	}
}
