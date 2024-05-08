package impostor;

import java.util.List;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;
import impostor.classes.InfoSala;

public class ImpostorEnvironment  extends Environment{
	
	
	public ImpostorEnvironment() {
        // Create the environment state
        this.environmentState = new ImpostorEnvironmentState();
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
        // Create a new perception to return
        ImpostorPerception perception = new ImpostorPerception();
        
        
        // Get the actual position of the agent to be able to create the
        // perception
        
        RoomNave posAgente = this.getEnvironmentState().getSalaActualImpostor();

        List<RoomNave> salasAdy = this.getEnvironmentState().getNave().get(posAgente).getSalasAdyacentes();
		int cantidadTrip = this.getEnvironmentState().getNave().get(posAgente).getCantidadTripuntalesEnSala();
		boolean tareaSaboteable = this.getEnvironmentState().getNave().get(posAgente).isTareaSaboteable();
		
		InfoSala aux = new InfoSala(salasAdy, cantidadTrip, tareaSaboteable);
        // Set the perception sensors
        perception.setInfoSalaActual(aux);
        
        // Return the perception
        return perception;
    }

	
}
