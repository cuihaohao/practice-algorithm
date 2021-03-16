package com.ch.practice.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * leetcode 361题
 */
public class SmallSeqV2 {
    public static void main(String[] args) {
        System.out.println(findSmallSeq("acbabcedce"));
    }

    public static String findSmallSeq(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        int len = s.length();
        int[] lastIndex = new int[26];
        for (int i = 0; i < len; i++) {
            lastIndex[chars[i] - 'a'] = i;
        }
        boolean[] visited = new boolean[26];
        for (int i = 0; i < len; i++) {
            if (visited[chars[i] - 'a']) {
                continue;
            }
            while (!deque.isEmpty() && deque.peekLast() > chars[i] && lastIndex[deque.peekLast() - 'a'] > i) {
                Character top = deque.removeLast();
                visited[top - 'a'] = false;

            }
            visited[chars[i] - 'a'] = true;
            deque.addLast(chars[i]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : deque) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
