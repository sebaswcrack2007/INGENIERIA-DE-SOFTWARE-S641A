public class ContratoServicios extends Documento {

    /** Número que identifica el contrato. */
    private String numeroContrato;

    /** Nombre del contratista. */
    private String contratista;

    /** Nombre de la entidad que contrata el servicio. */
    private String entidadContratante;

    /** Valor económico del contrato. */
    private double valor;

    /** Duración del contrato expresada en meses. */
    private int duracionMeses;

    /**
     * Crea un contrato de prestación de servicios con sus datos.
     */
    public ContratoServicios(String nombre, String numeroContrato,
            String contratista, String entidadContratante,
            double valor, int duracionMeses) {
        super(nombre);
        this.numeroContrato = numeroContrato;
        this.contratista = contratista;
        this.entidadContratante = entidadContratante;
        this.valor = valor;
        this.duracionMeses = duracionMeses;
    }

    /**
     * Constructor de copia. Crea un contrato nuevo con los datos de otro.
     */
    private ContratoServicios(ContratoServicios original) {
        super(original.getNombre());
        this.numeroContrato = original.numeroContrato;
        this.contratista = original.contratista;
        this.entidadContratante = original.entidadContratante;
        this.valor = original.valor;
        this.duracionMeses = original.duracionMeses;
    }

    /**
     * Crea una copia independiente del contrato actual.
     */
    public ContratoServicios clonar() {
        return new ContratoServicios(this);
    }

    /** Muestra en consola los datos del contrato. */
    public void mostrar() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Número de contrato: " + numeroContrato);
        System.out.println("Contratista: " + contratista);
        System.out.println("Entidad contratante: " + entidadContratante);
        System.out.println("Valor: " + valor);
        System.out.println("Duración: " + duracionMeses + " meses");
    }

    public String getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(String numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public String getContratista() {
        return contratista;
    }

    public void setContratista(String contratista) {
        this.contratista = contratista;
    }

    public String getEntidadContratante() {
        return entidadContratante;
    }

    public void setEntidadContratante(String entidadContratante) {
        this.entidadContratante = entidadContratante;
    }

    public double getValor() {
        return valor;
    }

    /** @param valor nuevo valor económico del contrato */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /** @return duración del contrato en meses */
    public int getDuracionMeses() {
        return duracionMeses;
    }

    /** @param duracionMeses nueva duración del contrato en meses */
    public void setDuracionMeses(int duracionMeses) {
        this.duracionMeses = duracionMeses;
    }
}
