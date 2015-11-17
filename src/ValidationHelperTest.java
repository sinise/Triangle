/**
 * Test the triangle class
 */
public class ValidationHelperTest {
    private static int errors = 0;
    private static ValidationHelper validationHelper;

    /**
     * Test if an invalid triangle can be created
     *
     * @param a        side a
     * @param b        side b
     * @param c        side c
     * @param expected if the provided triangle is false (invalid) or true (valid)
     * @param test     test number
     */
    private static void testValidationHelper(int a, int b, int c, boolean expected, int test) {
        validationHelper = new ValidationHelper();
        boolean result = true;
        try {
            validationHelper.validate(a, b, c);
        } catch (TriangleException te) {
            result = false;
        }
        if (expected == result) {
            System.out.println("Test " + test + " passed");
        } else {
            System.out.println("Test " + test + " failed");
            errors++;
        }
    }

    /**
     * Test if the getType method of the triangle return the correct type
     *
     * @param a            side a
     * @param b            side b
     * @param c            side c
     * @param expectedType the expected return value
     * @param test         test number
     */
    private static void testType(int a, int b, int c, Triangle.TriangleType expectedType, int test) {
        try {
            Triangle triangle = new Triangle(a, b, c);
            if (triangle.getType() == expectedType) {
                System.out.println("Test " + test + " passed");
            } else {
                System.out.println("Test " + test + " failed");
                errors++;
            }
        } catch (TriangleException e) {
            System.out.println(e.getError());

        }
    }

    public static void main(String[] args) {
        //one side is longer than the sum of the other two sides
        testValidationHelper(22, 1, 1, false, 1);
        testValidationHelper(1, 22, 1, false, 2);
        testValidationHelper(1, 1, 22, false, 3);

        //one side is equal to the sum of the other two sides
        testValidationHelper(22, 10, 2, false, 4);
        testValidationHelper(30, 50, 20, false, 5);
        testValidationHelper(91, 9, 100, false, 6);

        //One, two or all sides are negative
        testValidationHelper(-10, 10, 10, false, 7);
        testValidationHelper(10, -10, 10, false, 8);
        testValidationHelper(10, 10, -10, false, 9);
        testValidationHelper(-10, -10, 10, false, 10);
        testValidationHelper(10, -10, -10, false, 11);
        testValidationHelper(-10, 10, -10, false, 12);
        testValidationHelper(-1, -1, -1, false, 13);

        //One, two or all sides are 0
        testValidationHelper(0, 20, 20, false, 14);
        testValidationHelper(20, 0, 20, false, 15);
        testValidationHelper(20, 20, 0, false, 16);
        testValidationHelper(0, 0, 20, false, 17);
        testValidationHelper(20, 0, 0, false, 18);
        testValidationHelper(0, 20, 0, false, 19);
        testValidationHelper(0, 0, 0, false, 20);

        //Test creation of some valid triangles
        testValidationHelper(22, 15, 10, true, 21);
        testValidationHelper(10, 10, 1, true, 22);
        testValidationHelper(20, 20, 20, true, 23);

        //Test valid scalene triangles
        testType(4, 5, 6, Triangle.TriangleType.SCALENE, 24);
        testType(4, 6, 5, Triangle.TriangleType.SCALENE, 25);
        testType(6, 5, 4, Triangle.TriangleType.SCALENE, 26);

        //Test valid isosceles triangles
        testType(4, 5, 5, Triangle.TriangleType.ISOSCELES, 27);
        testType(5, 4, 5, Triangle.TriangleType.ISOSCELES, 28);
        testType(5, 5, 4, Triangle.TriangleType.ISOSCELES, 29);

        //Test valid equilateral triangles
        testType(5, 5, 5, Triangle.TriangleType.EQUILATERAL, 30);

        System.out.println(errors + " tests failed");
    }
}
