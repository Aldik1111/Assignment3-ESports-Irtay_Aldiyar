package repository;

import exception.*;
import model.Game;
import src.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GameRepository{

    public void create(Game game) {
        String sql = "insert into games (id, name, genre) values (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, game.getId());
            ps.setString(2, game.getName());
            ps.setString(3, game.getGenre());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Failed to create game:\n " + e, e);
        }
    }
}
