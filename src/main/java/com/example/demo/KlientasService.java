package com.example.demo;

import java.sql.SQLException;
import java.util.List;

public class KlientasService {

    private final DBRepository dbRepository = new DBRepository();

    public List<Klientas> clientList() throws SQLException {
        return dbRepository.clientList();
    }
    public Klientas clientById(int id) throws SQLException {
        return dbRepository.clientById(id);
    }
    public void newClient(String vardas, String pavarde, String email, String telNumeris) throws SQLException {
        dbRepository.newClient(vardas, pavarde, email, telNumeris);
    }
    public void updateClientById(int id, String vardas, String pavarde, String email, String telNumeris) throws SQLException {
        dbRepository.updateClientById(id, vardas, pavarde, email, telNumeris);
    }
    public void deleteClientById(int id) throws SQLException {
        dbRepository.deleteClientById(id);
    }
    public List<Klientas> clientsWithActiveRents() throws SQLException {
        return dbRepository.clientsWithActiveRents();
    }
}
