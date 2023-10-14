package cy.ac.ucy.cs.epl231.ID1012334_1072862.homework3;

/**
 * This class is used for creating coordinates as Points.
 * 
 * The class creates Points with given x and y coordinates.
 *
 * @author Elia Nicolaou
 * @since 25/11/2019
 */
public class Point_1012334_1072862 {
	public int x;
	public int y;

	/**
	 * This is the empty constructor initialisation is the beginning of the axes
	 * (0,0)
	 * 
	 */
	public Point_1012334_1072862() {
		x = 0;
		y = 0;
	}

	/**
	 * This constructor takes two variables as parameters. The first variable
	 * corresponds to the x of the point and the second to the y of the point.
	 * 
	 * @param x1 the x of the point.
	 * @param y1 the y of the point.
	 */
	public Point_1012334_1072862(int x1, int y1) {
		x = x1;
		y = y1;
	}

	/**
	 * This constructor takes another object point as a parameter. Then creates an
	 * object with the corresponding elements of the given point.
	 * 
	 * @param a represents the given point that we want to create the new object
	 *          based on it.
	 */
	public Point_1012334_1072862(Point_1012334_1072862 a) {
		x = a.x;
		y = a.y;
	}

	/**
	 * Converts point to a readable form
	 */
	public String toString() {
		return "x = " + x + " " + "y = " + y;
	}
	
    /**
     * This function calculates the distance between two given point.
     * 
     * @param a The first point
     * @param b The second point
     * @return The distance between the two points
     */
	static public int Distance(Point_1012334_1072862 a, Point_1012334_1072862 b) {

		return (int) Math.sqrt(Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2));
	}

	/**
	 * Checks if the current object Point is the same with the given one.
	 * 
	 * @param p2 a given Object Point in order to check if is the same with the
	 *           current one.
	 * @return returns true if the point objects are the same, and false if they are
	 *         not.
	 */
	public boolean same(Point_1012334_1072862 p2) {
		if (x == p2.x && y == p2.y) {
			return true;
		}
		return false;
	}

}
