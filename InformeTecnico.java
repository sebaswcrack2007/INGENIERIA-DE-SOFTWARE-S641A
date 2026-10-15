public class InformeTecnico extends Documento {

    private String titulo;
    private String responsable;
    private String areaTrabajo;
    private String fecha;
    private String conclusiones;

    public InformeTecnico(String nombre, String titulo, String responsable,
                          String areaTrabajo, String fecha, String conclusiones) {
        super(nombre);
        this.titulo = titulo;
        this.responsable = responsable;
        this.areaTrabajo = areaTrabajo;
        this.fecha = fecha;
        this.conclusiones = conclusiones;
    }

    /** Constructor de copia. */
    private InformeTecnico(InformeTecnico original) {
        super(original.getNombre());
        this.titulo = original.titulo;
        this.responsable = original.responsable;
        this.areaTrabajo = original.areaTrabajo;
        this.fecha = original.fecha;
        this.conclusiones = original.conclusiones;
    }

    @Override
    public InformeTecnico clonar() {
        return new InformeTecnico(this);
    }

    @Override
    public void mostrar() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Título: " + titulo);
        System.out.println("Responsable: " + responsable);
        System.out.println("Área de trabajo: " + areaTrabajo);
        System.out.println("Fecha: " + fecha);
        System.out.println("Conclusiones: " + conclusiones);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getAreaTrabajo() {
        return areaTrabajo;
    }

    public void setAreaTrabajo(String areaTrabajo) {
        this.areaTrabajo = areaTrabajo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getConclusiones() {
        return conclusiones;
    }

    public void setConclusiones(String conclusiones) {
        this.conclusiones = conclusiones;
    }
}