package algorithmEx;

class node {
	private int data;
	private node left;
	private node right;
	
	public node(int data) {
		this.setData(data);
		setLeft(null);
		setRight(null);
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public node getLeft() {
		return left;
	}

	public void setLeft(node left) {
		this.left = left;
	}

	public node getRight() {
		return right;
	}

	public void setRight(node right) {
		this.right = right;
	}
}

public class binarySearchTree {
	public node root;
	public binarySearchTree() {
		this.root = null;
	}
	
	public boolean find(int id) {
		node current = root;
		while(current!=null) {
			if(current.getData()==id) {
				return true;
			} else if(current.getData()>id) {
				current = current.getLeft();
			} else {
				current = current.getRight();
			}
		}
		return false;
	}
	
	public void insert(int id) {
		node newNode = new node(id);
		if(root==null) {
			root = newNode;
			return;
		}
		node current = root;
		node parent = null;
		while(true) {
			parent = current;
			if(id < current.getData()) {
				current = current.getLeft();
				if(current==null) {
					parent.setLeft(newNode);
					return;
				} else {
					current = current.getRight();
					if(current==null) {
						parent.setRight(newNode);
						return;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		binarySearchTree bts = new binarySearchTree();
		bts.insert(6);
		bts.insert(10);
		bts.insert(1);
		bts.insert(3);
		bts.insert(9);
		bts.insert(4);
		bts.insert(2);
		bts.insert(11);
		bts.insert(13);
		System.out.println(bts.find(222));
		System.exit(0);
	}

}
