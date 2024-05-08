package impostor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.state.EnvironmentState;
import impostor.classes.InfoSala;

public class ImpostorEnvironmentState extends EnvironmentState {
	
	// HashMap1: key: AmbienteActual, value:
	//										HashMap2: key: AmbientesAdyacentes, value: Percepciones 
	private Map<RoomNave, InfoSala> nave; // 
	private int cantidadTripulantes;
	private int enegiaImpostor;
	private RoomNave salaActualImpostor;
	
	// TODO
	public ImpostorEnvironmentState() {
		super();
		initState();
	}

	@Override
	public void initState() {
		//cantidad de tripulantes al inicio:
		cantidadTripulantes = 1;

		nave =  new HashMap<RoomNave, InfoSala>();
		
		//iniciar nave, salas y detalles de cada una
		List<RoomNave> adyacentesCafeteria = new ArrayList<RoomNave>();
		adyacentesCafeteria.add(RoomNave.WEAPONS);
		//adyacentesCafeteria.add(RoomNave.UPPER_ENGINE);
		//adyacentesCafeteria.add(RoomNave.MEDBAY);
		//adyacentesCafeteria.add(RoomNave.ADMIN);
		adyacentesCafeteria.add(RoomNave.STORAGE);
		nave.put(RoomNave.CAFETERIA, new InfoSala(adyacentesCafeteria, 0, false));
		
		List<RoomNave> adyacentesWeapons = new ArrayList<RoomNave>();
		adyacentesWeapons.add(RoomNave.CAFETERIA);
		//adyacentesWeapons.add(RoomNave.O2);
		//adyacentesWeapons.add(RoomNave.NAVIGATION);
		adyacentesWeapons.add(RoomNave.SHIELDS);
		nave.put(RoomNave.WEAPONS, new InfoSala(adyacentesWeapons, 0, false));
		
		/*List<RoomNave> adyacentesO2 = new ArrayList<RoomNave>();
		adyacentesO2.add(RoomNave.WEAPONS);
		adyacentesO2.add(RoomNave.NAVIGATION);
		adyacentesO2.add(RoomNave.SHIELDS);
		nave.put(RoomNave.O2, new InfoSala(adyacentesO2, 1, true));
		
		List<RoomNave> adyacentesNavigation = new ArrayList<RoomNave>();
		adyacentesNavigation.add(RoomNave.WEAPONS);
		adyacentesNavigation.add(RoomNave.O2);
		adyacentesNavigation.add(RoomNave.SHIELDS);
		nave.put(RoomNave.NAVIGATION, new InfoSala(adyacentesNavigation, 1, false));
		*/
		List<RoomNave> adyacentesShields = new ArrayList<RoomNave>();
		adyacentesShields.add(RoomNave.WEAPONS);
		//adyacentesShields.add(RoomNave.O2);
		//adyacentesShields.add(RoomNave.NAVIGATION);
		//adyacentesShields.add(RoomNave.COMMUNICATION);
		adyacentesShields.add(RoomNave.STORAGE);
		nave.put(RoomNave.SHIELDS, new InfoSala(adyacentesShields, 0, false));
		
		/*List<RoomNave> adyacentesCommunication = new ArrayList<RoomNave>();
		adyacentesCommunication.add(RoomNave.SHIELDS);
		adyacentesCommunication.add(RoomNave.STORAGE);
		nave.put(RoomNave.COMMUNICATION, new InfoSala(adyacentesCommunication, 1, false));
		*/
		List<RoomNave> adyacentesStorage = new ArrayList<RoomNave>();
		adyacentesStorage.add(RoomNave.CAFETERIA);
		//adyacentesStorage.add(RoomNave.ADMIN);
		//adyacentesStorage.add(RoomNave.ELECTRICAL);
		//adyacentesStorage.add(RoomNave.COMMUNICATION);
		adyacentesStorage.add(RoomNave.SHIELDS);
		//adyacentesStorage.add(RoomNave.LOWER_ENGINE);
		nave.put(RoomNave.STORAGE, new InfoSala(adyacentesStorage, 1, true));
		
		
		// seguir resto de salas
		
		//posicion inicial y energia inicial del impostor:
		this.setSalaActualImpostor(RoomNave.CAFETERIA);
		this.setEnegiaImpostor(1000);
        
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Map<RoomNave, InfoSala> getNave() {
		return nave;
	}

	public void setNave(Map<RoomNave, InfoSala> nave) {
		this.nave = nave;
	}

	public int getCantidadTripulantes() {
		return cantidadTripulantes;
	}

	public void setCantidadTripulantes(int cantidadTripulantes) {
		this.cantidadTripulantes = cantidadTripulantes;
	}

	public int getEnegiaImpostor() {
		return enegiaImpostor;
	}

	public void setEnegiaImpostor(int enegiaImpostor) {
		this.enegiaImpostor = enegiaImpostor;
	}

	public RoomNave getSalaActualImpostor() {
		return salaActualImpostor;
	}

	public void setSalaActualImpostor(RoomNave salaActualImpostor) {
		this.salaActualImpostor = salaActualImpostor;
	}

}
