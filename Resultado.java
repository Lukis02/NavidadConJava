import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class Resultado  {
   private String local,visitante,resultado,arbrito;
   Date fecha;
   public Resultado(String Local, String visitante, String resultado, String arbrito, Date fecha){
       this.local=Local;
       this.visitante=visitante;
       this.resultado=resultado;
       this.arbrito=arbrito;
       this.fecha=fecha;
   }

    @Override
    public String toString() {
        return "Resultado{" +
                "local='" + local + '\'' +
                ", visitante='" + visitante + '\'' +
                ", resultado='" + resultado + '\'' +
                ", arbrito='" + arbrito + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
