/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videovuokraamo;
import java.util.ArrayList;
/**
 *
 * @author Yasaburo
 */
public class Asiakas {
    final private String nimi;
    private int pisteet = 0;
    private ArrayList<String> vuokralla;
    
    public Asiakas(String nimi) {
        this.nimi = nimi;
    }

    public String getNimi() {
        return nimi;
    }

    public int getPisteet() {
        return pisteet;
    }
    
    public void lisaaPisteet(int maara) {
        this.pisteet = this.pisteet + maara;
    }
    
    public void vahennaPisteet(int maara) {
        this.pisteet = this.pisteet - maara;
    }
    
    public boolean vuokraaElokuva(String elokuva) {
        if (this.vuokralla.contains(elokuva)) {
            return false;
        } else {
            this.vuokralla.add(elokuva);
            return true;
        }
    }
    
    public boolean palautaElokuva(String elokuva) {
        if (!this.vuokralla.contains(elokuva)) {
            return false;
        } else {
            this.vuokralla.remove(elokuva);
            return true;
        }
    }

    public ArrayList<String> getVuokralla() {
        return vuokralla;
    }
    
    public void tulostaVuokratut() {
        for (int i = 0;this.vuokralla.size() > i;i++) {
            System.out.println(this.vuokralla);
        }
    }
}
