package com.example.usestubdemo.config;

import com.example.usestubdemo.bean.Client;
import com.example.usestubdemo.bean.ClientStub;
import com.example.usestubdemo.bean.impl.ClientImpl;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

@Configurable
public class Config {

    @Bean("client")
    @ConditionalOnProperty(prefix = "usestubdemo", name = "stubmode", havingValue = "off")
    public ClientImpl client() {
        return new Client();
    }

    @Bean("client")
    @ConditionalOnProperty(name = "usestubdemo.stubmode", havingValue = "on")
    public ClientImpl clientStub() {
        return new ClientStub();
    }
}
