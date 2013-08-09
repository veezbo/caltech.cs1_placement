

package cs1hanoi;

/**
 * File: Cs1hanoi
 * 
 * Assignment: Caltech CS 1 Placement Exam- Problem 2
 * 
 * Author: Vibhor Kumar
 * Caltech UID: 1918696
 * 
 */
public class Cs1hanoi {
    
    /**
     * Handles errors with the input and, if passes, runs the program with input
     * @param args Holds command-line argument: exactly one positive integer
     */
    public static void main(String[] args) {
        
        int numDisks = -1;
        
    //ensure the number of arguments is 1
        if (args.length > 1) {
            System.out.println("Too many arguments: exactly one is needed");
            System.exit(-1);
        }
        else if (args.length < 1) {
            System.out.println("Too few arguments: exactly one is needed");
            System.exit(-1);
        }
        
    //ensure that the argument is in the proper format (Integer)
        try {
            numDisks = Integer.parseInt(args[0]);
        }
        catch (Exception e) {
            System.out.println("Invalid Input: should be a positive integer");
            System.exit(-1);
        }
        
        if (numDisks <= 0) {
            System.out.println("Invalid Input: should be a positive integer");
            System.exit(-1);
        }
        
        Hanoi h = new Hanoi(numDisks);
        
        display(h);
        solve(h);
        
    //if the program reaches here, a proper exit status is returned
        System.exit(0);
        
    }
    
    /**
     * Runs hanoi_solve with initial parameters
     * @param hanoi Holds initial program state
     */
    public static void solve(Hanoi hanoi) {
        
        //recursive_solve run with parameters indicating that all N disks are
        //to be moved from peg A to peg B
        hanoi_solve (hanoi, hanoi.getNumDisks(), 0, 1);
        
    }
    
    /**
     * Moves the top disk on one peg to another
     * @param hanoi Holds the location of all disks and their respective pegs
     * @param pegStart Indicates the peg where the disk is being moved from
     * @param pegEnd Indicates the peg where the disk is being moved to
     */
    public static void move(Hanoi hanoi, int pegStart, int pegEnd) {
        
        hanoi.move(pegStart, pegEnd);
        display(hanoi);
        
    }
    
    /**
     * Displays the disks at each of the pegs of the given hanoi object
     * @param hanoi Holds the location of all disks and their respective pegs
     */
    public static void display(Hanoi hanoi) {
        //makes use of the overrided toString method of the Hanoi object
        System.out.println(hanoi);
    }
    
    /**
     * Recursive method that performs the necessary moves to reach the end state
     * @param hanoi Holds the location of all disks and their respective pegs
     * @param M number of disks to be moved
     * @param pegStart peg from which the disks are to be moved
     * @param pegEnd peg to which the disks are to be moved
     */
    public static void hanoi_solve (
            Hanoi hanoi, int M, int pegStart, int pegEnd 
            ) 
    {
        if (M==1) {
            move (hanoi, pegStart, pegEnd);
            return;
        } 
        
        //pegIntermediate is the peg that is not pegStart or pegEnd
        int pegIntermediate = 3 - pegStart - pegEnd;
        
        hanoi_solve (hanoi, M-1, pegStart, pegIntermediate);
        move (hanoi, pegStart, pegEnd);
        hanoi_solve (hanoi, M-1, pegIntermediate, pegEnd);
        
    }
    
}
