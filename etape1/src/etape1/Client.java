package etape1;
import java.io.IOException;
	import java.io.InputStream;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.io.OutputStream;
	import java.net.Socket;

public class Client {
 static String serverhost = "localhost";
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
		
			 s.close();
			} catch (IOException e) {System.err.println(e);}


		}

		}
