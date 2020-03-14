import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {

	public static void main(String[] args) {
		System.out.println("Client started");

		try {
//			It takes in arguments one is ip address of our device and second is port number
			Socket soc = new Socket("localhost", 8000);
			BufferedReader clientInput = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter a string");
			String str = clientInput.readLine();

//			The soc.getOutputStream will return output stream of socket and the boolean value 
//			determines whether the printwriter object will autoflush or not
			PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
			out.println(str);
			
//			Read what is returned by the server
			BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			System.out.println(in.readLine());
			
			soc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
