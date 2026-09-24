import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("SISTEMA DE PLAYLIST");
        System.out.print("Ingrese el nombre de la playlist: ");
        String nombrePlaylist = scanner.nextLine();

        Playlist miPlaylist = new Playlist(nombrePlaylist);
        int opcion = 0;

        while (opcion != 6) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Agregar cancion");
            System.out.println("2. Mostrar canciones");
            System.out.println("3. Eliminar cancion");
            System.out.println("4. Mostrar cantidad de canciones");
            System.out.println("5. Buscar cancion");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Por favor, ingrese un numero valido.");
                scanner.nextLine();
                continue;
            }

            if (opcion == 1) {
                System.out.print("Ingrese el titulo: ");
                String titulo = scanner.nextLine();

                System.out.print("Ingrese el artista: ");
                String artista = scanner.nextLine();

                System.out.print("Ingrese la duracion en segundos: ");

                if (scanner.hasNextInt()) {
                    int duracion = scanner.nextInt();
                    scanner.nextLine();

                    Cancion nuevaCancion = new Cancion(titulo, artista, duracion);
                    miPlaylist.agregarCancion(nuevaCancion);
                } else {
                    System.out.println("Duracion invalida. Debe ingresar un numero entero.");
                    scanner.nextLine();
                }

            } else if (opcion == 2) {
                miPlaylist.mostrarCanciones();

            } else if (opcion == 3) {
                if (miPlaylist.obtenerCantidad() == 0) {
                    System.out.println("No hay canciones para eliminar.");
                } else {
                    miPlaylist.mostrarCanciones();
                    System.out.print("Ingrese el numero de la cancion que desea eliminar: ");

                    if (scanner.hasNextInt()) {
                        int numero = scanner.nextInt();
                        scanner.nextLine();
                        miPlaylist.eliminarCancion(numero);
                    } else {
                        System.out.println("Entrada invalida. Debe ingresar el numero de la cancion.");
                        scanner.nextLine();
                    }
                }

            } else if (opcion == 4) {
                System.out.println("Total de canciones en la playlist: " + miPlaylist.obtenerCantidad());

            } else if (opcion == 5) {
                System.out.print("Ingrese el titulo de la cancion a buscar: ");
                String tituloBuscar = scanner.nextLine();
                miPlaylist.buscarCancion(tituloBuscar);

            } else if (opcion == 6) {
                System.out.println("Saliendo del programa...");

            } else {
                System.out.println("Opcion no valida. Intente de nuevo.");
            }
        }

        System.out.println("\n--- RESUMEN DE LA PLAYLIST ---");
        System.out.println("Nombre: " + miPlaylist.nombre);
        System.out.println("Cantidad total de canciones: " + miPlaylist.obtenerCantidad());

        scanner.close();
    }
}