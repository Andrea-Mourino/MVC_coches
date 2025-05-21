/**
 * Clase encargada de la interacción con el usuario
 * y la presentación de datos
 */
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase encargada de la interacción con el usuario
 */
public class View {
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
    public static void menu() {
        Scanner scanner = new Scanner(System.in);

        Model miModel = new Model();
        View miView = new View();
        Controller miController = new Controller();
        int opcion;



        do {
            System.out.println("--- Menú Principal ---");
            System.out.println("1. Crear coche");
            System.out.println("2. Aumentar velocidad");
            System.out.println("3. Disminuir velocidad");
            System.out.println("4. Mostrar todos los coches");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            opcion = scanner.nextInt();


            switch (opcion) {

                case 1:
                    System.out.print("Introduce el modelo del coche: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Introduce la matrícula del coche: ");
                    String matricula = scanner.nextLine();
                    miModel.crearCoche(modelo, matricula);
                    System.out.println("Coche creado correctamente.");
                    break;
                case 2:
                    System.out.print("Introduce la matrícula del coche: ");
                    String matriculaAumentar = scanner.nextLine();
                    System.out.print("Introduce la velocidad a aumentar: ");
                    int velocidadAumentar = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    miController.aumentarVelocidad(matriculaAumentar, miModel.getVelocidad(matriculaAumentar) + velocidadAumentar);
                    System.out.println("Velocidad aumentada correctamente.");
                    break;
                case 3:
                    System.out.print("Introduce la matrícula del coche: ");
                    String matriculaDisminuir = scanner.nextLine();
                    System.out.print("Introduce la velocidad a disminuir: ");
                    int velocidadDisminuir = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    miController.disminuirVelocidad(matriculaDisminuir, miModel.getVelocidad(matriculaDisminuir) - velocidadDisminuir);
                    System.out.println("Velocidad disminuida correctamente.");
                    break;

                case 4:
                    miView.mostrarTodosLosCoches(miModel.getTodosLosCoches());
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;


            }

        } while (opcion != 0);

    }

}
