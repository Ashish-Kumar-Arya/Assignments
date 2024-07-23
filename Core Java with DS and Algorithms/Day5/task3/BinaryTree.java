package assignments.day5.task3;

import java.util.Scanner;

public class BinaryTree {
    static Scanner sc=null;

    public static Node createNode() {
        Node root=null;
        System.out.println("Enter the data: ");
        int data=sc.nextInt();
        if(data==-1) {
            return null;
        }
        root=new Node(data);

        System.out.println("Enter left for "+data);
        root.left=createNode();

        System.out.println("Enter right for "+data);
        root.right=createNode();

        return root;
    }

    public static int height(Node root) {
        if(root==null) {
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }

public static boolean check(Node root) {
    if(root==null) {
        return true;
    }

   int lh=height(root.left);
   int rh=height(root.right);
   if(Math.abs(rh-lh)>1) {
    return false;
   }
   boolean left=check(root.left);
   boolean right=check(root.right);
   if(!left||!right) {
    return false;
   }
   return true;
}

    public static void main(String[] args) {
        sc=new Scanner(System.in);
        Node root = createNode();
        System.out.println();
        if(check(root)) {
            System.out.println("Tree is balanced.");
        }
        else {
            System.out.println("Tree is not balanced.");
        }
    }
}

class Node {
    Node left, right;
    int data;
    public Node(int data) {
        this.data=data;
    }
}