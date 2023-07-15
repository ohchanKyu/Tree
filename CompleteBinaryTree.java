package tree;

import tree.BinarySearchTree.*;

public class CompleteBinaryTree {

	TreeNode head;
	int nodeCount;
	public CompleteBinaryTree() {
		nodeCount = 0;
		head = null;
	}
	
	public void insertNode(int key) {
		TreeNode newNode = new TreeNode();
		newNode.key = key;
		newNode.left = null;
		newNode.right = null;
		nodeCount++;
		if(nodeCount == 1) {
			newNode.index = 1;
			head = newNode;
		}else {
			newNode.index = nodeCount;
			int parentNum = nodeCount / 2;
			
			TreeNode ptr = searchIndexNode(head,parentNum);
			
			if(nodeCount%2==0) {
				ptr.left = newNode;
			}else {
				ptr.right = newNode;
			}
		}
	}
	
	public void deleteNode(CompleteBinaryTree tree,int nodeCount) {
		
		TreeNode head = tree.head;
		TreeNode deleteNode = searchIndexNode(head,nodeCount);
		TreeNode parentNode = searchIndexNode(head,nodeCount/2);
		
		if(parentNode.left == deleteNode) {
			parentNode.left = null;
		}else if(parentNode.right == deleteNode) {
			parentNode.right = null;
		}
		tree.nodeCount--;
	}
	
	
	public TreeNode searchIndexNode(TreeNode node,int index) {
		
		if(node == null) {
			return null;
		}else if(node.index == index) {
			return node;
		}
		TreeNode leftNode = searchIndexNode(node.left,index);
		if(leftNode != null && leftNode.index == index) {
			return leftNode;
		}
		TreeNode rightNode = searchIndexNode(node.right,index);
		if(rightNode != null && rightNode.index == index) {
			return rightNode;
		}else {
			return null;
		}
		
	}
	
	public void inOrder(TreeNode node) {
		if(node == null) {
			return;
		}else {
			inOrder(node.left);
			System.out.print("Data : "+node.key+" ");
			inOrder(node.right);
		}
	}
	
	public void adjust(TreeNode head,int index,int nodeCount) {
		
		int adjustKey = searchIndexNode(head,index).key;
		
		int j = 2*index;
		while(j<=nodeCount) {
			
			if(j<nodeCount) {
				int leftChildKey = searchIndexNode(head,j).key;
				int rightChildKey = searchIndexNode(head,j+1).key;
				if(leftChildKey < rightChildKey) {
					j++;
				}
			}
			if(adjustKey > searchIndexNode(head,j).key) {
				break;
			}
			searchIndexNode(head,j/2).key = searchIndexNode(head,j).key;
			j = j*2;
		}
		searchIndexNode(head,j/2).key = adjustKey;
	}
	
	public void heapSort(CompleteBinaryTree tree) {
		
		TreeNode head = tree.head;
		for(int i=(tree.nodeCount/2);i>=1;i--) {
			tree.adjust(head, i, tree.nodeCount);
		}
		for(int i=tree.nodeCount-1;i>=1;i--) {
			
			int tmp = searchIndexNode(head,i+1).key;
			System.out.print("Data : "+searchIndexNode(head,1).key+" ");
			searchIndexNode(head,1).key = tmp;
			tree.adjust(head,1,i);
		}
		System.out.print("Data : "+searchIndexNode(head,1).key+" ");
	}
}
