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
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class LineChartUtil {
  private static final int DEFAULT_HEIGHT = 600;
  private static final int DEFAULT_WIDTH = 800;
  private String titel;
  private String xLabel;
  private String yLabel;
  private List<? extends Number>[] x;
  private List<? extends Number>[] y;

  /**
   * constructor
   * 
   * @param titel titel of the bar chart
   * @param xLabel label of the x-axis
   * @param yLabel label of the y-axis
   * @param x list of x numbers
   * @param y list of the corresponding numbers
   */
  private LineChartUtil(String titel, String xLabel, String yLabel, List<? extends Number>[] x,
      List<? extends Number>[] y) {
    this.titel = titel;
    this.xLabel = xLabel;
    this.yLabel = yLabel;
    this.x = x;
    this.y = y;
  }

  public void start(Stage stage) {
    stage.setTitle("Bar Chart");
    final NumberAxis xAxis = new NumberAxis();
    final NumberAxis yAxis = new NumberAxis();
    xAxis.setForceZeroInRange(false);
    yAxis.setForceZeroInRange(false);
    final LineChart<Number, Number> bc = new LineChart<>(xAxis, yAxis);
    bc.setTitle(titel);
    xAxis.setLabel(xLabel);
    yAxis.setLabel(yLabel);

    for (int i = 0; i < x.length; i++) {
      XYChart.Series<Number, Number> series = new XYChart.Series<>();

      for (int j = 0; j < x[i].size(); j++) {
        series.getData().add(new XYChart.Data<>(x[i].get(j), y[i].get(j)));

      }
      bc.getData().add(series);
    }
    Scene scene = new Scene(bc, DEFAULT_WIDTH, DEFAULT_HEIGHT);

    stage.setScene(scene);
    stage.show();
  }

  public static void show(String titel, String xLabel, String yLabel, List<? extends Number>[] x,
      List<? extends Number>[] y) {
    JavaFXUtils.forceFXUtilsReady();
    Platform.runLater(() -> {
      new LineChartUtil(titel, xLabel, yLabel, x, y).start(new Stage());
    });
  }

  @SuppressWarnings("unchecked")
  public static void show(String titel, String xLabel, String yLabel, List<? extends Number> x,
      List<? extends Number> y) {
    show(titel, xLabel, yLabel, new List[] { x }, new List[] { y });
  }
}
