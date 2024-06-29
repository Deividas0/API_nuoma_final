package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class NuomaRepository {
    private final NuomaService nuomaService = new NuomaService();

    @GetMapping("/rentals")   // Visas nuomos sarasas.
    public List<Nuoma> rentalsList() throws SQLException {
        return nuomaService.rentalsList();
    }
    @PostMapping("/rentals")   // Nauja nuomos registracija.
    public void newRental(@RequestBody Nuoma n) throws SQLException {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = localDateTime.toLocalDate();
        Date sqlDate = Date.valueOf(localDate);
        nuomaService.newRental(n.getAutoId(), n.getKlientasId(), sqlDate);
    }
    @PutMapping("/rentals/{id}")   // Prideti nuomai grazinimo data.
    public void rentalsAddReturnDateById(@PathVariable int id, @RequestBody Nuoma n) throws SQLException {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = localDateTime.toLocalDate();
        Date sqlDate = Date.valueOf(localDate);
        nuomaService.rentalsAddReturnDateById(n.getId(),sqlDate);
    }
    @DeleteMapping("/rentals/{id}")   // Istrinti nuoma pagal ID.
    public void removeRentalById(@PathVariable int id) throws SQLException {
        nuomaService.removeRentalById(id);
    }
    @GetMapping("/clients/{id}/rentals")  // Visos nuomos pagal kliento ID.
    public List<Nuoma> rentByClientId(@PathVariable int id) throws SQLException {
        return nuomaService.rentByClientId(id);
    }
    @GetMapping("/rentals/period")  // Nuoma pagal datas (nuo-iki)
    public List<Nuoma> rentByDateFromTo(String nuomosPradzia2, String nuomuosPabaiga2) throws SQLException {
        return nuomaService.rentByDateFromTo(nuomosPradzia2,nuomuosPabaiga2);
    }
    @GetMapping("/cars/{id}/availability")   // Patikrinti ar auto laisvas pagal data.
    public boolean checkIfCarAvailableByDate(@PathVariable int id, String data) throws SQLException {
        return nuomaService.checkIfCarAvailableByDate(id,data);
    }
}
