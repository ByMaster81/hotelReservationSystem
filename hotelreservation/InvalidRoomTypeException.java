package hotelreservation;
public class InvalidRoomTypeException extends Exception {

    public InvalidRoomTypeException() {
        super("Invalid room type entered.");
    }

    public InvalidRoomTypeException(String message) {
        super(message);
    }

    public InvalidRoomTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidRoomTypeException(Throwable cause) {
        super(cause);
    }
}