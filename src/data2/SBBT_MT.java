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

    public finiteBag<D> blacken() {
        return new SBBT_MT();
    }

    public finiteBag<D> balance() {
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
    public finiteBag<D> remove(D elt) {
        return this;
    }

    public finiteBag<D> remove(D elt, int n) {
        return this;
    }

    public finiteBag<D> removeAll(D elt) {
        return this;
    }

    public finiteBag<D> add(D elt) {
        return new SBBT_ST(empty(), elt, empty(), 1, false);
    }
    // (add t elt) --> finite-set where t is a finite-set and elt is an ent

    public finiteBag<D> add(D elt, int n) {
        for (int i = 0; i <= n; i++) {
            this.add(elt);
        }
        return this;
    }

    public finiteBag<D> union(finiteBag u) {
        return u;
    }

    public finiteBag<D> inter(finiteBag u) {
        return this;
    }

    public finiteBag<D> diff(finiteBag u) {
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

    @Override
    public Sequence<D> seq() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public finiteBag<D> insert(D elt, int count) {
       return this.insertInner(elt, count).blacken();
    }


    public finiteBag<D> insertInner(D elt, int count) {
        return new SBBT_ST(elt, count);
    }

    @Override
    public int sumIt() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int sumItS(Sequence<D> as) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
