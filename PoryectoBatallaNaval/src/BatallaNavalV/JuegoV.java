package BatallaNavalV;

import javax.swing.JOptionPane;

public class JuegoV {
	public void jugando(){
		JuegoV jugador1 = new JuegoV();
		JuegoV jugador2 = new JuegoV();
		
		String [][] tablero1 = new String [8][8];
		String [][] tablero2 = new String [8][8];

		String salir="";
		int barcoJ1_1, barcoJ1_2, barcoJ1_3, barcoJ2_1, barcoJ2_2, barcoJ2_3;
		do{
			jugador1.tablero(tablero1);
			jugador2.tablero(tablero2);
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
	public void tablero(String [][] tablero){
		for(int i=0; i<tablero.length; i++){
			for(int j=0; j<tablero[0].length;j++){
				tablero[i][j] = "~";
			}
		}
	}
	
	public void mostrarTablero(String [][] tablero){
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
	
	public void BarcoCreacion(String [][] tablero, int barco1, int barco2, int barco3){ 
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
	public int disparo(String [][] tablero, int impacto, int proyectiles){
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
	public void JuegoTerminado(int impacto, int proyectiles, int barcos){

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
