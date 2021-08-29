package cmsc256;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/****************************************************************************
 * Cyaira Hughes
 ****************************************************************************
 * 256-901
 * Programming Project 6
 * Creates a custom graph from a file with properties
 * November 24, 2020
 ****************************************************************************/

public class CustomGraph<V> extends UnweightedGraph<V> {
	//constructors
	public CustomGraph() {
		super();
	}

	public CustomGraph(int[][] edges, int numberOfVertices) {
		super(edges, numberOfVertices);
	}

	public CustomGraph(List<Edge> edges, int numberOfVertices) {
		super(edges, numberOfVertices);
	}

	public CustomGraph(List<V> vertices, List<Edge> edges) {
		super(vertices, edges);
	}

	public CustomGraph(V[] vertices, int[][] edges) {
		super(vertices, edges);
	}

	//determines if graph is connected
	public boolean isConnected() {
		//if there are less than 2 vertices, the graph is not connected
		if (vertices.size() < 2)
			return false;
		//returns true if the number of vertices in the search tree is equal to the number of vertices in the graph
		return dfs(0).getNumberOfVerticesFound() == vertices.size();
	}

	//reads file and returns CustomGraph object
	public CustomGraph<Integer> readFile(String fileName) throws FileNotFoundException, NumberFormatException {
		//initialize variables
		int numVertices = 0;
		List<Edge> edges = new ArrayList<Edge>();
		try {
			//reads file
			Scanner readFile = new Scanner(new File(fileName));
			//initialize string array
			String[] details = new String[0];
			//the number of vertices is represented by the first line of the file
			numVertices = Integer.parseInt(readFile.nextLine());
			while (readFile.hasNextInt()) {
				details = readFile.nextLine().split(" ");
				try {
					//add edge objects to list
					for (int i = 1; i < details.length ; i++) {
						edges.add(new Edge(Integer.parseInt(details[0]), Integer.parseInt(details[i])));
					}
					//catches and throws NumberFormatException
				} catch (NumberFormatException e) {
					throw new NumberFormatException();
				}
			}
			//catches and throws FileNotFound Exception
		}catch (FileNotFoundException e){
			throw new FileNotFoundException();
		}
		//returns CustomGraph object
		return new CustomGraph<Integer>(edges,numVertices);
	}

	//returns a list of list elements that correspond to the connected components of the graph
	public List<List<Integer>> listConnectedComponents(){
		List<List<Integer>> data = new ArrayList<List<Integer>>();
		//if there is only one vertex, a list of the single vertex is returned
		if (vertices.size() == 1) {
			data.add(Collections.singletonList(0));
		}
		//if the graph is connected, a list of all connected components is added
		else if (isConnected()){
			data.add(dfs(0).getSearchOrder());
		}
		//if the graph is not connected and and not empty, connected components of the graph are added
		else if (!isConnected() && vertices.size() != 0){
			data.add(dfs(0).getSearchOrder());
			data.add(dfs(vertices.size()-1).getSearchOrder());
		}
		//returns list of listConnectedComponents
		return data;
	}

	//returns a list of the shortest path from an origin to destination
	public List<Integer> getShortestPath(int origin, int destination){
		//path is stored as the path of a search tree from origin to destination (casted to List<Integer>)
		List<Integer> path = (List<Integer>) bfs(destination).getPath(origin);
		//if the destination is not equal to the last element of the list, null iss returned
		if (destination != path.get(path.size()-1)){
			return null;
		}
		//returns path
		return path;
	}

	//determines if graph is a cycle
	public boolean hasCycle() {
			//initialize variables
			List<Integer> allVertices = new ArrayList<>();
			boolean[] isVisited = new boolean[vertices.size()];
			int[] parent = new int[vertices.size()];
			//assigns values to variables
			for (int i = 0; i < vertices.size(); i++) {
				isVisited[i] = false;
				allVertices.add((Integer) vertices.get(i));
				parent[i] = dfs(i).getParent(i);
			}
			//calls helper method on non visited elements
			for (int i = 0; i < vertices.size(); i++) {
				if (!isVisited[i]) {
					return hasCycle(i, parent, allVertices, isVisited);
				}

			}
		return false;
	}
	//helper method
	private boolean hasCycle(int u, int[] parent, List<Integer> allVertices, boolean[] isVisited) {
		//removes element from list
		allVertices.remove(u);
		//visits element
		isVisited[u] = true;
		for (Edge e : neighbors.get(u)) {
			//recursive call
			if (!isVisited[u]) {
				parent[u] = u;
				hasCycle(parent[u], parent, allVertices, isVisited); // Recursive search
			}
			//returns true or false
			return isVisited[e.u] && u != parent[u];
		}
		return false;
	}

	//yeah sorry i couldn't figure this out
	public List<Integer> findCycle(int startingVertex){
		return null;
	}
}
