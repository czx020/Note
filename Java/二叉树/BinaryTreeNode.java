package shiyan7;

public  class BinaryTreeNode<T> {
	private T data;  /* ����������T����ʵ����Ҫ������ */
	BinaryTreeNode<T> leftChild; /* ����������ָ������ ����*/
	BinaryTreeNode<T> rightChild; /* �����Һ�����ָ���Һ��Ӷ��� */

	public BinaryTreeNode(){

	}

	public BinaryTreeNode(T data){
		this.data = data;
                this.leftChild = null;
                this.rightChild = null;
	}


	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public BinaryTreeNode<T> getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(BinaryTreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}
	public BinaryTreeNode<T> getRightChild() {
		return rightChild;
	}
	public void setRightChild(BinaryTreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}
}
