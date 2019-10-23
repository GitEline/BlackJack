import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StartBlackJack {
    public static void main(String[] args) {
        Boolean quit = false;

            String[] kaartKleuren = {"H", "R", "K", "S"};
            String[] kaartTypen = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "H", "V", "B", "A"};
            List<String> kaartenInSpel = new ArrayList<>();

            for (String kaartType : kaartKleuren) {
                for (String kaartWaarde : kaartTypen) {
                    String kaart = kaartType + kaartWaarde;
                    kaartenInSpel.add(kaart);
                }
            }

//            System.out.println(kaartenInSpel); // kaarten voor shuffle
            Collections.shuffle(kaartenInSpel);
//            System.out.println(kaartenInSpel); // kaarten na shuffle

            System.out.println("Kies een kaart [k], pass[p] of quit [q]");
            List<String>getrokkenKaarten = new ArrayList<>();
            do {
                Scanner commandReader = new Scanner(System.in);
                String command = commandReader.nextLine();

                if (command.equals("q")) {
                    quit = true;
                } else if (command.equals("k")) {
                    System.out.println(kaartenInSpel.get(0));
                    getrokkenKaarten.add(kaartenInSpel.get(0));
                    kaartenInSpel.remove(0);
                    System.out.println("Totale punten aantal: " + berekeningPunten(getrokkenKaarten));
                } else if (command.equals("p")) {
                    System.out.println("De getrokken kaarten zijn: " + getrokkenKaarten);
                    System.out.println("Totale punten aantal: " + berekeningPunten(getrokkenKaarten));
                } else {
                    System.out.println("Commando incorrect, probeer opnieuw.");
                }
            } while (!quit);

    }

    public static int berekeningPunten(List<String> getrokkenKaarten){
        int totaalAantalPunten = 0;
        for(String kaart:getrokkenKaarten){
            String kaartPunten = kaart.substring(1);

            if(kaartPunten.equals("B") || kaartPunten.equals("V") || kaartPunten.equals("H")){
                totaalAantalPunten += 10;
            }else if (kaartPunten.equals("A")) {
                totaalAantalPunten += 11;
            } else {
                totaalAantalPunten += Integer.parseInt(kaartPunten);
            }

        }
        return totaalAantalPunten;
    }


}
