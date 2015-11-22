import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;
 
public class DFS
{
    private Stack<Integer> stack;
    public static int isFound=0;
    public DFS() 
    {
        stack = new Stack<Integer>();
    }
 
    public void dfs(int adjacency_matrix[][], int source , int goal)
    {
        int number_of_nodes = adjacency_matrix[source].length - 1;
 
        int visited[] = new int[number_of_nodes + 1];		
        int element = source;		
        int i = source;		
        System.out.print(element + "\t");		
        visited[source] = 1;		
        stack.push(source);
 
        while (!stack.isEmpty() && isFound!=1 )
        {
            element = stack.peek();
            i = element;	
	    while (i <= number_of_nodes)
	    {
     	        if (adjacency_matrix[element][i] == 1 && visited[i] == 0)
	        {
                    stack.push(i);
                    visited[i] = 1;
                    element = i;
                    i = 1;
			if (element == goal)
			{
				isFound= 1;
			}
                    System.out.print(element + "\t");
	            continue;
                }
                i++;
	    }
            stack.pop();	
        }
	
    }
 
    public static void main(String...arg)
    {
        int number_of_nodes, source,goal;
        Scanner scanner = null;
		try
        {
			System.out.println("Enter the number of nodes in the graph");
            scanner = new Scanner(System.in);
            number_of_nodes = scanner.nextInt();
 
			int adjacency_matrix[][] = new int[12][12];
			//System.out.println("Enter the adjacency matrix");
			for (int i = 1; i <= number_of_nodes; i++)
			{
				for (int j = 1; j <= number_of_nodes; j++)
				{
						adjacency_matrix[i][j] = 0;
				}
			}
		adjacency_matrix[1][2] = adjacency_matrix[2][1]= 1;
		adjacency_matrix[1][3] = adjacency_matrix[3][1]= 1;
		adjacency_matrix[2][1] = 1;
		adjacency_matrix[2][4] = adjacency_matrix[4][2]= 1;
		adjacency_matrix[2][5] = adjacency_matrix[5][2]= 1;
		adjacency_matrix[3][1] =  1;
		adjacency_matrix[3][6] = adjacency_matrix[6][3]= 1;
		adjacency_matrix[3][7] = adjacency_matrix[7][3]= 1;
		adjacency_matrix[4][2] = 1;
		adjacency_matrix[4][8] = adjacency_matrix[8][4]= 1;
		adjacency_matrix[5][9] =adjacency_matrix[9][5] =1;
		adjacency_matrix[5][10] =adjacency_matrix[10][5] =1;
		adjacency_matrix[6][11] = adjacency_matrix[11][6]= 1;
		//System.out.println("Enter the adjacency matrix:");
		 for (int i = 1; i <= number_of_nodes; i++)
		{
			for (int j = 1; j <= number_of_nodes; j++)
			{
				System.out.print(adjacency_matrix[i][j] + "      "  );
			}
			System.out.println(" ");
		}
			
			System.out.println("Enter the source for the graph");
			source = scanner.nextInt(); 
			System.out.println("Enter the Node to Search the graph");
				goal = scanner.nextInt(); 
	 
				System.out.println("Visited Node");
				DFS dfs = new DFS();
		dfs.dfs(adjacency_matrix, source,goal);
		System.out.println("---------------------------------------------------------");
		if (  dfs.isFound == 1)
		{
			System.out.println("------VVVVVVVVV------ Node Found-----------VVVVVVVV---------");
		}
		else
		{
			System.out.println("----XXXXX-------- Node not Found------------XXXXXX--------");
		}
		}
		catch(InputMismatchException inputMismatch)
		{
			System.out.println("Wrong Input format");
		}	
		scanner.close();	
	}	
}