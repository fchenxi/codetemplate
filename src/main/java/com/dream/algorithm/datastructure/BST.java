package com.dream.algorithm.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * BST<br>
 * binnary search tree<br>
 * 二叉查找树,二叉搜索树
 * @author liushaohui
 */

public class BST {
  private BTNode<Integer> root;

  public BST() {
    root = null;
  }

  /**
   * 增加一个value
   * @param v
   */
  public void add(int v) {
    add(root, v);
  }

  /**
   * 从某个节点增加一个value
   * @param par
   * @param v
   */
  private void add(BTNode<Integer> par, int v) {
    if (par == null) {
      par = new BTNode<Integer>(v);
    } else {
      if (v <= par.v) {
        add(par.left, v);
      } else {
        add(par.right, v);
      }
    }
  }

  public List<Integer> getSorted() {
    List<Integer> sorted = new ArrayList<Integer>();
    inOrderTraval(root, sorted);
    return sorted;
  }

  /**
   * 中序遍历
   * @param par
   * @param sorted
   */
  private void inOrderTraval(BTNode<Integer> par, List<Integer> sorted) {
    if (par == null) {
      return;
    }
    if (par.left != null) {
      inOrderTraval(par.left, sorted);
    }
    sorted.add(par.v);
    if (par.right != null) {
      inOrderTraval(par.right, sorted);
    }
  }

  /**
   * 检测二叉搜索上是否在两个节点的和为给定的值
   * @param sum
   * @return
   */
  public int[] checkSum(int sum) {
    return new int[] { 0, 1 };
  }
}
