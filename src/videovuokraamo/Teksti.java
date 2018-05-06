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
public class Teksti {
    
    public void tervehdys(){
        System.out.println("Tervetuloa videovuokraamon kassapalveluun!");
        System.out.println("Mitä haluat tehdä?");
    }
    
    public void vaihtoehdot(int i){
        switch (i) {
            case 0:
                System.out.println("Valitse numero ja paina enter.\n1. Asiakaspalvelu\n"
                    + "2. Katalogi\n" + "3. Hinnasto");
                break;
            case 1:
                System.out.println("1. Vuokraa\n2. Palauta\n3. Osta karkkia\n"
                    + "4. Lisää asiakas\n5. Asiakkaan tiedot\n"
                        + "6. Lista asiakkaista\n0. Alkuun");    
                break;
            case 2:
                System.out.println("1. Lisää elokuva\n2. Poista elokuva\n3. Lisää hyllyyn\n"
                    + "4. Lisää karkkia\n5. Elokuvan tiedot\n6. Lista elokuvista\n"
                    + "7. Lista karkeista\n0. Alkuun");
                break;
            case 3:
                System.out.println("1. Tulosta hinnasto\n2. Määritä Blu-rayn vuokrahinta\n" 
                    + "3. Määritä DVD:n vuokrauhinta\n4. Määritä karkkien kilohinta(€/100g) ");
                break;
        }
    }
}
