import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2 {

public static void main(String[] args) throws IOException {
	System.out.println("El directorio actual es: ");
	String directorio=System.getProperty("user.dir");
    System.out.println(directorio);
    
    String rutad1=directorio+File.separator+"dirEjer2";
        
	File dir=new File(rutad1);
	existeD(dir);
	
	String rutaf1=rutad1+File.separator+"uno.txt";
	
	String rutaf2=rutad1+File.separator+"dos.txt";
	File fich1=new File(rutaf1);
	File fich2=new File(rutaf2);
	existeF(fich1);
	existeF(fich2);
	

    BufferedWriter f1=new BufferedWriter(new FileWriter(rutaf1));
	escritura(f1);
	f1.close();
	
		
	
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
public static void existeD(File file)
{
	if(file.isDirectory())
	{
		System.out.println("El directorio "+file+ " ya existía.");
	}
	else {
		file.mkdir();
		System.out.println("El directorio "+file+ " se ha creado.");
	}
}
public static void escritura(BufferedWriter file) throws IOException {
	Scanner in=new Scanner(System.in);
	System.out.println("Introduzca el nombre a escribir en el fichero:");
	String nombre=in.nextLine();
	while(!nombre.equals("-"))
	{
		file.write(nombre);
		file.newLine();
		System.out.println("Introduzca el nombre a escribir en el fichero:");
		nombre=in.nextLine();
	}
	
		
	
		in.close();
	
}

}
