package se.academy.wumpus.test;

import org.junit.Assert;
import org.junit.Test;
import se.academy.wumpus.Game;
import se.academy.wumpus.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shooting {
    @Test
    public void missingTheWumpus() {
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
        game.setWumpusLocation(room2);

        game.acceptCommand("shoot 3");

        Assert.assertTrue(outputLines.size() > 0);
        Assert.assertEquals("You missed the Wumpus!", outputLines.get(outputLines.size() - 1));
        Assert.assertFalse(game.isOver());
    }

    @Test
    public void outOfArrows() {
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
        game.setWumpusLocation(room2);

        game.acceptCommand("shoot 3");
        game.acceptCommand("shoot 3");
        game.acceptCommand("shoot 3");
        game.acceptCommand("shoot 3");
        game.acceptCommand("shoot 3");

        Assert.assertTrue(outputLines.size() > 0);
        Assert.assertEquals("Game over, you have no more arrows", outputLines.get(outputLines.size() - 1));
        Assert.assertTrue(game.isOver());
    }
}
