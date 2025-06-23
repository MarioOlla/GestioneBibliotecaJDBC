package it.formazione.dao;

import it.formazione.model.Genere;
import it.formazione.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenereDAO {

    public void create(Genere genere) {
        String sql = "INSERT INTO genere (nome, descrizione) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, genere.getNome());
            stmt.setString(2, genere.getDescrizione());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Genere> readAll() {
        List<Genere> generi = new ArrayList<>();
        String sql = "SELECT * FROM genere";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Genere g = new Genere();
                g.setIdGenere(rs.getLong("id_genere"));
                g.setNome(rs.getString("nome"));
                g.setDescrizione(rs.getString("descrizione"));
                generi.add(g);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return generi;
    }

    public Genere readById(long id) {
        String sql = "SELECT * FROM genere WHERE id_genere = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Genere g = new Genere();
                g.setIdGenere(rs.getLong("id_genere"));
                g.setNome(rs.getString("nome"));
                g.setDescrizione(rs.getString("descrizione"));
                return g;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Genere genere) {
        String sql = "UPDATE genere SET nome = ?, descrizione = ? WHERE id_genere = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, genere.getNome());
            stmt.setString(2, genere.getDescrizione());
            stmt.setLong(3, genere.getIdGenere());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(long id) {
        String sql = "DELETE FROM genere WHERE id_genere = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
