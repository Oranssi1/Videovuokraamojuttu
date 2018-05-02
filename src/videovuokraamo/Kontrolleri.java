/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videovuokraamo;
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
        Asiakas asiakas = new Asiakas(nimi);
        asiakaslista.lisääListaan(nimi, asiakas);
    }
    
    public void tulostaAsiakkaat() {
        asiakaslista.tulostaLista();
    }
    
    public void vuokraaLeffa(String asiakas, String leffa, int levylaatu) {
        HashMap<String, Asiakas> asiakkaat = asiakaslista.getLista();
        if (!asiakkaat.containsKey(asiakas)) {
            System.out.println("Asiakasta ei asiakaslistalla. Lisätään...");
            this.lisaaAsiakas(asiakas);
        }
        Asiakas vuokraaja = asiakkaat.get(asiakas);
        
        if (!elokuvalista.lista.containsKey(leffa)) {
            System.out.println("Elokuvaa ei listalla");
        }else if (vuokraaja.getVuokralla().contains(leffa)) {
            System.out.println("Asiakas on jo vuokrannut elokuvan.");            
        } else {
            
            if (elokuvalista.lista.get(leffa).getLukumaara(levylaatu) < 0) {
                System.out.println("Varastossa ei jäljellä tätä elokuvaa tässä formaatissa. Tilaa lisää.");
            } else {
                elokuvalista.lista.get(leffa).vahennaLeffoja(levylaatu, 1);
                vuokraaja.vuokraaElokuva(elokuvalista.lista.get(leffa).getNimi());
                System.out.println("Elokuva " + elokuvalista.lista.get(leffa).getNimi() + " vuokrattu asiakkaalle " + vuokraaja.getNimi() + ".");
            }
        }
    }
    
    public void lisääLeffalistaan(String nimi, int vuosi){
        Elokuva leffa = new Elokuva(nimi,vuosi);
        elokuvalista.lisääListaan(nimi, leffa);
    }
    
    public void poistaLeffalistalta(String nimi) {
        elokuvalista.poistaListalta(nimi);
    }
    
    public String elokuvanTiedot(String nimi) {
        return this.elokuvalista.getNimi(nimi).toString();
    }
    
    public void tulostaLeffalista() {
        elokuvalista.tulostaLista();
    }
    
    public void lisaaKarkkia(String nimi, int maara) {
        karkkilista.lisääListaan(nimi, maara);
    }
    
    public void tulostaKarkit() {
        karkkilista.tulostaLista();
    }
    
    public void operoi() {
        while(true) {
            näky.valinta();
        }
    }

    public static void main(String[] args) {
        Kontrolleri controller = new Kontrolleri();
        controller.operoi();
    }
}