package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class AutoRepository {
    private final AutoService autoService = new AutoService();

    @GetMapping("/cars")   // Gauti visus auto.
    public List<Auto> carsList() throws SQLException {
        return autoService.carsList();
    }
    @GetMapping("/cars/{id}")   // Gauti auto pagal ID.
    public Auto carsById(@PathVariable int id) throws SQLException {
        return autoService.carsById(id);
    }
    @PostMapping("/cars")   // Pridėti nauja auto.
    public Auto newAuto(@RequestBody Auto auto) throws SQLException {
        autoService.newAuto(auto.getGamintojas(), auto.getModelis(), auto.getMetai(), auto.getUzimtumas());
        return null;
    }
    @PutMapping("/cars/{id}")   // Atnaujinti auto info pagal ID.
    public Auto updateCarById(@PathVariable int id, @RequestBody Auto auto) throws SQLException {
        autoService.updateCarById(auto.getId(), auto.getGamintojas(), auto.getModelis(), auto.getMetai(), auto.getUzimtumas());
        return null;
    }
    @DeleteMapping("/cars/{id}")   // Istrinti auto pagal ID.
    public void deleteCarById(@PathVariable int id) throws SQLException {
        autoService.deleteCarById(id);
    }
    @GetMapping("/cars/available")   // Laisvi auto.
    public List<Auto> availableCars() throws SQLException {
        return autoService.availableCars();
    }
    @GetMapping("/cars/{make}")   // Visi auto pagal gamintoja.
    public List<Auto> carsByMaker(@PathVariable String make) throws SQLException {
        return autoService.carsByMaker(make);
    }
    @GetMapping("/cars/year/{year}")   // Gauti visus auto pagal metus.
    public List<Auto> allAutoByYear(@PathVariable int year) throws SQLException {
        return autoService.allAutoByYear(year);
    }
    @GetMapping("/cars/rented-more-than/{count}")   // Gauti visus auto isnomuotus daugiau nei X kartu.
    public List<Auto> carsRentedMoreThanXAmount(@PathVariable int count) throws SQLException {
        return autoService.carsRentedMoreThanXAmount(count);
    }
}
