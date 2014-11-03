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
public class SequenceNMT<D extends Comparable> implements Sequence<D> {
D here;
int count;
Sequence<D> next;

public SequenceNMT(D here, int count, Sequence<D> next) {
    this.here = here;
    this.count = count;
    this.next = next;
}
    

    public boolean hasNext() {
        return true;
    }

    public D here() {
        return this.here;
    }

    public SequenceMT<D> next() {
        if (count > 1) {
            return new SequenceNMT()
        }
    }
    public Sequence<D> seq() {
        return this;
    }
}
