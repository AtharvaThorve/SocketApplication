import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) {
		System.out.println("Waiting for clients");

//		This is a server socket which receives a port number
//		Client side socket first connects to this socket then a new socket is created through which 
//		connection is established with server
		try (ServerSocket ss = new ServerSocket(8000)) {

//			accept methods acts like a blocking call so it'll wait for client connection and as soon
//			as it gets it it'll return a socket object
			Socket soc = ss.accept();
			System.out.println("Connection established");

//			Read the incoming input
			BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			String str = in.readLine();

//			Write the input received
			PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
			out.println("Server says: " + str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
