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
public class SBBT_ST<D extends Comparable> implements FiniteBag<D> {

    SBBT_ST() {
    }

    FiniteBag left;
    D here;
    FiniteBag right;
    int count;
    boolean isBlack;

    public SBBT_ST(FiniteBag left, D here, FiniteBag right, int count) {
        this.left = left;
        this.here = here;
        this.right = right;
        this.count = count;
    }

    public SBBT_ST(FiniteBag left, D here, FiniteBag right, int count, boolean isBlack) {
        this.left = left;
        this.here = here;
        this.right = right;
        this.count = count;
        this.isBlack = isBlack;
    }

    public SBBT_ST(D here) {
        this.here = here;
        this.count = 1;
        this.left = new SBBT_MT();
        this.right = new SBBT_MT();
    }

    public SBBT_ST(D here, int count) {
        this.here = here;
        this.count = count;
        this.isBlack = false;
        this.left = new SBBT_MT();
        this.right = new SBBT_MT();
    }

    public int getCount(D elt) {
        if (elt.compareTo(this.here) == 0) {
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
        if (this.getCount(here) == 0) {
            if (!left.isEmptyHuh()) {
                return false;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

// (member t elt) --> boolean where t is a finite-bag and elt is an int
    public boolean member(D elt) {
        //compareTo part of comparable
        if (elt.compareTo(this.here) == 0) {
            return this.count > 0;
        } else if (elt.compareTo(this.here) < 0) {
            return left.member(elt);
        } else {
            return right.member(elt);
        }
    }

    // (remove t elt) --> finite-bag where t is a finite-bag and elt is an int
    public FiniteBag<D> remove(D elt) {
        return this.remove(elt, 1);

    }

    public String toString() {
        return "( " + left + " " + right + ")";
    }

    public FiniteBag<D> remove(D elt, int n) {
        //figure out a way of calculating max amount of elt in multiset.
        int max = Math.max(0, this.getCount(elt) - n);
        //returns the larger of a and b. 

        //if this.getCount(elt)-n is equal to 0, then FiniteBag will remove 0
        //http://www.tutorialspoint.com/java/lang/math_max_int.htm
        if (elt.compareTo(this.here) == 0) {
            //returning count - n elements
            return new SBBT_ST(this.left, this.here, this.right, max);
        } else if (elt.compareTo(this.here) < 0) {
            return new SBBT_ST(this.left.remove(elt, n), this.here, this.right, this.count);
        } else {
            return new SBBT_ST(this.left, this.here, this.right.remove(elt, n), this.count);
        }
    }

    public FiniteBag<D> removeAll(D elt) {

        if (elt.compareTo(this.here) == 0) {
            return new SBBT_ST(this.left, this.here, this.right, 0);
            //take the union of the left and right trees to put them together
        } else if (elt.compareTo(this.here) < 0) {
            return new SBBT_ST(this.left.removeAll(elt), this.here, this.right, this.count);
        } else {
            return new SBBT_ST(this.left, this.here, this.right.removeAll(elt), this.count);
        }
    }

    public FiniteBag<D> add(D elt) {
        return this.add(elt, 1);
    }

    public FiniteBag<D> add(D elt, int n) {
        if (elt.compareTo(this.here) == 0) {
            return new SBBT_ST(this.left, this.here, this.right, this.count + n, this.isBlack);
        } else if (elt.compareTo(this.here) < 0) {
            return new SBBT_ST(this.left.add(elt, n), this.here, this.right, this.count, this.isBlack);
        } else {
            return new SBBT_ST(this.left, this.here, this.right.add(elt, n), this.count, this.isBlack);
        }

    }

    public FiniteBag blacken() {
        return new SBBT_ST(this.left, this.here, this.right, this.count, true);
    }

    public boolean isBlackHuh() {
        return isBlack;
    }

    public FiniteBag balance() {
        SBBT_ST lefty;
        SBBT_ST leftyleft;
        SBBT_ST leftyright;
        SBBT_ST righty;
        SBBT_ST rightyleft;
        SBBT_ST rightyright;

        if ((this.isBlackHuh()
                && (this.left instanceof SBBT_ST)
                && (((SBBT_ST) this.left).left instanceof SBBT_ST)
                && !((SBBT_ST) this.left).isBlackHuh()
                && !((SBBT_ST) this.left).left.isBlackHuh())) {
            //cast it so compiler knows it's SBBT_ST
            //error here because i can't get the left of left. 

            lefty = ((SBBT_ST) this.left);
            leftyleft = ((SBBT_ST) lefty.left);
            //hahahahaha wowow this is complicated. 
            return new SBBT_ST(
                    /* left */new SBBT_ST(leftyleft.left, leftyleft.here, leftyleft.right, leftyleft.count, true),
                    /* here */ lefty.here,
                    /* right */ new SBBT_ST(leftyleft.right, this.here, this.right, this.count, true),
                    /* count */ lefty.count,
                    /* isBlack */ false);

            //this return statement is a filler
            //return new SBBT_ST(this.left, this.here, this.right, this.count, this.isBlack);
        } else if ((this.isBlackHuh() 
                && (this.left instanceof SBBT_ST) 
                && (((SBBT_ST) this.left).right instanceof SBBT_ST)
                && !((SBBT_ST) this.left).isBlackHuh()
                && !((SBBT_ST) this.left).right.isBlackHuh())) {

            lefty = ((SBBT_ST) this.left);
            leftyleft = ((SBBT_ST) lefty.left);
            leftyright = ((SBBT_ST) lefty.right);
            //hahahahaha wowow this is complicated. 
            return new SBBT_ST(
                    /* left */new SBBT_ST(leftyleft, lefty.here, leftyright.left, lefty.count, true),
                    /* here */ leftyright.here,
                    /* right */ new SBBT_ST(leftyright.right, this.here, this.right, this.count, true),
                    /* count */ leftyright.count,
                    /* isBlack */ false);

        } else if ((this.isBlackHuh() 
                && (this.right instanceof SBBT_ST) 
                && (((SBBT_ST) this.right).left instanceof SBBT_ST)
                && !((SBBT_ST) this.right).isBlackHuh()
                && !((SBBT_ST) this.right).left.isBlackHuh())) {

            righty = ((SBBT_ST) this.right);
            rightyleft = ((SBBT_ST) righty.left);

            return new SBBT_ST(
                    /* left */new SBBT_ST(this.left, this.here, rightyleft.left, this.count, true),
                    /* here */ rightyleft.here,
                    /* right */ new SBBT_ST(rightyleft.right, righty.here, righty.right, righty.count, true),
                    /* count */ rightyleft.count,
                    /* isBlack */ false);

        } else if ((this.isBlackHuh() 
                && (this.right instanceof SBBT_ST) 
                && (((SBBT_ST) this.right).right instanceof SBBT_ST)
                && !((SBBT_ST) this.right).isBlackHuh()
                && !((SBBT_ST) this.right).right.isBlackHuh())) {

            righty = ((SBBT_ST) this.right);
            rightyright = ((SBBT_ST) righty.right);
            rightyleft = ((SBBT_ST) righty.left);

            return new SBBT_ST(
                    /* left */new SBBT_ST(this.left, this.here, rightyleft, this.count, true),
                    /* here */ righty.here,
                    /* right */ new SBBT_ST(rightyright.left, rightyright.here, rightyright.right, rightyright.count, true),
                    /* count */ righty.count,
                    /* isBlack */ false);
        } else {
            return this;
        }

    }

    public FiniteBag<D> union(FiniteBag u) {
        return left.union(right.union(u)).add(here, this.getCount(here));
    }

    public FiniteBag inter(FiniteBag u) {
        if (u.member(this.here)) {
            int min = Math.min(u.getCount(here), this.getCount(here));
            return new SBBT_ST(this.left.inter(u), this.here, this.right.inter(u), min);
        } else {
            return this.left.inter(u).union(this.right.inter(u));
        }

    }

    public FiniteBag<D> diff(FiniteBag u) {
        FiniteBag removedST = u.remove(here, this.getCount(here));
        return left.union(right).diff(removedST);
    }

    public boolean equal(FiniteBag u) {
        return (this.subset(u) && u.subset(this));
        //
    }

    public boolean subset(FiniteBag u) {
        //elements in this are in FiniteBag. we can find this using count
        //since there would have to be at least 1 item in this that is in u
        //for left, right, and here. 
        //
        return (u.getCount(here) >= this.getCount(here)
                && this.left.subset(u) && this.right.subset(u));

    }

    public FiniteBag<D> insert(D elt, int count) {
        return this.insertInner(elt, count).blacken();
    }

    public FiniteBag<D> insertInner(D elt, int count) {
        if (elt.compareTo(this.here) == 0) {
            return new SBBT_ST(this.left, this.here, this.right, this.count + count, this.isBlack);
        } else if (elt.compareTo(this.here) < 0) {
            return new SBBT_ST(this.left.insert(elt, count), this.here, this.right, this.count, this.isBlack).balance();
        } else {
            return new SBBT_ST(this.left, this.here, this.right.insertInner(elt, count), this.count, this.isBlack).balance();
        }
    }
    
    
    public String stringItS(Sequence<D> s) {
        StringBuffer buffy = new StringBuffer("");
        
        while(s.hasNext()) {
            buffy.append(s.next().seqToString());
            buffy.append(" ");
            s = s.next();
        }
        return buffy.toString();
    }
    
    public String stringIt() {
        return stringItS(this.seq());
    }

    public Sequence<D> seq() {
        return new SequenceST(here, count, (new SequenceCat(left.seq(), right.seq())));
    }

    public int sumIt() {
        return sumItS(this.seq());
    }

    public int sumItS(Sequence<D> as) {
        int sum = 0;
        while (as.hasNext()) {
            sum = sum + 1;
            as = as.next();
        }
        return sum;
    }



}
