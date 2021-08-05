import java.io.Serializable;

public class Cliente implements Serializable
{
    private String cedula;
    private String nombre;
    private String apellidos;

    // Constructor
    public Cliente(){

    }

    public Cliente(String cedula, String nombre, String apellidos){
        this.cedula=cedula;
        this.nombre=nombre;
        this.apellidos=apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }


}
