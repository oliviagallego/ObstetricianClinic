package obstetricianclinic.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


import obstetricianclinic.ifaces.*;
import obstetricianclinic.jdbc.*;
import obstetricianclinic.pojos.*;
//import obstetricianclinic.jpa.JPAUserManager;esta por programar



public class ObstetricianMenu {
	private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	private static ObstetricianManager obstetricianMan;
	private static WomanManager womanMan;
	
	public static void main(String[] args) {
		ConnectionManager conMan = new ConnectionManager();
		obstetricianMan = new JDBCObstetricianManager(conMan.getConnection());
		womanMan = new JDBCWomanManager(conMan.getConnection());
    	
		
		while (true) {
			try {
				System.out.println("Welcome to the obstetrician clinic!!");
				System.out.println("Choose an option, please:");
				System.out.println("1. Register a Woman");
				System.out.println("2. Select a woman");
				System.out.println("3. Change password");
				System.out.println("0. Exit");

			
        int choice = Integer.parseInt(r.readLine());
		switch (choice) {
						case 1: {
							registerwoman();
							break;
						}
						case 2: {
							searchWomanByNameAndSurname(choice);
							break;
						}
						case 3: {
							changePassword();
							break;
						}
						
						case 0: {
							conMan.closeConnection();
							return;
						}
						}

					} catch (NumberFormatException e) {
						System.out.println("Please write a number");
						e.printStackTrace();
					} catch (IOException e) {
						System.out.println("I/O Exception.");
						e.printStackTrace();
					}
				}

			}
				
				

               

public static void registerwoman() throws IOException {
	System.out.println("Please type the womans data:");
	System.out.println("Name:");
	String name = r.readLine();
	System.out.println("Surname:");
	String surname = r.readLine();
	System.out.println("weight:");
	Float weight = Float.parseFloat(r.readLine());
	System.out.println("Date of birth (dd-MM-yyyy):");
	String dob = r.readLine();
	LocalDate dobLocalDate = LocalDate.parse(dob, formatter); 
	Date dobDate = Date.valueOf(dobLocalDate); 
	Woman o = new Woman(name, surname, dobDate, weight, obstetrician);
	womanMan.registerWoman(o);

}

public static void searchWomanByNameAndSurname(int id) throws IOException {
	System.out.println("Search woman by name:");
	String name = r.readLine();
	System.out.println("Surname::");
	String surname = r.readLine();
	List<Woman> listwoman = womanMan.searchWomanByNameAndSurname(name, surname);
	System.out.println(listwoman);
   }
	
	public static void changePassword() {
		System.out.println("\nChange password:");
		String password = Utilities.readString(" -Type new password: ");
		User user= changePassword(user, password);
		System.out.println(" -Password changed correctly to " + user.getPassword());
		break;
}





	
	
	
	
	
	
	
	
}


