package cy.ac.ucy.cs.epl231.ID1012334_1072862.homework3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class implements the graph used to store the nodes from the file
 * 
 * @author Elia Nicolaou, Demetra Hadjicosti
 * @since 20/11/2019
 */
public class Graph_1012334_1072862 {
	/**
	 * The number of vertices
	 */
	private int V;
	/**
	 * The number of edges
	 */
	private int E;
	/**
	 * The hash table with the nodes
	 */
	HashTable_1012334_1072862 nodes;
	/**
	 * The weights of the edges
	 */
	private double weights[][];
	/**
	 * The hash data of the nodes
	 */
	HashData nodes_id[];
	/**
	 * The weight of the minimum spanning tree
	 */
	double primweight;
	/**
	 * The minimum spanning tree
	 */
	ArrayList<PrimEdge> tree;

	boolean printPrim;
	/**
	 * Graph constructor
	 * 
	 * It creates a graph
	 * 
	 * @param n    The number of the vertices
	 * @param node The hash table of the nodes
	 */
	public Graph_1012334_1072862(int n, HashTable_1012334_1072862 node) {
		if (node.size <= 0)
			throw new IllegalArgumentException("Number of vertices must be > 1");
		this.V = n;
		this.E = 0;
		this.nodes = node;
		this.printPrim = false;
		create_weights();
		this.prim();
	}

	/**
	 * This function calculates the weights between the nodes and stores them in a
	 * 2d array
	 */
	private void create_weights() {
		int n = 0;
		nodes_id = new HashData[V];
		for (int i = 0; i < V; i++) {
			while (nodes.table[n] == null)
				n++;
			nodes_id[i] = nodes.table[n];
			n++;
		}
//
//		System.out.print("\t");
//		for (int i = 0; i < V; i++) {
//			System.out.print(nodes_id[i].key + "\t");
//		}

		weights = new double[V][V];

		int j = 0;
		for (int i = 0; i < V; i++) {
			for (Node_1012334_1072862 s : nodes_id[i].neighbours) {
				if (s != null) {
					j = find_the_j(s);
					weights[i][j] = Point_1012334_1072862.Distance(s.coordinates, nodes_id[i].current.coordinates);
				}
			}
		}

//		for (int i = 0; i < V; i++) {
//			System.out.println();
//			System.out.print(nodes_id[i].key + " \t ");
//			for (j = 0; j < V; j++) {
//				System.out.print(weights[i][j] + "\t");
//			}
//		}

		//System.out.println();
		//System.out.println("---------------------------------------------------------");
	}

	/**
	 * Finds the position of a given node
	 * 
	 * @param s The node that we want to find
	 * @return The position of the node in the nodes array
	 */
	private int find_the_j(Node_1012334_1072862 s) {
		for (int i = 0; i < V; i++) {
			if (nodes_id[i].current == s) {
				return i;
			}
		}
		return 0;
	}

	/**
	 * Return the number of vertices in the graph.
	 */
	public int V() {
		return V;
	}

	/**
	 * Return the number of edges in the graph.
	 */
	public int E() {
		return E;
	}

	/**
	 * Add the undirected edge v-w to graph.
	 * 
	 * @throws java.lang.IndexOutOfBoundsException unless both 0 <= v < V and 0 <= w
	 *         < V
	 */
//	public void addDirectedEdge(int v, int w, double weight) {
//		if (weight != 0) {
//			if (v < 0 || v >= V)
//				throw new IndexOutOfBoundsException();
//			if (w < 0 || w >= V)
//				throw new IndexOutOfBoundsException();
//			if (weights[v][w] == 0)
//				E++;
//			weights[v][w] = weight;
//		}
//	}

	/**
	 * Add the undirected edge v-w to graph.
	 * 
	 * @throws java.lang.IndexOutOfBoundsException unless both 0 <= v < V and 0 <= w
	 *         < V
	 */

	/**
	 * Add the undirected edge v-w to graph.
	 * 
	 * @throws java.lang.IndexOutOfBoundsException unless both 0 <= v < V and 0 <= w
	 *         < V
	 */

//	public String toString() {
//		String result = "";
//		for (int i = 0; i < V; i++)
//			for (int j = 0; j < V; j++)
//		//		if (weights[i][j] != 0)
//			//		result += ((char) (i + 65)) + "-" + ((char) (j + 65)) + ":" + weights[i][j] + "\n";
//		result += " \n\t";
//		for (int i = 0; i < V; i++)
//			result += ((char) (i + 65)) + "\t";
//		result += " \n";
//		for (int i = 0; i < V; i++) {
//			result += ((char) (i + 65)) + "\t";
//			for (int j = 0; j < V; j++) {
//	//			result += weights[i][j] + "\t";
//			}
//			result += " \n";
//		}
//		return result;
//	}
	/**
	 * This private class creates edges
	 * 
	 * Connects two nodes and holds the weight
	 * 
	 * @author Elia Nicolaou, Demetra Hadjicosti
	 *
	 */
	private class PrimEdge {
		/**
		 * The node at the start of the edge
		 */
		Node_1012334_1072862 v1;
		/**
		 * The node at the end of the edge
		 */
		Node_1012334_1072862 v2;
		/**
		 * The weight of the edge
		 */
		double weight;

		/**
		 * Edge constructor
		 * 
		 * @param current  The current node at the start of the edge
		 * @param current2 The node at the end of the edge
		 * @param weight   The weight of the edge
		 */
		PrimEdge(Node_1012334_1072862 current, Node_1012334_1072862 current2, double weight) {
			this.v1 = current;
			this.v2 = current2;
			this.weight = weight;
		}

		/**
		 * toString function that prints the path between two nodes
		 */
		public String toString() {
			return (v1.id + " ------- \t" + weight + "\t ------- " + v2.id);
		}
	}

	/**
	 * This function implements the prim algorithm
	 * 
	 * It calculates the minimum spanning tree using the prim algorithm. The prim
	 * algorithm is greedy. Each time it checks for the shortest distance connecting
	 * two nodes. Continues until all the nodes are connected in the shortest way.
	 */
	public void prim() {
        int s = one_neighboor();
		double weight = 0;
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++)
			visited[i] = false;

		HashData closest[] = new HashData[this.V];
		for (int i = 0; i < V; i++)
			closest[i] = null;

		double distance[] = new double[this.V];
		for (int i = 0; i < V; i++)
			distance[i] = Double.MAX_VALUE; // Double.MAX_VALUE = 1.7976931348623157E308

		tree = new ArrayList<PrimEdge>();

		int v = 0;
		visited[v] = true;

		for (int i = 0; i < V; i++) {
			for (int w = 0; w < V; w++) {
				if (weights[v][w] > 0 && weights[v][w] < distance[w]) {
					distance[w] = weights[v][w];
					closest[w] = nodes_id[v];
				}
			}

			if(printPrim) {
			System.out.print("VERTICES: ");
			for (int j = 0; j < V; j++) {
				System.out.print(nodes_id[j].key + "\t");
			}
			System.out.print("\nVISITED: ");
			for (int j = 0; j < visited.length; j++) {
				System.out.print(visited[j] + "\t");
			}
			System.out.print("\nCLOSEST:  ");
			for (int j = 0; j < V; j++) {
				if (closest[j] == null) {
					System.out.print("null" + "\t");
				} else {
					System.out.print(closest[j].key + "\t");
				}
			}
			System.out.print("\nDISTANCE: ");
			for (int j = 0; j < distance.length; j++) {
				if (distance[j] == Double.MAX_VALUE)
					System.out.print("INF\t");
				else
					System.out.print((int) distance[j] + "\t");
			}
			
			System.out.println(""); }

			v = minVertex(visited, distance);
			int j = find_the_j(closest[v].current);
			weight += weights[j][v];
			visited[v] = true;

			tree.add(new PrimEdge(nodes_id[j].current, nodes_id[v].current, weights[j][v]));

			if(printPrim)
			System.out.println("---------------------------------------------------------");
			
			if (tree.size() == (V - 1-s))
				break;
		}

		primweight = weight;
	}

	private int one_neighboor() {
		int n = 0;
		for(HashData s : nodes_id) {
			if(s.neighbours.size()<2) {
				n++;
			}
		}
		return n;
	}

	/**
	 * This function prints the minimum spanning tree
	 */
	public void printPrim() {
		for (int i = 0; i < tree.size(); i++)
			System.out.println(tree.get(i));
	}

	/**
	 * This function returns the smallest distance between two nodes
	 * 
	 * @param visited  Array with all the visited nodes
	 * @param distance Array with all the distances between the nodes
	 * @return Returns the smallest distance possible connecting two nodes
	 */
	private int minVertex(boolean visited[], double distance[]) {
		int min = 0;
		double minimum = Double.MAX_VALUE;
		for (int i = 0; i < V; i++) {
			if (visited[i] == true)
				continue; // skip nodes already in MST
			if (distance[i] < minimum) {
				min = i;
				minimum = distance[i];
			}
		}
		return min; // Return the minimum among all distances
	}

	/**
	 * This function prints all the temperatures of the nodes
	 */
	public void print_all_temperatures() {
		System.out.println("~~~~~~~~Temperatures~~~~~~~");
		System.out.println("---------------------------------------------------------");
		for (int i = 0; i < nodes_id.length; i++) {
			System.out.println("For id =>\t" + nodes_id[i].key + "\t temperature =\t" + nodes_id[i].current.temp);
		}
	}

	/**
	 * This function changes the temperature of the node that the user selected
	 * 
	 * @param id   The id of the node
	 * @param temp The temperature of the node
	 */
	public void change_the_temperature(String id, double temp) {
	//	System.out.print("id = " + id);
		for (int i = 0; i < nodes.table.length; i++) {
			if (nodes.table[i] != null) {
				//System.out.println(nodes.table[i].key + " == " + id);
				if (nodes.table[i].key.equals(id)) {
					nodes.table[i].current.temp = temp;
				}
			}
		}
	}

	/**
	 * This function checks if there is a danger of fire.
	 * 
	 * The function informs the first node given about a possible fire at the second
	 * node
	 * 
	 * @param id   The id of the first node we want to be informed
	 * @param id_2 The id of the second node that we want to check
	 */
	public void fire(String id, String id_2) {
		HashData firestation = null;
		HashData sensor = null;

		for (int i = 0; i < V; i++) {
			if (nodes_id[i].key.equals(id)) {
				if (nodes_id[i].current.type != 'F') {
					System.out.println("Error!!! - > the given id is not a Fire Station :(");
					return;
				} else if (nodes_id[i].current.type == 'F') {
					firestation = nodes_id[i];
					break;
				}
			}
		}

		for (int i = 0; i < V; i++) {
			if (nodes_id[i].key.equals(id_2)) {
				if (nodes_id[i].current.type != 'S') {
					System.out.println("Error!!! - > the given id is not a Sensor :(");
					return;
				} else if (nodes_id[i].current.type == 'S') {
					sensor = nodes_id[i];
					break;
				}
			}
		}

		if (sensor.current.temp > 50) {
			System.out.println("ALARM!!! IT MIGHT BE A FIRE !!!!!! ");

			for (PrimEdge s : tree) {
				if (id.equals(s.v1.id) && id_2.equals(s.v2.id) || (id_2.equals(s.v1.id) && id.equals(s.v2.id))) {
					System.out.println("The fire station is neighboor with the sensor ");
					System.out.print(s);
					return;
				}
			}
			boolean fire = false;

			ArrayList<PrimEdge> path = new ArrayList<PrimEdge>();

			Node_1012334_1072862 sen = firestation.current;
			Node_1012334_1072862 end = sensor.current;
			while (!fire) {
				for (PrimEdge s : tree) {
					if (s.v1.id.equals(sen.id)) {
						path.add(s);
						sen = s.v2;
					}
					if (s.v2.id.equals(end.id)) {
						fire = true;
						break;
					}
				}
			}
			for (PrimEdge s : path) {
				System.out.println(s);
			}
		} else {
			System.out.print("There is no fire , no reason to find a path.\n");
		}
	}

	/**
	 * This function writes back to the file when the program is ended
	 * 
	 * The updated data is written back to the file
	 * 
	 * @param args The name of the file we want to print to
	 * @throws IOException Exception for files
	 */
	public void write_back(String args) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(args));
		for (int i = 0; i < V; i++) {
			Node_1012334_1072862 s = nodes_id[i].current;
			writer.write(s.id + "\t(" + s.coordinates.x + "," + s.coordinates.y + ")\t" + s.temp + "\n");
		}
		writer.close();

	}

	/**
	 * This function adds a new node to the graph
	 * 
	 * Checks if the node can be put to the graph and places it to the appropriate
	 * position.
	 * 
	 * @param hash The hash table of the graph
	 * @param data The data table
	 * @param d    The maximum distance that 2 sensors should have
	 */
	public void add_new_data(HashTable_1012334_1072862 hash, HashData data, double d) {
		V++;
		nodes = hash;
		Node_1012334_1072862 upd = data.current;
		for (HashData s : hash.table) {
			if (s != null) {
				if (upd.notSame(s.current)) {
					if (Point_1012334_1072862.Distance(upd.coordinates, s.current.coordinates) < d) {
						s.neighbours.add(upd);
						s.weights.add(Point_1012334_1072862.Distance(upd.coordinates, s.current.coordinates));
					}
				}
			}
		}
		create_weights();
		this.prim();
	}

	/**
	 * This function removes a node from the graph
	 * 
	 * @param hash The hash table
	 */
	public void remove(HashTable_1012334_1072862 hash) {
		V--;
		nodes = hash;
		create_weights();
		this.prim();
	}
}