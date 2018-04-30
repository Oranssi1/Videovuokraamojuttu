/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videovuokraamo;

/**
 *
 * @author Yasaburo
 */
public class Asiakas {
    private String nimi;
    private int pisteet = 0;
    
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
}
