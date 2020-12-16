package com.j4v4code.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.j4v4code"})
public class WebConfig implements WebMvcConfigurer {
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/views/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /*
     *Response Karakter Kodlaması İçin
     * HTTP Response'un da Http Requestte olduğu  gibi UTF-8 karakter kodlamasına göre kodlanması gerekmektedir.
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();

        List<MediaType> mediaTypeList = new ArrayList<>();
        mediaTypeList.add(new MediaType("text", "plain", Charset.forName("UTF-8")));
        mediaTypeList.add(new MediaType("text", "plain", Charset.forName("UTF-8")));
        mediaTypeList.add(new MediaType("application", "json", Charset.forName("UTF-8")));
        mediaTypeList.add(new MediaType("text", "javascript", Charset.forName("UTF-8")));

        stringConverter.setSupportedMediaTypes(mediaTypeList);
        converters.add(stringConverter);

    }

    /*
     * Locale bilgisinin cookiler (çerezler) kullanılarak depolanması ve çözümlenmesi için
     * Springde CookieLocaleResolver beaninin tanımlanaması gerekir.
     */
    @Bean
    public CookieLocaleResolver localeResolver() {
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setDefaultLocale(Locale.forLanguageTag("tr-TR"));
        localeResolver.setCookieName("j4v4cod-locale-cookie");
        localeResolver.setCookieMaxAge(3600);
        return localeResolver;

    }

    /*
     *Oturum locale bilgisinin çözümlenmesi için Spring
     * SessionLocaleResolver beaninin tanımlanması gerekir.
     */

    @Bean
    public SessionLocaleResolver sessionLocaleResolver() {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.forLanguageTag("tr-TR"));
        return sessionLocaleResolver;

    }



}
