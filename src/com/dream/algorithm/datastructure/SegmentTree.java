package com.dream.algorithm.datastructure;

/**
 * segment tree<br>
 * 线段树
 * 
 * @author liushaohui
 * @version 1.0.0 since Aug 27,2009
 */

public class SegmentTree {
	private Node root;

	public SegmentTree(int n) {
		root = new Node(0, n - 1, 0);
		build(root);
	}

	/**
	 * 构造线段树
	 * 
	 * @param father
	 */
	private void build(Node father) {
		if (father.left == father.right) {
			return;
		}
		int mid = (father.left + father.right) / 2;
		father.leftnode = new Node(father.left, mid, 0);
		build(father.leftnode);
		father.rightnode = new Node(mid + 1, father.right, 0);
		build(father.rightnode);
	}

	/**
	 * 修改区间[from,to]的数值
	 * 
	 * @param from
	 * @param to
	 * @param value
	 */
	public void addValue(int from, int to, int value) {
		addValue(root, from, to, value);
	}

	/**
	 * 修改区间[from,to]的数值
	 * 
	 * @param father
	 * @param from
	 * @param to
	 * @param value
	 */
	private void addValue(Node father, int from, int to, int value) {

	}

	/**
	 * 获取区间[from,to]的最大值
	 * 
	 * @param from
	 * @param to
	 * @return 返回区间[from,to]的最大值
	 */
	public int getMax(int from, int to) {
		return getMax(root, from, to);
	}

	/**
	 * 获取区间[from,to]的最大值
	 * 
	 * @param root2
	 * @param from
	 * @param to
	 * @return
	 */
	private int getMax(Node father, int from, int to) {
		return 0;
	}

	// 线段树的节点
	class Node {
		public int left;
		public int right;
		public int value;
		public Node leftnode = null;
		public Node rightnode = null;

		public Node(int left, int right, int value) {
			this.left = left;
			this.right = right;
			this.value = value;
		}
	}
}
