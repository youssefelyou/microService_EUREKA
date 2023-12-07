package com.example.voiture.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private Long Id;
    private String Nom;
    private Float Age;
}

