package repository;

import model.Game;
import model.Match;
import repository.impl.JdbcCrudRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GameRepository extends JdbcCrudRepository<Game> {

    @Override
    protected String getTableName() {
        return "games";
    }

    @Override
    protected Game mapRowToEntity(ResultSet rs) throws SQLException {
        return new Game(rs.getInt("id"), rs.getString("name")) {
            @Override
            public int getTeamSize() {
                return 0; // default, потом можно расширить под MOBA/FPS
            }

            @Override
            public String getGenre() {
                try {
                    return rs.getString("genre");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    @Override
    protected void setInsertParams(PreparedStatement ps, Game entity) throws SQLException {
        ps.setInt(1, entity.getId());
        ps.setString(2, entity.getName());
        ps.setString(3, entity.getGenre());
    }

    @Override
    protected void setUpdateParams(PreparedStatement ps, Game entity) throws SQLException {
        ps.setString(1, entity.getName());
        ps.setString(2, entity.getGenre());
        ps.setInt(3, entity.getId());
    }

    @Override
    public void update(int id, Game game) {
        update(game.getId(), game);
    }

    protected String getInsertSql() {
        return "INSERT INTO games (id, name, genre) VALUES (?, ?, ?)";
    }
}
