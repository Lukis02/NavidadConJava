import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Calendar;

public class resultado {
    private String descripcion ;


    boolean completado = false;

    public resultado(String descripcion, boolean completado){

        this.descripcion = descripcion;

        this.completado = false;

    }
    @Override
    public String toString(){
        return "tarea{" +
                "descripcion='" + descripcion + '\'' +
                '\''
                + "no completado";

    }
}
