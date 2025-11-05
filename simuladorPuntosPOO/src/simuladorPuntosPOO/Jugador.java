package simuladorPuntosPOO;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
	// Atributos
    private String nombre;
    private List<Mision> misiones;
    // Constructor
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.misiones = new ArrayList<>();
    }

    public void agregarMision(Mision mision) {
        misiones.add(mision);
    }

    // Método calcular total de puntos
    public int calcularTotalPuntos() {
        int total = 0;
        for (Mision m : misiones) {
            total += m.getPuntaje();
        }
        return total;
    }
    //2. Metodo para Determinar si el jugador es un Chad:
    public boolean esChadDelRPG() {
        return calcularTotalPuntos() > 300;
    }
    //3. Metodo para Encontrar la misión con más puntos:
    public int obtenerMisionMasPuntaje() {
        int mayor = 0;
        int indice = 0;
        for (int i = 0; i < misiones.size(); i++) {
            if (misiones.get(i).getPuntaje() > mayor) {
                mayor = misiones.get(i).getPuntaje();
                indice = i + 1;
            }
        }
        return indice;
    }
    //4. Metodo para Verificar si hay alguna misión fallida:
    public boolean hayMisionFallida() {
        for (Mision m : misiones) {
            if (m.getPuntaje() == 0) return true;
        }
        return false;
    }
    //5. Metodo para Determinar si fue constante:
    public boolean ejecucionConstante() {
        int mayor = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;
        for (Mision m : misiones) {
            int p = m.getPuntaje();
            if (p > mayor) mayor = p;
            if (p < menor) menor = p;
        }
        return (mayor - menor) < 20;
    }
    //6. Metodo para Contar cuántas misiones superaron los 75 puntos.
	//Si son al menos 3, mostrar:"Nivel desbloqueado: Mini Stone Chad"
    public boolean desbloqueaMiniStoneChad() {
        int contador = 0;
        for (Mision m : misiones) {
            if (m.getPuntaje() > 75) contador++;
        }
        return contador >= 3;
    }
    //7. Metodo que Muestra de resultados (Tabla de puntuación final):
    public void mostrarTablaPuntuacion() {
        System.out.println("Tabla de puntuación final");
        System.out.println("Misión\tPuntaje\tPuntaje Acumulado");
        int acumulado = 0;
        for (int i = 0; i < misiones.size(); i++) {
            int p = misiones.get(i).getPuntaje();
            acumulado += p;
            System.out.println((i + 1) + "\t" + p + "\t" + acumulado);
        }
        System.out.println("Total Final de Puntos: " + acumulado);
    }
    // Metodo para mostrar el resumen en consola
    public void mostrarResumen() {
        System.out.println("Puntos acumulados: " + calcularTotalPuntos());
        System.out.println(esChadDelRPG() ? "¡Felicidades! Sos un verdadero Chad del RPG" : "Te falta entrenamiento, joven aprendiz...");
        System.out.println("Tu mejor desempeño fue en la misión " + obtenerMisionMasPuntaje() + " con " + misiones.get(obtenerMisionMasPuntaje() - 1).getPuntaje() + " puntos.");
        if (hayMisionFallida()) System.out.println("Fallaste al menos una misión. Que el backend te tenga piedad...");
        if (ejecucionConstante()) System.out.println("¡Ejecución constante! Sos el sueño de un arquitecto de software.");
        if (desbloqueaMiniStoneChad()) System.out.println("Nivel desbloqueado: Mini Stone Chad");
        mostrarTablaPuntuacion();
    }
}
