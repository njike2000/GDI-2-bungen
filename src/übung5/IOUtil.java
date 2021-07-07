package util;

/**
 * Utilities für die Ein- und Ausgabe über JavaFX
 * Die Ausgaben werden in eine TextArea durchgeführt.
 * Die Eingaben funktionieren über Dialoge
 */
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class IOUtil {

	/**
	 * liest einen int-Wert ein
	 * @param txt die Eingabenaufforderung
	 * @return der eingelesene int-Wert
	 */
	public static int nextInt(String txt) {
		return nextInt(txt, Integer.MIN_VALUE, Integer.MAX_VALUE, false);
	}

	/**
	 * liest einen int-Wert aus einem Wertebereich ein
	 * @param txt die Eingabenaufforderung
	 * @param min der kleinste erlaubte Wert
	 * @param max der größte erlaubte Wert
	 * @return der eingelesene int-Wert
	 */
	public static int nextInt(String txt, int min, int max) {
		return nextInt(txt, min, max, true);
	}

	/**
	 * liest einen positiven int-Wert ein
	 * @param txt die Eingabenaufforderung
	 * @return der eingelesene int-Wert
	 */
	public static int nextPosInt(String txt) {
		return nextInt(txt, 0, Integer.MAX_VALUE, true);
	}

	private static int nextInt(String txt, int min, int max, boolean showLimits) {
		createAndShow("Eingabe von int", showLimits ? txt + "(" + min + ".." + max + ")" : txt, e -> {
			try {
				int n = Integer.parseInt(sInput = sTf.getText());
				if (n < min || n > max) {
					showError("Bitte nur Zahl zwischen " + min + " und " + max + " eingeben");
					return;
				}
				sTf.setText("");
				sSem.release();

				try {
					sDialogStage.hide();
				} catch (IllegalStateException ex) {
				}
			} catch (NumberFormatException ex) {
				showError("Bitte eine Ganzzahl, z.B. 1, -7 etc.   eingeben");
			}
		});

		return Integer.parseInt(sInput);
	}

	/**
	 * liest einen double-Wert ein
	 * @param txt die Eingabenaufforderung
	 * @return der eingelesene double-Wert
	 */
	public static double nextDouble(String txt) {
		createAndShow("Eingabe von double", txt, e -> {
			try {
				Double.parseDouble(sInput = sTf.getText());
				sTf.setText("");
				sSem.release();

				try {
					sDialogStage.hide();
				} catch (IllegalStateException ex) {
				}
			} catch (NumberFormatException ex) {
				showError("Bitte eine Gleitkommazahl, z.B. 1.0 oder 1.4E-2 eingeben");
			}
		});

		return Double.parseDouble(sInput);
	}

	/**
	 * liest einen BigDecimal-Wert ein
	 * @param txt die Eingabenaufforderung
	 * @return der eingelesene BigDecimal-Wert
	 */
	public static BigDecimal nextBigDecimal(String txt) {
		createAndShow("Eingabe von BigDecimal", txt, e -> {
			try {
				sInput = sTf.getText();
				new BigDecimal(sInput);
				sTf.setText("");
				sSem.release();
				try {
					sDialogStage.hide();
				} catch (IllegalStateException ex) {
					ex.printStackTrace();
				}
			} catch (NumberFormatException ex) {
				showError("Bitte eine Bigdecimalzahl wie z.B. 1.0 eingeben");
			}
		});

		return new BigDecimal(sInput);
	}

	/**
	 * liest eine Zeichenkette ein - Spacezeichen werden auch akzeptiert!
	 * @param txt die Eingabenaufforderung
	 * @return die eingelesene Zeichenkette - mindestens ein Zeichen!
	 */
	public static String next(String txt) {
		createAndShow("Eingabe von String", txt, e -> {
			sInput = sTf.getText();
			if (sInput == null || sInput.length() == 0) {
				showError("Text darf nicht leer sein");
				return;
			}
			sTf.setText("");
			sSem.release();
			try {
				sDialogStage.hide();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		return sInput;
	}

	/**
	 * liest ein Zeichen ein
	 * @param txt die Eingabenaufforderung
	 * @return das eingelesene Zeichen
	 */
	public static char nextChar(String txt) {
		createAndShow("Eingabe von Zeichen", txt, e -> {
			sInput = sTf.getText();
			if (sInput == null || sInput.length() == 0) {
				showError("Zeichen darf nicht leer sein");
				return;
			}
			if (sInput.length() > 1) {
				showError("Bitte nur ein Zeichen");
				return;
			}
			sTf.setText("");
			sSem.release();
			try {
				sDialogStage.hide();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		return sInput.charAt(0);
	}

	private static void showError(String txt) {
		sDialogStage.setAlwaysOnTop(false);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information");
		alert.setHeaderText("Fehlerhafte Eingabe");
		alert.setContentText(txt);
		alert.showAndWait();
	}

	// Verschiedene Ausgabenmethoden wie von System.out
	
	public static void printf(String format, Object... args) {
		print(String.format(format, args));
	}

	public static void print(byte b) {
		print(String.valueOf(b));
	}

	public static void print(short s) {
		print(String.valueOf(s));
	}

	public static void print(int i) {
		print(String.valueOf(i));
	}

	public static void print(long l) {
		print(String.valueOf(l));
	}

	public static void print(boolean b) {
		print(String.valueOf(b));
	}

	public static void print(char c) {
		print(String.valueOf(c));
	}

	public static void print(float f) {
		print(String.valueOf(f));
	}

	public static void print(double d) {
		print(String.valueOf(d));
	}

	public static void print(char[] cArray) {
		print(new String(cArray));
	}

	public static void println(byte b) {
		println(String.valueOf(b));
	}

	public static void println(short s) {
		println(String.valueOf(s));
	}

	public static void println(int i) {
		println(String.valueOf(i));
	}

	public static void println(long l) {
		println(String.valueOf(l));
	}

	public static void println(boolean b) {
		println(String.valueOf(b));
	}

	public static void println(char c) {
		println(String.valueOf(c));
	}

	public static void println(float f) {
		println(String.valueOf(f));
	}

	public static void println(double d) {
		println(String.valueOf(d));
	}

	public static void println(char[] cArray) {
		println(new String(cArray));
	}

	public static void println(Object obj) {
		println(obj.toString());
	}

	public static void print(Object obj) {
		print(obj.toString());
	}

	public static void print(String txt) {
		checkAndWait();
		Platform.runLater(() -> {
			sTextArea.appendText(txt);
			sStage.show();
		});
	}

	// Hilfsdaten für die IO-Aktivitäten
	private static Stage sStage;
	private static String sInput;
	private static Label sTitle;
	private static Label sText;
	private static TextField sTf;
	private static TextArea sTextArea;
	private static AtomicBoolean sStarted = new AtomicBoolean();
	private static Semaphore sWait = new Semaphore(0);
	private static Semaphore sSem = new Semaphore(0);
	private static Stage sDialogStage;

	private static void checkAndWait() {
		if (sStarted.compareAndSet(false, true)) {
			JavaFXUtils.forceFXUtilsReady();
			Platform.runLater(() -> {
				sStage = new Stage();
				sTextArea = new TextArea();
				sTextArea.setWrapText(true);
				Scene scene = new Scene(sTextArea, 600, 400);
				sStage.setScene(scene);
				sStage.setOnCloseRequest(e -> {
					System.exit(0);
				});
				sDialogStage = new Stage(); // remember the stage
				sDialogStage.initStyle(StageStyle.UNDECORATED); // usr can not close or
				// change the size
				VBox v = new VBox(20);
				v.setPadding(new Insets(20));
				v.getChildren().addAll(sTitle = new Label(), new Separator());
				HBox h = new HBox(20);
				h.setPadding(new Insets(20));
				h.getChildren().add(sText = new Label());
				sTf = new TextField(); // create the text field for using later
				h.getChildren().add(sTf);
				v.getChildren().add(h);
				Scene sc = new Scene(v);
				sDialogStage.setScene(sc);
				sWait.release();
			});
			try {
				sWait.acquire();
			} catch (Exception ex) {

			}
		}

	}

	public static void println(String txt) {
		checkAndWait();
		Platform.runLater(() -> {
			sTextArea.appendText(txt + "\n");
			sStage.show();
		});
	}

	private static void createAndShow(String title, String txt, EventHandler<ActionEvent> a) {
		checkAndWait();
		javafx.application.Platform.runLater(() -> {
			sTitle.setText(title);
			sText.setText(txt);
			sTf.setOnAction(a);
			sDialogStage.setAlwaysOnTop(true);
			sDialogStage.show();
		});
		try {
			sSem.acquire();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	static int sNum = 0;

	private static <T> List<String> toStringList(T[] a) {
		List<String> result = new ArrayList<>();
		for (T e : a)
			result.add(e.toString());
		return result;
	}

	/**
	 * Hilfsmethode, um eine Liste von Möglichkeiten anzuzeigen und auszuwählen
	 * @param <T>  Typ - kann auch bebiebiges Objekt sein
	 * @param txt Aufforderungstext
	 * @param menuitems Array von Möglichkeiten
	 * @return Index des ausgewählten Punktes , -1 beim Abbruch
	 */
	public static <T> int showMenu(String txt, T[] menuitems) {
		checkAndWait();
		Platform.runLater(() -> {
			final ChoiceDialog<String> dialog = new ChoiceDialog<>(menuitems[0].toString(), toStringList(menuitems));
			dialog.setTitle(txt);
			dialog.setHeaderText("");
			dialog.setContentText("Bitte einen Menüpunkt wählen");
			dialog.setGraphic(null);
			Optional<String> ret = dialog.showAndWait();
			sNum = -1;
			if (ret.isPresent()) {
				for (int i = 0; i < menuitems.length; i++) {
					if (ret.get().equals(menuitems[i].toString())) {
						sNum = i;
						break;
					}
				}
			}
			sSem.release();
		});
		try {
			sSem.acquire();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		return sNum;
	}
}
