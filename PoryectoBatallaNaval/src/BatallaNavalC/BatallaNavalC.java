package BatallaNavalC;
import java.util.Scanner;
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
	*/
	public static void main(String[] args) {
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
		
		jugador1.tablero(tablero1); 
		jugador2.tablero(tablero2); 
		/*Se llena el metodo tablero con el tablero correspondiente a cada jugador
		 * con un parametro de tipo matriz tambien llamado tablero*/
		String salir="";
		int barcoJ1_1, barcoJ1_2, barcoJ1_3, barcoJ2_1, barcoJ2_2, barcoJ2_3; 
		/*Estas variables son las que definen los tamaños de cada bote de cada uno
		 * de los jugadores*/
		do{
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
	
}//Fin de public class BatallaNaval