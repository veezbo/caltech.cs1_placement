
package cs1automata;

import java.util.Random;

public class Automata {
    
    final int numCells;
    final int[] updateRule;
    int[] gen;
    
    /**
     * Constructor for Automata Class
     * @param pNumCells Number of cells each generation has
     * @param pUpdateRule int array of length 4 holding update rule of automata
     * @param pgen int array holding the starting generation of cells
     */
    public Automata(int pNumCells, int[] pUpdateRule, int[] pgen) {
        
        numCells = pNumCells;
        updateRule = pUpdateRule;
        gen = pgen;
        
    }
    
    /**
     * Static method that creates an int array filled with 0's and 1's randomly
     * @param numCells Number of cells each generation has, or length of the array
     * @return randomGen, int array filled with 0's and 1's randomly
     */
    public static int[] randomGenGenerate(int numCells) {
        
        int[] randomGen = new int[numCells];
        Random rand = new Random();
        for (int i = 0; i < numCells; i++) {
            randomGen[i] = rand.nextInt(2);
        }
        return randomGen;
        
    }
    
    /**
     * Updates one generation of cells, given the updateRule and current gen
     */
    public void update () {
        
        int[] newgen = new int[numCells];
        for (int i = 0; i < numCells; i++) 
        {    
            
            if (i == 0) {
                newgen[i] = updateRule[gen[i] + gen[i+1]];
            }
            else if (i == numCells-1) {
                newgen[i] = updateRule[gen[i-1] + gen[i]];
            }
            else {
                newgen[i] = updateRule[gen[i-1] + gen[i] + gen[i+1]];
            }
            
        }
        
        gen = newgen;
        
    }
    
    /**
     * Converts the current Automata object into a printable String
     * For use when printing out the current generation
     * @return toString, a String representation of the Automata object
     */
    @Override
    public String toString() {
        
        String toString = "";
        for (int i = 0; i < numCells; i++) {
            toString += gen[i];
        }
        return toString;
        
    }
    
}
