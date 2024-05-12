package impostor.actions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import impostor.ImpostorAgentState;
import impostor.ImpostorEnvironmentState;
import impostor.RoomNave;

public class Sabotear extends SearchAction{

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		ImpostorAgentState impostorState = (ImpostorAgentState) s;
		
		 RoomNave posActual = impostorState.getSalaActual();
		 if(impostorState.getNave().get(posActual).isTareaSaboteable()) {
			 
			impostorState.getNave().get(posActual).setTareaSaboteable(false);	
			int aux = impostorState.getCantidadTareas();
			impostorState.setCantidadTareas(aux-1);
			 return impostorState;
		 }
		 
		return null;
	}
	
	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		
		ImpostorAgentState impostorState = (ImpostorAgentState) ast;
		ImpostorEnvironmentState enviromentState = (ImpostorEnvironmentState) est;

		RoomNave posActual = enviromentState.getSalaActualImpostor();
		
		if(enviromentState.getNave().get(posActual).isTareaSaboteable()) {
			
			enviromentState.getNave().get(posActual).setTareaSaboteable(false);
			impostorState.getNave().get(posActual).setTareaSaboteable(false);

			int aux = enviromentState.getCantidadTareas();
			
			enviromentState.setCantidadTareas(aux-1);
			impostorState.setCantidadTareas(aux-1);
			
			return enviromentState;
		}
		
		return null;
	}
	
	
	@Override
	public Double getCost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "Sabotea tarea";
	}
	
	
}
