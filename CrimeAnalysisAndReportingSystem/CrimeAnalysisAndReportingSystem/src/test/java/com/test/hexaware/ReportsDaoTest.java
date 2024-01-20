package com.test.hexaware;

import static org.junit.Assert.assertTrue;

import com.hexaware.controller.IncidentController;
import com.hexaware.controller.OfficerController;
import com.hexaware.dao.ReportsDao;
import com.hexaware.entity.Reports;
import java.time.LocalDate;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * JUnit test class for testing the functionality of ReportsDao.
 */
public class ReportsDaoTest {

  private static ReportsDao testReportsDao;
  private static IncidentController testIncidentController;
  private static OfficerController testOfficerController;

  /**
   * Set up resources before the test class runs.
   */
  @BeforeClass
  public static void setUpClass() { 
    testReportsDao = new ReportsDao();
    testIncidentController = new IncidentController();
    testIncidentController.putIncidentsToArray();
    testOfficerController = new OfficerController();
    testOfficerController.putOfficersToArray();
  }

  /**
   * Test case for adding a report to the database.
   */
  @Test 
  public void testAddReport() {
    Reports testReport = new Reports(6, testIncidentController.incidentList.get(0),
        testOfficerController.officerList.get(0), LocalDate.parse("2023-01-01"),
        "Test Report details", "Test"); 
    assertTrue(testReportsDao.addReport(testReport));
  }

  /**
   * Clean up resources after the test class has run.
   */
  @AfterClass
  public static void tearDown() {
    // Additional cleanup steps, if any
    testReportsDao = null;
    testIncidentController = null;
    testOfficerController = null;
  }
}
