package com.example.demo;

public class Klientas {
    public int id;
    public String vardas;
    public String pavarde;
    public String email;
    public String telNumeris;

    public Klientas(int id, String vardas, String pavarde, String email, String telNumeris) {
        this.id = id;
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.email = email;
        this.telNumeris = telNumeris;
    }

    public Klientas(String vardas, String pavarde, String email, String telNumeris) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.email = email;
        this.telNumeris = telNumeris;
    }
    public Klientas(){};


    public String getVardas() {return vardas;}
    public String getPavarde() {return pavarde;}
    public String getEmail() {return email;}
    public String getTelNumeris() {return telNumeris;}
    public int getId() {return id;}

    @Override
    public String toString(){
        return "Kliento ID: " + getId() + ". Vardas: " + getVardas() + ". Pavardė: " + getPavarde()
                + "El. pašto adresas: " + getEmail() + ". Tel. numeris: " + getTelNumeris() + ". ";
    }
}
