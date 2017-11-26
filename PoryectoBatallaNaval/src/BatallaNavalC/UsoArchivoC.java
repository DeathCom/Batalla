package BatallaNavalC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
public class UsoArchivoC {
	public void accesso(){
		Scanner entrada = new Scanner(System.in);
		UsoArchivoC archivo = new UsoArchivoC();
		JuegoC iniciar = new JuegoC();
		String password="";
		int count=0;
		do{
			System.out.println("Digite Contraseña para ingresar: ");
			password = entrada.next();
			
			if(archivo.leerArchivo("contrasena.txt").equals(password)){
				iniciar.jugando();//todo el juego es llamado a travez de jugando()
			}else{
				System.out.println("Contraseña Incorrecta");
				count++;
			}
			if(count==3){
				System.out.println("Ha hecho demasiados intentos\n" +
						"Chao............");
				break;
			}
		}while(!archivo.leerArchivo("contrasena.txt").equals(password));
		entrada.close();
	}	
	/*Se crea metodo leerArchivo para leer la contraseña de acceso al juego*/
	public String leerArchivo(String archivo){
		String password="";
		try{
			FileReader leer = new FileReader(archivo);
			BufferedReader almacenar = new BufferedReader(leer);
			password = almacenar.readLine();
			almacenar.close();
			
		}catch(Exception e){
			System.out.println("Error al leer el archivo");
		}
		return password;
		
	}
}
