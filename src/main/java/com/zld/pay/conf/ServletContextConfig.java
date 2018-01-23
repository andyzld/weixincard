package com.zld.pay.conf;//package com.zld.weixin.conf;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
///**
// * Created by Administrator on 2018/1/16.
// * 解决swaggerUI配置后找不到页面的问题
// * 配置Swaggerui只需要：
// * 1.pom
// * 2.Swagger2 conf
// */
//@Configuration
//public class ServletContextConfig extends WebMvcConfigurationSupport {
//
//    /**
//     * 发现如果继承了WebMvcConfigurationSupport，则在yml中配置的相关内容会失效。
//     * 需要重新指定静态资源
//     * @param registry
//     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//        super.addResourceHandlers(registry);
//    }
//
//
//    /**
//     * 配置servlet处理
//     */
//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }
//
//}
