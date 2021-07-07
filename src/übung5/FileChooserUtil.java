package util;

/**
 * Utility to start a file chooser from a non GUI application
 * @author tran
 * @version 1.0
 */
import java.io.File;
import java.util.concurrent.Semaphore;

import javafx.application.Platform;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class FileChooserUtil {

  private File file;
  private Semaphore sem = new Semaphore(0);
  private String desc;
  private String extension;
  private boolean saveDialog;

  /**
   * Ctor - Merken die notwendigen Daten für den späteren Start
   * 
   * @param desc Beschreibung der zu filternden Dateien (e.g. "text")
   * @param extension Datei-Ausdruck (e.g. "*.txt")
   */
  private FileChooserUtil(String desc, String extension, boolean saveDialog) {
    this.desc = desc;
    this.extension = extension;
    this.saveDialog = saveDialog;
  }

  public void start(Stage stage) {
    final FileChooser fileChooser = new FileChooser();
    fileChooser.setInitialDirectory(new File(".")); // wir starten im aktuellen Ordner
    // File-Filter installieren
    fileChooser.getExtensionFilters().add(new ExtensionFilter(desc, extension)); 
    if (saveDialog)
      file = fileChooser.showSaveDialog(stage);
    else
      file = fileChooser.showOpenDialog(stage); 
    sem.release(); // Signal das Ende des Vorgangs
  }

  /**
   * Hilfsmethode, um einen FX-FileChooser von einer NonGUI-Anwendung zu starten
   * @param desc Beschreibung der zu öffnenden Dateien
   * @param extension Beschreibung der Dateiendungen wie z.B. "*.java", "*,txt" usw.
   * @param shutdown true => JavaFX-Thread wird runtergefahren, kann später nicht mehr
   * gestartet werden, false => JavaFX-Thread bleibt bestehen, muss später ggf. noch
   * beendet werden 
   * @return Das zu wählende File-Objekt (null falls es abgebrochen wurde)
   */
  public static File showOpenDialog(String desc, String extension, boolean shutdown) {
    return showDialog(desc, extension, false, shutdown);
  }

  /**
   * Hilfsmethode, um einen abspeichernden FX-FileChooser von einer NonGUI-Anwendung zu starten
   * @param desc Beschreibung der zu öffnenden Dateien
   * @param extension Beschreibung der Dateiendungen wie z.B. "*.java", "*,txt" usw.
   * @param shutdown true => JavaFX-Thread wird runtergefahren, kann später nicht mehr
   * gestartet werden, false => JavaFX-Thread bleibt bestehen, muss später ggf. noch
   * beendet werden 
   * @return Das zu wählende File-Objekt (null falls es abgebrochen wurde)
   */
  public static File showSaveDialog(String desc, String extension, boolean shutdown) {
    return showDialog(desc, extension, true, shutdown);
  }

 
  private static File showDialog(String desc, String extension, boolean saveDialog, boolean shutdown) {
	  // zwingen, dass der JavaFX-Thread gestartet wird
	  JavaFXUtils.forceFXUtilsReady();
	  // Obj für den späteren Start erzeugen
    final FileChooserUtil f = new FileChooserUtil(desc, extension, saveDialog);
    // Wir senden eine Nachricht in den JavaFX-Thread, um ein File-Objekt zu bekommen
    Platform.runLater(() -> {
      f.start(new Stage()); // start den FileChooser
      if (shutdown) { // JavaFX-thread nicht mehr benötigt => runterfahren
        JavaFXUtils.end();
      }
    });
    // Ab hier ist der FileChooser noch nicht fertig!! Daher muss man warten!!
    try {
      f.sem.acquire(); // Warte bis der FileChooser beendet ist
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    return f.file; // und gibt das Ergebnis zurück
  }
}
