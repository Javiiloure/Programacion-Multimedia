import java.io.IOException;

public class LanzadorCliente {

	public static void main(String mensaje) throws IOException {
		 Cliente cli = new Cliente(); //Se crea el cliente
	        System.out.println("Iniciando cliente\n");
	        cli.startClient(mensaje); //Se inicia el cliente
	}
}
