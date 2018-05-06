/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videovuokraamo;

import java.text.DecimalFormat;

/**
 *
 * @author Yasaburo
 */
public class Elokuva {
    private String nimi;
    private int vuosi;
    private int BDlukumaara = 1;
    private int DVDlukumaara = 1;
    private int BDvuokralla = 0;
    private int DVDvuokralla = 0;
    private double arvosana = 0;
    private int montakoArvosanaa = 0;
    DecimalFormat desiFormaatti = new DecimalFormat("#.00");
    
    public Elokuva(String nimi, int vuosi) {
        this.nimi = nimi.toUpperCase();
        this.vuosi = vuosi;
    }
        
    public int getLukumaara(int levylaji) {
        if (levylaji == 1) {
            return BDlukumaara;
        } else {
            return DVDlukumaara;
        }
    }
    
    public void setLukumaara(int levylaji, int maara) {
        if (levylaji == 1) {
            this.BDlukumaara = maara;
        } else {
            this.DVDlukumaara = maara;
        }
    }
    
    public int getBDVuokralla() {
        return this.BDvuokralla;
    }

    public int getDVDVuokralla() {
        return this.DVDvuokralla;
    }
    
    public void lisaaHyllyyn(int BD, int DVD) {
        this.BDlukumaara = this.BDlukumaara + BD;
        this.DVDlukumaara = this.DVDlukumaara + DVD;
    }
    
    public void lisaaLeffoja(int levylaji, int maara) {
        if (levylaji == 1) {
            this.BDlukumaara = this.BDlukumaara + maara;
            this.BDvuokralla = this.BDvuokralla - maara;
        } else {
            this.DVDlukumaara = this.DVDlukumaara + maara;
            this.DVDvuokralla = this.DVDvuokralla - maara;
        }
    }

    public void vahennaLeffoja(int levylaji, int maara) {
        if (levylaji == 1) {
            this.BDlukumaara = this.BDlukumaara - maara;
            this.BDvuokralla = BDvuokralla + maara;
        } else {
            this.DVDlukumaara = this.DVDlukumaara - maara;
            this.DVDvuokralla = this.DVDvuokralla + maara;
        }
    }

    public String getNimi() {
        return nimi;
    }

    public int getVuosi() {
        return vuosi;
    }

    public void lisaaArvosana(int arvo) {
        this.montakoArvosanaa = this.montakoArvosanaa + 1;
        this.arvosana = this.arvosana + arvo;
    }
    
    public double getArvosana() {
        if (this.montakoArvosanaa <= 0) {
            return 0;
        } else {
            return 1.0 * arvosana / this.montakoArvosanaa;
        }
    }
    
    @Override
    public String toString() {
        return "Nimi: " + this.nimi + "\nJulkaisuvuosi: " + this.vuosi + "\nArvosana: " + desiFormaatti.format(this.getArvosana()) 
                + "\nBlu-ray: " + this.BDlukumaara + "\nDVD: " + this.DVDlukumaara;
    }
}
