package impostor;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class ImpostorGoal extends GoalTest{

	@Override
    public boolean isGoalState(AgentState agentState) {
		// TODO: Función prueba de meta
		return true;
		
		
		/*if (((PacmanAgentState) agentState).isNoMoreFood() &&
                ((PacmanAgentState) agentState).isAllWorldKnown()) {
            return true;
        }
        return false;*/
		
    }
}
