import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class UCS
{
    public static void main(String[] args)
    {

        Node a = new Node("A",0);
        Node b = new Node("B",0);
        Node c = new Node("C",0);
        Node d = new Node("D",0);
        Node e = new Node("E",0);
        Node f = new Node("F",0);
        Node g = new Node("G",0);


        a.adjacencies = new Edge[]
        {   new Edge(d,3),
            new Edge(b,5)
        };

        b.adjacencies = new Edge[]
        {
            new Edge(c,1)
        };

        c.adjacencies = new Edge[]
        {
		new Edge(b,4)
        };                

        d.adjacencies = new Edge[]
        {
		new Edge(e,2),
		new Edge(f,2)
        };
	
	 e.adjacencies = new Edge[]
        {
		new Edge(e,2),
		new Edge(f,2)
        };

        f.adjacencies = new Edge[]
        {
            new Edge(g,3)

        };

        g.adjacencies = new Edge[]
        {
            new Edge(e,4)
        };
        System.out.println("Queue   "+ "  Expand   "+ "  Explore ");
        uniformCostSearch(a,g);

    }
	
    public static void uniformCostSearch(Node source, Node goal)
    {
        Set<Node> explored = new HashSet<Node>();

        PriorityQueue<Node> queue = new PriorityQueue<Node>
        (
            20, new Comparator<Node>()
            {				 
                @Override
                public int compare(Node i, Node j)
               {
                    if(i.f_scores > j.f_scores)
                    {
                        return 1;
                    }
                    else if (i.f_scores < j.f_scores)
                    {
                        return -1;
                    }
                    else
                    {
                        return 0;
                    }
                }
            }
        );
        //cost from start
        source.f_scores = 0;
        queue.add(source);

        boolean found = false;

        Stack Explored = new Stack();
     
        while( ( !queue.isEmpty() ) )
        {
            for(Node n : queue)
            { 
                System.out.print("  "+n.value +"("+ (int)n.f_scores +")" );
            }
            System.out.print( " ----- ");
            
            Node current = queue.poll();
           explored.add(current);
           
            System.out.print(current.value + "  ------ " );
           
            
            System.out.println( " "+Arrays.toString(Explored.toArray()));
            
            if(current.value.equals(goal.value))
            {		    
                found = true;
                //System.out.println("Node Found  :"+current.value + "  Cost : "+current.f_scores);
                break;
            }

            for(Edge e : current.adjacencies)
            { 
                
                Node child = e.target;
                double cost = e.cost;
                if((explored.contains(child)) )
                {
                    continue;
                } 

                child.f_scores = cost + current.f_scores;
                queue.add(child);
                 
		//System.out.println("Visiting   :"+child.value + "  Score : "+child.f_scores);                                     
                
            }
            Explored.push(current.value);
        }
    }        
}


