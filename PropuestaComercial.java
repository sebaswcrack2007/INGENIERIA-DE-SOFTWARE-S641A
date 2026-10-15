public class PropuestaComercial extends Documento {

    private String numero;
    private String cliente;
    private String descripcion;
    private double valor;
    private int vigenciaDias;

    public PropuestaComercial(String nombre, String numero, String cliente,
                              String descripcion, double valor, int vigenciaDias) {
        super(nombre);
        this.numero = numero;
        this.cliente = cliente;
        this.descripcion = descripcion;
        this.valor = valor;
        this.vigenciaDias = vigenciaDias;
    }

    /** Constructor de copia. */
    private PropuestaComercial(PropuestaComercial original) {
        super(original.getNombre());
        this.numero = original.numero;
        this.cliente = original.cliente;
        this.descripcion = original.descripcion;
        this.valor = original.valor;
        this.vigenciaDias = original.vigenciaDias;
    }

    @Override
    public PropuestaComercial clonar() {
        return new PropuestaComercial(this);
    }

    @Override
    public void mostrar() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Número: " + numero);
        System.out.println("Cliente: " + cliente);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Valor: " + valor);
        System.out.println("Vigencia: " + vigenciaDias + " días");
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getVigenciaDias() {
        return vigenciaDias;
    }

    public void setVigenciaDias(int vigenciaDias) {
        this.vigenciaDias = vigenciaDias;
    }
}