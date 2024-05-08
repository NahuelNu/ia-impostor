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
            System.out.println("gana %%%%%%");
			return true;
        }
        return false;
		
    }
}
