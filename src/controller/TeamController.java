package controller;

import model.Team;
import service.TeamService;

import java.util.List;
import exception.*;


public class TeamController {
    private final TeamService service = new TeamService();

    public void createTeam(Team team) {
        try {
            service.createTeam(team);
            System.out.println("<=======================>");
            System.out.println("Team " + team.getName() +" created");
        } catch (ApplicationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void listTeams(Team team) {
        try {
            List<Team> teams = service.getAll();
            teams.forEach(System.out::println);
        } catch (ApplicationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void teamById(int id) {
        try {
            service.getById(id);
        } catch (ApplicationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void deleteTeam(int id){
        try {
            service.deleteTeam(id);
            System.out.println("<=======================>");
            System.out.println("Team id " + id +" deleted");
        } catch (ApplicationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

}
