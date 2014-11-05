/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data2;

import java.util.Random;

/**
 *
 * @author ldbruby95
 */
public class TestTest<D extends Comparable> {

    static int count;
    static FiniteBag mt = new SBBT_MT();
    Randomness<D> rand;

    //test variables
    static int MTtest = 0;
    static int CardMTtest = 0;
    static int CardAddtest = 0;
    static int CardRemovetest = 0;

    TestTest(Randomness<D> rand) {
        this.rand = rand;
    }

    public static int randInt(int min, int max) {

        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;

    }

    public static FiniteBag MT() {
        return new SBBT_MT();
    }

    public FiniteBag<D> randTree(int l) {
        if (l == 0) {
            return MT();
        } else {
            return randTree(l - 1).add(rand.createRand(), Utility.randInt(1, 10));
        }
    }

    /*                    testing empty                       */
    public void testIsEmptyHuhMT(int count) throws Exception {
        for (int i = 0; i < 1000; i++) { // run 100 tests
            if (count == 0) {
                FiniteBag mt = MT();
                if (!mt.isEmptyHuh()) {
                    throw new Exception("Failure! MT finite set is not empty");
                }
            } else {
                int length = Utility.randInt(1, 150);
                FiniteBag r = randTree(length);
                if (r.isEmptyHuh()) {
                    throw new Exception("Failure! Non MT finite set is empty");
                }
            }
            MTtest++;
        }
    }

    /*                    testing cardinality                        */
    public void testCardinalityMT() throws Exception {
        // first check that it's empty. 
        for (int i = 0; i < 1000; i++) {
            int length = Utility.randInt(0, 15);
            FiniteBag r = randTree(length);
            if (!r.isEmptyHuh() && (r.cardinality() == 0)) {
                throw new Exception("Failure! Non MT finite set has 0 cardinality");
            }
            if (r.isEmptyHuh() && r.cardinality() != 0) {
                throw new Exception("Failure! MT finite set has cardinality not 0");
            }
            CardMTtest++;
        }
    }

    public void testCardinalityAdd() throws Exception {
        for (int i = 0; i < 1000; i++) {
            int length = Utility.randInt(0, 15);
            FiniteBag r = randTree(length);
            int cardC = r.cardinality();
            if (r.add(rand.createRand()).cardinality() != cardC + 1) {
                throw new Exception("Failure! Not adding properly");
            }
            if (r.add(rand.createRand()).cardinality() == cardC) {
                throw new Exception("Failure! Not adding to set");
            }
            CardAddtest++;
        }
    }

    public void testCardinalityRemove() throws Exception {
        for (int i = 0; i < 1000; i++) {
            D rElt = rand.createRand();
            int length = Utility.randInt(0, 15);
            FiniteBag r = randTree(length);
            int cardC = r.cardinality();
            int cardA = r.remove(rElt).cardinality();
            if (r.getCount(rElt) > 0 && cardA != cardC - 1) {
                throw new Exception("Failure! Cardinality not decreased when element is in set");
            }
            if (r.getCount(rElt) == 0 && cardA != cardC) {
                throw new Exception("Failure! Cardinality should not have changed");
            }
            CardRemovetest++;
        }
    }

    public static void main(String[] args) throws Exception {
        // TODO code application logic here

        TestTest intTest = new TestTest(new randInt());
        TestTest stringTest = new TestTest(new randString());
        int checkInt = Utility.randInt(0, 1);

        System.out.println("------------------------------------------------------------");
        System.out.println("TESTING EMPTY . . . ");
        intTest.testIsEmptyHuhMT(checkInt);
        stringTest.testIsEmptyHuhMT(checkInt);
        System.out.println("Tested testIsEmptyHUHMT " + MTtest + " times");

        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.println("TESTING CARDINALITY . . . ");
        intTest.testCardinalityMT();
        stringTest.testCardinalityMT();
        System.out.println("Tested testCardinalityMT " + CardMTtest + " times");

        //testCardinalityMT(mt);
    }

}
