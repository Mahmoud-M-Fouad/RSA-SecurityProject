/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rsaproject;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Emad
 */
public class classServer {
    private static ServerSocket serverSocket;
    private static final int port =1234;

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(port);
            
            do {
                Socket client =serverSocket.accept();
                System.out.println("New Client Accept");
                ClientHander h = new  ClientHander(client);
                h.start();
            }
            while (true);

        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            System.exit(1);
        }

    }
    
    
}
