package com.gjw.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Component
public class MyMvcConfig implements WebMvcConfigurer {

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * 将静态资源映射到对应路径
         */
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        List<MediaType> mediaTypes=new ArrayList<MediaType>();
        mediaTypes.add(new MediaType(MediaType.TEXT_HTML, Charset.forName("UTF-8")));
        mediaTypes.add(new MediaType(MediaType.APPLICATION_JSON,Charset.forName("UTF-8")));
        mediaTypes.add(new MediaType(MediaType.APPLICATION_XML,Charset.forName("UTF-8")));
        converter.setSupportedMediaTypes(mediaTypes);
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        converter.setFastJsonConfig(fastJsonConfig);
        converters.add(converter);
    }
}
