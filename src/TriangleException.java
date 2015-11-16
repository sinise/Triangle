/**
 * Created by sebastian on 11/16/15.
 */
public class TriangleException extends Exception {

    private int a;
    private int b;
    private int c;
    public TriangleException(int a, int b, int c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public String getError()
    {
        String error = "Triangle a=" + a + " b=" + b + " c=" + c + " is not a valid triangle";
        return error;
    }
}
