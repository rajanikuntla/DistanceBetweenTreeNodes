package com.node_distance;

public class BinaryTree {
	
	private int data;
	private BinaryTree leftNode;
	private BinaryTree rightNode;
	private int level;
	private int nThNode;
	private boolean isLeaf;
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public BinaryTree getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(BinaryTree leftNode) {
		this.leftNode = leftNode;
	}
	public BinaryTree getRightNode() {
		return rightNode;
	}
	public void setRightNode(BinaryTree rightNode) {
		this.rightNode = rightNode;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getnThNode() {
		return nThNode;
	}
	public void setnThNode(int nThNode) {
		this.nThNode = nThNode;
	}
	public boolean isLeaf() {
		return isLeaf;
	}
	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	
}
