package ftmk.rmi.sensorManager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

import ftkm.rmi.sensor.TemperatureSensor;

/**
 * This class manage the value of temperature from the sensor.
 * 
 * @author emalianakasmuri
 *
 */
public class TemperatureSensorManager extends UnicastRemoteObject implements TemperatureSensor {

	//EXE 5
	private HashMap<String, Integer> weekTemperature;
	
	public TemperatureSensorManager() throws RemoteException {
		super();
		
		// Load temperatures(EXE 5)
		weekTemperature = new LinkedHashMap<String, Integer>();
		loadWeekTemperature();
	}
	
	private void loadWeekTemperature() {
		
		
		//Data preparation (EXE 5)
		String days[]= {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
		
		int temperature[] = {32,31,34,36,33,34,37};
		
		//Load data into map(EXE 5)
		
		for(int index = 0;index<days.length ; index++)
		{
			weekTemperature.put(days[index],Integer.valueOf(temperature[index]));
		}
		
	}
	
	

	@Override
	public int getTemperature() throws RemoteException {
		
		return 35;
		
	}
	
	//EXE 6
	@Override
	public int getTemperature(String day) throws RemoteException{
		
		return weekTemperature.get(day);
	}
	
	
	@Override
	public int  getAverageTemperature() throws RemoteException{
		
		
		int totalTemperature = 0;
		Set<String>days = weekTemperature.keySet();
		for(String day:days)
		{
			totalTemperature += weekTemperature.get(day);
		}
			int average= totalTemperature / days.size();
			
			return average;
		
	
	}
	

}