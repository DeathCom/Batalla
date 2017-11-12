package BatallaNavalV;

import javax.swing.JOptionPane;

public class JuegoV {
	public static void tablero(String [][] tablero){
		for(int i=0; i<tablero.length; i++){
			for(int j=0; j<tablero[0].length;j++){
				tablero[i][j] = "~";
			}
		}
	}
	
	public static void mostrarTablero(String [][] tablero){
		String capturaArray =" ";
		for(int i=0; i<tablero.length; i++){
				for(int j=0; j<tablero[0].length;j++){
					System.out.print(" "+tablero[i][j]);
					capturaArray = capturaArray+" "+tablero[i][j]+" ";
				};
				System.out.println(" ");
				capturaArray = capturaArray+"\n";
		}
		JOptionPane.showMessageDialog(null,"_________________________\n"
									+capturaArray
									+"_________________________\n");
	}
	
	public static void BarcoCreacion(String [][] tablero, int barco1, int barco2, int barco3){ 
		if(Math.random() < 0.5){ //barco1
			int columna = (int) (Math.random()*5);
			int fila = (int) (Math.random()*7);
			for(int i=0; i<barco1;i++){
				tablero[fila][columna+i]= "B";
			}
		}else{ 
			int columna = (int)(Math.random()*7);
			int fila = (int) (Math.random()*5);
			
            for(int i = 0; i<barco1; i++)
            {
            	tablero[fila+i][columna]= "B";
            }
		}
		if(Math.random() < 0.5){ //barco2
			int columna = (int) (Math.random()*5);
			int fila = (int) (Math.random()*7);
			
			for(int i=0; i<barco2;i++){
				tablero[fila][columna+i]= "B";
			}
		}else{ 
			int columna = (int)(Math.random()*7);
			int fila = (int) (Math.random()*5);
			
            for(int i = 0; i<barco2; i++)
            {
            	tablero[fila+i][columna]= "B";
            }
		}
		if(Math.random() < 0.5){ //barco3
			int columna = (int) (Math.random()*5);
			int fila = (int) (Math.random()*7);
					
			for(int i=0; i<barco3;i++){
				tablero[fila][columna+i]= "B";
			}
		}else{ 
			int columna = (int)(Math.random()*7);
			int fila = (int) (Math.random()*5);
			
		    for(int i = 0; i<barco3; i++)
		    {
		    	tablero[fila+i][columna]= "B";
		    }
		}
	}
	public static int disparo(String [][] tablero, int impacto, int proyectiles){
		int fila, columna;
		JOptionPane.showMessageDialog(null, "Tiene "+proyectiles+" proyectiles");
		fila = Integer.parseInt(JOptionPane.showInputDialog("Seleccione Fila deseada: "));
		while(fila>8 || fila<1){
			fila = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor de 1 a 8: "));
		}
		columna = Integer.parseInt(JOptionPane.showInputDialog("Seleccione Columna deseada: "));
		while(columna>8 || columna<1){
			columna = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor de 1 a 8: "));
		}
		if(tablero[fila-1][columna-1].equalsIgnoreCase("B")){
			impacto++;
			JOptionPane.showMessageDialog(null, "--Impact--");
			tablero[fila-1][columna-1]="X";
		}else{
			JOptionPane.showMessageDialog(null, "--Fallo--");
			tablero[fila-1][columna-1]="M";
		}
		return impacto;
	}
	public static void JuegoTerminado(int impacto, int proyectiles, int barcos){

		if(impacto<barcos){
			JOptionPane.showMessageDialog(null, "Lo siento no pudo destruir los barco");
		}
		if(proyectiles<1){
			JOptionPane.showMessageDialog(null, "Ya no tiene mas proyectiles");
		}else if(impacto>=barcos){
			JOptionPane.showMessageDialog(null, "Destruiste las naves con exito");
		}
		JOptionPane.showMessageDialog(null, "Fin del Juego.");
	}
}
