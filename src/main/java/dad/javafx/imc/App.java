package dad.javafx.imc;

import javafx.application.Application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
	private TextField pesoText, alturaText; // caja para escribir
	private Label frontpLabel, backpLabel, frontaLabel, backaLabel, ImcLabel, IMCLiteralLabel, ImcValueLabel;
	private IMC imc;

	public void start(Stage stage) {
		imc = new IMC();
		frontpLabel = new Label();
		frontpLabel.setText("Peso:");
		frontpLabel.setAlignment(Pos.CENTER_LEFT);
		
		pesoText = new TextField("0");
		pesoText.setPrefColumnCount(4);
		pesoText.setText("");	//Introduce aqui el peso	

		backpLabel = new Label();
		backpLabel.setText("kg");
		backpLabel.setAlignment(Pos.CENTER_RIGHT);
		
		HBox hboxPeso = new HBox();
		hboxPeso.setAlignment(Pos.BASELINE_CENTER);
		hboxPeso.setSpacing(5);
		hboxPeso.getChildren().addAll(frontpLabel, pesoText, backpLabel);
		
		frontaLabel = new Label();
		frontaLabel.setText("Altura:");
		frontaLabel.setAlignment(Pos.CENTER_LEFT);
		
		alturaText = new TextField("0");
		alturaText.setPrefColumnCount(4);
		alturaText.setText("");	//Introduce aqui la altura	

		backaLabel = new Label();
		backaLabel.setAlignment(Pos.CENTER_RIGHT);
		backaLabel.setText("cm");

		HBox hboxAltura = new HBox();
		hboxAltura.setAlignment(Pos.BASELINE_CENTER);
		hboxAltura.setSpacing(5);
		hboxAltura.getChildren().addAll(frontaLabel, alturaText, backaLabel);

		ImcLabel = new Label();
		ImcLabel.setText("IMC:");
		ImcLabel.setAlignment(Pos.CENTER_LEFT);
		
		IMCLiteralLabel = new Label();
		
		
		ImcValueLabel = new Label();
		ImcValueLabel.setAlignment(Pos.CENTER_RIGHT);
		
		// HBOX IMC
		HBox hboxIMC = new HBox();
		hboxIMC.setAlignment(Pos.BASELINE_CENTER);
		hboxIMC.setSpacing(5);
		hboxIMC.getChildren().addAll(ImcLabel, ImcValueLabel);
		
		
		
		HBox hboxpesos = new HBox();
		hboxpesos.setAlignment(Pos.BASELINE_CENTER);
		hboxpesos.setSpacing(5);
		hboxpesos.getChildren().add(IMCLiteralLabel);
		
		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(hboxPeso, hboxAltura, hboxIMC, hboxpesos);

		Scene scene = new Scene(root, 320, 200);
		stage.setTitle("IMC.fxml");
		stage.setScene(scene);
		stage.show();

		pesoText.textProperty().addListener((obs, oldText, newText) -> {
			imc.setPeso(Double.parseDouble(newText.toString()));

		});

		alturaText.textProperty().addListener((obs, oldText, newText) -> {
			imc.setAltura(Double.parseDouble(newText.toString()));

		});
		ImcValueLabel.textProperty().bind(imc.imcProperty().asString());
		IMCLiteralLabel.textProperty().bind(imc.imcliteralProperty());

	}

	public static void main(String args[]) {
		launch(args);
	}
}