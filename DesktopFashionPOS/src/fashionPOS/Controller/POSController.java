package fashionPOS.Controller;

import fashionPOS.Model.Dao.ItemDao;
import fashionPOS.Model.Dao.TransaksiDao;
import fashionPOS.Model.Entity.Tbitem;
import fashionPOS.Model.Entity.Tbtransaction;
import fashionPOS.Model.Entity.Tbuser;
import fashionPOS.Util.DBHelper;
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
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
    @FXML
    private TextField kembali;
    @FXML
    private TextField bayar;
    private Tbuser pelaku;

    private ObservableList<Tbtransaction> tbtransactions;
    private TransaksiDao transaksiDao;
    private Tbitem clickItem;
    private Tbtransaction clickTrans;
    private int idxTrans;
    private ObservableList<Tbitem> cad = FXCollections.observableArrayList();
    private List<Tbitem> data = new ArrayList<Tbitem>();
    private SimpleDateFormat simpleDateFormat;
    private Date dateNow;
    private Double Hasil = 0.0;
    private List<Tbtransaction> listTransaksi = new ArrayList<Tbtransaction>();
    private ObservableList<Tbtransaction> penampungListTransaksi = FXCollections.observableArrayList();
    private Double NetAmo;

    private void reset() {
        net.clear();
        tax.clear();
        net.clear();
        bayar.clear();
        kembali.clear();
        NetAmo = 0.0;
        penampungListTransaksi.clear();
        listTransaksi.clear();
        Hasil = 0.0;
        data.clear();
        cad.clear();
        idxTrans = 0;
        tbtransactions.clear();
        tableTrf.setItems(tbtransactions);
    }

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
    private void itemClick(MouseEvent mouseEvent) {
        clickItem = tableItem.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void transaksiClick(MouseEvent mouseEvent) {

        clickTrans = tableTrf.getSelectionModel().getSelectedItem();
        idxTrans = tableTrf.getSelectionModel().getSelectedIndex();
    }

    @FXML
    private void checkout(ActionEvent actionEvent) {
        if (Hasil == 0.0) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Belum Ada Transaksi!");
            a.show();
        } else {
            if (bayar.getText() == null || bayar.getText().trim().isEmpty()) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Uangnya Mana? T_T");
                a.show();
            } else if (Double.parseDouble(bayar.getText()) < Hasil) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Jangan Mau Rugi :)!\nUangnya Kurang!");
                a.show();

            } else {
                Date now = new Date();
                kembali.setText(convIDR(Double.parseDouble(bayar.getText()) - Hasil));
                Tbtransaction data = new Tbtransaction();
                int id = getTbtransactions().size() + 1;
                for (Tbtransaction i : listTransaksi) {
                    i.setTransactionId(id);
                    i.setTransactionDate(now);
                    i.setTransactionStatus(1);
                    i.setTbuserByTbuserUserId(pelaku);
                    getTransaksiDao().addData(i);
                    id++;
                }
                reset();
            }
        }
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
        data.clear();
        for (Tbitem i : getTbitems()) {
            if (i.getTbcategoryByTbcategoryCategoryId().getCategoryType().equals(baju.getText())) {
                data.add(i);
            }
        }
        cad.setAll(data);
        tableItem.setItems(cad);
    }

    @FXML
    private void celana(ActionEvent actionEvent) {
        data.clear();
        for (Tbitem i : getTbitems()) {
            if (i.getTbcategoryByTbcategoryCategoryId().getCategoryType().equals(celana.getText())) {
                data.add(i);
            }
        }
        cad.setAll(data);
        tableItem.setItems(cad);
    }

    @FXML
    private void kauskaki(ActionEvent actionEvent) {
        data.clear();
        for (Tbitem i : getTbitems()) {
            if (i.getTbcategoryByTbcategoryCategoryId().getCategoryType().equals(kaoskaki.getText())) {
                data.add(i);
            }
        }
        cad.setAll(data);
        tableItem.setItems(cad);
    }

    @FXML
    private void sepatu(ActionEvent actionEvent) {
        data.clear();
        for (Tbitem i : getTbitems()) {
            if (i.getTbcategoryByTbcategoryCategoryId().getCategoryType().equals(sepatu.getText())) {
                data.add(i);
            }
        }
        cad.setAll(data);
        tableItem.setItems(cad);
    }

    @FXML
    private void sandal(ActionEvent actionEvent) {
        data.clear();
        for (Tbitem i : getTbitems()) {
            if (i.getTbcategoryByTbcategoryCategoryId().getCategoryType().equals(sandal.getText())) {
                data.add(i);
            }
        }
        cad.setAll(data);
        tableItem.setItems(cad);
    }

    @FXML
    private void other(ActionEvent actionEvent) {
        data.clear();
        for (Tbitem i : getTbitems()) {
            if (i.getTbcategoryByTbcategoryCategoryId().getCategoryType().equals(other.getText())) {
                data.add(i);
            }
        }
        cad.setAll(data);
        tableItem.setItems(cad);
    }

    @FXML
    private void showall(ActionEvent actionEvent) {
        data.clear();
        tableItem.setItems(getTbitems());
    }


    @FXML
    private void add(ActionEvent actionEvent) {
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Input QTY");
        dialog.setContentText("Masukkan Jumlah Qty:");
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


    private void internalModelPesanan() {
        NetAmo = 0.0;
        for (Tbtransaction i : listTransaksi) {
            NetAmo += i.getTransactionTotalprice() * i.getQty();
        }
        net.setText(String.valueOf(convIDR(NetAmo)));
        Hasil = NetAmo + Double.parseDouble(tax.getText().equals("") ? "0" : tax.getText());

        totalNet.setText(convIDR(Hasil));
    }


    private String convIDR(Double harga) {
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        return kursIndonesia.format(harga);
    }


    @FXML
    private void update(ActionEvent actionEvent) {
        if (clickTrans != null && !listTransaksi.isEmpty()) {
            TextInputDialog dialog = new TextInputDialog("");
            dialog.setTitle("Ubah QTY");
            dialog.setContentText("Masukkan Jumlah Qty:");
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent() && !result.get().equals("") && !(Integer.parseInt(result.get()) == 0)) {
                clickTrans.setQty(Integer.valueOf(result.get()));
                listTransaksi.set(idxTrans, clickTrans);
                penampungListTransaksi.setAll(listTransaksi);
                tableTrf.refresh();
                internalModelPesanan();
            }
        }
    }

    @FXML
    private void delete(ActionEvent actionEvent) {
        if (clickTrans != null && !listTransaksi.isEmpty()) {
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setContentText("Apakah yakin mau menghapus data?");
            a.setContentText("Konfirmasi Hapus");
            a.showAndWait();
            if (a.getResult() == ButtonType.OK) {
                listTransaksi.remove(clickTrans);
                penampungListTransaksi.setAll(listTransaksi);
                tableTrf.refresh();
                internalModelPesanan();
            }

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
                Hasil = NetAmo * 1.1;
                totalNet.setText(convIDR(Hasil));
            }
        } else {
            Hasil = NetAmo;
            totalNet.setText(convIDR(Hasil));
            tax.setText("");
        }

    }


    public void setMainFormController(Tbuser pelaku) {
        this.pelaku = pelaku;
    }
}
