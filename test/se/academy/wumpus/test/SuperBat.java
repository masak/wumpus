package se.academy.wumpus.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import se.academy.wumpus.Game;
import se.academy.wumpus.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuperBat {
    @Test
    @Ignore // need to disable this one for now; it doesn't place any bats
    public void superBatTest() {
        List<String> outputLines = new ArrayList<>();
        Game game = new Game(message -> outputLines.add(message));
        Map<Integer, Room> rooms = new HashMap<>();
        Room room1 = new Room(1);
        Room room2 = new Room(2);
        Room room3 = new Room(3);
        rooms.put(1, room1);
        rooms.put(2, room2);
        rooms.put(3, room3);
        Room.connect(room1, room2);
        game.setRooms(rooms);
        game.setPlayerLocation(room1);

        game.acceptCommand("move 2");

        Assert.assertTrue(outputLines.size() > 0);
        Assert.assertEquals("There is a bat in here!", outputLines.get(outputLines.size() - 3));
        Assert.assertEquals("The bat lifts you and drops you in a different room.", outputLines.get(outputLines.size() - 2));
        Assert.assertEquals("You got teleported into room 3!", outputLines.get(outputLines.size() - 1));
        Assert.assertNotEquals(room2, game.getPlayerLocation());
        Assert.assertEquals(room3, game.getPlayerLocation());
        Assert.assertFalse(game.isOver());
    }
}