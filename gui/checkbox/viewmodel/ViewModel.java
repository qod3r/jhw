package checkbox.viewmodel;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;

public class ViewModel {
    @FXML
    CheckBox cb1, cb2, cb3;

    @FXML
    Hyperlink hl;

    @FXML
    Label l;

    @FXML
    ProgressBar pb;

    public void onClick(MouseEvent event) {
        if (event.getSource() == cb1) {
            hl.setVisible(cb1.isSelected());
        } else if (event.getSource() == cb2) {
            l.setVisible(cb2.isSelected());
        } else if (event.getSource() == cb3) {
            pb.setVisible(cb3.isSelected());
        }
    }
}
