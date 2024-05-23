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
import obstetricianclinic.pojos.*;

public class DiseaseMenu {
	private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	private static WomanManager womanMan;
	private static LabReportManager labReportMan;
	private static DiseaseManager diseaseMan;
	
	public static void menu(Woman woman, ConnectionManager conMan) {

		womanMan = conMan.getWomanMan();
		labReportMan=conMan.getLabReportMan();
		diseaseMan = conMan.getDiseaseMan();
	
		while (true) {
			try {
				System.out.println("Woman's Menu of: "+woman.getName()+" "+woman.getSurname());
				System.out.println("\nChoose an option, please:");
				System.out.println("\n1. View woman's data");
				System.out.println("\n2. Update woman's data");
				System.out.println("\n3. Delete woman's data");
				System.out.println("\n4. Assign disease");
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
							System.out.println(woman);
							break;
						}
						case 3: {
							int id= woman.getId();
							womanMan.deleteWoman(id);
							conMan.closeConnection();
							break;
						}
						case 4:{
							int id= woman.getId();
							assignDisease(id);
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