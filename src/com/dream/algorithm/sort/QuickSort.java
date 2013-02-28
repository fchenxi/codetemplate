package com.dream.algorithm.sort;

/**
 * 快速排序
 * 
 * @author liushaohui
 * 
 */
public class QuickSort implements Sort {

	@Override
	public void sort(int[] array, int from, int to) {
		if (from == to) {
			return;
		} else {
			int key = keySelect(array, from, to);
		}
	}

	/**
	 * 选择key
	 * 
	 * @param array
	 * @param from
	 * @param to
	 * @return
	 */
	private int keySelect(int[] array, int from, int to) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void sort(int[] array) {
		sort(array, 0, array.length - 1);
	}
}
