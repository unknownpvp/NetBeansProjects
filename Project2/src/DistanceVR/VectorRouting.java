package DistanceVR;

import java.util.*;
import java.io.*;

public class VectorRouting {

    public static void main(String[] args) {
        int i, j;                                         // counter vars
        int[][] nodeInfo = readInput(args[0]);            // has the info for the links between the routers
        Router[] routers = new Router[6];         // my router object
        Scanner scanner = new Scanner(System.in);         // gets user input
        boolean singleStep;                               // true = the user wants to use single step, otherwise false
        boolean stable = false;                           // assume the system is not stable and needs to run
        int cycles = 0;                                   // cycles until stable
        String input;                                    // this will tell the program what the user has chosen how to run the program
        
        System.out.print("Would you like single step mode? (y/n): ");
        // Get what the user wants to do.
        input = scanner.nextLine();
        
        // if yes, then the user wants single step
        if(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes"))
        {
            singleStep = true;
        }
        else
        {
            singleStep = false;
        }
        
        // Begin main part of functionality
        System.out.println("Initializing routers.");
        
        // Create a list of routers
        for( i = 0; i < routers.length; i++ )
        {
            routers[i] = new Router();
            // Call the router constructor
            // The array starts at 0, but the first router starts at 1
            // var i will be used for the routerID but it starts at 0 so it needs to have 1 added to it
            routers[i].router(i+1, nodeInfo);
            System.out.println("Inital link state for router: " + (i+1) );
            // Each router has its own understanding of the current internet status
            // This will print what it knows. Which is only what it is directly connected to at the moment
            routers[i].printRoutingTable();
        }

        // The program will diverge based on user input
        if( singleStep )
        {
            // exe the single step process
            while( !stable )
            {
                // make the user advance by pressing return
                System.out.println("Please press enter to continue.");
                input = scanner.nextLine();
                stable = shareTables(routers);
                for( i = 0; i < 6; i++ )
                {
                    routers[i].printDistanceVectorTable();
                }
            }
            // We wont be needing to get anymore user input
            scanner.close();
            System.out.println("The system is now stable.");
            System.out.println("The nodes are not getting any new information");
        }
        else
        {
            // auto process
            // the system starts not stable. It will run until it is stable
            // take note of when the system started running
            // cannot be int or system will throw error
            long startTime = System.nanoTime();
            while( !stable )
            {
                //
                stable = shareTables(routers);
                // that was one cycle of the system sharing information
                cycles++;
            }
            System.out.println("The system is now stable.");
            System.out.println("The nodes are not getting any new information");
            // take note of end time
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            System.out.println("It took the system " + cycles + " cycles and " + (duration/1000000) + " milliseconds to reach stability");
        }
    }
    
    // returns true if the system is stable
    public static boolean shareTables(Router[] routers){
        int i, j;
        int[] list;            // contains the list of who needs what from who
        int detect = 0;        // has the system been updated
        boolean stable = true; // if the system is stable, this will tell the main function
        int[][] vectorTable;   // contains the information of the neighboring router
        
        // This is looping through the routers
        for( i = 0; i < 6; i++ )
        {
            // this list will tell us what nodes need to share their information with the current node in question
            list = routers[i].getNeighborTable();
            // debugging output
            // printArray(list);
            // Loop though who needs a routing table
            for( j = 0; j < list.length; j++ )
            {
                if( list[j] > 0 )
                {
                    System.out.println("Router " + (i+1) + " is getting its linked router tables.");
                    // this get the neighbor's table
                    vectorTable = routers[j].getDistanceVectorTable();
                    // updateDistanceVectorTable will return false if the table did not update.
                    // I will use this to determine if the system is stable.
                    stable = routers[i].updateDistanceVectorTable(vectorTable);
                    
                    // if the system is not stable, then detect will get pushed up from zero
                    // it will be used to return to the main function to detect if the system is indeed stable
                    if ( stable )
                    {
                        detect++;
                    }
                    System.out.println("Router " + (i+1) + " updated with router " + (j+1) );
                }
            }
        }
        if( detect == 0 )
        {
            // system is stable
            return true;
        }
        else
        {
            // system is not stable
            return false;
        }
    }
    
    // This simply reads data from the input file from what you call it in the args
    // Will return the node information
    public static int[][] readInput(String fileName){
        //
        int i = 0; 
        int j = 0;
        int[][] nodeInfo;           // will store the information of the nodes from the file
        nodeInfo = new int[24][3];  // The max size of the input will be 24 because max routers is 6 and max relationships is 4 per router
        
        try 
        {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            // Read data from the file line by line and store it in the array
            while ((line = bufferedReader.readLine()) != null) {
                // we know how the file will be formatted
		String[] lines = line.split(" ");
                for( j = 0; j < 3; j++ ){
                    // convert string to in
                    nodeInfo[i][j] = Integer.parseInt(lines[j]);
                }
                i++;
            }
            fileReader.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        // return the created array to the main function
        return nodeInfo;
    }
    
    
}
