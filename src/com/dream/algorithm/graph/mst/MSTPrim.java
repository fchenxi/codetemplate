package com.dream.algorithm.graph.mst;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * MST prim<br>
 * Mining Spamming tree using the algorithm of prim<br>
 * Using heap<br>
 * o(nlogn)
 * @author liushaohui
 */
public class MSTPrim {
  // 节点个数
  private int n;
  private List<Edge>[] edgeList;

  public MSTPrim(int n) {
    this.n = n;
    this.edgeList = new List[n];
    for (int i = 0; i < n; i++) {
      this.edgeList[i] = new ArrayList<Edge>();
    }
  }

  public void addEdge(int a, int b, int w) {
    edgeList[a].add(new Edge(a, b, w));
    edgeList[b].add(new Edge(b, a, w));
  }

  public int getMST() {
    int mst = 0;
    Queue<Edge> edgePq = new PriorityQueue<Edge>();
    boolean[] flag = new boolean[this.n];
    for (int i = 0; i < n; i++) {
      flag[i] = false;
    }
    flag[0] = true;

    for (Edge e : edgeList[0]) {
      if (!flag[e.b]) {
        edgePq.add(e);
      }
    }

    for (int i = 1; i < this.n; i++) {
      Edge edge = null;

      while (!edgePq.isEmpty()) {
        edge = edgePq.poll();
        if (!flag[edge.b]) {
          break;
        }
      }
      if (edge == null) { // b不存在是，返回-1
        return Integer.MIN_VALUE;
      }

      mst += edge.w;

      flag[edge.b] = false;

      for (Edge e : edgeList[edge.b]) {
        if (!flag[e.b]) {
          edgePq.add(e);
        }
      }
    }
    return mst;
  }
  
  public class Edge {
    public int a, b, w;

    public Edge(int a, int b, int w) {
      this.a = a;
      this.b = b;
      this.w = w;
    }

    public int compareTo(Edge that) {
      return this.w - that.w;
    }
  }
}
