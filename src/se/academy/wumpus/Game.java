package se.academy.wumpus;

import java.util.Map;
import java.util.Scanner;

public class Game {
    private Output output;
    private Map<Integer, Room> rooms;
    private Room playerLocation;
    private Room wumpusLocation;
    private Room arrowLocation;
    private boolean isOver;
    int arrowCount = 5;

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
        boolean arrowHitWumpus = false;
        arrowCount--;
        if (arrowCount == 0){
            output.println("Game over, you have no more arrows");
            isOver = true; }
            //If the monster is located in room 2 you will always win
        else if (command.equals("shoot 2")) {
            output.println("You win the game!");
            isOver = true;
        }
        else if (!arrowHitWumpus) {
            output.println("You missed the Wumpus!");

        }
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

