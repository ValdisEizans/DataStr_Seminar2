package service;

import datastr.MyLinkedList;

public class MainService {

	public static void main(String[] args) {
		MyLinkedList<Character> symbols = new MyLinkedList<Character>();
		try {
			symbols.add('A');
			symbols.add('B');
			symbols.add('C');
			symbols.print();			
			symbols.add('Z');
			symbols.print();
			symbols.add('X',0);
			symbols.print();
			symbols.add('Y',4);
			symbols.print();
			symbols.remove(0);
			symbols.print();
			symbols.remove(4);
			symbols.print();
			symbols.remove(1);
			symbols.print();
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
