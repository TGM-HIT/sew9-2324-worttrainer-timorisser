package trisser;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
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

    public void play(){

    }

    public void zuruecksetzen(){
        this.index = 0;
        this.richtige = 0;
        this.falsche = 0;
        this.versuche = 0;
    }

    private void randomize(){
        for(int i = 0; i < this.woerterPaare.size(); i++){
            int randomI = (int) (Math.random() * this.woerterPaare.size());
            WoerterPaar temp = this.woerterPaare.get(randomI);
            this.woerterPaare.set(randomI, this.woerterPaare.get(i));
            this.woerterPaare.set(i, temp);
        }

    }

    private Image getImage(){
        Image img = null;
        System.out.println(getPaar(this.index).getUrl());
        try {
            URL url = new URL(getPaar(this.index).getUrl());
            img = ImageIO.read(url);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        return img;
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

    public WoerterPaar getPaar(int index){
        return this.woerterPaare.get(index);
    }
}
