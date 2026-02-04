package repository;

import model.Player;
import utils.DatabaseConnection;
import exception.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerRepository {

    public void create(Player player) {
        String sql = """
            INSERT INTO players (id, nickname, age, rank, team_id)
            VALUES (?, ?, ?, ?, ?)
        """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, player.getId());
            ps.setString(2, player.getNickname());
            ps.setInt(3, player.getAge());
            ps.setInt(4, player.getRank());
            ps.setInt(5, player.getTeamId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Failed to create player", e);
        }
    }

    public List<Player> getAll() {
        String sql = "SELECT * FROM players";
        List<Player> players = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                players.add(
                        new Player(
                                rs.getInt("id"),
                                rs.getString("nickname"),
                                rs.getInt("age"),
                                rs.getInt("rank"),
                                rs.getInt("team_id")
                        )
                );
            }

        } catch (SQLException e) {
            throw new DatabaseException("Failed to fetch players", e);
        }
        return players;
    }

    public List<Player> getByTeamId(int teamId) {
        String sql = "SELECT * FROM players WHERE team_id = ?";
        List<Player> players = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, teamId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                players.add(
                        new Player(
                                rs.getInt("id"),
                                rs.getString("nickname"),
                                rs.getInt("age"),
                                rs.getInt("rank"),
                                rs.getInt("team_id")
                        )
                );
            }

        } catch (SQLException e) {
            throw new DatabaseException("Failed to fetch players by team", e);
        }
        return players;
    }
}
