package edu.ucalgary.oop;

/**
 * This class represents a family relationship between disaster victims.
 */
public class FamilyRelation {
    private DisasterVictim personOne;
    private String relationshipTo;
    private DisasterVictim personTwo;

    /**
     * Constructs a new FamilyRelation object.
     *
     * @param personOne The first disaster victim involved in the relationship.
     * @param relationshipTo The type of relationship between personOne and personTwo.
     * @param personTwo The second disaster victim involved in the relationship.
     */
    public FamilyRelation(DisasterVictim personOne, String relationshipTo, DisasterVictim personTwo) {
        this.personOne = personOne;
        this.relationshipTo = relationshipTo;
        this.personTwo = personTwo;
    }

    
    /**
     * Retrieves the first disaster victim involved in this family relationship.
     *
     * @return The first disaster victim.
     */
    public DisasterVictim getPersonOne() {
        return personOne;
    }

    
    /**
     * Sets the first disaster victim involved in this family relationship.
     *
     * @param personOne The new value for the first disaster victim.
     */
    public void setPersonOne(DisasterVictim personOne) {
        this.personOne = personOne;
    }

    /**
     * Retrieves the type of relationship between the two disaster victims.
     *
     * @return The relationship type (e.g., "parent", "sibling", "spouse").
     */
    public String getRelationshipTo() {
        return relationshipTo;
    }

    /**
     * Sets the type of relationship between the two disaster victims.
     *
     * @param relationshipTo The new relationship type to be set.
     */
    public void setRelationshipTo(String relationshipTo) {
        this.relationshipTo = relationshipTo;
    }

    /**
     * Retrieves the second disaster victim involved in this family relationship.
     *
     * @return The second disaster victim.
     */
    public DisasterVictim getPersonTwo() {
        return personTwo;
    }

    /**
     * Sets the second disaster victim involved in this family relationship.
     *
     * @param personTwo The new value for the second disaster victim.
     */
    public void setPersonTwo(DisasterVictim personTwo) {
        this.personTwo = personTwo;
    }
}
