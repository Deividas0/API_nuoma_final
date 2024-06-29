package com.example.demo;

import java.sql.SQLException;
import java.util.List;

public class AutoService {
    private final DBRepository dbRepository = new DBRepository();

    public List<Auto> carsList() throws SQLException {
        return dbRepository.carsList();
    }
    public Auto carsById(int id) throws SQLException {
        return dbRepository.carsById(id);
    }
    public void newAuto(String gamintojas, String modelis, int metai, boolean uzimtumas) throws SQLException {
        dbRepository.newAuto(gamintojas, modelis, metai, uzimtumas);
    }
    public void updateCarById(int id, String gamintojas, String modelis, int metai, boolean uzimtumas) throws SQLException {
        dbRepository.updateCarById(id, gamintojas, modelis, metai, uzimtumas);
    }
    public void deleteCarById(int id) throws SQLException {
        dbRepository.deleteCarById(id);
    }
    public List<Auto> availableCars() throws SQLException {
        return dbRepository.availableCars();
    }
    public List<Auto> carsByMaker(String gamintojas2) throws SQLException {
        return dbRepository.carsByMaker(gamintojas2);
    }
    public List<Auto> allAutoByYear(int x) throws SQLException {
        return dbRepository.allAutoByYear(x);
    }
    public List<Auto> carsRentedMoreThanXAmount(int x) throws SQLException {
        return dbRepository.carsRentedMoreThanXAmount(x);
    }
}
