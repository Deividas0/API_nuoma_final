package com.example.demo;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class DBRepository {
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

    public List<Nuoma> rentalsList() throws SQLException {
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
                LocalDate nuomosPradzia = resultSet.getDate("nuomos_pradzia").toLocalDate();
                LocalDate nuomosPabaiga = resultSet.getDate("nuomos_Pabaiga").toLocalDate();
                nuomosSarasas.add(new Nuoma(id, autoId, klientasId, nuomosPradzia, nuomosPabaiga));
            }
            return nuomosSarasas;
        }
    }

    public void newRental(int autoId, int klientasId, Date nuomosPradzia) throws SQLException {
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

    public void rentalsAddReturnDateById(int id, Date nuomosPabaiga) throws SQLException {
        SQLconnect();
        final String sql = "UPDATE nuoma SET nuomos_pabaiga = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(2, id);
            preparedStatement.setDate(1, nuomosPabaiga);
            preparedStatement.executeUpdate();
        }
    }

    public void removeRentalById(int id) throws SQLException {
        SQLconnect();
        final String sql = "DELETE FROM nuoma WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public List<Nuoma> rentByClientId(int klientoId) throws SQLException {
        SQLconnect();
        final String sql = "SELECT * FROM nuoma WHERE kliento_id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, klientoId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Nuoma> nuomosSarasas = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int autoId = resultSet.getInt("auto_id");
                int klientasId = resultSet.getInt("kliento_id");

                LocalDate nuomosPradzia = resultSet.getDate("nuomos_pradzia").toLocalDate();
                LocalDate nuomosPabaiga = formatDate(resultSet.getString("nuomos_pabaiga"));
                nuomosSarasas.add(new Nuoma(id, autoId, klientasId, nuomosPradzia, nuomosPabaiga));
            }
            return nuomosSarasas;
        }
    }

    public List<Nuoma> rentByDateFromTo(String nuomosPradzia2, String nuomosPabaiga2) throws SQLException {
        SQLconnect();
        final String sql = "SELECT * FROM nuoma WHERE nuomos_pradzia >= ? AND nuomos_pabaiga <= ?";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, nuomosPradzia2);
            preparedStatement.setString(2, nuomosPabaiga2);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Nuoma> nuomosSarasas = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int autoId = resultSet.getInt("auto_id");
                int klientasId = resultSet.getInt("kliento_id");

                LocalDate nuomosPradzia = resultSet.getDate("nuomos_pradzia").toLocalDate();
                LocalDate nuomosPabaiga = formatDate(resultSet.getString("nuomos_pabaiga"));
                nuomosSarasas.add(new Nuoma(id, autoId, klientasId, nuomosPradzia, nuomosPabaiga));
            }
            return nuomosSarasas;
        }
    }

    public boolean checkIfCarAvailableByDate(int autoId2, String data) throws SQLException {
        SQLconnect();
        final String sql = "SELECT * FROM nuoma WHERE auto_id = ? AND ? NOT BETWEEN nuomos_pradzia AND nuomos_pabaiga";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, autoId2);
            preparedStatement.setString(2, data);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
            return false;
        }
    }

    public List<Klientas> clientList() throws SQLException {
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

    public Klientas clientById(int id) throws SQLException {
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

    public void newClient(String vardas, String pavarde, String email, String telNumeris) throws SQLException {
        SQLconnect();
        final String sql = "INSERT INTO klientai (vardas, pavarde, el_pastas, tel_numeris) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, vardas);
            preparedStatement.setString(2, pavarde);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, telNumeris);
            preparedStatement.executeUpdate();
        }

    }

    public void updateClientById(int id, String vardas, String pavarde, String email, String telNumeris) throws SQLException {
        SQLconnect();
        final String sql = "UPDATE klientai SET vardas = ?, pavarde = ?, el_pastas = ?, tel_numeris = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, vardas);
            preparedStatement.setString(2, pavarde);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, telNumeris);
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
        }
    }

    public void deleteClientById(int id) throws SQLException {
        SQLconnect();
        final String sql = "DELETE FROM klientai WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public List<Klientas> clientsWithActiveRents() throws SQLException {
        SQLconnect();
        final String sql = """
                SELECT DISTINCT k.id, k.vardas, k.pavarde, k.el_pastas, k.tel_numeris, n.nuomos_pradzia FROM nuoma n
                INNER JOIN klientai k ON k.id = n.kliento_id
                WHERE nuomos_pabaiga IS NULL;
                """;
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Klientas> klientaiTurintysAktyviaNuoma = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String vardas = resultSet.getString("vardas");
                String pavarde = resultSet.getString("pavarde");
                String email = resultSet.getString("el_pastas");
                String telNumeris = resultSet.getString("tel_numeris");
                Klientas klientas = new Klientas(id, vardas, pavarde, email, telNumeris);
                klientaiTurintysAktyviaNuoma.add(klientas);
            }
            return klientaiTurintysAktyviaNuoma;
        }
    }
    public List<Auto> carsList() throws SQLException {
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
    public Auto carsById(int id) throws SQLException {
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
    public void newAuto(String gamintojas, String modelis, int metai, boolean uzimtumas) throws SQLException {
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
    public void updateCarById(int id, String gamintojas, String modelis, int metai, boolean uzimtumas) throws SQLException {
        SQLconnect();
        final String sql = "UPDATE auto SET gamintojas = ?, modelis = ?, metai = ?, uzimtumas = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, gamintojas);
            preparedStatement.setString(2, modelis);
            preparedStatement.setInt(3, metai);
            preparedStatement.setBoolean(4, uzimtumas);
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
        }
    }
    public void deleteCarById(int id) throws SQLException {
        SQLconnect();
        final String sql = "DELETE FROM auto WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        }
    }
    public List<Auto> availableCars() throws SQLException {
        SQLconnect();
        final String sql = "SELECT * FROM auto WHERE uzimtumas = 1";
        PreparedStatement preparedStatement = _connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        List<Auto> laisvuAutoSarasas = new ArrayList<>();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String gamintojas = resultSet.getString("gamintojas");
            String modelis = resultSet.getString("modelis");
            int metai = resultSet.getInt("metai");
            boolean uzimtumas = resultSet.getBoolean("uzimtumas");
            Auto auto = new Auto(id, gamintojas, modelis, metai, uzimtumas);
            laisvuAutoSarasas.add(auto);
        }
        return laisvuAutoSarasas;
    }
    public List<Auto> carsByMaker(String gamintojas2) throws SQLException {
        SQLconnect();
        final String sql = "SELECT * FROM auto WHERE gamintojas = ?";
        PreparedStatement preparedStatement = _connection.prepareStatement(sql);

        preparedStatement.setString(1, gamintojas2);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Auto> visiAutoPagalGamintoja = new ArrayList<>();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String gamintojas = resultSet.getString("gamintojas");
            String modelis = resultSet.getString("modelis");
            int metai = resultSet.getInt("metai");
            boolean uzimtumas = resultSet.getBoolean("uzimtumas");
            Auto auto = new Auto(id, gamintojas, modelis, metai, uzimtumas);
            visiAutoPagalGamintoja.add(auto);
        }
        return visiAutoPagalGamintoja;
    }
    public List<Auto> allAutoByYear(int x) throws SQLException {
        SQLconnect();
        final String sql = "SELECT * FROM auto WHERE metai = ?";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, x);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Auto> visiAutoPagalMetus = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String gamintojas = resultSet.getString("gamintojas");
                String modelis = resultSet.getString("modelis");
                int metai = resultSet.getInt("metai");
                boolean uzimtumas = resultSet.getBoolean("uzimtumas");
                Auto auto = new Auto(id, gamintojas, modelis, metai, uzimtumas);
                visiAutoPagalMetus.add(auto);
            }
            return visiAutoPagalMetus;
        }
    }
    public List<Auto> carsRentedMoreThanXAmount(int x) throws SQLException {
        SQLconnect();
        final String sql = """
                SELECT a.id, a.gamintojas, a.modelis, a.metai, a.uzimtumas
                FROM auto a
                INNER JOIN nuoma n ON a.id = n.auto_id
                WHERE n.auto_id IN (
                    SELECT auto_id
                    FROM nuoma
                    GROUP BY auto_id
                    HAVING COUNT(auto_id) > ?
                )
                GROUP BY a.id, a.gamintojas, a.modelis, a.metai, a.uzimtumas;
                """;
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, x);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Auto> isnomuotiAutoDaugiauNeiXKartu = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String gamintojas = resultSet.getString("gamintojas");
                String modelis = resultSet.getString("modelis");
                int metai = resultSet.getInt("metai");
                boolean uzimtumas = resultSet.getBoolean("uzimtumas");

                Auto auto = new Auto(id, gamintojas, modelis, metai, uzimtumas);
                isnomuotiAutoDaugiauNeiXKartu.add(auto);
            }
            return isnomuotiAutoDaugiauNeiXKartu;
        }
    }





    private LocalDate formatDate(String dateTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate rentalDate = null;
        try {
            rentalDate = LocalDate.parse(dateTime, dateTimeFormatter);
        } catch (DateTimeParseException | NullPointerException e) {
            rentalDate = LocalDate.parse("2000-01-01", dateTimeFormatter);
        }
        return rentalDate;
    }
}
