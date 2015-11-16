/**
 * Exception for testing validation of a triangle
 * Created by sebastian on 11/16/15.
 */
class TriangleException extends Exception {

    private final int a;
    private final int b;
    private final int c;

    /**
     * set the sides of the invalid triangle
     * @param a side a
     * @param b side b
     * @param c side c
     */
    public TriangleException(int a, int b, int c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * @return the error messages.
     */
    public String getError()
    {
        return "Triangle a=" + a + " b=" + b + " c=" + c + " is not a valid triangle";
    }
}
