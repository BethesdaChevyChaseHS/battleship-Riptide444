package bcc.battleship;

public class Ship {

    private int row;
    private int column;
    private int length;
    private int direction;

    // Constructor. Create a ship and set the length.
    public Ship(int length) {
        this.length = length;
        this.row = Constants.UNSET;
        this.column = Constants.UNSET;
        this.direction = Constants.UNSET;
    }

    // Has the location been initialized
    public boolean isLocationSet() {
        if (this.row != Constants.UNSET && this.column != Constants.UNSET) {
            return true;
        } else {
            return false;
        }
    }

    // Has the direction been initialized
    public boolean isDirectionSet() {
        if (this.direction != Constants.UNSET) {
            return true;
        } else {
            return false;
        }
    }

    // Set the location of the ship
    public void setLocation(int row, int col) {
        this.row = row;
        this.column = col;
    }

    // Set the direction of the ship
    public void setDirection(int direction) {
        this.direction = direction;
    }

    // Getter for the row value
    public int getRow() {
        return this.row;
    }

    // Getter for the column value
    public int getCol() {
        return this.column;
    }

    // Getter for the length of the ship
    public int getLength() {
        return this.length;
    }

    // Getter for the direction
    public int getDirection() {
        return this.direction;
    }

    // Helper method to get a string value from the direction
    private String directionToString() {
        if (this.direction == Constants.HORIZONTAL) {
            return "horizontal";
        } else if (this.direction == Constants.VERTICAL) {
            return "vertical";
        }
        return "unset direction";
    }

    // Helper method to get a (row, col) string value from the location
    private String locationToString() {
        if (this.row == Constants.UNSET || this.column == Constants.UNSET) {
            return "(unset location)";
        } else {
            return "(" + this.row + ", " + this.column + ")";
        }
    }

    // toString value for this Ship
    @Override
    public String toString() {
        return directionToString() + " ship of length " + length + " at " + locationToString();
    }
}