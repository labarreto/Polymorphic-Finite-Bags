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
public class SBBT_ST<D extends Comparable> implements finiteBag<D>{
    
    SBBT_ST() {
    }

    
     finiteBag left;
   D here;
finiteBag right;
    
    public SBBT_ST(finiteBag left, D here, finiteBag right) {
        this.left = left;
        this.here = here;
        this.right = right;
    }

    public int cardinality() {
       return 0; // shoudl not be 0, but for now
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
    } else if (elt.compareTo(this.here) > 0) {
        return right.member(elt);
    } else {
        return left.member(elt);
    }
    }

    // (remove t elt) --> finite-bag where t is a finite-bag and elt is an int
    public finiteBag remove(D elt) {
      return this;
    }

    public finiteBag add(D elt) {
        if (elt.compareTo(this.here) == 0) {
            return this;
        } else if (elt.compareTo(this.here) > 0) {
            return new SBBT_ST(this.left, this.here, this.right.add(elt));
        } else {
            return new SBBT_ST(this.left.add(elt), this.here, this.right);
        }
    }
        // (add t elt) --> finite-set where t is a finite-set and elt is an ent

    public finiteBag union(finiteBag u) {
        // because this is a multiset with multiplicity,
        // items can repeat! so union can just be both sets
        return u;
        //gotta figure out how to do this. 
    }

    public finiteBag inter(finiteBag u) {
        return this;
    }

    public boolean equal(finiteBag u) {
        return u.isEmptyHuh();
        //
    }

    public boolean subset(finiteBag u) {
        return false;
        //
    }

    public int multiplicity(D elt) {
        return 0;
    } //shoudl not always be 0. but for now,
//it has to be
//multiplicity of a member of a multiset
    //is the number of times it appears in the multiset. 

    
}
