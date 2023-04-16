package com.greatlearning.priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class JuiceShop {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the Juice Shop");
		System.out.println("Enter the total number of orders for Mango milkshake");
		int mango = sc.nextInt();
		System.out.println("Enter the total number of orders for Orange milkshake");
		int orange = sc.nextInt();
		System.out.println("Enter the total number of orders for Pineapple milkshake");
		int pineapple = sc.nextInt();
		System.out.println("Minimum time needed to deliver all orders is: " + findMinimumTime(mango, orange, pineapple));
		sc.close();
	}
	
	public static int findMinimumTime(int mango,int orange,int pineapple) {
		int minSeconds = 0;
		PriorityQueue<Integer> orderQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
		orderQueue.add(mango);
		orderQueue.add(orange);
		orderQueue.add(pineapple);
		//Iterate the Orderqueue until all the orders are served.
		while(!orderQueue.isEmpty()) {
			int order1 = orderQueue.peek() == null ? 0 : orderQueue.poll();
			int order2 = orderQueue.peek() == null ? 0 : orderQueue.poll();
			
			if(order1 > 0 && order2 > 0) {
				order1--;
				order2--;
				minSeconds++;
			}else if(order1 > 0 && order2 == 0) { // Condition arrives when there is no possiblity of two diff milkshakes.
				minSeconds = minSeconds + order1;
				return minSeconds;
			}
			
			if(order1 > 0) {
				orderQueue.add(order1);
			}
			
			if(order2 > 0) {
				orderQueue.add(order2);
			}
		}
		return minSeconds;
	}
}
