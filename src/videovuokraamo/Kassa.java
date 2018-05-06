
package videovuokraamo;

/**
 *
 * @author tommi
 */
public class Kassa {
    
    private double saldo=1000.0;
    private double BDvuokra=10.0;
    private double DVDvuokra=5.0;
    private double karkkihinta=1.0;
    
    
    public double getSaldo() {
        return saldo;
    }
    
    public void vuokraus(int levylaji){
        if(levylaji ==1){
            this.saldo = this.saldo + this.BDvuokra ;
        }   else 
            { this.saldo = this.saldo + this.DVDvuokra;
        }
    }
    public void karkinmyynti(double maara){
        this.saldo = this.karkkihinta * (maara/100);       
}    
    
    public void setBDhinta(double hinta){
        this.BDvuokra = hinta;
    }

    public double getBDvuokra() {
        return BDvuokra;
    }

    public double getDVDvuokra() {
        return DVDvuokra;
    }

    public double getKarkkihinta() {
        return karkkihinta;
    }
    
    
    public void setDVDhinta(double hinta){
        this.DVDvuokra= hinta;
    }
    
    public void setKarkkihinta(double hinta){
        this.karkkihinta = hinta;
        //hinta €/100g
    }
}
