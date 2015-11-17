/**
 * Triangle v 1.0<br>
 * Triangle.java<br>
 * Purpose: Create a triangle and determine it's type.<br>
 * Author: Sebastian O. Jensen
 */
public class Triangle {
    public enum TriangleType {
        EQUILATERAL, ISOSCELES, SCALENE
    }

    private final int a;
    private final int b;
    private final int c;
    private TriangleType type;

    /**
     * Create a valid triangle and determine its type
     *
     * @param a Side a
     * @param b Side b
     * @param c Side c
     * @throws TriangleException
     */
    public Triangle(int a, int b, int c) throws TriangleException {
        this.a = a;
        this.b = b;
        this.c = c;
        setType();
    }

    /**
     * Determine and set the type
     */
    private void setType() {
        if (a == b && b == c) {
            type = TriangleType.EQUILATERAL;
        } else if (a == b || a == c || b == c) {
            type = TriangleType.ISOSCELES;
        } else {
            type = TriangleType.SCALENE;
        }
    }

    /**
     * @return The type of the triangle (equilateral, isosceles, scalene)
     */
    public TriangleType getType() {
        return type;
    }
}
