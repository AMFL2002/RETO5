import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Ejercicio1 {
	public static void main(String[]args) throws IOException {
		Scanner entrada=new Scanner(System.in);
		System.out.println("Introduza el nombre del primer fichero (con longitud igual o superior a 3):");
		String fich1=entrada.nextLine();
		while(fich1.length()<3)
		{
			System.out.println("Introduza el nombre del primer fichero (con longitud igual o superior a 3):");
			fich1=entrada.nextLine();
		}
		System.out.println("Introduza el nombre del segundo fichero (con longitud igual o superior a 3):");
		String fich2=entrada.nextLine();
		while(fich2.length()<3)
		{
			System.out.println("Introduza el nombre del segundo fichero (con longitud igual o superior a 3):");
			fich2=entrada.nextLine();
		}
		entrada.close();
		String directorioActual=System.getProperty("user.dir");
		System.out.println(directorioActual);
		String rutaCompletaFich1 = directorioActual + File.separator +fich1+".txt";
		File fichero1=new File(rutaCompletaFich1);
		String rutaCompletaFich2 = directorioActual + File.separator +fich2+".txt";
		File fichero2=new File(rutaCompletaFich2);
		
		boolean existe1=comprobarExiste(fichero1);
		boolean existe2=comprobarExiste(fichero2);
		if(comprobarExiste(fichero1)) {
	    boolean escribir=escribirEnFichero(rutaCompletaFich1);
	    boolean leer=leerDeFichero(rutaCompletaFich1);
	    System.out.println("Nombre del fichero: "+fichero1.getName());
	    System.out.println("Ruta absoluta del fichero: "+fichero1.getAbsolutePath());
	    System.out.println("Ruta del directorio padre: "+fichero1.getParent());
	    System.out.println("Tamaño del fichero del fichero: "+fichero1.length());
	    if(fichero1.isDirectory()) {
	    	System.out.println("Es un direcorio.");
	    }
	    else {
	    	System.out.println("Es un fichero.");
	    }
	    System.out.println("¿Permiso de lectura?: "+fichero1.canRead());
	    System.out.println("¿Permiso de escritura?: "+fichero1.canWrite());
	    System.out.println("¿Permiso de ejecución?: "+fichero1.canExecute());
	    System.out.println("¿Está oculto?: "+fichero1.isHidden());
	    
	    boolean duplica=duplicarFicheros(fichero1, fichero2);
	    boolean borrar=borrarFichero(fichero1);


	    
		}
		else {
			{
				System.out.println("El fichero no existe, por lo tanto no puedo mostrar sus propiedades.");
			}
		}
	}
	public static boolean leerDeFichero(String miFichero) throws IOException {
		FileReader fich=new FileReader(miFichero);
		int i=fich.read();
		while(i!=-1)
		{
			System.out.println((char)i);
			i=fich.read();
		}
		fich.close();
		return true;
		
		
	}
	public static boolean escribirEnFichero(String miFichero) throws IOException {
		FileWriter fich = new FileWriter(miFichero);
			
			for(int i=0; i<=10;i++) 
			{
			fich.write(""+i);
			fich.write('\n');
			}
			fich.close();
		
		return true;
		
	}
	public static boolean borrarFichero(File miFichero) {
		
		if (miFichero.delete())
		{
	        System.out.println("El fichero ha sido borrado satisfactoriamente");
		return true;
		}
	    else
	    {
	        System.out.println("El fichero no pudó ser borrado");
	        return false;
	    }
		
	}
	public static boolean comprobarExiste(File miFichero) {
		if(miFichero.exists())
		{
			
			System.out.println("El fichero "+miFichero+ " ya existía.");
			return true;
		}
		else {
			
			try {
				miFichero.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("El fichero "+miFichero+ " se ha creado.");
			return false;
		}
	}
	
	public static boolean duplicarFicheros(File origen, File destino) throws IOException {
		FileWriter out=new FileWriter(destino);
		FileReader in= new FileReader(origen);
		int i;
		while((i=in.read())!=-1)
		{
			out.write((char)i);
		}
		in.close();
		out.close();
		return true;
		
		
	}
	
}
