package com.pro.msay;

import com.pro.msay.domain.Timestamped;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableCaching // 캐시기능 활성화

public class MsayApplication extends Timestamped {

    public static void main(String[] args) {
        SpringApplication.run(MsayApplication.class, args);
    }

}
