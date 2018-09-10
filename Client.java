/** TCP Client class for diffie- hellman**
 * Author: Kargul, Benjamin
 * 9/15/2017
 */

import java.net.Socket;
import java.io.*;

public class Client{
  
  static Socket socket;
  static int DEFAULT_PORT = 90; //default is usually 80
  static String ip = "localhost";
  static PrintWriter out;
  static BufferedReader in;
  static boolean writing = false;
  
  //default constructor
  public static void main(String[] args){
    
    //Diffie-Hellman: Use your EXPO program (or function call) to compute the Diffie Hellman numbers. Let g = 1907, p = 784313, SA = 160011 (Alice’s secret), and SB = 12067 (Bob’s secret).
    int g = 1907, p = 784313, Sa = 160011;
    //compute
    int Ta = EXPO.exponentiate(g,Sa,p);
    System.out.println("g = 1907, p = 784313, Sa = 160011\nCalculated Ta = " + Ta);
    
    try{
      socket = new Socket(ip, DEFAULT_PORT);
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      out = new PrintWriter(socket.getOutputStream(), true);
      write("Connected");
      write(Integer.toString(Ta));
      System.out.println("Bob: " + in.readLine());
      int Tb = Integer.parseInt(in.readLine());
      System.out.println("Bob: Tb = " + Tb);
      
      //compute
      int Ts = EXPO.exponentiate(Tb,Sa,p);
      System.out.println("Calculated Ts = " + Ts);
      
      
    }
    catch(IOException e){
      System.out.println(e);
    }
    
   
    try{
      out.close();
      in.close();
      socket.close();
    }catch(Exception ee){ System.out.println(ee); }
  }


  //Sending messages
  public static void write(String message){
    writing = true;
    out.println(message); 
    writing = false;
  }

}
