package EyeClear;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.text.SimpleDateFormat;
import java.util.Date;

class PrescriptionTest {
	
	private Date createExaminationDate(String dateString) {
        Date examinationDate = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            examinationDate = sdf.parse(dateString);
        } catch (Exception e) {
            fail("Date parsing failed");
        }
        return examinationDate;
    }
	
	//addPrescription test case
	
	
	//valid prescription 
	@Test
    void testValidPrescription() {
		Date examinationDate = createExaminationDate("2024-10-25");

        Prescription prescription1 = new Prescription(1, "John", "Doey", "123 Main Street, Suburb, 12345", 
                18.25f,  3.0f, 90f, examinationDate, "Williams");
        Prescription prescription2 = new Prescription(1, "Johnathan", "Doey", "123 Main Street, Suburb, 12345", 
        											19.99f,3.99f, 90f, examinationDate, "Williams");
        Prescription prescription3 = new Prescription(1, "John", "Doey", "123 Main Street, Suburb, 12345", 
        											18.00f, 3.99f, 179f, examinationDate, "Williams");
        
      
        assertTrue(prescription1.addPrescription(), "Valid prescription should return true");
        assertTrue(prescription2.addPrescription(), "Valid prescription should return true");
        assertTrue(prescription3.addPrescription(), "Valid prescription should return true");
    }
	
	//invalid name
	@Test
    void testInvalidName() {
		Date examinationDate = createExaminationDate("2024-10-25");

        Prescription prescription1 = new Prescription(1, "Joe", "Doey", "123MainStreet,Suburb,12345", 
                                                     21.25f, 3.0f, 90f, examinationDate, "Williams");
        Prescription prescription2 = new Prescription(3,"ClaudeAlexanders", "Doey", "123 Main Street, Suburb, 12345",
        												18.25f, 3.0f, 90f, examinationDate, "Williams");
        Prescription prescription3 = new Prescription(1, "John", "Doe", "123MainStreet,Suburb,12345", 
                										21.25f, 3.0f, 90f, examinationDate, "Williams");
        Prescription prescription4 = new Prescription(1, "John", "MaximianAlexande", "123MainStreet,Suburb,12345", 
                										21.25f, 3.0f, 90f, examinationDate, "Williams");
        
        
        assertFalse(prescription1.addPrescription(), "Valid prescription should return false");
        assertFalse(prescription2.addPrescription(), "Valid prescription should return false");
        assertFalse(prescription3.addPrescription(), "Valid prescription should return false");
        assertFalse(prescription4.addPrescription(), "Valid prescription should return false");
    }
	
	//invalid address
	@Test
    void testInvalidAddress() {
		Date examinationDate = createExaminationDate("2024-10-25");

        Prescription prescription = new Prescription(6, "John", "Doey", "1234 Short St, WXYZ", 
        		18.25f, 3.0f, 90f, examinationDate, "Alexander");
        
        
        
        assertFalse(prescription.addPrescription(), "Valid prescription should return false");
    }
	
	//invalid sphere value
	
	@Test
    void testInvalidSphere() {
		Date examinationDate = createExaminationDate("2024-10-25");

        Prescription prescription1 = new Prescription(1, "John", "Doey", "123 Main Street, Suburb, 12345", -20.01f, 3.0f, 90f, examinationDate, "Williams");
        Prescription prescription2 = new Prescription(1, "John", "Doey", "123 Main Street, Suburb, 12345", 20.01f, 3.0f, 90f, examinationDate, "Williams");
        
        
        
        assertFalse (prescription1.addPrescription(), "Valid prescription should return true");
        assertFalse (prescription2.addPrescription(), "Valid prescription should return true");
    }
	
	//invalid cylinder value
	
	@Test
    void testInvalidCylinder() {
		Date examinationDate = createExaminationDate("2024-10-25");

        Prescription prescription1 = new Prescription(1, "John", "Doey", "123 Main Street, Suburb, 12345", 18.25f, 4.01f, 90f, examinationDate, "Williams");
        Prescription prescription2 = new Prescription(1, "John", "Doey", "123 Main Street, Suburb, 12345", 18.25f, -4.01f, 90f, examinationDate, "Williams");
        
        assertFalse (prescription1.addPrescription(), "Valid prescription should return true");
        assertFalse (prescription2.addPrescription(), "Valid prescription should return true");
    }
	
	//invalid axis value
	@Test
    void testInvalidAxis() {
		Date examinationDate = createExaminationDate("2024-10-25");

        Prescription prescription1 = new Prescription(1, "John", "Doey", "123 Main Street, Suburb, 12345", 18.25f, 3.0f, -1f, examinationDate, "Williams");
        Prescription prescription2 = new Prescription(1, "John", "Doey", "123 Main Street, Suburb, 12345", 18.25f, 3.0f, 181f, examinationDate, "Williams");
        
        assertFalse (prescription1.addPrescription(), "Valid prescription should return true");
        assertFalse (prescription2.addPrescription(), "Valid prescription should return true");
    }
	//invalid optometrist 
	@Test
    void testInvalidOptometrist() {
		Date examinationDate = createExaminationDate("2024-10-25");

        Prescription prescription1 = new Prescription(1, "John", "Doey", "123 Main Street, Suburb, 12345", 18.25f, 3.0f, 90f, examinationDate, "Jullian");
        Prescription prescription2 = new Prescription(1, "John", "Doey", "123 Main Street, Suburb, 12345", 18.25f, 3.0f, 90f, examinationDate, "Willy Wonka Alexander First");
        
        assertFalse (prescription1.addPrescription(), "Valid prescription should return true");
        assertFalse (prescription2.addPrescription(), "Valid prescription should return true");
    }
	
	//addRemark test case
	//valid remark test case
	 @Test
	    void testValidRemark() {
	        Date examinationDate = createExaminationDate("2024-10-25");
	        Prescription prescription = new Prescription(1, "John", "Doey", "123 Main Street, Suburb, 12345",
	                18.25f, 3.0f, 90f, examinationDate, "Williams");

	        assertTrue(prescription.addRemark("Client vision is steadily improving now.", "client"), 
	                   "Valid remark should return true");
	        assertTrue(prescription.addRemark("The staff are very polite to us.", "optometrist"), 
	                   "Valid remark should return true");

	    }	
	//invalid test case with short remark
	 @Test
	    void testInvalidShortRemark() {
	        Date examinationDate = createExaminationDate("2024-10-25");
	        Prescription prescription = new Prescription(1, "John", "Doey", "123 Main Street, Suburb, 12345",
	                18.25f, 3.0f, 90f, examinationDate, "Williams");
	        //The remark is short
	        assertFalse(prescription.addRemark("My vision improved slightly yesterday", "client"), 
	                    "Remark should return false");
	        assertFalse(prescription.addRemark("Good", "client"), 
                    "Remark should return false");
	    }
	//invalid test case with long remark
	 void testInvalidLongRemark() {
	        Date examinationDate = createExaminationDate("2024-10-25");
	        Prescription prescription = new Prescription(1, "John", "Doey", "123 Main Street, Suburb, 12345",
	                18.25f, 3.0f, 90f, examinationDate, "Williams");
	       //The remark is long	        
	        assertFalse(prescription.addRemark("The client is experiencing improved vision but might need another checkup with the optometrist in a few months depending on their current situation", 
	        		"client"), 
                 "Remark should return false");
	        assertFalse(prescription.addRemark("The client vision is improved and feels the optometrist has done a great job, though they may require another checkup in a few months depending on how their condition progresses", 
	        		"optometrist"), 
                 "Remark should return false");
	        
	    }
	 
	//The remark does not start with upper case 
	 void testNoUppercaseRemark() {
	        Date examinationDate = createExaminationDate("2024-10-25");
	        Prescription prescription = new Prescription(1, "John", "Doey", "123 Main Street, Suburb, 12345",
	                18.25f, 3.0f, 90f, examinationDate, "Williams");
	       
	       
	        assertFalse(prescription.addRemark("client is experiencing improved vision but might need another checkup in a few months depending on their current situation", 
	        		"client"), 
                 "Remark should return false");
	        assertFalse(prescription.addRemark("the staff is very polite to the customer", 
	        		"client"), 
                 "Remark should return false");
	    }
	 
	//Invalid category test case 
	 @Test
	    void testInvalidCategory() {
	        Date examinationDate = createExaminationDate("2024-10-25");
	        Prescription prescription = new Prescription(1, "John", "Doey", "123 Main Street, Suburb, 12345",
	                18.25f, 3.0f, 90f, examinationDate, "Williams");

	        assertFalse(prescription.addRemark("A client vision is steadily improving now.", null), 
	                    "Null category should return false");
	        assertFalse(prescription.addRemark("A client vision is steadily improving now.","customer"), 
	        		"Category should return false");
	    }
	//Invalid exceeding number of remarks 
	 @Test
	 void testExceedingRemarksLimit() {
	     Date examinationDate = createExaminationDate("2024-10-25");
	     Prescription prescription = new Prescription(1, "John", "Doey", "123 Main Street, Suburb, 12345",
	             18.25f, 3.0f, 90f, examinationDate, "Williams");

	     prescription.addRemark("Client vision is steadily improving now.", "client");  
	     prescription.addRemark("The staff are very polite to us.", "optometrist");  

	     assertFalse(prescription.addRemark("Recieve good service by the optometrist.","client"), 
	                 "Remark should return true");
	 }


}
