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
public class Kontrolleri {
    private Näkymä näky;
    private Elokuvalista elokuvalista = new Elokuvalista();
    private Asiakaslista asiakaslista = new Asiakaslista();
    private Karkkilista karkkilista = new Karkkilista();
    
    public Kontrolleri() {
        näky = new Näkymä(this);
    }
    
    public void lisääLeffalistaan(String nimi, int vuosi){
        Elokuva leffa = new Elokuva(nimi,vuosi);
        elokuvalista.lisääListaan(nimi, leffa);
    }
    
    public void poistaLeffalistalta(String nimi) {
        elokuvalista.poistaListalta(nimi);
    }
    
    public String elokuvanTiedot(String nimi) {
        return this.elokuvalista.getElokuva(nimi).toString();
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