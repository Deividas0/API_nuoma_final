package com.example.demo;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class DBManager {
    final static String URL = "jdbc:mysql://localhost:3306/javadarbas";
    final static String USERNAME = "root";
    final static String PASSWORD = "l3g10n4s";
    public static Connection _connection;

    public void API() {
    }


    public void SQLconnect(String URL, String USERNAME, String PASSWORD) throws SQLException, SQLException {
        _connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public void SQLconnect() throws SQLException {
        _connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public List<Auto> autoSarasas() throws SQLException {
        SQLconnect();
        final String sql = "SELECT * FROM auto";
        PreparedStatement preparedStatement = _connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Auto> autoSarasas = new ArrayList<>();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String gamintojas = resultSet.getString("gamintojas");
            String modelis = resultSet.getString("modelis");
            int metai = resultSet.getInt("metai");
            boolean uzimtumas = resultSet.getBoolean("uzimtumas");
            Auto auto = new Auto(id, gamintojas, modelis, metai, uzimtumas);
            autoSarasas.add(auto);
        }
        return autoSarasas;
    }

    public Auto autoPagalId(int id) throws SQLException {
        SQLconnect();
        final String sql = "SELECT * FROM auto WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String gamintojas = resultSet.getString("gamintojas");
                String modelis = resultSet.getString("modelis");
                int metai = resultSet.getInt("metai");
                boolean uzimtumas = resultSet.getBoolean("uzimtumas");
                return new Auto(id, gamintojas, modelis, metai, uzimtumas);
            }

            return null;
        }
    }

    public void naujasAuto(String gamintojas, String modelis, int metai, boolean uzimtumas) throws SQLException {
        SQLconnect();
        final String sql = "INSERT INTO auto (gamintojas,modelis,metai,uzimtumas) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, gamintojas);
            preparedStatement.setString(2, modelis);
            preparedStatement.setInt(3, metai);
            preparedStatement.setBoolean(4, uzimtumas);
            preparedStatement.execute();
        }
    }

    public void keiciamAutoInfo(int id, String gamintojas, String modelis, int metai, boolean uzimtumas) throws SQLException {
        SQLconnect();
        final String sql = "UPDATE auto SET gamintojas = ?, modelis = ?, metai = ?, uzimtumas = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, gamintojas);
            preparedStatement.setString(2, modelis);
            preparedStatement.setInt(3, metai);
            preparedStatement.setBoolean(4, uzimtumas);
            preparedStatement.setInt(5, id);
            preparedStatement.execute();
        }
    }

    public void pasalintiAutoPagalId(int id) throws SQLException {
        SQLconnect();
        final String sql = "DELETE FROM auto WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        }
    }

    public List<Klientas> gautivisusklientus() throws SQLException {
        SQLconnect();
        final String sql = "SELECT * FROM klientai";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Klientas> klientuSarasas = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String vardas = resultSet.getString("vardas");
                String pavarde = resultSet.getString("pavarde");
                String email = resultSet.getString("el_pastas");
                String telNumeris = resultSet.getString("tel_numeris");
                Klientas klientas = new Klientas(id, vardas, pavarde, email, telNumeris);
                klientuSarasas.add(klientas);

            }
            return klientuSarasas;
        }
    }

    public Klientas gautiKlientaPagalId(int id) throws SQLException {
        SQLconnect();
        final String sql = "SELECT * FROM klientai WHERE id = (?)";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String vardas = resultSet.getString("vardas");
                String pavarde = resultSet.getString("pavarde");
                String email = resultSet.getString("el_pastas");
                String telNumeris = resultSet.getString("tel_numeris");
                return new Klientas(id, vardas, pavarde, email, telNumeris);
            }

            return null;
        }
    }
    public void sukurtiNaujaKlienta(String vardas, String pavarde, String email, String telNumeris) throws SQLException {
        SQLconnect();
        final String sql = "INSERT INTO klientai (vardas, pavarde, el_pastas, tel_numeris) VALUES (?, ?, ?, ?)";
        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, vardas);
            preparedStatement.setString(2, pavarde);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, telNumeris);
            preparedStatement.executeUpdate();
        }

    }
    public void atnaujintiKlientoInformacija(int id, String vardas, String pavarde, String email, String telNumeris) throws SQLException {
        SQLconnect();
        final String sql = "UPDATE klientai SET vardas = ?, pavarde = ?, el_pastas = ?, tel_numeris = ? WHERE id = ?";
        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, vardas);
            preparedStatement.setString(2, pavarde);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, telNumeris);
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
        }
    }
    public void istrintiKlientaPagalId(int id) throws SQLException {
        SQLconnect();
        final String sql = "DELETE FROM klientai WHERE id = ?";
        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }
    }
    public List<Nuoma> visasNuomosSarasas() throws SQLException {
        SQLconnect();
        final String sql = "SELECT * FROM nuoma";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Nuoma> nuomosSarasas = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int autoId = resultSet.getInt("auto_id");
                int klientasId = resultSet.getInt("kliento_id");
                LocalDateTime nuomosPradzia = resultSet.getTimestamp("nuomos_pradzia").toLocalDateTime();
                LocalDateTime nuomosPabaiga = resultSet.getTimestamp("nuomos_Pabaiga").toLocalDateTime();
                nuomosSarasas.add(new Nuoma(id, autoId, klientasId, nuomosPradzia, nuomosPabaiga));

            }
            return nuomosSarasas;
        }
    }
    public void sukurtiNaujaNuomosOperacija(int autoId, int klientasId, Date nuomosPradzia) throws SQLException {
        SQLconnect();
        final String sql = "INSERT INTO nuoma (auto_id, kliento_id, nuomos_pradzia) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            LocalDateTime localDateTime = LocalDateTime.now();
            LocalDate localDate = localDateTime.toLocalDate();
            Date sqlDate = Date.valueOf(localDate);

            preparedStatement.setInt(1, autoId);
            preparedStatement.setInt(2, klientasId);
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.executeUpdate();
        }
    }
    public void pridetiNuomaiGrazinimoData(int id, Date nuomosPabaiga) throws SQLException {
        SQLconnect();
        final String sql = "UPDATE nuoma SET nuomos_pabaiga = ? WHERE id = ?";
        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(2, id);
            preparedStatement.setDate(1, nuomosPabaiga);
            preparedStatement.executeUpdate();
        }
    }
    public void istrintiNuomaPagalId(int id) throws SQLException {
        SQLconnect();
        final String sql = "DELETE FROM nuoma WHERE id = ?";
        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }

    }

}





