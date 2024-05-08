package impostor.actions;

import java.util.List;
import java.util.ArrayList;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import impostor.ImpostorAgentState;
import impostor.ImpostorEnvironmentState;
import impostor.RoomNave;

public class IrA extends SearchAction {
	
	private RoomNave ambiente;
	
	public IrA(RoomNave a){
		super();
		this.ambiente=a;
	}
	
    /**
     * This method updates a tree node state when the search process is running.
     * It does not updates the real world state.
     */
	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		ImpostorAgentState impostorState = (ImpostorAgentState) s;
		
		RoomNave posAgente = impostorState.getSalaActual();
		
		List <RoomNave> ambientesAdyacentes= 
				(ArrayList <RoomNave>) (impostorState.getNave().get(posAgente).getSalasAdyacentes());
		
		  //Si la lista de ambientes adyacentes (a los que puede moverse) no contiene a
		  //este ambiente entonces retornar null
		if(!ambientesAdyacentes.contains(ambiente)) return null;
		//if(!impostorState.getAmbientesAdyacentes().contains(ambiente)) return null;
		  
		impostorState.setSalaActual(ambiente);
		
		System.out.println("Se mueve a "+this.ambiente+" ############################");
		return impostorState;
		 
	}


    /**
     * This method updates the agent state and the real world state.
     */
	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		ImpostorEnvironmentState environmentState = (ImpostorEnvironmentState) est;
        ImpostorAgentState impostorState = ((ImpostorAgentState) ast);
		
        RoomNave posAgente = environmentState.getSalaActualImpostor();
        
		List <RoomNave> ambientesAdyacentes= 
				(ArrayList <RoomNave>) (environmentState.getNave().get(posAgente).getSalasAdyacentes());
		
		if(!ambientesAdyacentes.contains(ambiente)) return null;
		
		environmentState.setSalaActualImpostor(ambiente);
		impostorState.setSalaActual(ambiente);
		 
		System.out.println("Se mueve a "+this.ambiente+" REAL ############################");
		return environmentState;
		
		
	}
	
	@Override
	public Double getCost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "Se mueve a " + this.ambiente;
	}
}
