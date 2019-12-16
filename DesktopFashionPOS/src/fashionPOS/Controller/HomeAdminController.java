package fashionPOS.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeAdminController {
    private Stage userStage;
    private Stage selfStage;
    private Stage itemStage;
    @FXML
    private BorderPane root;

    public void actionFormItem(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fashionPOS/View/item.fxml"));
            AnchorPane pane = loader.load();
//                HomeAdminController controller = loader.getController();
//                controller.setMainFormController(this);
//            Scene scene = new Scene(pane);
            Scene scene = new Scene(pane);
            userStage.setScene(scene);
            userStage.setTitle("Item");
            userStage.initModality(Modality.APPLICATION_MODAL);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void actionFormUser(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fashionPOS/View/user.fxml"));
            AnchorPane pane = loader.load();
//                HomeAdminController controller = loader.getController();
//                controller.setMainFormController(this);
            Scene scene = new Scene(pane);
            itemStage.setScene(scene);
            itemStage.setTitle("User");
            itemStage.initModality(Modality.APPLICATION_MODAL);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @FXML
    private void out(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader();
            selfStage = new Stage();
            loader.setLocation(getClass().getResource("/fashionPOS/View/login.fxml"));
            AnchorPane pane = loader.load();
            Scene scene = new Scene(pane);
            selfStage.setScene(scene);
            selfStage.initModality(Modality.APPLICATION_MODAL);

            ((Stage) root.getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        selfStage.show();
    }
}
