package repository;

import model.Match;
import model.Team;
import model.Tournament;
import utils.DatabaseConnection;
import exception.*;
import repository.TournamentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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


    public List<Match> getAll() {
        String sql = "SELECT * FROM matches";
        List<Match> matches = new ArrayList<>();

        TeamRepository teamRepo = new TeamRepository();
        TournamentRepository tournamentRepo = new TournamentRepository();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Team team1 = teamRepo.getById(rs.getInt("team1_id"));
                Team team2 = teamRepo.getById(rs.getInt("team2_id"));
                Tournament tournament = tournamentRepo.getById(rs.getInt("tournament_id"));

                Match match = new Match(
                        rs.getInt("id"),
                        team1,
                        team2,
                        tournament,
                        rs.getInt("score1"),
                        rs.getInt("score2")
                );

                matches.add(match);
            }

        } catch (SQLException e) {
            throw new DatabaseException("Failed to fetch matches", e);
        }

        return matches;
    }


    public Match getById(int id) {
        String sql = "SELECT * FROM matches WHERE id = ?";

        TeamRepository teamRepo = new TeamRepository();
        TournamentRepository tournamentRepo = new TournamentRepository();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

            Team team1 = teamRepo.getById(rs.getInt("team1_id"));
            Team team2 = teamRepo.getById(rs.getInt("team2_id"));
            Tournament tournament = tournamentRepo.getById(rs.getInt("tournament_id"));

                return new Match(
                        rs.getInt("id"),
                        team1,
                        team2,
                        tournament,
                        rs.getInt("score1"),
                        rs.getInt("score2")
                );
            } else { return null; }

        } catch (SQLException e) {
            throw new DatabaseException("Failed to fetch match:\n" + e, e);
        }
    }

    public void delete(int id) {
        String sql = "delete from matches where id = ?";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e){
            throw new DatabaseException("Failed to delete match:\n " + e, e);
        }
    }
}
