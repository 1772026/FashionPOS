package fashionPOS.Controller;

import fashionPOS.Model.Dao.CategoryDao;
import fashionPOS.Model.Dao.ItemDao;
import fashionPOS.Model.Entity.Tbcategory;
import fashionPOS.Model.Entity.Tbitem;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class itemController implements Initializable {
    @FXML
    private TextField txtid;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPriceBuy;
    @FXML
    private TextField txtPriceSell;
    @FXML
    private ComboBox<Tbcategory> comboCategory;
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
    private TableView<Tbitem> tableItem;
    @FXML
    private TableColumn<Tbitem, String> colID;
    @FXML
    private TableColumn<Tbitem, String> colName;
    @FXML
    private TableColumn<Tbitem, String> colCategory;
    @FXML
    private TableColumn<Tbitem, String> colPriceSell;
    @FXML
    private TableColumn<Tbitem, String> colPriceBuy;
    @FXML
    private VBox child;
    private Tbitem selected;
    private ObservableList<Tbitem> tbItems;
    private ObservableList<Tbcategory> tbCategories;
    private ItemDao itemDao ;
    private CategoryDao categoryDao ;


    private ObservableList<Tbitem> getTbItems() {
        if (tbItems == null) {
            tbItems = FXCollections.observableArrayList();
            tbItems.addAll(getItemDao().getAllData());
        }
        return tbItems;
    }

    private ItemDao getItemDao() {
        if (itemDao == null) {
            itemDao = new ItemDao();
        }
        return itemDao;
    }

    private ObservableList<Tbcategory> getCategories() {
        if (tbCategories == null) {
            tbCategories = FXCollections.observableArrayList();
            tbCategories.addAll(getCategoryDao().getAllData());
        }
        return tbCategories;
    }

    private CategoryDao getCategoryDao() {
        if (categoryDao == null) {
            categoryDao = new CategoryDao();
        }
        return categoryDao;
    }

    @FXML
    private void categoryClick(MouseEvent mouseEvent) {

    }

    @FXML
    private void save(ActionEvent actionEvent) {
        Tbitem item = new Tbitem();
        Tbcategory category = new Tbcategory();

        category.setCategoryId(comboCategory.getSelectionModel().getSelectedItem().getCategoryId());
        category.setCategoryType(comboCategory.getSelectionModel().getSelectedItem().getCategoryType());


        item.setItemName(txtName.getText().trim());
        item.setItemPriceSell(Integer.parseInt(txtPriceSell.getText().trim()));
        item.setItemPriceSupply(Integer.parseInt(txtPriceBuy.getText().trim()));
        item.setItemDescription(txtDescription.getText());
        item.setTbcategoryByTbcategoryCategoryId(category);

        boolean notDuplicate = getTbItems().stream().noneMatch(d -> d.getItemName() == item.getItemName());
        if (notDuplicate) {
            getItemDao().addData(item);
            tableItem.refresh();
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Duplicate Item Name");
            a.showAndWait();
        }
        tableItem.refresh();
    }

    @FXML
    private void reset(ActionEvent actionEvent) {
    }

    @FXML
    private void update(ActionEvent actionEvent) {
        Tbitem item = new Tbitem();
        Tbcategory category = new Tbcategory();

        category.setCategoryId(comboCategory.getSelectionModel().getSelectedItem().getCategoryId());
        category.setCategoryType(comboCategory.getSelectionModel().getSelectedItem().getCategoryType());


        item.setItemId(Integer.parseInt(txtid.getText()));
        item.setItemName(txtName.getText().trim());
        item.setItemPriceSell(Integer.parseInt(txtPriceSell.getText().trim()));
        item.setItemPriceSupply(Integer.parseInt(txtPriceBuy.getText().trim()));
        item.setItemDescription(txtDescription.getText());
        item.setTbcategoryByTbcategoryCategoryId(category);

        boolean notDuplicate = getTbItems().stream().noneMatch(d -> d.getItemName().equals(item.getItemName()));
        if (selected.getItemName() != txtid.getText()) {
            if (notDuplicate) {
                itemDao.updateData(item);
                tableItem.refresh();
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Duplicate Item Name");
                a.showAndWait();
            }
        }
        tableItem.refresh();
    }

    @FXML
    private void delete(ActionEvent actionEvent) {
        Tbitem item = new Tbitem();
        Tbcategory category = new Tbcategory();

        category.setCategoryId(comboCategory.getSelectionModel().getSelectedItem().getCategoryId());
        category.setCategoryType(comboCategory.getSelectionModel().getSelectedItem().getCategoryType());

        item.setItemId(Integer.parseInt(txtid.getText()));
        getItemDao().updateData(item);
        item.setItemName(txtName.getText().trim());
        item.setItemPriceSell(Integer.parseInt(txtPriceSell.getText().trim()));
        item.setItemPriceSupply(Integer.parseInt(txtPriceBuy.getText().trim()));
        item.setItemDescription(txtDescription.getText());
        item.setTbcategoryByTbcategoryCategoryId(category);
        itemDao.deleteData(item);
        clearForm();
        tableItem.refresh();
    }

    @FXML
    private void tableClicked(MouseEvent mouseEvent) {
        selected = tableItem.getSelectionModel().getSelectedItem();
        txtid.setText(String.valueOf(selected.getItemId()));
        txtName.setText(selected.getItemName());
        txtPriceSell.setText(String.valueOf(selected.getItemPriceSell()));
        txtPriceBuy.setText(String.valueOf(selected.getItemPriceSupply()));
        txtDescription.setText(selected.getItemDescription());
        comboCategory.setValue(selected.getTbcategoryByTbcategoryCategoryId());
        save.setDisable(true);
        update.setDisable(false);
        delete.setDisable(false);
    }

    private void clearForm() {
        txtid.clear();
        txtDescription.clear();
        txtName.clear();
        txtPriceBuy.clear();
        txtPriceSell.clear();
        comboCategory.setValue(null);
        save.setDisable(false);
        update.setDisable(true);
        delete.setDisable(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableItem.setItems(getTbItems());
        comboCategory.setItems(getCategories());
        colID.setCellValueFactory(data ->
                new SimpleStringProperty(String.valueOf(data.getValue().getItemId())));
        colName.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getItemName()));
        colCategory.setCellValueFactory(data ->
                new SimpleStringProperty(String.valueOf(data.getValue().getTbcategoryByTbcategoryCategoryId().getCategoryId())));
        colPriceBuy.setCellValueFactory(data ->
                new SimpleStringProperty(String.valueOf(data.getValue().getItemPriceSupply())));
        colPriceSell.setCellValueFactory(data ->
                new SimpleStringProperty(String.valueOf(data.getValue().getItemPriceSell())));
    }


}
