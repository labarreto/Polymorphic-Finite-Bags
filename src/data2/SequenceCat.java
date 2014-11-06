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
public class SequenceCat<D extends Comparable> implements Sequence<D> {
    Sequence<D> left;
    Sequence<D> right;
    
    public SequenceCat(Sequence<D> left, Sequence<D> right) {
        this.left = left;
        this.right = right;
    }

    public boolean hasNext() {
        return this.left.hasNext() || this.right.hasNext();
    }

    public D here() {
        if (this.left.hasNext()){
            return this.left.here();
        } else {
            return this.left.here();
        }
    }
   
                                        
                                    
     public Sequence<D> next() {
         if (this.left.hasNext()) {
             return new SequenceCat(this.left.next(), this.right);
         } else {
             return this.right.next();
         }
     }
     
     public String seqToString() {
         return this.left.seqToString() + " " + this.right.seqToString();
     }
     
     public Sequence<D> seq() {
         return this;
     }
                                    
}
