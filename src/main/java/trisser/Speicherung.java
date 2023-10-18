package trisser;

import java.io.IOException;

public interface Speicherung {

    void saveContent(String filePath, WortTrainer wordTrainer) throws IOException;
    WortTrainer loadContent(String filePath, WortTrainer wordTrainer);

}
