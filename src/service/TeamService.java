package service;

import model.Team;
import repository.TeamRepository;

import java.util.List;
import java.util.Optional;

public class TeamService {

    private final TeamRepository teamRepository = new TeamRepository();

    public void createTeam(Team team) {
        teamRepository.save(team);
    }

    public Optional<Team> getTeamById(int id) {
        return teamRepository.findById(id);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public void updateTeam(Team team) {
        teamRepository.save(team);
    }

    public void deleteTeam(int id) {
        teamRepository.deleteById(id);
    }
}
