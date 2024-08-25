import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Tienda tienda = new Tienda();
        Scanner sc = new Scanner(System.in);
        int opc;


        do {
            System.out.println("1. Agregar Producto");
            System.out.println("2. Modificar Producto");
            System.out.println("3. Eliminar Producto");
            System.out.println("4. Ver Productos");
            System.out.println("5. Buscar Producto");
            System.out.println("6. Realizar Compra");
            System.out.println("7. Salir");

            System.out.print("Ingrese opcion: ");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    tienda.agregarProducto();
                    break;
                case 2:
                    tienda.mostrarProductos();
                    System.out.print("Ingrese el numero del producto a modificar: ");
                    int indiceModificar = sc.nextInt() - 1;
                    sc.nextLine();
                    tienda.modificarProducto(indiceModificar);
                    break;
                case 3: //eliminar
                    tienda.mostrarProductos();
                    System.out.print("Ingrese el numero del producto a eliminar: ");
                    int indiceEliminar = sc.nextInt() - 1;
                    tienda.eliminarProducto(indiceEliminar);
                    break;

                case 4:
                    tienda.mostrarProductos();
                    break;

                case 5:
                    System.out.println("Ingrese nombre del producto a buscar: ");
                    String criterio = sc.next();
                    tienda.buscarProducto(criterio);
                    break;
                case 6:
                    tienda.mostrarProductos();
                    System.out.print("Ingrese el nombre del producto a comprar: ");
                    int indiceCompra = sc.nextInt() - 1;
                    System.out.print("Ingrese la cantidad a comprar: ");
                    int cantidadCompra = sc.nextInt() - 1;

                    tienda.realizarCompra(indiceCompra, cantidadCompra);
                    break;
                case 7:
                    System.out.println("Ha salido de la Tienda ");
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }

            while(opc !=7);
            sc.close();

        }


    }