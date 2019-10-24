package yohoho;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
	private static ServerSocket ecoute;
	private static int PORT = 50000;
	//Ports disponibles 49152 jusqu'à 65535

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			// On écoute sur le port <PORT>
			 ecoute=new ServerSocket(PORT);
			 System.out.println("Serveur initialisé");
			 
			while (true) {
			// On accepte une demande de connexion d'un client
			System.out.println("En attente de connexion sur le port "+PORT);
			Socket client=ecoute.accept();
			System.out.println("Client connecté : "+client.getInetAddress().toString());

			OutputStream out = client.getOutputStream();
			System.out.println("Test 1");
			ObjectOutputStream objOut = new ObjectOutputStream(out);
			System.out.println("Test 2");
			InputStream in = client.getInputStream();
			System.out.println("Test 3");
			ObjectInputStream objIn = new ObjectInputStream(in);
			System.out.println("Test 4");
			Integer I= new Integer(3);
			System.out.println("Test 5");
			objOut.writeObject(I);
			System.out.println("J'envoie : "+I);
			try {
				ListeObj O= (ListeObj)objIn.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			client.close();
			
			}
		}
		catch (IOException e) {
		 System.err.println(e.getMessage());
		 System.exit(1);
		 }


	}
}
