package com.dream.algorithm.graph.match;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * maximum bipartite matching<br>
 * 二分图的最大匹配
 * 
 * Hungary 匈牙利算法
 * 
 * @author liushaohui
 * @version 1.0.0 from Sep 20, 2009
 * 
 */
public class Hungray {
	private int n1;
	private int n2;
	private int match[][];
	private int mRow[];
	private int mCol[];

	public Hungray(int n1, int n2) {
		this.n1 = n1;
		this.n2 = n2;
		this.match = new int[n1][n2];
		this.mRow = new int[n1];
		this.mCol = new int[n2];
	}

	/**
	 * 增加一条边
	 * 
	 * @param a
	 * @param b
	 */
	public void addEdge(int a, int b) {
		match[a][b] = 1;
	}

	/**
	 * 广度优先搜索
	 * 
	 * @param flag
	 * @param from
	 * @return
	 */
	private int dfs(boolean[] flag, int from) {
		for (int i = 0; i < n2; i++)
			if (match[from][i] == 1) {
				if (flag[i] == false) {
					flag[i] = true;
					int t = mCol[i];
					mCol[i] = from;
					mRow[from] = i;
					if (t == -1 || dfs(flag, t) == 1) {
						return 1;
					}
					mCol[i] = t;
					mRow[t] = i;
				}
			}
		return 0;
	}

	/**
	 * 
	 * @param flag
	 * @param from
	 * @return
	 */
	private int bfs(int s) {
		int[] prev = new int[n1];
		Arrays.fill(prev, -1);
		prev[s] = s;

		Queue<Integer> queue = new LinkedBlockingQueue<Integer>();
		queue.add(s);
		int from = s;

		boolean find = false;
		while (!queue.isEmpty()) {
			from = queue.poll();
			for (int i = 0; i < n2; i++) {
				if (match[from][i] > 0) {
					int to = i;
					int next = mCol[to];
					if (from != next) {
						if (next == -1) {
							find = true;
							break;
						}
						if (prev[next] == -1) { // 没有增广过
							queue.add(next);
							prev[next] = from;
						}
					}
				}
			}
			if (find == true) {
				break;
			}
		}
		if (!find) {
			return 0;
		}
		while (prev[from] != from) {
			from = prev[from];
		}
		return 1;
	}

	/**
	 * 二分图最大匹配
	 * 
	 * @return
	 */
	public int getMaxMatch() {
		int ret = 0;
		Arrays.fill(mCol, -1);
		Arrays.fill(mRow, -1);
		boolean[] flag = new boolean[n2];
		for (int i = 0; i < n1; i++) {
			Arrays.fill(flag, false);
			ret += dfs(flag, i);
		}
		return ret;
	}

	/**
	 * 二分图最大匹配
	 * 
	 * @return
	 */
	public int getMaxMatchBFS() {
		int ret = 0;
		Arrays.fill(mCol, -1);
		Arrays.fill(mRow, -1);
		for (int i = 0; i < n1; i++) {
			ret += bfs(i);
		}
		return ret;
	}
}
