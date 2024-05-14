package impostor.actions;

import java.util.ArrayList;
import java.util.List;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import impostor.ImpostorAgentState;
import impostor.ImpostorEnvironmentState;
import impostor.classes.InfoSala;
import impostor.classes.RoomNave;

public class NoMove extends SearchAction{
	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		
		ImpostorAgentState impostorState = (ImpostorAgentState) s;
		RoomNave posAgente = impostorState.getSalaActual();
		
		if(impostorState.isNoMove()) return null;
		impostorState.setNoMove(true);
		
		List <RoomNave> ambientesAdyacentes= 
				(ArrayList <RoomNave>) (impostorState.getNave().get(posAgente).getSalasAdyacentes());
		
		if(impostorState.getNave().get(posAgente).getCantidadTripuntalesEnSala()==-1) {
			InfoSala infoSalaNew = new InfoSala(ambientesAdyacentes,0,false);
			impostorState.getNave().put(posAgente, infoSalaNew);
		}
		impostorState.incrementarCostoCamino(this.getCost());
		//System.out.println("NO SE MUEVEA SADASDF############################");
		return impostorState;
	}

	@Override
	public Double getCost() {
		return 200.0;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {

		ImpostorAgentState impostorState = (ImpostorAgentState) ast;
		ImpostorEnvironmentState enviromentState = (ImpostorEnvironmentState) est;
		
		System.out.println("-------------ESTO NO SE EJECUTA NUNCA----------");
		return enviromentState;
	}

	@Override
	public String toString() {
		return "NoSeMueve";
	}
}
