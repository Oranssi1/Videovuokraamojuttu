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
    
    public Kontrolleri() {
        näky = new Näkymä(this);
    }
    
    public void lisaaAsiakas(String nimi) {
        Asiakas asiakas = new Asiakas(nimi.toUpperCase());
        asiakaslista.lisääListaan(nimi.toUpperCase(), asiakas);
    }
    
    public void tulostaAsiakkaanvuokratut(String nimi) {
        nimi = nimi.toUpperCase();
        if (asiakaslista.lista.containsKey(nimi)) {
            asiakaslista.lista.get(nimi).tulostaVuokratut();
        } else {
            System.out.println("Asiakasta ei löydy listalta.");
        }
    }
    
    public void tulostaAsiakkaat() {
        asiakaslista.tulostaLista();
    }
    
    public void vuokraaLeffa(String asiakas, String leffa, int levylaatu) {
        HashMap<String, Asiakas> asiakkaat = asiakaslista.getLista();
        asiakas = asiakas.toUpperCase();
        leffa = leffa.toUpperCase();
        if (!asiakkaat.containsKey(asiakas)) {
            System.out.println("Asiakasta ei asiakaslistalla. Lisätään...");
            this.lisaaAsiakas(asiakas);
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
                        System.out.println("Elokuva " + elokuvalista.lista.get(leffa).getNimi() + " vuokrattu asiakkaalle " + vuokraaja.getNimi() + ".");
                    }
                }
        }
    }
    
    public boolean palautaLeffa(String asiakas, String leffa) {
        if (asiakaslista.lista.containsKey(asiakas)) {
            return false;
        } else {
            Asiakas vuokraaja = asiakaslista.lista.get(asiakas);
            if (!vuokraaja.getVuokralla().containsKey(leffa)) {
                System.out.println("Asiakkaalla ei ole vuokrassa tätä elokuvaa.");
            } else {
                vuokraaja.palautaElokuva(leffa);
                elokuvalista.getElokuva(leffa).lisaaLeffoja(vuokraaja.getVuokralla().get(leffa), 1);
                System.out.println("Elokuva " + leffa + " palautettu hyllyyn.");
            }
            return true;
        }
    }
    
    public void lisääLeffalistaan(String nimi, int vuosi){
        Elokuva leffa = new Elokuva(nimi.toUpperCase(),vuosi);
        elokuvalista.lisääListaan(nimi.toUpperCase(), leffa);
    }
    
    public void poistaLeffalistalta(String nimi) {
        elokuvalista.poistaListalta(nimi.toUpperCase());
    }
    
    public String elokuvanTiedot(String nimi) {
        nimi = nimi.toUpperCase();
        return this.elokuvalista.getNimi(nimi).toString();
    }
    
    public void tulostaLeffalista() {
        elokuvalista.tulostaLista();
    }
    
    public HashMap<String,Asiakas> getAsiakaslista() {
        return this.asiakaslista.lista;
    }
    
    public void lisaaKarkkia(String nimi, int maara) {
        karkkilista.lisääListaan(nimi.toUpperCase(), maara);
    }
    
    public void tulostaKarkit() {
        karkkilista.tulostaLista();
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