package etape3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays;

public class traitementClient extends Thread {
	
	Socket client;	 

	public traitementClient(String name,Socket client){
		super(name) ;
		this.client = client ;
		
	}
	
	public void run(){
		try
		{
		 System.out.println("Client connect� ("+this.getName()+"): "+client.getInetAddress().toString());
		
		 	ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
	        out.flush();
	 
	        ObjectInputStream in = new ObjectInputStream(client.getInputStream());
	 
	        System.out.println("Serveur a cree les flux");
	 
	        int[] tableauAEmettre = {7, 8, 9,9,9};
	 
	        out.writeObject(tableauAEmettre);
	        out.flush();
	 
	        System.out.println("Serveur: donnees emises");
	 
	        Object objetRecu = in.readObject();
	        int[] tableauRecu = (int[]) objetRecu;
	 
	       // System.out.println("Serveur recoit: " + Arrays.toString(tableauRecu));
	       // System.out.println("Paquet re�u ("+this.getName()+") :"+objetRecu);
	        System.out.println("Paquet re�u ("+ Arrays.toString(tableauRecu));
	 
	        in.close();
	        out.close();
	        client.close();
		}
		    		 catch (IOException e) {System.err.println(e);} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
}}
		

