package impostor;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;


public class ImpostorAgent extends SearchBasedAgent{

	public ImpostorAgent() {
        // The Impostor Goal
        ImpostorGoal goal = new ImpostorGoal();

        // The Impostor Agent State
        ImpostorAgentState impostorState = new ImpostorAgentState();
        this.setAgentState(impostorState);
		
		/* TODO: todo esto
        // Create the operators
        Vector<SearchAction> operators = new Vector<SearchAction>();
        operators.addElement(new Eat());
        operators.addElement(new Fight());
        operators.addElement(new GoLeft());
        operators.addElement(new GoUp());
        operators.addElement(new GoRight());
        operators.addElement(new GoDown());

        // Create the Problem which the Pacman will resolve
        Problem problem = new Problem(goal, pacmanState, operators);
        this.setProblem(problem);*/
	}

	@Override
	public void see(Perception p) {
		this.getAgentState().updateState(p);
	}

	@Override
	public Action selectAction() {
		// TODO Auto-generated method stub
		return null;
	}


}
