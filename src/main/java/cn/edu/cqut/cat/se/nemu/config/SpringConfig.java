package cn.edu.cqut.cat.se.nemu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import java.io.File;

/**
 * 自定义配置静态资源配置
 */
@Configuration
public class SpringConfig implements WebMvcConfigurer {

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/" };

//    @Autowired
//    private HttpInterceptor httpInterceptor;

    //释放静态资源
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //项目的文件夹绝对路径
        String dir = System.getProperty("user.dir");
        registry.addResourceHandler("/**")
                .addResourceLocations("file:" + dir + File.separator + "media" + File.separator)
                .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

    //配置跨域问题
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH")
                .maxAge(3600);
    }

    //调用拦截器
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(httpInterceptor).addPathPatterns("/**");
//    }
}
