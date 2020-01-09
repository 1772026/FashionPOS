package fashionPOS.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
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
            userStage = new Stage();
            loader.setLocation(getClass().getResource("/fashionPOS/View/ItemForm.fxml"));
            VBox pane = loader.load();
            Scene scene = new Scene(pane);
            root.setCenter(new AnchorPane(pane));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actionFormUser(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader();
            userStage = new Stage();
            loader.setLocation(getClass().getResource("/fashionPOS/View/userForm.fxml"));
            VBox pane = loader.load();
            Scene scene = new Scene(pane);
            root.setCenter(new AnchorPane(pane));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void report(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader();
            userStage = new Stage();
            loader.setLocation(getClass().getResource("/fashionPOS/View/view_transaksi.fxml"));
            VBox pane = loader.load();
            Scene scene = new Scene(pane);
            root.setCenter(new AnchorPane(pane));

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
            selfStage.setTitle("Fashion POS");
            selfStage.initModality(Modality.APPLICATION_MODAL);

            ((Stage) root.getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        selfStage.show();
    }


    @FXML
    private void retur(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader();
            userStage = new Stage();
            loader.setLocation(getClass().getResource("/fashionPOS/View/return_item_form.fxml"));
            AnchorPane pane = loader.load();
            Scene scene = new Scene(pane);
            root.setCenter(new AnchorPane(pane));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
