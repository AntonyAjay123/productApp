package com.example.userOrderAssignment.service;

import com.example.userOrderAssignment.model.Address;
import com.example.userOrderAssignment.model.Order;
import com.example.userOrderAssignment.model.Product;
import com.example.userOrderAssignment.model.User;
import com.example.userOrderAssignment.repository.AddressRepository;
import com.example.userOrderAssignment.repository.OrderRepository;
import com.example.userOrderAssignment.repository.ProductRepository;
import com.example.userOrderAssignment.repository.UserRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    public int saveOrder(String order){
        JSONObject json = new JSONObject(order);
        Order newOrder = new Order();
        Address address = addressRepository.findById(json.getInt("addressId")).get();
        User user = userRepository.findById(json.getInt("userId")).get();
        Product product=productRepository.findById(json.getInt("productId")).get();
        newOrder.setAddressId(address);
        newOrder.setProductId(product);
        newOrder.setUserId(user);
        newOrder.setProductQuantity(json.getInt("productQuantity"));
        orderRepository.save(newOrder);
        return newOrder.getOrderId();
    }
    public JSONArray findAll(){
        List<Order> orders = orderRepository.findAll();
        JSONArray jsonArray = new JSONArray();
        for(Order order:orders){
            JSONObject json = new JSONObject();
            json.put("productId",order.getProductId().getProductId());
            json.put("userId",order.getUserId().getUserId());
            json.put("addressId",order.getAddressId().getAddressId());
            json.put("productQuantity",order.getProductQuantity());
            json.put("orderId",order.getOrderId());
            jsonArray.put(json);
        }
        return jsonArray;
    }

    public JSONObject findById(int id){
        Order order = orderRepository.findById(id).get();
        return new JSONObject(order);
    }
}
