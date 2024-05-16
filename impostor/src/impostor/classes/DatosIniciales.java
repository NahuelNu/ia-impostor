package impostor.classes;

import java.util.Random;

public class DatosIniciales {
	private RoomNave salaInicialImpostor;
	
	
	public DatosIniciales() {
		
		this.setSalatInicialImpostor();
		
		
	}
	
	private void setSalatInicialImpostor() {
		RoomNave[] salas = RoomNave.values();
		Random random = new Random();
		int indiceAleatorio = random.nextInt(salas.length);
		this.salaInicialImpostor= salas[indiceAleatorio];
	}
	
	public RoomNave getSalaInicialImpostor() {
		return this.salaInicialImpostor;
	}
}
