
package cs1hanoi;

public class Hanoi {
    
    private int numDisks;
    private int[][] pegs; //holds all the disks and their respective pegs
    private int[] lastNonZeroElement; //holds index of last disk for each peg
    
    /**
     * Constructor for class Hanoi: sets up instance variables
     * @param pnumDisks Number of total disks
     */
    public Hanoi(int pnumDisks) {
        
        numDisks = pnumDisks;
        pegs = new int[3][numDisks];
        
        //sets up beginning position: all disks at first peg
        for (int i = 0; i < numDisks; i++) {
            pegs[0][i] = numDisks-i;
        }
        
        //setting up where the lastNonZeroElement of each peg is
        lastNonZeroElement = new int[3];
        lastNonZeroElement[0] = numDisks-1;
        lastNonZeroElement[1] = -1;
        lastNonZeroElement[2] = -1;
        
    }
    
    /**
     * Returns numDisks, a private instance variable
     * @return numDisks, an int that holds the current number of total disks
     */
    public int getNumDisks() {
        return numDisks;
    }
    
    /**
     * Moves the top disk on one peg to another, while handling errors
     * @param pegStart Indicates the peg where the disk is being moved from
     * @param pegEnd Indicates the peg where the disk is being moved to
     */
    public void move(int pegStart, int pegEnd) {
        
    //finds the disk that needs to be moved
        int diskToMove = pegs[pegStart][lastNonZeroElement[pegStart]];
        
    //finds the disk that the moved disk is going to be moved over;
    //..in the event that the peg is empty, the disk is treated as 0
        
        int diskToMoveOver;
        if (lastNonZeroElement[pegEnd] == -1) {
            diskToMoveOver = 0;
        }
        else {
            diskToMoveOver = pegs[pegEnd][lastNonZeroElement[pegEnd]];
        }
        
    //checks to ensure that diskToMoveOver is not smaller than diskToMove
        if (diskToMoveOver != 0 && diskToMoveOver < diskToMove) {
            System.out.println("Trying to move a disk over a smaller disk");
            System.exit(-1);
        }
        
    //proceeds with moving the disk, altering pegs and lastNonZeroElement
        pegs[pegStart][lastNonZeroElement[pegStart]] = 0;
        lastNonZeroElement[pegStart]--;
        pegs[pegEnd][lastNonZeroElement[pegEnd]+1] = diskToMove;
        lastNonZeroElement[pegEnd]++;
        
    }
    
    /**
     * Creates String representation of hanoi object to be printed
     * @return toString, a String that represents current state of hanoi
     */
    @Override
    public String toString() {
        
        //maps [0, 1, 2] => ["A", "B", "C"]
        final String numtoPeg = "ABC";
        
        String toString = "";
        
        for (int i = 0; i < 3; i++) 
        {
            toString += numtoPeg.charAt(i);
            toString += ": ";
            for (int j = 0; j < numDisks; j++) {
                //if disk number is 0, then there are no more disks on that peg
                if (pegs[i][j]==0) break;
                else toString += " " + pegs[i][j];
            }
            toString += "\n";
        }    
        return toString;
        
    }
}
