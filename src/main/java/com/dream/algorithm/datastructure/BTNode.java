package com.dream.algorithm.datastructure;

/**
 * 二叉树节点类
 * 
 * @author liushaohui
 * 
 */
public class BTNode<T> {
	public T v;
	BTNode<T> left;
	BTNode<T> right;

	public BTNode(T v) {
		this.v = v;
		this.left = null;
		this.right = null;
	}
}