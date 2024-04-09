package edu.ucalgary.oop;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class DisasterVictim {
    private static int counter = 0;

    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private final int assignedSocialId;
    private List<FamilyRelation> familyConnections = new ArrayList<>();
    private List<MedicalRecord> medicalRecords = new ArrayList<>();
    private List<Supply> personalBelongings = new ArrayList<>();
    private final String entryDate;
    private String gender;
    private String comments;
    private List<DietaryInitiative> dietaryInitiatives = new ArrayList<>();

    /**
     * Constructs a DisasterVictim object with a given first name and entry date.
     * @param firstName The first name of the victim.
     * @param entryDate The entry date in the format "YYYY-MM-DD".
     * @throws IllegalArgumentException If the entry date is not in the correct format.
     */
    public DisasterVictim(String firstName, String entryDate) {
        this.firstName = firstName;
        if (!isValidDateFormat(entryDate)) {
            throw new IllegalArgumentException("Invalid date format for entry date. Expected format: YYYY-MM-DD");
        }
        this.entryDate = entryDate;
        this.assignedSocialId = generateSocialID();
    }

    
    /**
     * Generates a unique social ID for each victim.
     * @return The assigned social ID.
     */
    private static int generateSocialID() {
        counter++;
        return counter;
    }

    
    /**
     * Checks if the given date string is in the correct format (YYYY-MM-DD).
     * @param date The date string to validate.
     * @return true if the date is in the correct format, false otherwise.
     */
    private static boolean isValidDateFormat(String date) {
        String dateFormatPattern = "^\\d{4}-\\d{2}-\\d{2}$";
        return date.matches(dateFormatPattern);
    }

    /**
     * Gets the first name of the victim.
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the victim.
     * @param firstName The first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the victim.
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }


    /**
     * Sets the last name of the victim.
     * @param lastName The last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the date of birth of the victim.
     * @return The date of birth.
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the date of birth of the victim.
     * @param dateOfBirth The date of birth to set.
     * @throws IllegalArgumentException If the date of birth is not in the correct format.
     */
    public void setDateOfBirth(String dateOfBirth) {
        if (!isValidDateFormat(dateOfBirth)) {
            throw new IllegalArgumentException("Invalid date format for date of birth. Expected format: YYYY-MM-DD");
        }
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets the assigned social ID of the victim.
     * @return The assigned social ID.
     */
    public int getAssignedSocialId() {
        return assignedSocialId;
    }

    /**
     * Gets the list of family connections associated with the victim.
     * @return The list of family connections.
     */
    public List<FamilyRelation> getFamilyConnections() {
        return familyConnections;
    }

    /**
     * Gets the list of medical records associated with the victim.
     * @return The list of medical records.
     */
    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    /**
     * Gets the list of personal belongings of the victim.
     * @return The list of personal belongings.
     */
    public List<Supply> getPersonalBelongings() {
        return personalBelongings;
    }

    /**
     * Sets the list of family connections associated with the victim.
     * @param connections The list of family connections to set.
     */
    public void setFamilyConnections(List<FamilyRelation> connections) {
        this.familyConnections.clear();
        this.familyConnections.addAll(connections);
    }

    /**
     * Sets the list of medical records associated with the victim.
     * @param records The list of medical records to set.
     */
    public void setMedicalRecords(List<MedicalRecord> records) {
        this.medicalRecords.clear();
        this.medicalRecords.addAll(records);
    }

    /**
     * Sets the list of personal belongings of the victim.
     * @param belongings The list of personal belongings to set.
     */
    public void setPersonalBelongings(List<Supply> belongings) {
        this.personalBelongings.clear();
        this.personalBelongings.addAll(belongings);
    }

    /**
     * Gets the list of dietary initiatives for the victim.
     * @return The list of dietary initiatives.
     */
    public List<DietaryInitiative> getDietaryInitiatives() {
        return this.dietaryInitiatives;
    }

    /**
     * Sets the list of dietary initiatives for the victim.
     * @param dietaryInitiatives The list of dietary initiatives to set.
     */
    public void setDietaryInitiatives(List<DietaryInitiative> dietaryInitiatives) {
        this.dietaryInitiatives = dietaryInitiatives;
    }


    public void addPersonalBelonging(Supply supply) {
        if (supply.getQuantity() > 0) {
            supply.setQuantity(supply.getQuantity() - 1); //Once the supply is added to the disaster victim, it is removed from supplies
            this.personalBelongings.add(supply);
        }
    }


    public void removePersonalBelonging(Supply unwantedSupply) {
        unwantedSupply.setQuantity(unwantedSupply.getQuantity() + 1); //Once the supply is removed from the disaster victim, it is added back to supplies
        this.personalBelongings.remove(unwantedSupply);
    }


    public void removeFamilyConnection(FamilyRelation exRelation) {
        DisasterVictim personOne = exRelation.getPersonOne();
        DisasterVictim personTwo = exRelation.getPersonTwo();

        if (personOne.equals(this)) {
            this.familyConnections.remove(exRelation);
            personTwo.familyConnections.remove(exRelation);
        } else {
            this.familyConnections.remove(exRelation);
            personOne.familyConnections.remove(exRelation);
        }

        // For each relation in Person One, remove Person Two from it if exists.
        // Each person one connection
        for (FamilyRelation relation: personOne.getFamilyConnections()) {
            if (!relation.getPersonOne().equals(personOne)) {
                // Each person one connection's connections (not Peace)
                for (FamilyRelation relation2: relation.getPersonOne().getFamilyConnections()) {
                    if (relation2.getPersonOne().equals(personTwo) || relation2.getPersonTwo().equals(personTwo)) {
                        relation.getPersonOne().familyConnections.remove(relation2);
                        break;
                    }
                }
            } else {
                // Each person one connection's connections (not Peace)
                for (FamilyRelation relation2: relation.getPersonTwo().getFamilyConnections()) {
                    if (relation2.getPersonOne().equals(personTwo) || relation2.getPersonTwo().equals(personTwo)) {
                        relation.getPersonTwo().familyConnections.remove(relation2);
                        break;
                    }
                }
            }
        }

        // For each relation in Person Two, remove Person One from it if exists.
        // Each person two connection
        for (FamilyRelation relation: personTwo.getFamilyConnections()) {
            if (!relation.getPersonOne().equals(personTwo)) {
                // Each person two connection's connections (not Peace)
                for (FamilyRelation relation2: relation.getPersonOne().getFamilyConnections()) {
                    if (relation2.getPersonOne().equals(personOne) || relation2.getPersonTwo().equals(personOne)) {
                        relation.getPersonOne().familyConnections.remove(relation2);
                        break;
                    }
                }
            } else {
                // Each person two connection's connections (not Peace)
                for (FamilyRelation relation2: relation.getPersonTwo().getFamilyConnections()) {
                    if (relation2.getPersonOne().equals(personOne) || relation2.getPersonTwo().equals(personOne)) {
                        relation.getPersonTwo().familyConnections.remove(relation2);
                        break;
                    }
                }
            }
        }
    }


    public void addFamilyConnection(FamilyRelation record) {
        // Add to all of current victim's relations
        for (FamilyRelation relation: familyConnections) {
            if (!relation.getPersonOne().equals(this)) {
                FamilyRelation familyRelationObj = new FamilyRelation(relation.getPersonOne(), record.getRelationshipTo(), record.getPersonTwo());

                boolean found1 = false;
                for (FamilyRelation innerRelation: relation.getPersonOne().familyConnections) {
                    if (innerRelation.getPersonOne().equals(relation.getPersonOne()) && innerRelation.getPersonTwo().equals(record.getPersonTwo())) {
                        found1 = true;
                        break;
                    }
                }

                if (!found1) {
                    relation.getPersonOne().familyConnections.add(familyRelationObj);
                }

                boolean found2 = false;
                for (FamilyRelation innerRelation: record.getPersonTwo().familyConnections) {
                    if (innerRelation.getPersonOne().equals(relation.getPersonOne()) && innerRelation.getPersonTwo().equals(record.getPersonTwo())) {
                        found2 = true;
                        break;
                    }
                }

                if (!found2) {
                    record.getPersonTwo().familyConnections.add(familyRelationObj);
                }
            } else {
                FamilyRelation familyRelationObj = new FamilyRelation(relation.getPersonTwo(), record.getRelationshipTo(), record.getPersonTwo());

                boolean found1 = false;
                for (FamilyRelation innerRelation: relation.getPersonTwo().familyConnections) {
                    if (innerRelation.getPersonOne().equals(relation.getPersonTwo()) && innerRelation.getPersonTwo().equals(record.getPersonTwo())) {
                        found1 = true;
                        break;
                    }
                }

                if (!found1) {
                    relation.getPersonTwo().familyConnections.add(familyRelationObj);
                }

                boolean found2 = false;
                for (FamilyRelation innerRelation: record.getPersonTwo().familyConnections) {
                    if (innerRelation.getPersonOne().equals(relation.getPersonTwo()) && innerRelation.getPersonTwo().equals(record.getPersonTwo())) {
                        found2 = true;
                        break;
                    }
                }

                if (!found2) {
                    record.getPersonTwo().familyConnections.add(familyRelationObj);
                }
            }
        }
        
        record.getPersonOne().familyConnections.add(record);
        record.getPersonTwo().familyConnections.add(record);
    }


    public String getEntryDate() {
        return entryDate;
    }


    public String getComments() {
        return comments;
    }


    public void setComments(String comments) {
        this.comments = comments;
    }


    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        try {
            boolean valid = false;
            File genderFile = new File("GenderOptions.txt");
            Scanner genderVerifier = new Scanner(genderFile);
            while (genderVerifier.hasNextLine()) {
                if (gender.toLowerCase().equals(genderVerifier.nextLine().replaceAll("[\r\n]", ""))) {
                    valid = true;
                }
            }
            genderVerifier.close();
            
            if (!valid) {
                throw new IllegalArgumentException("Invalid gender. Acceptable values are male, female, or other.");
            }
            this.gender = gender.toLowerCase();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static enum DietaryInitiative {
        ASIAN_VEGETARIAN("Asian vegetarian meal"),
        DIABETIC("Diabetic meal"),
        GLUTEN_FREE("Gluten intolerant meal"),
        KOSHER("Kosher meal"),
        LOW_SALT("Low salt meal"),
        MUSLIM("Muslim meal"),
        PEANUT_FREE("Peanut-free meal"),
        VEGAN("Vegan meal"),
        VEGETARIAN_JAIN("Vegetarian Jain meal");
    
        private final String description;
    
        DietaryInitiative(String description) {
            this.description = description;
        }
    
        public String getDescription() {
            return description;
        }
    
        public static DietaryInitiative fromString(String text) {
            for (DietaryInitiative initiative : DietaryInitiative.values()) {
                if (initiative.name().equalsIgnoreCase(text)) {
                    return initiative;
                }
            }
            throw new IllegalArgumentException("No such dietary initiative: " + text);
        }
    }
}
