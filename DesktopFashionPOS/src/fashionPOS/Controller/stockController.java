package fashionPOS.Controller;
/**
 * Created By Nicolavickh
 */
import fashionPOS.Model.Dao.SizeStockDao;
import fashionPOS.Model.Entity.Tbitem;
import fashionPOS.Model.Entity.Tbsizestock;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class stockController implements Initializable {
    @FXML
    private TextField txtItem;
    @FXML
    private VBox root;
    @FXML
    private TextField txtS;
    @FXML
    private TextField txtM;
    @FXML
    private TextField txtL;
    @FXML
    private TextField txtXL;
    @FXML
    private TextField txtXXL;
    @FXML
    private TextField txtXXXL;
    @FXML
    private Button add;
    @FXML
    private Button update;
    @FXML
    private Button delete;
    @FXML
    private TableView<Tbsizestock> tableStock;
    @FXML
    private TableColumn<Tbsizestock, String> colName;
    @FXML
    private TableColumn<Tbsizestock, String> colS;
    @FXML
    private TableColumn<Tbsizestock, String> colL;
    @FXML
    private TableColumn<Tbsizestock, String> colM;
    @FXML
    private TableColumn<Tbsizestock, String> colXL;
    @FXML
    private TableColumn<Tbsizestock, String> colXXL;
    @FXML
    private TableColumn<Tbsizestock, String> colXXXL;
    private Tbsizestock selected = new Tbsizestock();
    private SizeStockDao stockDao;
    private ObservableList<Tbsizestock> stocks;

    private ObservableList<Tbsizestock> getStock() {
        if (stocks == null) {
            stocks = FXCollections.observableArrayList();
            stocks.addAll(getStockDao().getAllData());
        }
        return stocks;
    }
    private SizeStockDao getStockDao() {
        if (stockDao == null) {
            stockDao = new SizeStockDao();
        }
        return stockDao;
    }
    @FXML
    private void add(ActionEvent actionEvent) {
        Tbsizestock stock = new Tbsizestock();
        stock.setTbitemByTbitemItemId(selected.getTbitemByTbitemItemId());
        stock.setSizestockSStock(selected.getSizestockSStock() + Integer.parseInt(txtS.getText()));
        stock.setSizestockMStock(selected.getSizestockMStock() + Integer.parseInt(txtM.getText()));
        stock.setSizestockLStock(selected.getSizestockLStock() + Integer.parseInt(txtL.getText()));
        stock.setSizestockXlStock(selected.getSizestockXlStock() + Integer.parseInt(txtXL.getText()));
        stock.setSizestockXxlStock(selected.getSizestockXxlStock() + Integer.parseInt(txtXXL.getText()));
        stock.setSizestockXxxlStock(selected.getSizestockXxxlStock() + Integer.parseInt(txtXXXL.getText()));
        stockDao.updateData(stock);
    }

    @FXML
    private void update(ActionEvent actionEvent) {
        selected.setSizestockSStock(Integer.parseInt(txtS.getText()));
        selected.setSizestockMStock(Integer.parseInt(txtM.getText()));
        selected.setSizestockLStock(Integer.parseInt(txtL.getText()));
        selected.setSizestockXlStock(Integer.parseInt(txtXL.getText()));
        selected.setSizestockXxlStock(Integer.parseInt(txtXXL.getText()));
        selected.setSizestockXxxlStock(Integer.parseInt(txtXXXL.getText()));
        stockDao.updateData(selected);
    }


    @FXML
    private void tableClicked(MouseEvent mouseEvent) {
        selected = tableStock.getSelectionModel().getSelectedItem();
        txtItem.setText(selected.getTbitemByTbitemItemId().getItemName());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableStock.setItems(getStock());
        colName.setCellValueFactory(data ->
                new SimpleStringProperty(String.valueOf(data.getValue().getTbitemByTbitemItemId().getItemName())));
        colS.setCellValueFactory(data ->
                new SimpleStringProperty(String.valueOf(data.getValue().getSizestockSStock())));
        colM.setCellValueFactory(data ->
                new SimpleStringProperty(String.valueOf(data.getValue().getSizestockMStock())));
        colL.setCellValueFactory(data ->
                new SimpleStringProperty(String.valueOf(data.getValue().getSizestockLStock())));
        colXL.setCellValueFactory(data ->
                new SimpleStringProperty(String.valueOf(data.getValue().getSizestockXlStock())));
        colXXL.setCellValueFactory(data ->
                new SimpleStringProperty(String.valueOf(data.getValue().getSizestockXxlStock())));
        colXXXL.setCellValueFactory(data ->
                new SimpleStringProperty(String.valueOf(data.getValue().getSizestockXxxlStock())));
    }
}
