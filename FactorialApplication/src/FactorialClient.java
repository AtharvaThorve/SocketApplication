import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class FactorialClient {

	public static void main(String[] args) {
		System.out.print("Enter number whose factorial is to be calculated: ");
		try (Socket soc = new Socket("localhost", 8000)) {
			BufferedReader clientInput = new BufferedReader(new InputStreamReader(System.in));
			String s = clientInput.readLine();
			
			PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
			out.println(s);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			System.out.println(in.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
