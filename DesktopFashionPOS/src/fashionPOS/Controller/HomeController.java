package fashionPOS.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    private Stage userStage;
    private Stage itemStage;
    public void actionFormItem(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fashionPOS/View/item.fxml"));
            AnchorPane pane = loader.load();
//                HomeController controller = loader.getController();
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
//                HomeController controller = loader.getController();
//                controller.setMainFormController(this);
            Scene scene = new Scene(pane);
            itemStage.setScene(scene);
            itemStage.setTitle("User");
            itemStage.initModality(Modality.APPLICATION_MODAL);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
