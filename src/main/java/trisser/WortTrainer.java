package trisser;

import javax.imageio.ImageIO;
import javax.swing.*;
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
        if(index >= this.woerterPaare.size()) this.zuruecksetzen();
        if(index == 0) randomize();
        while(index < this.woerterPaare.size()){
            Image img = getImage();

            String res = (String) JOptionPane.showInputDialog(null, "Was ist das Wort?", "Wort Trainer", JOptionPane.QUESTION_MESSAGE, new ImageIcon(img), null, null);
            if(res.isEmpty()){
                // TODO save();
                return;
            }
            boolean guessed = res.equalsIgnoreCase(getPaar(this.index).getWort());
            if(guessed){
                this.richtige++;
                this.index++;
            } else {
                this.falsche++;
            }
            this.versuche++;
            JOptionPane.showMessageDialog(null, (guessed ? "Richtig!" : "Falsch!") + "\nVersuche: " + versuche + "\nRichtig: " + richtige + "\nFalsch: " + falsche);
            if(guessed) this.versuche = 0;
            //TODO this.save();
        }
        zuruecksetzen();
        //TODO this.save();
    }

    public void zuruecksetzen(){
        this.index = 0;
        this.richtige = 0;
        this.falsche = 0;
        this.versuche = 0;
        randomize();
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

    public void load(){
        WortTrainer geladen = this.speicherung.loadContent(this.pfad, this);
        if(geladen != null){
            this.woerterPaare = geladen.getWoerterPaare();
            this.index = geladen.getIndex();
            this.richtige = geladen.getRichtige();
            this.falsche = geladen.getFalsche();
            this.versuche = geladen.getVersuche();
        }
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
