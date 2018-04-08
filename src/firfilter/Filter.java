/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firfilter;

/**
 *
 * @author Ahmed
 */

class Filter {
    
    final int CMAX = 6;
    int circ[] = new int[CMAX];
    int b[] = new int[CMAX];
    int pos;
    
    void Filter(){
    }
    
    void circ_init(){
        for (int i = 0; i < CMAX; i++) {
            circ[i] = 0;
            b[i] = i+1;
        }
        pos = 0;
    }
    
    void circ_update(int new_value){
        pos = ((pos == 0) ? CMAX-1 : (pos-1));
        circ[pos] = new_value;
    }
    
    int circ_get(int i){
        return circ[(pos+i)%CMAX];
    }
    
    Long fir(int new_value){
        long result = 0;
        circ_update(new_value);
        for (int i = 0; i < CMAX; i++) {
            result += b[i]*circ_get(i);
        }
        return result;
    }
    
    String display(){
        String content = "";
        for (int i = 0; i < CMAX; i++) {
            content += "Sample [ " + i + " ] = " + circ_get(i) + "\t\t" + 
                    "b [ " + i + " ] = " + b[i] + "\n";
        }
        return content;
    }
}
