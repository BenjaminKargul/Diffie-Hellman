/** TCP Server class  for diffie-hellman **
 * Author: Kargul, Benjamin
 * 9/15/2017
 */

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class Server{
  
  static ServerSocket ss; //TCP socket for server
  static int DEFAULT_PORT = 90; //default is usually 80
  static PrintWriter out;
  static BufferedReader in;
  static boolean writing = false;
  
  public static void main(String[] args){
    
    //Diffie-Hellman: Use your EXPO program (or function call) to compute the Diffie Hellman numbers. Let g = 1907, p = 784313, SA = 160011 (Alice’s secret), and SB = 12067 (Bob’s secret).
    int g = 1907, p = 784313, Sb = 12067;
    
    //compute
    int Tb = EXPO.exponentiate(g,Sb,p);
    System.out.println("g = 1907, p = 784313, Sb = 12067\nCalculated Tb = " + Tb);
    
    //Create server     
    try{
      ss = new ServerSocket(DEFAULT_PORT);
      Socket socket = ss.accept();
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      out = new PrintWriter(socket.getOutputStream(), true);
      write("Connected");
      write(Integer.toString(Tb));
      System.out.println("Alice: " + in.readLine());
      int Ta = Integer.parseInt(in.readLine());
      System.out.println("Alice: Ta = " + Ta);
      
      //compute
      int Ts = EXPO.exponentiate(Ta,Sb,p);
      System.out.println("Calculated Ts = " + Ts);
                                   
    }
    catch(IOException e){
      System.out.println(e);
    }

  }
  //Sending messages
  public static void write(String message){
    writing = true;
    out.println(message); 
    writing = false;
  }
  //Recieving messages
  public static void close(){
    if(!writing){
      try{
        out.close();
        in.close();
        ss.close();
      }catch(Exception e){ System.out.println(e); }
      
    }else{ System.out.println("Cannot close while writing"); }
  }
  
}
