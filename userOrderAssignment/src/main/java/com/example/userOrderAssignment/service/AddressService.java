package com.example.userOrderAssignment.service;

import com.example.userOrderAssignment.model.Address;
import com.example.userOrderAssignment.repository.AddressRepository;
import com.example.userOrderAssignment.repository.UserRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    UserRepository userRepository;

    public int saveAddress(String address){
        Address newAddress=new Address();
        JSONObject json=new JSONObject(address);
        newAddress.setZipcode(json.getString("zipcode"));
        newAddress.setUserId(userRepository.findById(json.getInt("userId")).get());
        newAddress.setState(json.getString("state"));
        newAddress.setPhoneNumber(json.getString("phoneNumber"));

        addressRepository.save(newAddress);
        return newAddress.getAddressId();
    }
}
