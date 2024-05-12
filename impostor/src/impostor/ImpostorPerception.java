package impostor;

import java.util.List;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

import impostor.classes.InfoSala;

public class ImpostorPerception extends Perception{
	
//	public static int UNKNOWN_PERCEPTION = -1;
//    public static int EMPTY_PERCEPTION = 0;
//    public static int CREWMATE_PERCEPTION = 1;
//    public static int MULTIPLE_CREWMATES_PERCEPTION = 2;
//    public static int TASK_PERCEPTION = 2;
    
    private InfoSala infoSalaActual;
    //private int energiaImpostor;
    
    public ImpostorPerception() {
    	
    }

	// Estos 2 metodos no se usan nunca en el ejemplo de pacman
	public ImpostorPerception(Agent agent, Environment environment) {
		super(agent, environment);
		// TODO Auto-generated constructor stub
	}
	
    /**
     * This method is used to setup the perception.
     */
	@Override
	public void initPerception(Agent agent, Environment environment) {
		 ImpostorAgent impostorAgent = (ImpostorAgent) agent;
	     ImpostorEnvironment impostorEnvironment = (ImpostorEnvironment) environment;
	     ImpostorEnvironmentState environmentState =
	    		 impostorEnvironment.getEnvironmentState();
	     
	     RoomNave posImpostor = environmentState.getSalaActualImpostor();
	     this.setInfoSalaActual(environmentState.getNave().get(posImpostor));
	     //this.setEnergiaImpostor(environmentState.getEnegiaImpostor());
	}

	public void setInfoSalaActual(InfoSala info) {
		this.infoSalaActual=info;
	}

//	public int getEnergiaImpostor() {
//		return energiaImpostor;
//	}
//
//	public void setEnergiaImpostor(int energiaImpostor) {
//		this.energiaImpostor = energiaImpostor;
//	}

	public InfoSala getInfoSalaActual() {
		return infoSalaActual;
	}
	
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        
        str.append("\n");
        //str.append("Energia impostor: " + this.energiaImpostor +"\n");
        str.append("Info sala actual: " + this.infoSalaActual+"\n");

        return str.toString();
    }
}
