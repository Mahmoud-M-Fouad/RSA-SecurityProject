/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rsaproject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Emad
 */
public class ClassClient {
    private  static InetAddress host;
    private static final  int port  = 1234;
    private static String s,resp;
    private static  Socket socket = null;
    private static FileWriter fw;
    private static Scanner networkInput;
    private static PrintWriter networkOutput;
    private static String response;
    private static String username;
    private static int prime1=17,prime2=11;
    private static int phay_n=(prime1-1)*(prime2-1);
    private static String msg="mamdoh\nmahmoud";
    private static int n=(prime1*prime2);
    private static int i=0,j=0,d=0;
    private static double c;
    private static String encryptedmsg="",msgback="",plain_text="";
   
    
    public String getRespDecrp()
    {
      return  resp;
    }
    public void setMessage(String s)
    {
        this.s=encrypt_msg(s,publickey(phay_n),n);
      
    }
     public String getMessage_plain()
    {
        
        this.msgback=decreptmsg(n,msg(getRespDecrp()),privatekey(phay_n));
        return  msgback;
      
    }
      public String getRespMes()
    {
      return  s;
    }
     public Socket getsocket()
    {
      return  socket;
    }
      public void closesocket() throws IOException
    {
      socket.close();
    }
   // Server_client_Muilt2 s = new  Server_client_Muilt2();
     public static void SendMessages()
     {
       
         
        try {
            socket = new Socket(InetAddress.getLocalHost(),1234);
            Scanner networkInput = new Scanner(socket.getInputStream());
            PrintWriter networkOutput = new PrintWriter(socket.getOutputStream(),true);
            networkOutput.println(s);
            
            ClassClient.resp = networkInput.nextLine();
           // Clientrsa.txtAreaClient.append(resp+"\n");
            System.out.println(resp);
        }
        catch (IOException ec)
        {
            ec.printStackTrace();
        }
       
}
     public static int publickey(int phay_n)
   {
       for(i=2;i<phay_n;i++)
            {
                if(find_e(i,phay_n)==1)
                    break;
                
            }       System.out.println("the value of e is : "+i);
            return i;
   }
    
   public static int find_e(int i,int z)
    {
        if(i==0)
            return z;
        else 
            return find_e(z%i,i);
    }
    
   public static int privatekey(int phay_n)
   {
       int x;
            for(j=0;j<=9;j++)
            {
                x=1+(j*phay_n);
                System.out.println("x : "+x);
                if(x%i==0)
                {
                    d=x/i;
                    break;
                }
            }       
            System.out.println("the of d is : "+d);
   return d;
   }
   
   public static String encrypt_msg(String msg,int publickey,int n)
   {
       encryptedmsg="";
       for (int o=0;o<msg.length();o++)
            {
                int u=(int)msg.charAt(o);
                c=(int)(Math.pow(u,publickey)%n);
                encryptedmsg+=(char)c;
                
            }
       return encryptedmsg;
   }
   
   public static String decreptmsg(int n,String encryptedmsg,int privatekey)
   {
       BigInteger N=BigInteger.valueOf(n);
            BigInteger C;
            //BigInteger msgback=
            String msgback="";
            String h="";
         //   h=msg(encryptedmsg);
            for (int o=0;o<encryptedmsg.length();o++)
            {
                int u=(int)encryptedmsg.charAt(o);
                C=BigInteger.valueOf(u);
                //int p=(int)(u.pow(d)).mod(n);
                BigInteger p=(C.pow(privatekey)).mod(N);
                //int y=Integer.parseInt(p);
                msgback+=new String(p.toByteArray());
            }
            System.out.println("decrepted msg is : "+msgback);
            return msgback;
   }
   public static String msg(String decreptedmsg)
   {
       String s="";
       for(int z=8;z<decreptedmsg.length();z++)
       {
           s+=decreptedmsg.charAt(z);
       }
       return s;
   }
}
