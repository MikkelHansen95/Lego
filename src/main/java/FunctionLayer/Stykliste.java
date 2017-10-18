/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Mikkel Lindstrøm
 */
public class Stykliste {
    
    private int fireklods;
    private int toklods;
    private int enkeltklods;

    public Stykliste(int fireklods, int toklods, int enkeltklods) {
        this.fireklods = fireklods;
        this.toklods = toklods;
        this.enkeltklods = enkeltklods;
    }

    public int getFireklods() {
        return fireklods;
    }

    public int getToklods() {
        return toklods;
    }

    public int getEnkeltklods() {
        return enkeltklods;
    }
  
}
