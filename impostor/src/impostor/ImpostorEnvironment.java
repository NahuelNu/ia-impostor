package impostor;

import java.util.List;
import java.util.Map;
import java.util.Random;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;
import impostor.classes.DatosIniciales;
import impostor.classes.InfoSala;
import impostor.classes.RoomNave;

public class ImpostorEnvironment  extends Environment{
	
	
	public ImpostorEnvironment(DatosIniciales datosIniciales) {
        this.environmentState = new ImpostorEnvironmentState(datosIniciales);
    }
	
	@Override
    public ImpostorEnvironmentState getEnvironmentState() {
        return (ImpostorEnvironmentState) super.getEnvironmentState();
    }
	
	/**
     * This method is called by the simulator. Given the Agent, it creates
     * a new perception reading, for example, the agent position.
     * @param agent
     * @return A perception that will be given to the agent by the simulator.
     */
    @Override
    public Perception getPercept() {
    	
    	ImpostorPerception perception = new ImpostorPerception();
    	
    	ImpostorEnvironmentState environmentState = this.getEnvironmentState();
   
    	perception.setNave(this.poderExtraSensorial());
        // Get the actual position of the agent to be able to create the
        // perception
        RoomNave posAgente = environmentState.getSalaActualImpostor();

        List<RoomNave> salasAdy = environmentState.getNave().get(posAgente).getSalasAdyacentes();
		int cantidadTripEnSala = environmentState.getNave().get(posAgente).getCantidadTripuntalesEnSala();
		int tareaSaboteable = environmentState.getNave().get(posAgente).getTareaSaboteable();
		
		InfoSala aux = new InfoSala(salasAdy, cantidadTripEnSala, tareaSaboteable);
        
		// Set the perception sensors
        perception.setInfoSalaActual(aux);
        
        // Return the perception
        return perception;
    }

    private Map<RoomNave, InfoSala> poderExtraSensorial() {
    	ImpostorEnvironmentState environmentState = this.getEnvironmentState();
    	   
    	if(environmentState.getActivarPoderExtraSensorial()<3) 
    		environmentState.setActivarPoderExtraSensorial(environmentState.getActivarPoderExtraSensorial()+1);
    	else if(environmentState.getActivarPoderExtraSensorial()==5) {
    		environmentState.setActivarPoderExtraSensorial(0);
    		System.out.println("Hago superpoder------------");
			return this.getEnvironmentState().getNave();
    	}
    	else {
    		double nroRandom = new Random().nextDouble();
    		if(nroRandom>=0.5) {
    			environmentState.setActivarPoderExtraSensorial(0);
    			System.out.println("Hago superpoder------------");
    			return this.getEnvironmentState().getNave();
    		}
    		else 
    			environmentState.setActivarPoderExtraSensorial(environmentState.getActivarPoderExtraSensorial()+1);
    	}
    	return null;
	}

	@Override
    public String toString() {
        return environmentState.toString();
    }
}
