package Language;

public class Tuple {
    private String x;
    private String y;


    public Tuple(String x, String y) {
        this.x = x;
        this.y = y;
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Tuple && ((Tuple) obj).getX().equals(this.x) && ((Tuple) obj).getY().equals(this.y);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
