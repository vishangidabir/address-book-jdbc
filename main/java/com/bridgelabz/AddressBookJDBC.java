package com.bridgelabz;

import java.sql.*;

public class AddressBookJDBC {
    public static void main(String[] args) throws SQLException {
        System.out.println("~~~Welcome to Address Book Program on JDBC~~~");
        String jdbcURL = "jdbc:mysql://localhost:3307/address_book_service?useSSL=false";
        String userName = "root";
        String passWord = "1234";
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");
            System.out.println("Connecting to database :" + jdbcURL);
            connection = DriverManager.getConnection(jdbcURL, userName, passWord);
            System.out.println("Connection is successful!!!!" + connection);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select count(*) from address_book_service.address_book where state='Kerala'");
            while (resultSet.next()) {
                System.out.println("Kerala city count in address Book :" + resultSet.getInt(1));
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            connection.close();
        }
    }
}
