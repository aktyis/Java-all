import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

public class Astar
{
        public static void main(String[] args)
	{
               Node Arad = new Node("Arad",366);
            Node Zerind = new Node("Zerind",374);
            Node Oradea = new Node("Oradea",380);
            Node Sibiu = new Node("Sibiu",253);
            Node Fagaras = new Node("Fagaras",178);
            Node Rimnicu = new Node("Rimnicu Vilcea",193);
            
            
            Node Pitesti = new Node("Pitesti",98);//Node Pitesti = new Node("Pitesti",1198);
            Node Timisoara = new Node("Timisoara",329);
            Node Lugoj = new Node("Lugoj",244);
            Node Mehadia = new Node("Mehadia",241);
            Node Drobeta = new Node("Drobeta",242);
            Node Craiova = new Node("Craiova",160);
            Node Bucharest = new Node("Bucharest",0);
            Node Giurgiu = new Node("Giurgiu",77);
            Node Urziceni = new Node("Urziceni",80);
            Node Hirsova = new Node("Hirsova",151);
            Node Eforie = new Node("Eforie",161);
            Node Valsui = new Node("Valsui",199);
            Node Iasi = new Node("Iasi",226);
            Node Neamt = new Node("Neamt",234);

            //Arad
            Arad.adjacencies = new Edge[]
            {      new Edge(Zerind,75),
                    new Edge(Sibiu,140),
                    new Edge(Timisoara,118)
            };

             //Zerind
            Zerind.adjacencies = new Edge[]
            {
                    new Edge(Arad,75),
                    new Edge(Oradea,71)
            };

             //Oradea
            Oradea.adjacencies = new Edge[]
            {
                    new Edge(Zerind,71),
                    new Edge(Sibiu,151)
            };

             //Sibiu
            Sibiu.adjacencies = new Edge[]
            {
                    new Edge(Arad,140),
                    new Edge(Fagaras,99),
                    new Edge(Oradea,151),
                    new Edge(Rimnicu,80),
            };

             //Fagaras
            Fagaras.adjacencies = new Edge[]
            {
                    new Edge(Sibiu,99),
                    new Edge(Bucharest,211)
            };

             //Rimnicu Vilcea
            Rimnicu.adjacencies = new Edge[]
            {
                    new Edge(Sibiu,80),
                    new Edge(Pitesti,97),
                    new Edge(Craiova,146)
            };

             //Pitesti
            Pitesti.adjacencies = new Edge[]
            {
                    new Edge(Rimnicu,97),
                    new Edge(Bucharest,1101),// new Edge(Bucharest,101)
                    new Edge(Craiova,138)
            };

             //Timisoara
            Timisoara.adjacencies = new Edge[]
            {
                    new Edge(Arad,118),
                    new Edge(Lugoj,111)
            };

             //Lugoj
            Lugoj.adjacencies = new Edge[]
            {
                    new Edge(Timisoara,111),
                    new Edge(Mehadia,70)
            };

             //Mehadia
            Mehadia.adjacencies = new Edge[]
            {
                    new Edge(Lugoj,70),
                    new Edge(Drobeta,75)
            };

             //Drobeta
            Drobeta.adjacencies = new Edge[]
            {
                    new Edge(Mehadia,75),
                    new Edge(Craiova,120)
            };

             //Craiova
            Craiova.adjacencies = new Edge[]
            {
                    new Edge(Drobeta,120),
                    new Edge(Rimnicu,146),
                    new Edge(Pitesti,138)
            };

            //Bucharest
            Bucharest.adjacencies = new Edge[]
            {
                    new Edge(Pitesti,101),
                    new Edge(Giurgiu,90),
                    new Edge(Fagaras,211),
                    new Edge(Urziceni,85),
            };

             //Giurgiu
            Giurgiu.adjacencies = new Edge[]
            {
                    new Edge(Bucharest,90)
            };

            //Urziceni
            Urziceni.adjacencies = new Edge[]
            {
                    new Edge(Bucharest,85),
                    new Edge(Hirsova,98),
                    new Edge(Valsui,142)
            };

            //Hirsova
            Hirsova.adjacencies = new Edge[]
            {
                    new Edge(Urziceni,98),
                    new Edge(Eforie,86)
            };

            //Eforie
            Eforie.adjacencies = new Edge[]
            {
                    new Edge(Hirsova,86)
            };

            //Valsui
            Valsui.adjacencies = new Edge[]
            {
                    new Edge(Urziceni,142),
                    new Edge(Iasi,92)
            };
            //Iasi
            Iasi.adjacencies = new Edge[]
            {
                    new Edge(Valsui,92),
                    new Edge(Neamt,87)
            };
            //Neamt
            Neamt.adjacencies = new Edge[]
            {
                    new Edge(Iasi,87)
            };

            AstarSearch(Arad,Bucharest);

            List<Node> path = printPath(Bucharest);

            System.out.println("Traversed Path: " + path);
            System.out.println("Path Cost  : " + (int) Bucharest.f_scores );
	
        }
	


        public static List<Node> printPath(Node target)
	{
                List<Node> path = new ArrayList<Node>();
        
		for(Node node = target; node!=null; node = node.parent)
		{
		    path.add(node);
		}

		Collections.reverse(path);

		return path;
        }

        public static void AstarSearch(Node source, Node goal)
	{

                Set<Node> explored = new HashSet<Node>();

                PriorityQueue<Node> queue = new PriorityQueue<Node>
		(
			20, new Comparator<Node>()
			{
				//override compare method
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
                source.g_scores = 0;
                queue.add(source);

                boolean found = false;

                while( ( !queue.isEmpty() ) && ( !found ) )
		{

                        //the node in having the lowest f_score value
                        Node current = queue.poll();

                        explored.add(current);

                        //goal found
                        if(current.value.equals(goal.value))
			{
                                found = true;
                        }

                        //check every child of current node
                        for(Edge e : current.adjacencies)
			{
                                Node child = e.target;
                                double cost = e.cost;
                                double temp_g_scores = current.g_scores + cost;
                                double temp_f_scores = temp_g_scores + child.h_scores;


                                /*if child node has been evaluated and the newer f_score is higher, skip*/
                                
                                    if((explored.contains(child)) && (temp_f_scores >= child.f_scores))
                                    {
                                            continue;
                                    }

                                /*else if child node is not in queue or  newer f_score is lower*/
                                
                                else if((!queue.contains(child)) ||  (temp_f_scores < child.f_scores))
				{
					child.parent = current;
                                        child.g_scores = temp_g_scores;
                                        child.f_scores = temp_f_scores;

                                        if(queue.contains(child))
					{
                                                queue.remove(child);
                                        }

                                        queue.add(child);

                                }

                        }

                }

        }
        
}


