package repository;

import model.Team;
import repository.impl.InMemoryCrudRepository;
import utils.DatabaseConnection;
import exception.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeamRepository extends InMemoryCrudRepository<Team> {
    public void create(Team team){
        String sql = "insert into teams(id,name) values(?, ?)";

        try(Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, team.getId());
            ps.setString(2,team.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Failed to create team:\n " + e, e);
        }
    }

    public List<Team> getAll() {
        String sql = "select * from teams";
        List<Team> teams = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Team team = new Team(
                        rs.getInt("id"),
                        rs.getString("name")
                );
                teams.add(team);
            }

        } catch (SQLException e) {
            throw new DatabaseException(" Failed to fetch teams:\n " + e, e);
        }
    return teams;
    }

    public Team getById(int id) {
        String sql = "SELECT * FROM teams WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Team(
                        rs.getInt("id"),
                        rs.getString("name")
                );
            }
            return null;
        } catch (SQLException e) {
            throw new DatabaseException("Failed to fetch team:\n" + e, e);
        }
    }

    public void update(int id, Team team) {
        String sql = "update teams set name = ? where id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, team.getName());
            ps.setInt(2, team.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Failed to update team:\n " + e, e);
        }
    }

    public void delete(int id) {
        String sql = "delete from teams where id = ?";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e){
            throw new DatabaseException("Failed to delete team:\n " + e, e);
        }
    }
    @Override
    public void update(Team team) {
        findById(team.getId()).ifPresent(existing ->
                existing.setName(team.getName())
        );
    }


}