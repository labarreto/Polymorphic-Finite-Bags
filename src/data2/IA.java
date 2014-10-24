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
public interface IA<D> {
    //abstract iterator takes in generic type D. 

    
    
    public boolean hasNext();


    public D here(); //one single generic object D 

    public IA<D> next(); //
    //something in here
    //bloop bloop
}
