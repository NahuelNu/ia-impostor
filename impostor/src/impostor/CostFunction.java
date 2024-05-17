package impostor;

import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

/**
 * This class can be used in any search strategy like
 * Uniform Cost.
 */
public class CostFunction implements IStepCostFunction {
	
	/**
     * This method calculates the cost of the given NTree node.
     */
	@Override
	public double calculateCost(NTree node) {
		double costoAdicional = ((ImpostorAgentState) node.getAgentState()).getCantidadTripulantes()*100;
		return node.getAction().getCost()+costoAdicional;
	}

}
