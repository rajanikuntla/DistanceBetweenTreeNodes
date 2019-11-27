package com.node_distance;

import java.util.ArrayList;

public class BinaryTreeManipulations {
	
	public static int INDEX = -1;
	public static int LEVEL = -1;
	
	/*
	 * Inserts the given node data into a tree
	 */
	public static BinaryTree insert(String nodeElements, String nodeSpecs, BinaryTree tempTree) {
		String[] nodes = nodeElements.split(" ");
		String[] nodeSpec = nodeSpecs.split(" ");
		tempTree = preOrder(nodes, nodeSpec);
		assignLevelsAndNthNodeValues(tempTree, 0, 1);
		return tempTree;
	}

	/*
	 * Pre order data is requested with nulls as tree cannot be created with 
	 * only one order. So the array with N,L specifies whether it is node or leaf
	 * and in the same manner constructs the tree.
	 */
	public static BinaryTree preOrder(String[] nodes, String[] nodeSpec) {
		BinaryTree tree = new BinaryTree();
		++INDEX;
		if(nodes.length > INDEX) {
			if(nodes.length > INDEX && nodes[INDEX].equals("null")) {
				return null;
			} 
			tree.setData(Integer.parseInt(nodes[INDEX]));
			if(nodeSpec[INDEX].equals("N"))
				tree.setLeaf(false);
			else 
				tree.setLeaf(true);
			if(nodeSpec[INDEX].equals("N")) {
				BinaryTree temp = new BinaryTree();
				temp = preOrder(nodes, nodeSpec);
				if( temp == null)
					tree.setLeftNode(null);
				else
					tree.setLeftNode(temp);
				temp = preOrder(nodes, nodeSpec);
				if(temp == null)
					tree.setRightNode(null);
				else
					tree.setRightNode(temp);
			}
			return tree;
		}
		return tree;
	}
	
	/*
	 * Assigns the node level and which element it is in that level
	 */
	public static void assignLevelsAndNthNodeValues(BinaryTree head, int level, int nThNode) {
		if(head == null)
			return;
		head.setLevel(level);
		head.setnThNode(nThNode);
		if(!head.isLeaf()) {
			if(head.getLeftNode() != null)
				assignLevelsAndNthNodeValues(head.getLeftNode(), level+1, (nThNode*2 - 1));
			if(head.getRightNode() != null)
				assignLevelsAndNthNodeValues(head.getRightNode(), level+1, (nThNode*2));
		}
	}

	/*
	 * Checks the distance between the given two nodes
	 */
	public static boolean checkTheDistance(String[] nodeData, BinaryTree head) {
		int nodeData1 = Integer.parseInt(nodeData[0]);
		int nodeData2 = Integer.parseInt(nodeData[1]);
		ArrayList<BinaryTree> nodes = searchForNode(nodeData1, nodeData2, head, new ArrayList<BinaryTree>());
		
		BinaryTree node1, node2;
		
		node1 = nodes.get(0);
		node2 = nodes.get(1);
		
		if(node1.getLevel() == node2.getLevel()) {
			int distance = 0;
			if(node1.getnThNode() < node2.getnThNode()) {
				distance = node2.getnThNode() - node1.getnThNode() - 1;
			} else {
				distance = node1.getnThNode() - node2.getnThNode() - 1;
			}
			System.out.println("Distance between the two nodes is "
					+ "-> " + (distance == -1 ? "0" : distance));
			
			return true;
		}
		return false;
		
	}
	
	/*
	 * Searches for the node elements in the tree
	 */
	public static ArrayList<BinaryTree> searchForNode(int node1, int node2, BinaryTree head, ArrayList<BinaryTree> nodes) {
		if(head.getData() == node1 || head.getData() == node2) {
			nodes.add(head);
		} else if(nodes.size() < 2) {
			if(head.getLeftNode() != null)
				searchForNode(node1, node2, head.getLeftNode(),nodes);
			if(head.getRightNode() != null)
				searchForNode(node1, node2, head.getRightNode(),nodes);
		}
		return nodes;
	}

}
