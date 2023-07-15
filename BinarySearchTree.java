package tree;

class TreeNode
{
	int key;
	int index;
	int runIndex;
	TreeNode left;
	TreeNode right;
}

public class BinarySearchTree {
	
	TreeNode head;
	int nodeCount;
	int indexNum;
	
	public BinarySearchTree() {
		head = null;
		nodeCount = 0;
	}
	
	public void insertNode(int data) {
		
		indexNum = 1;
		TreeNode newNode = new TreeNode();
		newNode.key = data;
		newNode.left = null;
		newNode.right = null;
		
		if(nodeCount == 0) {
			head = newNode;
		}else {
			TreeNode tmp = head;
			TreeNode preTmp = null;
			while(tmp != null) {
				preTmp = tmp;
				if(tmp.key > data) {
					tmp = tmp.left;
				}else {
					tmp = tmp.right;
				}
			}
			if(preTmp.key < data) {
				preTmp.right = newNode;
			}else {
				preTmp.left = newNode;
			}
		}
		nodeCount++;
		adjustIndex(head);
	}
	
	public void adjustIndex(TreeNode node) {
		if(node == null) {
			return;
		}else {
			adjustIndex(node.left);
			node.index = indexNum++;
			adjustIndex(node.right);
		}
	}
	
	public int search(TreeNode head,int key) {
		
		TreeNode tmp = head;
		if(tmp == null) {
			System.out.println("찾는 값이 존재하지 않습니다");
			return -1;
		}
		if(tmp.key == key) {
			return tmp.index;
		}
		else if(tmp.key > key) {
			return search(tmp.left,key);
		}else {
			return search(tmp.right,key);
		}
	}
	
	public void deleteNode(TreeNode node,int key) {
		
		TreeNode tmp  = node;
		TreeNode preTmp = null;
		while(tmp!=null) {
			if(tmp.key == key) {
				break;
			}else if(tmp.key > key) {
				preTmp = tmp;
				tmp = tmp.left;
			}else {
				preTmp = tmp;
				tmp = tmp.right;
			}
		}
		if(tmp == null) {
			System.out.println("삭제원소가 존재하지 않습니다.");
			return;
		}
		if(tmp.left == null && tmp.right == null) {
			if(preTmp == null) {
				
			}
			if(preTmp.left == tmp) {
				preTmp.left = null;
			}else {
				preTmp.right = null;
			}
		}else if(tmp.left == null || tmp.right == null) {
			
			if(preTmp.left == tmp) {
				if(tmp.left == null) {
					preTmp.left = tmp.right;
				}else {
					preTmp.left = tmp.left;
				}
				
			}else {
				if(tmp.left == null) {
					preTmp.right = tmp.right;
				}else {
					preTmp.right = tmp.left;
				}
			}
		}else {
			TreeNode ptr = maxNode(tmp.left);
			int changeNum = ptr.key;
			deleteNode(tmp,ptr.key);
			tmp.key = changeNum;
		}
	}
	
	public TreeNode maxNode(TreeNode node) {
		
		TreeNode ptr = node;
		while(ptr.right!=null) {
			ptr = ptr.right;
		}
		return ptr;
	}
	
	public TreeNode minNode(TreeNode node) {
		
		TreeNode ptr = node;
		while(ptr.left != null) {
			ptr = ptr.left;
		}
		return ptr;
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
	
	public void postOrder(TreeNode node) {
		if(node == null) {
			return;
		}else {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print("Data : "+node.key+" ");
		}
	}
	
	public void preOrder(TreeNode node) {
		if(node == null) {
			return;
		}else {
			System.out.print("Data : "+node.key+" ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}
}
