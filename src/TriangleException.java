/**
 * Exception for testing validation of a triangle
 * Created by sebastian on 11/16/15.
 */
class TriangleException extends Exception {

    private int a;
    private int b;
    private int c;
    private String reason;

    /**
     * set the sides of the invalid triangle
     *
     * @param a side a
     * @param b side b
     * @param c side c
     */
    public TriangleException(int a, int b, int c, String reason) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.reason = reason;
    }

    /**
     * @return the error messages.
     */
    public String getError() {
        return "Triangle with sides a=" + a + " b=" + b + " c=" + c + " is not " +
                "a valid triangle. " + reason;
    }
}
