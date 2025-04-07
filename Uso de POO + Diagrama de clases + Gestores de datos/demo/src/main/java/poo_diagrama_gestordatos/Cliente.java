package poo_diagrama_gestordatos;

public class Cliente {
    String nombre, apellido, correo, contacto, estadoCivil, ciudad;

    public Cliente(String nombre, String apellido, String correo, String contacto, String estadoCivil, String ciudad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contacto = contacto;
        this.estadoCivil = estadoCivil;
        this.ciudad = ciudad;
    }
}