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
public class Elokuva {
    private String nimi;
    private int vuosi;
    private int BDlukumaara = 0;
    private int DVDlukumaara = 0;
    private double arvosana = 1;
    private int montakoArvosanaa = 1;
    
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

    public void lisaaLeffoja(int levylaji, int maara) {
        if (levylaji == 1) {
            this.BDlukumaara = this.BDlukumaara + maara;
        } else {
            this.DVDlukumaara = this.DVDlukumaara + maara;
        }
    }

    public void vahennaLeffoja(int levylaji, int maara) {
        if (levylaji == 1) {
            this.BDlukumaara = this.BDlukumaara - maara;
        } else {
            this.DVDlukumaara = this.DVDlukumaara - maara;
        }
    }
    
    public Elokuva(String nimi, int vuosi) {
        this.nimi = nimi;
        this.vuosi = vuosi;
    }

    public String getNimi() {
        return nimi;
    }

    public int getVuosi() {
        return vuosi;
    }

    public double getArvosana() {
        return arvosana / this.montakoArvosanaa;
    }
    
    @Override
    public String toString() {
        return "Nimi: " + this.nimi + "\nJulkaisuvuosi: " + this.vuosi + "\nArvosana: " + this.getArvosana() 
                + "\nBlu-ray: " + this.BDlukumaara + "\nDVD: " + this.DVDlukumaara;
    }
}
