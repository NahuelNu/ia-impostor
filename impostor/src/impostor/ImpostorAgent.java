package impostor;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.solver.search.DepthFirstSearch;
import frsf.cidisi.faia.solver.search.Search;
import impostor.actions.Eliminar;
import impostor.actions.IrA;
import impostor.actions.NoMove;


public class ImpostorAgent extends SearchBasedAgent{

	public ImpostorAgent() {
        // The Impostor Goal
        ImpostorGoal goal = new ImpostorGoal();

        // The Impostor Agent State
        ImpostorAgentState impostorState = new ImpostorAgentState();
        this.setAgentState(impostorState);

		
		
        Vector<SearchAction> operators = new Vector<SearchAction>();
        operators.addElement(new Eliminar());
        operators.addElement(new IrA(RoomNave.WEAPONS));
        operators.addElement(new IrA(RoomNave.SHIELDS));
        operators.addElement(new IrA(RoomNave.O2));
        operators.addElement(new IrA(RoomNave.NAVIGATION));
        operators.addElement(new IrA(RoomNave.COMMUNICATION));
        operators.addElement(new IrA(RoomNave.ADMIN));
        operators.addElement(new IrA(RoomNave.LOWER_ENGINE));
        operators.addElement(new IrA(RoomNave.REACTOR));
        operators.addElement(new IrA(RoomNave.SECURITY));
        operators.addElement(new IrA(RoomNave.UPPER_ENGINE));
        operators.addElement(new IrA(RoomNave.MEDBAY));
        operators.addElement(new IrA(RoomNave.ELECTRICAL));
        operators.addElement(new IrA(RoomNave.STORAGE));
        operators.addElement(new IrA(RoomNave.CAFETERIA));
        operators.addElement(new NoMove());


        // Create the Problem which the Impostor will resolve
        Problem problem = new Problem(goal, impostorState, operators);
        this.setProblem(problem);
	}

	@Override
	public void see(Perception p) {
		this.getAgentState().updateState(p);
		
	}

	 /**
     * This method is executed by the simulator to ask the agent for an action.
     */
    @Override
    public Action selectAction() {

        // Create the search 
        DepthFirstSearch strategy = new DepthFirstSearch();

        /**
         * Another search strategy examples:
         * 
         * Depth First Search:strategy
         * DepthFirstSearch strategy = new DepthFirstSearch();
         * 
         * Breath First Search:
         * BreathFirstSearch strategy = new BreathFirstSearch();
         * 
         * Uniform Cost:
         * IStepCostFunction costFunction = new CostFunction();
         * UniformCostSearch strategy = new UniformCostSearch(costFunction);
         * 
         * A Star Search:
         * IStepCostFunction cost = new CostFunction();
         * IEstimatedCostFunction heuristic = new Heuristic();
         * AStarSearch strategy = new AStarSearch(cost, heuristic);
         * 
         * Greedy Search:
         * IEstimatedCostFunction heuristic = new Heuristic();
         * GreedySearch strategy = new GreedySearch(heuristic);
         */

        // Create a Search object with the strategy
        Search searchSolver = new Search(strategy);

        /* Generate an XML file with the search tree. It can also be generated
         * in other formats like PDF with PDF_TREE */
        searchSolver.setVisibleTree(Search.XML_TREE);

        // Set the Search searchSolver.
        this.setSolver(searchSolver);

        // Ask the solver for the best action
        Action selectedAction = null;
        try {
            selectedAction =
                    this.getSolver().solve(new Object[]{this.getProblem()});
        } catch (Exception ex) {
            Logger.getLogger(ImpostorAgent.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Return the selected action
        return selectedAction;
    }


}
