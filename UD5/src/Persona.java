import java.io.Serializable;

public class Persona implements Serializable{
public String nombre;
public String apellido1;
public String apellido2;
public int edad;
	public Persona(String nombre, String apellido1, String apellido2, int edad) {
		this.nombre=nombre;
		this.apellido1=apellido1;
		this.apellido2=apellido2;
		this.edad=edad;
	}
	public void mostrarPersonas() {
		System.out.println("El nombre es: "+nombre);
        System.out.println("El apellido1 es: "+apellido1);
        System.out.println("El apellido2 es: "+apellido2);
        System.out.println("La edad es: "+edad);
	}
}
