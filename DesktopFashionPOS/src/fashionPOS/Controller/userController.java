package fashionPOS.Controller;

import fashionPOS.Model.Dao.CategoryDao;
import fashionPOS.Model.Dao.ItemDao;
import fashionPOS.Model.Dao.RoleDao;
import fashionPOS.Model.Dao.UserDao;
import fashionPOS.Model.Entity.Tbcategory;
import fashionPOS.Model.Entity.Tbitem;
import fashionPOS.Model.Entity.Tbrole;
import fashionPOS.Model.Entity.Tbuser;
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

public class userController implements Initializable {
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
    private TableColumn<Tbuser, String> colId;
    @FXML
    private TableColumn<Tbuser, String> colUsername;
    @FXML
    private TableColumn<Tbuser, String> colPassword;
    @FXML
    private TableColumn<Tbuser, String> colName;
    @FXML
    private TableColumn<Tbuser, String> colRole;
    @FXML
    private TableView<Tbuser> tableUser;
    private ObservableList<Tbuser> tbusers;
    private UserDao userDao;
    private ObservableList<Tbrole> tbroles;
    private RoleDao roleDao;
    private Tbuser selectUser;

    private ObservableList<Tbuser> getTbusers() {
        if (tbusers == null) {
            tbusers = FXCollections.observableArrayList();
            tbusers.addAll(getUserDao().getAllData());
        }
        return tbusers;
    }

    private UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDao();
        }
        return userDao;
    }

    private ObservableList<Tbrole> getTbroles() {
        if (tbroles == null) {
            tbroles = FXCollections.observableArrayList();
            tbroles.addAll(getRoleDao().getAllData());
        }
        return tbroles;
    }

    private RoleDao getRoleDao() {
        if (roleDao == null) {
            roleDao = new RoleDao();
        }
        return roleDao;
    }

    @FXML
    private void add(ActionEvent actionEvent) {
    }

    @FXML
    private void update(ActionEvent actionEvent) {
    }

    @FXML
    private void delete(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableUser.setItems(getTbusers());
        role.setItems(getTbroles());
        colId.setCellValueFactory(d -> new SimpleStringProperty(String.valueOf(d.getValue().getUserId())));
        colUsername.setCellValueFactory(d -> new SimpleStringProperty(String.valueOf(d.getValue().getUserName())));

        colPassword.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getUserPassword()));
        colName.setCellValueFactory(d -> new SimpleStringProperty(String.valueOf(d.getValue().getUserName())));
        colRole.setCellValueFactory(d -> new SimpleStringProperty(String.valueOf(d.getValue().getTbroleByTbroleRoleId().getRoleName())));

    }

    @FXML
    private void selectRole(MouseEvent mouseEvent) {
        selectUser = tableUser.getSelectionModel().getSelectedItem();
    }
}
