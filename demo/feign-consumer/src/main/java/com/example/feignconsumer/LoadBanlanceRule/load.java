package com.example.feignconsumer.LoadBanlanceRule;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 思路：
 * <p>
 * 访问的服务实例下标数=初始为0的值累加%服务实例总数
 * 根据下标数从服务实例中获取
 */
@Component
public class load implements LoadBalance {


    AtomicInteger item = new AtomicInteger(0);

    //获取每次值加一
    /*
        获取每次访问的服务实例下标
     */
    public int getindex() {
        int current;
        int except;
        //利用自旋锁，cas
        do {
            //获取当前值
            current = item.get();

            //当到达最大之后从0开始,每次加1
            except = current >= Integer.MAX_VALUE ? 0 : current + 1;

        } while (!item.compareAndSet(current, except));
        //比较AutomicInteger主内存中的值与线程A中的current（拷贝值）做比较，如果相同返回true,并将值修改
        //cas只能保证一个共享变量的原子性，循环往复可能会引起内存开销大，并引起ABA问题 AtomicStampedReference 提供了根据版本号判断的实现，可以解决一部分问题。
        return except;
    }


    @Override
    public ServiceInstance getServerInstance(List<ServiceInstance> instances) {

        int index = getindex() % instances.size();
        //从实例列表中获取下标
        return instances.get(index);
    }
}
