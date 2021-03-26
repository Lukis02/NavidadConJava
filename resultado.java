

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
