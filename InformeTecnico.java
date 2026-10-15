/**
 * Representa un informe técnico dentro del sistema de documentos.
 *
 * Contiene la información propia de un informe y permite crear una copia
 * mediante el patrón de diseño Prototype. La copia puede modificarse sin
 * cambiar los datos del informe original.
 *
 * @version 1.0
 * @see Documento
 */
public class InformeTecnico extends Documento {

    /** Título que identifica el informe técnico. */
    private String titulo;

    /** Nombre de la persona responsable del informe. */
    private String responsable;

    /** Área o departamento al que pertenece el informe. */
    private String areaTrabajo;

    /** Fecha de elaboración del informe. */
    private String fecha;

    /** Conclusiones principales del informe técnico. */
    private String conclusiones;

    /**
     * Crea un informe técnico con todos sus datos.
     *
     * @param nombre nombre descriptivo del documento o de la plantilla
     * @param titulo título del informe
     * @param responsable persona responsable del informe
     * @param areaTrabajo área de trabajo correspondiente
     * @param fecha fecha de elaboración del informe
     * @param conclusiones conclusiones principales del informe
     */
    public InformeTecnico(String nombre, String titulo, String responsable,
                          String areaTrabajo, String fecha, String conclusiones) {
        super(nombre);
        this.titulo = titulo;
        this.responsable = responsable;
        this.areaTrabajo = areaTrabajo;
        this.fecha = fecha;
        this.conclusiones = conclusiones;
    }

    /**
     * Constructor de copia. Crea un informe nuevo a partir de otro informe.
     *
     * @param original informe cuyos datos se copiarán
     */
    private InformeTecnico(InformeTecnico original) {
        super(original.getNombre());
        this.titulo = original.titulo;
        this.responsable = original.responsable;
        this.areaTrabajo = original.areaTrabajo;
        this.fecha = original.fecha;
        this.conclusiones = original.conclusiones;
    }

    /**
     * Devuelve una copia independiente de este informe técnico.
     *
     * @return nuevo informe con los mismos datos que el original
     */
    @Override
    public InformeTecnico clonar() {
        return new InformeTecnico(this);
    }

    /**
     * Muestra en consola los datos del informe técnico.
     */
    @Override
    public void mostrar() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Título: " + titulo);
        System.out.println("Responsable: " + responsable);
        System.out.println("Área de trabajo: " + areaTrabajo);
        System.out.println("Fecha: " + fecha);
        System.out.println("Conclusiones: " + conclusiones);
    }

    /**
     * Devuelve el título del informe.
     *
     * @return título del informe técnico
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Cambia el título del informe.
     *
     * @param titulo nuevo título del informe
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Devuelve el nombre del responsable.
     *
     * @return responsable del informe
     */
    public String getResponsable() {
        return responsable;
    }

    /**
     * Cambia el responsable del informe.
     *
     * @param responsable nuevo responsable del informe
     */
    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    /**
     * Devuelve el área de trabajo.
     *
     * @return área de trabajo del informe
     */
    public String getAreaTrabajo() {
        return areaTrabajo;
    }

    /**
     * Cambia el área de trabajo.
     *
     * @param areaTrabajo nueva área de trabajo
     */
    public void setAreaTrabajo(String areaTrabajo) {
        this.areaTrabajo = areaTrabajo;
    }

    /**
     * Devuelve la fecha del informe.
     *
     * @return fecha de elaboración
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Cambia la fecha del informe.
     *
     * @param fecha nueva fecha de elaboración
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Devuelve las conclusiones del informe.
     *
     * @return conclusiones principales
     */
    public String getConclusiones() {
        return conclusiones;
    }

    /**
     * Cambia las conclusiones del informe.
     *
     * @param conclusiones nuevas conclusiones
     */
    public void setConclusiones(String conclusiones) {
        this.conclusiones = conclusiones;
    }
}
