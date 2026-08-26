import java.util.ArrayList;
import java.util.Scanner;
public class dfsGraph {

    static class graph
    {
        int v;
        ArrayList<ArrayList<Integer>>adjList=new ArrayList<>();

        public graph(int val) {
            this.v=val;

            for(int i=0;i<v;i++)
            {
                adjList.add(new ArrayList<>());
            }
        }
        void addEdge(int u,int v)
        {
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }     
    }
    
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        int vertex=sc.nextInt();
        int edge=sc.nextInt();

        graph g=new graph(vertex);

        for(int i=0;i<edge;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();

            g.addEdge(u,v);
        }

        boolean visited[]=new boolean[vertex];

        dfsTraversal(0,visited,g.adjList);

    }

    static void dfsTraversal(int u, boolean visited[],ArrayList<ArrayList<Integer>>adjList)
    {
        visited[u]=true;
        System.out.print(u+" "+"->");

        for(int i=0;i<adjList.get(u).size();i++)
        {
            if(!visited[adjList.get(u).get(i)])
            {
                dfsTraversal(adjList.get(u).get(i), visited,adjList);
                
            }
        }
    }
}
