public class Kaart {
    private final KaartKleuren kaartKleur;
    private final KaartTypen kaartType;
    private final int waarde;

    public KaartKleuren getKaartKleur() {
        return kaartKleur;
    }
    public KaartTypen getKaartType() {
        return kaartType;
    }
    public int getWaarde() {
        return waarde;
    }


    public Kaart(KaartKleuren kaartKleur, KaartTypen kaartType) {
        this.kaartKleur = kaartKleur;
        this.kaartType = kaartType;
        this.waarde = kaartType.getValue();
    }

    @Override
    public String toString() {
        String kaartKleurString = kaartKleur.toString();
        String kaartTypeString = kaartType.toString();
        return kaartKleurString.substring(0,1).toUpperCase() +
                kaartKleurString.substring(1).toLowerCase() +
                "-" +
                kaartTypeString.substring(0,1).toUpperCase() +
                kaartTypeString.substring(1).toLowerCase();
    }
}