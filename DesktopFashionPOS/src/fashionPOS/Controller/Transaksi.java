package fashionPOS.Controller;
/**
 * Created By Steven
 */
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Transaksi  {

    @FXML
    private TextField kembali;
    @FXML
    private TextField bayar;
    @FXML
    private TextField totalNet;
    private String pay;
    private String kembalian;
    private String total;
    @FXML
    private AnchorPane root;

    public void initial(String pay,String kembalian,String total){
        this.pay=pay;
        this.kembalian=kembalian;
        this.total=total;
        kembali.setText(kembalian);
        bayar.setText(pay);
        totalNet.setText(total);
    }
    @FXML
    private void BACK(ActionEvent actionEvent) {
        ((Stage) this.root.getScene().getWindow()).close();
    }
}
