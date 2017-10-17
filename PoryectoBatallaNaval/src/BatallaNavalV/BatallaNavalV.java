package BatallaNavalV;
import javax.swing.JOptionPane;;
public class BatallaNavalV {
	/**
	* Juego de batalla naval por consola
	* Un solo jugador y un maximo de 3 botes.
	*/
	public static final boolean pintar = true;
	public static void main(String[] args) {
		String [][] tablero = new String [8][8];
		tablero(tablero);
		int barco1, barco2, barco3;
		
		do{
			barco1 = Integer.parseInt(JOptionPane.showInputDialog("Digite la longitud del barco1 (1-4):"));
			barco2 = Integer.parseInt(JOptionPane.showInputDialog("Digite la longitud del barco2 (1-4):"));
			barco3 = Integer.parseInt(JOptionPane.showInputDialog("Digite la longitud del barco3 (1-4):"));
			if(barco1<=0|| barco1>=5 || barco2<=0 || barco2>=5 || barco3<=0 || barco3>=5){
				System.out.println("UPS!\n" +
						"Digito algun dato no solicitado.");
			}
		}while((barco1<=0|| barco1>=5) || (barco2<=0 || barco2>=5) || (barco3<=0 || barco3>=5));
		int barcos = barco1+barco2+barco3;
		BarcoCreacion(tablero, barco1, barco2, barco3);
		int proyectiles=15, impacto=0;
		while(proyectiles>0 && impacto<barcos){
			mostrar_tablero(tablero);
			impacto = disparo(tablero, impacto, proyectiles);
			proyectiles--;
		}
		JuegoTerminado(impacto, proyectiles, barcos);
	}
	
	public static void tablero(String [][] tablero){
		for(int i=0; i<tablero.length; i++){
			for(int j=0; j<tablero[0].length;j++){
				tablero[i][j] = "~";
			}
		}
	}
	
	public static void mostrar_tablero(String [][] tablero){
		String capturaArray =" ";
		for(int i=0; i<tablero.length; i++){
			if(pintar){
				for(int j=0; j<tablero[0].length;j++){
					System.out.print(" "+tablero[i][j]);
					capturaArray = capturaArray+" "+tablero[i][j]+" ";
				};
				System.out.println(" ");
				capturaArray = capturaArray+"\n";
			}
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
}//Fin de public class BatallaNaval