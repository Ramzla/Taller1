import java.util.ArrayList;

public class Playlist {
    String nombre;
    ArrayList<Cancion> canciones;

    public Playlist(String nombre) {
        this.nombre = nombre;
        this.canciones = new ArrayList<>();
    }

    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
        System.out.println("Cancion agregada correctamente.");
    }

    public void mostrarCanciones() {
        if (canciones.isEmpty()) {
            System.out.println("La playlist esta vacia.");
        } else {
            System.out.println("\n--- Canciones en " + nombre + " ---");
            for (int i = 0; i < canciones.size(); i++) {
                System.out.print((i + 1) + ". ");
                canciones.get(i).mostrarInformacion();
            }
        }
    }

    public void eliminarCancion(int posicion) {
        int indice = posicion - 1;
        if (indice >= 0 && indice < canciones.size()) {
            Cancion eliminada = canciones.remove(indice);
            System.out.println("Se elimino la cancion: " + eliminada.titulo);
        } else {
            System.out.println("El numero seleccionado no es valido.");
        }
    }

    public int obtenerCantidad() {
        return canciones.size();
    }

    public void buscarCancion(String tituloBuscado) {
        boolean encontrada = false;

        for (int i = 0; i < canciones.size(); i++) {
            Cancion c = canciones.get(i);
            if (c.titulo.equalsIgnoreCase(tituloBuscado)) {
                System.out.println("¡Cancion encontrada!");
                c.mostrarInformacion();
                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            System.out.println("La cancion '" + tituloBuscado + "' no esta en la playlist.");
        }
    }
}