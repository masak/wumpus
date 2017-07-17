package se.academy.wumpus;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Output output;
    private Map<Integer, Room> rooms;
    private Room playerLocation;
    private Room wumpusLocation;
    private int superBatLocation = 2;
    private boolean isOver;
    private boolean hasSuperBat;


    public Game(Output output) {
        this.output = output;
    }

    public Game() {
        this(message -> System.out.println(message));
    }

    public void setRooms(Map<Integer, Room> rooms) {
        this.rooms = rooms;
    }

    public void setPlayerLocation(Room playerLocation) {
        this.playerLocation = playerLocation;
    }

    public Room getPlayerLocation() {
        return this.playerLocation;
    }

    public void setWumpusLocation(Room wumpusLocation) {
        this.wumpusLocation = wumpusLocation;
    }

    public void acceptCommand(String command) {
        if (command.equals("move 2")) {
            output.println("There is a bat in here!");
            output.println("The bat lifts you and drops you in a different room.");
            setPlayerLocation(rooms.get(3));

            output.println("You got teleported into room 3!");
        }
    }

    public boolean isOver() {
        return isOver;
    }

    public boolean hasSuperBat() {
        return hasSuperBat;
    }

    public static void main(String args[]) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        while (!game.isOver()) {
            System.out.print("> ");
            String command = scanner.nextLine();
            game.acceptCommand(command);
        }
    }
}
