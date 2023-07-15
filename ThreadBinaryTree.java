package tree;

import java.util.*;

class ThreadNode
{
	char data;
	int LBit;
	int RBit;
	int leftThread;
	int rightThread;
	ThreadNode Rlink;
	ThreadNode Llink;
}

class ThreadTree
{
	ThreadNode head;
	int insertCount;
	public ThreadTree() {
		head = new ThreadNode();
		head.data = 0;
		head.LBit = 0;
		head.RBit = 1;
		head.Llink = null;
		head.Rlink = head;
		insertCount = 0;
	}
	public ThreadNode insertNode(char data) {
		
		ThreadNode newNode = new ThreadNode();
		newNode.data = data;
		newNode.LBit = 0;
		newNode.RBit = 0;
		newNode.Rlink = null;
		newNode.Llink = null;
		newNode.leftThread = 0;
		newNode.rightThread = 0;
		if(head.LBit == 0) {
			head.Llink = newNode;
			head.LBit = 1;
		}
		insertCount++;
		return newNode;
	}
	public void addLeft(ThreadNode parentNode,ThreadNode newNode) {
		
		parentNode.Llink = newNode;
		parentNode.LBit = 1;
	}
	public void addRight(ThreadNode parentNode,ThreadNode newNode) {
		
		parentNode.Rlink = newNode;
		parentNode.RBit= 1;
	}
	
	public void inOrder(ThreadNode node,LinkedList<Object> list) {
		if(node == null || node == head) {
			return;
		}else if(node.rightThread == 1 || node.leftThread == 1) {
			return;
		}
		else {
			inOrder(node.Llink,list);
			list.add((char)node.data);
			inOrder(node.Rlink,list);
		}
	}
	
	public ThreadNode searchNode(ThreadNode node,char key) {
		if((node.leftThread == 1 || node.rightThread == 1) && node.data != key) {
			return null;
		}else if((node.leftThread == 1 || node.rightThread == 1)&& node.data == key) {
			return node;
		}else if(node.data == key) {
			return node;
		}else {
			ThreadNode leftNode = searchNode(node.Llink,key);
			if(leftNode != head && leftNode != null && leftNode.data == key) {
					return leftNode;
			}
			ThreadNode rightNode = searchNode(node.Rlink,key);
			if(rightNode != head && rightNode != null && rightNode.data == key) {
				return rightNode;
			}
			return null;
		}
	}
	public ThreadNode Insuccessor(ThreadNode node) {
	
		ThreadNode rightNode = node.Rlink;
		if(node.RBit == 1) {
			while(rightNode.LBit == 1) {
				rightNode = rightNode.Llink;
			}
		}
		return rightNode;
	}
	public ThreadNode predecessor(char data) {
		ThreadNode node = searchNode(head.Llink,data);
		
		ThreadNode leftNode = node.Llink;
		if(node.LBit == 1) {
			while(leftNode.RBit == 1) {
				leftNode = leftNode.Rlink;
			}
		}
		return leftNode;
	}
	public void printTree() {
		ThreadNode node = leftMostNode(head.Llink);
		System.out.println("Data : "+node.data);
		while(true) {
			node = Insuccessor(node);
			if(node==head) {
				return;
			}
			System.out.println("Data : "+node.data);
		}
	}
	public ThreadNode leftMostNode(ThreadNode node) {
		
		while(node!=head && node.Llink != head) {
			node = node.Llink;
		}
		return node;
	}
}

public class ThreadBinaryTree {

	public static void threadSet(ThreadTree tree) {
		LinkedList<Object> list = new LinkedList<>();
		tree.inOrder(tree.head.Llink, list);
		
		for(int i=0;i<list.size();i++) {
			ThreadNode node = tree.searchNode(tree.head.Llink,(char)list.get(i));
			if(node.LBit == 0) {
				if(i==0) {
					node.Llink = tree.head;
					node.leftThread = 1;
				}else {
					ThreadNode leftNode = tree.searchNode(tree.head.Llink,(char)list.get(i-1));
					node.Llink = leftNode;
					node.leftThread = 1;
				}
			}
			if(node.RBit == 0) {
				if(i==list.size()-1) {
					node.Rlink = tree.head;
					node.rightThread = 1;
				}else {
					ThreadNode rightNode = tree.searchNode(tree.head.Llink,(char)list.get(i+1));
					node.Rlink = rightNode;
					node.rightThread = 1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		ThreadTree tree = new ThreadTree();
		ThreadNode node1 = tree.insertNode('A');
		ThreadNode node2 = tree.insertNode('B');
		ThreadNode node3 = tree.insertNode('C');
		ThreadNode node4 = tree.insertNode('D');
		ThreadNode node5 = tree.insertNode('E');
		ThreadNode node6 = tree.insertNode('F');
		ThreadNode node7 = tree.insertNode('G');
		ThreadNode node8 = tree.insertNode('H');
		ThreadNode node9 = tree.insertNode('I');
		ThreadNode node10 = tree.insertNode('J');
		ThreadNode node11 = tree.insertNode('K');
		tree.addLeft(node1, node2);
		tree.addRight(node1, node3);
		tree.addLeft(node2, node4);
		tree.addRight(node2, node5);
		tree.addLeft(node3, node6);
		tree.addRight(node3, node7);
		tree.addLeft(node4, node8);
		tree.addRight(node4, node9);
		tree.addLeft(node8, node10);
		tree.addLeft(node6, node11);
		
		threadSet(tree);
		tree.printTree();
	}

}
