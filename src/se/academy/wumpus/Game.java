package se.academy.wumpus;

import java.util.Map;

public class Game {
    private Output output;
    private Map<Integer, Room> rooms;
    private Room playerLocation;
    private Room wumpusLocation;
    private boolean isOver;

    public Game(Output output) {
        this.output = output;
    }

    public void setRooms(Map<Integer, Room> rooms) {
        this.rooms = rooms;
    }

    public void setPlayerLocation(Room playerLocation) {
        this.playerLocation = playerLocation;
    }

    public void setWumpusLocation(Room wumpusLocation) {
        this.wumpusLocation = wumpusLocation;
    }

    public void acceptCommand(String command) {
        output.println("You win the game!");
        isOver = true;
    }

    public boolean isOver() {
        return isOver;
    }
}
