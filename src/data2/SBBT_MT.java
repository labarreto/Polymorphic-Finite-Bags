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
public class SBBT_MT<D extends Comparable> implements finiteBag<D> {

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

    public finiteBag blacken() {
        return new SBBT_MT();
    }

    public finiteBag balance() {
        return this;
    }

    public int getCount(D elt) {
        return 0;
    }

    public static finiteBag empty() {
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
    public finiteBag remove(D elt) {
        return empty();
    }

    public finiteBag removeN(D elt, int n) {
        return this.remove(elt);
    }

    public finiteBag removeAll(D elt) {
        return this.remove(elt);
    }

    public finiteBag add(D elt) {
        return new SBBT_ST(empty(), elt, empty(), 1, false);
    }
    // (add t elt) --> finite-set where t is a finite-set and elt is an ent

    public finiteBag addN(D elt, int n) {
        for (int i = 0; i <= n; i++) {
            this.add(elt);
        }
        return this;
    }

    public finiteBag union(finiteBag u) {
        return u;
    }

    public finiteBag inter(finiteBag u) {
        return empty();
    }

    public finiteBag diff(finiteBag u) {
        return u;
    }

    public boolean equal(finiteBag u) {
        return u.isEmptyHuh();
        // only will be equal if finiteBag in question
        // is also empty. 
    }

    public boolean subset(finiteBag u) {
        return true;
        //empty set is a subset of all sets
    }

}
