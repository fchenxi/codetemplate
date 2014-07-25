package com.dream.algorithm.graph.shortestpath;

import com.dream.algorithm.graph.shortestpath.SSSPBellmanFord.Edge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * SSSP :single source shortest path<br>
 * algorithm dijkstra
 * @author liushaohui
 */
class SSSPDijkstra {

  private int n;
  private List<Edge> edgeList[];

  public SSSPDijkstra(int n) {
    this.n = n;
    edgeList = new List[n];
    for (int i = 0; i < edgeList.length; i++) {
      edgeList[i] = new ArrayList<Edge>();
    }
  }

  public void addEdge(int a, int b, int v) {
    edgeList[a].add(new Edge(a, b, v));
  }

  public int getSSSP(int s, int t) {
    return getSSSP(s)[t];
  }

  public int[] getSSSP(int s) {
    int[] ret = new int[n];
    Arrays.fill(ret, Integer.MAX_VALUE);

    boolean[] flag = new boolean[n];
    Arrays.fill(flag, false);

    Queue<Node> pq = new PriorityQueue<Node>();
    pq.add(new Node(s, 0));
    ret[s] = 0;

    while (!pq.isEmpty()) {
      Node top = pq.poll();
      int from = top.from;

      if (flag[from]) {
        continue;
      }
      flag[from] = true;
      for (Edge e : edgeList[from]) {
        int to = e.b;

        if (ret[to] > ret[from] + e.w) {
          ret[to] = ret[from] + e.w;
          pq.add(new Node(to, ret[to]));
        }
      }
    }
    return ret;
  }

  public class Edge implements Comparable<Edge> {
    public int a;     // 一节点
    public int b;     // 另一节点
    public int w;     // 边的权值

    public Edge(int a, int b, int w) {
      this.a = a;
      this.b = b;
      this.w = w;
    }

    @Override
    public int compareTo(Edge that) {
      return this.w - that.w;
    }
  }
  
  class Node implements Comparable<Node> {
    int from;
    int dist;

    public Node(int from, int dist) {
      this.from = from;
      this.dist = dist;
    }

    @Override
    public int compareTo(Node that) {
      return this.dist - that.dist;
    }
  }
}
