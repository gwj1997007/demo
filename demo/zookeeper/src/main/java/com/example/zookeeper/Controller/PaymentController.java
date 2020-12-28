package com.example.zookeeper.Controller;

import com.example.common.pojo.JsonResult;
import com.example.common.pojo.Payment;
import com.example.zookeeper.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String port;

    @GetMapping("/get/{id}")
    public JsonResult<Payment> getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.GetPaymentById(id);
        if (payment != null) {
            return new JsonResult<Payment>(200, "成功", payment);
        } else {
            return new JsonResult<>(404, "失败");
        }
    }
    @PostMapping("/post")
    public JsonResult<Payment> postPayment(@RequestBody Payment payment) {
        int rows = paymentService.createPayment(payment);
        if (rows !=0) {
            return new JsonResult<Payment>(200, "成功", payment);
        } else {
            return new JsonResult<>(404, "失败");
        }
    }
    @GetMapping("/get/zk")
    public String getZookeeper(){
        return port+ UUID.randomUUID().toString();
    }

}