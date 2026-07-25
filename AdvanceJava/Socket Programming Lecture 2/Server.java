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

            int n = Integer.parseInt(dis.readUTF());   // we will get this value from clients and it will be in string , we need to convert it into factorial

            System.out.println(n + " is received for calculation");

            int fact=1;

            for(int i = 1 ; i <=n ; i++){
                fact = fact * i ;
            }

            dos.writeUTF(Integer.toString(fact)); // we got factorial as an integer , and we need to send the answer as a string , therefore converted integer into string

            sob.close();
            ssob.close();
        }

        catch(Exception e){
            e.printStackTrace();
        }

    }

}
