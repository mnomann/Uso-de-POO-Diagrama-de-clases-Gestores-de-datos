package poo_diagrama_gestordatos;

import java.util.*;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tienda tienda = new Tienda("Calle Falsa 123");

        // Cargar clientes
        Type tipoCliente = new TypeToken<List<Cliente>>() {}.getType();
        List<Cliente> clientes = JsonUtil.cargarLista("clientes.json", tipoCliente);
        tienda.clientes = clientes;

        // Cargar computadores de escritorio
        Type tipoEscritorio = new TypeToken<List<ComputadorEscritorio>>() {}.getType();
        List<ComputadorEscritorio> pcs = JsonUtil.cargarLista("escritorio.json", tipoEscritorio);

        // Cargar notebooks
        Type tipoNotebook = new TypeToken<List<Notebook>>() {}.getType();
        List<Notebook> notebooks = JsonUtil.cargarLista("notebooks.json", tipoNotebook);

        // Cargar tablets
        Type tipoTablet = new TypeToken<List<Tablet>>() {}.getType();
        List<Tablet> tablets = JsonUtil.cargarLista("tablets.json", tipoTablet);

        // Agregar al catálogo
        for (DispositivoTecnologico d : pcs) tienda.agregarDispositivo(d);
        for (DispositivoTecnologico d : notebooks) tienda.agregarDispositivo(d);
        for (DispositivoTecnologico d : tablets) tienda.agregarDispositivo(d);



        List<DispositivoTecnologico> catalogo = new ArrayList<>();
        catalogo.addAll(JsonUtil.cargarLista("escritorio.json", tipoEscritorio));
        catalogo.addAll(JsonUtil.cargarLista("notebooks.json", tipoNotebook));
        catalogo.addAll(JsonUtil.cargarLista("tablets.json", tipoTablet));

        tienda.clientes = clientes;
        tienda.catalogo = catalogo;

        int opcion;
        do {
            System.out.println("\n--- MENÚ TIENDA ---");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Buscar dispositivo");
            System.out.println("3. Realizar venta");
            System.out.println("4. Modificar dirección tienda");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre: "); String nombre = sc.nextLine();
                    System.out.print("Apellido: "); String apellido = sc.nextLine();
                    System.out.print("Correo: "); String correo = sc.nextLine();
                    System.out.print("Contacto: "); String contacto = sc.nextLine();
                    System.out.print("Estado Civil: "); String estado = sc.nextLine();
                    System.out.print("Ciudad: "); String ciudad = sc.nextLine();

                    Cliente nuevo = new Cliente(nombre, apellido, correo, contacto, estado, ciudad);
                    tienda.agregarCliente(nuevo);
                    JsonUtil.guardarLista("clientes.json", tienda.clientes);
                    System.out.println("Cliente registrado con éxito.");
                }

                case 2 -> {
                    System.out.println("\n ¿Cómo deseas buscar un dispositivo?");
                    System.out.println("1. Por Marca");
                    System.out.println("2. Por Modelo");
                    System.out.println("3. Por Tipo (escritorio, notebook, tablet)");
                    System.out.print("Elige una opción (1-3): ");
                    int opcionBusqueda = sc.nextInt();
                    sc.nextLine();

                    String criterio = "";
                    switch (opcionBusqueda) {
                        case 1 -> criterio = "marca";
                        case 2 -> criterio = "modelo";
                        case 3 -> criterio = "tipo";
                        default -> {
                            System.out.println(" Opción inválida.");
                            return;
                        }
                    }

                    System.out.print("Ingresa el valor a buscar: ");
                    String valor = sc.nextLine();

                    List<DispositivoTecnologico> resultados = tienda.buscar(criterio, valor);

                    System.out.println("\n Resultados de búsqueda:");
                    if (resultados.isEmpty()) {
                        System.out.println(" No se encontraron dispositivos que coincidan con tu búsqueda.");
                    } else {
                        for (DispositivoTecnologico d : resultados) {
                            System.out.println("-".repeat(40));
                            System.out.println(d.obtenerEspecificaciones());
                        }
                        System.out.println("-".repeat(40));
                        System.out.printf(" Total encontrados: %d\n", resultados.size());
                    }
                }

                case 3 -> {
                    System.out.print("Correo del cliente: ");
                    String correo = sc.nextLine();
                    Cliente cliente = tienda.clientes.stream()
                        .filter(c -> c.correo.equalsIgnoreCase(correo)).findFirst().orElse(null);

                    if (cliente == null) {
                        System.out.println("Cliente no encontrado.");
                        break;
                    }

                    List<DispositivoTecnologico> compra = new ArrayList<>();
                    String continuar;
                    do {
                        System.out.print("Modelo del dispositivo a comprar: ");
                        String modelo = sc.nextLine();
                        DispositivoTecnologico dispositivo = tienda.catalogo.stream()
                            .filter(d -> d.modelo.equalsIgnoreCase(modelo) && d.stock > 0).findFirst().orElse(null);

                        if (dispositivo != null) {
                            compra.add(dispositivo);
                        } else {
                            System.out.println("Dispositivo no disponible.");
                        }

                        System.out.print("¿Desea agregar otro dispositivo? (s/n): ");
                        continuar = sc.nextLine().toLowerCase();
                    } while (continuar.equals("s"));

                    tienda.realizarVenta(cliente, compra);
                    System.out.println("Venta realizada exitosamente.");
                }

                case 4 -> {
                    System.out.print("Nueva dirección de la tienda: ");
                    String nuevaDir = sc.nextLine();
                    tienda.modificarDireccion(nuevaDir);
                    System.out.println("Dirección actualizada.");
                }

                case 5 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 5);

        sc.close();
    }
}
