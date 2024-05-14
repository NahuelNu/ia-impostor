package impostor;

import java.util.Map;

import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.NTree;
import impostor.classes.InfoSala;
import impostor.classes.RoomNave;

public class FuncionCosto implements IStepCostFunction {
	
	/**
     * This method calculates the cost of the given NTree node.
     */
	@Override
	public double calculateCost(NTree node) {
		ImpostorAgentState agentState = ((ImpostorAgentState) node.getAgentState());
		Map<RoomNave, InfoSala> nave = agentState.getNave();
		
		double costo = 0.0;
		for (RoomNave clave : nave.keySet()) {
            InfoSala valor = nave.get(clave);
            if(valor.getCantidadTripuntalesEnSala()==-1) costo+=10;
            if(valor.isTareaSaboteable()) costo+=10;
        }
		
		//costoCamino para mejorar el eliminar y sabotear
		return costo+agentState.getCostoCamino();
		//return costo;//+agentState.getCantidadTripulantes()*10;
	}

}
