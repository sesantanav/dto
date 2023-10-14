/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sendai.dto;

/**
 *
 * @author sesv
 */
public class CustomerDTO {
	private int id;
	private String fullname;
	private String country;
	private String address;
	private String cp;
	private String date;
    
    // setters
	public void setId(int id){
		this.id = id;
	}
	public void setFullName(String fullname){
		this.fullname = fullname;
	}
    public void setCountry(String country){
        this.country = country;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setCP(String cp){
        this.cp = cp;
    }
    public void setDate(String date){
        this.date = date;
    }
    // Getters
    public int getId(){
		return this.id;
	}
	public String getFullName(){
		return this.fullname;
	}
    public String getCountry(){
        return this.country;
    }
    public String getAddress(){
        return this.address;
    }
    public String getCP(){
       return this.cp;
    }
    public String getDate(){
        return this.date;
    }
    
    public CustomerDTO(int id, String fullname, String country, String address, 
                       String cp, String date){
        super();
        this.id = id;
        this.fullname = fullname;
        this.country = country;
        this.address = address;
        this.cp = cp;
        this.date = date;
    }
    public CustomerDTO(){}

    @Override
    public String toString(){
        return  "Customer: " + this.id + "\n" +
                "Fullname: " + this.fullname + "\n" + 
                "Country: " + this.country + "\n" +
                "Address: " + this.address + "\n" +
                "Postal Code : " + this.cp + "\n" +
                "Date: " + this.date + "\n" 
                ;
    }
}
