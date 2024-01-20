package com.hexaware.view;

import com.hexaware.controller.CaseController;
/**
 * The MainModule class serves as the entry point for the Crime Analysis and Reporting System.
 * It provides a user interface to interact with various entities such as Incidents, Cases, Officers, Reports,
 * Victims, Suspects, and Law Enforcement Agencies.
 *
 * The user can perform actions like viewing incidents, adding incidents, searching incidents by criteria,
 * updating incident status, updating incidents, getting incidents by ID, adding cases, updating cases,
 * displaying all cases, getting case details, registering officers, displaying officers, and getting officers by ID.
 * The user can also add reports, show reports, and get reports by ID. Additionally, the user can add victims,
 * display victims, add suspects, display suspects, add law enforcement agencies, and display law enforcement agencies.
 *
 * The data for various entities is initialized using controller instances, and the main menu allows the user
 * to choose from different options for interacting with the system.
 *
 * Usage:
 * - Execute the main method to launch the Crime Analysis and Reporting System.
 * - Follow the on-screen menu to perform various actions.
 *
 * Note: Ensure that the necessary controllers and data arrays are properly initialized.
 */
import com.hexaware.controller.IncidentController;
import com.hexaware.controller.LawEnforcementAgencyController;
import com.hexaware.controller.OfficerController;
import com.hexaware.controller.ReportController;
import com.hexaware.controller.SuspectController;
import com.hexaware.controller.VictimController;
import com.hexaware.exception.RecordNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class MainModule {
  public static void main(String[] args) throws RecordNotFoundException{
    // Controller instances for various entities
    IncidentController incidentController = new IncidentController();
    VictimController victimController=new VictimController();
    SuspectController suspectController=new SuspectController();
    LawEnforcementAgencyController agencyController=new LawEnforcementAgencyController();
    CaseController caseController=new CaseController();
    OfficerController officerController=new OfficerController();
    ReportController reportController=new ReportController();
    int l;

    // Initializing data arrays for entities
    victimController.putVictimsToArray();
    suspectController.putSuspectsToArray();
    agencyController.putAgenciesToArray();
    incidentController.putIncidentsToArray();
    caseController.putCasesToArray();
    officerController.putOfficersToArray();
    reportController.putReportsToArray();

    // Main menu options
    System.out.println("**************");
    System.out.println("Crime Analysis and Reporting System");
    System.out.println("**************");
    Scanner sc = new Scanner(System.in);
    int ch;
    do {
      System.out.println("Enter your choice");
      System.out.println("Enter 0 For Exit\n"
          + "Enter 1 For  Incidents Section\n"
          + "Enter 2 For  Cases Section\n"
          + "Enter 3 For Officers Section\n"
          + "Enter 4 For Reports Section\n"
          + "Enter 5 For Victims Section\n"
          + "Enter 6 For Suspects Section\n"
          + "Enter 7 For Agency Section\n");

      System.out.println("Please enter your choice:");
      ch = sc.nextInt();
      switch (ch) {

        case 0:break;
        
        case 1:
          // Incidents section menu
          System.out.println("0. Exit\n"
              + "Enter 1. View Incidents\n"
              + "Enter 2. Add Incidents\n"
              + "Enter 3. Search Incidents in Date Range\n"
              + "4. Search Incidents by criteria\n"
              + "5. Update Incident Status \n"
              + "6. Update Incident\n"
              + "7. Get Incident By Id");
          System.out.println("Enter your choice: ");
          l = sc.nextInt();

          switch (l) {
            case 0:break;
            
            case 1:incidentController.viewIncidents(); 
            break;

            case 2:incidentController.addIncidents();
            break;

            case 3:System.out.println("Enter Start Date and End Date(yyyy-mm-dd): ");
                   incidentController.getIncidentsDateRange(LocalDate.parse(sc.next()),
                          LocalDate.parse(sc.next()));
                   break;
            
            case 4:System.out.println("Enter your criteria (id/type/date(yyyy-mm-dd)/location)");
                   incidentController.searchIncidents(sc.next());
                   break;
            
            case 5:System.out.println("Enter Incident Id:");
                   incidentController.updateIncidentStatus(sc.nextInt());
                   break;
            
            case 6:System.out.println("Enter incident id:");
                   incidentController.updateIncident(sc.nextInt());
                   break;
            
            case 7:
            	System.out.println("Enter incident id:");
            	try {
            		 incidentController.getIncidentById(sc.nextInt());
                     break;
				} catch (RecordNotFoundException e) {
		            // Handle the exception and print a specific message
//		            System.out.println("Record not found in the Database!!!");
				}
//                   incidentController.getIncidentById(sc.nextInt());
//                   break;

            default:System.out.println("Enter a valid option");
                    break;
          }
          break;

        case 2:
          // Cases section menu
          System.out.println("0. Exit\n"
               + "1. Add a Case\n"
               + "2. Update a Case\n"
               + "3. Display All Cases\n"
               + "4. Get Case Details");
     System.out.println("Enter your choice: ");
     l=sc.nextInt();
     switch(l) {
     	case 0:break;
     	
     	case 1:	caseController.addCase();
     			break;
	
    	case 2:	System.out.println("Enter case Id: ");
    			caseController.updateCase(sc.nextInt());
    			break;
    			
     	case 3:	caseController.getAllCases();
     			break;

     	case 4:	System.out.println("Enter case Id: ");
			caseController.getCase(sc.nextInt());
			break;
     			
     	default:System.out.println("Enter a valid option!!");
     			break;
     }
     break;

     case 3:
    	 //Officers menu section
     System.out.println("0. Exit\n"
     		+ "1. Register an Officer\n"
     		+ "2. Show All Officers\n"
     		+ "3. Get Officer By Id");
     l=sc.nextInt();
     switch(l) {
     	case 0:break;

     	case 1:officerController.addOfficer();
     	break;
	
     	case 2:officerController.displayOfficers();
     	break;
	
     	case 3:System.out.println("Enter Officer Id:");
     		officerController.getOfficerById(sc.nextInt());
     	break;
	
     	default:System.out.println("Enter a valid option!");
     	break;
     }
     break;

    case 4://Reports menu section
    	System.out.println("0. Exit\n"
    		+ "1. Add Report\n"
    		+ "2. Show Reports\n"
    		+ "3. Get Report By Id");
    l=sc.nextInt();
    switch(l) {
    	case 0:
    		break;
    		
    	case 1:reportController.addReport();
    		break;
    	
    	case 2:reportController.displayReports();
    		break;
    		
    	case 3:System.out.println("Enter Report Id");
    		reportController.getReportById(sc.nextInt());
    	break;
    		
    	default:System.out.println("Enter a valid option:");
    	break;
    }
    break;

		case 5://Victim menu section
			System.out.println("0. Exit\n"
				+ "1. Add a Victim\n"
				+ "2. Show all Victims\n");
		l=sc.nextInt();
		switch(l) {
			case 0:break;
			
			case 1:victimController.addVictim();
			break;
			
			case 2:victimController.displayVictims();
			break;
			
			default:System.out.println("Enter a valid option:");
			break;
		}
		break;
		
		case 6://Suspects menu section
			System.out.println("0. Exit\n"
				+ "1. Add Suspect\n"
				+ "2. Show All Suspects\n");
		l=sc.nextInt();
		switch(l) {
			case 0:break;
			
			case 1:suspectController.addSuspect();
			break;
			
			case 2:suspectController.showSuspects();
			break;
			
			default:System.out.println("Enter a valid option:");
			break;
		}
		break;
		
		case 7://Law Enforcement Agencies menu Section
			System.out.println("0. Exit\n"
				+ "Enter 1. Add Agency\n"
				+ "Enter 2. Show All Agencies\n");
		l=sc.nextInt();
		switch(l) {
			case 0:break;
			
			case 1:agencyController.addAgency();
			break;
			
			case 2:agencyController.showAllAgencies();
			break;
			
			default:System.out.println("Enter a valid option:");
			break;
		}
		break;
		
		default:System.out.println("Enter a valid option:");
			break;
      }
    } while (ch != 0);
  }
}
