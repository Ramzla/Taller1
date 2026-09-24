public class Cancion {

    String titulo;
    String artista;
    int duracionSegundos;

    public Cancion(String titulo, String artista, int duracionSegundos) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracionSegundos = duracionSegundos;
    }

    public void mostrarInformacion() {
        System.out.println("Título: " + titulo + " | Artista: " + artista + " | Duración: " + duracionSegundos + " segundos");
    }
}