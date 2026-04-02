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

	//izveidot add funkciju, kurai padod elementu un poziciju, kur ielikt
	//ja 0 pozicija
	public void add(Ttype inputElement, int position) throws Exception{
		if(isFull()) {
			throw new Exception("Saraksts pilns, nevar pievienot elementu!");
		}
		if(inputElement == null) {
			throw new Exception("Nav noradits padotais elements!");
		}
		if(position < 0) {
			throw new Exception("Noradita pozicija var but tikai pozitiva!");
		}
		if(position > howManyElements) {
			throw new Exception("Noradita pozicija nevar but lielaka par esoso elementu skaitu!");
		}
		if(position == 0) {
			MyNode<Ttype> newNode = new MyNode<Ttype>(inputElement);
			
			newNode.setNextNode(firstNode);
			firstNode.setPreviousNode(newNode);
			
			firstNode = newNode;
			howManyElements++;
		}
		//ja pedeja pozicija pozicija
		else if (position == howManyElements) {
			add(inputElement);			
		}
		else {
			//izveidojam jauno mezglu
			MyNode<Ttype> newNode = new MyNode<Ttype>(inputElement);
			
			//ejam lidz pozicijai -1
			MyNode<Ttype> currentNode = firstNode;//TODO no kuras puses sakt 
			for(int i = 1; i <= position-1; i++ ) {
				currentNode = currentNode.getNextNode();//lecam pa mezgliem
			}
			//veido kreisa un labas puses blokus 
			MyNode<Ttype> leftNode = currentNode;
			MyNode<Ttype> rightNode = leftNode.getNextNode();
			
			//veicam saisu nomainu
			leftNode.setNextNode(newNode);
			newNode.setPreviousNode(leftNode);
			newNode.setNextNode(rightNode);
			rightNode.setPreviousNode(newNode);
			
			howManyElements++;
		}
	}
	
	//remove by position funkcija
	public void remove(int position) throws Exception{
		if(isEmpty()) {
			throw new Exception("Saraksts tukss, nevar dzest elementu!");
		}
		if(position < 0) {
			throw new Exception("Noradita pozicija var but tikai pozitiva!");
		}
		if(position > howManyElements) {
			throw new Exception("Noradita pozicija nevar but lielaka par esoso elementu skaitu!");
		}
		if(position == 0) {
			firstNode = firstNode.getNextNode();
			firstNode.setPreviousNode(null);
			
			howManyElements--;
		}
		//ja pedeja pozicija pozicija
		else if (position == howManyElements-1) {
			lastNode = lastNode.getPreviousNode();
			lastNode.setNextNode(null);
			
			howManyElements--;
		}
		else {
			//ejam lidz pozicijai 
			MyNode<Ttype> currentNode = firstNode;//TODO no kuras puses sakt 
			for(int i = 1; i <= position; i++ ) {
				currentNode = currentNode.getNextNode();//lecam pa mezgliem
			}
			//veido kreisa un labas puses blokus 
			MyNode<Ttype> leftNode = currentNode.getPreviousNode();
			MyNode<Ttype> rightNode = currentNode.getNextNode();
			
			//veicam saisu nomainu
			leftNode.setNextNode(rightNode);
			rightNode.setPreviousNode(leftNode);

			howManyElements--;
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
