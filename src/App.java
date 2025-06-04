public class App {
    public static void main(String[] args) {
        Model miModel = new Model();
        Controller miController = new Controller();

        View miView = new View(miController);

        miView.menu();
    }
}
