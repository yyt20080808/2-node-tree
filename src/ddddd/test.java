package ddddd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class test {
	public static void createBinTree(TreeNode root) {
		TreeNode newNodeB = new TreeNode(2, "B");
		TreeNode newNodeC = new TreeNode(3, "C");
		TreeNode newNodeD = new TreeNode(4, "D");
		TreeNode newNodeE = new TreeNode(5, "E");
		TreeNode newNodeF = new TreeNode(6, "F");
		root.setLeftChild(newNodeB);
		root.setRightChild(newNodeC);
		root.getLeftChild().setLeftChild(newNodeD);
		root.getLeftChild().setRightChild(newNodeE);
		root.getRightChild().setRightChild(newNodeF);
	}

	public static void main(String[] args) throws IOException {
		TreeNode root = new TreeNode(1, "A");
		createBinTree(root);
		System.out.println("递归先序遍历： ");
		preorder(root);
		System.out.println("\n递归中序遍历： ");
		inorder(root);
		System.out.println();
		System.out.println("递归后序遍历： ");
		postorder(root);
		System.out.println("\nThe height is:" + getHeight(root));
		System.out.println("非递归先序遍历： ");
		iterativePreorder(root);
		System.out.println("\n非递归中序遍历： ");
		iterativeInorder(root);
		System.out.println("\n非递归后序遍历： ");
		iterativePostorder(root);
	}

	public static void iterativePreorder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root != null) {
			stack.push(root);
			while (!stack.empty()) {
				root = stack.pop();
				root.setVisted(true);
				System.out.print(root.getData());
				if (root.getRightChild() != null)
					stack.push(root.getRightChild());
				if (root.getLeftChild() != null)
					stack.push(root.getLeftChild());
			}
		}
	}

	public static void iterativeInorder(TreeNode p) {  
        Stack<TreeNode> stack = new Stack<TreeNode>();  
        TreeNode node = p;  
        while (node != null || stack.size() > 0) {  
            while (node != null) {  
                stack.push(node);  
                node = node.getLeftChild();  
            }  
            if (stack.size() > 0) {  
                node = stack.pop();  
                System.out.print(node.getData()); 
                node = node.getRightChild();  
            }  
        }  
    } 

	public static void iterativePostorder(TreeNode p){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = p,prev = p;
		while(node!=null || stack.size()>0){
			while(node!=null){
				stack.push(node);
				node = node.getLeftChild();
			}
			if(stack.size()>0){
				TreeNode temp = stack.peek().getRightChild();
				if(temp == null || temp == prev){
					node = stack.pop();
					System.out.print(node.getData());
					prev = node;  
                    node = null; 
				}else{
					node = temp;
				}
			}
		}
		
	}
	
	public static int getHeight(TreeNode root) {
		if (root != null) {
			int i = getHeight(root.getLeftChild());
			int j = getHeight(root.getRightChild());
			return (i > j) ? (i + 1) : (j + 1);
		} else
			return 0;
	}

	public static void preorder(TreeNode root) {
		if (root != null) {
			root.setVisted(true);
			System.out.print(root.getData());
			preorder(root.getLeftChild());
			preorder(root.getRightChild());
		}
	}

	public static void inorder(TreeNode root) {
		if (root != null) {
			root.setVisted(true);
			inorder(root.getLeftChild());
			System.out.print(root.getData());
			inorder(root.getRightChild());
		}
	}

	public static void postorder(TreeNode root) {
		if (root != null) {
			root.setVisted(true);
			postorder(root.getLeftChild());
			postorder(root.getRightChild());
			System.out.print(root.getData());
		}
	}
}
