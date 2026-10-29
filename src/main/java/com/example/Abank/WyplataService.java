package com.example.Abank;

import org.springframework.stereotype.Service;

@Service
public class WyplataService {

    public double wyplata(double balance,double amount){
        if (amount<=0){
            throw new IllegalArgumentException("<Kwota wypłaty nie może być mniejsza od 0>");
        }
        return balance-amount;
    }
}
