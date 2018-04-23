//Input for problem
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
//Holding nodes and edges
import java.util.ArrayList;
//Data structure specified for algorithm
import java.util.PriorityQueue;
//Modifying comparator to compare by weight
import java.util.Comparator;

//Main class
public class UVA10034 {
	//Inner class Node for holding the nodes read in with their properties
	public class Node {
		//X and Y coordinates
		double x;
		double y;
		//Parent of this node
		Node parent;
		//Unique identifier
		int index;
		
		//Full Argument Constructor
		public Node(double x, double y, int index) {
			this.x = x;
			this.y = y;
			parent = null;
			this.index = index;
		}
	}
	//Inner class Edge for holding the edges between nodes to know the minimum distances for the greedy picking
	public class Edge {
		//Nodes a and b that this edge is between
		Node a;
		Node b;
		//Distance between a and b or weight of the edge
		double weight;
		
		//Full Argument Constructor
		public Edge(Node a, Node b) {
			//Sets nodes a and b
			this.a = a;
			this.b = b;
			//Calculates edge between them
			this.weight = Math.sqrt(Math.pow(this.b.x - this.a.x, 2) + Math.pow(this.b.y - this.a.y, 2));
		}
	}
	//Interface based on the java comparator used for implementing the ability to compare the edge class based on weight to find the minimum weight.
	public class CompareEdges implements Comparator<Edge> {
		public int compare(Edge x, Edge y) {
			return (x.weight < y.weight) ? -1 : 1;
		}
	}
	
    //Main method
    public static void main(String[] args) throws IOException {
		//Run the program without static issues of keyword this
		UVA10034 main = new UVA10034();
		main.run();
    }
	//Avoids static issues
	public void run() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
        //Read in total number of cases to process.
        int N = Integer.parseInt(in.readLine());
		in.readLine();
		
        //Load all cases
        for (int n = 0; n < N; n++) {
            //Read in total nodes
            int nodeCount = Integer.parseInt(in.readLine());
			
            //List of all nodes
            ArrayList<Node> nodes = new ArrayList<Node>();
			
            //Load all nodes into list
            for (int j = 0; j < nodeCount; j++) {
				String[] DATA = (in.readLine()).split("\\s");
                nodes.add(new Node(Double.parseDouble(DATA[0]), Double.parseDouble(DATA[1]), j));
            }
			
			//Fill the Queue and base it off the modified comparator to prioritize by weight
			Comparator<Edge> cmp = new CompareEdges();
			PriorityQueue<Edge> edgeQueue = new PriorityQueue<Edge>(cmp);
			
			int S = nodes.size();
			for (int i = 0; i < S; i++) {
				//Starting from j avoids reading duplicate edges
				for (int j = i; j < S; j++) {
					//Add edges to processing queue
					edgeQueue.add(new Edge(nodes.get(i), nodes.get(j)));
				}
			}
			//Stores total weight.
			double totalWeight = 0;
			
			//Go from least weight to most in priority queue of edges
			while(!edgeQueue.isEmpty()) {
				Edge edge = edgeQueue.poll();
				Node a = edge.a, b = edge.b;
				
				
				//Check to see if Node a and b are in the same set. If not, merge them and add their weight to total.
				if (!(findRoot(a) == findRoot(b))) {
					//If adding edge doesnt cause cycles then add to graph
					//Find parent by setting v to its parent until its parent is null(move the vertex cursor)
					while(a.parent != null) {
						a = a.parent;
					}
					//Set the node without a parent to have node u as its parent
					a.parent = b;
					//Add new edge weight to total weight
					totalWeight += edge.weight;
				}
			}
			//Return result with 2 degrees of precision(2 decimals), total weight of tree is result
            System.out.printf("%.2f\n", totalWeight);
			if (n != N - 1 && N > 2) {
				System.out.println();
				in.readLine();
			}
        }
	}
	
    //Finds the root of the tree recursively by getting the parent of the node until we find the node with no parent
    private static int findRoot(Node node) {
        return (node.parent == null) ? node.index : findRoot(node.parent);
    }
}
