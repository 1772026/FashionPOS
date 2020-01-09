package fashionPOS.Controller;
/**
 * Created By Steven
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class MainController {

    @FXML
    private HBox root;
    @FXML
    private TextField txtid;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPriceSell;
    @FXML
    private TextField txtPriceBuy;
    @FXML
    private ComboBox comboCategory;
    @FXML
    private Button save;
    @FXML
    private Button reset;
    @FXML
    private Button update;
    @FXML
    private Button delete;
    @FXML
    private Button editStock;
    @FXML
    private TextArea txtDescription;
    @FXML
    private TableView tableItem;
    @FXML
    private TableColumn colID;
    @FXML
    private TableColumn colName;
    @FXML
    private TableColumn colCategory;
    @FXML
    private TableColumn colPriceSell;
    @FXML
    private TableColumn colPriceBuy;

    @FXML
    private void categoryClick(MouseEvent mouseEvent) {
    }

    @FXML
    private void save(ActionEvent actionEvent) {
    }

    @FXML
    private void reset(ActionEvent actionEvent) {
    }

    @FXML
    private void update(ActionEvent actionEvent) {
    }

    @FXML
    private void delete(ActionEvent actionEvent) {
    }

    @FXML
    private void tableCliked(MouseEvent mouseEvent) {
    }
}
