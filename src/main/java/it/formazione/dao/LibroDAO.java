package it.formazione.dao;

import it.formazione.model.Libro;
import it.formazione.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

    public void create(Libro libro) {
        String sql = "INSERT INTO libro (titolo, prezzo, anno_pubblicazione, copie_disponibili) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, libro.getTitolo());
            stmt.setDouble(2, libro.getPrezzo());
            stmt.setInt(3, libro.getAnnoPubblicazione());
            stmt.setInt(4, libro.getCopieDisponibili());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Libro> readAll() {
        List<Libro> libri = new ArrayList<>();
        String sql = "SELECT * FROM libro";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Libro l = new Libro();
                l.setIdLibro(rs.getLong("id_libro"));
                l.setTitolo(rs.getString("titolo"));
                l.setPrezzo(rs.getDouble("prezzo"));
                l.setAnnoPubblicazione(rs.getInt("anno_pubblicazione"));
                l.setCopieDisponibili(rs.getInt("copie_disponibili"));
                libri.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libri;
    }

    public Libro readById(long id) {
        String sql = "SELECT * FROM libro WHERE id_libro = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Libro l = new Libro();
                l.setIdLibro(rs.getLong("id_libro"));
                l.setTitolo(rs.getString("titolo"));
                l.setPrezzo(rs.getDouble("prezzo"));
                l.setAnnoPubblicazione(rs.getInt("anno_pubblicazione"));
                l.setCopieDisponibili(rs.getInt("copie_disponibili"));
                return l;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Libro libro) {
        String sql = "UPDATE libro SET titolo = ?, prezzo = ?, anno_pubblicazione = ?, copie_disponibili = ? WHERE id_libro = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, libro.getTitolo());
            stmt.setDouble(2, libro.getPrezzo());
            stmt.setInt(3, libro.getAnnoPubblicazione());
            stmt.setInt(4, libro.getCopieDisponibili());
            stmt.setLong(5, libro.getIdLibro());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(long id) {
        String sql = "DELETE FROM libro WHERE id_libro = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
