/*

    if we are making a Server the we need ServerSocket class(Required to make connection of socket)
    socket will be made by Client

*/

import java.io.*;
import java.net.*;  // to use networking packages like socket , etc.

class Server {
    
    public static void main(String[] arg){

        ServerSocket ssob = null;
        Socket sob = null;

        InputStream is = null;
        OutputStream os = null;

        DataInputStream dis = null;
        DataOutputStream dos = null;

        try{

            ssob = new ServerSocket(25000);
            System.out.println("Server Started !!!");
            sob = ssob.accept();
            System.out.println("Client is Connected !!!");

            is = sob.getInputStream();
            os = sob.getOutputStream();

            dis = new DataInputStream(is);
            dos = new DataOutputStream(os);

            String fname = dis.readUTF();

            FileInputStream fis = new FileInputStream(fname);
            byte b[] = new byte[1024];

            while(true){
                int nob = fis.read(b);
                if(nob==-1){
                    break;
                }

                dos.write(b,0,nob);
            }

            fis.close();
            sob.close();
            ssob.close();

            System.out.println("File Transfered Successfully");

        }

        catch(Exception e){
            e.printStackTrace();
        }

    }

}
