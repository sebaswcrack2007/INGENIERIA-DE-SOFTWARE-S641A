
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaDocumentos {

    private static final Scanner ENTRADA = new Scanner(System.in);

    private static final ArrayList<Documento> plantillas = new ArrayList<>();
    private static final ArrayList<Documento> documentosGenerados = new ArrayList<>();

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

        ENTRADA.close();
    }

    /** Registra una plantilla inicial de cada tipo. */
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

    private static void mostrarMenu() {
        System.out.println("\n===== SISTEMA DE DOCUMENTOS =====");
        System.out.println("1. Crear una plantilla");
        System.out.println("2. Ver plantillas disponibles");
        System.out.println("3. Clonar una plantilla");
        System.out.println("4. Ver documentos generados");
        System.out.println("5. Modificar un documento generado");
        System.out.println("6. Salir");
    }

    /** Crea una plantilla del tipo seleccionado. */
    private static void crearPlantilla() {
        System.out.println("\n--- Crear plantilla ---");
        System.out.println("1. Propuesta comercial");
        System.out.println("2. Informe técnico");
        System.out.println("3. Contrato de prestación de servicios");

        int tipo = leerEntero("Seleccione el tipo de documento: ");

        if (tipo < 1 || tipo > 3) {
            System.out.println("Tipo de documento no válido.");
            return;
        }

        String nombre = leerTextoObligatorio("Nombre de la plantilla: ");
        Documento nuevaPlantilla;

        switch (tipo) {
            case 1:
                String numeroPropuesta =
                        leerTextoObligatorio("Número de propuesta: ");
                String cliente = leerTextoObligatorio("Cliente: ");
                String descripcion =
                        leerTextoObligatorio("Descripción del servicio: ");
                double valorPropuesta =
                        leerDouble("Valor de la propuesta: ");
                int vigencia = leerEntero("Vigencia en días: ");

                nuevaPlantilla = new PropuestaComercial(
                        nombre, numeroPropuesta, cliente, descripcion,
                        valorPropuesta, vigencia);
                break;

            case 2:
                String titulo = leerTextoObligatorio("Título del informe: ");
                String responsable =
                        leerTextoObligatorio("Responsable: ");
                String area = leerTextoObligatorio("Área de trabajo: ");
                String fecha = leerTextoObligatorio("Fecha: ");
                String conclusiones =
                        leerTextoObligatorio("Conclusiones: ");

                nuevaPlantilla = new InformeTecnico(
                        nombre, titulo, responsable, area, fecha, conclusiones);
                break;

            case 3:
                String numeroContrato =
                        leerTextoObligatorio("Número de contrato: ");
                String contratista =
                        leerTextoObligatorio("Contratista: ");
                String entidad =
                        leerTextoObligatorio("Entidad contratante: ");
                double valorContrato = leerDouble("Valor del contrato: ");
                int duracion = leerEntero("Duración en meses: ");

                nuevaPlantilla = new ContratoServicios(
                        nombre, numeroContrato, contratista, entidad,
                        valorContrato, duracion);
                break;

            default:
                return;
        }

        plantillas.add(nuevaPlantilla);
        System.out.println("Plantilla registrada correctamente.");
    }

    /** Muestra todas las plantillas registradas. */
    private static void listarPlantillas() {
        System.out.println("\n--- Plantillas disponibles ---");

        if (plantillas.isEmpty()) {
            System.out.println("No hay plantillas registradas.");
            return;
        }

        for (int i = 0; i < plantillas.size(); i++) {
            Documento documento = plantillas.get(i);

            System.out.println("\nPlantilla " + (i + 1)
                    + " (" + documento.getClass().getSimpleName() + ")");
            documento.mostrar();
        }
    }

    /** Clona una plantilla y guarda la copia por separado. */
    private static void clonarPlantilla() {
        System.out.println("\n--- Clonar plantilla ---");

        if (plantillas.isEmpty()) {
            System.out.println("No hay plantillas para clonar.");
            return;
        }

        listarPlantillas();

        int indice = leerEntero(
                "Ingrese el número de la plantilla que desea clonar: ") - 1;

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

    /** Muestra los documentos generados. */
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

    /** Permite modificar una copia sin alterar la plantilla original. */
    private static void modificarDocumento() {
        System.out.println("\n--- Modificar documento ---");

        if (documentosGenerados.isEmpty()) {
            System.out.println("No hay documentos generados para modificar.");
            return;
        }

        listarDocumentosGenerados();

        int indice = leerEntero(
                "Ingrese el número del documento que desea modificar: ") - 1;

        if (indice < 0 || indice >= documentosGenerados.size()) {
            System.out.println("Número de documento no válido.");
            return;
        }

        Documento documento = documentosGenerados.get(indice);
        int opcion;

        do {
            System.out.println("\nDocumento seleccionado: "
                    + documento.getNombre());
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
                String nuevoNombre =
                        leerTextoObligatorio("Nuevo nombre: ");
                documento.setNombre(nuevoNombre);
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

    private static void modificarPropuesta(
            PropuestaComercial propuesta, int opcion) {

        switch (opcion) {
            case 2:
                propuesta.setNumero(
                        leerTextoObligatorio("Nuevo número de propuesta: "));
                break;
            case 3:
                propuesta.setCliente(
                        leerTextoObligatorio("Nuevo cliente: "));
                break;
            case 4:
                propuesta.setDescripcion(
                        leerTextoObligatorio("Nueva descripción: "));
                break;
            case 5:
                propuesta.setValor(leerDouble("Nuevo valor: "));
                break;
            case 6:
                propuesta.setVigenciaDias(
                        leerEntero("Nueva vigencia en días: "));
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void modificarInforme(
            InformeTecnico informe, int opcion) {

        switch (opcion) {
            case 2:
                informe.setTitulo(
                        leerTextoObligatorio("Nuevo título: "));
                break;
            case 3:
                informe.setResponsable(
                        leerTextoObligatorio("Nuevo responsable: "));
                break;
            case 4:
                informe.setAreaTrabajo(
                        leerTextoObligatorio("Nueva área de trabajo: "));
                break;
            case 5:
                informe.setFecha(
                        leerTextoObligatorio("Nueva fecha: "));
                break;
            case 6:
                informe.setConclusiones(
                        leerTextoObligatorio("Nuevas conclusiones: "));
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void modificarContrato(
            ContratoServicios contrato, int opcion) {

        switch (opcion) {
            case 2:
                contrato.setNumeroContrato(
                        leerTextoObligatorio("Nuevo número de contrato: "));
                break;
            case 3:
                contrato.setContratista(
                        leerTextoObligatorio("Nuevo contratista: "));
                break;
            case 4:
                contrato.setEntidadContratante(
                        leerTextoObligatorio("Nueva entidad contratante: "));
                break;
            case 5:
                contrato.setValor(leerDouble("Nuevo valor: "));
                break;
            case 6:
                contrato.setDuracionMeses(
                        leerEntero("Nueva duración en meses: "));
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    /** Lee texto y no permite que quede vacío. */
    private static String leerTextoObligatorio(String mensaje) {
        while (true) {
            String texto = leerTexto(mensaje);

            if (!texto.isEmpty()) {
                return texto;
            }

            System.out.println("Este campo no puede quedar vacío.");
        }
    }

    /** Lee una línea de texto. */
    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return ENTRADA.nextLine().trim();
    }

    /** Lee un entero y repite la pregunta si el dato no es válido. */
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

    /** Lee un número decimal y acepta punto o coma decimal. */
    private static double leerDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = ENTRADA.nextLine().trim().replace(',', '.');

            try {
                double valor = Double.parseDouble(entrada);

                if (Double.isFinite(valor)) {
                    return valor;
                }

                System.out.println("Ingrese un número finito válido.");
            } catch (NumberFormatException e) {
                System.out.println(
                        "Ingrese un número válido. Puede usar punto o coma decimal.");
            }
        }
    }
}
