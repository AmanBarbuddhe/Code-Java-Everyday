
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
            is = sob.getInputStream();
            os = sob.getOutputStream();

            dis = new DataInputStream(is);
            dos = new DataOutputStream(os);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while(true){

                System.out.print("Type a Message (STOP): ");
                String s = br.readLine();
                dos.writeUTF(s);
                if(s.equals("STOP")){
                    break;
                }
            }
            
            sob.close();
        }

        catch(Exception e){
            e.printStackTrace();
        }

    }

}
