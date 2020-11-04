package cn.edu.cqut.cat.se.nemu;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("cn.edu.cqut.cat.se.nemu.mapper")
@SpringBootApplication
@EnableScheduling
public class NeteaseMusicServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NeteaseMusicServerApplication.class, args);
    }
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
