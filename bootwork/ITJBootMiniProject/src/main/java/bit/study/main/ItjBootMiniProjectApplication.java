package bit.study.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"boot.study.*","naver.cloud"})
@MapperScan({"boot.study.mapper"})
public class ItjBootMiniProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItjBootMiniProjectApplication.class, args);
    }

}
