package com.example.demo;



public class Auto {
    public int id;
    public String gamintojas;
    public String modelis;
    public int metai;
    public boolean uzimtumas;

    public Auto(int id, String gamintojas, String modelis, int metai, boolean uzimtumas) {
        this.id = id;
        this.gamintojas = gamintojas;
        this.modelis = modelis;
        this.metai = metai;
        this.uzimtumas = uzimtumas;
    }

    public Auto(String gamintojas, String modelis, int metai, boolean uzimtumas) {
        this.gamintojas = gamintojas;
        this.modelis = modelis;
        this.metai = metai;
        this.uzimtumas = uzimtumas;
    }
    public Auto(){};

    public int getId() {return id;}
    public String getGamintojas() {return gamintojas;}
    public String getModelis() {return modelis;}
    public int getMetai() {return metai;}
    public boolean getUzimtumas() {return uzimtumas;}

    @Override
    public String toString(){
        return "Auto ID: " + getId() + ". Gamintojas: " + getGamintojas() + ". Modelis: " + getModelis()
                + ". Metai: " + getMetai() + ". Ar auto laisvas: " + getUzimtumas() + ". ";
    }
}



