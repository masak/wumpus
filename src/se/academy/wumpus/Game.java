package se.academy.wumpus;

import java.util.Map;
import java.util.Scanner;

public class Game {
    private Output output;
    private Map<Integer, Room> rooms;
    private Room playerLocation;
    private Room wumpusLocation;
    private boolean isOver;

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

    public static void main(String args[]) {
        char U = '\u033F';
        System.out.println("Hunt the Wumpus\n" + "         "+U+U+U+U+U+U+"\n" );


        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        while (!game.isOver()) {
            System.out.print("> ");
            String command = scanner.nextLine();
            game.acceptCommand(command);
        }
    }
}
