package service;

import datastr.MyLinkedList;
import model.Student;

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
			symbols.add('C');
			symbols.print();
			symbols.add('Y',4);
			symbols.print();
			/*symbols.print();
			symbols.remove(0);
			symbols.print();
			symbols.remove(4);
			symbols.print();
			symbols.remove(1);
			symbols.print();*/
			System.out.println(symbols.getByPosition(5));
			System.out.println(symbols.searchByPosition('C'));
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("------------------------------------  DARBS AR STUDENTIEM --------------------------------------");
			MyLinkedList<Student> allStudents = new MyLinkedList<Student>();
			Student s1 = new Student("Janis", "Berzins", "123545-87452");
			Student s2 = new Student("Guntis", "Liepins", "874519-87452");
			Student s3 = new Student("Liga", "Egle", "986325-87452");
			allStudents.add(s1);
			allStudents.add(s2);
			allStudents.add(s3);
			allStudents.print();
			System.out.println(allStudents.getByPosition(1));
			System.out.println(allStudents.searchByPosition(s2));//indekss, kur glabajas Liga
			allStudents.print();
			allStudents.remove(1);
			allStudents.print();
			allStudents.makeEmpty();
			allStudents.add(new Student("Genadijs", "Testeris", "123545-87452"));
			allStudents.print();

			
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

}
