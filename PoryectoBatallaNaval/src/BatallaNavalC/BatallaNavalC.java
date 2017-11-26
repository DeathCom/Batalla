package BatallaNavalC;
public class BatallaNavalC {
	/**
	* Juego de batalla naval por consola
	* Un solo jugador y un maximo de 3 botes.
	* Ultima Modificacion por comentarios en clase de programacion 1:
	* esta modificacion se realiza el 11-11-2017 y finaliza el mismo dia 
	* hora inicio 17:00 hora finializa modificacion: 22:00
	* Se crea un segundo jugador y se adapta el juego para dos jugadores 
	* por rumores que el juego debe ser para dos personas
	* Nota: 
	* Se debe re-acomodar el codigo y los comentarios ya que por la adaptacion 
	* se tuvo que re-ordenar el codigo casi en su totalidad.
	* Se agrega ciclo para que no se salga del juego hasta que el usuario lo indique
	*18-11-2017
	*se crea metodo de juego llamado jugando() y se llama todo el juego desde el main 
	*con solo el metodo jugando()
	*25/11/2017
	*se inicia proceso para hacer que el proyecto use archivos de texto
	*se utilizara en el main
	*se crea la clase UsoArchivo y ahi se crea el metodo del archivo
	*se mueve el metodo jugando a la clase JuegoC
	*Se crea el nuevo metodo llamado acceso y se mueve a a clase UsoArchivo
	*se eliminan todos los metodos estaticos
	*Fin del update
	*Nota: Misma modoficciones se hacen para el batalla naval en ventanas*/
	public static void main(String[] args) {
		UsoArchivoC archivo = new UsoArchivoC();
		archivo.accesso(); 
	}
	
}//Fin de public class BatallaNaval