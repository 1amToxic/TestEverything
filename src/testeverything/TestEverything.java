/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeverything;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lamit
 */
public class TestEverything {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String s =  sc.nextLine();
        s = s.trim();
        System.out.println(s);
        StringTokenizer stk = new StringTokenizer(s," ");
        ArrayList<String> list = new ArrayList<>();
        int sum = 0;
        while(stk.hasMoreTokens()){
            list.add(stk.nextToken()); 
            sum++;
        }
        System.out.println(sum);
        System.out.println(list.get(0));
        System.out.println(list.get(list.size()-1));
        // TODO code application logic here
    }
    
}
