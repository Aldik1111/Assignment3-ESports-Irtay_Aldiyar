package controller;

import model.Game;
import model.Team;
import service.TeamService;

import java.util.List;
import exception.*;


public class TeamController {
    private final TeamService service = new TeamService();

    public void create(Team team) {
        try {
            service.create(team);
            System.out.println("<=======================>");
            System.out.println("Team " + team.getName() +" created");
        } catch (ApplicationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void getAll() {
        List<Team> games = service.getAll();
        if (games.isEmpty()) {
            System.out.println("No games found.");
            return;
        }
        games.forEach(g ->
                System.out.println(g.getId() + " | " + g.getName())
        );
    }


    public void getById(int id) {
        try {
            service.getById(id);
        } catch (ApplicationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void deleteTeam(int id){
        try {
            service.delete(id);
            System.out.println("<=======================>");
            System.out.println("Team id " + id +" deleted");
        } catch (ApplicationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

}
