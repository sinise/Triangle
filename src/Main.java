/**
 * Test the triangle class
 */
public class Main {
    private static int errors = 0;

    /**
     * Helper method for the testValid method
     * @param a side a
     * @param b side b
     * @param c side c
     * @return true if the triangle was created and false if the creation failed.
     */
    private static boolean testValidHelper(int a, int b, int c){

        try {
            new Triangle(a, b, c);
            return true;

        }catch(TriangleException e){
            System.out.println(e.getError());
            return false;
        }
    }

    /**
     * Test if an invalid triangle can be created
     * @param a side a
     * @param b side b
     * @param c side c
     * @param expected if the provided triangle is false (invalid) or true (valid)
     * @param test test number
     */
    private static void testValid(int a, int b, int c, boolean expected, int test){
        if (testValidHelper(a, b, c) == expected){
            System.out.println("Test " + test + " passed");
        } else {
            System.out.println("Test " + test + " failed");
            errors++;
        }
    }

    /**
     * Test if the getType method of the triangle return the correct type
     * @param a side a
     * @param b side b
     * @param c side c
     * @param expectedType the expected return value
     * @param test test number
     */
    private static void testType(int a, int b, int c, String expectedType, int test){
        try {
            Triangle triangle = new Triangle(a, b, c);
            if (triangle.getType().equals(expectedType)){
                System.out.println("Test " + test + " passed");
            } else {
                System.out.println("Test " + test + " failed");
                errors++;
            }
        }catch(TriangleException e){
            System.out.println(e.getError());

        }
    }
    
    public static void main(String[] args) {
        //one side is longer than the sum of the other two sides
        testValid(22, 1, 1, false, 1);
        testValid(1, 22, 1, false, 2);
        testValid(1, 1, 22, false, 3);

        //one side is equal to the sum of the other two sides
        testValid(22, 10, 2, false, 4);
        testValid(30, 50, 20, false, 5);
        testValid(91, 9, 100, false, 6);

        //One, two or all sides are negative
        testValid(-10, 10, 10, false, 7);
        testValid(10, -10, 10, false, 8);
        testValid(10, 10, -10, false, 9);
        testValid(-10, -10, 10, false, 10);
        testValid(10, -10, -10, false, 11);
        testValid(-10, 10, -10, false, 12);
        testValid(-1, -1, -1, false, 13);

        //One, two or all sides are 0
        testValid(0, 20, 20, false, 14);
        testValid(20, 0, 20, false, 15);
        testValid(20, 20, 0, false, 16);
        testValid(0, 0, 20, false, 17);
        testValid(20, 0, 0, false, 18);
        testValid(0, 20, 0, false, 19);
        testValid(0, 0, 0, false, 20);

        //Test creation of some valid triangles
        testValid(22, 15, 10, true, 21);
        testValid(10, 10, 1, true, 22);
        testValid(20, 20, 20, true, 23);

        //Test valid scalene triangles
        testType(4,5,6, "scalene", 24);
        testType(4,5,6, "scalene", 25);
        testType(4,5,6, "scalene", 26);

        //Test valid isosceles triangles
        testType(4, 5, 5, "isosceles", 27);
        testType(5, 4, 5, "isosceles", 28);
        testType(5, 5, 4, "isosceles", 29);

        //Test valid equilateral triangles
        testType(5,5,5, "equilateral", 30);
        testType(60,60,60, "equilateral", 31);
        testType(100,100,100, "equilateral", 32);

        System.out.println(errors + " tests failed");
    }
}
