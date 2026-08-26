
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class dijKistraAlgorithm {

    static PriorityQueue<pair>pq=new PriorityQueue<>((a,b)->a.wt-b.wt);

    static class pair
    {
        int v;
        int wt;

        pair(int wt,int v)
        {
            this.v=v;
            this.wt=wt;
        }
    }

    static class Graph
    {
        int v;
        ArrayList<ArrayList<pair>>adjList=new ArrayList<>();

        Graph(int v)
        {
            for(int i=0;i<v;i++)
            {
                adjList.add(new ArrayList<>());
            }
        }

        void addEdge(int x, int y, int weight)
        {
            adjList.get(x).add(new pair(weight,y));
        }
    }

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        System.out.println("enter vertex");
        int vertex=sc.nextInt();

        Graph g=new Graph(vertex);

        System.out.println("enter edges");
        int edges=sc.nextInt();

        for(int i=0;i<edges;i++)
        {
            System.out.println("enter x , y , weight");
            int x=sc.nextInt();
            int y=sc.nextInt();
            int weight=sc.nextInt();

            g.addEdge(x, y, weight);
        }

        System.out.println("enter source");
        int source=sc.nextInt();

        int distance[]=new int[vertex];

        Arrays.fill(distance,Integer.MAX_VALUE);

        distance[source]=0;

        pq.offer(new pair(0,source));

        traverse(pq,g.adjList,distance);

        for(int i=0;i<distance.length;i++)
        {
            System.out.println("distance of "+i+" from source is "+ distance[i]);
        }





    }

    static void traverse(PriorityQueue<pair>pq,ArrayList<ArrayList<pair>>list,int[]distance)
    {


        while(!pq.isEmpty())
        {
       pair node=pq.poll();
       int v=node.v;
       

       for(int i=0;i<list.get(v).size();i++)
       {

        int wt=list.get(v).get(i).wt;

        if(distance[list.get(v).get(i).v]>distance[v]+wt)
        {
            distance[(list.get(v).get(i)).v]=distance[v]+wt;
            pq.offer(new pair(distance[(list.get(v).get(i)).v],list.get(v).get(i).v));
        }
       }
       
    }
}
    
}
