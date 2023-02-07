package com.example.usestubdemo;

import com.example.usestubdemo.bean.Client;
import com.example.usestubdemo.bean.ClientStub;
import com.example.usestubdemo.bean.impl.ClientImpl;
import com.example.usestubdemo.config.Config;
import com.example.usestubdemo.config.OtherConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;

class UseStubDemoApplicationTests {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner();

    @Test
    public void whenStubmodeSetOn_thenCreateClientStub() {
        this.contextRunner
                .withPropertyValues("usestubdemo.stubmode=on")
                .withUserConfiguration(Config.class)
                .run(
                        context -> {
                            assertThat(context).hasBean("client");
                            ClientImpl client = context.getBean(ClientImpl.class);
                            assertThat(client.showName()).isEqualTo("ClientStub");
                            assertThat(context).doesNotHaveBean(Client.class);
                        });
    }

    @Test
    public void whenStubmodeSetOff_thenCreateClient() {
        this.contextRunner
                .withPropertyValues("usestubdemo.stubmode=off")
                .withUserConfiguration(Config.class)
                .run(
                        context -> {
                            assertThat(context).hasBean("client");
                            ClientImpl client = context.getBean(ClientImpl.class);
                            assertThat(client.showName()).isEqualTo("Client");
                            assertThat(context).doesNotHaveBean(ClientStub.class);
                        });
    }

    @Test
    public void whenUsedPrimary_thenCreateClientStub() {
        this.contextRunner
                .withUserConfiguration(OtherConfig.class)
                .run(
                        context -> {
                            ClientImpl client = context.getBean(ClientImpl.class);
                            assertThat(client.showName()).isEqualTo("ClientStub");
                        });
    }
}
