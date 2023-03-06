import java.io.IOException;

public class LanzadorServer {

	public static String main() throws IOException {
		
		// Se crea el servidor
		Servidor serv = new Servidor(); 
		System.out.println("Iniciando servidor\n");
		
		// Se inicia el servidor
		String mensaje = serv.startServer(); 
		return mensaje;
	}
}
