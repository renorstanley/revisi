/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package UTS;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author baskoro
 */
public class UTS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            byte[] buf = new byte[10];
            BufferedReader in;
            PrintWriter on;
            try (Socket socket = new Socket("10.151.43.147", 6666)) {
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
                in= new BufferedReader (new InputStreamReader(is));
                on = new PrintWriter (new OutputStreamWriter(os), true);
                
                int len;
                 
                while(true) {
                    buf = new byte[100];
                    len = is.read(buf);
                    if(len == -1) {
                        
                        break;
                    }
                 
              
                   String comp= new String(buf);
                   System.out.print(comp);
                if(comp.contains("NRP\\n"))
                  {
                Scanner sc =new Scanner(System.in); 
                String s;
                s = sc.nextLine();
                String valid= "Username:";
                valid = valid.concat(s);
                valid= valid.concat("\n");
                os.write(valid.getBytes());
                 os.flush();
               System.out.print(comp);
               
                  }
             else if(comp.contains("                                                                                  200 State: Logged On"))
                {
                  String operation= new String(buf);
                  System.out.println("masuk coi");
                  String[ ] parts= operation.split(" ");
                  String part1= parts[0];
                  String part2= parts[1];
                  String part3= parts[2];
                  int oper1= Integer.parseInt(part1);
                int oper2= Integer.parseInt(part2);
                int jwb;
                  if(part2.contains("mod"))
                        {
                         jwb= oper1%oper2;  
                          String ans= "Result:";
                ans = ans.concat(String.valueOf(jwb));
                ans= ans.concat("\n");
                os.write(ans.getBytes());
                 os.flush();
                        }
                else if(part2.contains("+"))
                        {
                            jwb = oper1+oper2;
                         String ans= "Result:";
                ans = ans.concat(String.valueOf(jwb));
                ans= ans.concat("\n");
                os.write(ans.getBytes());
                 os.flush();
                        }
                
                 else if(part2.contains("-"))
                        {
                            jwb = oper1-oper2;
                         String ans= "Result:";
                ans = ans.concat(String.valueOf(jwb));
                ans= ans.concat("\n");
                os.write(ans.getBytes());
                 os.flush();
                        }
                
             else if(part2.contains("x"))
                        {
                            jwb = oper1*oper2;
                         String ans= "Result:";
                ans = ans.concat(String.valueOf(jwb));
                ans= ans.concat("\n");
                os.write(ans.getBytes());
                 os.flush();
                        }
             else if(part2.contains("/"))
                        {
                            jwb = oper1/oper2;
                         String ans= "Result:";
                ans = ans.concat(String.valueOf(jwb));
                ans= ans.concat("\n");
                os.write(ans.getBytes());
                 os.flush();
}
                  
                  
                }
                os.close();
                is.close();
            }
                
        } }catch (IOException ex) {
            Logger.getLogger(UTS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}