package com.example.demo;

import java.sql.SQLException;
import java.util.List;

public class AutoService {
    private final DBRepository dbRepository = new DBRepository();

    public List<Auto> autoSarasas() throws SQLException {
        return dbRepository.autoSarasas();
    }
    public Auto autoPagalId(int id) throws SQLException {
        return dbRepository.autoPagalId(id);
    }
    public void naujasAuto(String gamintojas, String modelis, int metai, boolean uzimtumas) throws SQLException {
        dbRepository.naujasAuto(gamintojas, modelis, metai, uzimtumas);
    }
    public void keiciamAutoInfo(int id, String gamintojas, String modelis, int metai, boolean uzimtumas) throws SQLException {
        dbRepository.keiciamAutoInfo(id, gamintojas, modelis, metai, uzimtumas);
    }
    public void pasalintiAutoPagalId(int id) throws SQLException {
        dbRepository.pasalintiAutoPagalId(id);
    }
    public List<Auto> laisvuAutoSarasas() throws SQLException {
        return dbRepository.laisvuAutoSarasas();
    }
    public List<Auto> visiAutoPagalGamintoja(String gamintojas2) throws SQLException {
        return dbRepository.visiAutoPagalGamintoja(gamintojas2);
    }
    public List<Auto> gautiVisusAutoPagalMetus(int x) throws SQLException {
        return dbRepository.gautiVisusAutoPagalMetus(x);
    }
    public List<Auto> isnomuotiAutoDaugiauNeiXKartu(int x) throws SQLException {
        return dbRepository.isnomuotiAutoDaugiauNeiXKartu(x);
    }
}
