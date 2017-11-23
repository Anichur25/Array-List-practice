
import java.io.IOException;
import java.net.*;


public class Server {
	
	public static final int Port  = 1400;
	public static void main(String[] args) throws IOException {
		
		new Server().runServer();

	}
	
	public void runServer() throws IOException 
	{
		ServerSocket serversocket = new ServerSocket(Port);
		
		while(true)
		{
			Socket socket = serversocket.accept();
		    new ServerThread(socket).start();
		}
		
	}

}
