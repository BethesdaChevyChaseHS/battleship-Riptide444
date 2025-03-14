package bcc.battleship;

public class Grid {
    
    private Location[][] gridLocations;
    
    // Create a new Grid and initialize each Location.
    public Grid() {
        gridLocations = new Location[Constants.NUM_ROWS][Constants.NUM_COLS];
        for (int j = 0; j < gridLocations.length; j++) {
            for (int k = 0; k < gridLocations[0].length; k++) {
                gridLocations[k][j] = new Location();
            }
        }
    }
    
    // Mark a hit in the specified location.
    public void markHit(int row, int col) {
       gridLocations[row][col].markHit();
    }
    
    // Mark a miss in the specified location.
    public void markMiss(int row, int col) {
        gridLocations[row][col].markMiss();
    }
    
    // Set the status of the Location at (row, col).
    public void setStatus(int row, int col, int status) {
        gridLocations[row][col].setStatus(status);
    }
    
    // Get the status of the Location at (row, col).
    public int getStatus(int row, int col) {
        return gridLocations[row][col].getStatus();
    }
    
    // Return whether this Location has already been guessed.
    public boolean alreadyGuessed(int row, int col) {
        return gridLocations[row][col].getStatus() != Constants.UNGUESSED;
    }
    
    // Set whether there is a ship at this location.
    public void setShip(int row, int col, boolean val) {
        gridLocations[row][col].setShip(val);
    }
    
    // Return whether there is a ship at this location.
    public boolean hasShip(int row, int col) {
        return gridLocations[row][col].hasShip();
    }
    
    // Get the Location object at this row and column.
    public Location get(int row, int col) {
        return gridLocations[row][col];
    }
    
    // Return the number of rows.
    public int numRows() {
        return gridLocations.length;
    }
    
    // Return the number of columns.
    public int numCols() {
        return gridLocations[0].length;
    }
    

    //maybe convert to boolean?
    public boolean addShip(Ship s) {
        if(s.getDirection() == Constants.HORIZONTAL) {
            for(int i = s.getCol(); i < (s.getCol() + s.getLength()); i++) {
                if (i >= gridLocations[0].length) {
                    return false;
                } else if (gridLocations[s.getRow()][i].hasShip()) {
                    return false;
                } else {
                    gridLocations[s.getRow()][i].setShip(true);
                }
            }
        } else {
            for(int i = s.getRow(); i < (s.getRow() + s.getLength()); i++) {
                if (i >= gridLocations.length) {
                    return false;
                } else if (gridLocations[i][s.getCol()].hasShip()) {
                    return false;
                } else {
                    gridLocations[i][s.getCol()].setShip(true);
                }
            }
        }

        return true;
    }

    public boolean allShipsSank(){
        for (Location[] row : gridLocations) {
            for (Location location : row) {
                if (location.hasShip() && !location.checkHit()) {
                    return false;
                }
            }
        }
        return true;
    }
}
