package fashionPOS.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class userController {
    @FXML
    private VBox child;
    @FXML
    private ComboBox role;
    @FXML
    private PasswordField password;
    @FXML
    private TextField name;
    @FXML
    private TextField id;
    @FXML
    private TextField username;
    @FXML
    private Button add;
    @FXML
    private Button update;
    @FXML
    private Button delete;
    @FXML
    private TableColumn colId;
    @FXML
    private TableColumn colUsername;
    @FXML
    private TableColumn colPassword;
    @FXML
    private TableColumn colName;
    @FXML
    private TableColumn colRole;

    @FXML
    private void add(ActionEvent actionEvent) {
    }

    @FXML
    private void update(ActionEvent actionEvent) {
    }

    @FXML
    private void delete(ActionEvent actionEvent) {
    }
}
