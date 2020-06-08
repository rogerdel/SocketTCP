import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {

	public static void main(String[] args) throws IOException {
		ServerSocket server = null;
		Socket cliente = null;
		BufferedReader en = null;
		PrintWriter sal = null;
		System.out.println("--------------INICIANDO SERVIDOR---------------------");
		try {
			server = new ServerSocket(4673);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		try {
			while(true) {
				cliente = server.accept();
				en = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
				sal = new PrintWriter(new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream())), true);
				while(true) {
					String cad = en.readLine();
					String res = "Opcion no valida";
					boolean s = false;
					switch(cad) {
					case "opcion 1":
						res = "Paepel";
						break;
					case "opcion 2":
						res = "Piedra";
						break;
					case "opcion 3":
						res = "Tijera";
						break;
					case "salir":
						s = true;
						break;
					}
					if(s)
						break;
					sal.println(res);
				}
			}
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		sal.close();
		en.close();
		server.close();
		cliente.close();
	}

}
