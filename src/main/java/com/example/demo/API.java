package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.List;
import java.util.Optional;

@RestController
public class API {

    @GetMapping("/visiauto")
    public List<Auto> autoSarasas() throws SQLException {
        DBManager db = new DBManager();
        return db.autoSarasas();
    }

    @GetMapping("/autopagalid")
    public Auto autoPagalId(int id) throws SQLException {
        DBManager db = new DBManager();
        return db.autoPagalId(id);
    }

    @PostMapping("/naujasauto")
    public Auto naujasAuto(@RequestBody Auto auto) throws SQLException {
        DBManager db = new DBManager();
        db.naujasAuto(auto.getGamintojas(), auto.getModelis(), auto.getMetai(), auto.getUzimtumas());
        return null;
    }

    @PutMapping("/atnaujintiautoinfopagalid")
    public Auto keiciamAutoInfo(@RequestBody Auto auto, Optional<Integer> id) throws SQLException {
        DBManager db = new DBManager();
        db.keiciamAutoInfo(auto.getId(), auto.getGamintojas(), auto.getModelis(), auto.getMetai(), auto.getUzimtumas());
        return null;
    }

    @DeleteMapping("/pasalintiautopagalid")
    public void pasalintiAutoPagalId(int id) throws SQLException {
        DBManager db = new DBManager();
        db.pasalintiAutoPagalId(id);
    }

    @GetMapping("/gautivisusklientus")
    public List<Klientas> gautivisusklientus() throws SQLException {
        DBManager db = new DBManager();
        return db.gautivisusklientus();
    }

    @GetMapping("/gautiklientapagalid")
    public Klientas gautiKlientaPagalId(int id) throws SQLException {
        DBManager db = new DBManager();
        return db.gautiKlientaPagalId(id);
    }

    @PostMapping("/sukurtinaujaklienta")
    public Klientas sukurtiNaujaKlienta(@RequestBody Klientas k) throws SQLException {
        DBManager db = new DBManager();
        db.sukurtiNaujaKlienta(k.getVardas(), k.getPavarde(), k.getEmail(), k.getTelNumeris());
        return null;
    }

    @PutMapping ("/atnaujintiklientoinfopagalid")
    private void atnaujintiKlientoInformacija(@RequestBody Klientas k) throws SQLException {
        DBManager db = new DBManager();
        db.atnaujintiKlientoInformacija(k.getId(),k.getVardas(), k.getPavarde(), k.getEmail(), k.getTelNumeris());
    }
    @DeleteMapping("/istrintiklientapagalid")
    public void istrintiKlientaPagalId(int id) throws SQLException {
        DBManager db = new DBManager();
        db.istrintiKlientaPagalId(id);
    }
}






