package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField valueOfFloat;
    @FXML
    private Label calculated;
    private double total = 0;

    @FXML
    private Label overUnder;
    @FXML
    private Label overUnderAmount;

    @FXML
    private TextField val5C;
    @FXML
    private TextField val10C;
    @FXML
    private TextField val20C;
    @FXML
    private TextField val50C;
    @FXML
    private TextField valR1;
    @FXML
    private TextField valR2;
    @FXML
    private TextField valR5;
    @FXML
    private TextField valR10;
    @FXML
    private TextField valR20;
    @FXML
    private TextField valR50;
    @FXML
    private TextField valR100;
    @FXML
    private TextField valR200;

    @FXML
    public void onButtonClicked(ActionEvent event) {
        total = (0.05 * setIntValue(val5C)) + (0.1 * setIntValue(val10C)) + (0.2 * setIntValue(val20C))
                + (0.5 * setIntValue(val50C))+ setIntValue(valR1) + (2 * setIntValue(valR2))
                + (5 * setIntValue(valR5)) + (10 * setIntValue(valR10)) + (20 *setIntValue(valR20))
                + (50 * setIntValue(valR50)) + (100 * setIntValue(valR100)) + (200 * setIntValue(valR200));

        calculated.setText("R" + String.valueOf(total));

        if (total > setIntValue(valueOfFloat)){
            overUnder.setText("Over by:");
            overUnderAmount.setText("R" + String.valueOf(total - setIntValue(valueOfFloat)));
        } else if (total < setIntValue(valueOfFloat)){
            overUnder.setText("Under by:");
            overUnderAmount.setText("R" + String.valueOf(setIntValue(valueOfFloat) - total));
        }
    }

    private int setIntValue(TextField value) {
        try{
            return Integer.parseInt(value.getText());
        } catch (Exception e) {
            return 0;
        }
    }

}
