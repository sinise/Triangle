/**
 * Created by sebastian on 11/16/15.
 */
public class Triangle {
    private double a;
    private double b;
    private double c;
    private String type;
    public Triangle(int a, int b, int c) throws TriangleException
    {
        this.a = a;
        this.b = b;
        this.c = c;
        validateTriangle(a, b ,c);
        setType(a, b , c);

    }
    private void validateTriangle(int a, int b, int c) throws TriangleException{
        validateTriangleHelper(a, b, c);
        validateTriangleHelper(a, c, b);
        validateTriangleHelper(b, a, c);
        validateTriangleHelper(b, c, a);
        validateTriangleHelper(c, a, b);
        validateTriangleHelper(c, b, a);
    }
    private void validateTriangleHelper(int a, int b, int c) throws TriangleException
    {
        if(a >= b + c){
            throw new TriangleException(a, b, c);
        }
        if(a <= 0){
            throw new TriangleException(a, b, c);
        }

    }
    private void setType(){

    }
}
