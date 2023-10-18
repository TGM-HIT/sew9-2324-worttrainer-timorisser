package trisser;

import java.util.ArrayList;

public class WortTrainer {

    public static void main(String[] args) {
        //TODO
    }

    private ArrayList<WoerterPaar> woerterPaare;
    private Speicherung speicherung;
    private int index;
    private int richtige;
    private int falsche;
    private int versuche;
    private String pfad;

    public WortTrainer(String pfad){
        this.pfad = pfad;
        this.speicherung = new JSONSave();
        this.woerterPaare = new ArrayList<WoerterPaar>();
        this.index = 0;
        this.richtige = 0;
        this.falsche = 0;
        this.versuche = 0;
    }

    public void zuruecksetzen(){
        this.index = 0;
        this.richtige = 0;
        this.falsche = 0;
        this.versuche = 0;
    }


    public ArrayList<WoerterPaar> getWoerterPaare() {
        return woerterPaare;
    }

    public void setWoerterPaare(ArrayList<WoerterPaar> woerterPaare) {
        this.woerterPaare = woerterPaare;
    }

    public Speicherung getSpeicherung() {
        return speicherung;
    }

    public void setSpeicherung(Speicherung speicherung) {
        this.speicherung = speicherung;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getRichtige() {
        return richtige;
    }

    public void setRichtige(int richtige) {
        this.richtige = richtige;
    }

    public int getFalsche() {
        return falsche;
    }

    public void setFalsche(int falsche) {
        this.falsche = falsche;
    }

    public int getVersuche() {
        return versuche;
    }

    public void setVersuche(int versuche) {
        this.versuche = versuche;
    }

    public String getPfad() {
        return pfad;
    }

    public void setPfad(String pfad) {
        this.pfad = pfad;
    }

    public void hinzu(WoerterPaar woerterPaar){
        this.woerterPaare.add(woerterPaar);
    }
}
