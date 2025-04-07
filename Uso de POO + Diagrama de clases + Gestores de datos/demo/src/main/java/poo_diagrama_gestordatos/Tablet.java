package poo_diagrama_gestordatos;

import java.util.List;

class Tablet extends DispositivoTecnologico {
    String resolucionPantalla;
    List<String> accesorios;

    public Tablet(String marca, String modelo, String procesador, int ram, int almacenamiento,
                  int anio, double precio, int stock, String resolucionPantalla, List<String> accesorios) {
        super(marca, modelo, procesador, ram, almacenamiento, anio, precio, stock);
        this.resolucionPantalla = resolucionPantalla;
        this.accesorios = accesorios;
    }

    @Override
    public String obtenerEspecificaciones() {
        return "Tablet - Marca: " + marca + ", Modelo: " + modelo + ", RAM: " + ram + "GB, Accesorios: " + accesorios +
               ", Resolución: " + resolucionPantalla + ", Precio: $" + precio + ", Stock: " + stock;
    }
}
