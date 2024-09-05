package Modelos;

public class Menu {
	private String Nombre;
	
	
	public Menu() {
		Nombre = "";
	}

	
	
	public void setNombre(String nombreIngresado) {
		Nombre += nombreIngresado;
	}

	public String getNombre() {
		return Nombre;
	}

}
