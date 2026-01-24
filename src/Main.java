import model.*;
import controller.*;

public class Main {
    public static void main(String[] args) {
        TeamController teamController = new TeamController();
        TournamentController tournamentController = new TournamentController();
        GameController gameController = new GameController();
        MatchController matchController = new MatchController();


        // ---- CREATE GAME ----
        Game dota = new Moba(1, "Dota 2");
        Game cs2 = new Fps(2, "CS2");

        gameController.createGame(dota);
        gameController.createGame(cs2);

        // ---- CREATE TEAMS ----
        Team alpha = new Team(1, "Team Alpha");
        Team beta = new Team(2, "Team Beta");

        teamController.createTeam(alpha);
        teamController.createTeam(beta);

        // ---- CREATE TOURNAMENT ----
        Tournament spring_2026_dota = new Tournament(1, "Spring Esports Cup",dota);

        tournamentController.create(spring_2026_dota);

        // ---- CREATE MATCH ----
        matchController.create(new Match(1, alpha, beta, spring_2026_dota));


        System.out.println("<=======================>");
        System.out.println("<=======================>");
        System.out.println("Application finished successfully.");
        System.out.println("<=======================>");
        System.out.println("<=======================>");
    }
}
