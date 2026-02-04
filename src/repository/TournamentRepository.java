package repository;

import model.Game;
import model.Tournament;
import repository.impl.JdbcCrudRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TournamentRepository extends JdbcCrudRepository<Tournament> {

    private final GameRepository gameRepo = new GameRepository();

    @Override
    protected String getTableName() {
        return "tournaments";
    }

    @Override
    protected Tournament mapRowToEntity(ResultSet rs) throws SQLException {
        Game game = gameRepo.findById(rs.getInt("game_id")).orElse(null);
        return new Tournament(rs.getInt("id"), rs.getString("name"), game);
    }

    @Override
    protected void setInsertParams(PreparedStatement ps, Tournament entity) throws SQLException {
        ps.setInt(1, entity.getId());
        ps.setString(2, entity.getName());
        ps.setInt(3, entity.getGame().getId());
    }

    @Override
    protected void setUpdateParams(PreparedStatement ps, Tournament entity) throws SQLException {
        ps.setString(1, entity.getName());
        ps.setInt(2, entity.getGame().getId());
        ps.setInt(3, entity.getId());
    }


    protected String getInsertSql() {
        return "INSERT INTO tournaments (id, name, game_id) VALUES (?, ?, ?)";
    }

    @Override
    public void update(int id, Tournament tournament) {
        update(tournament.getId(), tournament);
    }
}
