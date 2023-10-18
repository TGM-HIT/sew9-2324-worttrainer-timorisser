package trisser;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class WoerterPaar {

    private String url;
    private String wort;

    public WoerterPaar(String url, String wort) throws IOException {
        setUrl(url);
        setWort(wort);
    }

    public String getWort() {
        return wort;
    }

    public void setWort(String wort) {
        this.wort = wort;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) throws IllegalArgumentException, IOException {

        Image image = ImageIO.read(new URL(url));
        if(image != null){
            this.url = url;
        }else{
            throw new IllegalArgumentException("URL is not an image!");
        }
    }

    public String toString() {
        return this.wort + ";" + url;
    }

}
