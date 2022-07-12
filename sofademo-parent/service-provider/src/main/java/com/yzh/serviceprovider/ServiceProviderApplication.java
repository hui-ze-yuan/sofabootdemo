package com.yzh.serviceprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication(scanBasePackages ={"com.yzh.common","com.yzh.serviceprovider"})
@Import({
        //这里就是填写需要装载的类
        com.yzh.common.entity.Book.class
})
public class ServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderApplication.class, args);
    }

}
