package impostor.classes;

import java.util.Random;

public class Tripulante {
	private int ciclos;
	private RoomNave posicion;
	
	public Tripulante() {
		this.ciclos=0;
		this.setPosicionInicial();
	}

	public RoomNave getPosicion() {
		return posicion;
	}

	private void setPosicionInicial() {
		RoomNave[] salas = RoomNave.values();
		Random random = new Random();
		int indiceAleatorio = random.nextInt(salas.length);
		this.posicion= salas[indiceAleatorio];
	}
	
	public RoomNave changePosicion(RoomNave[] salasAdyacentes) {
		
		Random random = new Random();
		
		if(this.ciclos>3 || random.nextDouble()>=0.5) {
			int indiceAleatorio = random.nextInt(salasAdyacentes.length);
			RoomNave newPosicion = salasAdyacentes[indiceAleatorio];
			this.posicion= newPosicion;
			this.ciclos=1;
			return newPosicion;
		}
		this.ciclos++;
		return null;
	}
	
	
}
