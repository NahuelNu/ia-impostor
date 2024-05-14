package impostor.classes;

import java.util.List;
import java.util.Objects;

public class InfoSala {

	private List<RoomNave> salasAdyacentes;
	private int cantidadTripuntalesEnSala;
	private boolean tareaSaboteable;
	
	public InfoSala(List<RoomNave> salasAdyacentes, int cantidadTripuntalesEnSala, boolean tareaSaboteable) {
		super();
		this.salasAdyacentes = salasAdyacentes;
		this.cantidadTripuntalesEnSala = cantidadTripuntalesEnSala;
		this.tareaSaboteable = tareaSaboteable;
	}
	public List<RoomNave> getSalasAdyacentes() {
		return salasAdyacentes;
	}
	public void setSalasAdyacentes(List<RoomNave> salasAdyacentes) {
		this.salasAdyacentes = salasAdyacentes;
	}
	public int getCantidadTripuntalesEnSala() {
		return cantidadTripuntalesEnSala;
	}
	public void setCantidadTripuntalesEnSala(int cantidadTripuntalesEnSala) {
		this.cantidadTripuntalesEnSala = cantidadTripuntalesEnSala;
	}
	public boolean isTareaSaboteable() {
		return tareaSaboteable;
	}
	public void setTareaSaboteable(boolean tareaSaboteable) {
		this.tareaSaboteable = tareaSaboteable;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cantidadTripuntalesEnSala, salasAdyacentes, tareaSaboteable);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InfoSala other = (InfoSala) obj;
		
		return cantidadTripuntalesEnSala == other.cantidadTripuntalesEnSala && tareaSaboteable == other.tareaSaboteable;
	}
	
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();

        str.append("Salas adyacentes: " + this.salasAdyacentes);
        str.append("; ");
        str.append("Cantidad Tripuntales En Sala: " + this.cantidadTripuntalesEnSala);
        str.append("; ");
        str.append("Tarea Saboteable: " + this.tareaSaboteable);


        return str.toString();
    }
	
}
