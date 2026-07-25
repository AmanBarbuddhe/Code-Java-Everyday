
import java.io.*;
import java.net.*;

public class Client {
    
    public static void main(String[] arg){
        
        Socket sob = null;

        InputStream is = null;
        OutputStream os = null;

        DataInputStream dis = null;
        DataOutputStream dos = null;

        try{
            sob = new Socket("localhost",25000);
            is = sob.getInputStream();    // as we discussed earlier , socket has 2 parts , this line is requesting for reading part of socket
            os = sob.getOutputStream();   // this line is requesting for writing part of socket

            dis = new DataInputStream(is);  // dis is to read from input stream(is)
            dos = new DataOutputStream(os); // dos is to write in output stream(os)

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.print("Enter the Number : ");
            String num = br.readLine();
            dos.writeUTF(num); // sending this num to server 
            String ans = dis.readUTF();  // to read the ans which came from server

            System.out.println("Factorial : " + ans);

            sob.close();
        }

        catch(Exception e){
            e.printStackTrace();
        }

    }

}
