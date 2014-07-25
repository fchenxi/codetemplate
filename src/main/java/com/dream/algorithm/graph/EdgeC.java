package com.dream.algorithm.graph;

/**
 * 代流量限制的边
 * 
 * @author liushaohui
 * 
 */
public class EdgeC extends Edge {
	public int cap;

	public EdgeC(int a, int b, int cap) {
		super(a, b);
		this.cap = cap;
	}
}
