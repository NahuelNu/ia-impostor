package impostor;

import java.util.Map;

import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;
import frsf.cidisi.faia.solver.search.NTree;
import impostor.classes.InfoSala;
import impostor.classes.RoomNave;

/**
 * This class allows to define a function to be used by any
 * informed search strategy, like A Star or Greedy.
 */
public class Heuristic implements IEstimatedCostFunction {
	
	/**
     * It returns the estimated cost to reach the goal from a NTree node.
     */
	@Override
	public double getEstimatedCost(NTree node) {
		ImpostorAgentState agentState = ((ImpostorAgentState) node.getAgentState());
		Map<RoomNave, InfoSala> nave = agentState.getNave();
		
		double costo = 0.0;
		for (RoomNave clave : nave.keySet()) {
            InfoSala valor = nave.get(clave);
            
            if(valor.getCantidadTripuntalesEnSala()==-1) costo+=9;
            else if(valor.getCantidadTripuntalesEnSala()>0) costo+=(90*valor.getCantidadTripuntalesEnSala());
            if(valor.getTareaSaboteable()==-1) costo+=10;
            else if(valor.getTareaSaboteable()==1) costo +=100;
        }
		return costo;
	}

}
