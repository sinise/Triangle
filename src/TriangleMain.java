/**
 * Command line program. Given 3 arguments of type int return the type of triangle
 */
class TriangleMain {
    private static ValidationHelper validationHelper;

    /**
     * Return the type of a triangle.
     * @param args The length of the triangles sides as int
     * */
    public static void main(String[] args) {
        try {
            if (!(args.length == 3)) {
                throw new IllegalArgumentException("Number of argument need to be 3");
            }
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int c = Integer.parseInt(args[2]);

            validationHelper = new ValidationHelper();
            //if triangle is valid
            if (validationHelper.validate(a, b, c)) {
                System.out.println(new Triangle(a, b, c).getType());
            }
        } catch (TriangleException te) {
            System.out.println(te.getError());
        } catch (NumberFormatException nfe) {
            System.out.println("Argument type should be of type int");
        }
    }
}
