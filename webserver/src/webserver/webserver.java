// Danny Vu
// 1001045960
// 10-4-2019

package webserver;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class webserver {
    
public static void main (String[] args) throws IOException 
{
        //Opens up server socket and starts listening to port 6789
        ServerSocket server = new ServerSocket(6789);
        System.out.println("Listening to connection on port 6789 . . .");
        
        while(true)
        {
            try
            {
                //Accepted connection from client and reads in the http contents
                Socket socket = server.accept();
                
                //Uses socket connection to take http contents and parse them through the handler
                httphandler httphandler = new httphandler(socket);
                
                //Prints out the http contents of the file trying to open from web server
                InputStreamReader isr =  new InputStreamReader(socket.getInputStream());
                BufferedReader br = new BufferedReader(isr);
                String line = br.readLine();
                while(!line.isEmpty())
                {
                    System.out.println(line);
                    line = br.readLine();
                }
            }
            catch(IOException e)
            {
                System.out.println(e);
            }
        }
    }
} 

//A httphandler class that parses the http contents and prints out all the attributes
class httphandler extends Thread 
{
    
  private final Socket client; 

  //A constructor that creates a web server with multi threading
  public httphandler(Socket client) 
  {
    this.client = client;
    Thread t = new Thread(this);
    t.start();
  }

  //Method to run multi-thread server and process the http
  @Override
  public void run() 
  {
        String inFile = null;
        try 
        {
            //Reads in file requested from server, takes and parses the strings to get the methods and file to display contents
            BufferedReader in = new BufferedReader(new InputStreamReader(
            client.getInputStream()));
            PrintStream out = new PrintStream(new BufferedOutputStream(
            client.getOutputStream()));
   
            String input = in.readLine();
            
            StringTokenizer parse = new StringTokenizer(input);
            String method = parse.nextToken(); 
            
            inFile = parse.nextToken();

            File file = new File(inFile);
            int fileLength = (int)file.length();
				
            if (method.equals("GET")) 
            { 
                out.println("HTTP/1.1 200 OK");
                out.println("Content-length: " + fileLength);
                out.println(); 
                out.flush(); 
            }		
	}
	catch (IOException e) 
        {
            System.out.println(e);
        }		
  } 
}