import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class FactorialServer {

	private static long factorial(int n) {
		if(n == 1) return 1;
		return n * factorial(n-1);
	}
	
	public static void main(String[] args) {
		System.out.println("Server started");
		try(ServerSocket ss = new ServerSocket(8000)) {
			Socket soc = ss.accept();
			System.out.println("Connection established");
			BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			int n = Integer.parseInt(in.readLine());
			long ans = factorial(n);
			
			PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
			out.printf("Factorial of %d is %d", n, ans);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
