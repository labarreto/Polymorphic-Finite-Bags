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

public interface FiniteBag<D extends Comparable> extends Sequenced<D> { 
/**
 * 
 * Example: {a, a, a, b, c}.getCount(a) = 3;
 * Example: {a, a, a, b}.getCount(b) = 1;
 * @param elt is a generic object type D
 * @return Int that represents the amount of elts in the FiniteBag
 */
    public int getCount(D elt); 
    
    /**
     * Example: {a, a, a, b, c}.cardinality() = 5;
     * Example: {}.cardinality() = 0;
     * Example: {1500000000}.cardinality() = 1;
     * @return Int that represents the size of the set or the total amount of elements
     */


    public int cardinality(); 
    
    /**
     * Example: {}.isEmptyHuh() = true;
     * Example: {a, b, c, d}.isEmptyHuh() = false;
     * @return Boolean that represents whether the set 
     */

    public boolean isEmptyHuh();
    
    /**
     * Example: {a, b, c}.member(a) = true;
     * Example: {a, b, c}.member(d) = false;
     * @param elt is a generic object type D
     * @return Boolean that represents whether the elt is in the FiniteBag
     */

    public boolean member(D elt);
    
    /**
     * Example: {a, b, c}.remove(a) = {b, c}
     * @param elt is a generic object type D
     * @return FiniteBag with one less count of elt.
     */

    public FiniteBag<D> remove(D elt);
    
    /**
     * Example: {a, a, a, a, b, c}.remove(a, 2) = {a, a, b, c}
     * @param elt is a generic object type D
     * @param n is an int that indicates the number of elements to be removed
     * @return FiniteBag with n less counts of elt.
     */

    public FiniteBag<D> remove(D elt, int n);
    
     /**
     * Example: {a, a, a, a, b, c}.removeAll(a) = {b, c}
     * @param elt is a generic object type D
     * @return FiniteBag with all instances of elt removed.
     */

    public FiniteBag<D> removeAll(D elt);
    
    /**
     * Example: {a, c}.add(b) = {a, b, c}
     * @param elt is a generic object type D
     * @return FiniteBag that is balanced with an inserted elt
     */

    public FiniteBag<D> add(D elt);
    
    /**
     * Example: {a, c}.add(b,2} = {a, b, b, c}
     * @param elt is a generic object type D
     * @param n is an int that indicates the number of elements to be added
     * @return FiniteBag that is balanced with n inserted elts
     */

    public FiniteBag<D> add(D elt, int n);

    /**
     * Example: {a}.equal{b} = false;
     * Example: {a, b}.equal{a, b} = true;
     * @param u is a FiniteBag containing generic object types D
     * @return Boolean that indicates whether FiniteBags are equal
     */

    public boolean equal(FiniteBag u);
    
    /**
     * Example: {a, b, c}.subset{a, b, c, d} = true;
     * Example: {a, b, c}.subset{a, b, c} = true;
     * Example: {a, b, c}.subset{a, b} = false;
     * @param u is a FiniteBag containing generic object types D
     * @return Boolean that indicates whether this is a subset of u
     */
    
    public boolean subset(FiniteBag u);
    
    /**
     * Example: {a, b, c}.union{a, b, c, d} = {a, a, b, b, c, c, d};
     * Example: {a, b, c}.union{d, e, f} = {a, b, c, d, e, f};
     * Example: {a, b, c}.union{} = {a, b, c};
     * @param u is a FiniteBag containing generic object types D
     * @return FiniteBag containing everything in this or u
     */

    
    public FiniteBag<D> union(FiniteBag u);
    /**
     * Example: {a, b, c}.inter{a, b, c, d} = {a, b, c};
     * Example: {a, b, c}.inter{d, e, f} = {};
     * Example: {a, b, c}.inter{} = {};
     * @param u is a FiniteBag containing generic object types D
     * @return FiniteBag containing everything in this and u
     */
    public FiniteBag<D> inter(FiniteBag u);
    
     /**
     * Example: {a, b, c}.diff{a, b, c, d} = {d};
     * Example: {a, b, c}.diff{d, e, f} = {d, e, f};
     * Example: {a, b, c}.diff{} = {};
     * @param u is a FiniteBag containing generic object types D
     * @return FiniteBag containing everything in u that is not in this
     */

    public FiniteBag<D> diff(FiniteBag u);
    
    
    /**
     * 
     * @return A Sequence that contains objects of generic type D
     */
    public Sequence<D> seq();
    
    /**
     * 
     * @return Int that represents the number of elements in this sequence
     */
    public int sumIt();
    
    /**
     * 
     * @param s is a sequence that contains objects of generic type D
     * @return Int that represents the number of elements in the s sequence
     */
    
    public int sumItS(Sequence<D> s);
    
    /**
     * 
     * @return String containing all items in this sequence
     */
    
    public String stringIt();
    
    /**
     * 
     * @param s is a sequence that contains objects of generic type D
     * @return String containing all items in the s sequence
     */
    
    public String stringItS(Sequence<D> s);
    
     /**
     *
     * @return Black parent node
     */

    public FiniteBag<D> blacken();
    
    /**
     * 
     * @return Boolean that returns true if root in FiniteBag is black
     */

    
    public boolean isBlackHuh();
    
    /**
     * 
     * @return Balanced FiniteBag
     */
    
    public FiniteBag<D> balance();

}
