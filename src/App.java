public class App {
    public static void main(String[] args) {
        // Crear instancias del Model y Controller
        Model miModel = new Model();
        Controller miController = new Controller();

        // Crear la View y pasarle el Controller
        View miView = new View();

        // Iniciar el menú
        miView.menu();
    }
}
