/**
 * Validate if arguments can be used to form a triangle
 */
class ValidationHelper {
    /**
     * Validate that a valid triangle can be constructed from the
     * given length.
     *
     * @param a Side a
     * @param b Side b
     * @param c Side c
     * @return true if tests passed
     * @throws TriangleException
     */
    public boolean validate(int a, int b, int c) throws TriangleException {

        if (a <= 0 || b <= 0 || c <= 0) {
            throw new TriangleException(a, b, c, "One side is negative or 0");
        }
        if (a >= b + c || b >= a + c || c >= a + b) {
            throw new TriangleException(a, b, c, "The length of one side is " +
                    "longer or equal to the sum of the two other sides");
        }
        return true;
    }
}
