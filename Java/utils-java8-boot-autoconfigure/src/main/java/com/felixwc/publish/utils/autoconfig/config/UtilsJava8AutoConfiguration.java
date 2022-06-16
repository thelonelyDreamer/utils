package com.felixwc.publish.utils.autoconfig.config;

import com.felixwc.publish.utils.autoconfig.eden.EdenInterface;
import com.felixwc.publish.utils.autoconfig.eden.impl.EdenInterfaceImpl;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * in order to learn java!
 * created at 2022/6/12 13:09
 *
 * @author felixwc
 */
@Configuration
@ConfigurationPropertiesScan(basePackages = {"com.felixwc.publish.utils.autoconfig.config.properties"})
public class UtilsJava8AutoConfiguration {

    @Bean
    public EdenInterface edenInterface(){
        return new EdenInterfaceImpl();
    }
}
