package cr.ac.ulead.Principal;

import java.io.IOException;
import java.util.Stack;

import cr.ac.ulead.Logic.Persona;
import cr.ac.ulead.UI.Interface;

public class Tree {

	private Node root = null;

	public void insert(Persona person) {
		Node newNode = new Node();
		newNode.data = person;
		if (root == null)
			root = newNode;
		else {
			Node current = root;
			Node parent;

			while (true) {
				parent = current;
				int variable = person.getDateOfBirst().compareTo(parent.data.getDateOfBirst());
				if (variable > 0) {
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = newNode;
						return;
					}
				} else if (variable < 0) {
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = newNode;
						return;
					}
				} else {
					if (Integer.parseInt(person.getID()) > Integer.parseInt(current.data.getID())) {
						current = current.leftChild;
						if (current == null) {
							parent.leftChild = newNode;
							return;
						}
					} else if (Integer.parseInt(person.getID()) < Integer.parseInt(current.data.getID())) {
						current = current.rightChild;
						if (current == null) {
							parent.rightChild = newNode;
							return;
						}
					} else
						return;
				}
			}
		}
	}

	public void traverse(int traverseType) throws IOException {
		Interface UI = new Interface();
		switch (traverseType) {
		case 3:
			System.out.print("\nPreorder traversal: ");
			preOrder(root);
			break;
		case 4:
			System.out.print("\nInorder traversal:  ");
			inOrder(root);
			break;
		case 5:
			System.out.print("\nPostorder traversal: ");
			postOrder(root);
			break;
		case 6:
			UI.Menu();
			break;
		default:
			System.out.print("GRACIAS POR PARTICIPAR!!! ");

		}
		System.out.println();
	}

	private void preOrder(Node localRoot) throws IOException {
		Interface UI = new Interface();
		if (localRoot != null) {
			System.out.print(localRoot.data + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
		UI.ShowMenu();
	}

	private void inOrder(Node localRoot) throws IOException {
		Interface UI = new Interface();
		if (localRoot != null) {
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.data + " ");
			inOrder(localRoot.rightChild);
		}
		UI.ShowMenu();
	}

	private void postOrder(Node localRoot) throws IOException {
		Interface UI = new Interface();
		if (localRoot != null) {
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.print(localRoot.data + " ");
		}
		UI.ShowMenu();
	}

	public void displayTree() {
		Stack globalStack = new Stack();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println("......................................................");
		while (isRowEmpty == false) {
			Stack localStack = new Stack();
			isRowEmpty = true;

			for (int j = 0; j < nBlanks; j++)
				System.out.print(' ');

			while (globalStack.isEmpty() == false) {
				Node temp = (Node) globalStack.pop();
				if (temp != null) {
					System.out.print(temp.data);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);

					if (temp.leftChild != null || temp.rightChild != null)
						isRowEmpty = false;
				} else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for (int j = 0; j < nBlanks * 2 - 2; j++)
					System.out.print(' ');
			}
			System.out.println();
			nBlanks /= 2;
			while (localStack.isEmpty() == false)
				globalStack.push(localStack.pop());
		}
		System.out.println("......................................................");
	}
}
