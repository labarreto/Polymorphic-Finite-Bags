/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data2;

interface finiteBag<D extends Comparable> { //this is going to implement some 
    //type of iteration abstraction
    // methods that have parameters should take in D elt because 
    // they don't take in just one specific type of parameter since
    // it could be different types. 

    public int cardinality(); // size of set. always consistently going
    // to return an int. 

    // (isEmptyHuh t) --> boolean where t is a finite bag
    public boolean isEmptyHuh();

    // (member t elt) --> boolean where t is a finite-bag and elt is an int
    public boolean member(D elt);

    // (remove t elt) --> finite-bag where t is a finite-bag and elt is an int
    public finiteBag remove(D elt);

    public finiteBag add(D elt);

    // (add t elt) --> finite-set where t is a finite-set and elt is an ent
    public boolean equal(finiteBag u);

    public boolean subset(finiteBag u);

    public finiteBag union(finiteBag u);

    public finiteBag inter(finiteBag u);

    public int multiplicity(D elt); //multiplicity of a member of a multiset
    //is the number of times it appears in the multiset. consistently going
    // to return an integer despite checking for abstract object types. 
}
