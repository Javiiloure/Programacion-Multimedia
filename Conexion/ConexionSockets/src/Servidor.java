import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Servidor extends Conexion // Se hereda de conexi�n para hacer uso de los sockets y dem�s
{
	public Servidor() throws IOException {
		super("servidor");
	} // Se usa el constructor para servidor de Conexion

	public String startServer()// M�todo para iniciar el servidor
	{
		try {
			System.out.println("Esperando..."); // Esperando conexi�n
			cs = ss.accept(); // Accept comienza el socket y espera una conexi�n desde un cliente
			System.out.println("Cliente en l�nea");
			// Se obtiene el flujo de salida del cliente para enviarle mensajes
			salidaCliente = new DataOutputStream(cs.getOutputStream());
//            //Se le env�a un mensaje al cliente usando su flujo de salida
//            salidaCliente.writeUTF("Petici�n recibida y aceptada");
			// Se obtiene el flujo entrante desde el cliente
			BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));
			while ((mensajeServidor = entrada.readLine()) != null) // Mientras haya mensajes desde el cliente
			{
				// Se muestra por pantalla el mensaje recibido
				System.out.println(mensajeServidor);
				return mensajeServidor;
			}

			System.out.println("Fin de la conexi�n");
			ss.close();// Se finaliza la conexi�n con el cliente
			return mensajeServidor;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return mensajeServidor;
		}

	}
}
