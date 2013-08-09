
package cs1automata;


/**
 * File: Cs1automata
 * 
 * Assignment: Caltech CS 1 Placement Exam- Problem 1
 * 
 * Author: Vibhor Kumar
 * Caltech UID: 1918696
 * 
 */
public class Cs1automata {

    /**
     * Handles errors in inputs, and, if passes, runs the program with inputs
     * @param args Holds command-line arguments: exactly 6 nonnegative integers
     */
    public static void main(String[] args) {
        
    //preliminary check to make sure there are exactly 6 arguments
        if (args.length != 6) {
            System.out.println("Please Enter Exactly 6 arguments");
            System.exit(-1);
        }
        
    //reading in values from the input
        final int numCells = readInt(args[0], false);
        final int numGens = readInt(args[1], false);
        final int[] updateRule = new int[4];
        for (int i = 0; i < 4; i++) {
            updateRule[i] = readInt(args[i+2], true);
        }
        
    //randomly generate the starting generation, using Automata's static method    
        final int[] startGen = Automata.randomGenGenerate(numCells);
    
    //create the Automata object using the given inputs
        Automata automata = new Automata(numCells, updateRule, startGen);
        
    //first, print the starting generation..
    //..then, run programRunner that runs the program with the read-in inputs
        print (automata);
        programRunner(automata, numGens);
        
    //if the program reaches here, a proper exit status is returned
        System.exit(0);
        
    }
    
    /**
     * Reads in an integer from a String, while handling errors
     * @param readIn String read in from the command line
     * @param update Indicates whether or not the String is part of the update rule
     * @return int representation of the String read in
     */
    public static int readInt(String readIn, boolean update) {

        int readInt = -1;
        
    //check to see input is in Integer format
        try {
            readInt = Integer.parseInt(readIn);
        }
        catch (Exception e) {
            System.out.println("Please Enter Only Nonnegative Integers");
            System.exit(-1);
        }
        
    //check to see input is nonnegative
        if (readInt < 0) {
            System.out.println("Please Enter Only Nonnegative Integers");
            System.exit(-1);
        }
        
    //if the input is part of the updateRule, check to make sure 0 or 1
        if (update) {
            if (readInt!=0 && readInt!= 1) {
                System.out.println("Please Enter Only 0's or 1's for the UpdateRule arguments");
                System.exit(-1);
            }
        }

        return readInt;

    }
    
    /**
     * Prints out the current automata, using the overrided toString method
     * @param automata, an Automata object that holds the current generation
     */
    public static void print(Automata automata) {
        
        //this automatically calls the Automata object's toString method
        System.out.println(automata);
        
    }
    
    /**
     * Runs the program with the given automata and number of generations
     * @param automata, an Automata object that holds the current generation
     * @param numGens Number of generations the program is to create
     */
    public static void programRunner(Automata automata, int numGens) {
        
        for (int i = 0; i < numGens; i++) 
        {
            automata.update();
            print (automata);
        }
        
    }
    
}
