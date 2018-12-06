package com.meng.productservice;

import ch.qos.logback.core.util.TimeUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Value("${server.port}")
    private String port;

    @RequestMapping("getProduct")
    public String getPort(@RequestParam("id")String productId) throws Exception {
        Random random = new Random();
        int i = (int) (Math.random() * 3)+1;
        boolean b = random.nextBoolean();
        if(i==1){
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else if(i == 2){

                throw new Exception();

        }
        return productId+ "||"+port;
    }
}
