//Daniel Chavez
public class LinkedBST {
	int size;
	public static final double PI = 3.14159265358979;
	public static final String TAB = "\t";
	private class Node {
		Shape shape;
		Node leftChild;
		Node rightChild;
		public Node(Shape shape) {
			this.shape = shape;
			leftChild = rightChild = null;
		}
	}
	private Node root;
	public LinkedBST(){
		root = null;
		size = 0;
	}
	//adds shapes
	public void add(Shape shape) {
		if(root == null) {
			root = new Node(shape);
			size++; }
		else
			add(root, shape);
	}
	private Node add(Node node, Shape shape) {
		if(node == null)
			node = new Node(shape);
		else if(shape.compareTo(node.shape)<0){//go left
			node.leftChild = add(node.leftChild,shape);
			size++;}
		else if(shape.compareTo(node.shape)>0) {
			node.rightChild = add(node.rightChild,shape);
			size++;}
		return node;
	}
	//print in preorder
	public void printPreorder() {
		printPreorder(root);
	}
	private void printPreorder(Node node) {
		if(node == null)
			return;
		System.out.println(node.shape);
		printPreorder(node.leftChild);
		printPreorder(node.rightChild);
	}
	// print in order
	public void printInorder() {
		printInorder(root);
	}
	private void printInorder(Node node) {
		if(node == null)
			return;
		printInorder(node.leftChild);
		System.out.println(node.shape);
		printInorder(node.rightChild);
	}
	//search
	public boolean search(Shape shape) {
		return search(root,shape);
	}
	//triangle search
	public boolean triangleSearch( Shape shape, double base, double height) {
		double area = (0.5)*base*height;
		Shape temp = new Shape("right triangle", area);
		return search(temp);
	}
	//rectangle search
	public boolean rectangleSearch( Shape shape, double length, double width) {
		double area = (0.5) * length * width;
		Shape temp = new Shape("rectangle", area);
		return search(temp);
	}
	//circle search
	public boolean circleSearch( Shape shape, double radius) {
		double area = radius * radius * PI;
		Shape temp = new Shape("circle", area);
		return search(temp);
	}
	//search
	public boolean search(Node node, Shape shape) {
		if(node == null)
			return false; 
		else if(shape.compareTo(node.shape) < 0)
			return search(node.leftChild, shape);
		else if(shape.compareTo(node.shape) > 0)
			return search(node.rightChild, shape);
		else
			return true;
	}
	//remove
	public void remove(Shape shape) {
		root = remove(root, shape);
	}
	private Node remove(Node node, Shape shape) {
		if(node == null)
			return null;
		else if(shape.compareTo(node.shape) < 0) {
			node.leftChild = remove(node.leftChild,shape);
		}
		else if(shape.compareTo(node.shape) > 0) {
			node.rightChild = remove(node.rightChild,shape);
			size--;
		}
		else {
			if(node.rightChild == null)
				return node.leftChild;
			else if(node.leftChild == null)
				return node.rightChild;
			Node temp = findMinInTree(node.rightChild);
			node.shape = temp.shape;
			node.rightChild = remove(node.rightChild, temp.shape);
			node.rightChild = remove(node.rightChild, temp.shape);
		}
		return node;
	}
	//remove triangle
	public void triangleRemove( Shape shape, double base, double height) {
		double area = (0.5) * base * height;
		Shape temp = new Shape("right triangle", area);
		remove(temp);
		size--;
	}
	//remove rectangle
	public void rectangleRemove( Shape shape, double length, double width) {
		double area = (0.5) * length * width;
		Shape temp = new Shape("rectangle", area);
		remove(temp);
		size--;
	}
	//remove circle
	public void circleRemove( Shape aShape, double xRadius) {
		double area = xRadius*xRadius*PI;
		Shape temp = new Shape("circle", area);
		remove(temp);
		size--;
	}
	//find minimum in tree
	private Node findMinInTree(Node node) {
		if(node == null)
			return null;
		else if (node.leftChild == null)
			return node;
		else 
			return findMinInTree(node.leftChild);
	}
	//find max
	public double findMax() {
		return findMaxInTree(root).shape.getArea();
	}
	
	public Node findMaxInTree(Node node) {
		if(node == null)
			return null;
		else if (node.rightChild == null)
			return node;
		else 
			return findMaxInTree(node.rightChild);
	}
	
}
	
	
	

