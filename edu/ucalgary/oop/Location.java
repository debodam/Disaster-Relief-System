package edu.ucalgary.oop;

import java.util.ArrayList;

/**
 * This class represents a location where disaster relief operations are managed.
 * It stores information about the location's name, address, occupants (DisasterVictim objects),
 * and supplies (Supply objects).
 */
public class Location {
    private String name;
    private String address;
    private ArrayList<DisasterVictim> occupants = new ArrayList<>(); 
    private ArrayList<Supply> supplies = new ArrayList<>(); 

    /**
     * Constructs a Location object with a specified name and address.
     *
     * @param name    The name of the location
     * @param address The address of the location
     */
    public Location(String name, String address) {
        this.name = name;
        this.address = address;
    }

    
    /**
     * Returns the name of the location.
     *
     * @return The name of the location
     */
    public String getName() {
        return name;
    }

    
    /**
     * Sets the name of the location.
     *
     * @param name The new name of the location
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /**
     * Returns the address of the location.
     *
     * @return The address of the location
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the location.
     *
     * @param address The new address of the location
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns a copy of the list of occupants in the location.
     *
     * @return A copy of the list of occupants
     */
    public ArrayList<DisasterVictim> getOccupants() {
        return new ArrayList<>(occupants); 
    }

    /**
     * Sets the occupants of the location.
     *
     * @param occupants The new list of occupants
     */
    public void setOccupants(ArrayList<DisasterVictim> occupants) {
        this.occupants = new ArrayList<>(occupants); 
    }

    /**
     * Returns a copy of the list of supplies stored at the location.
     *
     * @return A copy of the list of supplies
     */
    public ArrayList<Supply> getSupplies() {
        return new ArrayList<>(supplies); 
    }

    /**
     * Sets the supplies stored at the location.
     *
     * @param supplies The new list of supplies
     */
    public void setSupplies(ArrayList<Supply> supplies) {
        this.supplies = new ArrayList<>(supplies); 
    }

    /**
     * Adds a new occupant to the location.
     *
     * @param occupant The occupant to be added
     */
    public void addOccupant(DisasterVictim occupant) {
        occupants.add(occupant);
    }

    /**
     * Removes an occupant from the location.
     *
     * @param occupant The occupant to be removed
     */
    public void removeOccupant(DisasterVictim occupant) {
        occupants.remove(occupant);
    }

    /**
     * Adds a new supply to the location.
     *
     * @param supply The supply to be added
     */
    public void addSupply(Supply supply) {
        supplies.add(supply);
    }

    /**
     * Removes a supply from the location.
     *
     * @param supply The supply to be removed
     */
    public void removeSupply(Supply supply) {
        supplies.remove(supply);
    }
}
