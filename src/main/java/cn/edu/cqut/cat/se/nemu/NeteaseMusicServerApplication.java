package cn.edu.cqut.cat.se.nemu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.edu.cqut.cat.se.nemu.mapper")
@SpringBootApplication
public class NeteaseMusicServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NeteaseMusicServerApplication.class, args);
    }

}
