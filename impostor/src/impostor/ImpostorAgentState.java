package impostor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

import impostor.classes.InfoSala;

public class ImpostorAgentState extends SearchBasedAgentState{

	// TODO: estado interno del impostor
	private Map<RoomNave, InfoSala> nave;
	
	private RoomNave salaActual;
	
	//private InfoSala infoSalaActual;
	private int cantidadTripulantes;
	private int energiaImpostor;
	
	
	public ImpostorAgentState() {
		super();
		this.salaActual = RoomNave.CAFETERIA;
		this.energiaImpostor = 1000;
		this.cantidadTripulantes = 1;
        initState();
    }
	
	public ImpostorAgentState(Map<RoomNave, InfoSala> nave, RoomNave salaActual, int cantidadTripulantes,
			int energiaImpostor) {
		super();
		this.nave = nave;
		this.salaActual = salaActual;
		this.cantidadTripulantes = cantidadTripulantes;
		this.energiaImpostor = energiaImpostor;
	}




	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ImpostorAgentState))
            return false;

		if (salaActual != ((ImpostorAgentState) obj).getSalaActual()) {
            return false;
        }
        
        if(energiaImpostor != ((ImpostorAgentState) obj).getEnergiaImpostor()) {
        	return false;
        }
        
        if(cantidadTripulantes != ((ImpostorAgentState) obj).getCantidadTripulantes()) {
        	return false;
        }
		
		Map<RoomNave, InfoSala> naveObj = ((ImpostorAgentState) obj).getNave();

		if(naveObj.size() != this.nave.size()) {
			return false;
		}
		
        for (Map.Entry<RoomNave, InfoSala> entry : nave.entrySet()) {
	        RoomNave room = entry.getKey();
	        //InfoSala infoSala = entry.getValue();
	        if(!naveObj.containsKey(room)){
	        	return false;
	        }
	        InfoSala infoSala = entry.getValue();
	        if(!infoSala.equals(naveObj.get(room))){
	        	return false;
	        } 
	    }

        if (salaActual != ((ImpostorAgentState) obj).getSalaActual()) {
            return false;
        }
        
        if(energiaImpostor != ((ImpostorAgentState) obj).getEnergiaImpostor()) {
        	return false;
        }
        
        if(cantidadTripulantes != ((ImpostorAgentState) obj).getCantidadTripulantes()) {
        	return false;
        }
        
        return true;
	}

	@Override
	public SearchBasedAgentState clone() {
		// TODO Auto-generated method stub
		Map<RoomNave, InfoSala> newNave = new HashMap<RoomNave, InfoSala>();
		
		for (Map.Entry<RoomNave, InfoSala> entry : nave.entrySet()) {
	        RoomNave room = entry.getKey();
	        InfoSala infoSala = entry.getValue();
	        newNave.put(room, new InfoSala(infoSala.getSalasAdyacentes(), infoSala.getCantidadTripuntalesEnSala(), infoSala.isTareaSaboteable()));
	    }
		
		RoomNave newSalaActual = salaActual;
		
		//private InfoSala infoSalaActual;
		int newCantidadTripulantes = cantidadTripulantes;
		int newEnergiaImpostor = energiaImpostor;
	
		return new ImpostorAgentState(newNave, newSalaActual, newCantidadTripulantes, newEnergiaImpostor);
	}

	@Override
	public void updateState(Perception p) {
		// TODO Auto-generated method stub
		ImpostorPerception impostorPerception = (ImpostorPerception) p;
		
		this.nave.put(salaActual, impostorPerception.getInfoSalaActual());
		this.energiaImpostor = impostorPerception.getEnergiaImpostor();
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "hacer";
	}

	@Override
	public void initState() {
		// TODO Auto-generated method stub

		this.nave = new HashMap<RoomNave, InfoSala>();
		
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
		nave.put(RoomNave.STORAGE, new InfoSala(adyacentesStorage, 0, false));
		System.out.println("nave size" + nave.size());
	}

	public boolean isNoMoreTribulantes() {
		
		if(cantidadTripulantes == 0) {
			return true;
		}
		
		return false;
	}


	public boolean isNoMoreTareas() {
		
		return false;
	}

	public Map<RoomNave, InfoSala> getNave() {
		return nave;
	}

	public RoomNave getSalaActual() {
		return salaActual;
	}

	public void setSalaActual(RoomNave salaActual) {
		this.salaActual = salaActual;
	}

	public int getCantidadTripulantes() {
		return cantidadTripulantes;
	}

	public void setCantidadTripulantes(int cantidadTripulantes) {
		this.cantidadTripulantes = cantidadTripulantes;
	}

	public int getEnergiaImpostor() {
		return energiaImpostor;
	}

	public void setEnergiaImpostor(int energiaImpostor) {
		this.energiaImpostor = energiaImpostor;
	}

	public void setNave(Map<RoomNave, InfoSala> nave) {
		this.nave = nave;
	}

	

}
