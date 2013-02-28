package com.dream.algorithm.sort;

/**
 * 原地归并排序<br>
 * 算法说明可以参见 {@link http
 * ://duanple.blog.163.com/blog/static/709717672008103041136277/}
 * 
 * @author liushaohui
 * @version 1.0.0 from 2009年9月26日
 */
public class InplaceMerge {
	/**
	 * 交换两个元素
	 * 
	 * @param array
	 * @param x
	 * @param y
	 */
	private void swap(int[] array, int x, int y) {
		int t = array[x];
		array[x] = array[y];
		array[y] = t;
	}

	/**
	 * 交换一段区间
	 * 
	 * @param array
	 * @param n
	 * @param x
	 * @param y
	 */
	private void swap(int[] array, int n, int x, int y) {
		for (int i = 0; i < n; i++) {
			swap(array, x + i, y + i);
		}
	}

	/**
	 * 原地的选择排序
	 * 
	 * @param array
	 * @param s
	 * @param t
	 */
	private void selectSort(int[] array, int s, int t) {
		for (int i = s; i < t; i++) {
			int p = i;
			for (int j = i + 1; j < t; j++) {
				if (array[j] < array[p]) {
					p = j;
				}
			}
			if (p != i) {
				swap(array, p, i);
			}
		}
	}

	/**
	 * 带有一块交换区的归并
	 * 
	 * @param array
	 * @param len1
	 *            第一段的长度
	 * @param len2
	 *            第二段的长度
	 * @param s
	 *            保证第一段和第二段连续，s为连续段的起点
	 * @param tmp
	 *            交换分区的位置，长度至少大于第一段的长度
	 */

	private void merge(int[] array, int len1, int len2, int s, int tmp) {
		swap(array, len1, s, tmp);

		int e1 = s + len1 + len2, e2 = tmp + len1;

		for (int s1 = s + len1, s2 = tmp; s1 < e1 || s2 < e2;) {
			if (s1 == e1) {
				while (s2 < e2) {
					swap(array, s, s2);
					s++;
					s2++;
				}
				break;
			}
			if (s2 == e2) {
				while (s1 < e1) {
					swap(array, s, s1);
					s++;
					s1++;
				}
				break;
			}
			if (array[s1] < array[s2]) {
				swap(array, s, s1);
				s++;
				s1++;
			} else {
				swap(array, s, s2);
				s++;
				s2++;
			}
		}
	}

	/**
	 * 原地归并排序
	 * 
	 * @param array
	 * @param M
	 *            第一段的长度
	 * @param N
	 *            总长度，下表从0开始
	 */
	public void inplaceMerge(int[] array, int M, int N) {
		int n = (int) Math.sqrt(N * 1.0);
		int m = (N + n - 1) / n - 2;
		int s = N - n * m;
		int p = M / n;

		swap(array, n, p * n, m * n);

		// 第一步： 使前m段的第一个元素有序
		// 在m段最多存在m个反序，可以证明的

		for (int i = 0; i < m; i++) {
			p = i;
			for (int j = i + 1; j < m; j++) {
				if (array[j * n] < array[p * n]) {
					p = j;
				}
			}
			if (p != i) {
				swap(array, n, i * n, p * n);
			}
		}

		// 第二步：使前m段有序
		for (int i = 0; i + 1 < m; i++) {
			// 需要交换
			if (array[i + n - 1] > array[(i + 1) * n]) {
				merge(array, n, n, i, n * m);
			}
		}
		// 第三步：使最后的2S段有序
		selectSort(array, N - 2 * s, N);

		// 第四步：分成成都为s的段
		for (int i = N - 2 * s - 1; i >= 0; i = i - s) {
			merge(array, Math.min(s, i - 0 + 1), s, Math.max(0, i - s + 1), N
					- s);
		}
		// 第五步：使最后的S段有序
		selectSort(array, N - s + 1, N);
	}
}
