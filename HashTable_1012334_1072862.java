package cy.ac.ucy.cs.epl231.ID1012334_1072862.homework3;

import java.util.LinkedList;

/**
 * This class is used from the nodes.
 * 
 * Every node contains the node hash key, the position in the hash table, a list
 * with its neighbours and a list with the weights.
 * 
 * @author Elia Nicolaou, Demetra Hadjicosti
 * @since 20/11/2019
 */
class HashData {
	/**
	 * The node that we are on currently
	 */
	Node_1012334_1072862 current;
	/**
	 * The id of the node
	 */
	String key;
	/**
	 * The position of the hash data in the array
	 */
	int hashkey; // the position of it in the array
	/**
	 * This list stores the neighbours of the node
	 */
	LinkedList<Node_1012334_1072862> neighbours;
	/**
	 * The list stores the weights of the edges
	 */
	LinkedList<Integer> weights;

	/**
	 * Hash data constructor
	 * 
	 * @param s The node
	 */
	public HashData(Node_1012334_1072862 s) {
		this.current = s;
		key = s.id;
		neighbours = new LinkedList<Node_1012334_1072862>();
		weights = new LinkedList<Integer>();
	}
}

/**
 * Hash table class
 * 
 * This class creates a hash table for placing the nodes to the appropriate
 * position
 * 
 * @author Elia Nicolaou, Demetra Hadjicosti
 *
 */
public class HashTable_1012334_1072862 {
	/**
	 * The size of the hash table
	 */
	int size;
	/**
	 * The data of the hash table
	 */
	HashData table[];

	/**
	 * Hash table constructor
	 * 
	 * @param size
	 */
	public HashTable_1012334_1072862(int size) {
		table = new HashData[size * 3];
		this.size = size * 2;
	}

	/**
	 * The hash function.
	 * 
	 * Uses mod with the size of the hash table to generate the position
	 * 
	 * @param key The node to check where it will be placed
	 * @return The position that the key will be put
	 */
	int hashCode(int key) {
		return key % this.size;
	}

	/**
	 * This function add to the hash table new hash data
	 * 
	 * @param data The data to be added
	 */
	void insert(HashData data) {

		int hashIndex = hashCode(Integer.parseInt(data.key));
		data.hashkey = hashIndex;

		while (table[hashIndex] != null && table[hashIndex].key != null) {
			++hashIndex;
			hashIndex %= size;
		}

		data.hashkey = hashIndex;
		table[hashIndex] = data;
	}

	/**
	 * This function removes the node from the graph
	 * 
	 * @param id The id of the node that we want to remove
	 */
	public void remove(String id) {
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				if (table[i].key.equals(id)) {
					table[i] = null;
				}
			}
		}
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				int c = 0;
				for (Node_1012334_1072862 n : table[i].neighbours) {
					if (n.id.equals(id)) {
						table[i].neighbours.remove(c);
					}
					c++;
				}
			}
		}
	}
}