package com.example.Abank;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "konto")
public class Konto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String Imie;
    private String Nazwisko;
    private float saldo;
    private int rok_utworzenia;

    public Konto(){}

    public Konto(Long id, String Imie, String Nazwisko,float saldo, int rok_utworzenia) {
        this.id = id;
        this.Imie = Imie;
        this.Nazwisko = Nazwisko;
        this.saldo=saldo;
        this.rok_utworzenia = rok_utworzenia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return Imie;
    }

    public void setImie(String imie) {
        Imie = imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        Nazwisko = nazwisko;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }


    public int getRok_utworzenia() {
        return rok_utworzenia;
    }

    public void setRok_utworzenia(int rok_utworzenia) {
        this.rok_utworzenia = rok_utworzenia;
    }
}
