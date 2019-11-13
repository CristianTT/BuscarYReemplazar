package dam.dad;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BuscarYReemplazarApp extends Application {
	
	private TextField buscarText, reemplazarText;
	private CheckBox mayusMinusCheck, haciaAtrasCheck, expresionRegularCheck, resaltarCheck;
	private Button buscarButton, reemplazarButton, reemplazarTodoButton, cerraButton, ayudaButton;

	@Override
	public void start(Stage primaryStage) throws Exception {

		mayusMinusCheck = new CheckBox("Mayúsculas y Minúsculas");
		haciaAtrasCheck = new CheckBox("Buscar hacia atrás");
		expresionRegularCheck = new CheckBox("Expresión regular");
		resaltarCheck = new CheckBox("Resaltar resultados");
		
		GridPane checkboxsPane = new GridPane();
		checkboxsPane.addRow(0, mayusMinusCheck, haciaAtrasCheck);
		checkboxsPane.addRow(1, expresionRegularCheck, resaltarCheck);
		
		ColumnConstraints[] colsCheckboxs = {
				new ColumnConstraints(),
				new ColumnConstraints()
			};
		checkboxsPane.getColumnConstraints().setAll(colsCheckboxs);
		colsCheckboxs[0].setPercentWidth(50);
		colsCheckboxs[1].setPercentWidth(50);
		
		buscarText = new TextField();
		reemplazarText = new TextField();
		
		GridPane gridCentral = new GridPane();
		gridCentral.addRow(0, new Label("Buscar:"), buscarText);
		gridCentral.addRow(1, new Label("Reemplazar con:"), reemplazarText);
		gridCentral.add(checkboxsPane, 1, 2);
		gridCentral.setHgap(10);
		gridCentral.setVgap(7);
		gridCentral.setPadding(new Insets(15));
		
		ColumnConstraints[] colsCentral = {
			new ColumnConstraints(),
			new ColumnConstraints()
		};
		gridCentral.getColumnConstraints().setAll(colsCentral);
		colsCentral[1].setHgrow(Priority.ALWAYS);

		buscarButton = new Button("Buscar");
		buscarButton.setPrefWidth(120);
		reemplazarButton = new Button("Reemplazar");
		reemplazarButton.setPrefWidth(120);
		reemplazarTodoButton = new Button("Reemplazar Todo");
		reemplazarTodoButton.setPrefWidth(120);
		cerraButton = new Button("Cerrar");
		cerraButton.setPrefWidth(120);
		ayudaButton = new Button("Ayuda");
		ayudaButton.setPrefWidth(120);
		
		VBox botonesPane = new VBox(5, buscarButton, reemplazarButton, reemplazarTodoButton, cerraButton, ayudaButton);
		botonesPane.setPadding(new Insets(15, 15, 15, 0));
		
		BorderPane root = new BorderPane();
		root.setCenter(gridCentral);
		root.setRight(botonesPane);
		
		Scene scene = new Scene(root, 720, 230);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Buscar y Reemplazar");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
