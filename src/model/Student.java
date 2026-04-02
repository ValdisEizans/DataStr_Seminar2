package model;

public class Student implements Comparable<Student> {
	//Mainigie
		private long studId;
		private String name;
		private String surname;
		private String personCode;
		
		//Paligmainigais bez setera/getera
		private static long counter = 0;
		
		//Geteri 
		public long getStudID() {
			return studId;
		}
		public String getName() {
			return name;
		}
		public String getSurname() {
			return surname;
		}
		public String getPersonCode() {
			return personCode;
		}
		
		//Seteri
		public void setStudID() {
			studId = counter;
			counter++;
		}
		public void setName(String inputName) {
			if((inputName != null) && (!inputName.isEmpty()) && (inputName.matches("[A-Z]{1}[a-z]{2,15}([*]{1}[A-Z]{1}[a-z]{2,15})?")) ) {
				name = inputName;
			}
			else{
				name = "Unknown";
			}
		}
		public void setSurname(String inputSurname) {
			if((inputSurname != null) && (!inputSurname.isEmpty()) && (inputSurname.matches("[A-Z]{1}[a-z]{2,25}([-]{1}[A-Z]{1}[a-z]{2,25})?")) ) {
				surname = inputSurname;
			}
			else{
				surname = "Unknown";
			}
		}
		public void setPersonCode(String inputPersoncode) {
			//TODO regex maska dienam un menesiem
			if ((inputPersoncode != null) && (!inputPersoncode.isEmpty()) && (inputPersoncode.matches("[0-9]{6}[-]{1}[0-9]{5}")) ) {
				personCode = inputPersoncode;
			}
			else {
				personCode = "Unknown";
			}
			
		}
		
		//Bezargumenta konstruktors
		public Student() {
			setStudID();
			setName("Valdis");
			setSurname("Eizans");
			setPersonCode("123456-78541");
		}
		
		//Argumenta konstruktors
		public Student(String inputName, String inputSurname, String inputPersonCode) {
			setStudID();
			setName(inputName);
			setSurname(inputSurname);
			setPersonCode(inputPersonCode);
		}
		
		//toString funkcija
		@Override //var nerakstit
		public String toString() {
			String result = studId + ": " + name + " " + surname + " (" + personCode + ")";
			return result;
		}
		@Override
		public int compareTo(Student student2) {
			if(surname.charAt(0) > student2.surname.charAt(0)) {
				return 1;
			}
			else if (surname.charAt(0) < student2.surname.charAt(0)) {
				return -1;
			}
			else {
				return 0;
			}
		}
		
		//Parejas funkcijas
	

}
