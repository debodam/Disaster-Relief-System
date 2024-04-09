package edu.ucalgary.oop;

/**
 * This class represents an individual making inquiries with their contact information.
 */
public class Inquirer {
    private final String FIRST_NAME;     //The first name of the inquirer
    private final String LAST_NAME;      //The last name of the inquirer
    private final String SERVICES_PHONE; //The phone number of the service

    /**
     * Constructs an {@code Inquirer} object with the specified details.
     *
     * @param firstName the first name of the inquirer
     * @param lastName the last name of the inquirer
     * @param phone the phone number for services
     */
    public Inquirer(String firstName, String lastName, String phone) {
        this.FIRST_NAME = firstName;
        this.LAST_NAME = lastName;
        this.SERVICES_PHONE = phone;
    }

    /**
     * Returns the first name of the inquirer.
     *
     * @return the first name of the inquirer
     */
    public String getFirstName() { return this.FIRST_NAME; }

    /**
     * Returns the last name of the inquirer.
     *
     * @return the last name of the inquirer
     */
    public String getLastName() { return this.LAST_NAME; }

    /**
     * Returns the phone number for services.
     *
     * @return the phone number for services
     */
    public String getServicesPhoneNum() { return this.SERVICES_PHONE; }
}
