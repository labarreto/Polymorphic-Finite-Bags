/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data2;

import java.util.Random;

/**
 *
 * @author Laura Barreto
 * @param <D> Generic object type
 */
public interface Randomness<D extends Comparable> {
/**
 * 
 * @return Random object of type D which could either be a random int or random string
 */
    public D createRand();
}
