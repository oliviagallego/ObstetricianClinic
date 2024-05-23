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
	
	private static WomanManager womanMan;
	private static DiseaseManager diseaseMan;
	
	public static void menu(Disease disease, ConnectionManager conMan) {

		womanMan = conMan.getWomanMan();
		diseaseMan = conMan.getDiseaseMan();

		while (true) {
			try {
				System.out.println("Disease menu:");
				System.out.println("\nChoose an option, please:");
				System.out.println("\n1. Add disease");
				System.out.println("\n2. Update disease");
				System.out.println("\n0. Exit");

			
        int choice = Integer.parseInt(r.readLine());
		switch (choice) {
						case 1: {
							resgisterDisease();
							break;
						}
						case 2: {
							updateDisease(disease);
							System.out.println(disease);
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

	private static void resgisterDisease() throws IOException {
		System.out.println("Please type disease´s name: ");
		String diseaseType = r.readLine();
		Disease disease = new Disease(diseaseType);
		diseaseMan.addDisease(disease);
	}
	
	
	private static void updateDisease(Disease disease) throws IOException {
		System.out.println("Please write the new disese name");
		String diseaseType = r.readLine();
		disease.setDiseaseType(diseaseType);
		diseaseMan.updateDisease(disease);
		System.out.println("The disease has been updated correctly");

	}
	
	

	
	}