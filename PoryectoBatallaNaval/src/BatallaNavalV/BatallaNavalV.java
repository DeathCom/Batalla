package BatallaNavalV;
import javax.swing.JOptionPane;

import BatallaNavalC.JuegoC;
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
	*/
	public static void main(String[] args) {
		jugando();
		//todo el juego es llamado a travez de jugando()
	}//fin Main
	public static void jugando(){
		JuegoV jugador1 = new JuegoV();
		JuegoV jugador2 = new JuegoV();
		
		String [][] tablero1 = new String [8][8];
		String [][] tablero2 = new String [8][8];
		
		jugador1.tablero(tablero1);
		jugador2.tablero(tablero2);
		String salir="";
		int barcoJ1_1, barcoJ1_2, barcoJ1_3, barcoJ2_1, barcoJ2_2, barcoJ2_3;
		do{
			salir = JOptionPane.showInputDialog(null, 
					"Digite \"I\" para iniciar o \"S\" para salir ");
			if(salir.equalsIgnoreCase("i")){
				JOptionPane.showMessageDialog(null, "Bienvenido al Juego de Batalla Naval de Carlos Pérez\n" +
						"Que se divierta");
				do{
					JOptionPane.showMessageDialog(null, "Seleccione el tamaño de las \"3\" naves del Jugador 1");
					barcoJ1_1 = Integer.parseInt(JOptionPane.showInputDialog("Digite la longitud del barco1 (1-4):"));
					barcoJ1_2 = Integer.parseInt(JOptionPane.showInputDialog("Digite la longitud del barco2 (1-4):"));
					barcoJ1_3 = Integer.parseInt(JOptionPane.showInputDialog("Digite la longitud del barco3 (1-4):"));
					JOptionPane.showMessageDialog(null, "Seleccione el tamaño de las \"3\" naves del Jugador 2");
					barcoJ2_1 = Integer.parseInt(JOptionPane.showInputDialog("Digite la longitud del barco1 (1-4):"));
					barcoJ2_2 = Integer.parseInt(JOptionPane.showInputDialog("Digite la longitud del barco2 (1-4):"));
					barcoJ2_3 = Integer.parseInt(JOptionPane.showInputDialog("Digite la longitud del barco3 (1-4):"));
					
					if(barcoJ1_1<=0|| barcoJ1_1>=5 || barcoJ1_2<=0 || barcoJ1_2>=5 || barcoJ1_3<=0 || barcoJ1_3>=5 
							|| barcoJ1_1<=0|| barcoJ1_1>=5 || barcoJ1_2<=0 || barcoJ1_2>=5 || barcoJ1_3<=0 || barcoJ1_3>=5){
						System.out.println();
						JOptionPane.showMessageDialog(null, "UPS!\nDigito algun dato no solicitado.");
					}
				}while((barcoJ1_1<=0 || barcoJ1_1>5) || (barcoJ1_2<=0 || barcoJ1_2>5) || (barcoJ1_3<=0 || barcoJ1_3>5) 
						|| (barcoJ2_1<=0 || barcoJ2_1>5) || (barcoJ2_2<=0 || barcoJ2_2>5) || (barcoJ2_3<=0 || barcoJ2_3>5));
				
				int barcosJ1 = (barcoJ1_1+barcoJ1_2+barcoJ1_3), barcosJ2 = (barcoJ2_1+barcoJ2_2+barcoJ2_3);
				
				jugador1.BarcoCreacion(tablero1, barcoJ1_1, barcoJ1_2, barcoJ1_3);
				jugador2.BarcoCreacion(tablero2, barcoJ2_1, barcoJ2_2, barcoJ2_3);
				
				int proyectilesJ1=(barcosJ1+1), impacto1=0; 
				int proyectilesJ2=(barcosJ2+1), impacto2=0; 
				
				while(proyectilesJ1>0 && impacto1<barcosJ1 && proyectilesJ2>0 && impacto2<barcosJ2){
					
					JOptionPane.showMessageDialog(null, "Jugador \"1\" atacando area del jugador \"2\"");
					jugador2.mostrarTablero(tablero2);
					impacto2 = jugador2.disparo(tablero2, impacto2, proyectilesJ2);
					proyectilesJ2--;
					
					JOptionPane.showMessageDialog(null, "Jugador \"2\" atacando area del jugador \"1\"");
					jugador1.mostrarTablero(tablero1); 
					impacto1 = jugador1.disparo(tablero1, impacto1, proyectilesJ1);			
					proyectilesJ1--; 
					
				}
				JOptionPane.showMessageDialog(null, "Jugador \"1\"");
				jugador2.JuegoTerminado(impacto2, proyectilesJ2, barcosJ2);
				JOptionPane.showMessageDialog(null, "Jugador \"2\"");
				jugador1.JuegoTerminado(impacto1, proyectilesJ1, barcosJ1);
			}else if(salir.equalsIgnoreCase("s")){
				JOptionPane.showMessageDialog(null, "Chao....");
			}else{
				JOptionPane.showMessageDialog(null, "Digito algo que NO es: \nni \"I\" ni \"S\"");
			}
		}while(!salir.equalsIgnoreCase("s"));
	}
	
}//Fin de public class BatallaNaval