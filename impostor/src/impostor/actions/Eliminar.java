package impostor.actions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import impostor.ImpostorAgentState;
import impostor.ImpostorEnvironmentState;
import impostor.RoomNave;

public class Eliminar extends SearchAction {

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		ImpostorAgentState impostorState = (ImpostorAgentState) s;
		
		 RoomNave posActual = impostorState.getSalaActual();
		 
		if(impostorState.getNave().get(posActual).getCantidadTripuntalesEnSala()==1) {
			
			impostorState.getNave().get(impostorState.getSalaActual()).setCantidadTripuntalesEnSala(0);
			
			int aux = impostorState.getCantidadTripulantes();
			impostorState.setCantidadTripulantes(aux-1);
			
			//System.out.println("ELIMINA 1 ############################");
			return impostorState;
		}
		
		return null;
	}

	@Override
	public Double getCost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		// TODO Auto-generated method stub
		ImpostorAgentState impostorState = (ImpostorAgentState) ast;
		ImpostorEnvironmentState enviromentState = (ImpostorEnvironmentState) est;

		RoomNave posActual = enviromentState.getSalaActualImpostor();
		
		if(enviromentState.getNave().get(posActual).getCantidadTripuntalesEnSala()==1) {
			
			enviromentState.getNave().get(impostorState.getSalaActual()).setCantidadTripuntalesEnSala(0);
			impostorState.getNave().get(impostorState.getSalaActual()).setCantidadTripuntalesEnSala(0);
			
			int aux = enviromentState.getCantidadTripulantes();
			
			enviromentState.setCantidadTripulantes(aux-1);
			impostorState.setCantidadTripulantes(aux-1);
			//System.out.println("ELIMINA 1 REAL ############################");
			return enviromentState;
		}
		
		return null;
	}

	@Override
	public String toString() {
		return "Elimina";
	}

}
