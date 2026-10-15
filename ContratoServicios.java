
public class ContratoServicios extends Documento {

    private String numeroContrato;
    private String contratista;
    private String entidadContratante;
    private double valor;
    private int duracionMeses;

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

    /** Constructor de copia. */
    private ContratoServicios(ContratoServicios original) {
        super(original.getNombre());
        this.numeroContrato = original.numeroContrato;
        this.contratista = original.contratista;
        this.entidadContratante = original.entidadContratante;
        this.valor = original.valor;
        this.duracionMeses = original.duracionMeses;
    }

    @Override
    public ContratoServicios clonar() {
        return new ContratoServicios(this);
    }

    @Override
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

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getDuracionMeses() {
        return duracionMeses;
    }

    public void setDuracionMeses(int duracionMeses) {
        this.duracionMeses = duracionMeses;
    }
}