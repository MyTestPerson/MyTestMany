package com.testmany.shop.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;

// Класс для инициализации Security.
// Запускается из класса RootConfig путём сканирования пакета.
public class SecurityInit extends AbstractSecurityWebApplicationInitializer {

    // Кодировка текста в UTF8. Например, если принять POST параметр @ModelAttribute,
    // то параметры будут не корректны, будут проценты, нули и так далее. Абракадабра.
    // Данный метод кодировки работает только для Security. Если в приложении не
    // будет Security, значит и проблем с кодировкой в данном случаи не будет.
    // Простыми словами - Security портит кодировку, поэтому приходится использовать
    // данный метод.
    //
    // =>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>
    //
    @Override
    protected final void beforeSpringSecurityFilterChain(final ServletContext servletContext) {

        FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("encodingFilter", new CharacterEncodingFilter());
        characterEncodingFilter.setInitParameter("encoding", "UTF-8");
        characterEncodingFilter.setInitParameter("forceEncoding", "true");
        characterEncodingFilter.addMappingForUrlPatterns(null, false, "/*");
    }

}
