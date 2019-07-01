/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminpage;

import common.Common;
import db.ShopDBUtils;
import entity.Shop;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ANITA
 */
/*initializable and the methods it adds are used when you want to 
interact with stuff injected wih @FXML*/
public class AdminPageController implements Initializable {

    private Button btnNewRegistration;

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtCodePrice;
    @FXML
    private TextField txtEntryName;
    @FXML
    private TextField txtDiscountPercentage;
    @FXML
    private TextField txtPrice;

    @FXML
    private TableView<Shop> tblShopData;
    @FXML
    private TableColumn<Shop, Integer> colId;
    @FXML
    private TableColumn<Shop, String> colProductName;
    @FXML
    private TableColumn<Shop, Integer> colPrice;
    @FXML
    private TableColumn<Shop, Integer> colDiscountPercentage;
    @FXML
    private TableColumn<Shop, String> colCodePrice;
    @FXML
    private TableColumn<Shop, String> colEntryName;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnSearch;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnLoad;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnClear;
    @FXML
    private TextField txtId;

    Shop shop;
    ShopDBUtils shopDBUtils;
    ObservableList<Shop> listOfShopData;
    Common common;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void handleItemsReviewButtonPressed(ActionEvent event) throws IOException {
        common = new Common();
        common.nextStage("/itemsreview/ItemsReview.fxml", "ItemsReview Window", true);
        Stage current = (Stage) btnNewRegistration.getScene().getWindow();
        current.hide();
    }

    @FXML
    private void handleSaveButtonAction(ActionEvent event) throws SQLException {
        shop = new Shop();
        shopDBUtils = new ShopDBUtils();
        shop.setProductName(txtName.getText());
        shop.setPrice(Integer.parseInt(txtPrice.getText()));
        shop.setDiscountPercentage(Integer.parseInt(txtDiscountPercentage.getText()));
        shop.setEntryName(txtEntryName.getText());
        shop.setCodePrice(txtCodePrice.getText());
        if (shopDBUtils.saveShopData(shop)) {
            System.out.println("Shop Data Inserted Successfully");
            clear();
            handleLoadButtonAction(event);

        }

    }

    @FXML
    private void handleSearchButtonAction(ActionEvent event) {

    }

    @FXML
    private void handleEditButtonAction(ActionEvent event) throws SQLException {
        shop = new Shop();
        shopDBUtils = new ShopDBUtils();
        shop.setId(Integer.parseInt(txtId.getText()));
        shop.setProductName(txtName.getText());
        shop.setEntryName(txtEntryName.getText());
        shop.setCodePrice(txtCodePrice.getText());
        shop.setDiscountPercentage(Integer.parseInt(txtDiscountPercentage.getText()));
        shop.setPrice(Integer.parseInt(txtPrice.getText()));

        if (shopDBUtils.updateData(shop)) {
            handleLoadButtonAction(event);
            System.out.println("Updated successfully");
            clear();
        } else {
            System.out.println("NO");
        }
    }

    @FXML
    private void handleLoadButtonAction(ActionEvent event) {
        shop = new Shop();
        shopDBUtils = new ShopDBUtils();
        listOfShopData = shopDBUtils.fetchData();
        if ((listOfShopData) != null) {
            colId.setCellValueFactory(new PropertyValueFactory<>("id"));
            colProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
            colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
            colDiscountPercentage.setCellValueFactory(new PropertyValueFactory<>("discountPercentage"));
            colEntryName.setCellValueFactory(new PropertyValueFactory<>("codePrice"));
            colCodePrice.setCellValueFactory(new PropertyValueFactory<>("entryName"));

            tblShopData.setItems(listOfShopData);
            System.out.println("Loaded");
        } else {
            System.out.println("No Data Found");
        }
    }

    @FXML
    private void handleDeleteButtonAction(ActionEvent event) {
        shop = new Shop();
        shopDBUtils = new ShopDBUtils();
        String name = txtName.getText();
        if (shopDBUtils.deleteShopData(name)) {
            System.out.println("Shop data deleted successfull");
            clear();
            handleLoadButtonAction(event);
        } else {
            System.out.println("Not deleted");
        }

    }

    @FXML
    private void handleClearButtonAction(ActionEvent event) {
        clear();
    }

    @FXML
    private void handleMouseClickAction(MouseEvent event) {
        showTableDataonFields();
    }

    private void clear() {
        txtId.clear();
        txtName.clear();
        txtCodePrice.clear();
        txtDiscountPercentage.clear();
        txtPrice.clear();
        txtEntryName.clear();
    }

    private void showTableDataonFields() {
        Shop shop = (Shop) tblShopData.getSelectionModel().getSelectedItem();
        txtId.setText("" + shop.getId());
        txtName.setText(shop.getProductName());
        txtPrice.setText("" + shop.getPrice());
        txtDiscountPercentage.setText("" + shop.getDiscountPercentage());
        txtEntryName.setText(shop.getEntryName());
        txtCodePrice.setText(shop.getCodePrice());
    }

}
