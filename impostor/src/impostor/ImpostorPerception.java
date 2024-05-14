package impostor;

import java.util.List;
import java.util.Map;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

import impostor.classes.InfoSala;
import impostor.classes.RoomNave;

public class ImpostorPerception extends Perception{
    
    private InfoSala infoSalaActual;
    private Map<RoomNave, InfoSala> nave;
    
    public ImpostorPerception() {
    	
    }

	// Estos 2 metodos no se usan nunca en el ejemplo de pacman
	public ImpostorPerception(Agent agent, Environment environment) {
		super(agent, environment);
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
	     
	     System.out.println("------------INITPERCEPTION ESTO NO SE EJECUTA NUNCA----------");
	}

	public void setInfoSalaActual(InfoSala info) {
		this.infoSalaActual=info;
	}

	public InfoSala getInfoSalaActual() {
		return infoSalaActual;
	}
	
	
    public Map<RoomNave, InfoSala> getNave() {
		return nave;
	}

	public void setNave(Map<RoomNave, InfoSala> nave) {
		this.nave = nave;
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
