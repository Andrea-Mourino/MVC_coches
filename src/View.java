/**
 * Clase encargada de la interacción con el usuario
 * y la presentación de datos
 */
import java.util.ArrayList;
import java.util.Scanner;

public class View implements observer {
    private final Controller controller;
    private final Scanner sc = new Scanner(System.in);

    public View(Controller controller) {
        this.controller = controller;
    }
    /**
     * Muestra la velocidad de un coche
     * @param matricula del coche
     * @param v velocidad
     * @return true si se ha mostrado correctamente
     */
    public boolean muestraVelocidad(String matricula, Integer v){
        System.out.println(matricula + ": " + v + "km/hr");
        return true;
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
    public void menu() {

        int opcion;
        do {
            System.out.println("\n MENÚ");

            System.out.println("1. Aumentar velocidad");
            System.out.println("2. Disminuir velocidad");
            System.out.println("3. Mostrar gasolina actual");
            System.out.println("4. Avanzar");
            System.out.println("5. Repostar gasolina");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    modificarVelocidad(true);
                    break;
                case 2:
                    modificarVelocidad(false);
                    break;
                case 3:
                    mostrarGasolina();
                    break;
                case 4:
                    avanzar();
                    break;
                case 5:
                    repostar();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no valida.");
            }
        } while (opcion != 0);
    }

    private void modificarVelocidad(boolean aumentar) {
        sc.nextLine(); // limpiar buffer
        System.out.print("Introducir la matrícula del coche: ");
        String matricula = sc.nextLine().trim();

        System.out.print("Introducir el valor a " + (aumentar ? "aumentar" : "disminuir") + ": ");
        int valor = sc.nextInt();

        if (aumentar) {
            controller.aumentarVelocidad(matricula, valor);
        } else {
            controller.disminuirVelocidad(matricula, valor);
        }
    }

    private void mostrarGasolina() {
        int gasolina = controller.consultarGasolina();
        System.out.println("Gasolina que tienes actualmente: " + gasolina + " litros.");
    }

    private void avanzar() {
        System.out.print("Introducir los metros a avanzar: ");
        int metros = sc.nextInt();

        System.out.print("Introducir la velocidad actual (km/h): ");
        int velocidad = sc.nextInt();
        controller.avanzar(metros, velocidad);
    }

    private void repostar() {
        System.out.print("Introducir los litros de gasolina que quieres poner: ");
        int litros = sc.nextInt();
        controller.repostarGasolina(litros);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    @Override
    public void actualizarGasolina(String mensaje) {
        System.out.println("Alerta de Gasolina: " + mensaje);
        // Este método se llama cada vez que cambia el nivel de gasolina.
        // El mensaje recibido tendrá el formato: "Nivel de gasolina: 8"

        // Separamos el texto usando ":" como separador
        String[] partesDelMensaje = mensaje.split(":");

        // Tomamos la segunda parte (el número), quitamos espacios y lo convertimos a entero
        String textoDelNivel = partesDelMensaje[1].trim();
        int nivelDeGasolina = Integer.parseInt(textoDelNivel);

        // Si el nivel es menor que 10, mostramos una advertencia
        if (nivelDeGasolina < 10) {
            System.out.println("[Alerta] Quedan " + nivelDeGasolina + " litros de gasolina. Recomendado repostar pronto.");
        }
    }
}
