
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
            
            System.out.println("Enter file name : ");
            String file_name = br.readLine();
            dos.writeUTF(file_name);

            FileOutputStream fos = new FileOutputStream(file_name);

            byte b[] = new byte[1024];

            while(true){
                
                //get Data from Server
                int nob = dis.read(b); // nob means number of bytes

                if(nob==-1){
                    break;        // nob==-1 means data from the file is over
                }

                //write it into file
                fos.write(b,0,nob); 
            }



            fos.close();
            sob.close();

            System.out.println("File Received Successfully");

        }

        catch(Exception e){
            e.printStackTrace();
        }

    }

}
