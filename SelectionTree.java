package tree;

import java.util.*;
import tree.CompleteBinaryTree;

class Run
{
	int index;
	Stack<Integer> stack = new Stack<>();
	int maxNum;
	
	public Run(int index) {
		this.index = index;
	}
	public void insertData(int data) {
		if(data > maxNum) {
			maxNum = data;
		}
		stack.push(data);
	}
	public int getData() {
		if(!stack.isEmpty()) {
			return stack.pop();
		}else {
			return maxNum+1;
		}
	}
}

public class SelectionTree {
	
	int runCount;
	TreeNode head;
	int nodeCount;
	int depthMinNode;
	int depthMaxNode;
	
	public SelectionTree(int runCount,Run run[]) {
		this.runCount = runCount;
		head = null;
		nodeCount = 0;
		int depth = (int)(Math.log(runCount) / Math.log(2))+1;
		int nodeNumber = (int)Math.pow(2, depth)-1;
		while(nodeCount<nodeNumber) {
			insertNode(-1);
		}
		int depthMinNode = (int)Math.pow(2,depth-1);
		this.depthMinNode = depthMinNode;
		this.depthMaxNode = nodeNumber;

		for(int i=depthMinNode,j=0;i<=nodeNumber;i++,j++) {
			TreeNode tmp = searchIndexNode(head,i);
			tmp.key = run[j].getData();
			tmp.runIndex = run[j].index;
		}
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
	
	public void winnerTree(TreeNode node,Run run[],int maxNum) {
		
		int startNumber = this.depthMaxNode;
		int depthMinNumber = this.depthMinNode;
		while(startNumber >= 3) {
			TreeNode ptr = searchIndexNode(node,startNumber);
			TreeNode ptr2 = searchIndexNode(node,startNumber-1);
			
			searchIndexNode(node,startNumber/2).key = ptr.key <= ptr2.key ? ptr.key : ptr2.key;
			searchIndexNode(node,startNumber/2).runIndex = ptr.key <= ptr2.key ? ptr.runIndex : ptr2.runIndex;
			startNumber -=2;
			
		}
		int winnerNum = searchIndexNode(head,1).key;
		int winnerIndex = searchIndexNode(head,1).runIndex;
		if(winnerNum == maxNum) {
			System.out.println("Winner : "+winnerNum);
			return;
		}else {
			System.out.println("Winner : "+winnerNum);
			searchIndexNode(head,depthMinNumber+winnerIndex-1).key = run[winnerIndex-1].getData();
			winnerTree(node,run,maxNum);
		}
	}
}
