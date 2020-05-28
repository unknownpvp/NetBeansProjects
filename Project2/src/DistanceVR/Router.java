package DistanceVR;

public class Router {
    private int routerID;
    private int[][] routingTable; // Network topology from routers A to B
    private int[][] distanceVectorTable; // Routing table from A to C
    public static final int MAX_NODES = 6;
    
    
    // router constructor
    public void router(int routerID, int[][] nodeInfo){
        int i, j, k, l;
        this.routerID = routerID;
        this.routingTable = new int[MAX_NODES][MAX_NODES];         // inital table for the links
        this.distanceVectorTable = new int[MAX_NODES][MAX_NODES];  // as info gets shared, this table will update
        
        // start by init the two graph arrays
        for( i = 0; i < MAX_NODES; i++ ){
            for( j = 0; j < MAX_NODES; j++ ){
                // Assuming all routers have a cost of 0 to themselves
                if( i == j ){
                    this.routingTable[i][j] = 0;
                }
                else{
                    // 16 indicates an infinite time
                    this.routingTable[i][j] = 16;
                }
            }
        }
        
        // Fill in the data to the routing table from the input file
        // loop though the input file data
        for( i = 0; i < nodeInfo.length; i++ ){
            // length - 1 becuse I do not want the program to think the cost is a node
            for( j = 0; j < nodeInfo[0].length-1; j++ ){
                // if the router finds itself
                if( routerID == nodeInfo[i][j]){
                    k = routerID - 1;
                    // if the router finds a link in the file, then it needs to update itself
                    // these if statements will decide where I am in the array that discribes the links and update with
                    // the correct value.
                    if( j == 0 ){
                        l = nodeInfo[i][1] - 1;
                        // I know that the cost is stored in place value 2 so it has been hard coded
                        this.routingTable[k][l] = nodeInfo[i][2];
                        this.routingTable[l][k] = nodeInfo[i][2]; 
                    }
                    if( j == 1 ){
                        l = nodeInfo[i][0] - 1;
                        this.routingTable[k][l] = nodeInfo[i][2];
                        this.routingTable[l][k] = nodeInfo[i][2]; 
                    }
                }
            }
        }
        // the DVT starts with the basic links
        this.distanceVectorTable = this.routingTable;
    }
    
    public int getID(){
        return routerID;
    }

    // formatting tricks to make the output look good
    public void printRoutingTable(){
        int i, j;
        System.out.println("Routing Table:");
        System.out.println("    1  2  3  4  5  6");
        System.out.println("  ---------------------");

        // simply loop though the graph array
        for( i = 0; i < this.routingTable.length; i++ ){
            System.out.print( i+1 + "| ");
            for( j = 0; j < this.routingTable[i].length; j++ ){
                // if its two digits, adjust accordingly
                if( this.routingTable[i][j] > 9 ){
                    System.out.print(this.routingTable[i][j] + " ");
                }
                else{
                    System.out.print(" " + this.routingTable[i][j] + " ");
                }
                
            }
            System.out.println(" |");
        }
        System.out.println("  --------------------");
    }
    

    // same as printRoutingTable but for the DVT
    public void printDistanceVectorTable(){
        int i, j;
        System.out.println("Distance Vector Table:");
        System.out.println("    1  2  3  4  5  6");
        System.out.println("  ---------------------");

        for( i = 0; i < this.distanceVectorTable.length; i++ ){
            System.out.print( i+1 + "| ");
            for( j = 0; j < this.distanceVectorTable[i].length; j++ ){
                if( this.distanceVectorTable[i][j] > 9 ){
                    System.out.print(this.distanceVectorTable[i][j] + " ");
                }
                else{
                    System.out.print(" " + this.distanceVectorTable[i][j] + " ");
                }
                
            }
            System.out.println(" |");
        }
        System.out.println("  --------------------");
    }
    
    // just return the private var
    public int[][] getDistanceVectorTable(){
        return this.distanceVectorTable;
    }

    // gets the distance vector table from other node
    public boolean updateDistanceVectorTable(int[][] neighborTable){
        // This function will get 
        int i, j;
        int change = 0;
        
        // loop though the two arrays and update if you find a better connection
        for( i = 0; i < this.distanceVectorTable.length; i++ ){
            for( j = 0; j < this.distanceVectorTable[i].length; j++ ){
                // dont update if you dont have a connection. 
                if( this.distanceVectorTable[i][j] > neighborTable[i][j] && neighborTable[i][j] < 16 ){
                    this.distanceVectorTable[i][j] = neighborTable[i][j];
                    // change will keep track of if the tables were updated
                    change++;
                }
            }
        }
        // if the tables changed, tell the main function so it can detect stablity
        if( change > 0 ){
            return true;
        }
        else{
            return false;
        }
    }
    
    // This will tell the main program what nodes need to share their information with this router
    public int[] getNeighborTable(){
        int i;
        int[] tableNeeded;
        tableNeeded = new int[MAX_NODES];
        
        // Init the needed tables with zeros
        for( i = 0; i < tableNeeded.length; i++ ){
            tableNeeded[i] = 0;
        }
        
        // If a router is connected, then it will have a cost that is not 16 or 0
        // this will return a list of what routers we can get the tables from
        for( i = 0; i < this.distanceVectorTable[0].length; i++ ){
            if( this.distanceVectorTable[this.routerID-1][i] < 16 ){
                tableNeeded[i] = this.distanceVectorTable[this.routerID-1][i];
            }
        }
        return tableNeeded;
    }
    
    
}
