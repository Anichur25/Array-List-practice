import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread extends Thread {
     
	Socket socket;
	ServerThread(Socket socket)
	{
		this.socket = socket;
		
	}
	
	public void run()
	{
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String message = null;
			
			while((message = br.readLine())!=null)
			{
				System.out.println("incoming Client message " + message);
			}
			socket.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
