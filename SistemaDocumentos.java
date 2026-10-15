import java.util.ArrayList;
import java.util.Scanner;

/**
 * Aplicación de consola para administrar plantillas y documentos.
 *
 * Permite registrar plantillas, clonarlas mediante el patrón Prototype,
 * consultar los documentos y modificar los datos de cada copia.
 * Las plantillas originales y los documentos generados se guardan en listas
 * separadas para conservar el documento original.
 *
 * @version 1.0
 */
public class SistemaDocumentos {

    /** Lee las opciones y los datos ingresados por el usuario. */
    private static final Scanner ENTRADA = new Scanner(System.in);

    /** Plantillas disponibles para crear documentos nuevos. */
    private static final ArrayList<Documento> plantillas = new ArrayList<>();

    /** Copias creadas a partir de las plantillas. */
    private static final ArrayList<Documento> documentosGenerados = new ArrayList<>();

    /**
     * Inicia el programa, registra algunas plantillas de ejemplo y muestra
     * el menú principal hasta que el usuario elija salir.
     *
     * @param args argumentos de línea de comandos (no se utilizan)
     */
    public static void main(String[] args) {
        cargarPlantillasIniciales();

        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    crearPlantilla();
                    break;
                case 2:
                    listarPlantillas();
                    break;
                case 3:
                    clonarPlantilla();
                    break;
                case 4:
                    listarDocumentosGenerados();
                    break;
                case 5:
                    modificarDocumento();
                    break;
                case 6:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);
    }

    /** Registra tres plantillas iniciales para facilitar las primeras pruebas. */
    private static void cargarPlantillasIniciales() {
        plantillas.add(new PropuestaComercial(
                "Plantilla de propuesta comercial",
                "PROP-BASE",
                "Cliente de ejemplo",
                "Desarrollo de software",
                2500000,
                30
        ));

        plantillas.add(new InformeTecnico(
                "Plantilla de informe técnico",
                "Informe de evaluación",
                "Responsable de ejemplo",
                "Sistemas",
                "14/10/2026",
                "Conclusiones pendientes"
        ));

        plantillas.add(new ContratoServicios(
                "Plantilla de contrato de servicios",
                "CON-BASE",
                "Contratista de ejemplo",
                "Entidad de ejemplo",
                5000000,
                6
        ));
    }

    /** Muestra las operaciones disponibles. */
    private static void mostrarMenu() {
        System.out.println("\n===== SISTEMA DE DOCUMENTOS =====");
        System.out.println("1. Crear una plantilla");
        System.out.println("2. Ver plantillas disponibles");
        System.out.println("3. Clonar una plantilla");
        System.out.println("4. Ver documentos generados");
        System.out.println("5. Modificar un documento generado");
        System.out.println("6. Salir");
    }

    /** Solicita los datos de un tipo de documento y lo registra como plantilla. */
    private static void crearPlantilla() {
        System.out.println("\n--- Crear plantilla ---");
        System.out.println("1. Propuesta comercial");
        System.out.println("2. Informe técnico");
        System.out.println("3. Contrato de prestación de servicios");
        int tipo = leerEntero("Seleccione el tipo de documento: ");

        String nombre = leerTexto("Nombre de la plantilla: ");
        Documento nuevaPlantilla;

        switch (tipo) {
            case 1:
                String numeroPropuesta = leerTexto("Número de propuesta: ");
                String cliente = leerTexto("Cliente: ");
                String descripcion = leerTexto("Descripción del servicio: ");
                double valorPropuesta = leerDouble("Valor de la propuesta: ");
                int vigencia = leerEntero("Vigencia en días: ");

                nuevaPlantilla = new PropuestaComercial(
                        nombre, numeroPropuesta, cliente, descripcion,
                        valorPropuesta, vigencia);
                break;

            case 2:
                String titulo = leerTexto("Título del informe: ");
                String responsable = leerTexto("Responsable: ");
                String area = leerTexto("Área de trabajo: ");
                String fecha = leerTexto("Fecha: ");
                String conclusiones = leerTexto("Conclusiones: ");

                nuevaPlantilla = new InformeTecnico(
                        nombre, titulo, responsable, area, fecha, conclusiones);
                break;

            case 3:
                String numeroContrato = leerTexto("Número de contrato: ");
                String contratista = leerTexto("Contratista: ");
                String entidad = leerTexto("Entidad contratante: ");
                double valorContrato = leerDouble("Valor del contrato: ");
                int duracion = leerEntero("Duración en meses: ");

                nuevaPlantilla = new ContratoServicios(
                        nombre, numeroContrato, contratista, entidad,
                        valorContrato, duracion);
                break;

            default:
                System.out.println("Tipo de documento no válido. No se creó la plantilla.");
                return;
        }

        plantillas.add(nuevaPlantilla);
        System.out.println("Plantilla registrada correctamente.");
    }

    /** Muestra todas las plantillas registradas y sus datos. */
    private static void listarPlantillas() {
        System.out.println("\n--- Plantillas disponibles ---");
        if (plantillas.isEmpty()) {
            System.out.println("No hay plantillas registradas.");
            return;
        }

        for (int i = 0; i < plantillas.size(); i++) {
            System.out.println("\nPlantilla " + (i + 1)
                    + " (" + plantillas.get(i).getClass().getSimpleName() + ")");
            plantillas.get(i).mostrar();
        }
    }

    /**
     * Permite seleccionar una plantilla y crear una copia mediante Prototype.
     * La copia se almacena en una lista distinta a la de las plantillas.
     */
    private static void clonarPlantilla() {
        System.out.println("\n--- Clonar plantilla ---");
        if (plantillas.isEmpty()) {
            System.out.println("No hay plantillas para clonar.");
            return;
        }

        listarPlantillas();
        int indice = leerEntero("Ingrese el número de la plantilla que desea clonar: ") - 1;
        if (indice < 0 || indice >= plantillas.size()) {
            System.out.println("Número de plantilla no válido.");
            return;
        }

        Documento original = plantillas.get(indice);
        Documento copia = original.clonar();

        String nombreCopia = leerTexto(
                "Nombre para la copia (Enter para conservar el nombre original): ");
        if (!nombreCopia.isEmpty()) {
            copia.setNombre(nombreCopia);
        }

        documentosGenerados.add(copia);
        System.out.println("Documento clonado y guardado correctamente.");
        System.out.println("Datos de la copia:");
        copia.mostrar();
    }

    /** Muestra todos los documentos creados a partir de las plantillas. */
    private static void listarDocumentosGenerados() {
        System.out.println("\n--- Documentos generados ---");
        if (documentosGenerados.isEmpty()) {
            System.out.println("Todavía no se han generado documentos.");
            return;
        }

        for (int i = 0; i < documentosGenerados.size(); i++) {
            Documento documento = documentosGenerados.get(i);
            System.out.println("\nDocumento " + (i + 1)
                    + " (" + documento.getClass().getSimpleName() + ")");
            documento.mostrar();
        }
    }

    /** Permite seleccionar una copia y modificar su nombre o sus atributos propios. */
    private static void modificarDocumento() {
        System.out.println("\n--- Modificar documento ---");
        if (documentosGenerados.isEmpty()) {
            System.out.println("No hay documentos generados para modificar.");
            return;
        }

        listarDocumentosGenerados();
        int indice = leerEntero("Ingrese el número del documento que desea modificar: ") - 1;
        if (indice < 0 || indice >= documentosGenerados.size()) {
            System.out.println("Número de documento no válido.");
            return;
        }

        Documento documento = documentosGenerados.get(indice);
        int opcion;

        do {
            System.out.println("\nDocumento seleccionado: " + documento.getNombre());
            System.out.println("1. Cambiar nombre del documento");

            if (documento instanceof PropuestaComercial) {
                System.out.println("2. Cambiar número de propuesta");
                System.out.println("3. Cambiar cliente");
                System.out.println("4. Cambiar descripción del servicio");
                System.out.println("5. Cambiar valor");
                System.out.println("6. Cambiar vigencia en días");
            } else if (documento instanceof InformeTecnico) {
                System.out.println("2. Cambiar título");
                System.out.println("3. Cambiar responsable");
                System.out.println("4. Cambiar área de trabajo");
                System.out.println("5. Cambiar fecha");
                System.out.println("6. Cambiar conclusiones");
            } else if (documento instanceof ContratoServicios) {
                System.out.println("2. Cambiar número de contrato");
                System.out.println("3. Cambiar contratista");
                System.out.println("4. Cambiar entidad contratante");
                System.out.println("5. Cambiar valor");
                System.out.println("6. Cambiar duración en meses");
            }

            System.out.println("0. Terminar modificación");
            opcion = leerEntero("Seleccione qué desea modificar: ");

            if (opcion == 0) {
                break;
            }

            if (opcion == 1) {
                documento.setNombre(leerTexto("Nuevo nombre: "));
            } else if (documento instanceof PropuestaComercial) {
                modificarPropuesta((PropuestaComercial) documento, opcion);
            } else if (documento instanceof InformeTecnico) {
                modificarInforme((InformeTecnico) documento, opcion);
            } else if (documento instanceof ContratoServicios) {
                modificarContrato((ContratoServicios) documento, opcion);
            } else {
                System.out.println("Opción no válida.");
            }
        } while (true);

        System.out.println("Documento actualizado:");
        documento.mostrar();
    }

    /** Modifica el atributo seleccionado de una propuesta comercial. */
    private static void modificarPropuesta(PropuestaComercial propuesta, int opcion) {
        switch (opcion) {
            case 2:
                propuesta.setNumero(leerTexto("Nuevo número de propuesta: "));
                break;
            case 3:
                propuesta.setCliente(leerTexto("Nuevo cliente: "));
                break;
            case 4:
                propuesta.setDescripcion(leerTexto("Nueva descripción: "));
                break;
            case 5:
                propuesta.setValor(leerDouble("Nuevo valor: "));
                break;
            case 6:
                propuesta.setVigenciaDias(leerEntero("Nueva vigencia en días: "));
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    /** Modifica el atributo seleccionado de un informe técnico. */
    private static void modificarInforme(InformeTecnico informe, int opcion) {
        switch (opcion) {
            case 2:
                informe.setTitulo(leerTexto("Nuevo título: "));
                break;
            case 3:
                informe.setResponsable(leerTexto("Nuevo responsable: "));
                break;
            case 4:
                informe.setAreaTrabajo(leerTexto("Nueva área de trabajo: "));
                break;
            case 5:
                informe.setFecha(leerTexto("Nueva fecha: "));
                break;
            case 6:
                informe.setConclusiones(leerTexto("Nuevas conclusiones: "));
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    /** Modifica el atributo seleccionado de un contrato de servicios. */
    private static void modificarContrato(ContratoServicios contrato, int opcion) {
        switch (opcion) {
            case 2:
                contrato.setNumeroContrato(leerTexto("Nuevo número de contrato: "));
                break;
            case 3:
                contrato.setContratista(leerTexto("Nuevo contratista: "));
                break;
            case 4:
                contrato.setEntidadContratante(leerTexto("Nueva entidad contratante: "));
                break;
            case 5:
                contrato.setValor(leerDouble("Nuevo valor: "));
                break;
            case 6:
                contrato.setDuracionMeses(leerEntero("Nueva duración en meses: "));
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    /** Lee una línea de texto ingresada por el usuario. */
    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return ENTRADA.nextLine().trim();
    }

    /** Lee un número entero y vuelve a solicitarlo si la entrada no es válida. */
    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = ENTRADA.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número entero válido.");
            }
        }
    }

    /** Lee un número decimal y vuelve a solicitarlo si la entrada no es válida. */
    private static double leerDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = ENTRADA.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido. Puede usar punto o coma decimal.");
            }
        }
    }
}
