package repository;

import model.Match;
import src.DatabaseConnection;
import exception.*;

import java.sql.*;

public class MatchRepository {
    public void create(Match match) {
        String sql = " insert into matches (id, team1_id, team2_id, tournament_id) " +
                "values (?, ?, ?, ?)";

        try(Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, match.getId());
            ps.setInt(2, match.getTeam1Id());
            ps.setInt(3, match.getTeam2Id());
            ps.setInt(4, match.getTournamentId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Failed to create match:\n " + e, e);
        }
    }
}
