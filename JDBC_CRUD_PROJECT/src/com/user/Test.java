package com.user;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Test {
    // Create a Scanner object for user input
    Scanner s = new Scanner(System.in);

    // Method for selling a product and inserting it into the database
    public void sell(Connection con) throws Exception {
        // Prompt the user to enter product details
        System.out.println("Enter id here: ");
        int id = s.nextInt();
        System.out.println("Enter product name: ");
        String nm = s.next();
        System.out.println("Enter price: ");
        int price = s.nextInt();
        System.out.println("Enter category: ");
        String cat = s.next();
        System.out.println("Enter quantity: ");
        int quantity = s.nextInt();

        // SQL query to insert data into the 'product' table
        String insertData = "INSERT INTO product VALUES(?,?,?,?,?)";
        // Create a PreparedStatement to execute the query
        PreparedStatement psi = con.prepareStatement(insertData);
        // Set the values for the parameters in the SQL query
        psi.setInt(1, id);
        psi.setString(2, nm);
        psi.setInt(3, price);
        psi.setString(4, cat);
        psi.setInt(5, quantity);
        // Execute the insert query
        psi.executeUpdate();
        // Close the PreparedStatement
        psi.close();
        // Print a message indicating that data has been inserted into the database
        System.out.println("Data inserted into the database");
    }

    // Method for buying a product from the database
    public void buy(Connection con) throws Exception {
        // SQL query to retrieve all products from the 'product' table
        String retrieve = "SELECT * FROM product";
        // Create a PreparedStatement to execute the query
        PreparedStatement ps = con.prepareStatement(retrieve);
        // Execute the query and get the result set
        ResultSet rs = ps.executeQuery();

        // Loop through the result set and display product details
        while (rs.next()) {
            System.out.println("Product id: " + rs.getInt(1));
            System.out.println("Product name: " + rs.getString(2));
            System.out.println("Product price: " + rs.getInt(3));
            System.out.println("Product category: " + rs.getString(4));
            System.out.println("Product Quantity: " + rs.getInt(5));
            System.out.println("____________________________________________");
        }

        // Prompt the user to enter the id of the product they want to buy
        System.out.println("Enter id of the product you want to buy");
        int i = s.nextInt();

        // SQL query to retrieve only the 'id' column from the 'product' table
        String retrieveSingle = "SELECT id FROM product";
        // Create a PreparedStatement to execute the query
        PreparedStatement ps1 = con.prepareStatement(retrieveSingle);
        // Execute the query and get the result set
        rs = ps1.executeQuery();

        // Flag to check if the entered id is valid
        boolean flag = false;

        // Loop through the result set to check if the entered id exists
        while (rs.next()) {
            if (i == rs.getInt(1)) {
                // If the id exists, create a SQL query to delete the product with the given id
                String deleteData = "DELETE FROM product WHERE id=?";
                // Create a PreparedStatement to execute the delete query
                PreparedStatement deleteStatement = con.prepareStatement(deleteData);
                // Set the parameter value for the id
                deleteStatement.setInt(1, i);
                // Execute the delete query
                deleteStatement.executeUpdate();
                // Set the flag to true
                flag = true;
                // Close the PreparedStatement
                deleteStatement.close();
                // Break out of the loop
                break;
            }
        }

        // Check the flag and print a message accordingly
        if (flag) {
            System.out.println("Congrats! You added one product");
        } else {
            System.out.println("You entered the wrong id");
        }
    }

    // Method for updating product information in the database
    public void updateProduct(Connection con) throws Exception {
        // Prompt the user to enter product ID for update
        System.out.println("Enter the product ID you want to update: ");
        int updateId = s.nextInt();

        // Prompt the user to choose what to update
        System.out.println("Choose what to update:");
        System.out.println("1. Update product name");
        System.out.println("2. Update product price");
        System.out.println("3. Update product category");
        System.out.println("4. Update product quantity");
        int updateChoice = s.nextInt();

        String columnName = "";
        String newValue = "";

        switch (updateChoice) {
            case 1:
                System.out.println("Enter the new product name: ");
                columnName = "name";
                newValue = s.next();
                break;
            case 2:
                System.out.println("Enter the new product price: ");
                columnName = "price";
                newValue = Integer.toString(s.nextInt());
                break;
            case 3:
                System.out.println("Enter the new product category: ");
                columnName = "category";
                newValue = s.next();
                break;
            case 4:
                System.out.println("Enter the new product quantity: ");
                columnName = "quantity";
                newValue = Integer.toString(s.nextInt());
                break;
            default:
                System.out.println("Invalid choice. No updates performed.");
                return;
        }

        // SQL query to update product information
        String updateData = "UPDATE product SET " + columnName + " = ? WHERE id = ?";
        PreparedStatement updateStatement = con.prepareStatement(updateData);
        updateStatement.setString(1, newValue);
        updateStatement.setInt(2, updateId);

        // Execute the update query
        int rowsAffected = updateStatement.executeUpdate();

        // Check if any rows were affected
        if (rowsAffected > 0) {
            System.out.println("Product information updated successfully.");
        } else {
            System.out.println("No product found with the provided ID. Update failed.");
        }

        // Close the PreparedStatement
        updateStatement.close();
    }

    // Method for displaying the product table
    public void displayProductTable(Connection con) throws Exception {
        // SQL query to retrieve all products from the 'product' table
        String retrieveAll = "SELECT * FROM product";
        // Create a PreparedStatement to execute the query
        PreparedStatement retrieveAllStatement = con.prepareStatement(retrieveAll);
        // Execute the query and get the result set
        ResultSet allProductsResultSet = retrieveAllStatement.executeQuery();

        // Display the table header
        System.out.println("Product Table:");
        System.out.println("ID\tName\tPrice\tCategory\tQuantity");
        System.out.println("____________________________________________");

        // Loop through the result set and display all product details
        while (allProductsResultSet.next()) {
            System.out.println(
                allProductsResultSet.getInt(1) + "\t" +
                allProductsResultSet.getString(2) + "\t" +
                allProductsResultSet.getInt(3) + "\t" +
                allProductsResultSet.getString(4) + "\t" +
                allProductsResultSet.getInt(5) 
            );
            System.out.println("____________________________________________");
        }

        // Close the PreparedStatement and ResultSet
        retrieveAllStatement.close();
        allProductsResultSet.close();
    }

    // Method for retrieving and displaying all products from the database
    public void retrieveAllProducts(Connection con) throws Exception {
        // SQL query to retrieve all products from the 'product' table
        String retrieveAll = "SELECT * FROM product";
        // Create a PreparedStatement to execute the query
        PreparedStatement retrieveAllStatement = con.prepareStatement(retrieveAll);
        // Execute the query and get the result set
        ResultSet allProductsResultSet = retrieveAllStatement.executeQuery();

        // Loop through the result set and display all product details
        while (allProductsResultSet.next()) {
            System.out.println("Product id: " + allProductsResultSet.getInt(1));
            System.out.println("Product name: " + allProductsResultSet.getString(2));
            System.out.println("Product price: " + allProductsResultSet.getInt(3));
            System.out.println("Product category: " + allProductsResultSet.getString(4));
            System.out.println("Product Quantity: " + allProductsResultSet.getInt(5));
            System.out.println("____________________________________________");
        }

        // Close the PreparedStatement and ResultSet
        retrieveAllStatement.close();
        allProductsResultSet.close();
    }

    // Main method where the program starts
    public static void main(String[] args) throws Exception {
        // Create a Scanner object for user input
        Scanner s = new Scanner(System.in);
        // Create an instance of the Test class
        Test t = new Test();

        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Establish a connection to the database
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cashify", "root", "Root@123");

        // Display a menu in a loop for user interaction
        while (true) {
            System.out.println("Menu***********************");
            System.out.println("1. Sell your product\n2. Buy your product\n3. Update your product\n4. Display Product Table\n5. Retrives");
            System.out.println("Enter your choice?");
            // Read the user's choice
            int ch = s.nextInt();

            // Switch statement to perform actions based on the user's choice
            switch (ch) {
                case 1:
                    // Call the sell method to sell a product
                    t.sell(con);
                    break;

                case 2:
                    // Call the buy method to buy a product
                    t.buy(con);
                    break;

                case 3:
                    // Call the updateProduct method to update a product
                    t.updateProduct(con);
                    break;

                case 4:
                    // Call the displayProductTable method to display the product table
                    t.displayProductTable(con);
                    break;

                case 5:
                    // Call the retrieveAllProducts method to display all products
                    t.retrieveAllProducts(con);
                    break;

                case 0:
                    System.out.println("Exiting the program.");
                    System.exit(0);

                default:
                    // Print a message for an invalid choice
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}
