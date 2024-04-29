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
	
	@Override
	public Perception getPercept() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
