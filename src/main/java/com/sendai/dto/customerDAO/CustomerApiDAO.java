package com.sendai.dto.customerDAO;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import com.sendai.dto.CustomerDTO;
import java.util.List;
/*
 * Obtener información de los clientes usando librería gson
 */
public class CustomerApiDAO {
  // ObjectMapper objectMapper = new ObjectMapper();
  Gson gson = new GsonBuilder().create();

  // metodo que devuelve el json
  public String apiRequest() throws Exception {
    HttpClient cliente = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create("http://localhost/northwindapi/customersapi.php"))
    .build();

    HttpResponse<String> response = cliente.send(request, BodyHandlers.ofString());

    return response.body();
  }

  // Retornar una lista de clientes
  public List<CustomerDTO> syncCustomersDAO() throws Exception {
    String response = apiRequest();

    List<CustomerDTO> customerDTO = gson.fromJson(response, new TypeToken<List<CustomerDTO>>(){
    }.getType());

    return customerDTO;
  }
  // Retorna un customer por id
  public CustomerDTO syncCustomersDAO(int id) throws Exception {
    String response = apiRequest();

    List<CustomerDTO> customerDTO = gson.fromJson(response, new TypeToken<List<CustomerDTO>>(){
    }.getType());

    return customerDTO.get(id);
  }

  // Retorno de una lista asincrona
  public CustomerDTO asyncCustomerDAO() throws Exception {
    HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create("http://localhost/northwindapi/customersapi.php"))
    .build();

    CustomerApiDAO customerApiDAO = new CustomerApiDAO();

    List<CustomerDTO> customerDTO = HttpClient.newHttpClient()
      .sendAsync(request, BodyHandlers.ofString())
      .thenApply(HttpResponse::body)
      .thenApply(customerApiDAO::readValueCustomerDTO)
      .get();

    return customerDTO.get(1);
  }

  List<CustomerDTO> readValueCustomerDTO(String content){
    return gson.fromJson(content, new TypeToken<List<CustomerDTO>>(){
    }.getType());
  }

}
