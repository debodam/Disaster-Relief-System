package edu.ucalgary.oop;


import org.junit.Test;
import static org.junit.Assert.*;

public class FamilyRelationTest {

    private DisasterVictim personOne = new DisasterVictim("John Dalan", "2024-01-19");
    private DisasterVictim personTwo = new DisasterVictim("Jane Dalan", "2024-02-20");
    private String relationshipTo = "sibling";
    private FamilyRelation testFamilyRelationObject = new FamilyRelation(personOne, relationshipTo, personTwo);
    
    @Test
    public void testObjectCreation() {
        assertNotNull(testFamilyRelationObject);
    }
	
    @Test
    public void testSetAndGetPersonOne() {
        DisasterVictim newPersonOne = new DisasterVictim("New Person", "2024-03-21");
        testFamilyRelationObject.setPersonOne(newPersonOne);
        assertEquals("setPersonOne should update personOne", newPersonOne, testFamilyRelationObject.getPersonOne());
    }

    @Test
    public void testSetAndGetPersonTwo() {
        DisasterVictim newPersonTwo = new DisasterVictim("Another Person", "2024-04-22");
        testFamilyRelationObject.setPersonTwo(newPersonTwo);
        assertEquals("setPersonTwo should update personTwo", newPersonTwo, testFamilyRelationObject.getPersonTwo());
    }

    @Test
    public void testPreventDuplicateData() {
        // Ensure that duplicate data is prevented
        FamilyRelation duplicateRelation = new FamilyRelation(personOne, relationshipTo, personTwo);
        personOne.addFamilyConnection(duplicateRelation);
        assertEquals("Duplicate data should not be allowed", 1, personOne.getFamilyConnections().size());
        assertEquals("Duplicate data should not be allowed", 1, personTwo.getFamilyConnections().size());
    }

    @Test
    public void testBidirectionalRelationship() {
        DisasterVictim personOne = new DisasterVictim("Peace", "2024-01-19");
        DisasterVictim personTwo = new DisasterVictim("Sam", "2024-02-20");
        FamilyRelation siblingRelationship = new FamilyRelation(personOne, "sibling", personTwo);
        personOne.addFamilyConnection(siblingRelationship);
        assertTrue("personOne should have a connection with siblingRelationship", personOne.getFamilyConnections().contains(siblingRelationship));
        assertTrue("personTwo should have a connection with siblingRelationship", personTwo.getFamilyConnections().contains(siblingRelationship));
    }

    @Test
    public void testStoreAllRelationships() {
        FamilyRelation siblingRelationship = new FamilyRelation(personOne, "sibling", personTwo);
        personOne.addFamilyConnection(siblingRelationship);
        // assertTrue("ERROR" + personOne.getFamilyConnections(), false);

        DisasterVictim personThree = new DisasterVictim("Diamond", "2024-03-21");
        FamilyRelation thirdRelation = new FamilyRelation(personOne, relationshipTo, personThree);
        personOne.addFamilyConnection(thirdRelation);
    
        assertEquals("All relationships in a series should be stored", 2, personOne.getFamilyConnections().size());
        assertEquals("All relationships in a series should be stored", 2, personTwo.getFamilyConnections().size());
        assertEquals("All relationships in a series should be stored" + personThree.getFamilyConnections().get(0).getPersonOne().getFirstName(), 2, personThree.getFamilyConnections().size());
    }
}
