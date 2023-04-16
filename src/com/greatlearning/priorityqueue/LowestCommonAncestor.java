package com.greatlearning.priorityqueue;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(20);
		root.right = new TreeNode(30);
		root.left.left = new TreeNode(40);
		root.left.right = new TreeNode(50);
		root.right.left = new TreeNode(60);
		root.right.right = new TreeNode(70);
		System.out.println("Lowest Common Ancestor (20,30) = "+getLCA(root,20,30));
		System.out.println("Lowest Common Ancestor (40,30) = "+getLCA(root,40,30));
		System.out.println("Lowest Common Ancestor (60,70) = "+getLCA(root,60,70));
		System.out.println("Lowest Common Ancestor (20,40) = "+getLCA(root,20,40));
	}
	
	//Find out the path of node traversal
	public static boolean findPath(TreeNode root, int data, List<Integer> path ) {
		// Base condition to come out of recursive
		if(root == null) {
			return false;
		}
		path.add(root.data);
		
		if(root.data == data) {
			return true;
		}else if(root.left != null && findPath(root.left, data, path)) {
			return true;
		}else if(root.right != null && findPath(root.right, data, path)) {
			return true;
		}
		//Data is not present in the traversal path and hence removing the added element
		path.remove(path.size() -1);
		return false;
	 }
	// Iterate both the path of nodes and find out common element as ancestor.
	public static int getLCA(TreeNode root, int node1 , int node2) {
		//Intialize the empty path for noe1 and node2
		List<Integer> path1 = new ArrayList<Integer>();
		List<Integer> path2 = new ArrayList<Integer>();
		
		if(!findPath(root, node1, path1) || !findPath(root, node2, path2)) {
			if(path1.size() > 0) {
				System.out.println("Node1 is present and Node2 is not present");
			}else {
				System.out.println("Node2 is present and Node1 is not present");
			}
			return -1;
		}
		
		int i=0;
		while(i<path1.size() && i<path2.size()) {
			if(!path1.get(i).equals(path2.get(i))){
				return path1.get(i-1);
			}
			i++;
		}
		return path1.get(i-1);
		
	}
}
