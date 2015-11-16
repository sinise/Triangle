/**
 * Triangle v 1.0
 * Triangle.java
 * Purpose: Create a triangle and tell it's type.
 * Author: Sebastian O. Jensen
 */
public class Triangle {
    private final int a;
    private final int b;
    private final int c;
    private String type;

    /**
     * Create a valid triangle and determine its type
     * @param a Side a
     * @param b Side b
     * @param c Side c
     * @throws TriangleException
     */
    public Triangle(int a, int b, int c) throws TriangleException
    {
        this.a = a;
        this.b = b;
        this.c = c;
        validateTriangle();
        type = setType();
    }

    /**
     * Validate the triangle and throw exception if it is not valid.
     * @throws TriangleException
     */
    private void validateTriangle() throws TriangleException{
        validateTriangleHelper(a, b, c);
        validateTriangleHelper(b, a, c);
        validateTriangleHelper(c, a, b);
    }

    /**
     * Helper method for the validateTriangle method
     * @param a side a
     * @param b side b
     * @param c side c
     * @throws TriangleException
     */
    private void validateTriangleHelper(int a, int b, int c) throws TriangleException
    {
        if(a >= b + c){
            throw new TriangleException(a, b, c);
        }
        if(a <= 0){
            throw new TriangleException(a, b, c);
        }

    }

    /**
     * Determine and set the type
     * @return the type of triangle (equilateral, isosceles, scalene)
     */
    private String setType(){
        if (a == b && b == c){
            return "equilateral";
        }
        if (a == b || a == c || b == c){
            return "isosceles";
        }
        else {
            return "scalene";
        }
    }

    /**
     * @return the type of the triangle (equilateral, isosceles, scalene)
     */
    public String getType(){
        return type;
    }
}
