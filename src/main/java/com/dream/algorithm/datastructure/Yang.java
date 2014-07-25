package com.dream.algorithm.datastructure;

/**
 * 杨式图表
 * 
 * @author liushaohui
 * @version 1.0.0
 */
public class Yang {
	private int[][] table;

	/**
	 * 杨式图表o(n)查询
	 * 
	 * @param table
	 * @param v
	 * @return
	 */
	public boolean query(int v) {
		return query(0, 0, table.length - 1, table[0].length - 1, v);
	}
	private boolean query(int x1, int y1, int x2, int y2, int v) {
		if (x1 >= x2 || y1 >= y2)
			return false;

		for (int i = y2; i >= y1; i--) {
			if (table[x1][i] == v) {
				return true;
			} else if (table[x1][i] < v) {
				return query(x1 + 1, y1, x2, y2, v);
			}
		}
		return false;
	}
}
