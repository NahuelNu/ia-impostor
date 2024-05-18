package impostor.classes;

import java.util.Random;

public class DatosIniciales {
	private RoomNave salaInicialImpostor;
	private int energiaInicialImpostor;
	private int cantTripulantes;
	
	public DatosIniciales() {
		
		this.setSalatInicialImpostor();
		Random random = new Random();
		this.energiaInicialImpostor= random.nextInt(30,150);
		this.cantTripulantes = random.nextInt(1, 11);
	}
	
	public int getCantTripulantes() {
		return this.cantTripulantes;
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
	
	public int getEnergiaInicialImpostor() {
		return this.energiaInicialImpostor;
	}
}
