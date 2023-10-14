package com.sendai.dto;
import java.util.ArrayList;
import java.util.List;

import com.sendai.dto.customerDAO.CustomerApiDAO;

/**
 * @author sesv
 * @version 1.1
 */
public class GetCustomerDTO{

    public void customerList(){
        try {
            CustomerApiDAO customerApiDao = new CustomerApiDAO();
            List<CustomerDTO> customers = customerApiDao.syncCustomersDAO();
            for (CustomerDTO crDTO : customers){
                System.out.println(crDTO.toString());
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public void customer(int id){
        try {
            CustomerApiDAO customerApiDAO = new CustomerApiDAO();
            CustomerDTO customer = customerApiDAO.syncCustomersDAO(id);
            System.out.println(customer.toString());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<CustomerDTO> customerlist(){
        List<CustomerDTO> customers = new ArrayList<CustomerDTO>();
        customers.add(new CustomerDTO(1, "Juan Perez", "Chile", 
            "San Fernando","30700","20231006"));
        customers.add(new CustomerDTO(2, "Nicanor Parra", "Chile", 
            "San Fernando","30700","20231006"));
        customers.add(new CustomerDTO(3, "Andres Ponce", "Chile", 
            "San Fernando","30700","20231006"));
        return customers;
    }
    
}
