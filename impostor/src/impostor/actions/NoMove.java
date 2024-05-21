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
	
	private double cost;
	
	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		
		ImpostorAgentState impostorState = (ImpostorAgentState) s;
		RoomNave posAgente = impostorState.getSalaActual();
		
		//Si ya hice un NoMove o en la sala actual hay un tripulante o tarea por sabotear retornar null
		if(impostorState.isNoMove() || impostorState.getNave().get(posAgente).getCantidadTripuntalesEnSala()>0 || impostorState.getNave().get(posAgente).getTareaSaboteable()==1) return null;
		impostorState.setNoMove(true);
		
		List <RoomNave> ambientesAdyacentes= 
				(ArrayList <RoomNave>) (impostorState.getNave().get(posAgente).getSalasAdyacentes());
		
		//Recorrer nave para que si todavía puedo moverme a las adyacentes retornar null
		for (RoomNave clave : impostorState.getNave().keySet()) {
			if(ambientesAdyacentes.contains(clave)) { 
				InfoSala valor = impostorState.getNave().get(clave);
				if(valor.getCantidadTripuntalesEnSala()!=0 || valor.getTareaSaboteable()!=0) return null;
			}
        }
		
		if(impostorState.getNave().get(posAgente).getCantidadTripuntalesEnSala()==-1) {
			InfoSala infoSalaNew = new InfoSala(ambientesAdyacentes,0,0);
			impostorState.getNave().put(posAgente, infoSalaNew);
		}
		
		//Necesario?
		this.setCost(2);
		//System.out.println("NO SE MUEVEA SADASDF############################");
		return impostorState;
	}

	@Override
	public Double getCost() {
		return this.cost;
	}
	
	private void setCost(double cost) {
		this.cost=cost;
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
