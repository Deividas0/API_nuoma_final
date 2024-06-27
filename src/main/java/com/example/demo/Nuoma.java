package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Nuoma {
    public int id;
    public int autoId;
    public int klientasId;
    public LocalDate nuomosPradzia;
    public LocalDate nuomosPabaiga;

    public Nuoma(int id, int autoId, int klientasId, LocalDate nuomosPradzia, LocalDate nuomosPabaiga) {
        this.id = id;
        this.autoId = autoId;
        this.klientasId = klientasId;
        this.nuomosPradzia = nuomosPradzia;
        this.nuomosPabaiga = nuomosPabaiga;
    }
    public Nuoma() {}

    public int getId() {return id;}
    public int getAutoId() {return autoId;}
    public int getKlientasId() {return klientasId;}
    public LocalDate getNuomosPradzia() {return nuomosPradzia;}
    public LocalDate getNuomosPabaiga() {return nuomosPabaiga;}
}
