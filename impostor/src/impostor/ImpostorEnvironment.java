package impostor;

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
        
        /*
        // Get the actual position of the agent to be able to create the
        // perception
        int row = this.getEnvironmentState().getAgentPosition()[0];
        int col = this.getEnvironmentState().getAgentPosition()[1];

        // Set the perception sensors
        perception.setTopSensor(this.getTopCell(row, col));
        perception.setLeftSensor(this.getLeftCell(row, col));
        perception.setRightSensor(this.getRightCell(row, col));
        perception.setBottomSensor(this.getBottomCell(row, col));
        */
        
        // Return the perception
        return perception;
    }
	
}
