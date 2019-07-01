
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricshopmanagement;

import electricshopmanagement.ElectricShopManagement;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**~``
 *
 * @author ANITA
 */
public class ElectricShopManagement extends Application {
    //The entry point for JavaFX applications is the Application class
    @Override
    public void start(Stage stage) throws IOException {
       Parent root =FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
         Scene scene=new Scene(root);
         stage.setScene(scene);
         stage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //the launcher loads and initializes the specifie Application class on the JavaFX Application Thread
       //i.e an instance of the Application is then constructed on the JavaFX Application Thread
        launch(args);
    }
    
}
