package edu.ucalgary.oop;

/**
 * This class represents a supply item used in disaster relief operations.
 * It encapsulates information about the type of supply and its quantity.
 */
public class Supply {
    private String type;
    private int quantity;

    /**
     * Constructs a Supply object with the specified type and quantity.
     *
     * @param type     The type of supply
     * @param quantity The quantity of the supply
     */
    public Supply(String type, int quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    /**
     * Sets the type of the supply.
     *
     * @param type The type of supply to set
     */
    public void setType(String type) { this.type = type; }

    /**
     * Sets the quantity of the supply.
     *
     * @param quantity The quantity of supply to set
     */
    public void setQuantity(int quantity) { this.quantity = quantity; }

    /**
     * Returns the type of the supply.
     *
     * @return The type of supply
     */
    public String getType() { return this.type; }

    /**
     * Returns the quantity of the supply.
     *
     * @return The quantity of supply
     */
    public int getQuantity() { return this.quantity; }
}
