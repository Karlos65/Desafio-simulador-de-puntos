package simuladorPuntosPOO;

public class SimuladorPuntos {

	public static void main(String[] args) {
		Jugador jugador = new Jugador("Carlos");

        jugador.agregarMision(new Mision(50));
        jugador.agregarMision(new Mision(80));
        jugador.agregarMision(new Mision(60));
        jugador.agregarMision(new Mision(90));
        jugador.agregarMision(new Mision(70));

        jugador.mostrarResumen();
    }

}
