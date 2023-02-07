package com.example.usestubdemo.bean;

import com.example.usestubdemo.bean.impl.ClientImpl;

public class ClientStub implements ClientImpl {
    @Override
    public String showName() {
        return "ClientStub";
    }
}
