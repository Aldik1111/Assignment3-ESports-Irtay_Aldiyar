package repository;

import model.Player;
import model.Team;
import repository.impl.JdbcCrudRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerRepository extends JdbcCrudRepository<Player> {

    @Override
    protected String getTableName() {
        return "players";
    }

    @Override
    protected Player mapRowToEntity(ResultSet rs) throws SQLException {
        return new Player(
                rs.getInt("id"),
                rs.getString("nickname"),
                rs.getInt("age"),
                rs.getInt("rank"),
                rs.getInt("team_id")
        );
    }

    @Override
    protected void setInsertParams(PreparedStatement ps, Player entity) throws SQLException {
        ps.setInt(1, entity.getId());
        ps.setString(2, entity.getNickname());
        ps.setInt(3, entity.getAge());
        ps.setInt(4, entity.getRank());
        ps.setInt(5, entity.getTeamId());
    }

    @Override
    protected void setUpdateParams(PreparedStatement ps, Player entity) throws SQLException {
        ps.setString(1, entity.getNickname());
        ps.setInt(2, entity.getAge());
        ps.setInt(3, entity.getRank());
        ps.setInt(4, entity.getTeamId());
        ps.setInt(5, entity.getId());
    }

    @Override
    public void update(int id, Player player) {
        update(player.getId(), player);
    }

    protected String getInsertSql() {
        return "INSERT INTO players (id, nickname, age, rank, team_id) VALUES (?, ?, ?, ?, ?)";
    }
}
