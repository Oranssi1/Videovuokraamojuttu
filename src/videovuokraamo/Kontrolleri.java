/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videovuokraamo;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Yasaburo
 */
public class Kontrolleri {
    private Näkymä näky;
    private Elokuvalista elokuvalista = new Elokuvalista();
    private Asiakaslista asiakaslista = new Asiakaslista();
    private Karkkilista karkkilista = new Karkkilista();
    private Kassa kassa = new Kassa();
    
    public Kontrolleri() {
        näky = new Näkymä(this);
    }
    
    public void lisaaAsiakas(String nimi) {
        Asiakas asiakas = new Asiakas(nimi);
        asiakaslista.lisääListaan(nimi, asiakas);
    }
    
    public void tulostaAsiakkaanvuokratut(String nimi) {
        if (asiakaslista.lista.containsKey(nimi)) {
            asiakaslista.lista.get(nimi).tulostaVuokratut();
        } else {
            System.out.println("Asiakasta ei löydy listalta.");
        }
    }
    
    public void tulostaAsiakkaat() {
        asiakaslista.tulostaLista();
    }
    
    public void tulostaKantapisteet(String asiakas) {
        Asiakas vuokraaja = (Asiakas) (asiakaslista.getLista()).get(asiakas);
        int pisteet = vuokraaja.getPisteet();
        System.out.println("Kanta-asiakaspisteitä: " + pisteet + " pistettä.");
    }
    
    public boolean onkoElokuvaa(String leffa) {
        if (elokuvalista.lista.containsKey(leffa)) {
            return true;
        }
        return false;
    }
    
    public void vuokraaLeffa(String asiakas, String leffa, int levylaatu) {
        HashMap<String, Asiakas> asiakkaat = asiakaslista.getLista();
        if (!asiakkaat.containsKey(asiakas)) {
            System.out.println("Asiakasta ei asiakaslistalla. Lisätään...");
            this.lisaaAsiakas(asiakas);
            System.out.println("");
        }
        Asiakas vuokraaja = asiakkaat.get(asiakas);
        
        if (!elokuvalista.lista.containsKey(leffa)) {
            System.out.println("Elokuvaa ei listalla");
        } else {
                if (vuokraaja.getVuokralla().containsKey(leffa)) {
                    System.out.println("Asiakas on jo vuokrannut elokuvan.");            
                } else {

                    if (elokuvalista.lista.get(leffa).getLukumaara(levylaatu) <= 0) {
                        System.out.println("Varastossa ei jäljellä tätä elokuvaa tässä formaatissa. Tilaa lisää.");
                    } else {
                        elokuvalista.lista.get(leffa).vahennaLeffoja(levylaatu, 1);
                        vuokraaja.vuokraaElokuva(elokuvalista.lista.get(leffa).getNimi(),levylaatu);
                        kassa.vuokraus(levylaatu);
                        System.out.println("Elokuva " + elokuvalista.lista.get(leffa).getNimi() + " vuokrattu asiakkaalle " + vuokraaja.getNimi() + ".");
                        System.out.println("Kassassa on rahaa " + kassa.getSaldo() + " euroa.");
                    }
                    if (vuokraaja.getPisteet() > 300) {
                        System.out.println("Asiakas saa 5 euroa alennusta 300 kanta-asiakaspisteellään!");
                        vuokraaja.vahennaPisteet(300);
                    } else {
                        System.out.println("Asiakas ansainnut 100 kanta-asiakaspistettä.");
                        vuokraaja.lisaaPisteet(100);
                    }
                }
        }
    }
    
    public boolean palautaLeffa(String asiakas, String leffa) {
        Asiakas vuokraaja = asiakaslista.lista.get(asiakas);
        if (!vuokraaja.getVuokralla().containsKey(leffa)) {
            System.out.println("Asiakkaalla ei ole vuokrassa tätä elokuvaa.");
            return false;
        } else {
            elokuvalista.getElokuva(leffa).lisaaLeffoja(vuokraaja.getVuokralla().get(leffa), 1);
            System.out.println("Elokuva " + leffa + " palautettu hyllyyn.");
            vuokraaja.palautaElokuva(leffa);
            return true;
        }
    }
    
    public void arvosana(String leffa, int arvo) {
            elokuvalista.getElokuva(leffa).lisaaArvosana(arvo);
    }
    
    public void lisaaLeffojaHyllyyn(String leffa, int BD, int DVD) {
        if (BD < 0 || DVD < 0) {
            System.out.println("Negatiivista määrää leffoja ei voi tilata.");
        } else if (this.elokuvalista.lista.containsKey(leffa)) {
            this.elokuvalista.lista.get(leffa).lisaaHyllyyn(BD, DVD);
            System.out.println("Elokuvat tuotu hyllyyn.");
        } else {
            System.out.println("Elokuvaa ei listalla.");
        }
    }
    
    public void lisääLeffalistaan(String nimi, int vuosi){
        Elokuva leffa = new Elokuva(nimi,vuosi);
        elokuvalista.lisääListaan(nimi, leffa);
    }
    
    public void poistaLeffalistalta(String nimi) {
        elokuvalista.poistaListalta(nimi);
    }
    
    public void elokuvanTiedot(String nimi) {
        if (!elokuvalista.lista.containsKey(nimi)) {
            System.out.println("Elokuvaa ei listalla");
        } else {
            System.out.println(this.elokuvalista.getNimi(nimi).toString()); 
        }
    }
    
    public void tulostaLeffalista() {
        elokuvalista.tulostaLista();
    }
    
    public HashMap<String,Asiakas> getAsiakaslista() {
        return this.asiakaslista.lista;
    }
    
    public void lisaaKarkkia(String nimi, int maara) {
        karkkilista.lisääListaan(nimi, maara);
    }
    
    public void myyKarkkia(String asiakas, String karkki, int maara) {
        HashMap<String, Asiakas> asiakkaat = asiakaslista.getLista();;
        if (!asiakkaat.containsKey(asiakas)) {
            System.out.println("Asiakasta ei asiakaslistalla. Lisätään...");
            this.lisaaAsiakas(asiakas);
            System.out.println("");
        }
        Asiakas ostaja = asiakaslista.getAsiakas(asiakas);
        this.karkkilista.vahennaKarkkia(karkki, maara);
        kassa.karkinmyynti(maara);
        ostaja.lisaaPisteet(maara/2);
        System.out.println("Myynti suoritettu. \nAsiakas ansaitsi " + (maara/2) + " kanta-asiakaspistettä.");
        System.out.println("Kassassa on rahaa " + kassa.getSaldo() + " euroa.");
    }
    
    public void tulostaKarkit() {
        karkkilista.tulostaLista();
    }
    
    public double getBDhinta() {
        return kassa.getBDvuokra();
    }
    
    public void setBDhinta(double hinta) {
        kassa.setBDhinta(hinta);
    }
    
    public double getDVDhinta() {
        return kassa.getDVDvuokra();
    }

    public void setDVDhinta(double hinta) {
        kassa.setDVDhinta(hinta);
    }
    
    public double getKarkkihinta() {
        return kassa.getKarkkihinta();
    }    
    
    public void setKarkkihinta(double hinta) {
        kassa.setKarkkihinta(hinta);
    }
    
    public double getSaldo() {
        return kassa.getSaldo();
    }
    
    public int getKarkkilistaPituus() {
        return karkkilista.getListaPituus();
    }
    
    public void operoi() {
        Elokuva kane = new Elokuva("CITIZEN KANE", 1941);
        elokuvalista.lisääListaan("CITIZEN KANE", kane);
        Elokuva matrix = new Elokuva("MATRIX", 1999);
        elokuvalista.lisääListaan("MATRIX", matrix);
        
        while(true) {
            näky.valinta();
        }
    }

    public static void main(String[] args) {
        Kontrolleri controller = new Kontrolleri();
        controller.operoi();
    }
}