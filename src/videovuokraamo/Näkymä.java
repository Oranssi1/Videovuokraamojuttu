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
        switch (lukija.nextLine()) {
            case "1":
                System.out.println("VUOKRATOIMINTA");
                break;
            case "2":
                System.out.println("PALAUTUSTOIMINTA");
                break;
            case "3":
                System.out.println("OOSTAKARKKIATOIMINTA");
                break;
            case "4":
                System.out.println("KANTA-ASIAKASTOIMINTA");
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
                controller.elokuvanTiedot(Nimi);
                break;
            case "5":
                controller.tulostaLeffalista();
                break;
            case "6":
                controller.tulostaKarkit();
                break;
            case "7":
                System.out.println("ASIAKASLISTATOIMINTA");
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
