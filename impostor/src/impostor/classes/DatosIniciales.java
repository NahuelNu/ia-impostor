package impostor.classes;

import java.util.Random;

public class DatosIniciales {
	private RoomNave salaInicialImpostor;
	private int energiaInicialImpostor;
	
	public DatosIniciales() {
		
		this.setSalatInicialImpostor();
		this.setEnergiaInicialImpostor();
		
	}
	
	private void setSalatInicialImpostor() {
		RoomNave[] salas = RoomNave.values();
		Random random = new Random();
		int indiceAleatorio = random.nextInt(salas.length);
		this.salaInicialImpostor= salas[indiceAleatorio];
	}
	
	private void setEnergiaInicialImpostor() {
		Random random = new Random();
		this.energiaInicialImpostor= random.nextInt(30,150);
	}
	
	public RoomNave getSalaInicialImpostor() {
		return this.salaInicialImpostor;
	}
	
	public int getEnergiaInicialImpostor() {
		return this.energiaInicialImpostor;
	}
}
