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
public class TestTest<D extends Comparable> {

    static int count;
    static FiniteBag mt = new SBBT_MT();
    Randomness rand;

    TestTest(Randomness<D> rand) {
        this.rand = rand;
    }

    public FiniteBag<D> randTree(int n) {
        FiniteBag randTree = new SBBT_MT();
        for (int i = 0; i < n; i++) {
            randTree = randTree.add(Utility.randInt(0, 50));
        }
        return randTree;
    }

    public static void testCardinalityMT(FiniteBag u) throws Exception {
        // first check that it's empty. 
        if (u.isEmptyHuh()) {
            if (u.cardinality() != 0) {
                throw new Exception("Failure! Cardinality for empty set is: " + u.cardinality()
                        + ", should be: 0");

            }
        }
    }
    

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("------------------------------------------------------------");
        System.out.println("TESTING EMPTY . . . ");
        //testCardinalityMT(mt);
    }

}
