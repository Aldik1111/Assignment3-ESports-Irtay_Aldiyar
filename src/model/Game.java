package model;

public abstract class Game {

    protected int id;
    protected String name;

    // Constructor
    public Game(int id, String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Game name cannot be empty");
        }
        this.id = id;
        this.name = name;
    }

    // Abstract methods
    public abstract int getTeamSize();

    public abstract String getGenre();


    // Getters and Setters
    public String getInfo() {
        return "Game: " + name + " | Genre: " + getGenre() +
                " | Team size: " + getTeamSize();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id must be positive");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Game name cannot be empty");
        }
        this.name = name;
    }
}
