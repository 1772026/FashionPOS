package fashionPOS.Controller;

import fashionPOS.Model.Dao.ItemDao;
import fashionPOS.Model.Dao.TransaksiDao;
import fashionPOS.Model.Entity.Tbitem;
import fashionPOS.Model.Entity.Tbtransaction;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.*;

public class POSController implements Initializable {
    public AnchorPane root;
    private Stage selfStage;
    @FXML
    private TableColumn<Tbtransaction, String> colName;
    @FXML
    private TableColumn<Tbtransaction, String> colPice;
    @FXML
    private TableColumn<Tbtransaction, String> colQty;
    @FXML
    private TableColumn<Tbitem, String> colItem;
    @FXML
    private Button add;
    @FXML
    private Button update;
    @FXML
    private Button delete;
    @FXML
    private Button checkout;
    @FXML
    private TableView<Tbitem> tableItem;
    @FXML
    private TableView<Tbtransaction> tableTrf;

    private ObservableList<Tbitem> tbitems;
    private ItemDao itemDao;
    @FXML
    private Button baju;
    @FXML
    private Button celana;
    @FXML
    private Button kaoskaki;
    @FXML
    private Button sandal;
    @FXML
    private Button sepatu;
    @FXML
    private Button other;
    @FXML
    private Button showall;
    @FXML
    private TableColumn<Tbitem, String> colHarga;
    @FXML
    private TextField net;
    @FXML
    private TextField tax;
    @FXML
    private CheckBox disc;
    @FXML
    private TextField totalNet;


    private ObservableList<Tbitem> getTbitems() {
        if (tbitems == null) {
            tbitems = FXCollections.observableArrayList();
            tbitems.addAll(getItemDao().getAllData());
        }
        return tbitems;
    }

    private ItemDao getItemDao() {
        if (itemDao == null) {
            itemDao = new ItemDao();
        }
        return itemDao;
    }

    private ObservableList<Tbtransaction> tbtransactions;
    private TransaksiDao transaksiDao;

    private ObservableList<Tbtransaction> getTbtransactions() {
        if (tbtransactions == null) {
            tbtransactions = FXCollections.observableArrayList();
            tbtransactions.addAll(getTransaksiDao().getAllData());
        }
        return tbtransactions;
    }

    private TransaksiDao getTransaksiDao() {
        if (transaksiDao == null) {
            transaksiDao = new TransaksiDao();
        }
        return transaksiDao;
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

            ((Stage) this.root.getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        selfStage.show();
    }

    private Tbitem clickItem;
    private Tbtransaction clickTrans;

    @FXML
    private void itemClick(MouseEvent mouseEvent) {
        clickItem = tableItem.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void transaksiClick(MouseEvent mouseEvent) {
        clickTrans = tableTrf.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void checkout(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableItem.setItems(getTbitems());

        colItem.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getItemName()));
        colHarga.setCellValueFactory(d -> new SimpleStringProperty(String.valueOf(d.getValue().getItemPriceSell())));

        colName.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getTbitemByTbitemItemId().getItemName()));
        colPice.setCellValueFactory(d -> new SimpleStringProperty(String.valueOf(d.getValue().getTransactionTotalprice())));
        colQty.setCellValueFactory(d -> new SimpleStringProperty(String.valueOf(d.getValue().getQty())));


    }

    @FXML
    private void baju(ActionEvent actionEvent) {
    }

    @FXML
    private void celana(ActionEvent actionEvent) {
    }

    @FXML
    private void kauskaki(ActionEvent actionEvent) {
    }

    @FXML
    private void sepatu(ActionEvent actionEvent) {
    }

    @FXML
    private void sandal(ActionEvent actionEvent) {
    }

    @FXML
    private void other(ActionEvent actionEvent) {
    }

    @FXML
    private void showall(ActionEvent actionEvent) {
    }

    private SimpleDateFormat simpleDateFormat;
    private Date dateNow;

    @FXML
    private void add(ActionEvent actionEvent) {
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Input QTY");
        dialog.setContentText("Masukkan Jumlah Qty Makanan:");
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent() && !result.get().equals("") && !(Integer.parseInt(result.get()) == 0)) {
            Tbtransaction data = new Tbtransaction();
            data.setQty(Integer.valueOf(result.get()));
            data.setTransactionTotalprice(clickItem.getItemPriceSell());
            data.setTbitemByTbitemItemId(clickItem);
            listTransaksi.add(data);
            penampungListTransaksi.setAll(listTransaksi);

            internalModelPesanan();

            tableTrf.setItems(penampungListTransaksi);
            tableTrf.refresh();

        }

    }

    private List<Tbtransaction> listTransaksi = new ArrayList<Tbtransaction>();
    private ObservableList<Tbtransaction> penampungListTransaksi = FXCollections.observableArrayList();
    private Double NetAmo;

    private String convIDR(Double harga) {
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        return kursIndonesia.format(harga);
    }

    private void internalModelPesanan() {
        NetAmo = 0.0;
        for (Tbtransaction i : listTransaksi) {
            NetAmo += i.getTransactionTotalprice() * i.getQty();
        }
        net.setText(String.valueOf(convIDR(NetAmo)));
        Double Hasil = NetAmo + Double.parseDouble(tax.getText().equals("") ? "0" : tax.getText());

        totalNet.setText(convIDR(Hasil));
    }

    @FXML
    private void update(ActionEvent actionEvent) {
        if (cli)
    }

    @FXML
    private void delete(ActionEvent actionEvent) {
        if (clickTrans != null && !listTransaksi.isEmpty()) {
            listTransaksi.remove(clickTrans);
            penampungListTransaksi.setAll(listTransaksi);
            tableTrf.refresh();
        }
    }

    @FXML
    private void tax(ActionEvent actionEvent) {
        if (disc.isSelected()) {
            if (listTransaksi.isEmpty()) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Tidak Ada transaksi!");
                a.show();
                disc.setSelected(false);
            } else {
                tax.setText(convIDR(NetAmo * 0.1));
                Double Hasil = NetAmo *0.9;
                totalNet.setText(convIDR(Hasil));
            }
        } else {
            Double Hasil = NetAmo;
            totalNet.setText(convIDR(Hasil));
            tax.setText("");
        }

    }
}
