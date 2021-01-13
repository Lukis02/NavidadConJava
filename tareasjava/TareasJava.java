package tareasjava;
import java.text.SimpleDateFormat;
import java.util.Date;



import java.util.*;
import java.io.*;

//creo el fichero de texto en el que aparecerán las tareas//
public class TareasJava {

	
	
	
	public static void main(String[] args) {
		int a=1;
		int start = 0;
		while (start == 0) {
			Scanner sc = new Scanner(System.in);
			System.out.println("¿desea crear una nueva tarea?");
			
			String respuesta = sc.nextLine();

			
				if (respuesta.equals("si")) {
					try {
						Date fecha = new Date();
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
						FileWriter tareas = new FileWriter(
								"src\\tareasjava\\pratica1.txt", true);
						PrintWriter pw = new PrintWriter(tareas);
						
						System.out.println("dime tu nueva tarea");
						String tarea = sc.nextLine();
						
						
				while (a==0) {
						
						
					
						System.out.println("¿desea completar la tarea?");
						String respuesta2 = sc.nextLine();
						
						if (respuesta2.equals("si")) {
							System.out.println("tarea completada");
							pw.println(tarea +"("+fecha+")"+"(completada)");
							
						}
						
						if (respuesta2.equals("no")) {
							System.out.println("tarea no completada");
							pw.println(tarea +"("+fecha+")"+"(no completada)");
							pw.close();
						}else{
							System.out.println("por favor, introduce un si o un no");
						}
				}
					}
							catch (Exception e) {
						e.printStackTrace();
					}

				}else {
				if (respuesta.equals("no")) {
					System.out.println("vale");
				} 
				sc.close();
				}
			
		}
	
}}
