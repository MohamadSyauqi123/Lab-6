import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import ftkm.rmi.sensor.TemperatureSensor;
import ftmk.rmi.sensorManager.TemperatureSensorManager;

/**
 * This class represent the server-side application using RMI
 * 
 * @author emalianakasmuri
 *
 */
public class TemperatureServerRMIApp {

	public static void main(String[] args) {
		
		
		try {
			
			// Create interface object
			TemperatureSensor sensorJasin = new TemperatureSensorManager();
			
			//Create interface object-Ayer Keroh 
			TemperatureSensor sensorAyerKeroh = new TemperatureSensorManager();
			
			// Get registry
			Registry rmiRegistry = LocateRegistry.getRegistry();
			
			
			// Register interface object as remote object
			rmiRegistry.rebind("SensorJasin", sensorJasin);
			// REgister interface object- Ayer Keroh
			rmiRegistry.rebind("SensorAyerKeroh",sensorAyerKeroh);
			
			System.out.println("SensorJasin is successfully registered");
			System.out.println("SensorAyerKeroh is succesfully registered");
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
