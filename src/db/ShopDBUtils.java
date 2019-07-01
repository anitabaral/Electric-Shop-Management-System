/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author anita
 */
import entity.Shop;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ShopDBUtils {

    //it sends SQL statements to the database
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Connection connection = DatabaseConnector.databaseConnector();
    ObservableList<Shop> listOfShopItems = FXCollections.observableArrayList();

    public boolean saveShopData(Shop shop) throws SQLException {
        if (connection != null) {
            String query = "INSERT INTO productDetails(productName,productPrice,productDiscountPercentage,productCodePrice,productEntryName) VALUES (?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, shop.getProductName());
            preparedStatement.setInt(2, shop.getPrice());
            preparedStatement.setInt(3, shop.getDiscountPercentage());
            preparedStatement.setString(4, shop.getCodePrice());
            preparedStatement.setString(5, shop.getEntryName());
            preparedStatement.execute();
            connection.close();
            return true;
        }
        return false;
    }

    public ObservableList<Shop> fetchData() {
        try {
            String query = "SELECT * FROM productDetails";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery(query);

            while (resultSet.next()) {
                Integer id = resultSet.getInt("productId");
                String productName = resultSet.getString("productName");
                Integer price = resultSet.getInt("productPrice");
                Integer discountPercentage = resultSet.getInt("productDiscountPercentage");
                String codePrice = resultSet.getString("productCodePrice");
                String entryName = resultSet.getString("productEntryName");
                Shop shop = new Shop(id, productName, price, discountPercentage, codePrice, entryName);
                listOfShopItems.add(shop);

                System.out.println(id + " " + productName + " " + price + " " + discountPercentage + " " + codePrice + " " + entryName);

            }
            return listOfShopItems;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateData(Shop shop) throws SQLException {
        System.out.println("gsgsfsd");

        if (connection != null) {
            String query = "UPDATE productDetails Set productName=?,productPrice=?,productDiscountPercentage=?,productCodePrice=?,productEntryName=? WHERE productId=?";
            preparedStatement = connection.prepareStatement(query);
            //resultSet = preparedStatement.executeQuery(query);
            preparedStatement.setString(1, shop.getProductName());
            preparedStatement.setInt(2, shop.getPrice());
            preparedStatement.setInt(3, shop.getDiscountPercentage());
            preparedStatement.setString(4, shop.getCodePrice());
            preparedStatement.setString(5, shop.getEntryName());
            preparedStatement.setInt(6, shop.getId());
            preparedStatement.executeUpdate();
            connection.close();
            return true;

        }
        return false;

    }

    public boolean deleteShopData(String name) {
        try {
            if (connection != null) {
                String query = "DELETE FROM productDetails Where productName=?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, name);
                preparedStatement.executeUpdate();
                return true;

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR");
        }
        return false;
    }

}
