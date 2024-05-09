package impostor;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class ImpostorGoal extends GoalTest{

	@Override
    public boolean isGoalState(AgentState agentState) {
		// TODO: Función prueba de meta
		
		/*if (((ImpostorAgentState) agentState).isNoMoreTribulantes() &&
                ((ImpostorAgentState) agentState).isNoMoreTareas()) {
            return true;
        }*/
		
		if (((ImpostorAgentState) agentState).isNoMoreTribulantes()) {
			return true;
        }
        return false;
		
    }
}
