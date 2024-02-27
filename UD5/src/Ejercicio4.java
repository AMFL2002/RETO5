import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ejercicio4 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String directorio=System.getProperty("user.dir");
		String rutaf1=directorio+File.separator+"persona.dat";
		File fichero=new File(rutaf1);
		existeF(fichero);
		Persona per1=new Persona("Noa","Fdez.","López",6);
		Persona per2=new Persona("Mimi","Fdez.","López",5);
		Persona per3=new Persona("Negri", "Fdez.", "López",4);
		
		escribir(fichero,per1,per2,per3);
		
		leer(fichero);
	}
	public static void escribir(File fich,Persona per1, Persona per2, Persona per3 ) throws IOException {
		FileOutputStream ficher=new FileOutputStream(fich);
		ObjectOutputStream objfich=new ObjectOutputStream(ficher);
		objfich.writeObject(per1);
		objfich.writeObject(per2);
		objfich.writeObject(per3);
		objfich.close();
	}
	public static void leer(File fich) throws IOException, ClassNotFoundException {
		 ObjectInputStream objfichin=null;
		try {
		FileInputStream fileIn = new FileInputStream(fich);
        objfichin = new ObjectInputStream(fileIn);
        Persona pers1=(Persona) objfichin.readObject();
        while(pers1!=null)
        {
        
        pers1.mostrarPersonas();
        pers1=(Persona) objfichin.readObject();
        }
        }
		catch(EOFException e) {
			System.out.println("El fichero ya ha sido leido entero.");
			
		}
        finally {
        objfichin.close();
        }
		
	}
	public static void existeF(File file)
	{
		if(file.exists())
		{
			System.out.println("El fichero "+file+ " ya existía.");
		}
		else {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("El fichero "+file+ " se ha creado.");
		}
	}
}
