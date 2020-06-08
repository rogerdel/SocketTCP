import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
public class ClienteTCP {

	public static void main(String[] args) throws IOException {
		Socket cliente = null;
		BufferedReader en = null;
		PrintWriter sal = null;
		try {
			cliente = new Socket("localhost",4673);
			en = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			sal = new PrintWriter(new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream())), true);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		try {
			while(true) {
				System.out.println("Selecione un opcion: ");
				for (int i = 1; i <= 3; i++)
					System.out.println("  opcion "+i);
				System.out.println("  salir");
			String c = sc.readLine();
			sal.println(c);
			if(c.equals("salir"))
				break;
			c = en.readLine();
			System.out.println(c);
			}
		}
		
		catch(Exception e){
			System.out.println(e);
		}
		sal.close();
		en.close();
		cliente.close();
	}
}
