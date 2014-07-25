package com.dream.algorithm.others;

import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 离散化<br>
 * 大量不连续的重复的标号转换为连续小的标号类
 * 
 * @author liushaohui
 * 
 */
public class Discretization {
	SortedSet<Integer> set;
	HashMap<Integer, Integer> trans;
	HashMap<Integer, Integer> back;

	public Discretization() {
		set = new TreeSet<Integer>();
	}

	/**
	 * 增加一个标号
	 * 
	 * @param v
	 */
	public void add(int v) {
		set.add(v);
	}

	/**
	 * 增加标号完毕，开始建立新的标号
	 */
	public void build() {
		trans = new HashMap<Integer, Integer>();
		back = new HashMap<Integer, Integer>();
		Integer[] array = set.toArray(new Integer[0]);
		for (int i = 0; i < array.length; i++) {
			trans.put(array[i], i);
			back.put(i, array[i]);
		}

	}

	/**
	 * 由旧的标号获得新的标号
	 * 
	 * @param from
	 * @return
	 */
	public int getDis(int from) {
		return trans.get(from);
	}

	/**
	 * 由新的标号获得旧的标号
	 * 
	 * @param to
	 * @return
	 */
	public int getBack(int to) {
		return back.get(to);
	}
}
