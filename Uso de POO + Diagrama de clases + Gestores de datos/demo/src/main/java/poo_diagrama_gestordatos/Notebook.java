package poo_diagrama_gestordatos;

class Notebook extends DispositivoTecnologico {
    String resolucionPantalla, tipoTeclado;
    int bateria;

    public Notebook(String marca, String modelo, String procesador, int ram, int almacenamiento,
                    int anio, double precio, int stock, String resolucionPantalla, String tipoTeclado, int bateria) {
        super(marca, modelo, procesador, ram, almacenamiento, anio, precio, stock);
        this.resolucionPantalla = resolucionPantalla;
        this.tipoTeclado = tipoTeclado;
        this.bateria = bateria;
    }

    @Override
    public String obtenerEspecificaciones() {
        return "Notebook - Marca: " + marca + ", Modelo: " + modelo + ", RAM: " + ram + "GB, Almacenamiento: " + almacenamiento +
               "GB, Resolución: " + resolucionPantalla + ", Batería: " + bateria + "mAh, Precio: $" + precio + ", Stock: " + stock;
    }
}