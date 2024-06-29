package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class KlientasRepository {
    private final KlientasService klientasService = new KlientasService();

    @GetMapping("/clients")   // Gauti visus klientus.
    public List<Klientas> clientList() throws SQLException {
        return klientasService.clientList();
    }
    @GetMapping("/clients/{id}")   // Gauti klienta pagal ID.
    public Klientas clientById(@PathVariable int id) throws SQLException {
        return klientasService.clientById(id);
    }
    @PostMapping("/clients")  // Sukurti nauja klienta.
    public Klientas newClient(@RequestBody Klientas k) throws SQLException {
        klientasService.newClient(k.getVardas(), k.getPavarde(), k.getEmail(), k.getTelNumeris());
        return null;
    }
    @PutMapping ("/clients/{id}")   // Atnaujinti kliento info pagal ID.
    private void updateClientById(@PathVariable int id, @RequestBody Klientas k) throws SQLException {
        klientasService.updateClientById(k.getId(),k.getVardas(), k.getPavarde(), k.getEmail(), k.getTelNumeris());
    }
    @DeleteMapping("/clients/{id}")   // Istrinti klienta pagal ID.
    public void deleteClientById(@PathVariable int id) throws SQLException {
        klientasService.deleteClientById(id);
    }
    @GetMapping("/clients/active-rentals")   // Gauti klientus su aktyviom nuomom.
    public List<Klientas> clientsWithActiveRents() throws SQLException {
        return klientasService.clientsWithActiveRents();
    }
}
