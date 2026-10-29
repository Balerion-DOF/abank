package com.example.Abank;

import org.springframework.stereotype.Service;

@Service
public class DepositService {

    public double deposit(double balance,double amount){
        if (amount<=0){
            throw new IllegalArgumentException("<Kwota nie może być mniejsza od zera>");
        }
        return balance+amount;
    }

}
