package tareasjava;

import java.io.*;
//creo el fichero de texto en el que aparecerán las tareas//
public class TareasJava {
	public static void main(String[] args) {
		FileWriter tareas = null;
		PrintWriter pw = null;
		try
		{
			tareas = new FileWriter("c:/prueba.txt");
			pw = new PrintWriter(tareas);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				 if (null != tareas)
		              tareas.close();
		           } catch (Exception e2) {
		              e2.printStackTrace();
			}
		}
	
	}
}
