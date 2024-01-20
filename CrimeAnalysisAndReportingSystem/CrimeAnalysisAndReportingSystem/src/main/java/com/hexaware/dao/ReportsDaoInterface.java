package com.hexaware.dao;

import com.hexaware.entity.Reports;

/**
 * Interface for the Reports DAO (Data Access Object).
 * Provides methods to interact with report data in the database,
 * including retrieval and addition operations.
 */
public interface ReportsDaoInterface {

  /**
   * Retrieves and populates the reports data into an array.
   */
  public void putReportsToArray();
    
  /**
   * Adds a new report to the database.
   *
   * @param report The report object to be added.
   * @return True if the report is successfully added, false otherwise.
   */
  public boolean addReport(Reports report);
}
