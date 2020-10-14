package dad.javafx.imc;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class IMCApp extends Application {
	private Label pesoLabel;
	private TextField pesoText;
	private Label kilo;
	private Label alturaLabel;
	private TextField alturaText;
	private Label cmLabel;
	private Label imcLabel;
	private Label imcnLabel;
	private Label resLabel;
	private DoubleProperty p = new SimpleDoubleProperty(0);
	private DoubleProperty a = new SimpleDoubleProperty(0);

	
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		pesoLabel = new Label("Peso:  ");
		
		pesoText = new TextField();
		pesoText.setMaxWidth(50);
		
		kilo = new Label("kg");
		
		alturaLabel = new Label("Altura: ");
		
		alturaText = new TextField();
		alturaText.setMaxWidth(50);		
		
		cmLabel = new Label("cm");
		
		imcLabel = new Label("IMC:");
		
		//Bindings
		Bindings.bindBidirectional(alturaText.textProperty(), a, new NumberStringConverter());
		Bindings.bindBidirectional(pesoText.textProperty(), p, new NumberStringConverter());

		Bindings.bindBidirectional(resLabel.textProperty(), a, new NumberStringConverter());
		
		//Pasar lo introducido a metros
		DoubleBinding alturaM = a.divide(100);
		
		//Altura al cuadrado
		DoubleBinding alturaCuadrado = alturaM.multiply(alturaM);
		
		//Operación
		DoubleBinding op = p.divide(alturaCuadrado);
		
		//resultado.bind(op);
		//resLabel.textProperty().bind(resultado.asString("%.2f"));

		
		
		HBox uno = new HBox();
		uno.setSpacing(5);
		uno.setAlignment(Pos.CENTER);
		uno.getChildren().addAll(pesoLabel, pesoText, kilo);
		
		
		HBox dos = new HBox();
		dos.setSpacing(5);
		dos.setAlignment(Pos.CENTER);
		dos.getChildren().addAll(alturaLabel, alturaText, cmLabel);
		
		
		HBox tres = new HBox();
		tres.setSpacing(5);
		tres.setAlignment(Pos.CENTER);
		tres.getChildren().addAll(imcLabel, imcnLabel);
		
		
		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(uno, dos, tres, resLabel);
		
		Scene scene = new Scene(root, 320, 200);
		
		primaryStage.setTitle("IMC");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);

	}

}
