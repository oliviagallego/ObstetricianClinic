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
							searchWomanByNameAndSurname();
							break;
						}
						case 3: {
							changepassword();
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
	System.out.println("Date of birth (yyyy-MM-dd):");
	String dob = r.readLine();
	LocalDate dobLocalDate = LocalDate.parse(dob, formatter); 
	Date dobDate = Date.valueOf(dobLocalDate); 
	Woman o = new Woman(name, surname, dob, weight);
	//hay un error en el constructor con el set date, y no me lo acepta//
	womanMan.registerWoman(o);

}

public static void searchWomanByNameAndSurname(int id) throws IOException {
	System.out.println("Search woman by name:");
	String name = r.readLine();
	System.out.println("Surname::");
	String surname = r.readLine();
	List<Woman> listwoman = womanMan.searchWomanByNameAndSurname(name, surname);
	//el constructor devuelve un woman en vez de una lista the woman//
	System.out.println(listwoman);
	
	
	//falta constructor para cambiar la contraseña del obstetrician//
	public static void changepassword() {
		
	}
	
	
	
	
	
	
}

}
