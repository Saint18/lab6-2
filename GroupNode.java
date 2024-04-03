
/*
GroupNode is a generic class and child of AbstractTreeNode. 
This node takes the place of a supervisor. 
It allows for a single data element along with an array list of other elements.

You'll have to include the needed imports, fix the class declaration, and then populate the body with the needed methods.
*/
//this node can have children and represents supervisors managing subordinates.
import java.util.ArrayList;
import java.util.List;

public class GroupNode<T> extends AbstractTreeNode<T> {
	private List<AbstractTreeNode<T>> children; // Variable list of type AbstractTreeNode to store child nodes

	// contructor inheriting from AbstractTreeNode
	public GroupNode(T data) {
		super(data);
		this.children = new ArrayList<>();
	}

	// constructor to initialize node with data and parent
	public GroupNode(T data, AbstractTreeNode<T> parent) {
		super(data, parent);
		this.children = new ArrayList<>();
	}

	// implementation of addChild method. adds child to node.
	@Override
	public AbstractTreeNode<T> addChild(AbstractTreeNode<T> child) {
		children.add(child);
		child.setParent(this); // set this node as the parent of child
		return child;
	}

	// method that removes child from node. returns true if child was in the list
	// and was removed.
	public boolean removeChild(AbstractTreeNode<T> child) {
		return children.remove(child);
	}

	// method to determine if node is a leaf. return true if empty
	@Override
	public boolean isLeaf() {
		return children.isEmpty();
	}

	// prints information for this node and the children
	@Override
	public void printEmployees() {
		System.out.println(this.data);
		for (AbstractTreeNode<T> child : children) {
			child.printEmployees(); // prints children's data
		}
	}

	
	//traverse method. vist parent node first. 
	@Override
	public void traversePreOrder() {
		System.out.println(this.data);
		for(AbstractTreeNode<T> child : children) {
			child.traversePreOrder();  //recursively traverse children
		}
	}
}
