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
                //Elokuvan vuokraamistoiminta
                System.out.println("Anna asiakkaan nimi: ");
                animi = lukija.nextLine().toUpperCase();
                System.out.println("Anna elokuvan nimi: ");
                enimi = lukija.nextLine().toUpperCase();
                System.out.println("Paina 1 jos vuokraat Blu-Raynä\nPaina 2 jos vuokraat DVD:nä");
                levylaatu = Integer.parseInt(lukija.nextLine());
                controller.vuokraaLeffa(animi, enimi, levylaatu);
                break;
            case "2":
                //Elokuvan palautustoiminta
                System.out.println("Anna asiakkaan nimi: ");
                animi = lukija.nextLine().toUpperCase();
                if (!controller.getAsiakaslista().containsKey(animi)) {
                    System.out.println("Asiakasta ei ole järjestelmässä.");
                } else {
                    controller.tulostaAsiakkaanvuokratut(animi);
                    System.out.println("Anna elokuvan nimi: ");
                    enimi = lukija.nextLine().toUpperCase();
                    if (controller.palautaLeffa(animi, enimi)) {
                        System.out.println("Asiakkaan arvosana elokuvalle (1-5)?\n"
                                + "0 jos asiakas ei halua antaa arvosanaa.");
                        int numero = Integer.parseInt(lukija.nextLine());
                        if (numero >= 1 && numero <= 5) {
                            System.out.println("asdasd");
                            controller.arvosana(enimi, numero);                            
                        }
                    }
                }
                break;
            case "3":
                //Karkin ostamistoiminta
                if (controller.getKarkkilistaPituus() <= 0) {
                    System.out.println("Kaupassa ei ole karkkia. Hae lisää katalogista.");
                } else {
                    System.out.println("Anna asiakkaan nimi:");
                    animi = lukija.nextLine().toUpperCase();
                    controller.tulostaKarkit();
                    System.out.println("Mitä karkkia asiakas ostaa?");
                    enimi = lukija.nextLine().toUpperCase();
                    System.out.println("Kuinka paljon? (grammoissa)");
                    int maara = Integer.parseInt(lukija.nextLine());
                    controller.myyKarkkia(animi, enimi, maara);
                }
                break;
            case "4":
                //Asiakkaan lisäys
                System.out.println("Anna asiakkaan nimi: ");
                controller.lisaaAsiakas(lukija.nextLine().toUpperCase());
                break;
            case "5":
                //Tulostaa asiakkaan vuokraukset ja kanta-asiakaspisteet listana
                System.out.println("Anna asiakkaan nimi: ");
                animi = lukija.nextLine().toUpperCase();
                controller.tulostaAsiakkaanvuokratut(animi);
                controller.tulostaKantapisteet(animi);
                break;
            case "6":
                //Tulostaa kaikkien asiakkaiden tiedot listana
                controller.tulostaAsiakkaat();
                break;                
            case "0":
                //Palaa alkuun
                break;
        }
        System.out.println("");
    }

    public void valintaKatalogi() {
        tekstit.vaihtoehdot(2);
        lukija.nextLine();
        String Nimi;
        switch (lukija.nextLine()) {
            case "1":
                //Lisää nimikkeen elokuvalistaan
                System.out.print("Elokuvan nimi: ");
                Nimi = lukija.nextLine().toUpperCase();
                System.out.print("Elokuvan julkaisuvuosi: ");
                int vuosi = Integer.parseInt(lukija.nextLine());
                controller.lisääLeffalistaan(Nimi, vuosi);
                break;
            case "2":
                //Poistaa nimikkeen elokuvalistasta
                System.out.println("Elokuvan nimi: ");
                Nimi = lukija.nextLine().toUpperCase();
                controller.poistaLeffalistalta(Nimi);
                break;
            case "3":
                //Lisää elokuvia hyllyyn.
                System.out.println("Elokuvan nimi: ");
                Nimi = lukija.nextLine().toUpperCase();
                System.out.println("Montako Blu-ray-kopiota tilataan: ");
                int BD = Integer.parseInt(lukija.nextLine());
                System.out.println("Montako DVD-kopiota tilataan: ");
                int DVD = Integer.parseInt(lukija.nextLine());
                controller.lisaaLeffojaHyllyyn(Nimi, BD, DVD);
                break;
            case "4":
                //Lisää karkityypin karkkihyllyyn
                System.out.println("Karkin tuotenimi: ");
                Nimi = lukija.nextLine().toUpperCase();
                System.out.println("Määrä grammoissa: ");
                int maara = Integer.parseInt(lukija.nextLine());
                controller.lisaaKarkkia(Nimi, maara);
                break;
            case "5":
                //Tulostaa yhden elokuvan tiedot
                System.out.println("Elokuvan nimi: ");
                Nimi = lukija.nextLine().toUpperCase();
                controller.elokuvanTiedot(Nimi);
                break;
            case "6":
                //Tulostaa elokuvat listana
                controller.tulostaLeffalista();
                break;
            case "7":
                //Tulostaa karkit listana
                controller.tulostaKarkit();
                break;
            case "0":
                //Paluu alkuun
                break;
        }
        System.out.println("");
    }
    
    public void valintaHinnasto(){
        tekstit.vaihtoehdot(3);
        lukija.nextLine();
        double hinta;
        
        switch(lukija.nextLine()){
            case "1":
                System.out.println("Blu-Rayn vuokrahinta on: " + controller.getBDhinta());
                System.out.println("DVD:n vuokrauhinta on : " + controller.getDVDhinta());
                System.out.println("Karkin hinta €/100g on : " + controller.getKarkkihinta());
                System.out.println("Kassasta löytyy rahaa : " + controller.getSaldo());
                break;
            case "2":
                System.out.println("BR vuokrahinta on tällä hetkellä : " + controller.getBDhinta() + "\nAnna uusi hinta.");
                controller.setBDhinta(lukija.nextDouble());
                break;
            case "3":
                System.out.println("DVD vuokrahinta on tällä hetkellä : " + controller.getDVDhinta() + "\nAnna uusi hinta.");
                controller.setDVDhinta(lukija.nextDouble());
                break;
            case "4":
                System.out.println("Karkkien hinta €/100g on tällä hetkellä : " + controller.getKarkkihinta() + "\nAnna karkien uusi hinta.");
                controller.setKarkkihinta(lukija.nextDouble());
                break;
        }
        System.out.println("");
        
    }
    
    public void valinta() {
        int valinta = 0;
        tekstit.tervehdys();
        do {
            tekstit.vaihtoehdot(0);
            valinta = lukija.nextInt();
            System.out.println("");
        } while (valinta != 1 && valinta != 2 && valinta != 3);
        
        if (valinta ==1 ) {
            //Asiakaspalvelumenu
            valintaAsiakas();
        } else if (valinta == 2) {
            //Katalogimenu
            valintaKatalogi();
        } else if (valinta == 3) {
            //Kassa/hinnasto
            valintaHinnasto();
        }    
    }
}