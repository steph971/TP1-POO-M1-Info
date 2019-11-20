package etape4;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;


public class serveur {

	
	public static  int i = 0 ;
	public static ArrayList<traitementClient> Ps = new ArrayList<traitementClient>() ;
	public LinkedList<Object> L = new LinkedList<Object>();
	private static ServerSocket ecoute;
	private static int PORT = 51919;
	//Ports disponibles 49152 jusqu'à 65535

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	        
	        // Récupération des méta-données à partir de la classe.
	        Class<serveur> metadata = serveur.class;
	        
	        // On récupère les attributs publics disponibles à partir de la classe
	        // (et y compris dans les classes parentes : Base et Object).
	        Field [] attributes = metadata.getFields();
	        
	        // On affiche des informations sur ces attributs publics.
	        for( Field attribute : attributes ) {
	            System.out.printf( 
	                    "%s of type %s (isPrimitive: %b)\n",
	                    attribute.getName(), 
	                    attribute.getType().getName(),
	                    attribute.getType().isPrimitive()
	            );
	        }
	        
	    
		
		try {
			// On écoute sur le port <PORT>
			 ecoute=new ServerSocket(PORT);
			 System.out.println("Serveur initialisé");
			 
			while (true) {
			// On accepte une demande de connexion d'un client
			System.out.println("Serveur en attente de connexion sur le port : "+PORT);
			Socket client=ecoute.accept();
			System.out.println("Client connecté(Serveur) : "+client.getInetAddress().toString());
			
			
			traitementClient P = new traitementClient ("Thread"+i,client) ;
			P.start();
			Ps.add(P);
			i++;
			
		
			
			}
		}
		catch (IOException e) {
		 System.err.println(e.getMessage());
		 System.exit(1);
		 }


	}
	
}
