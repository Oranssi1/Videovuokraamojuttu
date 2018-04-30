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
public class Asiakaslista {
    HashMap<String, Asiakas> lista = new HashMap();
    
    public int getListaPituus() {
        return this.lista.size();
    }
    
    public Asiakas getAsiakas(String nimi) {
        return this.lista.get(nimi);
    }
    
    public void lisääListaan(String nimi, Asiakas asiakas) {
        if (lista.containsKey(nimi)) {
            System.out.println("Asiakas on jo järjestelmässä.");
        } else {
            this.lista.put(nimi, asiakas);
            System.out.println("Lisätty.");
        }
    }
    
    public void poistaListalta(String asiakas) {
        if (lista.containsKey(asiakas)) {
            lista.remove(asiakas);
            System.out.println(asiakas + " poistettu.");
        } else {
            System.out.println("Asiakasta ei löydy järjestelmästä.");
        }
    }
    
    public void tulostaLista() {
        Iterator iteraattori = this.lista.keySet().iterator();

        while (iteraattori.hasNext()) {
            String nimi = iteraattori.next().toString();
            System.out.println("asiakas : \"" + lista.get(nimi).getNimi() + "\" Kanta-asiakaspisteet: " + lista.get(nimi).getPisteet());
        }
    }
}
