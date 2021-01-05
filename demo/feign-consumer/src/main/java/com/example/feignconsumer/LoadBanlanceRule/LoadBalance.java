package com.example.feignconsumer.LoadBanlanceRule;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

/**
 * 手写负载均衡算法
 * 接口
 */
public interface LoadBalance {
    //获取实例信息
    ServiceInstance getServerInstance(List<ServiceInstance> instances);

}
