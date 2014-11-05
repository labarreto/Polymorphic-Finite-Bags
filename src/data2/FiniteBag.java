/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data2;

interface finiteBag<D extends Comparable> extends Sequenced<D> { //this is going to implement some 
    //type of iteration abstraction
    // methods that have parameters should take in D elt because 
    // they don't take in just one specific type of parameter since
    // it could be different types. 

//      AVL ... 1 - 2 Tree
//Red-Black ... 2 - 3 Tree
//fake1 and fake 2 are functions
//t1 is a class, 
//fake1 would be nested class or private class only used in smart insert
    public int getCount(D elt); //replaces multiplicity

    public int cardinality(); // size of set. always consistently going
    // to return an int. 

    // (isEmptyHuh t) --> boolean where t is a finite bag
    public boolean isEmptyHuh();

    // (member t elt) --> boolean where t is a finite-bag and elt is an int
    public boolean member(D elt);

    // (remove t elt) --> finite-bag where t is a finite-bag and elt is an int
    public finiteBag<D> remove(D elt);

    public finiteBag<D> remove(D elt, int n);

    public finiteBag<D> removeAll(D elt);

    public finiteBag<D> add(D elt);

    public finiteBag<D> add(D elt, int n);

    public finiteBag<D> blacken();

    public boolean isBlackHuh();


    public boolean equal(finiteBag u);

    public boolean subset(finiteBag u);

    public finiteBag<D> union(finiteBag u);

    public finiteBag<D> inter(finiteBag u);

    public finiteBag<D> diff(finiteBag u);
    
    public finiteBag<D> insert(D elt, int count);
    public finiteBag<D> insertInner(D elt, int count);
    public Sequence<D> seq();
    public int sumIt();
    public int sumItS(Sequence<D> as);

    //replacing multiplicity with getCount 
}
