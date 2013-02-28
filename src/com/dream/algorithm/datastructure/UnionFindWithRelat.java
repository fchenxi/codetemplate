package com.dream.algorithm.datastructure;

/**
 * 带关系的并查集合
 * 
 * @author liushaohui
 * 
 */
public class UnionFindWithRelat {
	int[] fath;
	int[] relat;

	public UnionFindWithRelat(int n) {
		this.fath = new int[n];
		this.relat = new int[n];
		for (int i = 0; i < n; i++) {
			fath[i] = i;
			relat[i] = 0;
		}
	}

	public int father(int k) {
		if (k != fath[k]) {
			int t = fath[k];
			fath[k] = father(t);
			relat[k] = (relat[k] + relat[t]) % 2;
		}
		return fath[k];
	}

	int find(int a, int b) {
		int fa = father(a);
		int fb = father(b);
		if (fa != fb) {
			return 2;
		} else {
			return (relat[a] + relat[b]) % 2;
		}
	}

	void Union(int a, int b, int c) {
		int fa = father(a);
		int fb = father(b);
		if (fa == fb) {
			return;
		}
		relat[fa] = (relat[b] - relat[a] + c + 2) % 2;
		fath[fa] = fb;
	}
}