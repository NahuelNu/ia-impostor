package impostor;

import java.util.List;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

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
        
        RoomNave posAgente = this.getEnvironmentState().getPosicionAgente();

		
        // Set the perception sensors
        perception.setListPerceptions(this.getListPerceptions(posAgente));
        
        // Return the perception
        System.out.println(perception.getListPerceptions());
        return perception;
    }

	private List<Integer> getListPerceptions(RoomNave posAgente) {
		return ( (ImpostorEnvironmentState) this.environmentState).getListPerceptions(posAgente);
	}
	
}
