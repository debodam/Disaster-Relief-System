package edu.ucalgary.oop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This class represents a medical record associated with a specific location and treatment information.
 * It contains details about the treatment received, including the date of treatment.
 */
public class MedicalRecord {
    private Location location;
    private String treatmentDetails;
    private String dateOfTreatment;

    /**
     * Constructs a MedicalRecord object with specified location, treatment details, and date of treatment.
     *
     * @param location         The location associated with the medical record
     * @param treatmentDetails Details of the treatment received
     * @param dateOfTreatment  The date of the treatment in the format "YYYY-MM-DD"
     * @throws IllegalArgumentException if the date format of dateOfTreatment is invalid
     */
    public MedicalRecord(Location location, String treatmentDetails, String dateOfTreatment) throws IllegalArgumentException {
        setLocation(location);
        this.treatmentDetails = treatmentDetails;

        // Check if the treatmentDetails string matches the expected date format
        if (!isValidDateFormat(dateOfTreatment)) {
            throw new IllegalArgumentException("Invalid date format for treatment details. Expected format: YYYY-MM-DD");
        }
        this.dateOfTreatment = dateOfTreatment;
    }

    
    /**
     * Returns the location associated with this medical record.
     *
     * @return The location associated with the medical record
     */
    public Location getLocation() {
        return location;
    }

    
    /**
     * Sets the location associated with this medical record.
     *
     * @param location The location to set
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Returns the details of the treatment received.
     *
     * @return The treatment details
     */
    public String getTreatmentDetails() {
        return treatmentDetails;
    }

    /**
     * Sets the details of the treatment received.
     *
     * @param treatmentDetails The treatment details to set
     */
    public void setTreatmentDetails(String treatmentDetails) throws IllegalArgumentException {
        this.treatmentDetails = treatmentDetails;
    }

    /**
     * Returns the date of the treatment in the format "YYYY-MM-DD".
     *
     * @return The date of treatment
     */
    public String getDateOfTreatment() {
        return dateOfTreatment;
    }

    /**
     * Sets the date of the treatment.
     *
     * @param dateOfTreatment The date of treatment to set (format: "YYYY-MM-DD")
     * @throws IllegalArgumentException if the date format is invalid
     */
    public void setDateOfTreatment(String dateOfTreatment) throws IllegalArgumentException {
        // Check if the date of treatment string matches the expected date format
        if (!isValidDateFormat(dateOfTreatment)) {
            throw new IllegalArgumentException("Invalid date format. Expected format: YYYY-MM-DD");
        }
        this.dateOfTreatment = dateOfTreatment;
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
}
