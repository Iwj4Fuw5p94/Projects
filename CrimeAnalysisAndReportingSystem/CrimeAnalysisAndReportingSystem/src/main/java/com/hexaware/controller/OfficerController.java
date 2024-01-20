package com.hexaware.controller;

import com.hexaware.dao.OfficersDao;
import com.hexaware.entity.LawEnforcementAgencies;
import com.hexaware.entity.Officers;
import com.hexaware.exception.DuplicateDataException;
import com.hexaware.exception.InvalidDataException;
import com.hexaware.exception.RecordNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * The OfficerController class manages a list of officers, interacting with the OfficersDao
 * to populate, add, and display officer information. It provides methods to populate the list,
 * add new officers, display officer details, and retrieve an officer by their ID. 
 * The class handles user input, data validation, and exception handling.
 */

public class OfficerController {
    public static List<Officers> officerList = new ArrayList<>();
    private InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    private BufferedReader bufferReader = new BufferedReader(inputStreamReader);
    private Officers officer;

    private OfficersDao officerDataAccessObject = new OfficersDao();
	public void putOfficersToArray() {
		officerDataAccessObject.putOfficersToArray();
	}
	public void addOfficer() {
		StringBuffer str=new StringBuffer("");
		officer=new Officers();
		
		try {
			System.out.println("Enter Officer Id:");
			str=str.append(bufferReader.readLine());
			if(str.toString().equals("")||Integer.parseInt(str.toString())<0) 
				throw new InvalidDataException();
			officer.setOfficerId(Integer.parseInt(str.toString()));
			
			System.out.println("Enter Officer First name:");
			str.setLength(0);
			str=str.append(bufferReader.readLine());
			if(str.toString().equals("")) 
				throw new InvalidDataException();
			officer.setFirstName(str.toString());
			
			System.out.println("Enter Officer Last name:");
			str.setLength(0);
			str=str.append(bufferReader.readLine());
			if(str.toString().equals("")) 
				throw new InvalidDataException();
			officer.setLastName(str.toString());
			
			System.out.println("Enter Officer Badge No:");
			str.setLength(0);
			str=str.append(bufferReader.readLine());
			if(str.toString().equals("")) 
				throw new InvalidDataException();
			officer.setBadgeNo(str.toString());
			
			System.out.println("Enter Officer's Rank:");
			str.setLength(0);
			str=str.append(bufferReader.readLine());
			if(str.toString().equals("")) 
				throw new InvalidDataException();
			officer.setRank(str.toString());
			
			System.out.println("Enter Officer's contact info:");
			str.setLength(0);
			str=str.append(bufferReader.readLine());
			if(str.toString().equals("")) 
				throw new InvalidDataException();
			officer.setContactInfo(str.toString());
			
			System.out.println("Enter Officer's Agency Id:");
			str.setLength(0);
			str=str.append(bufferReader.readLine());
			if(str.toString().equals("")||Integer.parseInt(str.toString())<0) 
				throw new InvalidDataException();
			
			for(LawEnforcementAgencies l:LawEnforcementAgencyController.agencyList) {
				if(l.getAgencyId()==Integer.parseInt(str.toString())) {
					officer.setAgency(l);
					break;
				}
			}
			
			boolean containsObject = officerList.stream()
	                .anyMatch(obj -> obj.getOfficerId()==officer.getOfficerId());
			
			
			if(containsObject) {
				throw new DuplicateDataException();
			}
			
			officerList.add(officer);
			officerDataAccessObject.addOfficer(officer);
			
		}catch(IOException e) {
			e.printStackTrace();
		} catch (InvalidDataException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		} catch (DuplicateDataException e) {
			System.err.println(e);
		}
	}
	
 /**
     * Displays information about the officers in the {@code officerList}.
     */
	public void displayOfficers() {
		for(Officers officer:officerList) {
			System.out.println(officer);
		}
	}
	
 /**
     * Retrieves and displays an officer by their ID.
     *
     * @param id The ID of the officer to retrieve.
     * @throws RecordNotFoundException If the officer with the specified ID is not found.
     */
	public void getOfficerById(int id) throws RecordNotFoundException {
		boolean isAvailable=false;
		for(Officers o:officerList) {
			if(o.getOfficerId()==id) {
				System.out.println(o);
				return;
			}
		}
		if(isAvailable==false)
			throw new RecordNotFoundException();
	}
}
