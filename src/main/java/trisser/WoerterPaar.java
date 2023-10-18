package trisser;

public class WoerterPaar {

    private String url;
    private String wort;

    public WoerterPaar(String url, String wort) {
        this.url = url;
        this.wort = wort;
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

    public void setUrl(String url) {
        if(!url.endsWith(".png") && !url. endsWith(".jpg") && !url.endsWith(".jpeg")) {
            throw new IllegalArgumentException("URL muss ein Bild sein!");
        }
        this.url = url;
    }

    public String toString() {
        return this.wort + ";" + url;
    }

}
