package task1;

/** Multilevel inheritance: Square -> Rectangle -> Shape. */
public class Square extends Rectangle {
    public Square(double side) {
        super("Square", side, side);
    }
}
