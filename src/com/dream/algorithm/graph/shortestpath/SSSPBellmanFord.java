package com.dream.algorithm.graph.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 边权值位负数的最短路径<br>
 * BellmanFord 算法
 * 
 * @author liushaohui
 * 
 */
public class SSSPBellmanFord {

	private int n;
	private List<Edge> edgeList;

	public SSSPBellmanFord(int n) {
		this.n = n;
		edgeList = new ArrayList<Edge>();
	}

	public void addEdge(int a, int b, int v) {
		edgeList.add(new Edge(a, b, v));
	}

	public int getSSSP(int s, int t) {
		return getSSSP(s)[t];
	}

	public int[] getSSSP(int s) {
		int[] dist = new int[n];
		if (hasNegCircle(s)) {
			Arrays.fill(dist, Integer.MIN_VALUE);
			return dist;
		}
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;
		for (int i = 1; i < n; i++) {
			for (Edge e : edgeList) {
				if (dist[e.a] < Integer.MAX_VALUE) {
					dist[e.b] = Math.min(dist[e.b], dist[i] + e.w);
				}
			}
		}
		return dist;
	}

	/**
	 * 检测是否存在负环
	 * 
	 * @return
	 */
	public boolean hasNegCircle(int s) {
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;
		for (int i = 1; i < n; i++) {
			for (Edge e : edgeList) {
				if (dist[e.a] < Integer.MAX_VALUE) {
					dist[e.b] = Math.min(dist[e.b], dist[i] + e.w);
				}
			}
		}
		for (Edge e : edgeList) {
			if (dist[e.a] < Integer.MAX_VALUE) {
				if (dist[e.b] < dist[e.a] + e.w) {
					return true;
				}
			}
		}
		return false;
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
}
