package com.dream.algorithm.sort;

/**
 * 排序的接口
 * 
 * @author liushaohui
 * 
 */
public interface Sort {
	/**
	 * 
	 * @param array
	 * @param from
	 * @param to
	 */
	public void sort(int[] array, int from, int to);

	/**
	 * 
	 * @param array
	 */
	public void sort(int[] array);
}
