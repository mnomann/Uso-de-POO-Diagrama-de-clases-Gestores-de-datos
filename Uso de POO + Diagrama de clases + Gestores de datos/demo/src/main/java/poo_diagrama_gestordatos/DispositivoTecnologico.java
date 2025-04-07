package poo_diagrama_gestordatos;

abstract class DispositivoTecnologico {
    String marca, modelo, procesador;
    int ram, almacenamiento, anioFabricacion, stock;
    double precio;

    public DispositivoTecnologico(String marca, String modelo, String procesador, int ram, int almacenamiento,
                                  int anioFabricacion, double precio, int stock) {
        this.marca = marca;
        this.modelo = modelo;
        this.procesador = procesador;
        this.ram = ram;
        this.almacenamiento = almacenamiento;
        this.anioFabricacion = anioFabricacion;
        this.precio = precio;
        this.stock = stock;
    }

    public abstract String obtenerEspecificaciones();
}