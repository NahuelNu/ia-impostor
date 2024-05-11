package impostor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import frsf.cidisi.faia.state.EnvironmentState;
import impostor.classes.InfoSala;

public class ImpostorEnvironmentState extends EnvironmentState {
	
	private Map<RoomNave, InfoSala> nave; 
	private int cantidadTripulantes;
	private int enegiaImpostor;
	private RoomNave salaActualImpostor;
	private int cantidadTareas;

	public ImpostorEnvironmentState() {
		super();
		initState();
	}

	@Override
	public void initState() {
		//cantidad de tripulantes al inicio:
		cantidadTripulantes = 2;
		cantidadTareas = 3;
		nave =  new HashMap<RoomNave, InfoSala>();
		
		//iniciar nave, salas y detalles de cada una
		List<RoomNave> adyacentesCafeteria = new ArrayList<RoomNave>();
		adyacentesCafeteria.add(RoomNave.WEAPONS);
		adyacentesCafeteria.add(RoomNave.UPPER_ENGINE);
		adyacentesCafeteria.add(RoomNave.MEDBAY);
		//adyacentesCafeteria.add(RoomNave.ADMIN);
		adyacentesCafeteria.add(RoomNave.STORAGE);
		nave.put(RoomNave.CAFETERIA, new InfoSala(adyacentesCafeteria, 0, false));
		
		List<RoomNave> adyacentesWeapons = new ArrayList<RoomNave>();
		adyacentesWeapons.add(RoomNave.CAFETERIA);
		adyacentesWeapons.add(RoomNave.O2);
		adyacentesWeapons.add(RoomNave.NAVIGATION);
		adyacentesWeapons.add(RoomNave.SHIELDS);
		nave.put(RoomNave.WEAPONS, new InfoSala(adyacentesWeapons, 0, false));
		
		List<RoomNave> adyacentesO2 = new ArrayList<RoomNave>();
		adyacentesO2.add(RoomNave.WEAPONS);
		adyacentesO2.add(RoomNave.NAVIGATION);
		adyacentesO2.add(RoomNave.SHIELDS);
		nave.put(RoomNave.O2, new InfoSala(adyacentesO2, 0, true));
		
		List<RoomNave> adyacentesNavigation = new ArrayList<RoomNave>();
		adyacentesNavigation.add(RoomNave.WEAPONS);
		adyacentesNavigation.add(RoomNave.O2);
		adyacentesNavigation.add(RoomNave.SHIELDS);
		nave.put(RoomNave.NAVIGATION, new InfoSala(adyacentesNavigation, 0, false));
		
		List<RoomNave> adyacentesShields = new ArrayList<RoomNave>();
		adyacentesShields.add(RoomNave.WEAPONS);
		adyacentesShields.add(RoomNave.O2);
		adyacentesShields.add(RoomNave.NAVIGATION);
		adyacentesShields.add(RoomNave.COMMUNICATION);
		adyacentesShields.add(RoomNave.STORAGE);
		nave.put(RoomNave.SHIELDS, new InfoSala(adyacentesShields, 1, false));
		
		List<RoomNave> adyacentesCommunication = new ArrayList<RoomNave>();
		adyacentesCommunication.add(RoomNave.SHIELDS);
		adyacentesCommunication.add(RoomNave.STORAGE);
		nave.put(RoomNave.COMMUNICATION, new InfoSala(adyacentesCommunication, 1, false));
		
		List<RoomNave> adyacentesStorage = new ArrayList<RoomNave>();
		adyacentesStorage.add(RoomNave.CAFETERIA);
		//adyacentesStorage.add(RoomNave.ADMIN);
		adyacentesStorage.add(RoomNave.ELECTRICAL);
		adyacentesStorage.add(RoomNave.COMMUNICATION);
		adyacentesStorage.add(RoomNave.SHIELDS);
		adyacentesStorage.add(RoomNave.LOWER_ENGINE);
		nave.put(RoomNave.STORAGE, new InfoSala(adyacentesStorage, 1, false));
		
		List<RoomNave> adyacentesElectrical = new ArrayList<RoomNave>();
		adyacentesElectrical.add(RoomNave.STORAGE);
		adyacentesElectrical.add(RoomNave.LOWER_ENGINE);
		nave.put(RoomNave.ELECTRICAL, new InfoSala(adyacentesElectrical, 0, true));
		
		List<RoomNave> adyacentesLowerEngine = new ArrayList<RoomNave>();
		adyacentesLowerEngine.add(RoomNave.STORAGE);
		adyacentesLowerEngine.add(RoomNave.ELECTRICAL);
		adyacentesLowerEngine.add(RoomNave.REACTOR);
		adyacentesElectrical.add(RoomNave.SECURITY);
		adyacentesElectrical.add(RoomNave.UPPER_ENGINE);
		nave.put(RoomNave.LOWER_ENGINE, new InfoSala(adyacentesLowerEngine, 0, false));
		
		List<RoomNave> adyacentesReactor = new ArrayList<RoomNave>();
		adyacentesReactor.add(RoomNave.LOWER_ENGINE);
		adyacentesReactor.add(RoomNave.SECURITY);
		adyacentesReactor.add(RoomNave.UPPER_ENGINE);
		nave.put(RoomNave.REACTOR, new InfoSala(adyacentesReactor, 0, true));
		
		List<RoomNave> adyacentesSecurity = new ArrayList<RoomNave>();
		adyacentesSecurity.add(RoomNave.LOWER_ENGINE);
		adyacentesSecurity.add(RoomNave.REACTOR);
		adyacentesSecurity.add(RoomNave.UPPER_ENGINE);
		nave.put(RoomNave.SECURITY, new InfoSala(adyacentesSecurity, 1, false));
		
		List<RoomNave> adyacentesUpperEngine = new ArrayList<RoomNave>();
		adyacentesUpperEngine.add(RoomNave.LOWER_ENGINE);
		adyacentesUpperEngine.add(RoomNave.REACTOR);
		adyacentesUpperEngine.add(RoomNave.SECURITY);
		adyacentesUpperEngine.add(RoomNave.MEDBAY);
		adyacentesUpperEngine.add(RoomNave.CAFETERIA);
		nave.put(RoomNave.UPPER_ENGINE, new InfoSala(adyacentesUpperEngine, 0, false));
		
		List<RoomNave> adyacentesMedbay= new ArrayList<RoomNave>();
		adyacentesMedbay.add(RoomNave.UPPER_ENGINE);
		adyacentesMedbay.add(RoomNave.CAFETERIA);
		nave.put(RoomNave.MEDBAY, new InfoSala(adyacentesMedbay, 0, false));
		
		/*List<RoomNave> adyacentesAdmin= new ArrayList<RoomNave>();
		adyacentesAdmin.add(RoomNave.CAFETERIA);
		adyacentesAdmin.add(RoomNave.STORAGE);
		nave.put(RoomNave.ADMIN, new InfoSala(adyacentesAdmin, 0, false));
		*/
		
		//posicion inicial y energia inicial del impostor:
		this.setSalaActualImpostor(RoomNave.CAFETERIA);
		this.setEnegiaImpostor(1000);
        
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
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		
		str.append("\n");
		str.append("Nave: "+this.nave+"\n");
		str.append("Sala actual impostor: "+this.salaActualImpostor+"\n");
		str.append("Cantidad de tripulantes vivos: "+this.cantidadTripulantes+"\n");
		str.append("Energia: "+this.enegiaImpostor+"\n");
		
		return str.toString();
		
	}
}
