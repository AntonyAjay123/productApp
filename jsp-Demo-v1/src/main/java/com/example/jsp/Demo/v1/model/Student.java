package com.example.jsp.Demo.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

@Data
@AllArgsConstructor
public class Student {
    String firstName;
    String lastName;

    String country;
    LinkedHashMap<String,String> countryOptions;

    String faveLang;

    ArrayList<String> os;
    public Student(){
        countryOptions=new LinkedHashMap<>();
        countryOptions.put("BR","BRAZIL");
        countryOptions.put("IND","INDIA");
        countryOptions.put("FR","FRANCE");
    }
}
