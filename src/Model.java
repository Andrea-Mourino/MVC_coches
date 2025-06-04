import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase encargada de manejar los datos
 */
public class Model {
    int litros = 0;
    static ArrayList<Coche> parking = new ArrayList<>();

    // Lista de observadores que quieren ser notificados cuando cambie la gasolina
    private List<observer> observadores = new ArrayList<>();

    // Capacidad máxima del depósito
    private final int CAPACIDAD_MAX = 50;

    // -----------------------------------
    // Gestión de Observadores
    // -----------------------------------

    // Método para registrar un nuevo observador (por ejemplo, una alarma)
    public void agregarObservador(observer obs) {
        observadores.add(obs);
    }

    // Notificar a todos los observadores con un mensaje
    private void notifCambioGasolina(String mensaje) {
        for (observer obs : observadores) {
            obs.actualizarGasolina(mensaje);
        }
    }


    /**
     * Crea un coche y lo mete en el parking
     * @param modelo del coche
     * @param matricula identificador unico
     * @return el coche creado
     */
    public Coche crearCoche(String modelo, String matricula){
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    /**
     * Busca coche segun matricula
     * @param matricula a buscar
     * @return chche o null si no existe
     */
    public Coche getCoche(String matricula){
        Coche aux = null;
        // recorre el array buscando por matricula
        for (Coche e: parking) {
            if (e.matricula.equals(matricula)) {
                aux = e;
            }
        }
        return aux;
    }
    public ArrayList<Coche> getTodosLosCoches() {
        return parking;
    }

    /**
     * Cambia la velocidad de un coche
     * @param matricula
     * @param v nueva velocidad
     * @return velocidad modificada
     */
    public int cambiarVelocidad(String matricula, Integer v) {
        // busca el coche
        getCoche(matricula).velocidad = v;
        // retorna la nueva velocidad
        return getCoche(matricula).velocidad;
    }

    /**
     * Ddevuelve la velocidad segun la matricula
     * @param matricula
     * @return
     */
    public int getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }
    /**
     * Añade un coche al parking
     * @param coche el coche a añadir
     */
    public void addCoche(Coche coche) {
        parking.add(coche);
    }
    /**
     * Aumenta la velocidad de un coche en el parking
     * @param index índice del coche
     * @param incremento cantidad a aumentar
     */
    public void aumentarVelocidadCoche(int index, int incremento) {
        if (index >= 0 && index < parking.size()) {
            parking.get(index).aumentarVelocidad(incremento);
        } else {
            System.out.println("Índice fuera de rango");
        }
    }
    /**
     * Disminuye la velocidad de un coche en el parking
     * @param index índice del coche
     * @param decremento cantidad a disminuir
     */
    public void disminuirVelocidadCoche(int index, int decremento) {
        if (index >= 0 && index < parking.size()) {
            parking.get(index).disminuirVelocidad(decremento);
        } else {
            System.out.println("Índice fuera de alcance");
        }
    }

    public void mostrarTodosLosCoches(ArrayList<Coche> coches) {
        System.out.println("--- Lista de Coches ---");
        if (coches.isEmpty()) {
            System.out.println("No hay coches registrados.");
        } else {
            for (Coche coche : coches) {
                System.out.println(coche);
            }
        }
    }
    /**
     * Avanza una distancia, consume gasolina si las condiciones lo requieren
     * @param metros cantidad de metros a avanzar
     * @param velocidad velocidad actual del coche
     */
    public void avanzar(int metros, int velocidad) {
        int posicionAlInicial = 0;
        int posicionNueva = posicionAlInicial + metros;

        if (posicionNueva > 100 || velocidad > 60) {
            reducirGasolina();
            System.out.println("Reduciendo gasolina...");
        } else {
            System.out.println("Avanzando " + metros + " metros a velocidad " + velocidad + " km/h.");
        }
    }

    /**
     * Reduce 10 litros de gasolina si hay suficiente
     */
    public boolean reducirGasolina() {
        if (litros >= 10) {
            litros -= 10;
            System.out.println("Gasolina que queda: " + litros + " litros.");
        } else {
            System.out.println("Poca gasolina para continuar.");
        }
        return true;
    }

    /**
     * Reposta una cantidad de gasolina ingresada
     * @param litrosRepostar litros a añadir
     */
    public void ponerGasolina(int litrosRepostar) {
        if (litrosRepostar <= 0) {
            System.out.println("Cantidad no valida. Agregue un valor positivo.");
            return;
        }
        litros += litrosRepostar;
        System.out.println("Se han añadido " + litrosRepostar + " litros. Total: " + litros + " litros.");
    }

    public int getGasolinaActual() {
        return litros;
    }
}
