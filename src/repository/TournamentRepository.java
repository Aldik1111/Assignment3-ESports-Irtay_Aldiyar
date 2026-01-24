package repository;

import model.Tournament;
import utils.DatabaseConnection;
import exception.*;

import java.sql.*;

public class TournamentRepository {

    public void create(Tournament tournament) {
        String sql = "insert into tournaments (id, name, game_id) values (?, ?, ?)";

        try(Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, tournament.getId());
            ps.setString(2, tournament.getName());
            ps.setInt(3, tournament.getGame().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Failed to create tournament:\n " + e, e);
        }
    }


}
