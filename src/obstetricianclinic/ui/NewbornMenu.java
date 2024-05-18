package obstetricianclinic.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import obstetricianclinic.ifaces.LabReportManager;
import obstetricianclinic.ifaces.NewbornManager;
import obstetricianclinic.ifaces.PregnancyManager;
import obstetricianclinic.ifaces.WomanManager;
import obstetricianclinic.jdbc.ConnectionManager;
import obstetricianclinic.pojos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.List;

public class NewbornMenu {
	private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	private static WomanManager womanMan;
	private static LabReportManager labReportMan;
	private static PregnancyManager pregMan;
	private static NewbornManager bornMan;
	
	public static void menu(Pregnancy pregnancy) {
		ConnectionManager conMan = new ConnectionManager();
		womanMan = conMan.getWomanMan();
		pregMan = conMan.getPregnancyMan();
		labReportMan=conMan.getLabReportMan();
		bornMan= conMan.getNewbornMan();		
		
		while (true) {
			try {
				//List of Newborns
				if(pregnancy.getNewborns().size()==1) {
					System.out.println("\n The newborn of these pregnancy is: "+pregnancy.getNewborns());
				}else {
					System.out.println("\n The newborns of these pregnancy are: ");
					for(int i=0; i<pregnancy.getNewborns().size(); i++) {
						System.out.println("\n"+i+" - "+pregnancy.getNewborns().get(i));
					}
				}
				
				System.out.println("Menu of Newborns: ");
				System.out.println("\nChoose an option, please:");
				System.out.println("\n1. Register a newborns");
				System.out.println("\n2. Update newborn ");
				System.out.println("\n3. View newborn ");
				System.out.println("\n0. Exit");

			
        int choice = Integer.parseInt(r.readLine());
		switch (choice) {
						case 1: {
							registerNewborn( pregnancy);
							break;
						}
						case 2: {
							Newborn nw=chooseNw(pregnancy);
							updateNewborn(nw);
							System.out.println(nw);
							break;
						}
						case 3: {
							Newborn nw=chooseNw(pregnancy);
							System.out.println(nw);
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
	public static  Newborn chooseNw(Pregnancy pregnancy) throws IOException {
		System.out.println("Pregnancys's Menu of: "+pregnancy.getDateConception()+" (date of conception)");
		if(pregnancy.getNewborns().size()==1) {
			System.out.println("\n The newborn of these pregnancy is: "+pregnancy.getNewborns());
			Newborn nw= pregnancy.getNewborns().get(0);
			return nw;
		}else {
			System.out.println("\n The newborns of these pregnancy are: ");
			for(int i=0; i<pregnancy.getNewborns().size(); i++) {
				System.out.println("\n"+i+" - "+pregnancy.getNewborns().get(i));
			}
			System.out.println("\n Which newborn are you interest in? (give me his number of the list)  ");
			int option = Integer.parseInt(r.readLine());
	        Newborn nw= pregnancy.getNewborns().get(option);
	        return nw;
		}
	}
	public static void registerNewborn(Pregnancy pregnancy) throws IOException {
		System.out.println("Please type the newborns data:");
		System.out.println("Name:");
		String name = r.readLine();
		System.out.println("Surname:");
		String surname = r.readLine();
		System.out.println("Weight:");
		Float weight = Float.parseFloat(r.readLine());
		System.out.println("Date of birth (dd-MM-yyyy):");
		String dob = r.readLine();
		LocalDate dobLocalDate = LocalDate.parse(dob, formatter);
		Date dobDate = Date.valueOf(dobLocalDate); 
		System.out.println("Gender (F/M): ");
		String gender = r.readLine();
		Newborn nw= new Newborn(name,surname,dobDate,weight,gender,pregnancy); 
		bornMan.addNewborn(nw);
	}
	
	public static void updateNewborn(Newborn nw) throws IOException {
		System.out.println("Please what do you want to update of the newborn's data:");
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
			nw.setName(name);
			bornMan.updateNewborn(nw);
			break;
		case 2:
			System.out.println("Give me the new surname: ");
			System.out.println("Surname:");
			String surname = r.readLine();
			nw.setSurname(surname);
			bornMan.updateNewborn(nw);
			break;
		case 3:
			System.out.println("Give me the new Date of birth (dd-MM-yyyy): ");
			String dob = r.readLine();
			LocalDate dobLocalDate = LocalDate.parse(dob, formatter);
			Date dobDate = Date.valueOf(dobLocalDate); 
			nw.setDob(dobDate);
			bornMan.updateNewborn(nw);
			break;
		case 4:
			System.out.println("Give me the new weight: ");
			Float weight = Float.parseFloat(r.readLine());
			nw.setWeight(weight);
			bornMan.updateNewborn(nw);
			break;
		default: {
			System.out.println(" ERROR: Invalid option.");
		}
			
	   }
	}

}
