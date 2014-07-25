package com.dream.algorithm.math;

public class ArraysEx {
	/**
	 * 上一个全排列
	 * 
	 * @param A
	 * @return
	 */
	public static boolean nextPermutation(int[] A) {
		int n = A.length;
		int i = 0;
		for (i = n - 1; i > 0; i--) {
			if (A[i - 1] < A[i]) {
				break;
			}
		}
		if (i == 0) {
			return false;
		}
		int j = i;
		for (j = n - 1; j >= i; j--) {
			if (A[j] > A[i - 1]) {
				break;
			}
		}
		int tmp = A[i - 1];
		A[i - 1] = A[j];
		A[j] = tmp;
		for (int k = 0; i + k < n - 1 - k; k++) {
			tmp = A[i + k];
			A[i + k] = A[n - 1 - k];
			A[n - 1 - k] = A[i + k];
		}
		return true;
	}

	/**
	 * 下一个全排列
	 * 
	 * @param A
	 * @return
	 */
	public static boolean prevPermutation(int[] A) {
		int n = A.length;
		int i = 0;
		for (i = n - 1; i > 0; i--) {
			if (A[i - 1] > A[i]) {
				break;
			}
		}
		if (i == 0) {
			return false;
		}
		int j = i;
		for (j = n - 1; j >= i; j--) {
			if (A[j] < A[i - 1]) {
				break;
			}
		}
		int tmp = A[i - 1];
		A[i - 1] = A[j];
		A[j] = tmp;
		for (int k = 0; i + k < n - 1 - k; k++) {
			tmp = A[i + k];
			A[i + k] = A[n - 1 - k];
			A[n - 1 - k] = A[i + k];
		}
		return true;
	}

	/**
	 * 
	 * @param array
	 * @param k
	 *            从0开始
	 * @return
	 */
	public static int kthElement(int[] array, int k) {
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			int p = partition(array, left, right);
			if (p == k) {
				break;
			} else if (p < k) {
				left = p + 1;
			} else {
				right = p - 1;
			}
		}
		return array[k];
	}

	/**
	 * 区间分块
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 */
	private static int partition(int[] array, int left, int right) {
		int key = (left + right) >> 1;
		while (left < right) {
			while (array[left] <= array[key])
				left++;
			while (array[right] > array[key]) {
				right--;
			}
			if (left < right) {
				int tmp = array[left];
				array[left] = array[right];
				array[right] = tmp;
			}
		}
		return left;
	}
	
	/**
	 * 寻找有序数组array中大于等于value的第一个位置
	 * 
	 * @param array
	 *            有序数组
	 * @param value
	 *            需要查询的数值
	 * @return 有序数组array中大于等于value的第一个位置
	 */
	public static int lowerbound(int[] array, int value) {
		return -1;
	}
	
	/**
	 * 寻找有序数组array中小于等于value的最后一个位置
	 * 
	 * @param array
	 *            有序数组
	 * @param value
	 *            需要查询的数值
	 * @return 有序数组array中小于等于value的最后一个位置
	 */
	public static int upppererbound(int[] array, int value) {
		return -1;
	}
	
}
