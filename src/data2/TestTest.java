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
    static int MTtest = 0;                          //1
    static int MTUniontest = 0;                     //2
    static int MTIntertest = 0;                     //3
    static int MTDifftest = 0;                      //4
    static int CardMTtest = 0;                      //5
    static int CardAddtest = 0;                     //6 
    static int CardRemovetest = 0;                  //7
    static int MemberDifftest = 0;                  //8
    static int MemberUniontest = 0;                 //9
    static int MemberIntertest = 0;                 //10
    static int MemberAddtest = 0;                   //11
    static int UnionSubsettest = 0;                 //12
    static int InterSubsettest = 0;                 //13
    static int DiffSubsettest = 0;                  //14
    static int EqualIntertest = 0;                  //15

    static int AddGetCounttest = 0;                 //17
    static int RemoveGetCounttest = 0;              //18
    static int AddRemoveCardinalitytest = 0;        //19
    static int SumItCardinalitytest = 0;            //20
    static int SeqToStringtest = 0;                 //21
    static int RemoveAlltest = 0;                   //22

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


    public void testIsEmptyHuhMT(int count) throws Exception {
        for (int i = 0; i < 5000; i++) { 

            if (count == 0) {
                FiniteBag mt = MT();
                if (!mt.isEmptyHuh()) {
                    throw new Exception("Failure! MT finite set is not empty");
                }
            } else {
                int length = Utility.randInt(1, 150);
                FiniteBag r = randTree(length);
                if (r.isEmptyHuh() && count != 0) {
                    throw new Exception("Failure! Non MT finite set is empty. length is : " + length
                            + ", and r Tree is: " + r);
                }
            }
            MTtest++;
        }
    }

    public void testEmptyUnion() throws Exception {
        for (int i = 0; i < 5000; i++) {
            int length = Utility.randInt(0, 15);
            FiniteBag r = randTree(length);
            if (!r.union(MT()).equal(r)) {
                throw new Exception("Failure! Union of random tree and empty is not the random tree");
            }
            MTUniontest++;
        }
    }

    public void testEmptyInter() throws Exception {
        for (int i = 0; i < 5000; i++) {
            int length = Utility.randInt(0, 15);
            FiniteBag r = randTree(length);
            if (!r.inter(MT()).equal(MT())) {
                throw new Exception("Failure! Intersection of random tree and empty is not empty");
            }
            MTIntertest++;
        }
    }
    
    public void testEmptyDiff() throws Exception {
        for (int i = 0; i < 5000; i++) {
            int length = Utility.randInt(0,15);
            int randNum = Utility.randInt(5,20);
            D rElt = rand.createRand();
            FiniteBag r = randTree(length);
            FiniteBag mt = MT();
            FiniteBag t = r.diff(mt);
            if (!(t.equal(mt))) {
                throw new Exception("Failure! Diff between set r and empty is not empty/r");
            }
            MTDifftest++;
        }
    }

    /*                    testing cardinality                        */
    public void testCardinalityMT() throws Exception {
        // first check that it's empty. 
        for (int i = 0; i < 5000; i++) {
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
        for (int i = 0; i < 5000; i++) {
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
        for (int i = 0; i < 5000; i++) {
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

    public void testMemberDiff() throws Exception {
        for (int i = 0; i < 5000; i++) {
            D rElt = rand.createRand();
            int length = Utility.randInt(0, 10);
            FiniteBag r = randTree(length);
            FiniteBag s = randTree(length);
            if (r.diff(s).member(rElt)) {
                if (!s.member(rElt)) {
                    throw new Exception("Failure! random elt should be in s");
                }
            } else if (!s.member(rElt) || r.member(rElt)) {

            } else {
                throw new Exception("Failure! Try again");
            }
            MemberDifftest++;
        }

    }

    public void testMemberUnion() throws Exception {
        for (int i = 0; i < 5000; i++) {
            int length = Utility.randInt(0, 15);
            FiniteBag r = randTree(length);
            FiniteBag s = randTree(length);
            D rElt = rand.createRand();
            if (r.union(s).member(rElt)) {
                if (r.member(rElt) || s.member(rElt)) {
                } else {
                    throw new Exception("Failure! rElt should be member of either set or both!");
                }
            } else {
                if (r.member(rElt) || s.member(rElt)) {
                    throw new Exception("Failure! rElt should not be in either set!");
                }
            }
            MemberUniontest++;
        }
    }

    public void testMemberInter() throws Exception {
        for (int i = 0; i < 5000; i++) {
            int length = Utility.randInt(0, 15);
            FiniteBag r = randTree(length);
            FiniteBag s = randTree(length);
            D rElt = rand.createRand();
            if (r.inter(s).member(rElt)) {
                if (r.member(rElt) && s.member(rElt)) {
                } else {
                    throw new Exception("Failure! rElt should be member of both!");
                }

            }
            MemberIntertest++;
        }
    }

    public void testMemberAdd() throws Exception {
        for (int i = 0; i < 5000; i++) {
            D bElt = rand.createRand();
            D fElt = rand.createRand();
            int length = Utility.randInt(0, 15);
            FiniteBag r = randTree(length);
            if (r.add(bElt).member(fElt)) {
                if (bElt.compareTo(fElt) == 0 || r.member(fElt)) {

                } else {
                    throw new Exception("Failure. fElt should not be in the set");
                }
            } else {
                if (bElt.compareTo(fElt) == 0 || r.member(fElt)) {
                    throw new Exception("Failure!");
                }
            }
            MemberAddtest++;
        }
    }

    public void testUnionSubset() throws Exception {
        for (int i = 0; i < 5000; i++) {
            int length = Utility.randInt(0, 15);
            FiniteBag r = randTree(length);
            FiniteBag s = randTree(length);
            FiniteBag t = r.union(s);
            if (!(r.subset(t) && s.subset(t))) {
                throw new Exception("Failure! r and s are not subsets of union of r and s");
            }
            UnionSubsettest++;
        }
    }
    


    
    public void testInterSubset() throws Exception {
        for (int i = 0; i < 5000; i++) {
            int length = Utility.randInt(0,15);
            FiniteBag r = randTree(length);
            FiniteBag s = randTree(length);
            FiniteBag inter = r.inter(s);
            if (r.equal(s) && (!(r.subset(inter) && s.subset(inter)))) {
                throw new Exception ("Failure! when r and s are equal, the intersection should be themselves, yet they are not subsets of the intersection ");
            }
            InterSubsettest++;
        }
    }
    
    public void testDiffSubset() throws Exception {
        

        for (int i = 0; i < 5000; i++) {
            int length = Utility.randInt(0,15);
            int randNum = Utility.randInt(5,20);
            D rElt = rand.createRand();
            FiniteBag r = randTree(length);
            FiniteBag s = r.add(rElt,randNum);
            FiniteBag t = r.diff(s);
            if (! t.subset(s)) {
                throw new Exception ("The difference set (r.diff(s) is not a subset of r");
            }
            DiffSubsettest++;
        }
    }
    public void testEqualInter() throws Exception {
        for (int i = 0; i < 5000; i++) {
            int length = Utility.randInt(0, 15);
            FiniteBag r = randTree(length);
            FiniteBag s = randTree(length);
            if (!r.inter(s).equal(s.inter(r))) {
                throw new Exception("Failure! r intersection s is not equal to s intersection r");
            }
            EqualIntertest++;
        }
    }

    public void testAddGetCount() throws Exception {
        for (int i = 0; i < 5000; i++) {
            int length = Utility.randInt(0, 15);
            int randNum = Utility.randInt(2, 15);
            D rElt = rand.createRand();
            FiniteBag r = randTree(length);
            if (!(r.getCount(rElt) <= r.add(rElt).getCount(rElt))) {
                throw new Exception("Failure! The count of elements does not increase after adding an element");
            }
            if (!(r.getCount(rElt) <= r.add(rElt, randNum).getCount(rElt))) {
                throw new Exception("Failure! The count of elements does not increase after adding n number of elements");
            }
            AddGetCounttest++;
        }
    }

    public void testRemoveGetCount() throws Exception {
        for (int i = 0; i < 5000; i++) {
            int length = Utility.randInt(0, 15);
            int randNum = Utility.randInt(1, 15);
            D rElt = rand.createRand();
            FiniteBag r = randTree(length);
            FiniteBag s = r.add(rElt);
            FiniteBag t = r.add(rElt, randNum);
            if (!(r.getCount(rElt) >= s.remove(rElt).getCount(rElt))) {
                throw new Exception("Failure! The count of random tree before and the count after adding and then removing a random element is not the same!");
            }
            if (!(r.getCount(rElt) >= s.remove(rElt, randNum).getCount(rElt))) {
                throw new Exception("Failure! The count of random tree before and the count after adding and then removing n random elements is not the same!");

            }
            RemoveGetCounttest++;
        }
    }

    public void testAddRemoveCardinality() throws Exception {
        for (int i = 0; i < 5000; i++) {
            int length = Utility.randInt(0, 15);
            int randNum = Utility.randInt(1, 15);
            D rElt = rand.createRand();
            FiniteBag r = randTree(length);
            FiniteBag s = r.add(rElt);
            FiniteBag t = r.add(rElt, randNum);
            FiniteBag u = s.remove(rElt);
            FiniteBag v = t.remove(rElt, randNum);

            if (!(r.cardinality() < s.cardinality()) && (!(r.cardinality() < t.cardinality()))) {
                throw new Exception("Cardinality does not increase when elements added");

            }
            if (!(r.cardinality() >= u.cardinality()) && (!(r.cardinality() >= v.cardinality()))) {
                throw new Exception("Cardinality does not decrease or stay the same when elements removed");
            }
            AddRemoveCardinalitytest++;
        }
    }
    
        public void testRemoveAll() throws Exception {
        for (int i = 0; i < 5000; i++) {
            int length = Utility.randInt(0,15);
            D rElt = rand.createRand();
            int randNum = Utility.randInt(2, 20);
            FiniteBag r = randTree(length);
            FiniteBag s = r.add(rElt, randNum);
            if (s.removeAll(rElt).getCount(rElt) != 0) {
                throw new Exception("Failure! not all random Elements removed");
            }
            RemoveAlltest++;
        }
    }

    public void testSumItCardinality() throws Exception {
        for (int i = 0; i < 5000; i++) {
            int length = Utility.randInt(0, 15);
            FiniteBag r = randTree(length);
            if (r.sumIt() != r.cardinality()) {
                throw new Exception("Failure! Sequence does not coincide with cardinality");
            }
            SumItCardinalitytest++;
        }
    }

    public void testSeqToString() throws Exception {
        for (int i = 0; i < 5000; i++) {
            int length = Utility.randInt(0, 15);
            FiniteBag r = randTree(length);
            String s = r.stringIt();
            if (!(s instanceof String)) {
                throw new Exception("Failure! Sequence not turned into a string!");
            }
            SeqToStringtest++;
        }
        
    }
    


    public static void main(String[] args) throws Exception {
        // TODO code application logic here

        TestTest intTest = new TestTest(new randInt());
        TestTest stringTest = new TestTest(new randString());
        int checkInt = Utility.randInt(0, 1);
        

        System.out.println("-*-*-*-*- EMPTY");
        intTest.testIsEmptyHuhMT(checkInt);
        stringTest.testIsEmptyHuhMT(checkInt);
        System.out.println("Tested IsEmptyHUH " + MTtest + " successful times");
        System.out.println();

        System.out.println("-*-*-*-*- EMPTY and UNION");
        intTest.testEmptyUnion();
        stringTest.testEmptyUnion();
        System.out.println("Tested EmptyUnion " + MTUniontest + " successful times");
        System.out.println();

        System.out.println("-*-*-*-*- EMPTY and INTERSECTION");
        intTest.testEmptyInter();
        stringTest.testEmptyInter();
        System.out.println("Tested EmptyInter " + MTIntertest + " successful times");
        System.out.println();
        
        System.out.println("-*-*-*-*- EMPTY and DIFFERENCE");
        intTest.testEmptyDiff();
        stringTest.testEmptyDiff();
        System.out.println("Tested EmptyDiff " + MTDifftest + " successful times");
        System.out.println();

        System.out.println("-*-*-*-*- EMPTY and CARDINALITY");
        intTest.testCardinalityMT();
        stringTest.testCardinalityMT();
        System.out.println("Tested CardinalityMT " + CardMTtest + " successful times");
        System.out.println();

        System.out.println("-*-*-*-*- CARDINALITY and ADD");
        intTest.testCardinalityAdd();
        stringTest.testCardinalityAdd();
        System.out.println("Tested CardinalityAdd " + CardAddtest + " successful times");
        System.out.println();

        System.out.println("-*-*-*-*- CARDINALITY and REMOVE");
        intTest.testCardinalityRemove();
        stringTest.testCardinalityRemove();
        System.out.println("Tested CardinalityRemove " + CardRemovetest + " successful times");
        System.out.println();

        System.out.println("-*-*-*-*- MEMBER and DIFFERENCE");
        intTest.testMemberDiff();
        stringTest.testMemberDiff();
        System.out.println("Tested MemberDiff " + MemberDifftest + " successful times");
        System.out.println();

        System.out.println("-*-*-*-*- MEMBER and UNION");
        intTest.testMemberUnion();
        stringTest.testMemberUnion();
        System.out.println("Tested MemberUnion " + MemberUniontest + " successful times");
        System.out.println();

        System.out.println("-*-*-*-*- MEMBER and INTERSECTION");
        intTest.testMemberInter();
        stringTest.testMemberInter();
        System.out.println("Tested MemberInter " + MemberIntertest + " successful times");
        System.out.println();

        System.out.println("-*-*-*-*- MEMBER and ADD");
        intTest.testMemberAdd();
        stringTest.testMemberAdd();
        System.out.println("Tested MemberAdd " + MemberAddtest + " successful times");
        System.out.println();

        System.out.println("-*-*-*-*- UNION and SUBSETS");
        intTest.testUnionSubset();
        stringTest.testUnionSubset();
        System.out.println("Tested UnionSubset " + UnionSubsettest + " successful times");
        System.out.println();
        
        System.out.println("-*-*-*-*- INTERSECTION and SUBSETS");
        intTest.testInterSubset();
        stringTest.testInterSubset();
        System.out.println("Tested InterSubset " + InterSubsettest + " successful times");
        System.out.println();
        
        System.out.println("-*-*-*-*- DIFFERENCE and SUBSETS");
        intTest.testDiffSubset();
        stringTest.testDiffSubset();
        System.out.println("Tested DiffSubset " + DiffSubsettest + " successful times");
        System.out.println();

        System.out.println("-*-*-*-*- EQUAL and INTERSECTION");
        intTest.testEqualInter();
        stringTest.testEqualInter();
        System.out.println("Tested EqualInter " + EqualIntertest + " successful times");
        System.out.println();
        
        System.out.println("-*-*-*-*- ADD and GETCOUNT");
        intTest.testAddGetCount();
        stringTest.testAddGetCount();
        System.out.println("Tested AddGetCount " + AddGetCounttest + " successful times");
        System.out.println();

        System.out.println("-*-*-*-*- REMOVE and GETCOUNT");
        intTest.testRemoveGetCount();
        stringTest.testRemoveGetCount();
        System.out.println("Tested RemoveGetCount " + RemoveGetCounttest + " successful times");
        System.out.println();

        System.out.println("-*-*-*-*- ADD and REMOVE and CARDINALITY");
        intTest.testAddRemoveCardinality();
        stringTest.testAddRemoveCardinality();
        System.out.println("Tested AddRemoveCardinality " + AddRemoveCardinalitytest + " successful times");
        System.out.println();
        
        System.out.println("-*-*-*-*- REMOVE ALL");
        intTest.testRemoveAll();
        stringTest.testRemoveAll();
        System.out.println("Tested RemoveAll " + RemoveAlltest + " successful times");
        System.out.println();
        
        System.out.println("-*-*-*-*- SUMIT and CARDINALITY");
        intTest.testSumItCardinality();
        stringTest.testSumItCardinality();
        System.out.println("Tested SumItCardinality " + SumItCardinalitytest + " successful times");
        System.out.println();
        
        System.out.println("-*-*-*-*- SEQTOSTRING");
        intTest.testSeqToString();
        stringTest.testSeqToString();
        System.out.println("Tested SeqToString " + SeqToStringtest + " successful times");
        System.out.println();

        




    }

}
