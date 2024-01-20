package com.test.hexaware;

import static org.junit.Assert.assertTrue;

import com.hexaware.controller.LawEnforcementAgencyController;
import com.hexaware.controller.SuspectController;
import com.hexaware.controller.VictimController;
import com.hexaware.dao.IncidentDao;
import com.hexaware.entity.Incidents;
import java.time.LocalDate;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test class for {@link IncidentDao}.
 */
public class IncidentDaoTest {
    
  /** The IncidentDao instance used for testing. */
  private static IncidentDao testIncidentDao;
  private static VictimController testVictimController;
  private static SuspectController testSuspectController;
  private static LawEnforcementAgencyController testLawEnforcementAgencyController;
    
  /**
   * Sets up the test class. This method is executed before any test method is run.
   */
  @BeforeClass
  public static void setUpClass() { 
    testIncidentDao = new IncidentDao();
    testVictimController = new VictimController();
    testSuspectController = new SuspectController();
    testLawEnforcementAgencyController = new LawEnforcementAgencyController();
    testVictimController.putVictimsToArray();
    testSuspectController.putSuspectsToArray();
    testLawEnforcementAgencyController.putAgenciesToArray();
  }

  /**
   * Test case for {@link IncidentDao#insertIncident(int, String, LocalDate, 
   * String, String, String, int, int, int)}.
   * Verifies the insertion of an incident.
   */
  @Test
   public void testInsertIncident() {
    assertTrue(testIncidentDao.insertIncident(9, "Test", LocalDate.parse("2023-09-09"),
               "testlocation", "testDescr", "CLOSED", 1, 2, 1));
  }

  /**
   * Test case for {@link IncidentDao#updateIncidentStatus(int, String)}.
   * Verifies the update of incident status.
   */
  @Test
   public void testUpdateIncidentStatus() {
    assertTrue(testIncidentDao.updateIncidentStatus(3, "UNDER_INVESTIGATION"));
  }

  /**
   * Test case for {@link IncidentDao#updateIncident(Incidents)}.
   * Verifies the update of a particular incident record.
   */
  @Test
  public void testUpdateIncident() {
      
    Incidents testIncident = new Incidents();
    testIncident.setIncidentId(3);
    testIncident.setIncidentType("Test");
    testIncident.setIncidentDate(LocalDate.now());
    testIncident.setLocation("Test Updated Location");
    testIncident.setDescription("Test Updated Description");
    testIncident.setStatus("CLOSED");
      
    testIncident.setVictim(testVictimController.victimList.get(0));
    testIncident.setSuspect(testSuspectController.suspectsList.get(0));
    testIncident.setAgency(testLawEnforcementAgencyController.agencyList.get(0));

    assertTrue(testIncidentDao.updateIncident(testIncident));
  }
  
  /**
   * Tears down the test class. This method is executed after all test methods are run.
   */
  @AfterClass
  public static void tearDownClass() { 

  }
}
