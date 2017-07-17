package se.academy.wumpus.test;


import org.junit.Assert;
import org.junit.Test;
import se.academy.wumpus.Game;
import se.academy.wumpus.Room;

import java.util.*;

public class Pit {
    @Test
    public void walkingIntoAPitMeansLosing() {
        List<String> outputLines = new ArrayList<>();
        Game game = new Game(message -> outputLines.add(message));
        Map<Integer, Room> rooms = new HashMap<>();
        Room room1 = new Room(1);
        Room room2 = new Room(2);
        rooms.put(1, room1);
        rooms.put(2, room2);
        Room.connect(room1, room2);

        game.setRooms(rooms);
        game.setPlayerLocation(room1);
        game.setBottomlessPitLocations(Arrays.asList(room2));

        game.acceptCommand("move 2");

        Assert.assertTrue(outputLines.size() > 0);
        Assert.assertEquals("You lose!", outputLines.get(outputLines.size() - 1));
        Assert.assertTrue(game.isOver());
    }
    @Test
    public void walkingIntoAnEmptyRoomMeansAlive() {
        List<String> outputLines = new ArrayList<>();
        Game game = new Game(message -> outputLines.add(message));
        Map<Integer, Room> rooms = new HashMap<>();
        Room room1 = new Room(1);
        Room room2 = new Room(2);
        rooms.put(1, room1);
        rooms.put(2, room2);
        Room.connect(room1, room2);

        game.setRooms(rooms);
        game.setPlayerLocation(room1);
        game.setBottomlessPitLocations(Arrays.asList(room2));
        game.acceptCommand("move 1");
        Assert.assertTrue(outputLines.size() > 0);
        Assert.assertEquals("You are still alive!", outputLines.get(outputLines.size() - 1));
        Assert.assertFalse(game.isOver());
    }
}
