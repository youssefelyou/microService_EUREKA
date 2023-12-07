package com.example.eurekaclient;

import com.example.eurekaclient.entity.Client;
import com.example.eurekaclient.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

    @Bean
    CommandLineRunner initialiserBaseH2(ClientRepository clientRepository) {
        return args -> {
            clientRepository.save(new Client(Long.parseLong("1"), "Youssef Elyourizi", Float.parseFloat("23")));
            clientRepository.save(new Client(Long.parseLong("2"), "Yahya Aloaui", Float.parseFloat("22")));
            clientRepository.save(new Client(Long.parseLong("3"), "Adam adam", Float.parseFloat("22")));

        };
    }


}
