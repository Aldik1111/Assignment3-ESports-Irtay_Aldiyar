package repository;

import exception.*;
import model.Game;
import model.Team;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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


    public List<Game> getAll() {
        String sql = "select * from games";
        List<Game> games = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Game game = new Game(
                        rs.getInt("id"),
                        rs.getString("name")
                ) {
                    @Override
                    public int getTeamSize() {
                        return 0;
                    }

                    @Override
                    public String getGenre() {
                        return "";
                    }
                };
                games.add(game);
            }

        } catch (SQLException e) {
            throw new DatabaseException(" Failed to fetch games:\n " + e, e);
        }
        return games;
    }

    public Game getById(int id) {
        String sql = "SELECT * FROM games WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Game(
                        rs.getInt("id"),
                        rs.getString("name")
                ) {
                    @Override
                    public int getTeamSize() {
                        return 0;
                    }

                    @Override
                    public String getGenre() {
                        return "";
                    }
                };
            }
            else {return null;}

        } catch (SQLException e) {
            throw new DatabaseException("Failed to fetch game:\n" + e, e);
        }
    }

    public void update(int id, Game game) {
        String sql = "update games set name = ?, genre = ? where id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, game.getName());
            ps.setString(2,game.getGenre());
            ps.setInt(3, game.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Failed to update game:\n " + e, e);
        }
    }

    public void delete(int id) {
        String sql = "delete from games where id = ?";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e){
            throw new DatabaseException("Failed to delete game:\n " + e, e);
        }
    }
}
