/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rsaproject;

/**
 *
 * @author Emad
 */
public class RSAProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerRSA server = new ServerRSA();
    ClientRSA client = new ClientRSA();
    server.setLocation(750, 110);
            server.setVisible(true);
    client.setLocation(250, 110);
            client.setVisible(true);
    }
    
}
