import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost",1400);
		String name = args[0];
		PrintWriter printwriter = new PrintWriter(socket.getOutputStream(),true);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true)
		{
			String input = br.readLine();
			printwriter.println(name + ":" + input);
		}
		
	}

}
