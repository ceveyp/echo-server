package ceveyp.syst44288.a2;
/*
This program is a client that makes echo requests of the server.
It is exactly the same as in assignment 2 question 1.
*/

//THIS IS A TEST
import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args){
        byte[] echoString = "this is another test".getBytes(); //a string which is converted to binary data for testing
        byte[] echoReply = new byte[echoString.length]; //an array to store the server's response
        try{
            Socket sock = new Socket("127.0.0.1", 43522); //open a TCP connection with the server
            OutputStream os = sock.getOutputStream(); //get output stream
            InputStream is = sock.getInputStream(); //get input stream
            DataOutputStream out = new DataOutputStream(os);
            DataInputStream in = new DataInputStream(is);
            out.write(echoString); //send server the data to echo
            in.read(echoReply); //read server's response into array of bytes
            for(int i = 0; i < echoReply.length; ++i) //for testing purposes, print the server's response
                System.out.printf("%c", echoReply[i]);
            System.out.println();
            sock.close(); //close the connection
        }
        catch(IOException e){
            System.err.println("IO exception");
        }
    }
}
