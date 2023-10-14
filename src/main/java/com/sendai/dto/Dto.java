package com.sendai.dto;
import java.util.List;

import com.sendai.dto.customerDAO.CustomerApiDAO;
import com.sendai.dto.customerDAO.CustomerApiUrl;
import com.sendai.dto.customerDAO.CustomerBDDAO;

/**
 * @author sesv
 */
public class Dto {

  public static void main(String[] args) {
    GetCustomerDTO customers = new GetCustomerDTO();
	
		/* 
		List<CustomerDTO> customerdto = customers.customerlist();
	
		for(CustomerDTO cdto : customerdto){
			System.out.println(cdto.getId());
			System.out.println(cdto.getFullName());
			System.out.println(cdto.getCountry());
		}
		*/
		
		//customers.customerList();
		//customers.customer(1);

		CustomerBDDAO customerBD = new CustomerBDDAO();
		CustomerDTO customerdata = customerBD.getCustomer(2);
		System.out.println(customerdata.toString());

		System.out.println("************************");
		
		/* 
		GetCustomer datos = new GetCustomer();
		try {
			System.out.println(datos.apiRequest());
		} catch (Exception e){
			e.printStackTrace();
		}
		*/
	
  }
}
