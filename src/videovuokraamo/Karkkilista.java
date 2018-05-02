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
public class Karkkilista {
    HashMap<String, Integer> lista = new HashMap();
    
    public int getListaPituus() {
        return this.lista.size();
    }
    
    public int getMaara(String nimi) {
        return this.lista.get(nimi);
    }
    
    public void lisääListaan(String nimi, int maara) {
        if (this.lista.containsKey(nimi)) {
            this.lista.put(nimi, this.lista.get(nimi) + maara);
        } else {
            this.lista.put(nimi, maara);   
        }
    }
    
    public boolean vahennaKarkkia(String nimi, int maara) {
        if (lista.containsKey(nimi) && lista.get(nimi) >= maara) {
            this.lista.put(nimi, this.lista.get(nimi) - maara);
            return true;
        } else {
            return false;
        }
    }
    
    public void tulostaLista() {
        if (this.lista.size() > 0) {
            Iterator iteraattori = this.lista.keySet().iterator();

            while (iteraattori.hasNext()) {
                String nimi = iteraattori.next().toString();
                System.out.println(">" + nimi + ", Määrä: " + this.lista.get(nimi) + " grammaa.");
            }
        } else {
            System.out.println("Kaupassa ei ole karkkia.");
        }
    }
}