package com.dream.algorithm.datastructure;

import java.util.Arrays;

/**
 * UnionFind 并查集<br>
 * 带关系，路径压缩
 * 
 * @author liushaohui
 * @version 1.0.0 since Aug 27, 2009
 */
public class UnionFind {

	// 父节点
	private int[] fath;

	// 某一个节点个数
	private int[] nodeSz;

	public UnionFind(int n) {
		this.fath = new int[n];
		this.nodeSz = new int[n];
		Arrays.fill(this.nodeSz, 1);
		for (int i = 0; i < n; i++) {
			fath[i] = i;
		}
	}

	/**
	 * 求某一个节点的父亲
	 * 
	 * @param k
	 *            一个节点
	 * @return k节点的父亲
	 */
	private int father(int k) {
		if (fath[k] == k) {
			return k;
		} else {
			fath[k] = father(fath[k]);
			return fath[k];
		}
	}

	/**
	 * 判断a，b节点是否在同一个集合
	 * 
	 * @param a
	 *            一个节点
	 * @param b
	 *            另一个节点
	 * @return 如果a,b在同一个集合中，返回true，否则返回false
	 */
	public boolean find(int a, int b) {
		int fa = father(a);
		int fb = father(b);
		return fa == fb ? true : false;
	}

	/**
	 * 求两个节点所代表的集合的并
	 * 
	 * @param a
	 *            一个节点
	 * @param b
	 *            另一个节点
	 */
	public void union(int a, int b) {
		int fa = father(a);
		int fb = father(b);
		if (fa != fb) {
			if (nodeSz[fa] > nodeSz[fb]) {
				fath[fb] = fa;
				nodeSz[fa] += nodeSz[fb];
			} else {
				fath[fa] = fb;
				nodeSz[fb] += nodeSz[fa];
			}
		}
	}

	/**
	 * @return 节点个数
	 */
	public int getNodeSz() {
		return nodeSz.length;
	}
}
