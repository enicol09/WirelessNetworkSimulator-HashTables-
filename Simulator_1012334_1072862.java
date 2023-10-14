package cy.ac.ucy.cs.epl231.ID1012334_1072862.homework3;
// Library imports
import java.io.*;
import java.util.*;

/**
 * This program simulates a network of wireless sensors which exchange and
 * handle information. The program is implemented using a graph and minimum
 * spanning trees. The user can choose from a menu for what to happen next like
 * adding to the network, changing nodes, removing nodes, producing minimum
 * spanning trees and getting information if there is a fire danger.
 * 
 * @author Elia Nicolaou, Demetra Hadjicosti
 * @since 20/11/2019
 */
public class Simulator_1012334_1072862 {
	/**
	 * Global variable for scanner (in)
	 */
	private static final Scanner scan = new Scanner(System.in);
	/**
	 * Global variable for scanner (scan)
	 */

	/**
	 * Main function of the program
	 * 
	 * It read from the file given and puts the data into a graph, next it enters a
	 * loop and the user chooses from a menu repeatedly given to him and the action
	 * chosen is happened.
	 * 
	 * @param args The arguments given from the command line
	 * @throws IOException Exception if the file is not found
	 */
	public static void main(String args[]) throws IOException {
		int select; // Selection of the user
		double d; // Largest distance that two sensors can communicate

		if (args.length != 2) {
			System.out.println("Error, Wrong amount of arguments given. Ending the program.");
			System.exit(1);
		}

		File file;
		if (args[0].endsWith(".txt")) {
			file = new File(args[0]);
		} else
			file = new File(args[0] + ".txt");

		if (!file.exists()) {
			System.out.println("Error! File given does not exist . Ending the program .");
			System.exit(1);
		}

		Scanner reader = new Scanner(file);

		String id = "", x = "", y = "";
		int cnt = 0;
		ArrayList<Node_1012334_1072862> nodes = new ArrayList<Node_1012334_1072862>();

		double temp;
		int a, b;

		boolean flag = false;
		d = Double.parseDouble(args[1]);
        // READING FROM FILE
		while (reader.hasNextLine()) {
			flag = false;
			id = reader.next();
			x = "";
			y = "";
			String coord = reader.next();
            
			// ANALYSING LINES
			for (int i = 1; i < coord.length() - 1; i++) {

				if (flag == false && coord.charAt(i) != ',' && coord.charAt(i) != ' ')
					x += coord.charAt(i);
				if (coord.charAt(i) == ',') {
					flag = true;
					i++;
				}
				if (flag == true && coord.charAt(i) != ' ')
					y += coord.charAt(i);
			}
			a = Integer.parseInt(x);
			b = Integer.parseInt(y);
			temp = reader.nextDouble();

			Node_1012334_1072862 t = new Node_1012334_1072862(id, a, b, temp, cnt);
			cnt++;
			nodes.add(t);
		}

		int size = nodes.size();

		HashTable_1012334_1072862 hash = new HashTable_1012334_1072862(size);

		// GRAPH CREATION
		for (Node_1012334_1072862 edge : nodes) {

			HashData data = new HashData(edge);

			for (Node_1012334_1072862 edge_2 : nodes) {
				if (edge.notSame(edge_2)) {
					if (Point_1012334_1072862.Distance(edge.coordinates, edge_2.coordinates) < d) {
						int weight = Point_1012334_1072862.Distance(edge.coordinates, edge_2.coordinates);
						data.neighbours.add(edge_2);
						data.weights.add(weight);
					}
				}
			}
			hash.insert(data);
		}

		int n = 0;
		for (int i = 0; i < hash.table.length; i++) {
			//int t = 0;
			if (hash.table[i] == null) {
				continue;
			}
			n++;}
			//System.out.println(" Kombos = " + hash.table[i].current.id + "\n Gitones me apostasi : ");
//			for (Node e : hash.table[i].neighbours) {
//
//				//System.out.println(" " + hash.table[i].current.id + "-" + e.id + "\t" + hash.table[i].weights.get(t));
//				t++;
//			}
			//System.out.print("\n");
//		}

		Graph_1012334_1072862 g = new Graph_1012334_1072862(n, hash);
		g.prim();
		
        // USER STARTS HERE
		do {
			printMenu();
			select = selection();
			System.out.println();
			
			if (select == 7) {
				g.write_back(args[0]);
				break;
			}
			switch (select) {
			case 1: { // CALCULATING MINIMUM SPANNING TREE
				System.out.println("Calculating the minimun spanning tree...");
				g.printPrim = true;
				g.prim();
		    	g.printPrim = false;
				break;
			}
			case 2: { // PRINTING THE MINIMUM SPANNING TREE
				g.printPrim();
				break;
			}
			case 3: { 
				
				// ADDING NEW NODE
				System.out.println("Please give  id  : ");
			boolean stop = false;
			
			while(!stop) {
				try {
				id = scan.next();
				stop = true;
				for(HashData s : g.nodes_id) {
					if(s.key.equals(id)) {
						System.out.println("\n This id , already exists in the graph . Please enter something else : ");
						stop=false;
						break;
					}
				}
	
				}
				catch(Exception e) {
					System.out.println("Error!!");
				}
			}
			
		    	System.out.println("Please now give coordinates and temperature of the new node " ); 
				String coord = scan.next();
				temp = scan.nextDouble();

				x = "";
				y = "";
				flag = false;

				for (int i = 1; i < coord.length() - 1; i++) {

					if (flag == false && coord.charAt(i) != ',' && coord.charAt(i) != ' ')
						x += coord.charAt(i);
					if (coord.charAt(i) == ',') {
						flag = true;
						i++;
					}
					if (flag == true && coord.charAt(i) != ' ')
						y += coord.charAt(i);
				}

				a = Integer.parseInt(x);
				b = Integer.parseInt(y);

				Node_1012334_1072862 t = new Node_1012334_1072862(id, a, b, temp, cnt);
				nodes.add(t);
				
				HashData data = new HashData(t);
				
				for (Node_1012334_1072862 edge_2 : nodes) {
					if (t.notSame(edge_2)) {
						if (Point_1012334_1072862.Distance(t.coordinates, edge_2.coordinates) < d) {
							int weight = Point_1012334_1072862.Distance(t.coordinates, edge_2.coordinates);
							data.neighbours.add(edge_2);
							//System.out.println(edge_2.id);
							data.weights.add(weight);
						}
					}
				}
				hash.insert(data);
				g.add_new_data(hash, data, d);
				break;
			}
			case 4: { // REMOVING NODE
				
				System.out.println("Please give  id  : ");
				boolean stop = false;
				
				while(!stop) {
					try {
					id = scan.next();
					stop = true;
					boolean stop2 = false;
					
					for(HashData s : g.nodes_id) {
						if(s.key.equals(id)) {
							stop2=true;}
						}
					
					if(!stop2) {
						System.out.println("\n This id , doesn't exists in the graph . Please enter something else : ");
							stop=false;
						
					}
		
					}
					catch(Exception e) {
						System.out.println("Error!!");
					}
				}
				
				hash.remove(id);
				g.remove(hash);
				break;
			}
			case 5: { // CHANGING TEMPERATURE TO A NODE
				g.print_all_temperatures();
				System.out.println();
				
				System.out.println("Please give  id  : ");
				boolean stop = false;
				
				while(!stop) {
					try {
					id = scan.next();
					stop = true;
					boolean stop2 = false;
					
					for(HashData s : g.nodes_id) {
						if(s.key.equals(id)) {
							stop2=true;}
						}
					
					if(!stop2) {
						System.out.println("\n This id , doesn't exists in the graph . Please enter something else : ");
							stop=false;
						
					}
		
					}
					catch(Exception e) {
						System.out.println("Error!!");
					}
				}
				
				System.out.println("Give temperature");
				temp = scan.nextDouble();
				g.change_the_temperature(id, temp);
				
				g.print_all_temperatures();
				break;
			}
			case 6: { // GIVING INFORMATION TO A IF THERE IS A FIRE IN B
				String id_2 = "";
				System.out.println("Please give id of the firestation!  : ");
				boolean stop = false;
				
				while(!stop) {
					try {
					id = scan.next();
					stop = true;
					boolean stop2 = false;
					
					for(HashData s : g.nodes_id) {
						if(s.key.equals(id)) {
							stop2=true;}
						}
					
					if(!stop2) {
						System.out.println("\n This id , doesn't exists in the graph . Please enter something else : ");
							stop=false;
						
					}
		
					}
					catch(Exception e) {
						System.out.println("Error!!");
					}
				}
				
				System.out.println("Please give id of the sensor !  : ");
				stop = false;
				
				while(!stop) {
					try {
					id_2 = scan.next();
					stop = true;
					boolean stop2 = false;
					
					for(HashData s : g.nodes_id) {
						if(s.key.equals(id_2)) {
							stop2=true;}
						}
					
					if(!stop2) {
						System.out.println("\n This id , doesn't exists in the graph . Please enter something else : ");
							stop=false;
						
					}
		
					}
					catch(Exception e) {
						System.out.println("Error!!");
					}
				}
	
				g.fire(id, id_2);
				break;
			}
			}
			System.out.println();
		} while (select != 7); //END

		System.out.println("End!");
		scan.close();
		reader.close();
	}

	/**
	 * This function prints a menu with the choices that a user can do
	 */
	public static void printMenu() {
		System.out.println("-----------------------------------------------------------------------\n"
				+ "Wireless Sensor Network Simulator\n----------------------------------\n"
				+ "1. Calculate the Minimum Spanning tree of the graph.\n"
				+ "2. Print the minimum spanning tree of the graph.\n" + "3. Insert a new node.\n"
				+ "4. Remove a node by giving its identity.\n" + "5. Change the temperature of a node.\n"
				+ "6. Inform fire station A for possible fire at node B (A and B given from user).\n" + "7. Exit\n");
	}

	/**
	 * This function gets from the user the selection from the menu that he made and
	 * check if it is valid
	 * 
	 * @return The selection of the user
	 */
	public static int selection() {
		System.out.println("\nPlease enter your selection: ");
		
		int in = 0;
		boolean stop2 = true;
		while (stop2) {
			try {
				String str = scan.next();
				in = Integer.parseInt(str);
				boolean stop3 = false;
				while (in < 1 ||  in >7) {
					stop3 = true;
					System.out.print("This number is not a choice!\nPlease insert again an above number : ");
					break;
				}
				if (!stop3) {
					stop2 = false;
				}

			} catch (Exception e) {
				System.out.print("Your input must be an integer! Give again: ");
			}
		}
		return in;
	}
}