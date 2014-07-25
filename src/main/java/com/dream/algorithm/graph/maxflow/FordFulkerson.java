package com.dream.algorithm.graph.maxflow;

import java.util.Arrays;

/**
 * Ford-Fulkerson method邻接矩阵版<br>
 * Given a flow function and its corresponding residual graph (a maximum- flow problem), select a
 * path from the source to the sink along which the flow can be increased and increase the flow.
 * Repeat until there are no such paths.
 * @author liushaohui
 * @version 1.0.0 from Oct 7, 2009
 */

public class FordFulkerson {
  private int n;
  private int[][] cap;

  public FordFulkerson(int n) {
    this.n = n;
    this.cap = new int[n][n];
  }

  public void addEdge(int a, int b, int v) {
    cap[a][b] += v;
  }

  public int getMaxflow(int s, int t) {
    int flow = 0;
    boolean[] flag = new boolean[n];
    while (true) {
      Arrays.fill(flag, true);
      int path = dfs(s, t, Integer.MAX_VALUE, flag);
      if (path <= 0) {
        break;
      } else {
        flow += path;
      }
    }
    return flow;
  }

  /**
   * 递归寻找增广路径
   * @param source
   * @param sink
   * @param flow
   * @param flag
   * @return
   */
  private int dfs(int source, int sink, int flow, boolean[] flag) {
    if (source == sink) {
      return flow;
    }
    flag[source] = false;
    for (int i = 0; i < n; i++) {
      if (flag[i] && cap[source][i] > 0) {
        int t = dfs(i, sink, Math.min(flow, cap[source][i]), flag);
        if (t > 0) {
          cap[source][i] -= t;
          cap[i][source] += t;
          return t;
        }
      }
    }
    return 0;
  }
}
