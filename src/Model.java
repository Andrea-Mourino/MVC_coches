import java.util.ArrayList;

/**
 * Clase encargada de manejar los datos
 */
public class Model {
    static ArrayList<Coche> parking = new ArrayList<>();

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
            System.out.println("Índice fuera de rango");
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
}
