package tree;

class Node {
	
	Object data;
	Node left;
	Node right;
	
	public Node(Object data) {
		this.data = data;
		left = null;
		right = null;
	}
	
	public void addLeft(Node node) {	
		left = node;
	}
	public void addRight(Node node) {
		right = node;
	}
	public void deleteLeft() {
		left = null;
	}
	public void deleteRight() {
		right = null;
	}
}

public class BinaryTree {
	
	int nodeCount;
	Node head;
	
	public BinaryTree() {
		nodeCount = 0;
		head = null;
	}

	public Node addNode(Object data) {
		
		Node newNode = new Node(data);
		nodeCount++;
		if(nodeCount == 1) {
			head = newNode;
		}
		return newNode;
	}
	
	public void inOrder(Node node) {
		if(node == null) {
			return;
		}else {
			inOrder(node.left);
			System.out.print("Data : "+node.data+" ");
			inOrder(node.right);
		}
	}
	
	public void postOrder(Node node) {
		if(node == null) {
			return;
		}else {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print("Data : "+node.data+" ");
		}
	}
	
	public void preOrder(Node node) {
		if(node == null) {
			return;
		}else {
			System.out.print("Data : "+node.data+" ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	public Node copy(Node node, BinaryTree newTree) {
		
		if(node == null) {
			return null;
		}else {
			
			Node leftNode = copy(node.left,newTree);
			if(leftNode != null) {
				node.addLeft(leftNode);
			}
			Node rightNode = copy(node.right,newTree);
			if(rightNode != null) {
				node.addRight(rightNode);
			}
			return node;
		}
	}
	
	public boolean eqauls(Node tree1,Node tree2) {
		
		boolean answer = false;
		if(tree1==null && tree2==null) {
			answer = true;
		}else if(tree1 != null && tree2 != null) {
			answer = eqauls(tree1.left,tree2.left);
			if(answer) {
				eqauls(tree1.right,tree2.right);
			}
		}
		return answer;
	}
	
	
}
