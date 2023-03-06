import java.io.DataOutputStream;
import java.io.IOException;

public class Cliente extends Conexion {
	public Cliente() throws IOException {
		// Se usa el constructor para cliente de Conexion
		super("cliente");
	} 

	// Metodo para iniciar el cliente
	public void startClient(String mensaje) {
		try {
			// Flujo de datos hacia el servidor
			salidaServidor = new DataOutputStream(cs.getOutputStream());
			
			// Se escribe en el servidor usando su flujo de datos
			System.out.println("Enviando mensaje...");
			salidaServidor.writeUTF(mensaje);
			
			// Fin de la conexion
			cs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
