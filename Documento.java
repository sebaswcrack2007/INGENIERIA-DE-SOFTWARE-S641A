
public abstract class Documento {

    /** Nombre que identifica el documento. */
    private String nombre;

    /** Crea un documento con su nombre. */
    public Documento(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** Crea una copia del documento actual. */
    public abstract Documento clonar();

    /** Muestra los datos del documento. */
    public abstract void mostrar();
}