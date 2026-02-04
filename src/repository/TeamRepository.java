package repository;

import model.Team;
import repository.impl.JdbcCrudRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamRepository extends JdbcCrudRepository<Team> {

    @Override
    protected String getTableName() {
        return "teams";
    }

    @Override
    protected Team mapRowToEntity(ResultSet rs) throws SQLException {
        return new Team(rs.getInt("id"), rs.getString("name"));
    }

    @Override
    protected void setInsertParams(PreparedStatement ps, Team entity) throws SQLException {
        ps.setInt(1, entity.getId());
        ps.setString(2, entity.getName());
    }

    @Override
    protected void setUpdateParams(PreparedStatement ps, Team entity) throws SQLException {
        ps.setString(1, entity.getName());
        ps.setInt(2, entity.getId());
    }

    @Override
    public void update(int id, Team team) {
        update(team.getId(), team);
    }

    protected String getInsertSql() {
        return "INSERT INTO teams (id, name) VALUES (?, ?)";
    }
}
