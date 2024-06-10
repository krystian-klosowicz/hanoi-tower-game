package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class JavaFxClass extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hanoi app");



        TextArea resultTextArea = new TextArea();
        resultTextArea.setEditable(false);
        resultTextArea.setMinHeight(150);
        resultTextArea.setPrefColumnCount(5);

        Hanoi hanoi = new Hanoi(5);
        resultTextArea.setText(hanoi.getHanoiText());
        // Buttony
        Button button1 = new Button("1.A to B");

        Button button2 = new Button("2.A to C");
        Button button3 = new Button("3.B to A");
        Button button4 = new Button("4.B to C");
        Button button5 = new Button("5.C to A");
        Button button6 = new Button("6.C to B");
        button1.setPrefWidth(210);
        button1.setPrefHeight(40);
        button2.setPrefWidth(210);
        button2.setPrefHeight(40);
        button3.setPrefWidth(210);
        button3.setPrefHeight(40);
        button4.setPrefWidth(210);
        button4.setPrefHeight(40);
        button5.setPrefWidth(210);
        button5.setPrefHeight(40);
        button6.setPrefWidth(210);
        button6.setPrefHeight(40);
        // Akcje dla buttonów
        button1.setOnAction(e -> {

            hanoi.moveDisk("A", "B");
            resultTextArea.setText(hanoi.getHanoiText());

        });

        button2.setOnAction(e -> {
            hanoi.moveDisk("A", "C");
            resultTextArea.setText(hanoi.getHanoiText());

        });

        button3.setOnAction(e -> {
            hanoi.moveDisk("B", "A");
            resultTextArea.setText(hanoi.getHanoiText());
        });

        button4.setOnAction(e -> {
            hanoi.moveDisk("B", "C");
            resultTextArea.setText(hanoi.getHanoiText());
        });

        button5.setOnAction(e -> {
            hanoi.moveDisk("C", "A");
            resultTextArea.setText(hanoi.getHanoiText());
        });

        button6.setOnAction(e -> {
            hanoi.moveDisk("C", "B");
            resultTextArea.setText(hanoi.getHanoiText());
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(resultTextArea, button1, button2, button3, button4, button5, button6);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}