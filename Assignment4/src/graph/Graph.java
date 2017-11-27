package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


//  represents a weighted undirected graph

public class Graph
{
	Vertex[] adjLists;   // array of all vertices in the graph

	public Graph(String file) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File(file));

		// read number of vertices
		adjLists = new Vertex[sc.nextInt()];

		// read vertex names & create vertices
		for (int v = 0; v < adjLists.length; v++)
		{
			adjLists[v] = new Vertex(sc.next(), null);
		}

		// read edges
		while (sc.hasNext())
		{
			// read vertex names and translate to vertex numbers
			int v1 = indexForName(sc.next());
			int v2 = indexForName(sc.next());
			int weight = sc.nextInt();

			// add v2 to front of v1's adjacency list and
			// add v1 to front of v2's adjacency list
			adjLists[v1].adjList = new AdjacencyNode(v2, adjLists[v1].adjList, weight);
			adjLists[v2].adjList = new AdjacencyNode(v1, adjLists[v2].adjList, weight);
		}
		sc.close();
	}

	int indexForName(String name)
	{
		for (int v = 0; v < adjLists.length; v++)
		{
			if (adjLists[v].name.equals(name))
			{
				return v;
			}
		}
		return -1;
	}

	// returns the number of vertices in the graph 
	public int numberOfVertices()
	{
		return adjLists.length;
	}

	// print a summary of the graph
	public void summarize()
	{
		for (int j = 0; j < numberOfVertices(); j++)
		{
			Vertex vj = adjLists[j];
			System.out.print(vj.name + ": ");
			for (AdjacencyNode e = vj.adjList; e != null; e = e.next)
			{
				System.out.print(adjLists[e.vertexNum].name + " " + e.weight + ",  ");
			}
			System.out.println();
		}
	}

	public int shortestPath(String nameFrom, String nameTo)
	{
		int start = indexForName(nameFrom);//translate String Vertex name to index
		int end = indexForName(nameTo);
		if(end<0 || start <0)
			return -1;
		SPRecord[] path = new SPRecord[adjLists.length];

		boolean[] fringe = new boolean[adjLists.length];
		boolean[] tree = new boolean[adjLists.length];

		path[start] = new SPRecord(true, -1, 0);
		tree[start] = true;


		for (AdjacencyNode neighbors = adjLists[start].adjList; neighbors != null; neighbors = neighbors.next)
		{
			fringe[neighbors.vertexNum] = true;
			path[neighbors.vertexNum] = new SPRecord(false, start, neighbors.weight);
		}

		int minDist;
		int minVertex = start;

		do
		{
			minDist = Integer.MAX_VALUE;
			for (int x = 0; x < adjLists.length; x++)
			{
				if (fringe[x] == true && path[path[x].link].inTree == true)
				{
					if (path[x].distance < minDist)
					{
						minDist = path[x].distance;
						minVertex = x;
					}
				}
			}

			path[minVertex].inTree = true;
			fringe[minVertex] = false;
			tree[minVertex] = true;

			for (AdjacencyNode neighbors = adjLists[minVertex].adjList; neighbors != null; neighbors = neighbors.next)
			{
				if (fringe[neighbors.vertexNum] == true)
				{
					if ((path[minVertex].distance + neighbors.weight) < path[neighbors.vertexNum].distance)
					{
						path[neighbors.vertexNum].distance = (path[minVertex].distance + neighbors.weight);
						path[neighbors.vertexNum].link = minVertex;
					}
				}

				if (tree[neighbors.vertexNum] == false && fringe[neighbors.vertexNum] == false)
				{
					fringe[neighbors.vertexNum] = true;
					path[neighbors.vertexNum] = new SPRecord(false, minVertex, path[minVertex].distance+neighbors.weight);
				}
			}
		}while (countTrues(fringe)>0);

		return path[indexForName(nameTo)].distance;
	}


	private int countTrues(boolean[] array)
	{
		int count = 0;
		for (int x = 0; x < array.length; x++)
		{
			if(array[x] == true)
				count++;
		}
		return count;
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		Graph g = new Graph("smallGraph.txt");
		g.summarize();
		System.out.println(g.shortestPath("Dog", "Cat"));

		Graph test = new Graph("graph.txt");
		test.summarize();
		System.out.println(test.shortestPath("Taylor", "Bobby"));
	}
}
