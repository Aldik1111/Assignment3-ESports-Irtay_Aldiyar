package service;

import model.Team;
import repository.TeamRepository;
import exception.*;
import java.util.List;

public class TeamService {
    private final TeamRepository repository = new TeamRepository();

    public void createTeam(Team team){
        if(team.getName().isEmpty()) {
            throw new ValidationException("Team name cannot be empty!");
        }
        repository.createTeam(team);
    }

    public List<Team> getAll(){
        return repository.getAll();
    }

    public Team getById(int id) {
        Team team = repository.getById(id);
        return repository.getById(id);
    }

    public void updateTeam(int id, Team team) {
        repository.updateTeam(id, team);
    }

    public void deleteTeam(int id) {
        repository.deleteTeam(id);
    }
}
