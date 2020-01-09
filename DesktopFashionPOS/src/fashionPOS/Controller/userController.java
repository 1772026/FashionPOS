package fashionPOS.Controller;
/**
 * Created By Steven
 */
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
    private ComboBox<Tbrole> role;
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
    @FXML
    private Button reset;

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

    private boolean checker() {
        if (
                name.getText().trim().isEmpty() ||
                        username.getText().trim().isEmpty() ||
                        password.getText().trim().isEmpty() ||
                        role.getValue() == null

        ) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Check Your Input!");
            a.show();
            return false;
        } else {
            return true;
        }
    }

    @FXML
    private void add(ActionEvent actionEvent) {
        if (checker()) {
            Tbuser data = new Tbuser();
            data.setUserUsername(username.getText());
            data.setUserPassword(password.getText());
            data.setTbroleByTbroleRoleId(role.getValue());
            data.setUserName(name.getText());
            userDao.addData(data);
            getTbusers().setAll(getUserDao().getAllData());
            tableUser.setItems(getTbusers());
            tableUser.refresh();
        }
    }

    @FXML
    private void update(ActionEvent actionEvent) {
        if (checker()) {

            Tbuser data = new Tbuser();
            data.setUserUsername(username.getText());
            data.setUserPassword(password.getText());
            data.setTbroleByTbroleRoleId(role.getValue());
            data.setUserName(name.getText());
            userDao.updateData(data);
            getTbusers().setAll(getUserDao().getAllData());
            tableUser.setItems(getTbusers());
            tableUser.refresh();
            cleat();

        }
    }

    @FXML
    private void delete(ActionEvent actionEvent) {
        if (checker()) {
            if (selectUser.getUserId() == 1 || selectUser.getUserId() == 2) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Tidak bisa di hapus, karena user utama");
                a.show();
            } else {
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setContentText("Apakah yakin mau menghapus data?");
                a.setContentText("Konfirmasi Hapus");
                a.showAndWait();
                if (a.getResult() == ButtonType.OK) {
                    userDao.deleteData(selectUser);
                    getTbusers().setAll(getUserDao().getAllData());
                    tableUser.setItems(getTbusers());
                    tableUser.refresh();
                    cleat();
                }

            }

        }

    }


    private void cleat() {
        id.setText("");
        name.setText("");
        username.setText("");
        password.setText("");
        role.setValue(null);
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
        try {
            selectUser = tableUser.getSelectionModel().getSelectedItem();
            id.setText(String.valueOf(selectUser.getUserId()));
            username.setText(selectUser.getUserName());
            password.setText(selectUser.getUserPassword());
            role.setValue(selectUser.getTbroleByTbroleRoleId());
            name.setText(selectUser.getUserName());
        } catch (Exception e) {
        }
    }

    @FXML
    private void reset(ActionEvent actionEvent) {
        cleat();
    }
}

