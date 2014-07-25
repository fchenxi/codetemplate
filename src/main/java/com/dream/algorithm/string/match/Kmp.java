
package com.dream.algorithm.string.match;

/**
 * Knuth–Morris–Pratt algorithm<br>
 * 要点：最大的(前缀等于后缀)
 * 
 * @author liushaohui
 * @version 1.0.0 since Aug 27，2009
 */
public class Kmp {
    /**
     * 获取模式串的next数组
     * 
     * @param pattern
     * @return
     */
    private int[] getNext(char[] pattern) {
        int[] next = new int[pattern.length + 1];
        int start = 0;
        for (int i = 0; i <= pattern.length; i++) {
            next[i] = start;
            while (start >= 0 && pattern[start - 1] != pattern[i - 1]) {
                start = next[start];
            }
            start++;
        }
        return next;
    }

    /**
     * kmp 匹配
     * 
     * @param str 母串
     * @param pattern 模式串
     * @return 第一个匹配位置，如果没有匹配的位置，返回-1
     */
    public int kmp(String str, String pattern) {
        return -1;
    }

    /**
     * kmp 匹配
     * 
     * @param str 母串
     * @param pattern 模式串
     * @return 第一个匹配位置，如果没有匹配的位置，返回-1
     */
    public int kmp(char[] str, char[] pattern) {
        int[] next = getNext(pattern);
        int start = 0;
        for (int i = 0; i < str.length; i++) {
            if (start >= 0 && str[i] != pattern[start]) {
                start = next[start];
            } else {
                start++;
            }
            if (start == pattern.length) {
                return i - start;
            }
            start++;
        }
        return -1;
    }
}
