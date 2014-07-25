
package com.dream.algorithm.graph.mst;

import java.util.PriorityQueue;
import java.util.Queue;

import com.dream.algorithm.datastructure.UnionFind;
import com.dream.algorithm.graph.Edge;
import com.dream.algorithm.graph.EdgeW;

/**
 * MST kruskal<br>
 * The minimum spanning undirected tree using the algorithm of kruskal <br>
 * Using heap and UnionFind set<br>
 * o(nlogn)
 * 
 * @author liushaohui
 * @version 1.0.0 since Aug 27, 2009
 */

public class MSTKru {
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

    // 节点数
    private int n;
    // 边的优先队列
    private Queue<Edge> edgePq;

    public MSTKru(int n) {
        this.n = n;
        this.edgePq = new PriorityQueue<Edge>();
    }

    public void addEdge(int a, int b, int w) {
        edgePq.add(new Edge(a, b, w));
    }

    public int getMST() {
        int mst = 0;
        UnionFind uf = new UnionFind(n);
        for (int i = 1; i < this.n; i++) {
            Edge edge = null;
            while (!edgePq.isEmpty()) {
                edge = edgePq.poll();
                if (!uf.find(edge.a, edge.b)) {
                    break;
                }
            }
            if (edge == null) {
                return Integer.MIN_VALUE;
            }
            mst += edge.w;
            uf.union(edge.a, edge.b);
        }
        return mst;
    }
}
