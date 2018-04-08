package firfilter;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class FilterController implements Initializable{
    
    Filter filter;

    @FXML
    private Button addValue;

    @FXML
    private TextArea showArea;

    @FXML
    private IntegerTextField newValue;

    @FXML
    void addNewValue(ActionEvent event) {
        if(newValue.getText().isEmpty())
            return;
        displayData(filter.fir(newValue.getInteger()).toString());
        newValue.clear();
    }

    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }
    
    void displayData(String result){
        showArea.appendText("Result = " + result + "\n" + filter.display() + "\n\n");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        filter = new Filter();
        filter.circ_init();
    }

}
