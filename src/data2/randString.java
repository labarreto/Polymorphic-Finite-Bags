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
public class randString implements Randomness<String> {
    public static final String CHAR_LIST = 
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    public static final int RAND_STRING_LENGTH = genRandInt();

    public static int genRandInt() {

        Random rand = new Random();
        int randomNum = rand.nextInt((25 - 1) + 1) + 1;
        return randomNum;
        
    }

    public String createRand() {
        StringBuffer randString = new StringBuffer();
        
        for(int i  = 0; i < RAND_STRING_LENGTH; i++) {
           int inty = genRandInt();
           char ch = CHAR_LIST.charAt(inty);
           randString.append(ch);
           
        }
        return randString.toString();
        
    }
    
}
