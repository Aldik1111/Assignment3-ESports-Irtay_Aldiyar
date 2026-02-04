package repository;

import model.Match;
import model.Player;
import model.Team;
import model.Tournament;
import repository.impl.JdbcCrudRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MatchRepository extends JdbcCrudRepository<Match> {

    private final TeamRepository teamRepo = new TeamRepository();
    private final TournamentRepository tournamentRepo = new TournamentRepository();

    @Override
    protected String getTableName() {
        return "matches";
    }

    @Override
    protected Match mapRowToEntity(ResultSet rs) throws SQLException {
        Team team1 = teamRepo.findById(rs.getInt("team1_id")).orElse(null);
        Team team2 = teamRepo.findById(rs.getInt("team2_id")).orElse(null);
        Tournament tournament = tournamentRepo.findById(rs.getInt("tournament_id")).orElse(null);

        return new Match(
                rs.getInt("id"),
                team1,
                team2,
                tournament,
                rs.getInt("score1"),
                rs.getInt("score2")
        );
    }

    @Override
    protected void setInsertParams(PreparedStatement ps, Match entity) throws SQLException {
        ps.setInt(1, entity.getId());
        ps.setInt(2, entity.getTeam1Id());
        ps.setInt(3, entity.getTeam2Id());
        ps.setInt(4, entity.getTournamentId());
    }

    @Override
    protected void setUpdateParams(PreparedStatement ps, Match entity) throws SQLException {
        ps.setInt(1, entity.getTeam1Id());
        ps.setInt(2, entity.getTeam2Id());
        ps.setInt(3, entity.getTournamentId());
        ps.setInt(4, entity.getId());
    }

    @Override
    public void update(int id, Match match) {
        update(match.getId(), match);
    }


    protected String getInsertSql() {
        return "INSERT INTO matches (id, team1_id, team2_id, tournament_id) VALUES (?, ?, ?, ?)";
    }
}
