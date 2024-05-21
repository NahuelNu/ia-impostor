package impostor.actions;

import java.util.List;
import java.util.Optional;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import impostor.ImpostorAgentState;
import impostor.ImpostorEnvironmentState;
import impostor.classes.RoomNave;
import impostor.classes.Tripulante;

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
		ImpostorEnvironmentState environmentState = (ImpostorEnvironmentState) est;

		RoomNave posActual = environmentState.getSalaActualImpostor();
		int cantTripulantesEnSala=environmentState.getNave().get(posActual).getCantidadTripuntalesEnSala();
		if(cantTripulantesEnSala>0) {
			
			environmentState.getNave().get(posActual).setCantidadTripuntalesEnSala(cantTripulantesEnSala-1);
			impostorState.getNave().get(posActual).setCantidadTripuntalesEnSala(cantTripulantesEnSala-1);
			
			int aux = environmentState.getCantidadTripulantes();
			
			environmentState.setCantidadTripulantes(aux-1);
			impostorState.setCantidadTripulantes(aux-1);
			
			//Eliminar tripulante de la lista
			
			List<Tripulante> tripulantes = environmentState.getTripulantes();
			Optional<Tripulante> tripulanteAEliminar=tripulantes.stream().filter(t->t.getPosicion()==environmentState.getSalaActualImpostor()).findFirst();
			
			if(tripulanteAEliminar.isPresent()) tripulantes.remove(tripulanteAEliminar.get());
			
			//System.out.println("ELIMINA 1 REAL ############################");
			return environmentState;
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
