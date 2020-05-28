/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 *
 * @author Danny
 */
public class Dbproject {

    static final String DB_URL ="jdbc:mysql://localhost:3306/car_rental";
    static final String DB_DRV ="com.mysql.cj.jdbc.Driver";
    static final String DB_USER = "root";
    static final String DB_PASSWD = "password";
    
    public static void main(String[] args) throws SQLException{
        String pathToConnector = "com.mysql.cj.jdbc.Driver";
        try
        {
            Class.forName(pathToConnector);
            //System.out.println("Connector Loaded Succesfully");
        }
        catch (ClassNotFoundException ex)
        {
            //System.out.println("Connector not loaded");
            System.out.println(ex.getMessage());
        }
        
        Connection connection = null;
        Statement statement = null;
        Statement state = null;
        ResultSet resultSet = null;
        ResultSet result = null;
        PreparedStatement preparedStatement = null;
        Scanner number = new Scanner(System.in);
      
        //GUI MENU
        System.out.println("WELCOME TO THE CAR RENTAL 2019");
        System.out.println("What would you like to do?");
        System.out.println("(1) Add information about a new customer.");
        System.out.println("(2) Add information about a new vehicle.");
        System.out.println("(3) Add information about a new rental reservation.");
        System.out.println("(4) Information from return of a rented car.");
        System.out.println("(5) View results.");
        System.out.print("Enter the number: ");
        
        try
        {
            connection=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            //System.out.println("Connected to database.");
            
            int num = number.nextInt();
            if(num==1)
            {
                Scanner input = new Scanner(System.in);
                System.out.print("What is your name?: ");
                String username = input.nextLine();
                
                System.out.print("What is your phone number? (xxx)xxx-xxxx: ");
                String userphone = input.nextLine();
                
                String sql = "INSERT INTO CUSTOMER (Name, Phone)" 
                        + "VALUES (?, ?)";
                preparedStatement = connection.prepareStatement(sql);
                
                //set param values
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, userphone);
                
                //execute query
                int i = preparedStatement.executeUpdate(); 
            
                if(i!=0)
                {
                    System.out.println("Records succesfully inserted.");
                }
                else
                {
                    System.out.println("Error adding records.");
                }
            }
            else if(num==2)
            {
                Scanner info = new Scanner(System.in);
                System.out.print("What is the VehicleID?: ");
                String vid = info.nextLine();
                
                System.out.print("What is the vehicle description? ex; (Acura ILX): ");
                String desc = info.nextLine();
                
                System.out.print("What is the vehicle year?: ");
                Integer year = info.nextInt();
                
                System.out.print("What is the type of the vehicle? (Enter a number (1-6)): ");
                Integer type = info.nextInt();
                
                System.out.print("What is the category of the vehicle? (Enter a number (0-1)) ");
                Integer category = info.nextInt();
                
                String sql = "INSERT INTO VEHICLE (VehicleID, Description, Year, Type, Category)" 
                        + "VALUES (?, ?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(sql);
                
                //set param values
                preparedStatement.setString(1, vid);
                preparedStatement.setString(2, desc);
                preparedStatement.setInt(3, year);
                preparedStatement.setInt(4, type);
                preparedStatement.setInt(5, category);
                
                //execute query
                int i = preparedStatement.executeUpdate(); 
            
                if(i!=0)
                {
                    System.out.println("Records succesfully inserted.");
                }
                else
                {
                    System.out.println("Error adding records.");
                }
            }
            else if(num==3)
            {
                Scanner info = new Scanner(System.in);
                
                System.out.print("What would you like the start date of the rental to be?: ");
                String startdate = info.nextLine();
                
                System.out.print("What would the return date of the rental be?: ");
                String returndate = info.nextLine();
                
                System.out.print("What kind of rental type are you looking for? (enter (1 or 7)): ");
                Integer rentaltype = info.nextInt();
                
                System.out.print("Do you want to pay on the order date or return date? (enter (1 for order date and 2 for return date)): ");
                Integer pay = info.nextInt();
                
                String sql = "INSERT INTO RENTAL (StartDate, ReturnDate, RentalType, PaymentDate)" 
                        + "VALUES (?, ?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(sql);
                
                //set param values
                preparedStatement.setString(1, startdate);
                preparedStatement.setString(2, returndate);
                preparedStatement.setInt(3, rentaltype);
                preparedStatement.setInt(4, pay);
                
                String query = "SELECT * FROM VEHICLE V, RENTAL R WHERE V.VehicleID = R.VehicleID";
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(query);
                while(rs.next())
                {
                    int type = rs.getInt("V.Type");
                    int category = rs.getInt("V.Category");
                    String vid = rs.getString("V.Vehicle");
                    System.out.println("Available cars to rent: " + vid + " Type: " + type + " Category: " + category);
                   
                }
                
                //execute query
                int i = preparedStatement.executeUpdate(); 
            
                if(i!=0)
                {
                    System.out.println("Records succesfully inserted.");
                }
                else
                {
                    System.out.println("Error adding records.");
                }
            }
            else if(num==4)
            {
                Scanner info = new Scanner(System.in);
                
                System.out.print("Enter the VehicleID to view the amount due: ");
                String vid = info.nextLine();
                
                String query = "SELECT * FROM RENTAL R, VEHICLE V , CUSTOMER C WHERE R.VehicleID = V.VehicleID and R.CustID = C.CustID";
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(query);
                while(rs.next())
                {
                    int totalamount = rs.getInt("R.TotalAmount");
                    String returndate = rs.getString("R.ReturnDate");
                    String name = rs.getString("C.Name");
                    String sql = "UPDATE RENTAL (TotalAmount)" 
                        + "VALUES (?)";
                    preparedStatement = connection.prepareStatement(sql);
                
                    //set param values
                    preparedStatement.setInt(1, totalamount);
                    System.out.println("Total payment due for rental: " +totalamount);
                    System.out.println("Return date: " + returndate + " Customer name: " + name);
                    
                }
            }
            else
            {
                String query = "SELECT * FROM vRentalInfo";
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(query);
                
                System.out.print("Would you like to filter search the database? (1 for no and 2 for yes): ");
                Scanner info = new Scanner(System.in);
                Integer ans = info.nextInt();
                if(ans==1)
                {
                    while(rs.next())
                    {
                        Integer cid = rs.getInt("CustomerID");
                        String cname = rs.getString("CustomerName");
                        Integer orderamt = rs.getInt("OrderAmount");
                        String vin = rs.getString("VIN");
                        String desc = rs.getString("VEHICLE");

                        System.out.println("CustID: " + cid + ", Customer Name: "+cname+ ", Balance: $" +orderamt+ ", VIN: "+vin+ ", Description: "+desc);
                    }
                }
                else
                {
                    while(rs.next())
                    {
                        System.out.print("Enter customer ID or VIN to search: ");
                        Integer data = info.nextInt();
                        System.out.print("Enter name or description to search: ");
                        String search = info.nextLine();
                        String sql = "SELECT * FROM vRentalInfo WHERE CustomerID LIKE '"+data+"' OR VIN LIKE'"+data+" OR Description LIKE'"+search+" OR CustomerName LIKE'"+search+"";
                        Statement sts = connection.createStatement();
                        ResultSet rss = sts.executeQuery(sql);
                        Integer cid = rss.getInt("CustomerID");
                        String cname = rss.getString("CustomerName");
                        Integer orderamt = rss.getInt("OrderAmount");
                        String vin = rss.getString("VIN");
                        String desc = rss.getString("VEHICLE");
                        System.out.println("CustID: " + cid + ", Customer Name: "+cname+ ", Balance: $" +orderamt+ ", VIN: "+vin+ ", Description: "+desc);
                        
                    }
                }
            }
        }
        catch(SQLException ex)
        {
        }
    }   
}
