import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Tienda {
    private List<Producto> productos;
    private Scanner scanner;

    public Tienda() {
        productos = new ArrayList<>();
        scanner = new Scanner(System.in);

    }


    public void agregarProducto() {
        System.out.println("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el descripcion del producto: ");
        String descripcion = scanner.nextLine();
        System.out.println("Ingrese el precio del producto: ");
        double precio = scanner.nextInt();
        System.out.println("Ingrese el cantidad del producto: ");
        int cantidad = scanner.nextInt();
        System.out.println("Ingrese el categoria del producto: ");
        String categoria = scanner.nextLine();
        scanner.nextLine();

        productos.add(new Producto(nombre, descripcion, precio, cantidad, categoria));
        System.out.println("El producto ha sido agregado");


    }

    public void modificarProducto(int indice) {
        if (indice >= 0 && indice < productos.size()) {
            Producto producto = productos.get(indice);
            System.out.println("Modificando producto: " + producto.getNombre());

            System.out.print("Nuevo nombre (dejar en blanco para no cambiar): ");
            String nuevoNombre = scanner.nextLine();
            if (!nuevoNombre.isEmpty()) {
                producto.setNombre(nuevoNombre);
            }

            System.out.print("Nuevo precio (dejar en blanco para no cambiar): ");
            String nuevoPrecioStr = scanner.nextLine();
            if (!nuevoPrecioStr.isEmpty()) {
                try {
                    double nuevoPrecio = Double.parseDouble(nuevoPrecioStr);
                    producto.setPrecio(nuevoPrecio);
                } catch (NumberFormatException e) {
                    System.out.println("Precio no válido. No se ha cambiado.");
                }
            }

            System.out.print("Nueva categoría (dejar en blanco para no cambiar): ");
            String nuevaCategoria = scanner.nextLine();
            if (!nuevaCategoria.isEmpty()) {
                producto.setCategoria(nuevaCategoria);
            }

            System.out.print("Nuevo stock (dejar en blanco para no cambiar): ");
            String nuevoStockStr = scanner.nextLine();
            if (!nuevoStockStr.isEmpty()) {
                try {
                    int nuevaCantidad = Integer.parseInt(nuevoStockStr);
                    producto.setCantidad(nuevaCantidad);
                } catch (NumberFormatException e) {
                    System.out.println("Stock no válido. No se ha cambiado.");
                }
            }

            System.out.println("Producto modificado: " + producto);
        } else {
            System.out.println("Índice inválido.");
        }

    }

    public void eliminarProducto(int indice){
        if(indice >= 0 && indice < productos.size()) {
            Producto eliminado = productos.remove(indice);
            System.out.println("El producto ha sido eliminado");
        }else {
            System.out.println("El producto no existe");
        }

    }

    public void mostrarProductos() {
        System.out.println("Productos disponibles: ");
        for (int i = 0; i < this.productos.size(); i++) {
            System.out.println((i + 1) + ". " + productos.get(i));
        }

    }

    public void buscarProducto(String criterio) {
        boolean encontrado = false;
        System.out.println("Resultados de la búsqueda para: " + criterio);
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(criterio) || producto.getCategoria().equalsIgnoreCase(criterio)) {
                System.out.println(producto);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron productos que coincidan con el criterio de búsqueda.");
        }
    }
    public void realizarCompra(int indice, int cantidad){
        if(indice>=0 && indice<this.productos.size()) {
            Producto producto = productos.get(indice);
            if (producto.getCantidad() >= cantidad) {
                producto.setCantidad(producto.getCantidad() - cantidad);
                System.out.println("Resumen de compra: " + cantidad + " unidades de " + producto.getNombre());
            } else {
                System.out.println("Stock insuficiente");
            }
        }else {
            System.out.println("No se encontro el producto");
        }
            }
        }

