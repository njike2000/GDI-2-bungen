package util;

/**
 * Einfache Erweiterung für eine Bühne (Stage) mit einem Leinwand (Canvas).
 * Objekte dieser Klasse bieten einfache draw-Methode.
 * Das Koordinatensystem ist das gewöhnliche 
 */
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Semaphore;

import javax.imageio.ImageIO;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class DrawSurface {
	private DrawSurfaceImpl surfaceImpl;
	private static Semaphore sSem = new Semaphore(0);
	public DrawSurface(int w, int h, String title) {
		JavaFXUtils.forceFXUtilsReady();
		
		Platform.runLater(() -> {
			surfaceImpl = DrawSurfaceImpl.create(w, h, title);
			surfaceImpl.show();
			sSem.release();
		});
		try {
			sSem.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void changeOrigin(double x, double y) {
		Platform.runLater(() -> {
			surfaceImpl.changeOrigin(x,y);
		});
	}
	public void setScale(double s) {
		Platform.runLater(() -> {
			surfaceImpl.setScale(s);
		});
	}

	public void setColor(Color c) {
		Platform.runLater(() -> {
			surfaceImpl.setColor(c);
		});
	}

	public void drawLine(double x1, double y1, double x2, double y2) {
		Platform.runLater(() -> {
			surfaceImpl.drawLine(x1, y1, x2, y2);
		});
	}

	public void saveAsPng(File f) {
		Platform.runLater(() -> {
			surfaceImpl.saveAsPng(f);
		});
	}

	static class DrawSurfaceImpl extends Stage {

		private GraphicsContext gc;
		private Canvas canvas;

		/**
		 * Erzeugt eine Oberfläche zum Zeichnen
		 * 
		 * @param w     Breite
		 * @param h     Höhe
		 * @param title Titel der Oberfläche
		 * @return eine Bühne (noch im hide-Zustand)
		 */
		static DrawSurfaceImpl create(int w, int h, String title) {
			DrawSurfaceImpl s = new DrawSurfaceImpl(w, h, title);
			return s;
		}

		// ctor
		private DrawSurfaceImpl(int w, int h, String title) {
			super();
			canvas = new Canvas(w, h);
			setScene(new Scene(new HBox(canvas)));
			setTitle(title);
			gc = canvas.getGraphicsContext2D();
			changeOrigin(w / 2, h / 2);
			gc.scale(1, -1);
		}

		public int getW() {
			return (int) canvas.getWidth();
		}

		public int getH() {
			return (int) canvas.getHeight();
		}

		public Paint getColor() {
			return gc.getStroke();
		}

		void setColor(Color c) {
			gc.setStroke(c);
		}

		void setScale(double s) {
			gc.scale(s, -s);
		}

		void changeOrigin(double x, double y) {
			gc.translate(x, y);
		}

		void drawLine(double x1, double y1, double x2, double y2) {
			gc.strokeLine(x1, y1, x2, y2);
		}

		/**
		 * Speichern das Bild in eine png-Datei
		 * 
		 * @param file
		 */
		void saveAsPng(File file) {
			if (file == null)
				return;
			WritableImage wimg = new WritableImage(getW(), getH());
			canvas.snapshot(null, wimg);
			RenderedImage r = SwingFXUtils.fromFXImage(wimg, null);
			try {
				ImageIO.write(r, "png", file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}