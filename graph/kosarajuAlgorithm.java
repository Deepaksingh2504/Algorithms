import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class kosarajuAlgorithm {
    
    static int component=0;
     static class graph{

        int v;
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();

        public graph(int val) {
           this.v=val;

           for(int i=0;i<v;i++)
           {
             list.add(new ArrayList<>());
            }      
        }

         void addEdge(int u ,int v)
          {  
           list.get(u).add(v);
          }
    }

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        System.out.println("enter the no of vertex u want ");
        int vertex=sc.nextInt();

        graph g=new graph(vertex);

        int edge=sc.nextInt();

        for(int i=0;i<edge;i++)
        {
            System.out.println("enter the edge");

            int u=sc.nextInt();
            int v=sc.nextInt();

            g.addEdge(u, v);

        }
        boolean visited[]=new boolean[vertex];

        Stack<Integer>stack=new Stack<>();

        for(int i=0;i<vertex;i++)
        {
            if(!visited[i])
            {
             topologicalSort(i,g.list,visited,stack);
            }

        }

         ArrayList<ArrayList<Integer>>Transposelist=new ArrayList<>();

         for(int i=0;i<vertex;i++)
           {
             Transposelist.add(new ArrayList<>());
            }   

        for(int i=0;i<vertex;i++)
        {
            for(int j=0;j<g.list.get(i).size();j++)
            {
                Transposelist.get(g.list.get(i).get(j)).add(i);
            }
        }
        boolean TransposeVisited[]=new boolean[vertex];
     

         while(!stack.isEmpty())
        { 
            int val=stack.pop();

            if(!TransposeVisited[val])
            {
                component++;
              dfsOnTransposeList(val,Transposelist,TransposeVisited);
            }

        }

       

    }

     static void topologicalSort(int node,ArrayList<ArrayList<Integer>>adjList,boolean visited[],Stack<Integer>stack)
     {
        visited[node]=true;

        for(int i=0;i<adjList.get(node).size();i++)
        {
            if(!visited[adjList.get(node).get(i)])
                {
                    topologicalSort(adjList.get(node).get(i), adjList, visited, stack);

                }
        }
        stack.push(node);

     }


     static void dfsOnTransposeList(int node,ArrayList<ArrayList<Integer>>adjList,boolean visited[])
     {
            visited[node]=true;

            for(int i=0;i<adjList.get(node).size();i++)
            {
                if(!visited[adjList.get(node).get(i)])
                {
                dfsOnTransposeList(adjList.get(node).get(i), adjList, visited);
                }
            
            }


     }

}

