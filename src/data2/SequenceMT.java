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
public class SequenceMT<D> implements Sequence<D> {

    public boolean hasNext() {
        return false;
    }

    public D here() {
        return null;
    }

    public SequenceMT<D> next() {
        return this;
    }

    //something in here
    //bloop bloop
}
