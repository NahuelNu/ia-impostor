package impostor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.state.EnvironmentState;

public class ImpostorEnvironmentState extends EnvironmentState {
	
	// HashMap1: key: Ambiente, value:
	//										HashMap2: key: AmbientesAdyacentes, value: Percepciones 
	// private Map<RoomNave,Map<RoomNave,List<Perception>>> world;
	
	// Otra idea - prueba de inicializacion en initState:
	// HashMap1: key Ambiente, value:
	// 								Lista con 2 elementos: [Lista de AmbientesAdyacentes, Lista de Percepciones]
	private Map<RoomNave,List<Object>> world;
	 
	private Integer cantTripulantesVivos;
	//private List<RoomNave> tareasASabotear;
	private RoomNave posicionAgente;
	private Integer energiaAgente;
	
	
	public ImpostorEnvironmentState() {
		this.initState();
	}
	
	// TODO
	@Override
	public void initState() {

		//Mapa prueba
		
		//variable mapa
		this.world = new HashMap<RoomNave,List<Object>>();
		
		//lista de [ambientes adyacentes] y [percepciones]
		List<Object> listaEjemplo = new ArrayList<>();
		
		//lista de ambientes adyacentes
		List<RoomNave> listaAdyacentes = new ArrayList();
		listaAdyacentes.add(RoomNave.ADMIN);
		listaAdyacentes.add(RoomNave.ELECTRICAL);
		
		//lsita de percepciones
		List<Integer> listaPercepciones = new ArrayList();
		listaPercepciones.add(ImpostorPerception.EMPTY_PERCEPTION);
		
		listaEjemplo.add(listaAdyacentes);
		listaEjemplo.add(listaPercepciones);
		
		//Primer ambiente insertado 
		world.put(RoomNave.CAFETERIA, listaEjemplo);
		
		
		List<RoomNave> listaAdyacentes2 = new ArrayList();
		listaAdyacentes2.add(RoomNave.CAFETERIA);
		List<Integer> listaPercepciones2 = new ArrayList();
		listaPercepciones2.add(ImpostorPerception.ENEMY_PERCEPTION);
		List<Object> listaEjemplo2 = new ArrayList<>();
		listaEjemplo2.add(listaAdyacentes2);
		listaEjemplo2.add(listaPercepciones2);		
		world.put(RoomNave.ADMIN, listaEjemplo2);
		
		List<RoomNave> listaAdyacentes3 = new ArrayList();
		listaAdyacentes3.add(RoomNave.CAFETERIA);
		List<Integer> listaPercepciones3 = new ArrayList();
		listaPercepciones3.add(ImpostorPerception.ENEMY_PERCEPTION);
		List<Object> listaEjemplo3 = new ArrayList<>();
		listaEjemplo3.add(listaAdyacentes3);
		listaEjemplo3.add(listaPercepciones3);
		world.put(RoomNave.ELECTRICAL, listaEjemplo3);
		
		
		System.out.println("Contenido del HashMap:");
		System.out.println(world);
		
		this.posicionAgente = RoomNave.CAFETERIA;
		this.energiaAgente = 10;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public RoomNave getPosicionAgente() {
		return posicionAgente;
	}

	public void setPosicionAgente(RoomNave posicionAgente) {
		this.posicionAgente = posicionAgente;
	}

	public List<Integer> getListPerceptions(RoomNave posAgente) {
		return (List<Integer>) world.get(posAgente).get(1);
	}
}
