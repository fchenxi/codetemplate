package com.dream.algorithm.sort;

/**
 * merge sort <br>
 * 归并排序
 * 
 * @author liushaohui
 * @version 1.0.0 since Aug 27, 2009
 */
public class MergeSort implements Sort {

	@Override
	public void sort(int[] array, int from, int to) {
		if (from == to) {
			return;
		} else {
			int mid = (from + to) / 2;
			sort(array, from, mid);
			sort(array, mid + 1, to);
			merge(array, from, mid, to);
		}
	}

	/**
	 * 归并两个有序序列
	 * 
	 * @param array
	 * @param from
	 * @param mid
	 * @param to
	 */
	private void merge(int[] array, int from, int mid, int to) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sort(int[] array) {
		sort(array, 0, array.length - 1);
	}
}
