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
                    + "2. Katalogi");
                break;
            case 1:
                System.out.println("1. Vuokraa\n2. Palauta\n3. Osta karkkia\n"
                    + "4. Kanta-asiakaspisteet\n5. Lisää asiakas\n6. Lista asiakkaista\n0. Alkuun");    
                break;
            case 2:
                System.out.println("1. Lisää elokuva\n2. Poista elokuva\n"
                    + "3. Lisää karkkia\n4. Elokuvan tiedot\n5. Lista elokuvista\n"
                    + "6. Lista karkeista\n0. Alkuun");
                break;
        }
    }

}
