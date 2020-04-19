package com.yayayahei.hello.spring.actuator.secure;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration(proxyBeanMethods = false)
public class ActuatorSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.requestMatcher(EndpointRequest.toAnyEndpoint()).authorizeRequests((requests) ->
//                requests.anyRequest().hasRole("ENDPOINT_ADMIN"));
        http.requestMatcher(EndpointRequest.toAnyEndpoint()).authorizeRequests((requests) ->
                requests.anyRequest().permitAll());
        http.httpBasic();
    }
}
