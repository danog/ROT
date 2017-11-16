/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author root
 */
public class Rotation {
    public static String rotate(String input, Integer by) {
        String output = "";
        char temp;
        for (int x = 0; x < input.length(); x++) {
            temp = input.charAt(x);
            if (temp >= 'a' && temp <= 'z') {
                temp = (char) ((((temp - 97) + by) % 26) + 97);
            }
            if (temp >= 'A' && temp <= 'Z') {
                temp = (char) ((((temp - 65) + by) % 26) + 65);
            }
            
            output += temp;
        }
        return output;
    }
}
