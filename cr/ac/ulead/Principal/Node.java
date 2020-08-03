package cr.ac.ulead.Principal;

import cr.ac.ulead.Logic.Persona;

public class Node {

	public Persona data; 
	public Node leftChild; 
	public Node rightChild; 

	public void displayNode() 
	{
		System.out.print('{');
		System.out.print(data);
		System.out.print("} ");
	}

}
