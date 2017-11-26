package BatallaNavalC;
import java.util.Scanner;
public class JuegoC {
	//######################################################################
	public void jugando(){
		/*Se traslada de la clase main a la clase a la clase JuegoC y se llama desde acceso*/
		Scanner entrada = new Scanner(System.in);
		/*Declaramos el scaner para las entradas*/
		JuegoC jugador1 = new JuegoC();
		JuegoC jugador2 = new JuegoC();
		/*Se instancias dos objetos de la clase JuegoV una para el jugador uno
		 * y la otra para el jugador dos*/
		
		String [][] tablero1 = new String [8][8];
		String [][] tablero2 = new String [8][8];
		/*Se delcaran los arrays necesarios para los tableros de los jugadores
		 *  uno y dos*/
		
		/*se mueven los llenados de tablero adentor del do-while, por que se descubre que
		 * cuando se inicia un nuevo juego carga la info de la batalla anterior*/
		//jugador1.tablero(tablero1); 
		//jugador2.tablero(tablero2); 
		/*Se llena el metodo tablero con el tablero correspondiente a cada jugador
		 * con un parametro de tipo matriz tambien llamado tablero*/
		String salir="";
		int barcoJ1_1, barcoJ1_2, barcoJ1_3, barcoJ2_1, barcoJ2_2, barcoJ2_3; 
		/*Estas variables son las que definen los tamaños de cada bote de cada uno
		 * de los jugadores*/
		do{
			//movimiento anteriormente mencionado para llenado de tablas de jugadores
			jugador1.tablero(tablero1); 
			jugador2.tablero(tablero2); 
			System.out.println("Digite \"I\" para iniciar o \"S\" para salir ");
			salir = entrada.next();
			
			if(salir.equalsIgnoreCase("i")){
				System.out.println("Bienvenido al Juego de Batalla Naval de Carlos Pérez\n" +
						"Que se divierta");//saludo de bienvenida :)
				
				do{ 
					/*controlamos que los usuarios ingresen el tamaño correcto de los barcos, 
					 * que va de 1-4 y no exeda su tamaño porque podria desbordar la matiz*/
					System.out.println("Seleccione el tamaño de las naves del Jugador 1");
					System.out.print("Digite la longitud del barco1 (1-4):");
					barcoJ1_1 = entrada.nextInt();
					System.out.print("Digite la longitud del barco2 (1-4):");
					barcoJ1_2 = entrada.nextInt();
					System.out.print("Digite la longitud del barco3 (1-4):");
					barcoJ1_3 = entrada.nextInt();
					System.out.println("Seleccione el tamaño de las naves del Jugador 2");
					System.out.print("Digite la longitud del barco1 (1-4):");
					barcoJ2_1 = entrada.nextInt();
					System.out.print("Digite la longitud del barco2 (1-4):");
					barcoJ2_2 = entrada.nextInt();
					System.out.print("Digite la longitud del barco3 (1-4):");
					barcoJ2_3 = entrada.nextInt();
					
					if(barcoJ1_1<=0|| barcoJ1_1>=5 || barcoJ1_2<=0 || barcoJ1_2>=5 || barcoJ1_3<=0 
							|| barcoJ1_3>=5 || barcoJ1_1<=0|| barcoJ1_1>=5 || barcoJ1_2<=0 || 
							barcoJ1_2>=5 || barcoJ1_3<=0 || barcoJ1_3>=5){
						System.out.println("UPS!\n" +
								"Digito algun dato no solicitado.");
					}
				}while((barcoJ1_1<=0 || barcoJ1_1>5) || (barcoJ1_2<=0 || barcoJ1_2>5) || (barcoJ1_3<=0 
						|| barcoJ1_3>5) || (barcoJ2_1<=0 || barcoJ2_1>5) || (barcoJ2_2<=0 || 
						barcoJ2_2>5) || (barcoJ2_3<=0 || barcoJ2_3>5));
				/*le indicaos al while que mientras lo anterior no se cmpla, se mantenga activo*/
				
				int barcosJ1 = (barcoJ1_1+barcoJ1_2+barcoJ1_3), barcosJ2 = (barcoJ2_1+barcoJ2_2+barcoJ2_3); 
				/*agarramos y sumamos el total en barcos para poder saber el total de objetivos y asi
				 * sacar el numero de aciertos que deben haber en el juego, o sea esto define cantidad de barcos
				 * a nivel de posicion ocupada por el array del juego y asi mismo sacamos el numero de proyectiles
				 * para cada usuario y que estos tengan las mismas oportunidades de ganar :)*/
				
				jugador1.BarcoCreacion(tablero1, barcoJ1_1, barcoJ1_2, barcoJ1_3);
				jugador2.BarcoCreacion(tablero2, barcoJ2_1, barcoJ2_2, barcoJ2_3);
				/*le pasamos al metodo de creacion de barcos  el tamano del tablero
				 * y el tamano de los barcos esto para cada jugador, esto crear barcos con posiciones
				 * diferentes para cada usuario*/
				
				int proyectilesJ1=(barcosJ1+1), impacto1=0; 
				int proyectilesJ2=(barcosJ2+1), impacto2=0; 
				/*estas dos variables estan ahi solo para inicializar los proyectiles y 
				 * el numero de impactos donde los proyectiles son un protyectil mas de la cantidad de
				 * posiciones del array de cada jugador*/
				
				while(proyectilesJ1>0 && impacto1<barcosJ1 && proyectilesJ2>0 && impacto2<barcosJ2){ 
					/*con este while iniciamos el juego donde decimos que si los impactos es menor a barcos
					 * o sea mientras existan barcos oh mientras proyectiles sean igual a 0 oh mientras 
					 * tenga balas se va a ejecutar lo de aqui adentro*/
					
					/*Indicamos cual jugador esta al ataque luego pintamos la matriz a atacar en este caso
					 * la del contrario recibimos la posicion y psamos lo del metodo disparo a impacto
					 * luego reducimos proyectiles en uno*/
					System.out.println("Jugador uno atacando area del jugador dos:");
					jugador2.mostrarTablero(tablero2);
					impacto2 = jugador2.disparo(tablero2, impacto2, proyectilesJ2);
					proyectilesJ2--;
					
					System.out.println("Jugador dos atacando area del jugador uno:");
					jugador1.mostrarTablero(tablero1); 
					impacto1 = jugador1.disparo(tablero1, impacto1, proyectilesJ1);
					proyectilesJ1--;
					
					/*
					 * Comentarios antes de modificacion:
					 * pintamos el tablero, aqui llamamos al metodo mostrarTablero y le pasamos un parametro tipo
					 * matriz llamado tablero que se definio en el inicio*/			
					/*le decimos a impacto que va a ser igual al valor que retorna disparo, el cual recibe
					 * como parametro el tableto, impacto y proyectiles*/
					/*por cada vez que ingresamos aqui a fuerza se va arestar un proyectil*/
				}//Salimos del while
				
				System.out.println("Jugador Uno:");
				jugador2.JuegoTerminado(impacto2, proyectilesJ2, barcosJ2);
				System.out.println("Jugador Dos:");
				jugador1.JuegoTerminado(impacto1, proyectilesJ1, barcosJ1);
				/*llamas a metodo JuegoTerminado y le pasamos impactos, proyectil y barcos 
				 * para que nos valide y saber si se perdio o gano*/
			}else if(salir.equalsIgnoreCase("s")){
				System.out.println("Chao....");
			}else{
				System.out.println("Digito algo que NO es: \nni \"I\" ni \"S\"");
			}
		}while(!salir.equalsIgnoreCase("s"));
	}
	//######################################################################
	public void tablero(String [][] tablero){ 
		/*creamos el tablero, este recibe como parametro un array*/
		for(int i=0; i<tablero.length; i++){
			for(int j=0; j<tablero[0].length;j++){
				tablero[i][j] = "~";
			}
		}
		/*Lo anterior lo que hace es crear el tablero en consola*/
	}
	//######################################################################
	public void mostrarTablero(String [][] tablero){
		/*desplegamos el tablero y mostrar la posicion de los barcos en el tablero*/
		
		separacion();
		/*llamamos una linea estetica de separacion, solo por usar un separador*/
		System.out.println("  1  2  3  4  5  6  7  8");//Se agrega encabezado a las columnas
		for(int i=0; i<tablero.length; i++){
			/*recorremos el tablero desde 0 a fin y lo pintmos en pantalla*/
			System.out.print((i+1));//Se agrega encabezado a las filas
			for(int j=0; j<tablero[0].length;j++){
				System.out.print(" "+tablero[i][j]+" ");
			}
			System.out.println(" ");
		}
		separacion();//llamamos una linea estetica de separacion
	}
	//######################################################################
	public void separacion(){
		/*linea de separacion de la matiz, metodo solo dibuja una linea*/
		System.out.println("____________________________");
		System.out.println(" ");
	}
	//######################################################################
	public void BarcoCreacion(String [][] tablero, int barco1, int barco2, int barco3){ 
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
	public int disparo(String [][] tablero, int impacto, int proyectiles){
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
			System.out.println("--Impact--\n");
			tablero[fila-1][columna-1]="X";
		}else{
			System.out.println("--Fallo--\n");
			tablero[fila-1][columna-1]="M";
		}
		return impacto;
		/*Unicamente contamos los impactos por cada acierto en las "B" y retornamos los impactos
		 * que se almacenaran nuevamente en impacto del Main
		 * esta forma era mas facil que un while o do while en el Main*/
	}
	//######################################################################
	public void JuegoTerminado(int impacto, int proyectiles, int barcos){
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
