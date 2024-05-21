package impostor.classes;

import java.util.List;
import java.util.Random;

public class Tripulante {
	private int ciclos;
	private RoomNave posicion;
	
	public Tripulante() {
		this.ciclos=0;
		this.setPosicionInicial();
	}
	
	//Para escenarios
	public Tripulante(RoomNave posInicial) {
		this.ciclos=0;
		this.posicion=posInicial;
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
	
	public RoomNave changePosicion(List<RoomNave> salasAdyacentes) {
		
		Random random = new Random();
		
		if(this.ciclos>3 || random.nextDouble()>=0.5) {
			int indiceAleatorio = random.nextInt(salasAdyacentes.size());
			RoomNave newPosicion = salasAdyacentes.get(indiceAleatorio);
			//System.out.println("........Se mueve tripulante de: "+this.posicion);
			this.posicion= newPosicion;
			this.ciclos=1;
			//System.out.println(" a : "+this.posicion+" ...............");
			return newPosicion;
		}
		this.ciclos++;
		return null;
	}

	public int getCiclos() {
		return ciclos;
	}

	public void setCiclos(int ciclos) {
		this.ciclos = ciclos;
	}

	public void setPosicion(RoomNave posicion) {
		this.posicion = posicion;
	}
	
	public String toString() {
		return this.getPosicion().toString();
	}
}
