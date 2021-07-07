package übung8;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

class TitledNode extends VBox {
	TitledNode(String titleString, Node content) {
	Label title = new Label(" " + titleString + " ");
	title.setStyle("-fx-font: 28px Vivaldi");
	VBox.setVgrow(content, Priority.ALWAYS);
	
	setStyle("-fx-background-color: white;-fx-border-color: blue;-fx-border-width: 5;");
	getChildren().addAll(title, content);
	}

} 

public class SimpleHTLMEditor extends Application {

	
	@Override
	public void start(Stage primaryStage) {
		TextArea area = new TextArea();
		area.setFont(Font.font("Arial", 24));
		WebView display = new WebView();
		SplitPane splitPane = new SplitPane();
		ScrollPane scrollPane = new ScrollPane(display);
		// Reaktion on key
		area.setOnKeyReleased((k) -> {
		display.getEngine().loadContent(area.getText());
		});
		scrollPane.setFitToWidth(true);
		splitPane.getItems().addAll(new TitledNode("Editor", area), new TitledNode("Display", scrollPane));
		splitPane.setDividerPositions(0.5f);
		primaryStage.setScene(new Scene(splitPane));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
	
	
