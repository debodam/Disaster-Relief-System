package edu.ucalgary.oop;

import org.junit.*;
import static org.junit.Assert.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class InquirerTest {
    
/* 
Define the values which will be used for tests
*/
private String expectedFirstName = "Joseph";
private String expectedLastName = "Bouillon";
private String expectedPhoneNumber = "+1-123-456-7890";
private String expectedMessage = "looking for my family members";
private Inquirer inquirer = new Inquirer(expectedFirstName, expectedLastName, expectedPhoneNumber);

/*
testObjectCreation -> means testing Inquirer constructor: 
   - What we need: To verify that an "Inquirer" object is successfully created.
   - Actual result: The name "Joseph Bouillon", the services phone number "+1-123-456-7890", and the provided info is "looking for my family members".
   - Expected Result: The test checks that the Inquirer object is not null, confirming successful object creation.
*/
    @Test
    public void testObjectCreation() {
        assertNotNull(inquirer);
    }

/*
testGetFirstName**: 
   - What we need: To ensure the "getFirstName()" method correctly returns the actual inquirer's first name.
   - Actual result: "Joseph".
   - Expected result: "inquirer.getFirstName()" should return "Joseph".
   */
    @Test
    public void testGetFirstName() {
        assertEquals("getFirstName() should return inquirer's first name", expectedFirstName, inquirer.getFirstName());
    }
	
/*
testGetLastName: 
   - What we need: To confirm that the "getLastName()" method accurately returns inquirer's last name.
   - Actual result:"Bouillon".
   - Expected result: "inquirer.getLastName()" should return "Bouillon".
*/
    @Test
    public void testGetLastName() {
        assertEquals("getLastName() should return inquirer's last name", expectedLastName, inquirer.getLastName());
    }
	
/*
testGetServicesPhoneNum**: 
   - What we need: To confirm that "getServicesPhoneNum()" method correctly returns the services phone number.
   - Actual result: "+1-123-456-7890".
   - Expected result: "inquirer.getServicesPhoneNum()" should return "+1-123-456-7890".
*/
    @Test
    public void testGetServicesPhoneNum() {

        assertEquals("getServicesPhoneNum() should return the correct Services Number",expectedPhoneNumber, inquirer.getServicesPhoneNum());
    }

    @Test
    public void testLogNewInquiry() throws SQLException {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/ensf380project", "oop", "ucalgary");
            
            // Prepare test data
            String firstName = "Dominik";
            String lastName = "Pflug";
            String phoneNumber = "123-456-9831";
            String details = "Test inquiry details";
    
            // Execute logNewInquiry method
            List<Inquirer> inquirers = new ArrayList<>();
            inquirers.add(new Inquirer(firstName, lastName, phoneNumber));
            
            InquirerInterface.setInquirers(inquirers);
            boolean inquiryLogged = InquirerInterface.logNewInquiry(connection, firstName, lastName, phoneNumber, details);
    
            assertTrue("There was an issue logging the inquiry", inquiryLogged);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue("Error Occurred" + e, false);
        }
    }

    @Test
    public void testSearchForInquirer() throws SQLException {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/ensf380project", "oop", "ucalgary");
            
            // Prepare test data
            String firstName = "Dominik";
            String lastName = "Pflug";
            String phoneNumber = "123-456-9831";
    
            // Execute logNewInquiry method
            String foundInquiry = InquirerInterface.searchForInquirer(connection, firstName);
            String expectedString = "Name: " + firstName + " " + lastName + ", Phone Number: " + phoneNumber;
    
            assertTrue("Queried inquirer was not found.", foundInquiry.contains(expectedString));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

