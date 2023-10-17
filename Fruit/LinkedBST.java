//Daniel Chavez
public class LinkedBST <T extends Comparable<T>> {
	private class Node {
		T data;
		Node leftChild;
		Node rightChild;
		public Node(T aData) {
			data = aData;
			leftChild = rightChild = null;
		}
	}
	private Node root;
	public LinkedBST() {
		root = null;
	}
	//add to tree
	public void add(T aData) {
		if(root==null)
			root = new Node(aData);
		else
			add(root,aData);
	}
	private Node add(Node aNode, T aData) {
		if(aNode == null)
			aNode = new Node(aData);
		else if(aData.compareTo(aNode.data) < 0)//go left
			aNode.leftChild = add(aNode.leftChild,aData);
		else if(aData.compareTo(aNode.data) > 0)
			aNode.rightChild = add(aNode.rightChild,aData);
		return aNode;
	}
	//print in preorder
	public void printPreorder() {
		printPreorder(root);
	}
	//print in post order
	public void printPostorder() {
		printPostorder(root);
	}
	private void printPostorder(Node aNode) {
		if(aNode == null)
			return;
		printInorder(aNode.leftChild);
		printInorder(aNode.rightChild);
		System.out.println(aNode.data);
	}
	//print in pre order
	private void printPreorder(Node aNode) {
		if(aNode == null)
			return;
		System.out.println(aNode.data);
		printPreorder(aNode.leftChild);
		printPreorder(aNode.rightChild);
	}
	//print in order
	public void printInorder() {
		printInorder(root);
	}
	private void printInorder(Node aNode) {
		if(aNode == null)
			return;
		printInorder(aNode.leftChild);
		System.out.println(aNode.data);
		printInorder(aNode.rightChild);
	}
	//returns true if data is in tree
	public boolean search(T aData) {
		return search(root,aData);
	}
	public boolean search(Node aNode, T aData) {
		if(aNode == null)
			return false;
		else if(aData.compareTo(aNode.data) < 0)
			return search(aNode.leftChild, aData);
		else if(aData.compareTo(aNode.data) > 0)
			return search(aNode.rightChild, aData);
		else
			return true;
	}
	//removes instance of parameter from tree
	public void remove(T aData) {
		root = remove(root, aData);
	}
	private Node remove(Node aNode, T aData) {
		if(aNode == null)
			return null;
		else if(aData.compareTo(aNode.data) < 0)
			aNode.leftChild = remove(aNode.leftChild,aData);
		else if(aData.compareTo(aNode.data) > 0)
			aNode.rightChild = remove(aNode.rightChild,aData);
		else {
			if(aNode.rightChild == null)
				return aNode.leftChild;
			else if(aNode.leftChild == null)
				return aNode.rightChild;
			Node temp = findMinInTree(aNode.rightChild);
			aNode.data = temp.data;
			aNode.rightChild = remove(aNode.rightChild, temp.data);
			aNode.rightChild = remove(aNode.rightChild, temp.data);
		}
		return aNode;
	}
	//returns minimum value in tree
	private Node findMinInTree(Node aNode) {
		if(aNode == null)
			return null;
		else if(aNode.leftChild == null)
			return aNode;
		else
			return findMinInTree(aNode.leftChild);
	}
}