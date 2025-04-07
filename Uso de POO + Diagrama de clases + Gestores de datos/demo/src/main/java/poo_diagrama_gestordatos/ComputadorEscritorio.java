package poo_diagrama_gestordatos;

class ComputadorEscritorio extends DispositivoTecnologico {
    String tarjetaVideo, fuentePoder, chasis;
    Pantalla pantalla;

    public ComputadorEscritorio(String marca, String modelo, String procesador, int ram, int almacenamiento,
                                int anio, double precio, int stock, String tarjetaVideo, String fuentePoder,
                                String chasis, Pantalla pantalla) {
        super(marca, modelo, procesador, ram, almacenamiento, anio, precio, stock);
        this.tarjetaVideo = tarjetaVideo;
        this.fuentePoder = fuentePoder;
        this.chasis = chasis;
        this.pantalla = pantalla;
    }

    @Override
    public String obtenerEspecificaciones() {
        return "PC Escritorio - Marca: " + marca + ", Modelo: " + modelo + ", RAM: " + ram + "GB, Almacenamiento: " + almacenamiento +
               "GB, Procesador: " + procesador + ", Pantalla: " + pantalla.modelo + ", Precio: $" + precio + ", Stock: " + stock;
    }
}