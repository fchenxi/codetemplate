package com.dream.algorithm.graph;

/**
 * 带流量限制和费用的边
 * 
 * @author liushaohui
 * 
 */
public class EdgeCV extends EdgeC {
	public int val;

	public EdgeCV(int a, int b, int cap, int val) {
		super(a, b, cap);
		this.val = val;
	}
}
