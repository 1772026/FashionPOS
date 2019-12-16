package fashionPOS.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class POSController {
    private Stage selfStage;
    @FXML
    private VBox root;

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
