
/*
LeafNode is a generic class and child of AbstractTreeNode. 
This node allows for a single data element. 

You'll have to include the needed imports, fix the class declaration, and then populate the body with the needed methods.
*/
//leaf node represents node without children. employees without subordinates. 
public class LeafNode<T> extends AbstractTreeNode<T> {

	// contructor inheriting from AbstractTreeNode
	public LeafNode(T data) {
		super(data);
	}

	// constuctor inheriting form AbstractTreeNode and parent
	public LeafNode(T data, AbstractTreeNode<T> parent) {
		super(data, parent);
	}

	// method for remove child. leaf nodes cannot have children so returns this node
	@Override
	public AbstractTreeNode<T> addChild(AbstractTreeNode<T> child) {
		return this;
	}

	// method to remove child but leaf node cannot have children so return false
	// always
	@Override
	public boolean removeChild(AbstractTreeNode<T> child) {
		return false;
	}

	// is leaf method will always return true
	@Override
	public boolean isLeaf() {
		return true;
	}

	// implementation of print employees
	@Override
	public void printEmployees() {
		System.out.println(this.data);
	}

	
	//traverse method parent node first
	@Override
	public void traversePreOrder() {
		System.out.println(this.data);
	}
	
	
	
	
}
