package pa3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


class PA3
{
    private int V;   // No. of vertices
    public static int[][] adjacency_matrix;
    private LinkedList<Integer> adj[]; //Adjacency Lists
    public static String result = "";
    public static String label = "";
    public static String matrixResult = "";
    // Constructor
    PA3(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i){
            adj[i] = new LinkedList();
        }
        adjacency_matrix = new int[V + 1][V + 1];
    }
    //created the adjacency matrix
    void Represent_Graph_Adjacency_Matrix(int v) 
    {
        V = v;
        adjacency_matrix = new int[V + 1][V + 1];
    }
    //prints the adjacency matrix including a row and column of the vertices
    String printMatrix(int v, PA3 g){
    	System.out.println("The adjacency matrix for the given graph is: ");
    	matrixResult = "The adjacency matrix for the given graph is: " + "\n";
    	
    	matrixResult += "0 ";
        for (int i = 0; i <= v -1; i++){
            System.out.print(i + "");
            matrixResult += i + "_";
        }
        matrixResult += "\n";
      
        for (int i = 0; i <= v-1; i++) 
        {
            System.out.print(i + "|");
        	matrixResult += i + "|";
            for (int j = 0; j <= v-1; j++) {
                System.out.print(g.getEdge(i, j) + " ");
                matrixResult += g.getEdge(i, j) + " ";
            }
            matrixResult += "\n";
            System.out.println("\n");
        }
        return matrixResult;
    }
 
    // Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }
    //function to add a edge to the matrix
    void makeEdge(int to, int from, int edge){
    	 adjacency_matrix[to][from] = edge;
    }
    //function to get an edge from the matrix
    int getEdge(int to, int from) 
    {
        return adjacency_matrix[to][from];
    }
    //function to print the adjacency list
    String printGraph(PA3 g)
    {     
    	label = "Adjacency List";
        for(int v = 0; v < g.V; v++)
        {
            label += "\n" + v + ":";
            for(Integer pCrawl: g.adj[v]){
                label += "->" + pCrawl;
            }
        }
        return label;
    }
 
    // prints BFS traversal from a given source s
    String BFS(int s)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];
 
        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
 
        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);
 
        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            result += s + " ";
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
            
        }
        return result;
    }
 
    //main method that created the user interface
    public static void main(String args[])
    {
        addComponentsToFirstPane();
    }
    //creates static variables
    public static int numberOfNodes;
    public static int nodeValue1;
    public static int nodeValue2;
    public static int startingVertex;
    
    //creates first pane of the user interface
    public static JPanel addComponentsToFirstPane(){
    	JFrame frame;
    	JPanel panel;
    	frame = new JFrame("Brockman, Doyle, Parnell");
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	// get 2/3 of the height, and 2/3 of the width
    	int height = screenSize.height * 2 / 3;
    	int width = screenSize.width * 2 / 3;
    	// set the jframe height and width
    	frame.setPreferredSize(new Dimension(width, height));
    	frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    	frame.setMinimumSize(new Dimension(800, 400));
    	frame.setVisible(true);
    	panel = new JPanel();
    	panel.setBackground(new Color(0, 32, 91));
    	panel.setLayout(new GridBagLayout());
    	GridBagConstraints c = new GridBagConstraints();
    	
		JLabel title1 = new JLabel("How many nodes would you like?");
		title1.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		title1.setBackground(Color.WHITE);
		title1.setForeground(new Color(191, 13, 62));
		title1.setBorder(BorderFactory.createLineBorder(new Color(191, 13, 62)));
		c.gridx = 10;	
		c.gridy = 1;	//row 1
		c.weightx = 1.0;
		c.weighty = 1.0;
		panel.add(title1, c);
		
		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea); 
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textArea.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		textArea.setBackground(Color.WHITE);
		textArea.setForeground(new Color(191, 13, 62));
		textArea.setBorder(BorderFactory.createLineBorder(new Color(191, 13, 62)));
		c.gridx = 10;	
		c.gridy = 50;	//row 1
		c.weightx = 1.0;
  		c.weighty = 1.0;
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(true);
		panel.add(textArea, c);	

		
		JButton enterButton = new JButton("Enter");
		enterButton.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		enterButton.setForeground(new Color(0, 32, 91));
		enterButton.setBackground(new Color(191, 13, 62));
		c.gridx = 10;
		c.gridy = 90;
		c.weightx = 0.5;
  		c.weighty = 0.5;
		panel.add(enterButton, c);
		
		enterButton.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	numberOfNodes = Integer.parseInt(textArea.getText());
		    	PA3 g = new PA3(numberOfNodes);
				PA3 graph = new PA3(numberOfNodes);
		    	addComponentsToThirdPane(g, numberOfNodes, graph);
		    	frame.dispose();

			}
		});
		
		frame.getContentPane().add(panel);
        frame.revalidate();
    	return panel;
    }
    //adds the edges to the graph
    public static JPanel addComponentsToSecondPane(JFrame frame, JPanel panel, GridBagConstraints c, PA3 g, PA3 graph, int numberOfNodes, int nodeValue1, int nodeValue2){
		g.addEdge(nodeValue1, nodeValue2);

		graph.makeEdge(nodeValue1, nodeValue2, 1);
		addComponentsToThirdPane(g, numberOfNodes, graph);
		frame.dispose();

    	return panel;
    }
    //allows user to create edges
    public static JPanel addComponentsToThirdPane(PA3 g, int numberOfNodes, PA3 graph){
    	JFrame frame;
    	JPanel panel;
    	frame = new JFrame("Brockman, Doyle, Parnell");
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	// get 2/3 of the height, and 2/3 of the width
    	int height = screenSize.height * 2 / 3;
    	int width = screenSize.width * 2 / 3;
    	// set the jframe height and width
    	frame.setPreferredSize(new Dimension(width, height));
    	frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    	frame.setMinimumSize(new Dimension(800, 400));
    	frame.setVisible(true);
    	panel = new JPanel();
    	panel.setBackground(new Color(0, 32, 91));
    	panel.setLayout(new GridBagLayout());
    	GridBagConstraints c = new GridBagConstraints();
    	
		

		int[] nodeArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,16,17,18,19,20,21,22,23,24};
		String[] listArray = new String[numberOfNodes];
		for(int i = 0; i< numberOfNodes; i++){
			listArray[i] = nodeArray[i] + "";
		}
		
		JLabel listLabel1 = new JLabel("Select a node you would like to add an edge to.");
		listLabel1.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		listLabel1.setBackground(Color.WHITE);
		listLabel1.setForeground(new Color(191, 13, 62));
		listLabel1.setBorder(BorderFactory.createLineBorder(new Color(191, 13, 62)));
		c.gridx = 30;	
		c.gridy = 40;	//row 1
		c.weightx = 1.0;
		c.weighty = 1.0;
		panel.add(listLabel1, c);
		
		JList nodeList1 = new JList(listArray);
		nodeList1.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		nodeList1.setBackground(Color.WHITE);
		nodeList1.setForeground(new Color(191, 13, 62));
		nodeList1.setBorder(BorderFactory.createLineBorder(new Color(191, 13, 62)));
		nodeList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		c.gridx = 30;
		c.gridy = 50;
		c.weightx = 1.0;
		c.weighty = 1.0;
		panel.add(new JScrollPane(nodeList1), c);
			
		nodeList1.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				nodeValue1 = nodeList1.getSelectedIndex();
			}
		   });
		
		JLabel listLabel2 = new JLabel("Select the node to connect to the edge.");
		listLabel2.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		listLabel2.setBackground(Color.WHITE);
		listLabel2.setForeground(new Color(191, 13, 62));
		listLabel2.setBorder(BorderFactory.createLineBorder(new Color(191, 13, 62)));
		c.gridx = 60;	
		c.gridy = 40;	//row 1
		c.weightx = 1.0;
		c.weighty = 1.0;
		panel.add(listLabel2, c);
		
		JList nodeList2 = new JList(listArray);
		nodeList2.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		nodeList2.setBackground(Color.WHITE);
		nodeList2.setForeground(new Color(191, 13, 62));
		nodeList2.setBorder(BorderFactory.createLineBorder(new Color(191, 13, 62)));
		nodeList2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		c.gridx = 60;
		c.gridy = 50;
		c.weightx = 1.0;
		c.weighty = 1.0;
		panel.add(new JScrollPane(nodeList2), c);
		
		nodeList2.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				nodeValue2 = nodeList2.getSelectedIndex();
			}
		   });
		frame.getContentPane().add(panel);
        frame.revalidate();	
		//numberOfNodes = Integer.parseInt(textArea.getText())
		
		JButton nextButton = new JButton("Next");
		nextButton.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		nextButton.setForeground(new Color(0, 32, 91));
		nextButton.setBackground(new Color(191, 13, 62));
		c.gridx = 50;
		c.gridy = 90;
		c.weightx = 0.5;
  		c.weighty = 0.5;
		panel.add(nextButton, c);
		
		
		
		nextButton.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	addComponentsToSecondPane(frame, panel, c, g, graph, numberOfNodes, nodeValue1, nodeValue2);
		    	frame.dispose();
			}
		});
    	
    	JButton BFSButton = new JButton("BFS");
		BFSButton.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		BFSButton.setForeground(new Color(0, 32, 91));
		BFSButton.setBackground(new Color(191, 13, 62));
		c.gridx = 70;
		c.gridy = 90;
		c.weightx = 0.5;
  		c.weighty = 0.5;
		panel.add(BFSButton, c);		
		
		BFSButton.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	addComponentsToFourthPane(g, graph);
		    	frame.dispose();
			}
		});
		
		frame.getContentPane().add(panel);
        frame.revalidate();
    	return panel;
    }
    //allows user to input a starting node
    public static JPanel addComponentsToFourthPane(PA3 g, PA3 graph){
    	JFrame frame;
    	JPanel panel;
    	frame = new JFrame("Brockman, Doyle, Parnell");
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	// get 2/3 of the height, and 2/3 of the width
    	int height = screenSize.height * 2 / 3;
    	int width = screenSize.width * 2 / 3;
    	// set the jframe height and width
    	frame.setPreferredSize(new Dimension(width, height));
    	frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    	frame.setMinimumSize(new Dimension(800, 400));
    	frame.setVisible(true);
    	panel = new JPanel();
    	panel.setBackground(new Color(0, 32, 91));
    	panel.setLayout(new GridBagLayout());
    	GridBagConstraints c = new GridBagConstraints();
    	
    	JLabel title2 = new JLabel("Enter the starting vertex");
		title2.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		title2.setBackground(Color.WHITE);
		title2.setForeground(new Color(191, 13, 62));
		title2.setBorder(BorderFactory.createLineBorder(new Color(191, 13, 62)));
		c.gridx = 10;	
		c.gridy = 1;	//row 1
		c.weightx = 1.0;
		c.weighty = 1.0;
		panel.add(title2, c);
		
		JTextArea textArea1 = new JTextArea();
		JScrollPane scrollPane1 = new JScrollPane(textArea1); 
		scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textArea1.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		textArea1.setBackground(Color.WHITE);
		textArea1.setForeground(new Color(191, 13, 62));
		textArea1.setBorder(BorderFactory.createLineBorder(new Color(191, 13, 62)));
		c.gridx = 10;	
		c.gridy = 50;	//row 1
		c.weightx = 1.0;
  		c.weighty = 1.0;
		textArea1.setLineWrap(true);
		textArea1.setWrapStyleWord(true);
		textArea1.setEditable(true);
		panel.add(textArea1, c);	

		JButton searchButton = new JButton("Start Search");
		searchButton.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		searchButton.setForeground(new Color(0, 32, 91));
		searchButton.setBackground(new Color(191, 13, 62));
		c.gridx = 70;
		c.gridy = 90;
		c.weightx = 0.5;
  		c.weighty = 0.5;
		panel.add(searchButton, c);		
		
		searchButton.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	startingVertex = Integer.parseInt(textArea1.getText());
		    	addComponentsToFifthPane(frame, panel, c, g, graph, startingVertex, numberOfNodes, nodeValue1, nodeValue2);
		    	frame.dispose();
			}
		});
		
		frame.getContentPane().add(panel);
        frame.revalidate();
    	return panel;
    }
    
    public static JPanel addComponentsToFifthPane(JFrame frame, JPanel panel, GridBagConstraints c, PA3 g, PA3 graph, int startingVertex, int numberOfNodes, int nodeValue1, int nodeValue2){
    	g.addEdge(nodeValue1, nodeValue2);
    	graph.makeEdge(nodeValue1, nodeValue2, 1);
		g.printGraph(g);
    	//g.printGraph(g);
        //System.out.println("Following is Breadth First Traversal ");
//    	g.BFS(startingVertex);
       	addComponentsToSixthPane(g, startingVertex, graph);
    	return panel;
    }
    //displays result
    public static JPanel addComponentsToSixthPane(PA3 g, int startingVertex, PA3 graph){
    	
    	JFrame frame;
    	JPanel panel;
    	frame = new JFrame("Brockman, Doyle, Parnell");
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	// get 2/3 of the height, and 2/3 of the width
    	int height = screenSize.height * 2 / 3;
    	int width = screenSize.width * 2 / 3;
    	// set the jframe height and width
    	frame.setPreferredSize(new Dimension(width, height));
    	frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    	frame.setMinimumSize(new Dimension(800, 400));
    	frame.setVisible(true);
    	panel = new JPanel();
    	panel.setBackground(new Color(0, 32, 91));
    	panel.setLayout(new GridBagLayout());
    	GridBagConstraints c = new GridBagConstraints();
    	
    	JLabel title3 = new JLabel("Breadth First Traversal");
		title3.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		title3.setBackground(Color.WHITE);
		title3.setForeground(new Color(191, 13, 62));
		title3.setBorder(BorderFactory.createLineBorder(new Color(191, 13, 62)));
		c.gridx = 10;	
		c.gridy = 1;	//row 1
		c.weightx = 1.0;
		c.weighty = 1.0;
		panel.add(title3, c);
		
    	JLabel title4 = new JLabel(g.BFS(startingVertex));
		title4.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		title4.setBackground(Color.WHITE);
		title4.setForeground(new Color(191, 13, 62));
		title4.setBorder(BorderFactory.createLineBorder(new Color(191, 13, 62)));
		c.gridx = 10;	
		c.gridy = 20;	//row 1
		c.weightx = 1.0;
		c.weighty = 1.0;
		panel.add(title4, c);
		
		JTextArea textArea1 = new JTextArea();
		JScrollPane scrollPane1 = new JScrollPane(textArea1); 
		scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textArea1.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		textArea1.setBackground(Color.WHITE);
		textArea1.setForeground(new Color(191, 13, 62));
		textArea1.setBorder(BorderFactory.createLineBorder(new Color(191, 13, 62)));
		c.gridx = 10;	
		c.gridy = 50;	//row 1
		c.weightx = 1.0;
  		c.weighty = 1.0;
		textArea1.setLineWrap(false);
		textArea1.setWrapStyleWord(false);
		textArea1.setEditable(true);
		textArea1.setText(g.printGraph(g));
		panel.add(textArea1, c);
		
		JTextArea textArea2 = new JTextArea();
		JScrollPane scrollPane2 = new JScrollPane(textArea2); 
		scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textArea2.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		textArea2.setBackground(Color.WHITE);
		textArea2.setForeground(new Color(191, 13, 62));
		textArea2.setBorder(BorderFactory.createLineBorder(new Color(191, 13, 62)));
		c.gridx = 20;	
		c.gridy = 50;	//row 1
		c.weightx = 1.0;
  		c.weighty = 1.0;
		textArea2.setLineWrap(false);
		textArea2.setWrapStyleWord(false);
		textArea2.setEditable(true);
		textArea2.setText(graph.printMatrix(numberOfNodes, graph));
		panel.add(textArea2, c);
		
		JButton exit = new JButton("Exit");
		//theTime.setText(arrayImproved);
		exit.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		exit.setBackground(Color.WHITE);
		exit.setForeground(new Color(191, 13, 62));
		exit.setBorder(BorderFactory.createLineBorder(new Color(191, 13, 62)));
		c.gridx = 20;	
		c.gridy = 60;	//row 1
		c.weightx = 1.0;
  	    c.weighty = 3.0;
		panel.add(exit, c);
		
		exit.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {	 
		    	frame.dispose();
		    }
		});
		
		JButton newGraph = new JButton("Enter another Graph");
		//theTime.setText(arrayImproved);
		newGraph.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		newGraph.setBackground(Color.WHITE);
		newGraph.setForeground(new Color(191, 13, 62));
		newGraph.setBorder(BorderFactory.createLineBorder(new Color(191, 13, 62)));
		c.gridx = 10;	
		c.gridy = 60;	//row 1
		c.weightx = 1.0;
  	    c.weighty = 3.0;
		panel.add(newGraph, c);
		
		newGraph.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {	 
		    	addComponentsToFirstPane();
		    	frame.dispose();
		    }
		});

		frame.getContentPane().add(panel);
        frame.revalidate();
        

    	return panel;
    }
    

}
