package com.yuper.mallspringboot;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MallspringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallspringbootApplication.class, args);
    }

}
