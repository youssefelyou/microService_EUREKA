package com.example.voiture;

import com.example.voiture.model.Client;
import com.example.voiture.repository.VoitureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class VoitureApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoitureApplication.class, args);
    }

    @Bean
    CommandLineRunner initialiserBaseH2(VoitureRepository voitureRepository, ClientService clientService){

        return args -> {
            Client client1 = clientService.clientById(1);
            Client client2 = clientService.clientById(2);
            System.out.println("**************************");
            System.out.println("Id est :" + client1.getId());
            System.out.println("Nom est :" + client1.getNom());     
            System.out.println("Id est :" + client2.getId());
            System.out.println("Nom est :" + client2.getNom());
            System.out.println("Age est :" + client2.getAge());
            voitureRepository.save(new Voiture(Long.parseLong("1"), "Dacia", "26 B 7021", "sandro", 1, client1));
            voitureRepository.save(new Voiture(Long.parseLong("2"), "Mercedes", "26 B 999", "class c", 2, client1));
            voitureRepository.save(new Voiture(Long.parseLong("3"), "kia", "29 A 27163", "sorento", 2, client2));
        };
    }


}
