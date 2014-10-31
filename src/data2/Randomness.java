/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data2;
import java.util.Random;

/**
 *
 * @author ldbruby95
 */
public interface Randomness<D extends Comparable> {
    public D createRand();
}

