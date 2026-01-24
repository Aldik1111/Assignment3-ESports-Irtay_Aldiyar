package repository;

import model.Game;
import model.Team;
import model.Tournament;
import utils.DatabaseConnection;
import exception.*;
import repository.GameRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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


    public List<Tournament> getAll() {
        String sql = "select * from tournaments";
        List<Tournament> tournaments = new ArrayList<>();

        GameRepository gameRepo = new GameRepository();


        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Game game = gameRepo.getById(rs.getInt("game_id"));
                 Tournament tournament = new Tournament(
                        rs.getInt("id"),
                        rs.getString("name"),
                        game
                );
                tournaments.add(tournament);
            }

        } catch (SQLException e) {
            throw new DatabaseException(" Failed to fetch teams:\n " + e, e);
        }
        return tournaments;
    }

    public Tournament getById(int id) {
        String sql = "SELECT * FROM tournaments WHERE id = ?";

        GameRepository gameRepo = new GameRepository();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Game game = gameRepo.getById(rs.getInt("game_id"));
                return new Tournament(
                        rs.getInt("id"),
                        rs.getString("name"),
                        game
                );
            }

            return null;


        } catch (SQLException e) {
            throw new DatabaseException("Failed to fetch tournament:\n" + e, e);
        }
    }

    public void update(int id, Tournament tournament) {
        String sql = "update tournaments set name = ?, game_id = ? where id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tournament.getName());
            ps.setInt(2, tournament.getGame().getId());
            ps.setInt(3, tournament.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Failed to update tournament:\n " + e, e);
        }
    }

    public void delete(int id) {
        String sql = "delete from tournaments where id = ?";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e){
            throw new DatabaseException("Failed to tournament team:\n " + e, e);
        }
    }

}
