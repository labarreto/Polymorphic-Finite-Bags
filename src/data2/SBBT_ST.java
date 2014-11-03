/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data2;

import java.util.*;

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
    boolean isBlack;

    public SBBT_ST(finiteBag left, D here, finiteBag right, int count) {
        this.left = left;
        this.here = here;
        this.right = right;
        this.count = count;
    }

    public SBBT_ST(finiteBag left, D here, finiteBag right, int count, boolean isBlack) {

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
        if (elt.equals(this.here)) {
            //there's a way to do this without a nested if. 
            return new SBBT_ST(this.left, this.here, this.right, this.count - 1);
        } else if (elt.compareTo(here) < 0) {
            return new SBBT_ST(this.left.remove(elt), this.here, this.right, this.count);
        } else {
            return new SBBT_ST(this.left, this.here, this.right.remove(elt), this.count);
        }

    }

    public finiteBag removeN(D elt, int n) {
        //figure out a way of calculating max amount of elt in multiset.
        int max = Math.max(0, this.getCount(elt) - n);
        //returns the larger of a and b. 

        //if this.getCount(elt)-n is equal to 0, then finiteBag will remove 0
        //http://www.tutorialspoint.com/java/lang/math_max_int.htm
        if (elt.equals(this.here)) {
            //returning count - n elements
            return new SBBT_ST(this.left, this.here, this.right, max);
        } else if (elt.compareTo(this.here) < 0) {
            return new SBBT_ST(this.left.removeN(elt, n), this.here, this.right, this.getCount(elt));
        } else {
            return new SBBT_ST(this.left, this.here, this.right.removeN(elt, n), this.getCount(elt));
        }
    }

    public finiteBag removeAll(D elt) {

        if (elt.equals(this.here)) {
            return new SBBT_ST(this.left, this.here, this.right, 0);
            //take the union of the left and right trees to put them together
        } else if (elt.compareTo(this.here) < 0) {
            return new SBBT_ST(this.left.removeAll(elt), this.here, this.right, this.getCount(elt));
        } else {
            return new SBBT_ST(this.left, this.here, this.right.removeAll(elt), this.getCount(elt));
        }
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

    public finiteBag blacken() {
        return new SBBT_ST(this.left, this.here, this.right, this.count, true);
    }

    public boolean isBlackHuh() {
        return isBlack;
    }

    public finiteBag balance() {
        if ((this.isBlackHuh() && (this.left instanceof SBBT_ST) && !((SBBT_ST) this.left).isBlackHuh()
                && !((SBBT_ST) this.left).left.isBlackHuh())) {
            //cast it so compiler knows it's SBBT_ST
            //error here because i can't get the left of left. 


            //hahahahaha wowow this is complicated. 
            return new SBBT_ST(return new SBBT_ST(((SBBT_ST) this.left).left) , (SBBT_ST)this.left).here, this.right, this.count, this.isBlack()));
            
            //this return statement is a filler
            //return new SBBT_ST(this.left, this.here, this.right, this.count, this.isBlack);

        } else if ((this.isBlackHuh() && (this.left instanceof SBBT_ST) && !((SBBT_ST) this.left).isBlackHuh()
                && !((SBBT_ST) this.left).right.isBlackHuh())) {
            
            //this return statement is a filler
            
            
            return new SBBT_ST(this.left, this.here, this.right, this.count, this.isBlack);
        
        } else if ((this.isBlackHuh() && (this.right instanceof SBBT_ST) && !((SBBT_ST) this.right).isBlackHuh()
                && !((SBBT_ST) this.right).left.isBlackHuh())) {
            

            //this return statement is a filler
            return new SBBT_ST(this.left, this.here, this.right, this.count, this.isBlack);
        } else if ((this.isBlackHuh() && (this.right instanceof SBBT_ST) && !((SBBT_ST) this.right).isBlackHuh()
                && !((SBBT_ST) this.right).right.isBlackHuh())) {
            
            //this return statement is a filler
             return new SBBT_ST(this.left, this.here, this.right, this.count, this.isBlack);
        } else {
            return this;
        }

    }

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
        return (u.getCount(here) >= this.getCount(here)
                && this.left.subset(u) && this.right.subset(u));

    }

}
