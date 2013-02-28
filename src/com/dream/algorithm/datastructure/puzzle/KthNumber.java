package com.dream.algorithm.datastructure.puzzle;

/**
 * 给定数组，查询区间[a,b]上的第k大数值
 */
public class KthNumber {
  private int[] A;

  public KthNumber(int[] A) {
    this.A = A;
  }

  /**
   * 查询区间[a,b]上的第k大数值
   * @param a
   * @param b
   * @param k
   * @return
   */
  public int query(int a, int b, int k) {
    if (k > (b - a + 1)) {
      return Integer.MIN_VALUE;
    }
    return -1;
  }
}
