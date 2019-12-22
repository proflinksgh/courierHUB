package com.example.Erranda;


import java.util.UUID;

public class uuid {
    public static void main(String[] args) {
        // Creating a random UUID (Universally unique identifier).
        UUID uuid = UUID.randomUUID();
        Constant.randomUUIDString = uuid.toString();

        System.out.println("Random UUID String = " + Constant.randomUUIDString);


    }

}
