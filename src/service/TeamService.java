package service;

import model.Team;
import repository.TeamRepository;
import exception.*;
import java.util.List;

public class TeamService {
    private final TeamRepository repository = new TeamRepository();

    public void create(Team team){
        if(team.getName().isEmpty()) {
            throw new ValidationException("Team name cannot be empty!");
        }
        repository.create(team);
    }

    public List<Team> getAll(){
        return repository.getAll();
    }

    public Team getById(int id) {
        Team team = repository.getById(id);
        return repository.getById(id);
    }

    public void update(int id, Team team) {
        repository.update(id, team);
    }

    public void delete(int id) {
        repository.delete(id);
    }
}
