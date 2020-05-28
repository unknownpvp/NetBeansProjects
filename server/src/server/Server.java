/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        boolean flag = false;

        try {
            ServerSocket ss = new ServerSocket(6789);
            if (ss.isBound()) {
                while (flag = true) {
                    final Socket s = ss.accept();



                    Thread t1=new Thread(new Runnable (){String line = null;public void run(){try{ InputStream is = s.getInputStream();
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(is));

                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    }});

                    Thread t2=new Thread(new Runnable (){String line = null;public void run(){try{ OutputStream os = s.getOutputStream();
                    Scanner sc=new Scanner(System.in);
                    String inp=null;
                    String t="HTTP/1.1 200 OK\r\n";
                    byte[]s=t.getBytes("UTF-8");
                    os.write(s);

                    t="Content-Length: 788\r\n";
                    s=t.getBytes("UTF-8");
                    os.write(s);
                    t="Content-Type: text/html\r\n\r\n";
                    s=t.getBytes("UTF-8");
                    os.write(s);


                    t="\r\n\r\n<html><body><h1>this is output</h1><table cellpading=5 border=5><tr><td>name</td><td>age></td><td>height</td></tr></table></body></html>\r\n\r\n";
                    s=t.getBytes("UTF-8");
                    os.write(s);
                    t="Connection: Closed";
                    s=t.getBytes("UTF-8");
                    os.write(s);

                    os.flush();
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    }});
                    t1.start();
                    t2.start();t1.join();
                    t2.join();


                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}