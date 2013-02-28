package com.dream.algorithm.graph;

public class EdgeW extends Edge implements Comparable<EdgeW> {
	// 边的权值
	public int w;

	public EdgeW(int a, int b, int w) {
		super(a, b);
		this.w = w;
	}

	@Override
	public int compareTo(EdgeW that) {
		return this.w - that.w;
	}
}