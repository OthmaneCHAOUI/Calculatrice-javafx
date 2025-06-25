package main;

import java.util.*;
import javafx.application.*;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.geometry.*;

public class Main extends Application{
    Label display_label;
    String display_output = "";
    String num_before_op = "";
    String num_after_op = "";
    ArrayList<String> inputs = new ArrayList<String>();

    @Override
    public void start(Stage myStage){
        display_label = new Label("0");

        // node racine
        GridPane grid = new GridPane(10, 10);
        grid.setAlignment(Pos.CENTER);
        grid.add(display_label, 0, 0, 4, 1);
        
        // gestion des boutons
        Button cbtn = new Button("C");
        cbtn.setMinSize(225, 40);
        cbtn.setOnAction(event -> hundlerButtonClick(cbtn.getText()));
        cbtn.getStyleClass().add("c_button");
        grid.add(cbtn, 0, 1, 4, 1);

        String[] str_buttons = {"1", "2", "3", "x", "4", "5", "6", "/", "7", "8", "9", "-", "0", ".", "=", "+"};
        int i = 0;
        for (int ligne = 0; ligne < 4; ligne++) {
            for (int col = 0; col < 4; col++) {
                Button btn = new Button(str_buttons[i]);
                btn.setMinSize(50, 50);
                btn.setOnAction(event -> hundlerButtonClick(btn.getText()));
                if (isOperator(btn.getText())){
                    btn.getStyleClass().add("op_button");
                }
                else if (btn.getText().equals("=")){
                    btn.getStyleClass().add("equal_button");
                }
                else{
                    btn.getStyleClass().add("number_button");
                }
                grid.add(btn, col, ligne+2);
                
                i++;
            }
        }

        // titre fenetre
        myStage.setTitle("Calculatrice");
        // definition Scene
        Scene myScene = new Scene(grid);
        // css style
        myScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        // mettre scene dans stage
        myStage.setScene(myScene);
        // display_label stage
        myStage.show();
    }

    public void hundlerButtonClick(String s){
        if(s.equals("=")){
            num_after_op = display_output.substring(num_before_op.length() + 1, display_output.length());
            inputs.add(num_after_op);
            double res = calculate(Double.valueOf(inputs.get(0)), Double.valueOf(inputs.get(2)), inputs.get(1));
            display_label.setText(Double.toString(res));
            display_output = "";
            inputs.clear();
        }
        else if(s.equals("C")){
            inputs.clear();
            display_label.setText("0");
            display_output = "";
        }
        else if (isNumber(s) || s.equals(".")) {
            display_output += s;
            display_label.setText(display_output);
        }
        else{
            num_before_op = display_output;
            inputs.add(display_output);
            display_output += s;
            inputs.add(s);
            display_label.setText(display_output);
        }
    }

    public double calculate(double x, double y, String op){
        double res = 0;
        switch(op){
            case "+":
                res = x + y;
                break;
            case "-":
                res = x - y;
                break;
            case "x":
                res = x * y;
                break;
            case "/":
                res = x / y;
                break;
        }

        return res;
    }

    public boolean isNumber(String str) {
        boolean b = false;
        for (int i=0; i<10; i++){
            if (str.equals(Integer.toString(i))){
                b = true;
            }
        }

        return b;
    }

    public boolean isOperator(String op){
        return op.equals("+") || op.equals("/") || op.equals("x") || op.equals("-");
    }

    public static void main(String[] args) {
        // message preparation fenetre
        System.out.println("lanching application...");
        // lancer fenetre
        launch(args);
    }
}