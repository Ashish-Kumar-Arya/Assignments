package com.example.java;

class Node {
	int key;
	Node left, right;
	public Node(int key) {
		this.key=key;
		this.left=null;
		this.right=null;
	}
}

public class BinarySearchTree {
	Node root;
	
	public BinarySearchTree() {
		this.root=null;
	}
	
	// insert node
	public void insert(int key) {
		root = inserting(root, key);
	}
	
	
	
	Node inserting(Node root, int key) {
		// TODO Auto-generated method stub
		if(root==null) {
				root=new Node(key);
				return root;
		}
		else if(root.key>key) {
			root.left=inserting(root.left, key);
		}
		else if(root.key<key){
			root.right=inserting(root.right, key);
		}
		return root;
	}

	static void inorder(Node root) {
		if(root!=null) {
			inorder(root.left);
			System.out.print(root.key+" ");
			inorder(root.right);
		}
	}
	
	static void preorder(Node root) {
		if(root!=null) {
			System.out.print(root.key+" ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	static void postorder(Node root) {
		if(root!=null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.key+" ");
		}
	}
	
	static boolean search(Node root, int key) {
		if(root==null) {
			return false;
		}
		else if(root.key==key) {
			return true;
		}
		return key<root.key?search(root.left,key):search(root.right,key);
	}
	
	static Node delete(Node root, int key) {
		if(root==null) {
			return root;
		}
		else if(key<root.key) {
			root.left=delete(root.left,key);
		}
		else if(key>root.key) {
			root.right=delete(root.right,key);
		}
		else {
			if(root.left==null) {
				return root.right;
			}
			else if(root.right==null) {
				return root.left;
			}
		}
		return root;
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(40);
		bst.insert(10);
		bst.insert(20);
		bst.insert(30);
		bst.insert(100);
		bst.insert(60);
		bst.insert(15);
		bst.insert(150);
		System.out.print("Inorder: ");
		inorder(bst.root);
		System.out.println();
		System.out.print("Preorder: ");
		preorder(bst.root);
		System.out.println();
		System.out.print("Postorder: ");
		postorder(bst.root);
		System.out.println();
		System.out.println(bst.search(bst.root, 8));
	}
	
}