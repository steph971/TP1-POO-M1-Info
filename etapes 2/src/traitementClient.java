import java.net.Socket;

public class traitementClient extends Thread {

	

	private Socket client;
	
	
	public traitementClient(String name,Socket client){
		super(name) ;
		this.client = client ;
		
	}
	
	public void run(){
		 System.out.println("Client connecté ("+this.getName()+"): "+client.getInetAddress().toString());
}
	
	
	
}
