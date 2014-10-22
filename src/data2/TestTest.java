/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data2;

/**
 *
 * @author ldbruby95
 */
public class TestTest {
    static int count;
    static finiteBag mt = new SBBT_MT();
    
    
        public static void testCardinalityMT(finiteBag u) {
        // first check that it's empty. 
        if (u.isEmptyHuh()) {
        
            if (u.cardinality() != 0) {
                
                System.out.println("Failure! Cardinality for empty set is: " + u.cardinality()
                        + ", should be: 0");
            }
        } 
    }

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("------------------------------------------------------------");
        System.out.println("TESTING EMPTY . . . ");
        testCardinalityMT(mt);
    }
    
    
}
