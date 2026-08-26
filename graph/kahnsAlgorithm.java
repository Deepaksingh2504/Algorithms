// kahns algorithm - for topological sort using bfs + indegree

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class kahnsAlgorithm
{
    static class Graph{
        int v;
        ArrayList<ArrayList<Integer>>adjList=new ArrayList<>();

        Graph(int v)
        {
            for(int i=0;i<v;i++)
            {
                adjList.add(new ArrayList<>());
            }
        }

        void addEdge(int u,int v)
        {
            adjList.get(u).add(v);
           
        }
    }

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        System.out.println("enter vertex");
        int vertices=sc.nextInt();
        
        Graph g=new Graph(vertices);

        System.out.println("enter edges");
        int edges=sc.nextInt();

        int indegree[]=new int[vertices+1];


        for(int i=0;i<edges;i++)
        {
        
            int u=sc.nextInt();
            int v=sc.nextInt();

            System.out.println("insert edges");
            g.adjList.get(u).add(v);
            indegree[v]++;
            
        }
           
            traverse(g.adjList,indegree);

    }

    static void traverse(ArrayList<ArrayList<Integer>>list,int[]indegree)
    {
          Queue<Integer>q=new LinkedList<>();

          for(int i=0;i<list.size();i++)
          {
            if(indegree[i]==0)
            {
                q.offer(i);
            }
          }

          int count =0;
          while(!q.isEmpty())
          {
            int node=q.poll();
            count++;


            for(int i=0;i<list.get(node).size();i++)
            {
                indegree[list.get(node).get(i)]--;

                    if(indegree[list.get(node).get(i)]==0)
                    {
                      q.offer(list.get(node).get(i));
                    }
                
            }
          }

          if(count != list.size())
    {
        System.out.println("\nCycle exists");
    }
    }
}
