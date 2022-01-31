package com.lab3.main;

import java.util.ArrayList;

public class FindLongestPath {
	static class Node{
		Node leftNode;
		Node rightNode;
		int nodeData;
	};
	static Node newNode(int nodeData) {
		Node temp = new Node();
		temp.nodeData = nodeData;
		temp.leftNode = null;
		temp.rightNode = null;
		return temp;
	}
	
	public static ArrayList<Integer> findLongestPath(Node root)
	{
		if(root==null) {
			ArrayList<Integer> output = new ArrayList<>();
			return output;
		}
		
		ArrayList<Integer> rightArray = findLongestPath(root.rightNode);
		ArrayList<Integer> leftArray = findLongestPath(root.leftNode);
		
		if(rightArray.size()<leftArray.size())
		{
			leftArray.add(root.nodeData);
		}
		else 
		{
			rightArray.add(root.nodeData);
		}
		
		return(leftArray.size()>rightArray.size()?leftArray:rightArray);
		
	}
		public static void main(String[] args)
		{
			Node root = newNode(100);
			root.leftNode = newNode(20);
			root.rightNode = newNode(130);
			root.leftNode.leftNode = newNode(10);
			root.leftNode.rightNode = newNode(50);
			root.rightNode.leftNode = newNode(110);
			root.rightNode.rightNode = newNode(140);
			root.leftNode.leftNode.leftNode = newNode(5);
			ArrayList<Integer> output = findLongestPath(root);
			int size = output.size();
			System.out.print("Longest path "+output.get(size-1));
			for(int i=size-2;i>=0;i--) 
			{
				System.out.print(" -> "+output.get(i));
			}
		}
}
