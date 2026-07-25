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

            while(true){
                String msg = dis.readUTF();
                if(msg.equals("STOP")){
                    break;
                }
                System.out.println(msg);
            }

            sob.close();
            ssob.close();
        }

        catch(Exception e){
            e.printStackTrace();
        }

    }

}
