/**
 * Clase abstracta que representa la estructura general de un documento.
 *
 * Sirve como clase base para los diferentes tipos de documentos del sistema.
 * Define los métodos comunes para clonar y mostrar cada documento.
 *
 * Esta clase forma parte de la implementación del patrón de diseño Prototype.
 * Cada subclase debe indicar cómo crear una copia de sí misma.
 *
 * @version 1.0
 */
public abstract class Documento {

    /** Nombre que permite identificar el documento o la plantilla. */
    private String nombre;

    /**
     * Crea un documento con el nombre indicado.
     *
     * @param nombre nombre del documento o de la plantilla
     */
    public Documento(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el nombre del documento.
     *
     * @return nombre del documento
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el nombre del documento.
     *
     * @param nombre nuevo nombre del documento
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Crea y devuelve una copia independiente de este documento.
     *
     * Cada clase concreta debe implementar este método y copiar sus propios
     * atributos. La copia no debe modificar el documento original cuando
     * posteriormente se cambien sus datos.
     *
     * @return una nueva instancia con los datos copiados del documento actual
     */
    public abstract Documento clonar();

    /**
     * Muestra en consola la información del documento.
     * Cada clase concreta decide qué atributos específicos debe mostrar.
     */
    public abstract void mostrar();
}
