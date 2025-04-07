package poo_diagrama_gestordatos;

import java.util.ArrayList;
import java.util.List;

class Tienda {
    String direccion;
    List<DispositivoTecnologico> catalogo;
    List<Cliente> clientes;

    public Tienda(String direccion) {
        this.direccion = direccion;
        this.catalogo = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void modificarDireccion(String nuevaDireccion) {
        this.direccion = nuevaDireccion;
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void agregarDispositivo(DispositivoTecnologico dispositivo) {
        catalogo.add(dispositivo);
    }

    public List<DispositivoTecnologico> buscar(String criterio, String valor) {
        List<DispositivoTecnologico> resultados = new ArrayList<>();
        for (DispositivoTecnologico d : catalogo) {
            if ((criterio.equals("marca") && d.marca.equalsIgnoreCase(valor)) ||
                (criterio.equals("modelo") && d.modelo.equalsIgnoreCase(valor)) ||
                (criterio.equals("tipo") && d.getClass().getSimpleName().equalsIgnoreCase(valor))) {
                resultados.add(d);
            }
        }
        return resultados;
    }

    public void realizarVenta(Cliente cliente, List<DispositivoTecnologico> dispositivos) {
        for (DispositivoTecnologico d : dispositivos) {
            d.stock -= 1;
        }
        Venta venta = new Venta(cliente, dispositivos);
        // Aquí se podría guardar la venta en un archivo
    }
}
