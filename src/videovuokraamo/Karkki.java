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
public class Karkki {
    final private String nimi;
    private int grammaa = 0;
    
    public Karkki(String nimi, int maaraGrammoissa) {
        this.nimi = nimi;
        this.grammaa = maaraGrammoissa;
    }
    
    public int getLukumaara() {
        return grammaa;
    }

    public void lisaaKarkkia(int lisagrammaa) {
        this.grammaa =+ lisagrammaa;
    }

    public boolean vahennaKarkkia(int vahennagrammaa) {
        if (grammaa >= vahennagrammaa) {
            this.grammaa =- vahennagrammaa;
            return true;
        } else {
            return false;
        }
    }

    public String getNimi() {
        return nimi;
    }

    public int getMaara() {
        return grammaa;
    }
    
    @Override
    public String toString() {
        return "Nimi: " + this.nimi + "\nMyynnissä: " + this.grammaa + " grammaa.";
    }
}
