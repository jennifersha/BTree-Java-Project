import java.util.List;
public class Node<E> {
	E data; //represent a single organ in a binary tree
	Node<E> leftson;
	Node<E> rightson;

	//accept node values ​​(information, right and left) and place them in attributes.
	public Node(E data, Node<E> left, Node<E> right) {
		this.data=data;
		this.leftson=left;
		this.rightson=right;
	}

	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}
	public Node<E> getLeftson() {
		return leftson;
	}
	public void setLeftson(Node<E> leftson) {
		this.leftson = leftson;
	}
	public Node<E> getRightson() {
		return rightson;
	}
	public void setRightson(Node<E> rightson) {
		this.rightson = rightson;
	}
}
