// for finding bridge

import java.util.ArrayList;
import java.util.Scanner;
public class tarjansAlgorithm {

     static int component=0;
        static int time=0;
    
    static class Graph
    {
        int v;
        ArrayList<ArrayList<Integer>>adjList=new ArrayList<>();

        Graph(int v)
        {
            this.v=v;

            for(int i=0;i<v;i++)
            {
                adjList.add(new ArrayList<>());    
            }
        }

        void addEdge(int u, int v)
        {
            adjList.get(u).add(v);
            adjList.get(v).add(u);
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

            g.addEdge(u, v);
        }
        
        System.out.println("enter the source vertex");
        int source=sc.nextInt();
        boolean visited[]=new boolean[vertex];
        int discoveryTime[]=new int[vertex];
        int lowTime[]=new int[vertex];  
       
        

        dfs(source,visited,-1,discoveryTime,lowTime,g.adjList);

    }

    static void dfs(int source,boolean visited[],int parent,int discoveryTime[],int lowTime[],ArrayList<ArrayList<Integer>>adjList)
    {
        visited[source]=true;
        discoveryTime[source]=++time;
        lowTime[source]=time;

        for(int i=0;i<adjList.get(source).size();i++)
        {
            if(!visited[adjList.get(source).get(i)])
            {
                dfs(adjList.get(source).get(i),visited,source,discoveryTime,lowTime,adjList);

                lowTime[source]=(int)Math.min(lowTime[source],lowTime[adjList.get(source).get(i)]);

                if(discoveryTime[source]<lowTime[adjList.get(source).get(i)])
                {
                    component++;
                }
            }
            else
            {
                if(adjList.get(source).get(i)!=parent)
                {
                    lowTime[source]=(int)Math.min(lowTime[source],discoveryTime[adjList.get(source).get(i)]);
                }
                else
                {
                    continue;
                }
            }
        }
    }
}
