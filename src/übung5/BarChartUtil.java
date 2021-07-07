package util;

/**
 * Utility to dislay bar chart from a non GUI application
 * x-axis must be from type String and y-axis from type Number
 * @author tran
 * @version 1.0
 */
import java.util.List;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class BarChartUtil {

	private static final int DEFAULT_HEIGHT = 600;
	private static final int DEFAULT_WIDTH = 800;

	@SafeVarargs
	private static void display(String titel, String xLabel, String yLabel, List<String> x,
	      List<? extends Number>... allY) {
		Stage stage = new Stage();
		stage.setTitle("Bar Chart");
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String, Number> bc = new BarChart<>(xAxis, yAxis);
		bc.setTitle(titel);
		xAxis.setLabel(xLabel);
		yAxis.setLabel(yLabel);

		for (List<? extends Number> y : allY) {
			XYChart.Series<String, Number> series = new XYChart.Series<>();
			for (int i = 0; i < x.size(); i++)
				series.getData().add(new XYChart.Data<>(x.get(i), y.get(i)));
			bc.getData().add(series);
		}
		Scene scene = new Scene(bc, DEFAULT_WIDTH, DEFAULT_HEIGHT);

		stage.setScene(scene);
		stage.show();
	}

	/**
	 * zeigt einen Bar-Chart
	 * 
	 * @param titel  Titel des Charts
	 * @param xLabel Beschriftung der x-Achse
	 * @param yLabel Beschriftung der y-Achse
	 * @param x      Liste von Namen
	 * @param y      Liste von korrespondierenden Werten
	 */
	@SafeVarargs
	public static void show(String titel, String xLabel, String yLabel, List<String> x, List<? extends Number>... y) {
		JavaFXUtils.forceFXUtilsReady();
		Platform.runLater(() -> {
			display(titel, xLabel, yLabel, x, y);
		});
	}
}
