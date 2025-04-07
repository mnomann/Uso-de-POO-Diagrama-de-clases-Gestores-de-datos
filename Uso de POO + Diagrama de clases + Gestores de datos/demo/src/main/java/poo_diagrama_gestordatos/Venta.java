package poo_diagrama_gestordatos;

import java.time.LocalDate;
import java.util.List;

class Venta {
    Cliente cliente;
    List<DispositivoTecnologico> dispositivos;
    LocalDate fecha;

    public Venta(Cliente cliente, List<DispositivoTecnologico> dispositivos) {
        this.cliente = cliente;
        this.dispositivos = dispositivos;
        this.fecha = LocalDate.now();
    }
}