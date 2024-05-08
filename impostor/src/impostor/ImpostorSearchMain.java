package impostor;

import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class ImpostorSearchMain {

	public static void main(String[] args) {
		ImpostorAgent impostorAgent = new ImpostorAgent();
        
        ImpostorEnvironment impostorEnvironment = new ImpostorEnvironment();
        
        // Prueba de percibir
        // impostorEnvironment.getPercept();
        
        // Para solo imprimir el mapa prueba
        // ImpostorEnvironmentState impostorEnvironmentPrueba= new ImpostorEnvironmentState();
        
        SearchBasedAgentSimulator simulator =
                new SearchBasedAgentSimulator(impostorEnvironment, impostorAgent);
        
        simulator.start();

	}

}
