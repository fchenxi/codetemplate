package com.dream.algorithm.graph.maxflow;

import com.dream.algorithm.datastructure.UnionFind;

/**
 * Stoer-Wagner Algorithm求全源最小割
 * 
 * @author Administrator
 * 
 */
public class StoerWagner implements AllMiniCut {
	private int n;
	private int graph[][];

	public StoerWagner(int n) {
		this.n = n;
		this.graph = new int[n][n];
	}

	public void addEdge(int a, int b, int c) {
		graph[a][b] = +c;
	}

	@Override
	public int getAllMiniCut() {
		boolean[] flag = new boolean[n];
		UnionFind unionFind = new UnionFind(n);
		int allMiniCut = Integer.MAX_VALUE;
		return allMiniCut;
	}
}
