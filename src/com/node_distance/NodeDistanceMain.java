package com.node_distance;

import java.util.Scanner;

public class NodeDistanceMain {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please provide the tree elements in pre order "
				+ "and also place \"null\" if it doesn't have any child "
				+ "along with spaces between each element.\n"
				+ "Also provide an array which specifies whehter the node is leaf or node "
				+ "with \"N\" for node and \"L\" for leaf.\n"
				+ "Sample Input: 5 2 7 null 3\n"
				+ "		N N L L L");
		
		String nodeElements = in.nextLine();
		String nodeSpecs = in.nextLine();
		
		BinaryTree head = BinaryTreeManipulations.insert(nodeElements, nodeSpecs, new BinaryTree());
		
		System.out.println("Enter the nodes whose distance has to be checked");
		
		String tempNodes = in.nextLine();
		String[] nodes = tempNodes.split(" ");
		
		if(BinaryTreeManipulations.checkTheDistance(nodes, head))
			System.out.println("Task Completed...");
		else
			System.out.println("Please provide the nodes which are at same levels"
					+ " or else provide a valid pre order of the tree with correct N and L values");
	}

}
