package com.example.feignconsumer.controller;

import com.example.common.pojo.JsonResult;
import com.example.common.pojo.Payment;
import com.example.feignconsumer.LoadBanlanceRule.LoadBalance;
import com.example.feignconsumer.service.paymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 负载均衡+熔断降级
 */
@RestController
@RequestMapping("/feign")
public class PaymentController {
    @Autowired
    private paymentService paymentService;

    //根据实例来做轮询的接口
    @Autowired
    private LoadBalance loadBalance;

    //获取实力服务
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "GetPaymentException", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "6000")})
    public JsonResult GetPayment(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @HystrixCommand(fallbackMethod = "GetPaymentException", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "6000")})
    public JsonResult GetPayment(@RequestBody Payment payment) {
        return paymentService.insertPayment(payment);
    }

    @GetMapping("/getInstance")
    public String getInstance(){
        //根据eureka提供的发现功能
        List<ServiceInstance> instances = discoveryClient.getInstances("feign-provider");
        //调用接口中的方法,参数为服务的实例列表
        int port = loadBalance.getServerInstance(instances).getPort();
        System.out.println(port);
        return "new String"+port;
    }

    public JsonResult GetPaymentException(Long id) {
        return new JsonResult(404, "访问异常");
    }
}
