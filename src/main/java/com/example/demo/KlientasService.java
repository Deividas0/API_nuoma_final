package com.example.demo;

import java.sql.SQLException;
import java.util.List;

public class KlientasService {

    private final DBRepository dbRepository = new DBRepository();

    public List<Klientas> gautivisusklientus() throws SQLException {
        return dbRepository.gautivisusklientus();
    }
    public Klientas gautiKlientaPagalId(int id) throws SQLException {
        return dbRepository.gautiKlientaPagalId(id);
    }
    public void sukurtiNaujaKlienta(String vardas, String pavarde, String email, String telNumeris) throws SQLException {
        dbRepository.sukurtiNaujaKlienta(vardas, pavarde, email, telNumeris);
    }
    public void atnaujintiKlientoInformacija(int id, String vardas, String pavarde, String email, String telNumeris) throws SQLException {
        dbRepository.atnaujintiKlientoInformacija(id, vardas, pavarde, email, telNumeris);
    }
    public void istrintiKlientaPagalId(int id) throws SQLException {
        dbRepository.istrintiKlientaPagalId(id);
    }
    public List<Klientas> klientaiTurintysAktyviaNuoma() throws SQLException {
        return dbRepository.klientaiTurintysAktyviaNuoma();
    }
}
