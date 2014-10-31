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
//self balancing binary tree with STuff in it.
public class SBBT_ST<D extends Comparable> implements finiteBag<D> {

    SBBT_ST() {
    }

    finiteBag left;
    D here;
    finiteBag right;
    int count;

    public SBBT_ST(finiteBag left, D here, finiteBag right, int count) {
        this.left = left;
        this.here = here;
        this.right = right;
        this.count = count;
    }

    public int getCount(D elt) {
        if (elt.equals(this.here)) {
            return count;
        } else {
            if (elt.compareTo(here) < 0) {
                return this.left.getCount(elt);
            } else {
                return this.right.getCount(elt);
            }
            
        }
    }
    public int cardinality() {
        return left.cardinality() + count + right.cardinality();
    }

    // (isEmptyHuh t) --> boolean where t is a finite bag
    public boolean isEmptyHuh() {
        return false;
    }

    // (member t elt) --> boolean where t is a finite-bag and elt is an int
    public boolean member(D elt) {
        //compareTo part of comparable
        if (elt.compareTo(this.here) == 0) {
            return true;
        } else if (elt.compareTo(this.here) < 0) {
            return left.member(elt);
        } else {
            return right.member(elt);
        }
    }

    // (remove t elt) --> finite-bag where t is a finite-bag and elt is an int
    public finiteBag remove(D elt) {
        //the only case where nothing happens is if count for elt is 0 since there
        //would be no elt to remove. 
        if (getCount(elt) != 0) {
            if (elt.equals(here)) {
                return new SBBT_ST(this.left, this.here, this.right, this.count - 1);
            } else if (elt.compareTo(here) < 0) {
                return new SBBT_ST(this.left.remove(elt), this.here, this.right, this.count);
            } else {
                return new SBBT_ST(this.left, this.here, this.right.remove(elt), this.count);
            }
        }
        //in the case where count for elt is 0, returning existing set. :) 
        return this;
    }

    public finiteBag removeN(D elt, int n) {
        return this;
        //come back to this.
    }

    public finiteBag removeAll(D elt) {
        return this;
        //come back to this. 
    }

    public finiteBag add(D elt) {
        //haha jk, this isn't efficient.
        
        if (elt.compareTo(this.here) == 0) {
            return this;
        } else if (elt.compareTo(this.here) > 0) {
            return new SBBT_ST(this.left, this.here, this.right.add(elt), this.count);
        } else {
            return new SBBT_ST(this.left.add(elt), this.here, this.right, this.count);
        }
    }

        // (add t elt) --> finite-set where t is a finite-set and elt is an ent
    public finiteBag addN(D elt, int n) {
        //haha jk, this isn't efficient. 
        return this;
    }
    //have to figure out smart insert. 

    public finiteBag union(finiteBag u) {
        // because this is a multiset with multiplicity,
        // items can repeat! so union can just be both sets
        return u;
        //gotta figure out how to do this. 
        
        //will use new smart insert
    }

    public finiteBag inter(finiteBag u) {
        return u;
        // will use union to join the common elements of 
        //left of u and this, and right of u and this.
        //union uses smart insert, so I cannot write this yet. 
        
        //my ideas are that if here is a member of u, and if count of u for here
        //is more than count of u for this, 
        //then return a new set where you find intersection of left and u left,
        //and intersection of right and u, and return count of this.here
        
    }

    public finiteBag diff(finiteBag u) {
        return u; //this is wrong. 
    }

    public boolean equal(finiteBag u) {
        return (this.subset(u) && u.subset(this));
        //
    }

    public boolean subset(finiteBag u) {
        //elements in this are in finiteBag. we can find this using count
        //since there would have to be at least 1 item in this that is in u
        //for left, right, and here. 
        //
        return (u.getCount(here) >= this.getCount(here) &&
                this.left.subset(u) && this.right.subset(u));

    }

}
