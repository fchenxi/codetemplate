package com.dream.algorithm.graph.shortestpath;

/**
 * 正权值全源最短路径<br>
 * floyd 算法
 * @author liushaohui
 */
public class APSPFloyd {

  private int n;
  private int[][] v;

  public APSPFloyd(int n) {
    this.n = n;
    this.v = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        v[i][j] = Integer.MAX_VALUE;
      }
      v[i][i] = 0;
    }
  }

  public void addEdge(int a, int b, int c) {
    v[a][b] = Math.min(v[a][b], c);
  }

  public int[][] getAPSP() {
    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (v[i][k] == Integer.MAX_VALUE) {
            continue;
          }
          if (v[k][j] == Integer.MAX_VALUE) {
            continue;
          }
          v[i][j] = Math.min(v[i][j], v[i][k] + v[k][j]);
        }
      }
    }
    return v;
  }
}
