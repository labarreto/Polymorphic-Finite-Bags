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
public class SBBT_ST implements finiteBag{
    
    SBBT_ST() {
    }

    public int here;
    public finiteBag left;
    public finiteBag right;
    
    public SBBT_ST(finiteBag left, int here, finiteBag right) {
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
    public boolean member(int elt) {
   return false;
    }

    // (remove t elt) --> finite-bag where t is a finite-bag and elt is an int
    public finiteBag remove(int elt) {
      return this;
    }

    public finiteBag add(int elt) {
        return this;
    }
        // (add t elt) --> finite-set where t is a finite-set and elt is an ent

    public finiteBag union(finiteBag u) {
        return this;
    }

    public finiteBag inter(finiteBag u) {
        return this;
    }

    public boolean equal(finiteBag u) {
        return u.isEmptyHuh();
    }

    public boolean subset(finiteBag u) {
        return false;
    }

    public int multiplicity() {
        return 0;
    } //shoudl not always be 0. but for now,
//it has to be
//multiplicity of a member of a multiset
    //is the number of times it appears in the multiset. 

    
}
