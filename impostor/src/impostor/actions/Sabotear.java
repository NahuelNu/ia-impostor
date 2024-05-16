package impostor.actions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import impostor.ImpostorAgentState;
import impostor.ImpostorEnvironmentState;
import impostor.classes.RoomNave;

public class Sabotear extends SearchAction{

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		ImpostorAgentState impostorState = (ImpostorAgentState) s;
		
		 RoomNave posActual = impostorState.getSalaActual();
		 if(impostorState.getNave().get(posActual).getTareaSaboteable()==1) {
			 
			impostorState.getNave().get(posActual).setTareaSaboteable(0);	
			int aux = impostorState.getCantidadTareas();
			impostorState.setCantidadTareas(aux-1);
			
			impostorState.incrementarCostoCamino(this.getCost());
			 return impostorState;
		 }
		 
		return null;
	}
	
	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		
		ImpostorAgentState impostorState = (ImpostorAgentState) ast;
		ImpostorEnvironmentState enviromentState = (ImpostorEnvironmentState) est;

		RoomNave posActual = enviromentState.getSalaActualImpostor();
		
		if(enviromentState.getNave().get(posActual).getTareaSaboteable()==1) {
			
			enviromentState.getNave().get(posActual).setTareaSaboteable(0);
			impostorState.getNave().get(posActual).setTareaSaboteable(0);

			int aux = enviromentState.getCantidadTareas();
			
			enviromentState.setCantidadTareas(aux-1);
			impostorState.setCantidadTareas(aux-1);
			
			return enviromentState;
		}
		
		return null;
	}
	
	
	@Override
	public Double getCost() {
		return -105.0;
	}

	@Override
	public String toString() {
		return "Sabotea tarea";
	}
	
	
}
