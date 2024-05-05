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
	private static UserManager userMan;
	
	public static void main(User user, UserManager man) {
		ConnectionManager conMan = new ConnectionManager();
		obstetricianMan = conMan.getObstetricianMan();
		womanMan = conMan.getWomanMan();/* solo tenemos q hacer uso del método*/
		userMan = man;
	
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
							Woman woman= searchWomanByNameAndSurname();
							
							break;
						}
						case 3: {
							System.out.println("\nChange password:");
							String password = Utilities.readString(" -Type new password: ");
							user = man.changePassword(user, password);
							System.out.println(" -Password changed correctly to " + user.getPassword());
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
	Woman woman = new Woman(name, surname, dobDate, weight);//quitamos el atributo oobstetrician para crear el objeto woman en este caso por que estamos en la cuenta de un obstetrician en concreto por lo tanto ose le asignará ese doctor directamente.
	//Para que la creacion de este objeto funcione tenemos que tener en la clase woman un constructor con esos atributos justo y en ese orden.
	womanMan.registerWoman(woman); //el error esta en la interfaz q estaba mal escrito register
	

}

public static Woman searchWomanByNameAndSurname() throws IOException {
	System.out.println("Search woman by name:");
	String name = r.readLine();
	System.out.println("Surname::");
	String surname = r.readLine();
	List<Woman> listWomen = womanMan.searchWomanByNameAndSurname(name, surname);
	
	if (listWomen.isEmpty()) {
        System.out.println("No women found with the name and surname provided.");
        return null;  // Return null if no matches are found
    }

    if (listWomen.size() == 1) {
        System.out.println("One woman found: " + listWomen.get(0));
        return listWomen.get(0);  // Return the single found woman
    }

    // Multiple women found, let user choose
    System.out.println("Multiple matches found, please choose one:");
    for (int i = 0; i < listWomen.size(); i++) {
        System.out.println((i + 1) + ". " + listWomen.get(i));
    }
    System.out.println("Enter the number of the woman you choose:");
    int choice = Integer.parseInt(r.readLine()) - 1;  // Adjust for zero-based index
    if (choice >= 0 && choice < listWomen.size()) {
        return listWomen.get(choice);  // Return the selected woman
    } else {
        System.out.println("Invalid choice, please enter a valid number.");
        return null;  // Return null if the input choice is out of range
    }

   }
	

	




	
	
	
	
	
	
	
	
}


