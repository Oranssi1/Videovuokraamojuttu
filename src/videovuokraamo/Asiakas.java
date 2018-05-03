/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videovuokraamo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
/**
 *
 * @author Yasaburo
 */
public class Asiakas {
    final private String nimi;
    private int pisteet = 0;
    private HashMap<String, Integer> vuokralla;
    
    public Asiakas(String nimi) {
        this.nimi = nimi;
        vuokralla = new HashMap<String, Integer>();
//        this.vuokralla.add("asd");
    }

    public String getNimi() {
        return nimi;
    }

    public int getPisteet() {
        return this.pisteet;
    }
    
    public void lisaaPisteet(int maara) {
        this.pisteet = (this.pisteet + maara);
    }
    
    public void vahennaPisteet(int maara) {
        this.pisteet = this.pisteet - maara;
    }
    
    public boolean vuokraaElokuva(String elokuva, int levylaatu) {
        if (this.vuokralla.containsKey(elokuva)) {
            return false;
        } else {
            this.vuokralla.put(elokuva, levylaatu);
            System.out.println(vuokralla);
            return true;
        }
    }
    
    public int levylaatu(String elokuva) {
        return this.vuokralla.get(elokuva);
    }
    
    public void palautaElokuva(String elokuva) {
        this.vuokralla.remove(elokuva);
    }

    public HashMap<String,Integer> getVuokralla() {
        return vuokralla;
    }
    
    public void tulostaVuokratut() {
        if (vuokralla.size() > 0) {
            System.out.println("Vuokralla:");
//            for (int i = 0;this.vuokralla.size() > i;i++) {
                Set<String> keys = vuokralla.keySet();
                int i = 1;
                for (String key : keys) {
                    System.out.println((i) + ". " + key);
                    i++;
                }
//            }
        } else {
            System.out.println("Asiakkaalla ei vuokrauksia.");
        }
    }
}
