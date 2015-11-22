//import java.util.PriorityQueue;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.List;
//import java.util.Comparator;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Scanner;
//
//public class IDS
//{
//    private int depth;
//    private int maxDepth;
//        public static void main(String[] args)
//	{
//                Node a = new Node("A",0);
//                Node b = new Node("B",0);
//                Node c = new Node("C",0);
//                Node d = new Node("D",0);
//                Node e = new Node("E",0);
//                Node f = new Node("F",0);
//                Node g = new Node("G",0);
//                Node h = new Node("H",0);
//                Node i = new Node("I",0);
//                Node j = new Node("J",0);
//                Node k = new Node("K",0);
//                Node l = new Node("L",0);
//                Node m = new Node("M",0);
//                Node n = new Node("N",0);
//                
//		a.adjacencies = new Edge[]
//		{
//                    new Edge(b,0),
//                    new Edge(c,0)
//                };
//                b.adjacencies = new Edge[]
//		{
//                    new Edge(d,0),
//                    new Edge(e,0)
//                };
//                c.adjacencies = new Edge[]
//		{
//                    new Edge(f,0),
//                    new Edge(g,0)
//                };
//                d.adjacencies = new Edge[]
//		{
//                    new Edge(h,0),
//                    new Edge(i,0)
//                };
//                e.adjacencies = new Edge[]
//		{
//                    new Edge(j,0),
//                    new Edge(k,0)
//                };
//                f.adjacencies = new Edge[]
//		{
//                    new Edge(f,0),
//                    new Edge(g,0)
//                };
//                g.adjacencies = new Edge[]
//		{
//                    new Edge(h,0),
//                    new Edge(i,0)
//                };
//                h.adjacencies = new Edge[]
//		{
//                    new Edge(j,0),
//                    new Edge(k,0)
//                };
//                i.adjacencies = new Edge[]
//		{
//                    new Edge(f,0),
//                    new Edge(g,0)
//                };
//                j.adjacencies = new Edge[]
//		{
//                    new Edge(h,0),
//                    new Edge(i,0)
//                };
//                k.adjacencies = new Edge[]
//		{
//                    new Edge(j,0),
//                    new Edge(k,0)
//                };
//                l.adjacencies = new Edge[]
//		{
//                    
//                };
//                m.adjacencies = new Edge[]
//		{
//                   
//                };
//                n.adjacencies = new Edge[]
//		{
//                   
//                };
////                String source,goal;
////                Scanner scanner = null;
////                System.out.println("Enter the source for the graph");
////                source = scanner.nextLine(); 
////                System.out.println("Enter the Node to Search the graph");
////                goal = scanner.nextLine(); 
//                
//                iterativeDeepningSearch(a,j);
//
//        }
//        public static void iterativeDeepningSearch(Node source, Node goal)
//	{
//        
//        }
//        
//	
//
//        public static void depthLimitedSearch(Node source, Node goal)
//	{
//            
//            Set<Node> explored = new HashSet<Node>();
//            explored.add(source);
//
//            //goal found
//            if(source.value.equals(goal.value))
//            {
//                    //found = true;
//            }
//            
//            
//
//                //cost from start
//                source.g_scores = 0;
//                queue.add(source);
//
//                boolean found = false;
//
//                while( ( !queue.isEmpty() ) && ( !found ) )
//		{
//
//                        //the node in having the lowest f_score value
//                       
//
//                        //check every child of current node
//                        for(Edge e : current.adjacencies)
//			{
//                                Node child = e.target;
//                                double cost = e.cost;
//                                double temp_g_scores = current.g_scores + cost;
//                                double temp_f_scores = temp_g_scores + child.h_scores;
//
//
//                                /*if child node has been evaluated and the newer f_score is higher, skip*/
//                                
//                                if((explored.contains(child)) && (temp_f_scores >= child.f_scores))
//				{
//                                        continue;
//                                }
//
//                                /*else if child node is not in queue or  newer f_score is lower*/
//                                
//                                else if((!queue.contains(child)) ||  (temp_f_scores < child.f_scores))
//				{
//					child.parent = current;
//                                        child.g_scores = temp_g_scores;
//                                        child.f_scores = temp_f_scores;
//
//                                        if(queue.contains(child))
//					{
//                                                queue.remove(child);
//                                        }
//
//                                        queue.add(child);
//
//                                }
//
//                        }
//
//                }
//
//        }
//        
//}
//
//
