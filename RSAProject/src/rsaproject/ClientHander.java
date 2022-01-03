/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rsaproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import static rsaproject.ClientRSA.txtAreaClient;
import static rsaproject.ClientRSA.txtMessageClient;

/**
 *
 * @author Emad
 */
public class ClientHander extends Thread{
    public Socket client;
    private Scanner input;
    private PrintWriter output;
    ClientRSA clientrsa ;
    public ClientHander(Socket client)
    {
        this.client =client;
        try {
            input  = new Scanner(client.getInputStream());
            output = new PrintWriter(client.getOutputStream(),true);

        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
    public  void run(){
        String Recive="";
        clientrsa = new ClientRSA();
        do {
            Recive = input.nextLine();
            output.println("ECHO  : "+Recive  );
           //clientrsa.txtAreaClient.append("ECHO  : "+Recive);
          //clientrsa.txtAreaClient.append("\n");
        }
        while (!Recive.equals("close"));
        try {
            if(client!=null)
            {
                System.out.println("Closing Down Connection");
                client.close();
            }

        }
        catch (IOException ex)
        {
            System.out.println("Unable to disconnect!");
        }

    }
    
}