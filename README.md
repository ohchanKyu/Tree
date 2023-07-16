# Tree

  <h1 >여러 트리의 자료구조  트리를 활용한 알고리즘 </h1>
  <h2>트리 종류</h2>
  <h4> 1. Binary Tree </h4>
  <h4> 2. Binary Search Tree </h4>
  <h4> 3. Complete Binary Tree </h4>
  <h4> 4. Selection Tree - Winner Tree </h4>
  <h4> 5. Spanning Tree </h4>
  <h4> 6. Threaded Binary Tree </h4>

<br>
<h3> [Binary Tree] </h3>

<h4> #Node Class </h4>
<h5> class Attribute : data / Node left / Node right </h5>
<h5> class method : addLeft / addRight / deleteLeft / deleteRight </h5>

<h4> #BinaryTree Class </h4>
<h5> class Attribute : nodeCount / Node head(head node) </h5>
<h5> class method : addNode -> Before conneting the nodes, declare it as the node of the tree </h5>
<h5> class method : Inorder / Postorder / Preorder  -> Tree Traversal Algorithm </h5>
<h5> class method : copy -> Copy an existing tree to a new tree </h5>
<h5> class method : equals -> Compare whether the two trees are the same </h5>
<br>
<h3> [Binary Search Tree] </h3>

<h4> #TreeNode Class </h4>
<h5> class Attribute : key / TreeNode left / TreeNode right / index / runIndex</h5>

<h4> #Binary Search Tree Class </h4>
<h5> class Attribute : TreeNode head(head node) / nodeCount / indexNum </h5>
<h5> class method : insertNode / adjustIndex -> insert newNode and Index is given according to the Inorder traversal </h5>
<h5> class method : search ->  Find the same value as the key that the user wants and returns the index of the node (Using recursion) </h5>
<h5> class method : deleteNode -> Delete Node that user wants </h5>
<h5> class method : maxNode / minNode -> return the largest key and the smallest key in the tree </h5>
<h5> class method : Inorder / Postorder / Preorder  -> Tree Traversal Algorithm </h5>
