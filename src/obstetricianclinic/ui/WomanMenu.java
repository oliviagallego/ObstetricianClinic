package obstetricianclinic.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import obstetricianclinic.ifaces.*;
import obstetricianclinic.jdbc.ConnectionManager;
import obstetricianclinic.pojos.LabReport;
import obstetricianclinic.pojos.User;
import obstetricianclinic.pojos.Woman;

public class WomanMenu {
	private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	private static WomanManager womanMan;
	private static LabReportManager labReportMan;
	
	public static void main(Woman woman) {
		ConnectionManager conMan = new ConnectionManager();
		womanMan = conMan.getWomanMan();
	
		while (true) {
			try {
				System.out.println("Woman's Menu of: "+woman.getName()+" "+woman.getSurname());
				System.out.println("\nChoose an option, please:");
				System.out.println("\n1. View woman's data");
				System.out.println("\n2. Update woman's data");
				System.out.println("\n3. Delete woman's data");
				System.out.println("\n0. Exit");

			
        int choice = Integer.parseInt(r.readLine());
		switch (choice) {
						case 1: {
							int id= woman.getId();
							viewWoman(id,woman);
							break;
						}
						case 2: {
							updateWoman(woman);
							break;
						}
						case 3: {
							int id= woman.getId();
							womanMan.deleteWoman(id);
							break;
						}
						
						case 0: {
							conMan.closeConnection();
							return;
						}
						default: {
							System.out.println(" ERROR: Invalid option.");
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
				
				

               

public static void viewWoman(int id, Woman woman) throws IOException {
	System.out.println("Please what do you want to see of the woman's data:");
	System.out.println("\nChoose an option:");
	System.out.println("\n1. View woman's information");
	System.out.println("\n2. View woman's laboratory report");
	System.out.println("\n3. View woman's pregnancy record");
	int option= Integer.parseInt(r.readLine());
	switch(option) {
	case 1:
		Woman o=womanMan.viewWoman(id);
		System.out.println(o);
		break;
	case 2:
		List<LabReport> l= labReportMan.getLabReportsByWoman(woman);
		System.out.println(l);
		break;
	case 3:
		PregnancyMenu.main(woman);
		break;
	default: {
		System.out.println(" ERROR: Invalid option.");
	}	
		
	}	

}

public static void updateWoman(Woman woman) throws IOException {
	System.out.println("Please what do you want to update of the woman's data:");
	System.out.println("\nChoose an option:");
	System.out.println("\n1. Change name");
	System.out.println("\n2. Change surname");
	System.out.println("\n3. Change dob");
	System.out.println("\n4. Change weight");
	int option= Integer.parseInt(r.readLine());
	switch(option) {
	case 1:
		System.out.println("Give me the new name: ");
		System.out.println("Name:");
		String name = r.readLine();
		woman.setName(name);
		womanMan.updateWoman(woman);
		break;
	case 2:
		System.out.println("Give me the new surname: ");
		System.out.println("Surname:");
		String surname = r.readLine();
		woman.setSurname(surname);
		womanMan.updateWoman(woman);
		break;
	case 3:
		System.out.println("Give me the new Date of birth (dd-MM-yyyy): ");
		String dob = r.readLine();
		LocalDate dobLocalDate = LocalDate.parse(dob, formatter);
		Date dobDate = Date.valueOf(dobLocalDate); System.out.println(l);
		woman.setDob(dobDate);
		womanMan.updateWoman(woman);
		break;
	case 4:
		System.out.println("Give me the new weight: ");
		Float weight = Float.parseFloat(r.readLine());
		woman.setWeight(weight);
		womanMan.updateWoman(woman);
		break;
	default: {
		System.out.println(" ERROR: Invalid option.");
	}
		
   }
	
}

	




	
	
	
	
	
	
	
	

}