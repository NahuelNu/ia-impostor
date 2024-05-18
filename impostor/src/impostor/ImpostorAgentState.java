package impostor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import impostor.classes.DatosIniciales;
import impostor.classes.InfoSala;
import impostor.classes.RoomNave;

public class ImpostorAgentState extends SearchBasedAgentState{

	private Map<RoomNave, InfoSala> nave;
	private RoomNave salaActual;
	private int cantidadTripulantes;
	private int energiaImpostor;
	private int cantidadTareas;
	
	// Utilizado en búsqueda para costo
	private double costoCamino;
	
	// Utilizados en búsqueda para que puedan pasar por estas salas solo 2 veces
	private int pasosPorCafeteria;
	private int pasosPorStorage;
	
	// Utilizado en búsqueda para que pueda realizar la acción NoMove solo 1 vez
	private boolean noMove;
	
	public ImpostorAgentState(DatosIniciales datosIniciales) {
		super();
		this.salaActual=datosIniciales.getSalaInicialImpostor();
		if(this.salaActual==RoomNave.STORAGE) this.pasosPorStorage=1;
		else this.pasosPorStorage=0;
		if(this.salaActual==RoomNave.CAFETERIA) this.pasosPorCafeteria=1;
		else this.pasosPorCafeteria=0;
		
		this.energiaImpostor = datosIniciales.getEnergiaInicialImpostor();
		this.cantidadTripulantes = 4;
		this.cantidadTareas = 3;
		
		
		this.noMove=false;
		this.costoCamino=0;
        initState();
    }
	
	@Override
	public void initState() {
		this.nave = new HashMap<RoomNave, InfoSala>();
		
		//iniciar nave, salas y detalles de cada una
		List<RoomNave> adyacentesCafeteria = new ArrayList<RoomNave>();
		adyacentesCafeteria.add(RoomNave.WEAPONS);
		adyacentesCafeteria.add(RoomNave.UPPER_ENGINE);
		adyacentesCafeteria.add(RoomNave.MEDBAY);
		adyacentesCafeteria.add(RoomNave.ADMIN);
		adyacentesCafeteria.add(RoomNave.STORAGE);
		nave.put(RoomNave.CAFETERIA, new InfoSala(adyacentesCafeteria, -1, -1));
		
		List<RoomNave> adyacentesWeapons = new ArrayList<RoomNave>();
		adyacentesWeapons.add(RoomNave.CAFETERIA);
		adyacentesWeapons.add(RoomNave.O2);
		adyacentesWeapons.add(RoomNave.NAVIGATION);
		adyacentesWeapons.add(RoomNave.SHIELDS);
		nave.put(RoomNave.WEAPONS, new InfoSala(adyacentesWeapons, -1, -1));
		
		List<RoomNave> adyacentesO2 = new ArrayList<RoomNave>();
		adyacentesO2.add(RoomNave.WEAPONS);
		adyacentesO2.add(RoomNave.NAVIGATION);
		adyacentesO2.add(RoomNave.SHIELDS);
		nave.put(RoomNave.O2, new InfoSala(adyacentesO2, -1, -1));
		
		List<RoomNave> adyacentesNavigation = new ArrayList<RoomNave>();
		adyacentesNavigation.add(RoomNave.WEAPONS);
		adyacentesNavigation.add(RoomNave.O2);
		adyacentesNavigation.add(RoomNave.SHIELDS);
		nave.put(RoomNave.NAVIGATION, new InfoSala(adyacentesNavigation, -1, -1));
		
		List<RoomNave> adyacentesShields = new ArrayList<RoomNave>();
		adyacentesShields.add(RoomNave.WEAPONS);
		adyacentesShields.add(RoomNave.O2);
		adyacentesShields.add(RoomNave.NAVIGATION);
		adyacentesShields.add(RoomNave.COMMUNICATION);
		adyacentesShields.add(RoomNave.STORAGE);
		nave.put(RoomNave.SHIELDS, new InfoSala(adyacentesShields, -1, -1));
		
		List<RoomNave> adyacentesCommunication = new ArrayList<RoomNave>();
		adyacentesCommunication.add(RoomNave.SHIELDS);
		adyacentesCommunication.add(RoomNave.STORAGE);
		nave.put(RoomNave.COMMUNICATION, new InfoSala(adyacentesCommunication, -1, -1));
		
		List<RoomNave> adyacentesStorage = new ArrayList<RoomNave>();
		adyacentesStorage.add(RoomNave.CAFETERIA);
		adyacentesStorage.add(RoomNave.ADMIN);
		adyacentesStorage.add(RoomNave.ELECTRICAL);
		adyacentesStorage.add(RoomNave.COMMUNICATION);
		adyacentesStorage.add(RoomNave.SHIELDS);
		adyacentesStorage.add(RoomNave.LOWER_ENGINE);
		nave.put(RoomNave.STORAGE, new InfoSala(adyacentesStorage, -1, -1));
		
		List<RoomNave> adyacentesElectrical = new ArrayList<RoomNave>();
		adyacentesElectrical.add(RoomNave.STORAGE);
		adyacentesElectrical.add(RoomNave.LOWER_ENGINE);
		nave.put(RoomNave.ELECTRICAL, new InfoSala(adyacentesElectrical, -1, -1));
		
		List<RoomNave> adyacentesLowerEngine = new ArrayList<RoomNave>();
		adyacentesLowerEngine.add(RoomNave.STORAGE);
		adyacentesLowerEngine.add(RoomNave.ELECTRICAL);
		adyacentesLowerEngine.add(RoomNave.REACTOR);
		adyacentesLowerEngine.add(RoomNave.SECURITY);
		adyacentesLowerEngine.add(RoomNave.UPPER_ENGINE);
		nave.put(RoomNave.LOWER_ENGINE, new InfoSala(adyacentesLowerEngine, -1, -1));
		
		List<RoomNave> adyacentesReactor = new ArrayList<RoomNave>();
		adyacentesReactor.add(RoomNave.LOWER_ENGINE);
		adyacentesReactor.add(RoomNave.SECURITY);
		adyacentesReactor.add(RoomNave.UPPER_ENGINE);
		nave.put(RoomNave.REACTOR, new InfoSala(adyacentesReactor, -1, -1));
		
		List<RoomNave> adyacentesSecurity = new ArrayList<RoomNave>();
		adyacentesSecurity.add(RoomNave.LOWER_ENGINE);
		adyacentesSecurity.add(RoomNave.REACTOR);
		adyacentesSecurity.add(RoomNave.UPPER_ENGINE);
		nave.put(RoomNave.SECURITY, new InfoSala(adyacentesSecurity, -1, -1));
		
		List<RoomNave> adyacentesUpperEngine = new ArrayList<RoomNave>();
		adyacentesUpperEngine.add(RoomNave.LOWER_ENGINE);
		adyacentesUpperEngine.add(RoomNave.REACTOR);
		adyacentesUpperEngine.add(RoomNave.SECURITY);
		adyacentesUpperEngine.add(RoomNave.MEDBAY);
		adyacentesUpperEngine.add(RoomNave.CAFETERIA);
		nave.put(RoomNave.UPPER_ENGINE, new InfoSala(adyacentesUpperEngine, -1, -1));
		
		List<RoomNave> adyacentesMedbay= new ArrayList<RoomNave>();
		adyacentesMedbay.add(RoomNave.UPPER_ENGINE);
		adyacentesMedbay.add(RoomNave.CAFETERIA);
		nave.put(RoomNave.MEDBAY, new InfoSala(adyacentesMedbay, -1, -1));
		
		List<RoomNave> adyacentesAdmin= new ArrayList<RoomNave>();
		adyacentesAdmin.add(RoomNave.CAFETERIA);
		adyacentesAdmin.add(RoomNave.STORAGE);
		nave.put(RoomNave.ADMIN, new InfoSala(adyacentesAdmin, -1, -1));
		
	}
	
	public ImpostorAgentState(Map<RoomNave, InfoSala> nave, RoomNave salaActual, int cantidadTripulantes,
			int energiaImpostor, int pasosPorCaf, int pasosPorSto, boolean noMove, int cantidadTareas, double costoCamino) {
		super();
		this.nave = nave;
		this.salaActual = salaActual;
		this.cantidadTripulantes = cantidadTripulantes;
		this.energiaImpostor = energiaImpostor;
		this.pasosPorCafeteria=pasosPorCaf;
		this.pasosPorStorage=pasosPorSto;
		this.noMove = noMove;
		this.cantidadTareas= cantidadTareas;
		this.costoCamino= costoCamino;
	}

	@Override
	public void updateState(Perception p) {
		ImpostorPerception impostorPerception = (ImpostorPerception) p;
		
		if(impostorPerception.getNave()!=null) {
			for (Map.Entry<RoomNave, InfoSala> entry : impostorPerception.getNave().entrySet()) {
		        RoomNave room = entry.getKey();
		        InfoSala infoSala = entry.getValue();
		        this.nave.put(room, new InfoSala(infoSala.getSalasAdyacentes(), infoSala.getCantidadTripuntalesEnSala(), infoSala.getTareaSaboteable()));
		    }
			
			for (RoomNave clave : this.nave.keySet()) {
	            InfoSala valor = this.nave.get(clave);
	            if(valor.getCantidadTripuntalesEnSala()==0) valor.setCantidadTripuntalesEnSala(-1);
	            if(valor.getTareaSaboteable()==0) valor.setTareaSaboteable(-1);
	        }
		}
		this.nave.put(this.salaActual, impostorPerception.getInfoSalaActual());
		
		this.pasosPorCafeteria=0;
		this.pasosPorStorage=0;
		this.noMove=false;
		this.costoCamino=0;
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
        
        if(this.cantidadTareas != ((ImpostorAgentState) obj).getCantidadTareas()) return false;
        
		if(this.pasosPorCafeteria != ((ImpostorAgentState) obj).getPasosPorCafeteria()) return false;
		if(this.pasosPorStorage != ((ImpostorAgentState) obj).getPasosPorStorage()) return false;
		if(this.noMove != ((ImpostorAgentState) obj).isNoMove()) return false;
		if(this.costoCamino != ((ImpostorAgentState) obj).getCostoCamino()) return false;
		
		Map<RoomNave, InfoSala> naveObj = ((ImpostorAgentState) obj).getNave();

		if(naveObj.size() != this.nave.size()) {
			return false;
		}
		
        for (Map.Entry<RoomNave, InfoSala> entry : nave.entrySet()) {
	        RoomNave room = entry.getKey();
	        if(!naveObj.containsKey(room)){
	        	return false;
	        }
	        InfoSala infoSala = entry.getValue();
	        if(!infoSala.equals(naveObj.get(room))){
	        	return false;
	        } 
	    }
        
        return true;
	}

	@Override
	public SearchBasedAgentState clone() {
		Map<RoomNave, InfoSala> newNave = new HashMap<RoomNave, InfoSala>();
		
		for (Map.Entry<RoomNave, InfoSala> entry : nave.entrySet()) {
	        RoomNave room = entry.getKey();
	        InfoSala infoSala = entry.getValue();
	        newNave.put(room, new InfoSala(infoSala.getSalasAdyacentes(), infoSala.getCantidadTripuntalesEnSala(), infoSala.getTareaSaboteable()));
	    }
		
		RoomNave newSalaActual = this.salaActual;
		
		int newCantidadTripulantes = this.cantidadTripulantes;
		int newEnergiaImpostor = this.energiaImpostor;
		int newCantidadTareas = this.cantidadTareas;
		int newPasosPorCaf = this.pasosPorCafeteria;
		int newPasosPorSto = this.pasosPorStorage;
		boolean newNoMove = this.noMove;
		double newCosto = this.costoCamino;
	
		return new ImpostorAgentState(newNave, newSalaActual, newCantidadTripulantes, newEnergiaImpostor,newPasosPorCaf, newPasosPorSto,newNoMove, newCantidadTareas, newCosto);
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		
		str.append("\n");
		str.append("Nave: "+this.nave+"\n");
		str.append("Sala actual: "+this.salaActual+"\n");
		str.append("Cantidad de tripulantes vivos: "+this.cantidadTripulantes+"\n");
		str.append("Cantidad de tareas restantes a sabotear: "+this.cantidadTareas+"\n");
		str.append("Energia: "+this.energiaImpostor+"\n");
		
		return str.toString();
	}


	public boolean isNoMoreTribulantes() {

		if(cantidadTripulantes == 0) {
			return true;
		}
		for (RoomNave clave : this.nave.keySet()) {
            InfoSala valor = this.nave.get(clave);
            if(valor.getCantidadTripuntalesEnSala()!=0) return false;
        }
		
		return true;
	}


	public boolean isNoMoreTareas() {
		
		if(cantidadTareas == 0) {
			return true;
		}
		for (RoomNave clave : this.nave.keySet()) {
            InfoSala valor = this.nave.get(clave);
            if(valor.getTareaSaboteable()!=0) return false;
        }
		
		return true;
	}
	
	public boolean hasEnergy() {
		if(this.getEnergiaImpostor()>0) return true;
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

	public int getPasosPorCafeteria() {
		return pasosPorCafeteria;
	}

	public void setPasosPorCafeteria(int pasosPorCafeteria) {
		this.pasosPorCafeteria = pasosPorCafeteria;
	}

	public int getPasosPorStorage() {
		return pasosPorStorage;
	}

	public void setPasosPorStorage(int pasosPorStorage) {
		this.pasosPorStorage = pasosPorStorage;
	}

	public boolean isNoMove() {
		return noMove;
	}

	public void setNoMove(boolean noMove) {
		this.noMove = noMove;
	}

	public int getCantidadTareas() {
		return cantidadTareas;
	}

	public void setCantidadTareas(int cantidadTareas) {
		this.cantidadTareas = cantidadTareas;
	}

	public double getCostoCamino() {
		return this.costoCamino;
	}

	public void incrementarCostoCamino(double cost) {
		this.costoCamino +=cost;
	}

	

	

}
