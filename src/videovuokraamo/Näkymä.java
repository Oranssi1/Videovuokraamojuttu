/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videovuokraamo;
import java.util.Scanner;

/**
 *
 * @author Yasaburo
 */
public class Näkymä {
    Scanner lukija = new Scanner(System.in);
    Teksti tekstit = new Teksti();
    Kontrolleri controller;
    
    public Näkymä (Kontrolleri controller) {
        this.controller = controller;
    }
    
    public void valintaAsiakas() {
        tekstit.vaihtoehdot(1);
        lukija.nextLine();
        String animi;
        String enimi;
        int levylaatu;
        switch (lukija.nextLine()) {
            case "1":
                System.out.println("Anna asiakkaan nimi: ");
                animi = lukija.nextLine();
                System.out.println("Anna elokuvan nimi: ");
                enimi = lukija.nextLine();
                System.out.println("Paina 1 jos vuokraat Blu-Raynä\nPaina 2 jos vuokraat DVD:nä");
                levylaatu = Integer.parseInt(lukija.nextLine());
                controller.vuokraaLeffa(animi, enimi, levylaatu);
                break;
            case "2":
                System.out.println("PALAUTUSTOIMINTA");
                System.out.println("Anna asiakkaan nimi: ");
                animi = lukija.nextLine().toUpperCase();
                if (!controller.getAsiakaslista().containsKey(animi)) {
                    System.out.println("Asiakasta ei ole järjestelmässä.");
                } else {
                    controller.tulostaAsiakkaanvuokratut(animi);
                    System.out.println("Anna elokuvan nimi: ");
                    enimi = lukija.nextLine();
                    controller.palautaLeffa(animi, enimi);
                }
                break;
            case "3":
                System.out.println("OOSTAKARKKIATOIMINTA");
                break;
            case "4":
                System.out.println("KANTA-ASIAKASTOIMINTA");
                break;
            case "5":
                System.out.println("Anna asiakkaan nimi: ");
                controller.lisaaAsiakas(lukija.nextLine());
                break;
            case "6":
                System.out.println("Anna asiakkaan nimi: ");
                controller.tulostaAsiakkaanvuokratut(lukija.nextLine());
                break;
            case "7":
                controller.tulostaAsiakkaat();
                break;                
            case "0":
                break;
        }
    }

    public void valintaKatalogi() {
        tekstit.vaihtoehdot(2);
        lukija.nextLine();
        String Nimi;
        switch (lukija.nextLine()) {
            case "1":
                System.out.print("Elokuvan nimi: ");
                Nimi = lukija.nextLine();
                System.out.print("Elokuvan julkaisuvuosi: ");
                int vuosi = Integer.parseInt(lukija.nextLine());
                controller.lisääLeffalistaan(Nimi, vuosi);
                break;
            case "2":
                System.out.println("Elokuvan nimi: ");
                Nimi = lukija.nextLine();
                controller.poistaLeffalistalta(Nimi);
                break;
            case "3":
                System.out.println("Karkin tuotenimi: ");
                Nimi = lukija.nextLine();
                System.out.println("Määrä grammoissa: ");
                int maara = Integer.parseInt(lukija.nextLine());
                controller.lisaaKarkkia(Nimi, maara);
                break;
            case "4":
                System.out.println("Elokuvan nimi: ");
                Nimi = lukija.nextLine();
                System.out.println(controller.elokuvanTiedot(Nimi));
                break;
            case "5":
                controller.tulostaLeffalista();
                break;
            case "6":
                controller.tulostaKarkit();
                break;
            case "0":
                break;
        }
    }
    
    public void valinta() {
        int valinta = 0;
        tekstit.tervehdys();
        do {
            tekstit.vaihtoehdot(0);
            valinta = lukija.nextInt();
        } while (valinta != 1 && valinta != 2);
        
        if (valinta ==1 ) {
            valintaAsiakas();
        } else if (valinta == 2) {
            valintaKatalogi();
        }
    }
}
