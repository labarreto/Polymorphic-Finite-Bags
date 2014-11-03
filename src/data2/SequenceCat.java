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

    hasnext 
    this.left.hasnext or this.right.has next
                    
                    
                    here if this.left.hasnext , return this.left.here
                            else return this.right.here
                                    
                                    
     next
                                    if left has next, return new cat sequence left.next, right.next
                                    
}
