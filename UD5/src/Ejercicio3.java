import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {
	public static void main(String[] args) throws IOException {
		String directorio=System.getProperty("user.dir");
		String rutaf=directorio+File.separator+"tres.dat";
		File fich=new File(rutaf);
		existeF(fich);
		BufferedWriter f=new BufferedWriter(new FileWriter(fich));
		escritura(f);
		f.close();
		
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
	public static void escritura(BufferedWriter file) throws IOException {
		Scanner in=new Scanner(System.in);
		System.out.println("Introduzca un numero positivo:");
		int num=in.nextInt();
		while(num>=0)
		{
			file.write(num);
			file.newLine();
			System.out.println("Introduzca el nombre a escribir en el fichero:");
			num=in.nextInt();
		}
		
			in.close();
		
	}
}
