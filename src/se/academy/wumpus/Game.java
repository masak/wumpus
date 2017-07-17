package se.academy.wumpus;

import java.util.*;

public class Game {
    private Output output;
    private Map<Integer, Room> rooms;
    private Room playerLocation;
    private Room wumpusLocation;
    private Room arrowLocation;
    int arrowCount = 5;
    private int superBatLocation = 2;
    private boolean isOver;
    private boolean hasSuperBat;
    private List<Room> bottomlessPitLocations;

    public Game(Output output) {
        this.output = output;
        this.bottomlessPitLocations = new ArrayList<>();
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
        if (command.startsWith("shoot ")) {
            boolean arrowHitWumpus = false;
            arrowCount--;
            if (arrowCount == 0) {
                output.println("Game over, you have no more arrows");
                isOver = true;
            }
            //If the monster is located in room 2 you will always win
            else if (command.equals("shoot 2")) {
                output.println("You win the game!");
                isOver = true;
            }
            else if (!arrowHitWumpus) {
                output.println("You missed the Wumpus!");
            }
        }
        else if (command.startsWith("move ")) {
            int roomNumber = Integer.parseInt(command.split(" ")[1]);
            if (bottomlessPitLocations.stream().anyMatch(room -> room.getRoomNumber() == roomNumber)) {
                output.println("There's a bottomless pit in this room. You fall into it.");
                output.println("You lose!");
                isOver = true;
            }
            else if (command.equals("move 2")) {
                output.println("There is a bat in here!");
                output.println("The bat lifts you and drops you in a different room.");
                setPlayerLocation(rooms.get(3));

                output.println("You got teleported into room 3!");
            }
            else {
                output.println("You are still alive!");
                isOver = false;
            }
        }
    }

    public boolean isOver() {
        return isOver;
    }

    public boolean hasSuperBat() {
        return hasSuperBat;
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

    public void setBottomlessPitLocations(List<Room> bottomlessPitLocations) {
        this.bottomlessPitLocations = bottomlessPitLocations;
    }
}

