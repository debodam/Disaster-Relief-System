package edu.ucalgary.oop;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This class represents a relief service entry, detailing information about an inquiry related to a missing person.
 * It includes data such as the inquirer, missing person, date of inquiry, provided information, and last known location.
 */
public class ReliefService {
    private Inquirer inquirer;
    private DisasterVictim missingPerson;
    private String dateOfInquiry;
    private String infoProvided;
    private Location lastKnownLocation;

    /**
     * Constructs a ReliefService object with specified details.
     *
     * @param inquirer         The inquirer submitting the relief inquiry
     * @param missingPerson    The missing person being inquired about
     * @param dateOfInquiry    The date of the inquiry in the format "YYYY-MM-DD"
     * @param infoProvided     Information provided during the inquiry
     * @param lastKnownLocation The last known location of the missing person
     * @throws IllegalArgumentException if the date format of dateOfInquiry is invalid
     */
    public ReliefService(Inquirer inquirer, DisasterVictim missingPerson, String dateOfInquiry, String infoProvided, Location lastKnownLocation) {
        this.inquirer = inquirer;
        this.missingPerson = missingPerson;
        setDateOfInquiry(dateOfInquiry);
        this.infoProvided = infoProvided;
        this.lastKnownLocation = lastKnownLocation;
    }

    
    /**
     * Returns the inquirer associated with this relief service.
     *
     * @return The inquirer
     */
    public Inquirer getInquirer() {
        return inquirer;
    }

    
    /**
     * Sets the inquirer associated with this relief service.
     *
     * @param inquirer The inquirer to set
     */
    public void setInquirer(Inquirer inquirer) {
        this.inquirer = inquirer;
    }

    /**
     * Returns the missing person associated with this relief service.
     *
     * @return The missing person
     */
    public DisasterVictim getMissingPerson() {
        return missingPerson;
    }

    /**
     * Sets the missing person associated with this relief service.
     *
     * @param missingPerson The missing person to set
     */
    public void setMissingPerson(DisasterVictim missingPerson) {
        this.missingPerson = missingPerson;
    }

    /**
     * Returns the date of the inquiry in the format "YYYY-MM-DD".
     *
     * @return The date of inquiry
     */
    public String getDateOfInquiry() {
        return dateOfInquiry;
    }

    /**
     * Sets the date of the inquiry.
     *
     * @param dateOfInquiry The date of inquiry to set (format: "YYYY-MM-DD")
     * @throws IllegalArgumentException if the date format is invalid
     */
    public void setDateOfInquiry(String dateOfInquiry) {
        // Check if the dateOfInquiry string matches the expected date format
        if (!isValidDateFormat(dateOfInquiry)) {
            throw new IllegalArgumentException("Invalid date format for date of inquiry. Expected format: YYYY-MM-DD");
        }
        this.dateOfInquiry = dateOfInquiry;
    }

    /**
     * Returns the information provided during the inquiry.
     *
     * @return The information provided
     */
    public String getInfoProvided() {
        return infoProvided;
    }

    /**
     * Sets the information provided during the inquiry.
     *
     * @param infoProvided The information provided to set
     */
    public void setInfoProvided(String infoProvided) {
        this.infoProvided = infoProvided;
    }

    /**
     * Returns the last known location of the missing person.
     *
     * @return The last known location
     */
    public Location getLastKnownLocation() {
        return lastKnownLocation;
    }

    /**
     * Sets the last known location of the missing person.
     *
     * @param lastKnownLocation The last known location to set
     */
    public void setLastKnownLocation(Location lastKnownLocation) {
        this.lastKnownLocation = lastKnownLocation;
    }

    /**
     * Helper method to check if a string matches the "YYYY-MM-DD" date format.
     *
     * @param date The date string to validate
     * @return True if the date string matches the format, false otherwise
     */
    private boolean isValidDateFormat(String date) {
        try {
            LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Returns a string representation of the relief service entry's details.
     *
     * @return A string containing details of the relief service entry
     */
    public String getLogDetails() {
        return "Inquirer: " + inquirer.getFirstName() + 
            ", Missing Person: " + missingPerson.getFirstName() + 
            ", Date of Inquiry: " + dateOfInquiry + 
            ", Info Provided: " + infoProvided + 
            ", Last Known Location: " + lastKnownLocation.getName();
    }
}
