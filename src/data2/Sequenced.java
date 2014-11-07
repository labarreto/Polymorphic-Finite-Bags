/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data2;

/**
 *
 * @author Laura Barreto
 * @param <D> Generic object type
 */
public interface Sequenced<D extends Comparable> {
    
    
    /**
     * Example: {a, b, c, d}.seq() = [a, b, c, d]
     * @return A Sequence containing objects of generic type D in this
     */
        public Sequence<D> seq();
    
    
}
