/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data2;

public interface FiniteBag<D extends Comparable> extends Sequenced<D> { 

    public int getCount(D elt); 

    public int cardinality(); 

    public boolean isEmptyHuh();

    public boolean member(D elt);

    public FiniteBag<D> remove(D elt);

    public FiniteBag<D> remove(D elt, int n);

    public FiniteBag<D> removeAll(D elt);

    public FiniteBag<D> add(D elt);

    public FiniteBag<D> add(D elt, int n);

    public FiniteBag<D> blacken();

    public boolean isBlackHuh();

    public boolean equal(FiniteBag u);

    public boolean subset(FiniteBag u);

    public FiniteBag<D> union(FiniteBag u);

    public FiniteBag<D> inter(FiniteBag u);

    public FiniteBag<D> diff(FiniteBag u);
    
    public Sequence<D> seq();
    
    public int sumIt();
    
    public int sumItS(Sequence<D> as);
    
    public String stringIt();
    
    public String stringItS(Sequence<D> s);

}
