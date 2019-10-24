package yohoho;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	
	private static String serverhost = "localhost";
	private static int PORT = 50000;
	
	//Ports disponibles 49152 jusqu'à 65535

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Socket s=null;
		 try {
			 System.out.println("Connexion...");
			 s=new Socket(serverhost,PORT); 
			 // Création du socket
			 System.out.println("Connecté.");
		 // Récupération des flux d’entrée/sortie
		OutputStream out = s.getOutputStream();
		System.out.println("Test 1");
		InputStream in = s.getInputStream();
		System.out.println("Test 2");
		ObjectOutputStream objOut = new ObjectOutputStream(out);
		System.out.println("Test 3");
		ObjectInputStream objIn = new ObjectInputStream(in);
		System.out.println("Test 4");
		try {
			Integer I= (Integer)objIn.readObject();
			System.out.println("J'ai reçu : "+I);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //UnObjet O= new UnObjet() ;
		 //objOut.writeObject(O);
		 s.close();
		} catch (IOException e) {System.err.println(e);}


	}

}
