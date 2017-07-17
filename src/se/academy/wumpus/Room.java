package se.academy.wumpus;

public class Room {
    private int roomNumber;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public static void connect(Room room1, Room room2) {

    }

    public int getRoomNumber() {
        return roomNumber;
    }
}
