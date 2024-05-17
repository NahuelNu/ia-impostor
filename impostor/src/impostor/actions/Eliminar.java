package impostor.actions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import impostor.ImpostorAgentState;
import impostor.ImpostorEnvironmentState;
import impostor.classes.RoomNave;

public class Eliminar extends SearchAction {
	
	private double cost;
	
	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		ImpostorAgentState impostorState = (ImpostorAgentState) s;
		
		 RoomNave posActual = impostorState.getSalaActual();
		 int cantTripulantesEnSala=impostorState.getNave().get(posActual).getCantidadTripuntalesEnSala();
		 if(cantTripulantesEnSala>0) {
		
			impostorState.getNave().get(posActual).setCantidadTripuntalesEnSala(cantTripulantesEnSala-1);
			
			int aux = impostorState.getCantidadTripulantes();
			impostorState.setCantidadTripulantes(aux-1);
			
			this.setCost(0);
			//System.out.println("ELIMINA 1 ############################");
			return impostorState;
		}
		
		return null;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {

		ImpostorAgentState impostorState = (ImpostorAgentState) ast;
		ImpostorEnvironmentState enviromentState = (ImpostorEnvironmentState) est;

		RoomNave posActual = enviromentState.getSalaActualImpostor();
		int cantTripulantesEnSala=enviromentState.getNave().get(posActual).getCantidadTripuntalesEnSala();
		if(cantTripulantesEnSala>0) {
			
			enviromentState.getNave().get(posActual).setCantidadTripuntalesEnSala(cantTripulantesEnSala-1);
			impostorState.getNave().get(posActual).setCantidadTripuntalesEnSala(cantTripulantesEnSala-1);
			
			int aux = enviromentState.getCantidadTripulantes();
			
			enviromentState.setCantidadTripulantes(aux-1);
			impostorState.setCantidadTripulantes(aux-1);
			//System.out.println("ELIMINA 1 REAL ############################");
			return enviromentState;
		}
		
		return null;
	}
	
	@Override
	public Double getCost() {
		return this.cost;
	}
	
	private void setCost(double cost) {
		this.cost=cost;
	}
	
	@Override
	public String toString() {
		return "Elimina";
	}

}
