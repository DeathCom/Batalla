package BatallaNavalV;
public class BatallaNavalV {
	/**
	* Juego de batalla naval por ventanas de JOptionPane
	* Un solo jugador y un maximo de 3 botes.
	* Ultima Modificacion por comentarios en clase de programacion 1:
	* esta modificacion se realiza el 11-11-2017 y finaliza el mismo dia 
	* hora inicio 17:00 hora finializa modificacion: 22:00
	* Se crea un segundo jugador y se adapta el juego para dos jugadores 
	* por rumores que el juego debe ser para dos personas
	* Nota: 
	* Se debe re-acomodar el codigo y los comentarios ya que por la adaptacion 
	* se tuvo que re-ordenar el codigo casi en su totalidad.
	* Comentarios del codigo en  el paquete BatallaNavalC.
	* Se agrega ciclo para que no se salga del juego hasta que el usuario lo indique
	18-11-2017
	*se crea metodo de juego llamado jugando() y se llama todo el juego desde el main 
	*con solo el metodo jugando()
	*25-11-2017
	*Se hacen las mismas modificaciones que en el batallaNavalC.java, en el
	*JuegoC.java y en el UsoArchivoV.java
	*/
	public static void main(String[] args) {
		UsoArchivoV archivo = new UsoArchivoV();
		archivo.accesso();
	}//fin Main
}//Fin de public class BatallaNaval