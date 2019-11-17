package fashionPOS.Controller;

import fashionPOS.Model.Dao.LoginDao;
import fashionPOS.Model.Entity.Tbuser;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    private Stage homeStage;
    private LoginDao loginDao;
    private ObservableList<Tbuser> tbusers;

    public boolean getLogin(Tbuser user) {
        return getLoginDao().login(user);
    }

    public LoginDao getLoginDao() {
        if (loginDao == null) {
            loginDao = new LoginDao();
        }
        return loginDao;
    }

    @FXML
    private void actionLogin(ActionEvent actionEvent) {
        Tbuser tbuser=new Tbuser();
        tbuser.setUsername(txtUsername.getText().trim());
        tbuser.setPassword(txtPassword.getText().trim());
        if (getLogin(tbuser)){
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/fashionPOS/View/home.fxml"));
                BorderPane pane = loader.load();
                HomeController controller = loader.getController();
                controller.setMainFormController(this);
                Scene scene = new Scene(pane);
                homeStage = new Stage();
                homeStage.setScene(scene);
                homeStage.setTitle("Home");
                homeStage.initModality(Modality.APPLICATION_MODAL);
            } catch (IOException e) {
                e.printStackTrace();

            }
            homeStage.show();
        }else {
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setContentText("Username or Password is Wrong!");
            a.show();
        }

    }
}
