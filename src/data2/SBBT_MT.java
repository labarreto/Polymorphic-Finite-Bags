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
//empty self-balancing binary tree
public class SBBT_MT<D extends Comparable> implements FiniteBag<D> {

    boolean isBlack;

    public SBBT_MT() {
        this.isBlack = true;
    }

    public SBBT_MT(boolean isBlack) {
        this.isBlack = isBlack;
    }

    public boolean isBlackHuh() {
        return isBlack;
    }

    public FiniteBag<D> blacken() {
        return new SBBT_MT();
    }

    public FiniteBag<D> balance() {
        return this;
    }

    public int getCount(D elt) {
        return 0;
    }

    public static FiniteBag empty() {
        return new SBBT_MT();
    }

    public int cardinality() {
        return 0;
    }

    // (isEmptyHuh t) --> boolean where t is a finite bag
    public boolean isEmptyHuh() {
        
        return true;
    }

    // (member t elt) --> boolean where t is a finite-bag and elt is an int
    public boolean member(D elt) {
        return false;
    }

    // (remove t elt) --> finite-bag where t is a finite-bag and elt is an int
    public FiniteBag<D> remove(D elt) {
        return this;
    }

    public FiniteBag<D> remove(D elt, int n) {
        return this;
    }

    public FiniteBag<D> removeAll(D elt) {
        return this;
    }

    public FiniteBag<D> add(D elt) {
        return add(elt, 1).blacken();
    }
    // (add t elt) --> finite-set where t is a finite-set and elt is an ent

    public FiniteBag<D> add(D elt, int n) {
        return new SBBT_ST(empty(), elt, empty(), n, false);
    }
    
        
    public String toString() {
        return "()";
    }


    public FiniteBag<D> union(FiniteBag u) {
        return u;
    }

    public FiniteBag<D> inter(FiniteBag u) {
        return this;
    }

    public FiniteBag<D> diff(FiniteBag u) {
        return u;
    }

    public boolean equal(FiniteBag u) {
        return u.isEmptyHuh();
        // only will be equal if FiniteBag in question
        // is also empty. 
    }

    public boolean subset(FiniteBag u) {
        return true;
        //empty set is a subset of all sets
    }

    
    public Sequence<D> seq() {
        return new SequenceMT();
    }

    public String stringItS(Sequence<D> s) {
        return "";
    }
    
    public String stringIt() {
        return stringItS(this.seq());
    }
    
    public int sumIt() {
        return sumItS(this.seq());
    }


    public int sumItS(Sequence<D> as) {
        return 0;
    }

}
