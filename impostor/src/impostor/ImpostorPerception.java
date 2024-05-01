package impostor;

import java.util.List;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class ImpostorPerception extends Perception{
	
	public static int UNKNOWN_PERCEPTION = -1;
    public static int EMPTY_PERCEPTION = 0;
    public static int ENEMY_PERCEPTION = 1;
    
    private List<Integer> listPerceptions;
    
	public ImpostorPerception() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public List<Integer> getListPerceptions() {
		return listPerceptions;
	}

	public void setListPerceptions(List<Integer> listPerceptions) {
		this.listPerceptions = listPerceptions;
	}






	// Estos 2 metodos no se usan nunca en el ejemplo de pacman
	public ImpostorPerception(Agent agent, Environment environment) {
		super(agent, environment);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void initPerception(Agent agent, Environment environment) {
		// TODO Auto-generated method stub
	}

}
