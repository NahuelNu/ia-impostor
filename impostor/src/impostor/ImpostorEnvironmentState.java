package impostor;

import java.util.List;
import java.util.Map;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.state.EnvironmentState;

public class ImpostorEnvironmentState extends EnvironmentState {
	
	// HashMap1: key: AmbienteActual, value:
	//										HashMap2: key: AmbientesAdyacentes, value: Percepciones 
	private Map<RoomNave,Map<RoomNave,List<Perception>>> world; 
	private Integer cantTripulantesVivos;
	private List<RoomNave> tareasASabotear;
	
	// TODO
	public ImpostorEnvironmentState() {
		super();
	}

	@Override
	public void initState() {
		//Iniciar mapa
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
