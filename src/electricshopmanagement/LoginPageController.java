/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricshopmanagement;

import common.Common;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ANITA
 */
public class LoginPageController implements Initializable {

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnLogin;
    Common common;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        ObservableList<String> list=FXCollections.observableArrayList("Admin");
//        comboBox.setItems(list);
    }

    @FXML
    private void handleLoginButtonPressed(ActionEvent event) throws IOException {
        System.out.println("Hi");
        if (txtUsername.getText().equals("admin")) {
            if (txtPassword.getText().equals("admin")) {
                common = new Common();
                common.nextStage("/adminpage/AdminPage.fxml", "AdminPage Window", true);
                Stage current = (Stage) txtUsername.getScene().getWindow();
                current.hide();
                System.out.println("Login Successful");
            }
            System.out.println("NO2");
        }
        System.out.print("No1");

    }

}
