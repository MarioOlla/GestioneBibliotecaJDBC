package it.formazione.dao;

import it.formazione.model.Autore;
import it.formazione.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutoreDAO {
    public void create(Autore autore) {
        String sql = "INSERT INTO autore (nominativo, data_di_nascita) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, autore.getNominativo());
            stmt.setDate(2, autore.getDataDiNascita());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Autore> readAll() {
        List<Autore> autori = new ArrayList<>();
        String sql = "SELECT * FROM autore";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Autore a = new Autore();
                a.setIdAutore(rs.getLong("id_autore"));
                a.setNominativo(rs.getString("nominativo"));
                a.setDataDiNascita(rs.getDate("data_di_nascita"));
                autori.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return autori;
    }

    public Autore readById(long id) {
        String sql = "SELECT * FROM autore WHERE id_autore = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Autore a = new Autore();
                a.setIdAutore(rs.getLong("id_autore"));
                a.setNominativo(rs.getString("nominativo"));
                a.setDataDiNascita(rs.getDate("data_di_nascita"));
                return a;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Autore autore) {
        String sql = "UPDATE autore SET nominativo = ?, data_di_nascita = ? WHERE id_autore = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, autore.getNominativo());
            stmt.setDate(2, autore.getDataDiNascita());
            stmt.setLong(3, autore.getIdAutore());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(long id) {
        String sql = "DELETE FROM autore WHERE id_autore = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
