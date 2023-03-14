public class BTree<E> {
	Node<E> root;
	int size;

	//An empty constructor that will reset the root to null and size to 0.
	public BTree() {
		this.root = null;
		this.size = 0;
	}
//The method will add a new node that has edited data to the tree.
	public void addByPath(E data, String path) throws InvalidPathException {
		if (path == null)
			return;
		String new_path = "";
		if (root==null) {
			if(path.length() == 0) {
			root=new Node<E>(data, null, null);
			root.setData(data);
					return;
			}
			else 
				throw new InvalidPathException();
		}
//		Node<E> temp=new Node(root.getData(), root.getLeftSon(), root.getRightSon());
		Node<E> temp=root;
		if(path.length()==1) {
			if (path.charAt(0) == 'R' && temp.getRightson() == null) {
//				temp.setRightSon(new Node<E>(data, null, null));
//				temp = save.rightSon;
				temp.rightson=new Node<E>(data, null, null);
//				temp.setRightSon(new Node<E>(data, null, null));
				temp = temp.rightson;
				temp.setData(data);
			}
			else if (path.charAt(0) == 'L' && temp.getLeftson() == null) {
				temp.leftson=new Node<E>(data, null, null);
//				temp.setLeftSon(new Node<E>(data, null, null));
				temp = temp.leftson;
				temp.setData(data);
			} else
				throw new InvalidPathException();
			return;
		}
		for (int i = 0; i < path.length(); i++) {
			if (path.charAt(i) != 'R' && path.charAt(i) != 'L')
				throw new InvalidPathException();
			if (i != path.length() - 1)
				new_path += path.charAt(i);
		}
		for (int i = 0; i < new_path.length(); i++) {
			if (path.charAt(i) == 'R' && temp.getRightson() != null)
				temp = temp.rightson;
			else if (path.charAt(i) == 'L' && temp.getLeftson() != null)
				temp = temp.leftson;
			else
				throw new InvalidPathException();
		}
		if (path.charAt(path.length() - 1) == 'R' && temp.getRightson() == null) {
			temp.rightson=new Node<E>(data, null, null);
//			temp.setRightSon(new Node<E>(data, null, null));
			temp = temp.rightson;
			temp.setData(data);

		} else if (path.charAt(path.length() - 1) == 'L' && temp.getLeftson() == null) {
			temp.leftson=new Node<E>(data, null, null);
//			temp.setLeftSon(new Node<E>(data, null, null));
			temp = temp.leftson;
			temp.setData(data);
		} else
			throw new InvalidPathException();
	}
	//The method returns a string that represents the information in the tree nodes
	//according to the pre order pass
	public String pre() { // pre order
		Node<E> temp=root;
		return printPreorder(temp,"");
	}
	private  String printPreorder(Node<E> root , String temp)  { 
		if (root == null) {
			return "";
		}
		temp=root.data+"\n";
		 temp+= printPreorder(root.leftson,temp);
		 temp+=printPreorder(root.rightson, temp);
		return temp;
	}
	//The number of organs in the tree.
	public int getSize() {
		Node<E> temp=root;
		return size(temp);
	}
		private int size(Node<E> root) { 
			if (root == null) 
				return 0; 
			else
				return(size(root.leftson) + 1 + size(root.rightson)); 
		}
		//The method will accept as a string parameter representing a path in the tree
		//(as described above) and return the information field at the node we reached.
		//If the route is invalid (i.e. leading to null) the method will throw 
		//the InvalidPathException exception.
		public E findByPath(String path) throws InvalidPathException {
			Node<E> temp=root;
			if(path==null) {
				return null;
			}
			if(path.length()==0) {
				return root.data;
			}
			for(int i=0;i<path.length();i++) {
				if (path.charAt(i) == 'R' && temp.getRightson() != null)
					temp = temp.rightson;
				else if (path.charAt(i) == 'L' && temp.getLeftson() != null)
					temp = temp.leftson;
				else
					throw new InvalidPathException();
			}
			return temp.data;
		}	
	}
		
	