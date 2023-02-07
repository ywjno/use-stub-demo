package com.example.usestubdemo.config;

import com.example.usestubdemo.bean.Client;
import com.example.usestubdemo.bean.ClientStub;
import com.example.usestubdemo.bean.impl.ClientImpl;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@Configurable
public class OtherConfig {

    @Bean
    public ClientImpl client() {
        return new Client();
    }

    @Bean
    @Primary
    public ClientImpl clientStub() {
        return new ClientStub();
    }
}
