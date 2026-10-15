/**
 * Representa una propuesta comercial dentro del sistema de documentos.
 *
 * Contiene la información propia de una propuesta y permite crear una copia
 * mediante el patrón de diseño Prototype. La copia recibe los mismos datos
 * que el documento original, pero es un objeto independiente.
 *
 * @version 1.0
 * @see Documento
 */
public class PropuestaComercial extends Documento {

    /** Número que identifica la propuesta comercial. */
    private String numero;

    /** Nombre del cliente al que se dirige la propuesta. */
    private String cliente;

    /** Descripción del servicio ofrecido. */
    private String descripcion;

    /** Valor económico de la propuesta. */
    private double valor;

    /** Vigencia de la propuesta expresada en días. */
    private int vigenciaDias;

    /**
     * Crea una propuesta comercial con todos sus datos.
     *
     * @param nombre nombre descriptivo del documento o de la plantilla
     * @param numero número que identifica la propuesta
     * @param cliente nombre del cliente destinatario
     * @param descripcion descripción del servicio ofrecido
     * @param valor valor económico de la propuesta
     * @param vigenciaDias cantidad de días durante los que la propuesta es válida
     */
    public PropuestaComercial(String nombre, String numero, String cliente,
                              String descripcion, double valor, int vigenciaDias) {
        super(nombre);
        this.numero = numero;
        this.cliente = cliente;
        this.descripcion = descripcion;
        this.valor = valor;
        this.vigenciaDias = vigenciaDias;
    }

    /**
     * Constructor de copia. Crea una propuesta nueva a partir de otra propuesta.
     *
     * @param original propuesta cuyos datos se copiarán
     */
    private PropuestaComercial(PropuestaComercial original) {
        super(original.getNombre());
        this.numero = original.numero;
        this.cliente = original.cliente;
        this.descripcion = original.descripcion;
        this.valor = original.valor;
        this.vigenciaDias = original.vigenciaDias;
    }

    /**
     * Devuelve una copia independiente de esta propuesta comercial.
     *
     * @return nueva propuesta con los mismos datos que la propuesta original
     */
    @Override
    public PropuestaComercial clonar() {
        return new PropuestaComercial(this);
    }

    /**
     * Muestra en consola los datos de la propuesta comercial.
     */
    @Override
    public void mostrar() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Número: " + numero);
        System.out.println("Cliente: " + cliente);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Valor: " + valor);
        System.out.println("Vigencia: " + vigenciaDias + " días");
    }

    /**
     * Devuelve el número de la propuesta.
     *
     * @return número de la propuesta
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Cambia el número de la propuesta.
     *
     * @param numero nuevo número de la propuesta
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Devuelve el cliente destinatario.
     *
     * @return nombre del cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * Cambia el cliente destinatario.
     *
     * @param cliente nuevo nombre del cliente
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * Devuelve la descripción del servicio.
     *
     * @return descripción del servicio ofrecido
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Cambia la descripción del servicio.
     *
     * @param descripcion nueva descripción del servicio
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve el valor económico de la propuesta.
     *
     * @return valor de la propuesta
     */
    public double getValor() {
        return valor;
    }

    /**
     * Cambia el valor económico de la propuesta.
     *
     * @param valor nuevo valor de la propuesta
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * Devuelve la cantidad de días de vigencia.
     *
     * @return vigencia en días
     */
    public int getVigenciaDias() {
        return vigenciaDias;
    }

    /**
     * Cambia la cantidad de días de vigencia.
     *
     * @param vigenciaDias nueva vigencia en días
     */
    public void setVigenciaDias(int vigenciaDias) {
        this.vigenciaDias = vigenciaDias;
    }
}
