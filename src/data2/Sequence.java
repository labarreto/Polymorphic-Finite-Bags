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
//iterator interface
public interface Sequence<D> {

    public D here();

    //looks at object here
    public boolean hasNext();

    //checks to see if there is a next element
    public Sequence<D> next();
    //moves to the next item in sequence. Originally named this IAInt,
    //but it makes more sense to refer to its functionality "sequence"
}
