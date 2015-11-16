public class Main {

    private static boolean testValidHelper(int a, int b, int c){

        try {
            Triangle triangle = new Triangle(a, b, c);
            return true;

        }catch(TriangleException e){
            System.out.println(e.getError());
            return false;
        }
    }
    private static void testValid(int a, int b, int c, boolean expected, int test){
        if (testValidHelper(a, b, c) == expected){
            System.out.println("Test " + test + " passed");
        } else {
            System.out.println("Test " + test + " failed");
        }
    }

    private static void testType(int a, int b, int c, String expectedType, int test){
        try {
            Triangle triangle = new Triangle(a, b, c);
            if (triangle.getType().equals(expectedType)){
                System.out.println("Test " + test + " passed");
            } else {
                System.out.println("Test " + test + " failed");
            } 
        }catch(TriangleException e){
            System.out.println(e.getError());
            return false;
        }
    }
    
    public static void main(String[] args) {
        //one side is longer than the sum of the other two sides
        testValid(22, 1, 1, false, 1);
        testValid(1, 22, 1, false, 2);
        testValid(1, 1, 22, false, 3);

        //one side is eaqual to the sum of the other two sides
        testValid(22, 10, 2, false, 1);
        testValid(30, 50, 20, false, 2);
        testValid(91, 9, 100, false, 3);

        // One, two or all sides are negative
        testValid(-10, 10, 10, false, 4);
        testValid(10, -10, 10, false, 5);
        testValid(10, 10, -10, false, 6);
        testValid(-10, -10, 10, false, 7);
        testValid(10, -10, -10, false, 8);
        testValid(-10, 10, -10, false, 9);
        testValid(-1, -1, -1, false, 10);

        //One, two or all sides are 0
        testValid(0, 20, 20, false, 11);
        testValid(20, 0, 20, false, 12);
        testValid(20, 20, 0, false, 13);
        testValid(0, 0, 20, false, 14);
        testValid(20, 0, 0, false, 15);
        testValid(0, 20, 0, false, 16);
        testValid(0, 0, 0, false, 17);

        //Test valid scalene triangles
        testScalene(4,5,6, "scalene", 18);
        testScalene(4,5,6, "scalene", 19);
        testScalene(4,5,6, "scalene", 20);

        //Test valid isosceles triangles
        testIsosceles(4, 5, 5, "isosceles", 21);
        testIsosceles(5, 4, 5, "isosceles", 22);
        testIsosceles(5, 5, 4, "isosceles", 23);

        //Test valid equilateral triangles
        testEquilateral(5,5,5, "equilateral", 24);
        testEquilateral(60,60,60, "equilateral", 25);
        testEquilateral(100,100,100, "equilateral", 26);
    }
}
