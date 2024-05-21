package impostor;

import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;
import impostor.classes.DatosIniciales;

public class ImpostorSearchMain {

	public static void main(String[] args) {
		
		DatosIniciales datosIniciales = new DatosIniciales();
		
		ImpostorAgent impostorAgent = new ImpostorAgent(datosIniciales);
        ImpostorEnvironment impostorEnvironment = new ImpostorEnvironment(datosIniciales);
        
        // Prueba de percibir
        // impostorEnvironment.getPercept();
        
        // Para solo imprimir el mapa prueba
        // ImpostorEnvironmentState impostorEnvironmentPrueba= new ImpostorEnvironmentState();
        
        SearchBasedAgentSimulator simulator =
                new SearchBasedAgentSimulator(impostorEnvironment, impostorAgent);
        
        simulator.start();

	}

}
