package fashionPOS.Controller;

import fashionPOS.Model.Dao.UserDao;
import fashionPOS.Model.Entity.Tbuser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    public AnchorPane root;
    private Stage selfStage;
    private UserDao loginDao;
    private Tbuser tbuser;
    @FXML
    private PasswordField txtUsername;
    @FXML
    private TextField txtPassword;

    private Tbuser getLogin(Tbuser data){
        if(tbuser == null){
            tbuser=getLoginDao().getData(data);
        }
        return tbuser;
    }

    private UserDao getLoginDao() {
        if (loginDao == null) {
            loginDao = new UserDao();
        }
        return loginDao;
    }

    @FXML
    private void SignIn(ActionEvent actionEvent) {
        Tbuser tbuser = new Tbuser();
        tbuser.setUserName(txtUsername.getText().trim());
        tbuser.setUserPassword(txtPassword.getText().trim());

        FXMLLoader loader = new FXMLLoader();
        selfStage = new Stage();
        if (getLogin(tbuser).getTbroleByTbroleRoleId().getRoleName().equals("admin")) {
            try {
                loader.setLocation(getClass().getResource("/fashionPOS/View/homeAdmin.fxml"));
                BorderPane pane = loader.load();
                Scene scene = new Scene(pane);
                selfStage.setScene(scene);
                selfStage.setTitle("Home Admin");
                selfStage.initModality(Modality.APPLICATION_MODAL);

                ((Stage) root.getScene().getWindow()).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            selfStage.show();
        } else if (getLoginDao().getData(tbuser).getTbroleByTbroleRoleId().getRoleName().equals("kasir")) {
            try {
                loader.setLocation(getClass().getResource("/fashionPOS/View/point_of_sales.fxml"));
                AnchorPane pane = loader.load();
                Scene scene = new Scene(pane);
                selfStage.setScene(scene);
                selfStage.setTitle("POS");
                selfStage.initModality(Modality.APPLICATION_MODAL);

                ((Stage) this.root.getScene().getWindow()).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            selfStage.show();
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Username or Password is Wrong!");
            a.show();
        }
    }
}
