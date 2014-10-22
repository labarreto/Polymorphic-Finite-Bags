/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data2;


interface IA {
    //something in here
    //bloop bloop
}
interface finiteBag extends IA{ //this is going to implement some 
                      //type of iteration abstraction
        public int cardinality();
        
        // (isEmptyHuh t) --> boolean where t is a finite bag
        public boolean isEmptyHuh();
        
        // (member t elt) --> boolean where t is a finite-bag and elt is an int
        public boolean member(int elt);
        
        // (remove t elt) --> finite-bag where t is a finite-bag and elt is an int
        public finiteBag remove (int elt);
        
        public finiteBag add(int elt);
        // (add t elt) --> finite-set where t is a finite-set and elt is an ent
                public boolean equal(finiteBag u);
        public boolean subset(finiteBag u);
        public finiteBag union(finiteBag u);
                public finiteBag inter(finiteBag u);


        public int multiplicity(); //multiplicity of a member of a multiset
        //is the number of times it appears in the multiset. 
}
