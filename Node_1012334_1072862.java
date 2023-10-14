package cy.ac.ucy.cs.epl231.ID1012334_1072862.homework3;

/**
 * This class represents a node.
 * 
 * The nodes have certain characteristics and this class constructs them and
 * manipulates them.
 * 
 * @author Elia Nicolaou, Demetra Hadjicosti
 * @since 20/11/2019
 */
public class Node_1012334_1072862 {
	/**
	 * The type of the node (F for fire station, S for sensor)
	 */
	char type;
	/**
	 * The id of the node
	 */
	String id;
	/**
	 * The temperature of the node
	 */
	double temp;
	/**
	 * The coordinates of the node
	 */
	Point_1012334_1072862 coordinates;
	/**
	 * Serial number of node
	 */
	int num;

	/**
	 * Node's empty constructor
	 */
	public Node_1012334_1072862() {
		type = ' ';
		id = "";
		temp = 0;
	}

	/**
	 * Node constructor
	 * 
	 * Constructs a node with certain details
	 * 
	 * @param id   The id of the node
	 * @param x    The x value of the coordinate
	 * @param y    The y value of the coordinate
	 * @param temp The temperature of the node
	 * @param num  The serial number of the node
	 */
	public Node_1012334_1072862(String id, int x, int y, double temp, int num) {
		this.id = id;
		this.coordinates = new Point_1012334_1072862(x, y);
		this.temp = temp;
		check_id(id);
		this.num = num;
	}

	/**
	 * This function checks what type the node is
	 * 
	 * @param id The id of the node
	 */
	private void check_id(String id) {
		if (id.startsWith("0")) {
			this.type = 'F'; // f for fire
		} else {
			this.type = 'S'; // s for sensors
		}
	}

	/**
	 * Checks if the nodes are the same
	 * 
	 * @param edge_2 The node to check
	 * @return True if they are not same otherwise false
	 */
	public boolean notSame(Node_1012334_1072862 edge_2) {
		if (this.id != edge_2.id)
			return true;
		return false;
	}

}
