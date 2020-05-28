package webtest;

import java.io.*;  
import java.net.*; 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.StringTokenizer;

public class webtest {

 public static void main (String[] args) throws IOException {
     
        ServerSocket server = new ServerSocket(6789);
        System.out.println("Listening to connection on port 6789 . . .");
        while(true)
        {
            try
            {
                Socket socket = server.accept();
                new httphandler(socket);
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

class httphandler extends Thread 
{
  private final Socket client;  // The accepted socket from the Webserver

  // Start the thread in the constructor
  public httphandler(Socket client) {
    this.client = client;
    Thread t = new Thread(this);
    t.start();
  }

  // Read the HTTP request, respond, and close the connection
  @Override
  public void run() 
  {
        String fileRequested = null;
        try 
        {
            // Open connections to the socket
            BufferedReader in=new BufferedReader(new InputStreamReader(
            client.getInputStream()));
            PrintStream out=new PrintStream(new BufferedOutputStream(
            client.getOutputStream()));
   
            String input = in.readLine();
            // we parse the request with a string tokenizer
            StringTokenizer parse = new StringTokenizer(input);
            String method = parse.nextToken().toUpperCase(); // we get the HTTP method of the client
            // we get file requested
            fileRequested = parse.nextToken().toLowerCase();

            File file = new File(fileRequested);
            int fileLength = (int) file.length();
            //String content = getContentType(fileRequested);
				
            if (method.equals("GET")) 
            { // GET method so we return content
                //byte[] fileData = readFileData(file, fileLength);
                // send HTTP Headers
                out.println("HTTP/1.1 200 OK");
                out.println("Server: Java HTTP Server from SSaurel : 1.0");
                out.println("Date: " + new Date());
                //out.println("Content-type: " + content);
                out.println("Content-length: " + fileLength);
                out.println(); // blank line between headers and content, very important !
                out.flush(); // flush character output stream buffer
            }		
	}
	catch (IOException x) 
        {
            System.out.println(x);
        }		
  } 
}