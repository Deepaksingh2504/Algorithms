// floyd warshall - to find the shortest distance between all pair of vertices

import java.util.ArrayList;
import java.util.Scanner;

public class floydWarshall {
    
    
    static class Pair
    {
        int edge;
        int weight;

        Pair(int e,int w)
        {
            this.edge=e;
            this.weight=w;
        }
    }
    static class Graph
    {
        int v;
        ArrayList<ArrayList<Pair>>adjList=new ArrayList<>();

        Graph(int v)
        {
            
            this.v=v;

            for(int i=0;i<v;i++)
            {
                adjList.add(new ArrayList<>());    
            }
        }

        void addEdge(int u, int v,int weight)
        {
            adjList.get(u).add(new Pair(v, weight));         
        }

    }

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        System.out.println("enter the no vertices u want");
        int vertex=sc.nextInt();

        Graph g=new Graph(vertex);

        System.out.println("how many edges u want to add");
        int edges=sc.nextInt();

        for(int i=0;i<edges;i++)
        {
            System.out.println("add edge");
            int u=sc.nextInt();
            int v=sc.nextInt();
            int weight=sc.nextInt();


            g.addEdge(u, v,weight);
        }



        int distance[][]=new int[vertex][vertex];

        // initializing the distance array 
        // distance from vertex u --> u will be 0 
        // distance from vertex u --> v direct will be initialized with weight given
        // and all indirect distance between u-->v will be initialized with infinity or here Integer.MAX_VALUE


        for(int i=0;i<vertex;i++)
        {
            for(int j=0;j<vertex;j++)
            {
                if(i==j)
                {
                    distance[i][j]=0;
                }
                else
                {
                    distance[i][j]=Integer.MAX_VALUE;
                }
            }
        }

        // for u ---> v direct connection putting their weight directly as their distance 

        for(int i=0;i<vertex;i++)
        {
            for(int j=0;j<g.adjList.get(i).size();j++)
            {
                distance[i][g.adjList.get(i).get(j).edge]=g.adjList.get(i).get(j).weight;
            }
        }

        // here im calculating all the indirect path  distance from i---->k---->j

        for(int k=0;k<vertex;k++)
        {
            for(int i=0;i<vertex;i++)
            {
                for(int j=0;j<vertex;j++)
                {
                    if (distance[i][k] != Integer.MAX_VALUE &&  distance[k][j] != Integer.MAX_VALUE)
                    {
                    distance[i][j]=(int )Math. min(distance[i][j],distance[i][k]+distance[k][j]);
                    }
                }
            }
        }
        
}
}
