package datastr;

public class MyNode<Ttype> {
	
	//Mainigie
	private Ttype element;
	private MyNode<Ttype> nextNode = null;
	private MyNode<Ttype> previousNode = null;
	
	//Geteri
	public Ttype getElement() {
		return element;
	}
	public MyNode<Ttype> getNextNode() {
		return nextNode;
	}
	public MyNode<Ttype> getPreviousNode() {
		return previousNode;
	}
	
	//Seteri
	public void setElement(Ttype inputElement) {
		if(inputElement != null) {
			element = inputElement;
		}
		else {
			element = (Ttype) new Object();
		}
	}
	//nav javeic not null parbaudes, jo ir gadijumi kad pedejais vai pirmais bloks
	public void setNextNode(MyNode<Ttype> nextNode) {
		this.nextNode = nextNode;
	}
	public void setPreviousNode(MyNode<Ttype> previousNode) {
		this.previousNode = previousNode;
	}
	
	//Konstruktors - bezargumenta neveido, jo lietotajams vienmer japado elements
	public MyNode (Ttype inputElement){
		setElement(inputElement);
	}
	
	//toString funkcija
	public String toString() {
		return "" + element;
	}

}
