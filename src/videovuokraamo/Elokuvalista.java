/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videovuokraamo;
import java.util.HashMap;
import java.util.Iterator;
/**
 *
 * @author Yasaburo
 */
public class Elokuvalista {
    HashMap<String, Elokuva> lista = new HashMap();
    
    public int getListaPituus() {
        return this.lista.size();
    }
    
    public Elokuva getNimi(String nimi) {
        return this.lista.get(nimi);
    }
    
    public Elokuva getElokuva(String nimi) {
        return this.lista.get(nimi);
    }
    
    public void lisääListaan(String nimi, Elokuva leffa) {
        if (lista.containsKey(nimi)) {
            System.out.println("Elokuva on jo listalla.");
        } else {
            this.lista.put(nimi, leffa);
            System.out.println("Lisätty.");
        }
    }
    
    public void poistaListalta(String leffa) {
        if (lista.containsKey(leffa)) {
            lista.remove(leffa);
            System.out.println(leffa + " poistettu.");
        } else {
            System.out.println("Elokuvaa ei listalla.");
        }
    }
    
    public void tulostaLista() {
        if (this.lista.size() > 0) {
            Iterator iteraattori = this.lista.keySet().iterator();

            while (iteraattori.hasNext()) {
                String nimi = iteraattori.next().toString();
                System.out.println(">" + nimi + " /Julkaisuvuosi: " + lista.get(nimi).getVuosi() + 
                        "/ Hyllyssä: *Blu-ray* - " + lista.get(nimi).getLukumaara(1) + " *DVD* - " + lista.get(nimi).getLukumaara(2) +
                        "/ Vuokralla: *Blu-ray* - " + lista.get(nimi).getBDVuokralla() + " *DVD* - " + lista.get(nimi).getDVDVuokralla());
            }        
        } else {
            System.out.println("Hyllyssä ei ole elokuvia.");
        }

    }
}