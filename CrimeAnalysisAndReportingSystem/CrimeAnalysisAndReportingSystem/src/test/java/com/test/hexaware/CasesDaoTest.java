package com.test.hexaware;

import static org.junit.Assert.assertTrue;

import com.hexaware.controller.IncidentController;
import com.hexaware.dao.CasesDao;
import com.hexaware.entity.Cases;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * JUnit test class for testing the functionality of CasesDao.
 */
public class CasesDaoTest {

  private static CasesDao testCasesDao;
  private static IncidentController testIncidentController;

  /**
   * Set up resources before the test class runs.
   */
  @BeforeClass
  public static void setUpClass() { 
    testCasesDao = new CasesDao();
    testIncidentController = new IncidentController();
    testIncidentController.putIncidentsToArray();
  }

  /**
   * Test case for adding a case to the database.
   */
  @Test 
  public void testAddCase() {
    Cases testCase = new Cases(1, "Case Description", testIncidentController.incidentList.get(0));
    assertTrue(testCasesDao.addCase(testCase));
  }

  /**
   * Test case for updating case details in the database.
   */
  @Test
  public void testUpdateCaseDetails() {
    Cases testCase = new Cases();
    testCase.setCaseId(1);
    testCase.setCaseDescription("Updated Case Description");
    testCase.setRelatedIncidents(testIncidentController.incidentList.get(0));

    assertTrue(testCasesDao.updateCaseDetails(testCase));
  }

  /**
   * Clean up resources after the test class has run.
   */
  @AfterClass
  public static void tearDown() {
    // Additional cleanup steps, if any
    testCasesDao = null;
    testIncidentController = null;
  }
}
