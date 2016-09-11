package ddddd;

public class TreeNode {
	private int key = 0;
	private String data = null;
	private boolean isVisted = false;
	private TreeNode leftChild = null;
	private TreeNode rightChild = null;

	public TreeNode() {
	}

	/**
	 * @param key
	 *            层序编码
	 * @param data
	 *            数据域
	 */
	public TreeNode(int key, String data) {
		this.key = key;
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public boolean isVisted() {
		return isVisted;
	}

	public void setVisted(boolean isVisted) {
		this.isVisted = isVisted;
	}

	public TreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}
	

}
