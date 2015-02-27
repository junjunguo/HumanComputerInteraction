package Calendar.model;

/**
 * A room data type for room information *
 * <p/>
 * Created by GuoJunjun <junjunguo.com> on 27/02/15.
 */

public class Room {
    private int roomID, roomSize;
    private String roomAddress;

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(int roomSize) {
        this.roomSize = roomSize;
    }

    public String getRoomAddress() {
        return roomAddress;
    }

    public void setRoomAddress(String roomAddress) {
        this.roomAddress = roomAddress;
    }
}
