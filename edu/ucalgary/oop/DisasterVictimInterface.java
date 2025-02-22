package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class represents an interface for managing disaster victim information.
 */
public class DisasterVictimInterface {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<DisasterVictim> victims = new ArrayList<>();

    
    /**
     * Main method to run the Disaster Victim Information System.
     * @param args Command-line arguments (not used in this application)
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the Disaster Victim Information System");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Enter a new Disaster Victim");
            System.out.println("2. View all entered Disaster Victims");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    enterNewDisasterVictim();
                    break;
                case 2:
                    viewAllDisasterVictims();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close(); 
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    /**
     * Method to enter details for a new Disaster Victim and add to the list.
     */
    private static void enterNewDisasterVictim() {
        System.out.println("\nEnter details for the new Disaster Victim:");

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Entry Date (YYYY-MM-DD): ");
        String entryDate = scanner.nextLine();

        DisasterVictim victim = new DisasterVictim(firstName, entryDate);

        System.out.print("Last Name: ");
        victim.setLastName(scanner.nextLine());

        System.out.print("Date of Birth (YYYY-MM-DD): ");
        victim.setDateOfBirth(scanner.nextLine());

        System.out.print("Gender: ");
        victim.setGender(scanner.nextLine());

        System.out.print("Comments: ");
        victim.setComments(scanner.nextLine());

        victims.add(victim);
        System.out.println("Disaster Victim information entered successfully.");

    }

    /**
     * Method to display all entered Disaster Victims.
     */
    private static void viewAllDisasterVictims() {
        if (victims.isEmpty()) {
            System.out.println("No Disaster Victims entered yet.");
            return;
        }

        System.out.println("\nAll Entered Disaster Victims:");
        for (int i = 0; i < victims.size(); i++) {
            System.out.println("Victim #" + (i + 1) + ":");
            displayVictimDetails(victims.get(i));
        }
    }

    
    /**
     * Method to display details of a single Disaster Victim.
     * @param victim The DisasterVictim object to display details for
     */
    private static void displayVictimDetails(DisasterVictim victim) {
        System.out.println("First Name: " + victim.getFirstName());
        System.out.println("Last Name: " + victim.getLastName());
        System.out.println("Date of Birth: " + victim.getDateOfBirth());
        System.out.println("Gender: " + victim.getGender());
        System.out.println("Entry Date: " + victim.getEntryDate());
        System.out.println("Comments: " + victim.getComments());
    }
}
