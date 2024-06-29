package com.example.demo;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NuomaService {
    private final DBRepository dbRepository = new DBRepository();

    public List<Nuoma> rentalsList() throws SQLException {
        return dbRepository.rentalsList();
    }

    public void newRental(int autoId, int klientasId, Date nuomosPradzia) throws SQLException {
        dbRepository.newRental(autoId, klientasId, nuomosPradzia);
    }

    public void rentalsAddReturnDateById(int id, Date nuomosPabaiga) throws SQLException {
        dbRepository.rentalsAddReturnDateById(id, nuomosPabaiga);
    }

    public void removeRentalById(int id) throws SQLException {
        dbRepository.removeRentalById(id);
    }
    public List<Nuoma> rentByClientId(int klientoId) throws SQLException {
        return dbRepository.rentByClientId(klientoId);
    }
    public List<Nuoma> rentByDateFromTo(String nuomosPradzia2, String nuomosPabaiga2) throws SQLException {
        return dbRepository.rentByDateFromTo(nuomosPradzia2,nuomosPabaiga2);
    }
    public boolean checkIfCarAvailableByDate(int autoId2, String data) throws SQLException {
        return dbRepository.checkIfCarAvailableByDate(autoId2,data);
    }
}

