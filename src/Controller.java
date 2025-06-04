/**
 * Controller.java
 * @author Andrea
 * @version 1.0
 */

import java.lang.module.ModuleDescriptor;

import java.lang.module.ModuleDescriptor;

public class Controller{
    // Instanciamos la vista y el modelo
    View miView = new View(this);
    Model miModel = new Model();

    public Controller() {
        this.miModel = new Model();
    }

    public static void main(String[] args) {
        // Instanciamos la vista y el modelo
        View miView = new View( null);
        Model miModel = new Model();

        // Crear tres coches
        miModel.crearCoche("LaFerrari", "SBC 1234");
        miModel.crearCoche("Alpine", "HYU 4567");
        miModel.crearCoche("Aston Martin", "FGH 3333");

        Coche ferrari = miModel.getCoche("SBC 1234");
        int nuevaVelocidad = miModel.cambiarVelocidad("SBC 1234", 30);
        boolean hecho = miView.muestraVelocidad("SBC 1234", miModel.getVelocidad("SBC 1234"));

        if (hecho) {
            System.out.println("Correcto");
        } else {
            System.out.println("Error");
        }
    }
    public void aumentarVelocidad(String matricula, int incremento) {
        Coche coche = miModel.getCoche(matricula);
        if (coche != null) {
            miModel.cambiarVelocidad(matricula, coche.velocidad + incremento);
            System.out.println("Velocidad incrementada correctamente.");
        } else {
            System.out.println("Coche no encontrado.");
        }
    }

    public void disminuirVelocidad(String matricula, int decremento) {
        Coche coche = miModel.getCoche(matricula);
        if (coche != null) {
            miModel.cambiarVelocidad(matricula, coche.velocidad - decremento);
            System.out.println("Velocidad menguada correctamente.");
        } else {
            System.out.println("Coche no encontrado.");
        }
    }

    public void avanzar(int metros, int velocidad) {
        miModel.avanzar(metros, velocidad);
    }

    public void repostarGasolina(int litros) {
        miModel.ponerGasolina(litros);
    }

    public int consultarGasolina() {
        return miModel.getGasolinaActual();
    }

}
