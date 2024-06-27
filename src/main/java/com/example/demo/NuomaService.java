package com.example.demo;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NuomaService {
    private final DBRepository dbRepository = new DBRepository();

    public List<Nuoma> visasNuomosSarasas() throws SQLException {
        return dbRepository.visasNuomosSarasas();
    }

    public void sukurtiNaujaNuomosOperacija(int autoId, int klientasId, Date nuomosPradzia) throws SQLException {
        dbRepository.sukurtiNaujaNuomosOperacija(autoId, klientasId, nuomosPradzia);
    }

    public void pridetiNuomaiGrazinimoData(int id, Date nuomosPabaiga) throws SQLException {
        dbRepository.pridetiNuomaiGrazinimoData(id, nuomosPabaiga);
    }

    public void istrintiNuomaPagalId(int id) throws SQLException {
        dbRepository.istrintiNuomaPagalId(id);
    }
    public List<Nuoma> nuomaPagalKlientoId(int klientoId) throws SQLException {
        return dbRepository.nuomaPagalKlientoId(klientoId);
    }
    public List<Nuoma> nuomaPagalDatasNuoIki(String nuomosPradzia2, String nuomosPabaiga2) throws SQLException {
        return dbRepository.nuomaPagalDatasNuoIki(nuomosPradzia2,nuomosPabaiga2);
    }
    public boolean nuomaArAutoLaisvasPagalData(int autoId2, String data) throws SQLException {
        return dbRepository.nuomaArAutoLaisvasPagalData(autoId2,data);
    }
}

