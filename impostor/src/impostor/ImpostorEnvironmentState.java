package impostor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import frsf.cidisi.faia.state.EnvironmentState;
import impostor.classes.DatosIniciales;
import impostor.classes.InfoSala;
import impostor.classes.RoomNave;
import impostor.classes.Tripulante;

public class ImpostorEnvironmentState extends EnvironmentState {
	
	private Map<RoomNave, InfoSala> nave; 
	private int cantidadTripulantes;
	private int energiaImpostor;
	private RoomNave salaActualImpostor;
	private int cantidadTareas;
	private List<Tripulante> tripulantes;
	private int activarPoderExtraSensorial;

	public ImpostorEnvironmentState(DatosIniciales datosIniciales) {
		super();
		//posicion inicial y energia inicial del impostor:
		//this.salaActualImpostor=datosIniciales.getSalaInicialImpostor();
		//this.energiaImpostor=datosIniciales.getEnergiaInicialImpostor();
		//this.cantidadTripulantes=datosIniciales.getCantTripulantes();
		//this.tripulantes=new ArrayList();
		//this.setTripulantes();
	
		
		// Escenario 1
		this.salaActualImpostor=RoomNave.UPPER_ENGINE;
		this.energiaImpostor = 50;
		this.cantidadTripulantes=5;
		this.tripulantes=new ArrayList<>();
		tripulantes.add(new Tripulante(RoomNave.UPPER_ENGINE));
		tripulantes.add(new Tripulante(RoomNave.WEAPONS));
		tripulantes.add(new Tripulante(RoomNave.WEAPONS));
		tripulantes.add(new Tripulante(RoomNave.STORAGE));
		tripulantes.add(new Tripulante(RoomNave.MEDBAY));
		initState();
	}

	@Override
	public void initState() {
		this.activarPoderExtraSensorial=1;
		this.cantidadTareas = 3;
		this.nave =  new HashMap<RoomNave, InfoSala>();
		int[] indiceTripulantes = new int[14];
		HashMap<RoomNave,Integer> posTripulantes = new HashMap<>();
		//Inicializar en 0
		for(RoomNave room : RoomNave.values()) posTripulantes.put(room, 0);
			
		tripulantes.forEach(t->{
								posTripulantes.put(t.getPosicion(), posTripulantes.get(t.getPosicion())+1) ;});
		
		
		// iniciar nave, salas y detalles de cada una
		
		List<RoomNave> adyacentesCafeteria = new ArrayList<RoomNave>();
		adyacentesCafeteria.add(RoomNave.WEAPONS);
		adyacentesCafeteria.add(RoomNave.UPPER_ENGINE);
		adyacentesCafeteria.add(RoomNave.MEDBAY);
		adyacentesCafeteria.add(RoomNave.ADMIN);
		adyacentesCafeteria.add(RoomNave.STORAGE);
		nave.put(RoomNave.CAFETERIA, new InfoSala(adyacentesCafeteria, posTripulantes.get(RoomNave.CAFETERIA), 0));
		
		List<RoomNave> adyacentesWeapons = new ArrayList<RoomNave>();
		adyacentesWeapons.add(RoomNave.CAFETERIA);
		adyacentesWeapons.add(RoomNave.O2);
		adyacentesWeapons.add(RoomNave.NAVIGATION);
		adyacentesWeapons.add(RoomNave.SHIELDS);
		nave.put(RoomNave.WEAPONS, new InfoSala(adyacentesWeapons, posTripulantes.get(RoomNave.WEAPONS), 0));
		
		List<RoomNave> adyacentesO2 = new ArrayList<RoomNave>();
		adyacentesO2.add(RoomNave.WEAPONS);
		adyacentesO2.add(RoomNave.NAVIGATION);
		adyacentesO2.add(RoomNave.SHIELDS);
		nave.put(RoomNave.O2, new InfoSala(adyacentesO2, posTripulantes.get(RoomNave.O2), 1));
		
		List<RoomNave> adyacentesNavigation = new ArrayList<RoomNave>();
		adyacentesNavigation.add(RoomNave.WEAPONS);
		adyacentesNavigation.add(RoomNave.O2);
		adyacentesNavigation.add(RoomNave.SHIELDS);
		nave.put(RoomNave.NAVIGATION, new InfoSala(adyacentesNavigation, posTripulantes.get(RoomNave.NAVIGATION), 0));
		
		List<RoomNave> adyacentesShields = new ArrayList<RoomNave>();
		adyacentesShields.add(RoomNave.WEAPONS);
		adyacentesShields.add(RoomNave.O2);
		adyacentesShields.add(RoomNave.NAVIGATION);
		adyacentesShields.add(RoomNave.COMMUNICATION);
		adyacentesShields.add(RoomNave.STORAGE);
		nave.put(RoomNave.SHIELDS, new InfoSala(adyacentesShields, posTripulantes.get(RoomNave.SHIELDS), 0));
		
		List<RoomNave> adyacentesCommunication = new ArrayList<RoomNave>();
		adyacentesCommunication.add(RoomNave.SHIELDS);
		adyacentesCommunication.add(RoomNave.STORAGE);
		nave.put(RoomNave.COMMUNICATION, new InfoSala(adyacentesCommunication, posTripulantes.get(RoomNave.COMMUNICATION), 0));
		
		List<RoomNave> adyacentesStorage = new ArrayList<RoomNave>();
		adyacentesStorage.add(RoomNave.CAFETERIA);
		adyacentesStorage.add(RoomNave.ADMIN);
		adyacentesStorage.add(RoomNave.ELECTRICAL);
		adyacentesStorage.add(RoomNave.COMMUNICATION);
		adyacentesStorage.add(RoomNave.SHIELDS);
		adyacentesStorage.add(RoomNave.LOWER_ENGINE);
		nave.put(RoomNave.STORAGE, new InfoSala(adyacentesStorage, posTripulantes.get(RoomNave.STORAGE), 0));
		
		List<RoomNave> adyacentesElectrical = new ArrayList<RoomNave>();
		adyacentesElectrical.add(RoomNave.STORAGE);
		adyacentesElectrical.add(RoomNave.LOWER_ENGINE);
		nave.put(RoomNave.ELECTRICAL, new InfoSala(adyacentesElectrical, posTripulantes.get(RoomNave.ELECTRICAL), 1));
		
		List<RoomNave> adyacentesLowerEngine = new ArrayList<RoomNave>();
		adyacentesLowerEngine.add(RoomNave.STORAGE);
		adyacentesLowerEngine.add(RoomNave.ELECTRICAL);
		adyacentesLowerEngine.add(RoomNave.REACTOR);
		adyacentesLowerEngine.add(RoomNave.SECURITY);
		adyacentesLowerEngine.add(RoomNave.UPPER_ENGINE);
		nave.put(RoomNave.LOWER_ENGINE, new InfoSala(adyacentesLowerEngine, posTripulantes.get(RoomNave.LOWER_ENGINE), 0));
		
		List<RoomNave> adyacentesReactor = new ArrayList<RoomNave>();
		adyacentesReactor.add(RoomNave.LOWER_ENGINE);
		adyacentesReactor.add(RoomNave.SECURITY);
		adyacentesReactor.add(RoomNave.UPPER_ENGINE);
		nave.put(RoomNave.REACTOR, new InfoSala(adyacentesReactor, posTripulantes.get(RoomNave.REACTOR), 1));
		
		List<RoomNave> adyacentesSecurity = new ArrayList<RoomNave>();
		adyacentesSecurity.add(RoomNave.LOWER_ENGINE);
		adyacentesSecurity.add(RoomNave.REACTOR);
		adyacentesSecurity.add(RoomNave.UPPER_ENGINE);
		nave.put(RoomNave.SECURITY, new InfoSala(adyacentesSecurity, posTripulantes.get(RoomNave.SECURITY), 0));
		
		List<RoomNave> adyacentesUpperEngine = new ArrayList<RoomNave>();
		adyacentesUpperEngine.add(RoomNave.LOWER_ENGINE);
		adyacentesUpperEngine.add(RoomNave.REACTOR);
		adyacentesUpperEngine.add(RoomNave.SECURITY);
		adyacentesUpperEngine.add(RoomNave.MEDBAY);
		adyacentesUpperEngine.add(RoomNave.CAFETERIA);
		nave.put(RoomNave.UPPER_ENGINE, new InfoSala(adyacentesUpperEngine, posTripulantes.get(RoomNave.UPPER_ENGINE), 0));
		
		List<RoomNave> adyacentesMedbay= new ArrayList<RoomNave>();
		adyacentesMedbay.add(RoomNave.UPPER_ENGINE);
		adyacentesMedbay.add(RoomNave.CAFETERIA);
		nave.put(RoomNave.MEDBAY, new InfoSala(adyacentesMedbay, posTripulantes.get(RoomNave.MEDBAY), 0));
		
		List<RoomNave> adyacentesAdmin= new ArrayList<RoomNave>();
		adyacentesAdmin.add(RoomNave.CAFETERIA);
		adyacentesAdmin.add(RoomNave.STORAGE);
		nave.put(RoomNave.ADMIN, new InfoSala(adyacentesAdmin, posTripulantes.get(RoomNave.ADMIN), 0));
        
	}
	
	private void setTripulantes() {
		for (int i = 0; i < this.cantidadTripulantes; i++) {
			tripulantes.add(new Tripulante()); 
		}
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

	public int getEnergiaImpostor() {
		return energiaImpostor;
	}

	public void setEnergiaImpostor(int enegiaImpostor) {
		this.energiaImpostor = enegiaImpostor;
	}

	public RoomNave getSalaActualImpostor() {
		return salaActualImpostor;
	}

	public void setSalaActualImpostor(RoomNave salaActualImpostor) {
		this.salaActualImpostor = salaActualImpostor;
	}
	
	
	public int getCantidadTareas() {
		return cantidadTareas;
	}

	public void setCantidadTareas(int cantidadTareas) {
		this.cantidadTareas = cantidadTareas;
	}

	public int getActivarPoderExtraSensorial() {
		return activarPoderExtraSensorial;
	}

	public void setActivarPoderExtraSensorial(int activarPoderExtraSensorial) {
		this.activarPoderExtraSensorial = activarPoderExtraSensorial;
	}

	public List<Tripulante> getTripulantes() {
		return tripulantes;
	}

	public void setTripulantes(List<Tripulante> tripulantes) {
		this.tripulantes = tripulantes;
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		
		str.append("\n");
		str.append("Nave: "+this.nave+"\n");
		str.append("Sala actual impostor: "+this.salaActualImpostor+"\n");
		str.append("Cantidad de tripulantes vivos: "+this.cantidadTripulantes+"\n");
		str.append("Cantidad de tareas restantes a sabotear: "+this.cantidadTareas+"\n");
		str.append("Energia impostor: "+this.energiaImpostor+"\n");
		str.append("Posicion tripulantes: "+this.tripulantes+"\n");
		
		return str.toString();
		
	}
}
