package calculator.viewmodel;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import calculator.model.Model;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ViewModel {

    @FXML
    Label res;

    private double n1, n2;
    private String op = "";

    @FXML
    void onClickNum(MouseEvent event) {
        int v = Integer.parseInt(((Pane)event.getSource()).getId().replace("btn", ""));

        res.setText(Double.parseDouble(res.getText())==0
                ? String.valueOf(n1 = v)
                : String.valueOf(Double.parseDouble(res.getText())*10+v));
    }

    @FXML
    void onClickOp(MouseEvent event) {
        String clickedOp = ((Pane)event.getSource()).getId().replace("btn", "");
        if (clickedOp.equals("Equals")) {
            n2 = Double.parseDouble(res.getText());

            switch (op) {
                case "+":
                    res.setText(Model.sum(n1, n2) + "");
                    break;
                case "-":
                    res.setText(Model.subtract(n1, n2) + "");
                case "*":
                    res.setText(Model.mulitply(n1, n2) + "");
                case "/":
                    try {
                        res.setText(Model.divide(n1, n2) + "");
                    } catch (Exception e) {
                        res.setText("0");
                    }
                    break;
            }

            op = ",";
        } else if (clickedOp.equals("Clear")) {
            res.setText("0");
            op = ",";
        } else {
            switch (clickedOp) {
                case "Plus" -> op = "+";
                case "Minus" -> op = "-";
                case "X" -> op = "*";
                case "Slash" -> op = "/";
            }
            n1 = Double.parseDouble(res.getText());
            res.setText("0");
        }
    }
}