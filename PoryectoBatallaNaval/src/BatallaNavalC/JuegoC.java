package BatallaNavalC;

import java.util.Scanner;

public class JuegoC {
	//######################################################################
	public static void tablero(String [][] tablero){ 
		/*creamos el tablero, este recibe como parametro un array*/
		for(int i=0; i<tablero.length; i++){
			for(int j=0; j<tablero[0].length;j++){
				tablero[i][j] = "~";
			}
		}
		/*Lo anterior lo que hace es crear el tablero en consola*/
	}
	//######################################################################
	public static void mostrarTablero(String [][] tablero){
		/*desplegamos el tablero y mostrar la posicion de los barcos en el tablero*/
		
		separacion();
		/*llamamos una linea estetica de separacion, solo por usar un separador*/
		
		for(int i=0; i<tablero.length; i++){
			/*recorremos el tablero desde 0 a fin y lo pintmos en pantalla*/
			
			for(int j=0; j<tablero[0].length;j++){
				System.out.print(" "+tablero[i][j]);
			}
			System.out.println(" ");
		}
		separacion();//llamamos una linea estetica de separacion
	}
	public static void separacion(){
		/*linea de separacion de la matiz, metodo solo dibuja una linea*/
		System.out.println("____________________________");
		System.out.println(" ");
	}
	//######################################################################
	public static void BarcoCreacion(String [][] tablero, int barco1, int barco2, int barco3){ 
		/*Creo un barco recibiendo los parametros tablero y barcos y en base a esto se van a posicionar 
		 * con una formula de pintado de posiciones de forma random obtenida de internet.
		 * donde se define el rango de numero y se genera ese numero de forma aleatoria*/
		
		//creando barco1
		
		/*posiciona en las filas - Horizontal
		 * le decimos al array que el resultado de math*5 lo almacene en columna
		 * y el de math*7 en fila, esto para pocicionar el barco en horizontal
		 * esto asi ya que sabemos que la matriz es de 8X8 entonces en math*5 me garantizo que
		 * el tamaño el barco si excede el largo podria convertirse en un pintado vertical, 
		 * de lo contrario se pintara horizontal, esto de la siguente manera:
		 * fila puede ir de 0 a 7
		 * columna puede ir  de 0 a 5
		 * esto para dar los espacios necesarios para que los barcos no
		 * se salgan de la matriz
		 *por otro lado el (int) (Math.random()*5) y el (int) (Math.random()*7) nos dice
		 *que se convieta a eintero y sea un numero entre 0 a 5 y de 0 a 7*/
		if(Math.random() < 0.5){ 
			
			int columna = (int) (Math.random()*5);
			int fila = (int) (Math.random()*7);
			
			/*nos crea el barco en el array con la posicion anterior
			 * los barcos deben ser menores a "BBBB" y mayores o iguales a "B
			 * esto en otras palabas es agarre los datos antriores y metolos en el array del tablero
			 * recorriendolo y lenando las posicones dadas de el array desde fila a columna*/
			
			for(int i=0; i<barco1;i++){
				tablero[fila][columna+i]= "B";
			}
			
		}else{ 
			/*posiciona en las columnas - Vertical
			 * Este else hace lo mismo pero a la inversa para trabajar con las verticales*/
			
			int columna = (int)(Math.random()*7);
			int fila = (int) (Math.random()*5);
			
            for(int i = 0; i<barco1; i++)
            {
            	tablero[fila+i][columna]= "B";
            }
		}
		//Este mismo proceso lo repito dos veces mas para crear otros dos barcos.
		//Creando Barco2
		if(Math.random() < 0.5){ 
			//posiciona en las filas - Horizontal

			int columna = (int) (Math.random()*5);
			int fila = (int) (Math.random()*7);
			
			for(int i=0; i<barco2;i++){
				tablero[fila][columna+i]= "B";
			}
			
		}else{ 
			//posiciona en las columnas - Vertical
			
			int columna = (int)(Math.random()*7);
			int fila = (int) (Math.random()*5);
			
            for(int i = 0; i<barco2; i++)
            {
            	tablero[fila+i][columna]= "B";
            }
		}
		//Creando Barco3
		if(Math.random() < 0.5){ 
			//posiciona en las filas - Horizontal
			int columna = (int) (Math.random()*5);
			int fila = (int) (Math.random()*7);
					
			for(int i=0; i<barco3;i++){
				tablero[fila][columna+i]= "B";
			}
			
		}else{ 
			//posiciona en las columnas - Vertical
			int columna = (int)(Math.random()*7);
			int fila = (int) (Math.random()*5);
			
		    for(int i = 0; i<barco3; i++)
		    {
		    	tablero[fila+i][columna]= "B";
		    }
		}
	}
	//######################################################################
	public static int disparo(String [][] tablero, int impacto, int proyectiles){
		/*llamamos desde disparo el array tablero, el impacto y los proyectiles
		 * con esto nos encargamos de buscar la posicion que el usuario digito 
		 * luego validamos y si existe una "B" la cambiamos por una "X" de lo
		 * contraio ponemos una "M"*/
		Scanner entrada = new Scanner(System.in);
		int fila, columna;
		System.out.println("Tiene "+proyectiles+" proyectiles");
		//Mostramos cantidad de proyectiles que posee
		
		/*Controlamos el ingreso de la posicion para que no se ingrese una posicion
		 * inexistente tanto para filas como columnas*/
		System.out.println("Seleccione Fila deseada: ");
		fila = entrada.nextInt();
		while(fila>8 || fila<1){
			System.out.println("Ingrese un valor de 1 a 8: ");
			fila = entrada.nextInt();
		}
		
		System.out.println("Seleccione Columna deseada: ");
		columna = entrada.nextInt();
		while(columna>8 || columna<1){
			System.out.println("Ingrese un valor de 1 a 8: ");
			columna = entrada.nextInt();
		}
		
		if(tablero[fila-1][columna-1].equalsIgnoreCase("B")){
			impacto++;
			System.out.println("--Impact--");
			tablero[fila-1][columna-1]="X";
		}else{
			System.out.println("--Fallo--");
			tablero[fila-1][columna-1]="M";
		}
		return impacto;
		/*Unicamente contamos los impactos por cada acierto en las "B" y retornamos los impactos
		 * que se almacenaran nuevamente en impacto del Main
		 * esta forma era mas facil que un while o do while en el Main*/
	}
	//######################################################################
	public static void JuegoTerminado(int impacto, int proyectiles, int barcos){
		/*una vez completado el while del Main le decimos las estadisticas al usuario
		 * esto estaba dentro del main pero se movio aqui para queno estiorve*/
		if(impacto<barcos){
			System.out.println("Lo siento no pudo destruir los barco");
		}
		if(proyectiles<1){
			System.out.println("Ya no tiene mas proyectiles");
		}else if(impacto>=barcos){
			System.out.println("Destruiste las naves con exito");
		}
		System.out.println("Fin del Juego.");
		/*los dos If salen al mismo tiempo junto con el ultimo mensaje y solo salen
		 * si el usurio agoto todos los proyectiles y quedo con impactos pendientes
		 * el else if solo sale si quedo con proyectiles e impacto es igual a barcos*/
	}
}
