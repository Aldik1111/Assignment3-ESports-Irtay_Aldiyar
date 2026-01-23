package src;

import model.*;

public class Main {
    public static void main(String[] args) {
        // Создаем игры
        Game dota = new Moba(0,"Dota 2");
        Game csgo = new Fps(1,"CS:GO");

        Player p1 = new Player(1, "Alice", 23, 8);
        Player p2 = new Player(2, "Bob", 25, 9);
        Player p3 = new Player(3, "Charlie", 17, 7);
        Player p4 = new Player(4, "Dave", 42,9 );
        Player p5 = new Player(5, "Eve", 24, 8);

        Player p6 = new Player(6, "Max", 21, 7);
        Player p7 = new Player(7, "Leo", 23,7);
        Player p8 = new Player(8, "Nick", 32, 9);
        Player p9 = new Player(9, "Tom", 19, 9);
        Player p10 = new Player(10, "Sam", 20, 9);


        // Создаем команды
        Team teamA = new Team(1,"Alpha", dota);
        teamA.addPlayer(p1);
        teamA.addPlayer(p2);
        teamA.addPlayer(p3);
        teamA.addPlayer(p4);
        teamA.addPlayer(p5);

        Team teamB = new Team(2,"Beta", dota);
        teamB.addPlayer(p6);
        teamB.addPlayer(p7);
        teamB.addPlayer(p8);
        teamB.addPlayer(p9);
        teamB.addPlayer(p10);



        System.out.println(teamA.playerCount());
        // Создаем турнир
        Tournament tournament1 = new Tournament("Winter Cup", dota);
        tournament1.registerTeam(teamA);
        tournament1.registerTeam(teamB);



        tournament1.startTournament();

        System.out.println("Tournament:  " + tournament1.toString());

        // Создаем матч
        Match match = new Match(teamA, teamB);
        match.playMatch();
        System.out.println("Match result: " + match.getResult());

        System.out.println();
    }
}
