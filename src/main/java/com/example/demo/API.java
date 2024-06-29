package com.example.demo;

import com.mysql.cj.xdevapi.DbDoc;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class API {
    //private final NuomaService nuomaService = new NuomaService();
    //private final KlientasService klientasService = new KlientasService();
    //private final AutoService autoService = new AutoService();

//    @GetMapping("/cars")   // Gauti visus auto.
//    public List<Auto> carsList() throws SQLException {
//        return autoService.carsList();
//    }

//    @GetMapping("/cars/{id}")   // Gauti auto pagal ID.
//    public Auto carsById(@PathVariable int id) throws SQLException {
//        return autoService.carsById(id);
//    }

//    @PostMapping("/cars")   // Pridėti nauja auto.
//    public Auto newAuto(@RequestBody Auto auto) throws SQLException {
//        autoService.newAuto(auto.getGamintojas(), auto.getModelis(), auto.getMetai(), auto.getUzimtumas());
//        return null;
//    }

//    @PutMapping("/cars/{id}")   // Atnaujinti auto info pagal ID.
//    public Auto updateCarById(@PathVariable int id, @RequestBody Auto auto) throws SQLException {
//        autoService.updateCarById(auto.getId(), auto.getGamintojas(), auto.getModelis(), auto.getMetai(), auto.getUzimtumas());
//        return null;
//    }

//    @DeleteMapping("/cars/{id}")   // Istrinti auto pagal ID.
//    public void deleteCarById(@PathVariable int id) throws SQLException {
//        autoService.deleteCarById(id);
//    }

//    @GetMapping("/clients")   // Gauti visus klientus.
//    public List<Klientas> clientList() throws SQLException {
//        return klientasService.clientList();
//    }

//    @GetMapping("/clients/{id}")   // Gauti klienta pagal ID.
//    public Klientas clientById(@PathVariable int id) throws SQLException {
//        return klientasService.clientById(id);
//    }

//    @PostMapping("/clients")  // Sukurti nauja klienta.
//    public Klientas newClient(@RequestBody Klientas k) throws SQLException {
//        klientasService.newClient(k.getVardas(), k.getPavarde(), k.getEmail(), k.getTelNumeris());
//        return null;
//    }

//    @PutMapping ("/clients/{id}")   // Atnaujinti kliento info pagal ID.
//    private void updateClientById(@PathVariable int id, @RequestBody Klientas k) throws SQLException {
//        klientasService.updateClientById(k.getId(),k.getVardas(), k.getPavarde(), k.getEmail(), k.getTelNumeris());
//    }
//    @DeleteMapping("/clients/{id}")   // Istrinti klienta pagal ID.
//    public void deleteClientById(@PathVariable int id) throws SQLException {
//        klientasService.deleteClientById(id);
//    }
//    @GetMapping("/rentals")   // Visas nuomos sarasas.
//    public List<Nuoma> rentalsList() throws SQLException {
//        return nuomaService.rentalsList();
//    }
//    @PostMapping("/rentals")   // Nauja nuomos registracija.
//    public void newRental(@RequestBody Nuoma n) throws SQLException {
//        LocalDateTime localDateTime = LocalDateTime.now();
//        LocalDate localDate = localDateTime.toLocalDate();
//        Date sqlDate = Date.valueOf(localDate);
//        nuomaService.newRental(n.getAutoId(), n.getKlientasId(), sqlDate);
//    }
//    @PutMapping("/rentals/{id}")   // Prideti nuomai grazinimo data.
//    public void rentalsAddReturnDateById(@PathVariable int id, @RequestBody Nuoma n) throws SQLException {
//        LocalDateTime localDateTime = LocalDateTime.now();
//        LocalDate localDate = localDateTime.toLocalDate();
//        Date sqlDate = Date.valueOf(localDate);
//        nuomaService.rentalsAddReturnDateById(n.getId(),sqlDate);
//    }
//    @DeleteMapping("/rentals/{id}")   // Istrinti nuoma pagal ID.
//        public void removeRentalById(@PathVariable int id) throws SQLException {
//            nuomaService.removeRentalById(id);
//        }

        // ------------------------------------  PAPILDOMI ENDPOINTAI -------------------------------

//    @GetMapping("/cars/available")   // Laisvi auto.
//    public List<Auto> availableCars() throws SQLException {
//        return autoService.availableCars();
//    }

//    @GetMapping("/cars/{make}")   // Visi auto pagal gamintoja.
//    public List<Auto> carsByMaker(@PathVariable String make) throws SQLException {
//        return autoService.carsByMaker(make);
//    }
//    @GetMapping("/clients/{id}/rentals")  // Visos nuomos pagal kliento ID.
//    public List<Nuoma> rentByClientId(@PathVariable int id) throws SQLException {
//        return nuomaService.rentByClientId(id);
//    }

//    @GetMapping("/rentals/period")  // Nuoma pagal datas (nuo-iki)
//    public List<Nuoma> rentByDateFromTo(String nuomosPradzia2, String nuomuosPabaiga2) throws SQLException {
//        return nuomaService.rentByDateFromTo(nuomosPradzia2,nuomuosPabaiga2);
//    }
//    @GetMapping("/cars/{id}/availability")   // Patikrinti ar auto laisvas pagal data.
//        public boolean checkIfCarAvailableByDate(@PathVariable int id, String data) throws SQLException {
//        return nuomaService.checkIfCarAvailableByDate(id,data);
//    }
//    @GetMapping("/cars/year/{year}")   // Gauti visus auto pagal metus.
//    public List<Auto> allAutoByYear(@PathVariable int year) throws SQLException {
//        return autoService.allAutoByYear(year);
//    }

//    @GetMapping("/clients/active-rentals")   // Gauti klientus su aktyviom nuomom.
//    public List<Klientas> clientsWithActiveRents() throws SQLException {
//        return klientasService.clientsWithActiveRents();
//    }

//    @GetMapping("/cars/rented-more-than/{count}")   // Gauti visus auto isnomuotus daugiau nei X kartu.
//    public List<Auto> carsRentedMoreThanXAmount(@PathVariable int count) throws SQLException {
//        return autoService.carsRentedMoreThanXAmount(count);
//    }

}







