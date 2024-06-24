package com.example.demo;

import java.time.LocalDateTime;

public class Nuoma {
    public int id;
    public int autoId;
    public int klientasId;
    public LocalDateTime nuomosPradzia;
    public LocalDateTime nuomosPabaiga;

    public Nuoma(int id, int autoId, int klientasId, LocalDateTime nuomosPradzia, LocalDateTime nuomosPabaiga) {
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
    public LocalDateTime getNuomosPradzia() {return nuomosPradzia;}
    public LocalDateTime getNuomosPabaiga() {return nuomosPabaiga;}
}
