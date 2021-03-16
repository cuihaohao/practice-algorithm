package com.ch.practice.recursion;

/**
 * “李白街上走，提壶去买酒，遇店加一倍，见花喝一斗”， 途中，遇见5次店，见了10此花，壶中原有2斗酒，最后刚好喝完酒，
 * 要求最后遇见的是花，求可能的情况有多少种？
 */
public class LiBaiDrink {
	static int count = 0;

	public static void main(String[] args) {
		drink(2, 10, 5);
		System.out.println(count);
	}

	public static void drink(int wine, int flower, int store) {
		if (wine < 1 || flower < 1 || store < 0) {
			return;
		}
		if (wine == 1 && flower == 1 && store == 0) {
			count++;
		}
		if (store > 0) {
			drink(wine * 2, flower, store - 1);
		}
		if (flower > 0) {
			drink(wine - 1, flower - 1, store);
		}

	}
}
