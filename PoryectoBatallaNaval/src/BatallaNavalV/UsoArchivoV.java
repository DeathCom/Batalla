package BatallaNavalV;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JOptionPane;


public class UsoArchivoV {
	public void accesso(){
		UsoArchivoV archivo = new UsoArchivoV();
		JuegoV iniciar = new JuegoV();
		String password="";
		int count=0;
		do{
			password = JOptionPane.showInputDialog("Digite Contraseña para ingresar: ");			
			if(archivo.leerArchivo("contrasena.txt").equals(password)){
				iniciar.jugando();//todo el juego es llamado a travez de jugando()
			}else{
				JOptionPane.showMessageDialog(null, "Contraseña Incorrecta");
				count++;
			}
			if(count==3){
				JOptionPane.showMessageDialog(null, "Ha hecho demasiados intentos\n" +
						"Chao............");
				break;
			}
		}while(!archivo.leerArchivo("contrasena.txt").equals(password));  
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
			JOptionPane.showMessageDialog(null, "Error al leer el archivo");
		}
		return password;
		
	}
}
