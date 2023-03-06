import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Se hereda de conexion para hacer uso de los sockets y demas
public class Servidor extends Conexion 
{
	public Servidor() throws IOException {
		// Se usa el constructor para servidor de Conexion
		super("servidor");
	} 

	// Metodo para iniciar el servidor
	public String startServer(){
		try {
			// Esperando conexion
			System.out.println("Esperando..."); 
			
			// Accept comienza el socket y espera una conexion desde un cliente
			cs = ss.accept(); 
			System.out.println("Cliente en linea");
			
			// Se obtiene el flujo entrante desde el cliente
			BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));
			
			// Se muestra por pantalla el mensaje recibido
			mensajeServidor = entrada.readLine();
			System.out.println(mensajeServidor);
			ss.close();
			return mensajeServidor;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return mensajeServidor;
		}
	}
}
