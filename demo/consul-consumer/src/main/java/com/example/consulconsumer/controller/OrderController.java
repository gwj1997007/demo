package com.example.consulconsumer.controller;


import com.example.common.pojo.JsonResult;
import com.example.common.pojo.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;
    private static  final String host="http://zookeeper-provider:8081/";

    @GetMapping("/get/{id}")
    public JsonResult<Payment> getPaymentById(@PathVariable Long id) {
        return  restTemplate.getForObject(host + "payment/get/"+id, JsonResult.class);

    }
    @PostMapping("/post")
    public JsonResult<Payment> postPayment(@RequestBody Payment payment) {
       return  restTemplate.postForObject(host + "payment/post", payment, JsonResult.class);
    }

}