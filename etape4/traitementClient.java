package etape4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
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
		 System.out.println("Client connecté ("+this.getName()+"): "+client.getInetAddress().toString());
		
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
	       // System.out.println("Paquet reçu ("+this.getName()+") :"+objetRecu);
	         System.out.println("Paquet reçu ("+this.getName()+") :"+ Arrays.toString(tableauRecu));
	       // System.out.println("s   :paquets ("+ Arrays.toString(tableauRecu));
	 
	        in.close();
	        out.close();
	        client.close();
		}
		    		 catch (IOException e) {System.err.println(e);} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

		
	}
	public static void main( String[] args ) throws Exception {

        
        // Récupération des méta-données à partir de la classe.
        Class<traitementClient> metadata = traitementClient.class;
        
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
        
    }
}


