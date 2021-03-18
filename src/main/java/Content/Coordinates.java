package Content;

/**
 * Class coordinates.
 */
public class Coordinates {
    private int x;
    private Integer y; //Максимальное значение поля: 941, Поле не может быть null

    public Coordinates(Integer x, Integer y) throws Exception {
        if (y == null || y > 941) {
            throw new Exception("Coordinate Y cannot be empty.\n" +
                    "Max value: 941.");
        } else if (x == null) {
            throw new Exception("Coordinate X cannot be empty.");
        } else {
            this.x = x;
            this.y = y;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
