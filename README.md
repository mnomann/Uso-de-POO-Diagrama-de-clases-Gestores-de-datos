# Sistema de Gestión de Dispositivos Electrónicos

Este es un sistema de gestión de una tienda de componentes tecnológicos que permite a los clientes comprar diferentes dispositivos como computadores de escritorio, notebooks y tablets. El sistema está implementado en Java utilizando principios de Programación Orientada a Objetos (POO) y tiene una estructura básica para gestionar clientes, productos y ventas.

# Requisitos

- Java 8 o superior.
- Dependencia de `Gson` para manejo de JSON. Puedes incluirla en tu proyecto mediante Maven o descargando el `.jar` directamente.

# Características

- **Clientes**: Los clientes pueden registrarse en el sistema con su información personal.
- **Dispositivos Tecnológicos**: La tienda tiene un catálogo de dispositivos, que incluye computadores de escritorio, notebooks y tablets. Cada dispositivo tiene características específicas.
- **Ventas**: El sistema permite realizar ventas de dispositivos, actualizando el stock de los productos después de cada compra.
- **Búsqueda de Productos**: Los clientes pueden buscar dispositivos tecnológicos por marca, modelo o tipo (tablet, notebook, escritorio).
- **Persistencia de Datos**: Todos los datos se almacenan en archivos JSON (`clientes.json`, `escritorio.json`, `notebooks.json`, `tablets.json`).

## Estructura del Proyecto

### Clases

1. **Cliente**: Representa un cliente con atributos como nombre, apellido, correo, número de contacto, estado civil y ciudad.
2. **Tienda**: Representa la tienda y contiene métodos para gestionar clientes, dispositivos, ventas y la dirección de la tienda.
3. **DispositivoTecnologico**: Clase abstracta que representa un dispositivo tecnológico. Tiene subclases:
    - **ComputadorEscritorio**
    - **Notebook**
    - **Tablet**
4. **Venta**: Representa una venta realizada a un cliente. Contiene la lista de dispositivos vendidos y la fecha de la venta.
5. **JsonUtil**: Clase de utilidad para cargar y guardar listas de objetos desde y hacia archivos JSON.

### Archivos JSON

- `clientes.json`: Contiene la lista de clientes registrados en la tienda.
- `escritorio.json`: Contiene los dispositivos de tipo computador de escritorio.
- `notebooks.json`: Contiene los dispositivos de tipo notebook.
- `tablets.json`: Contiene los dispositivos de tipo tablet.

## Funcionalidades del Sistema

1. **Agregar Cliente**: Permite agregar nuevos clientes con sus datos personales.
2. **Buscar Dispositivo**: Permite buscar dispositivos por marca, modelo o tipo.
3. **Realizar Venta**: Permite realizar una venta a un cliente específico y actualizar el stock de los dispositivos.
4. **Modificar Dirección de la Tienda**: Permite cambiar la dirección de la tienda.

## Cómo Ejecutar el Proyecto

3. **Ejecutar el archivo principal**:

    Puedes ejecutar el proyecto ejecutando la clase `Main`:

## Ejemplo de Uso

Al ejecutar el sistema, se presenta un menú interactivo en consola donde el usuario puede seleccionar diversas opciones:

