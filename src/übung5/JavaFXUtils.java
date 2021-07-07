package util;
/**
 * Utility zum Starten des JavaFX-Threads
 * <b>Wichtig:</b> Wenn der JavaFX-Thread durch das Schließen der letzten Bühne beendet werden soll,
 * dann soll nur JavaFXUtils.forceFXUtilsReady aufgerufen werden.
 * Wenn mehrere Aktivitäten mit JavaFX gemacht werden (ständiges Öffnen und Schließen  von Dialogen
 * dann soll am Anfang
 * JavaFXUtils.startSticky() - damit JavaFX-Thread nicht implizit runtergefahren wird, wenn
 * keine Bühne sichtbar ist. Das Problem bei JavaFX ist, das er nur einmal gestartet werden darf
 * und am Ende
 * JavaFXUtils.end() aufgerufen werden
 */
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class JavaFXUtils extends Application {
	// Für die Synchronisation
	private static Semaphore sSem = new Semaphore(0);
	private static AtomicBoolean sStarted = new AtomicBoolean(false);
	
	// Wird gestartet, beim Laden der Klasse - Das Ende ist ungewiss
	static {
		new Thread(() -> launch(JavaFXUtils.class)).start();
	}
	
	
	@Override
	public void start(Stage primaryStage) {
		sSem.release();  // Erst hier wird signalisiert, dass JavaFX-Thread steht
	}
	

	public static void forceFXUtilsReady() {
		// Überprüft, ob die Methode zum ersten Mal aufgerufen wird
		// Danach wird threadsicher die Variable auf true gesetzt
		if (sStarted.compareAndSet(false, true)) {
			try {
				sSem.acquire();  // stellt damit sicher, dass JavaFX-Thread gestartet wurde
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Start JavaFX-Thread und konfiguriert so, dass der JavaFX-Thread noch existiert, auch wenn
	 * die letzte Bühne geschlossen wurde
	 */
	public static void startSticky() {
		forceFXUtilsReady();
		Platform.setImplicitExit(false);
	}

	/**
	 * Zwingt die Beendigung des JavaFX-Threads
	 */
	public static void end() {
		Platform.exit();
	}
}
