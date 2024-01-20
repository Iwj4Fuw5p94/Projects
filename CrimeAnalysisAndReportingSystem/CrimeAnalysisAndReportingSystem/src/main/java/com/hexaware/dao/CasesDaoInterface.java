package com.hexaware.dao;
/**
 * The CasesDaoInterface interface defines the contract for interacting with the CasesDao class.
 * It includes methods to populate the list of cases and add new case details.
 */

import com.hexaware.entity.Cases;
public interface CasesDaoInterface {
  public void putCaseToArray();
  public void addCase(Cases cases);
}





