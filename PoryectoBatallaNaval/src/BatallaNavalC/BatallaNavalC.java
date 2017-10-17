package BatallaNavalC;
import java.util.Scanner;
public class BatallaNavalC {
	/**
	* Juego de batalla naval por consola
	* Un solo jugador y un maximo de 3 botes.
	*/
	public static final boolean pintar = true;
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String [][] tablero = new String [8][8]; //declaro el array para el tablero
		tablero(tablero); //llamo al tablero que construyo con el array
		int barco1, barco2, barco3; //defino los espacion para los barcos
		
		do{ //controlamos que el usuario ingrese el tamaño correct de entre 1-4 para los barcos
			System.out.print("Digite la longitud del barco1 (1-4):");
			barco1 = entrada.nextInt();
			System.out.print("Digite la longitud del barco2 (1-4):");
			barco2 = entrada.nextInt();
			System.out.print("Digite la longitud del barco3 (1-4):");
			barco3 = entrada.nextInt();
			
			if(barco1<=0|| barco1>=5 || barco2<=0 || barco2>=5 || barco3<=0 || barco3>=5){
				System.out.println("UPS!\n" +
						"Digito algun dato no solicitado.");
			}
		}while((barco1<=0|| barco1>=5) || (barco2<=0 || barco2>=5) || (barco3<=0 || barco3>=5));
		
		int barcos = barco1+barco2+barco3; /*agarramos y sumamos el total en barcos para poder saber
		hasta donde se termina el juego*/
		
		BarcoCreacion(tablero, barco1, barco2, barco3);//creamos los barcos en el tablero
		int proyectiles=15, impacto=0; //definimos los proyectiles y los impactos
		
		while(proyectiles>0 && impacto<barcos){ //iniciamos el juego
			mostrar_tablero(tablero); //pintamos el tablero
			impacto = disparo(tablero, impacto, proyectiles); //almacenamos los impactos en el tabletro 
			proyectiles--; //restamos proyectiles
		}
		JuegoTerminado(impacto, proyectiles, barcos);
		/*indica cuando termina el juego en base a impactos en barcos y proyectiles*/

	}
	//######################################################################
	public static void tablero(String [][] tablero){ /*creamos el tablero, este
	recibe como parametro un array*/
		for(int i=0; i<tablero.length; i++){
			
			for(int j=0; j<tablero[0].length;j++){
				tablero[i][j] = "~";
			}
		}
		/*Lo anterior lo que hace es crear el tablero en consola*/
	}
	//######################################################################
	public static void mostrar_tablero(String [][] tablero){/*desplegamos el tablero
	y mostrar la posicion de los barcos en el tablero*/
		separacion();//llamamos una linea estetica de separacion
		for(int i=0; i<tablero.length; i++){//recorremos el tablero
			
			if(pintar){//verificamos que el tablero este vacio y lo pintamos en consola
				for(int j=0; j<tablero[0].length;j++){
					System.out.print(" "+tablero[i][j]);
				}
				System.out.println(" ");
			}/*else{
				for(int j=0; j<tablero[0].length;j++){
					if(tablero[i][j].equals("B")){
						System.out.print(" "+"~");
					}
					else{
						System.out.print(" "+tablero[i][j]);
					}
				}
				System.out.println(" ");
			}*/
			/*esta parte cmentada es mas de verificacion del tablero*/
		}
		separacion();//llamamos una linea estetica de separacion
	}
	public static void separacion(){//linea estetica de separacion
		System.out.println("____________________________");
		System.out.println(" ");
	}
	//######################################################################
	public static void BarcoCreacion(String [][] tablero, int barco1, int barco2, int barco3){ //creo barcos y posicion random.
		
		//creando barco1
		if(Math.random() < 0.5){ 
			/*posiciona en las filas - Horizontal
			 * la decimos al array que el resultado de math*5 lo almacene en columna
			 * y el de math*7 en fila, esto para pocicionar el varco en horizontal
			 * el math<0.5 define que el numero no va superar el tamaño ya
			 * que si sale un numero mayor ya no entran en el array.*/

			int columna = (int) (Math.random()*5);
			int fila = (int) (Math.random()*7);
			
			/*nos crea el barco en el array con la posicion anterior
			 * los barcos deben ser menores a "BBBB" y mayores o iguales a "B*/
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
		/*llamamos el array, el impacto y los proyectiles
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
}//Fin de public class BatallaNaval