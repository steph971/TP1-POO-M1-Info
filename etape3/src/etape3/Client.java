package etape3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays;

public class Client {
	static boolean n = true;
	private static String serverhost = "localhost";
	private static int PORT = 51919;
	public static int i ;
	//Ports disponibles 49152 jusqu'� 65535
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Socket s=null;
		 try {	
			 System.out.println("Connexion...");
			 s=new Socket(serverhost,PORT); 
			 // Cr�ation du socket
			 System.out.println("Connect�.");
		 // R�cup�ration des flux d�entr�e/sortie
			 
			 ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
		        out.flush();
		        ObjectInputStream in = new ObjectInputStream(s.getInputStream());
		       
		        System.out.println("Client a cree les flux");
		 
		        int[] tableauAEmettre = {1, 2, 3};
		 
		        out.writeObject(tableauAEmettre);
		        out.flush();
		 
		        System.out.println("Client: donnees emises");
		 
		        Object objetRecu = in.readObject();
		        int[] tableauRecu = (int[]) objetRecu;
		 
		       // System.out.println("Client recoit: " + Arrays.toString(tableauRecu));
		       // System.out.println("Paquet envoy� (client"+i+") :"+objetRecu);
		        System.out.println("Paquet re�u ("+ Arrays.toString(tableauRecu));
		        in.close();
		        out.close();
		        i++;
		        s.close();
		    }
		    		 catch (IOException e) {System.err.println(e);} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	}
	}


