package util;

import java.awt.Toolkit;
import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class FXUtil
{
   public static void forceNumberInput(TextField tf)
   {
      forceInput(tf, "[+-]?[0-9]*", Integer.MAX_VALUE);
   }

   public static void forceDigitInput(TextField tf)
   {
      forceInput(tf, "[0-9]*", Integer.MAX_VALUE);
   }

   public static void forceInput(TextField tf, String pattern, int maxLength)
   {
      tf.textProperty().addListener((observable, oldValue, newValue) -> {
         if ("".equals(newValue))
            return;

         if (!newValue.matches(pattern) || newValue.length() > maxLength)
         {
            Toolkit.getDefaultToolkit().beep();
            tf.setText(oldValue);
         }
      });
   }

   public static void zeigeInfo(String headerText, String content)
   {
      zeige(headerText, content, AlertType.INFORMATION);
   }

   /**
    * Hilfsmethode, um die FXML-Datei einzulesen und die Bühne aufzubauen
    * Wichtige Voraussetzung: Die FMXL-Datei heißt bis auf die Endung genau so
    * wie die Application-Klasse und sie liegt in dem selben Ordner
    * 
    * @param app
    *           Die JavaFX-Application
    * @param stage
    *           Die Bühne
    * @return Der eingesetzte Inhalt als Parent (Basisklasse von Pane)
    */
   public static Parent start(Application app, Stage stage)
   {
      return start(app, stage, app.getClass().getSimpleName() + ".fxml");
   }

   /**
    * Hilfsmethode, um die FXML-Datei einzulesen und die Bühne aufzubauen. Die
    * FXMLDatei muss im selben Ordner liegen wie die Application
    * 
    * @param app
    *           Die JavaFX-Application
    * @param stage
    *           Die Bühne
    * @param fxmlDatei
    *           Name der FXML-Datei
    * @return Der eingesetzte Inhalt als Parent (Basisklasse von Pane)
    */
   public static Parent start(Application app, Stage stage, String fxmlDatei)
   {
      return start(app, stage, fxmlDatei, null);
   }

   /**
    * Hilfsmethode, um die FXML-Datei einzulesen und die Bühne aufzubauen. Die
    * FXMLDatei muss im selben Ordner liegen wie die Application. Der Controller
    * wird in diesem Fall explizit angegeben. WICHTIG: In der FXML-Datei darf
    * kein Kontroller eingetragen werden
    * 
    * @param app
    *           Die JavaFX-Application
    * @param stage
    *           Die Bühne
    * @param fxmlDatei
    *           Name der FXML-Datei
    * @return Der eingesetzte Inhalt als Parent (Basisklasse von Pane)
    * @param controller
    *           Ein expliziter Controller
    * @return Der eingesetzte Inhalt als Parent (Basisklasse von Pane)
    */
   public static Parent start(Application app, Stage stage, String fxmlDatei,
         Object controller)
   {
      try
      {
         Class<?> c = app.getClass();
         FXMLLoader loader = new FXMLLoader(c.getResource(fxmlDatei));
         if (controller != null)
            loader.setController(controller);
         Parent p = (Parent) loader.load();
         Scene s = new Scene(p);
         stage.setScene(s);
         stage.show();
         return p;
      } catch (Exception ex)
      {
         ex.printStackTrace();
         System.exit(1);
      }
      return null; // kann nie passieren!! muss hier stehen, sonst
                   // Kompilierfehler
   }

   public static void zeigeError(String headerText, String content)
   {
      zeige(headerText, content, AlertType.ERROR);
   }

   private static void zeige(String headerText, String content, AlertType type)
   {
      Alert a = new Alert(type);
      a.setHeaderText(headerText);
      a.setContentText(content);
      a.show();
   }

   public static File auswahlOeffnen(Stage s, String dir,
         ExtensionFilter filter)
   {
      return dateiAuswahl(s, dir, filter, false);
   }

   public static File auswahlSpeichern(Stage s, String dir,
         ExtensionFilter filter)
   {
      return dateiAuswahl(s, dir, filter, true);
   }

   public static File dateiAuswahl(Stage s, String dir, ExtensionFilter filter,
         boolean speichern)
   {
      // Objekt zum wählen von Datei
      FileChooser f = new FileChooser();
      f.getExtensionFilters().add(filter);
      // Wo soll gestartet werden?
      f.setInitialDirectory(new File(dir));
      // Dateiauswahl
      if (speichern)
         return f.showSaveDialog(s);
      return f.showOpenDialog(s);
   }
}
