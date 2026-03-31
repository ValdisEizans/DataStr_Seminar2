package datastr;

public class MyLinkedList<Ttype> {
	//Mainigie
	private MyNode<Ttype> firstNode = null; //glaba infor kurs pirmais
	private MyNode<Ttype> lastNode = null; //glaba info kurs pedejais
	private int howManyElements = 0;
	
	//first un last node netaisa seterus un geterus, lai lietotajs nevar sos rediget
	
	//atgriez cik elementi saraksta
	public int getHowManyElements(){
		return howManyElements;
	}
	
	//Konstruktors bus bezargumenta konstruktors no Object klases.
	
	//toString funkcija
	
	//funkcijas
	private boolean isEmpty() {
		return (howManyElements == 0); 
	}
	
	private boolean isFull() {
		try {
			new MyNode<Character>('A');//megina RAM rezervet vietu
			return false;
		}
		catch(OutOfMemoryError e){
			return true;
		}
	}
	
	//pievienot elementu
	public void add(Ttype inputElement) throws Exception{
		if(isFull()) {
			throw new Exception("Saraksts pilns, nevar pievienot elementu!");
		}
		if(inputElement == null) {
			throw new Exception("Nav noradits padotais elements!");
		}
		//ja pievieno pirmo bloku
		if(isEmpty()) {
			MyNode<Ttype> newNode = new MyNode<Ttype>(inputElement);
			lastNode = newNode;
			firstNode = newNode;
			howManyElements++;
		}
		else {//ja saraksta jau vismaz 1 bloks
			MyNode<Ttype> newNode = new MyNode<Ttype>(inputElement);
			lastNode.setNextNode(newNode);//savieno jauno bloku ar pedejo
			newNode.setPreviousNode(lastNode);
			lastNode = newNode;//uzliek jauno pedejo elementu
			howManyElements++;
		}
	}

	//printesanas (apstaigasanas) funkcija
	public void print() throws Exception{
		if(isEmpty()) {
			throw new Exception("Saraksta nav elementu, nav ko drukat!");
		}
		
		MyNode<Ttype> currentNode = firstNode;
		while(currentNode != null) {
			System.out.print(currentNode.getElement() + " ");
			currentNode = currentNode.getNextNode();
		}
		System.out.println();
	}
	
	
	

}
