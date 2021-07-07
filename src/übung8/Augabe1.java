package übung8;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Augabe1 extends Application {

	@Override
	public void start(Stage primaryStage) {
		
	FlowPane flow1 = new FlowPane( );
	FlowPane flow2 = new FlowPane( );
	flow1.setPadding(new Insets(5, 0, 5, 0));
	flow2.setPadding(new Insets(5, 0, 0, 0));
	flow1.setPrefWrapLength(208);
	flow2.setPrefWrapLength(208);
	flow1.setStyle("-fx-background-color: #DAE6F3;");
	HBox box = new HBox(20);
	box.setAlignment(Pos.CENTER);
	
	
	//flow.setVgap(20);
	flow1.setHgap(10);
	flow2.setHgap(10);
	for(int i = 1; i <= 3; i++) {
		Button b1 = new Button("Button " + i);
		flow1.getChildren().add(b1);
		
	
	}
	for(int j = 4; j <= 6; j++ ){
		Button b2 = new Button("Button " + j);
		flow2.getChildren().add(b2);
	}
	box.getChildren().addAll(flow1, flow2);
	
	primaryStage.setScene(new Scene(box));
	primaryStage.show();
	
	}

	public static void main(String[] args) {
		launch(args);
	}
}
