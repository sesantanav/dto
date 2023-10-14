package com.sendai.dto.customerDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sendai.dto.CustomerDTO;

public class CustomerBDDAO {
  private Connection con;
  
  public CustomerBDDAO(){
    try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/northwind?autoReconnect=true&useSSL=false", "arquitectura", "123456");
    }catch (Exception e){
      e.printStackTrace();
    }
  }
  public CustomerDTO getCustomer(int id){
    CustomerDTO customer = new CustomerDTO();
    try {
      // String sql = "select id, from Customer where id =?";
      String sql = "call sp_selectcustomer(?)";
      PreparedStatement stmt = con.prepareStatement(sql);

      stmt.setInt(1, id);
      ResultSet rs = stmt.executeQuery();
      // System.out.println(rs.getString("fullname"));
      if (rs.next()){
        customer = new CustomerDTO(rs.getInt("id"),rs.getString("fullname")
          ,rs.getString("country_region"),rs.getString("address")
          ,rs.getString("zip_postal_code"),rs.getString("date_now"));
      }
    } catch (Exception e){
      e.printStackTrace();
    }
    return customer;
  } 

  public List<CustomerDTO> getCustomers(){
    List<CustomerDTO> customers = new ArrayList<CustomerDTO>();
    try {
      String sql = "call sp_selectcustomers";
      PreparedStatement stmt = con.prepareStatement(sql);

      ResultSet rs = stmt.executeQuery();
      while(rs.next()){
        CustomerDTO temp = getCustomer(rs.getInt("id"));
        customers.add(temp);
      }
    } catch (Exception e){
      e.printStackTrace();
    }
    return customers;
  }
}
