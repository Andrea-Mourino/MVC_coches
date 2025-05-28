/**
 * Coche.java
 *
 * Clase que representa un coche con matrícula, modelo y velocidad.
 *
 * @version 1.0
 *
 * @author Andrea
 */
public class Coche {
    String matricula;
    String modelo;
    Integer velocidad;
    double gasolina;


    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = 0;
        this.gasolina = 100;
    }
    public String getMatricula() {
        return matricula;
    }
    public String getModelo() {
        return modelo;
    }
    public Integer getVelocidad() {
        return velocidad;
    }
    public double getGasolina() { return gasolina; }
    public void aumentarVelocidad(int incremento) {
        this.velocidad += incremento;
    }
    public void disminuirVelocidad(int decremento) {
        this.velocidad -= decremento;
    }
    public void avanzar(double distancia) {
        double consumo = calcularConsumo(distancia);
        if (gasolina >= consumo) {
            gasolina -= consumo;
            System.out.println(modelo + " ha avanzado " + distancia + " km. Gasolina restante: " + gasolina + " litros.");
        } else {
            System.out.println(modelo + " no tiene suficiente gasolina para avanzar.");
        }
    }

    /**
     * Calcula el consumo de gasolina según la distancia y velocidad
     */
    private double calcularConsumo(double distancia) {
        double consumoPorKm = 0.05 + (velocidad * 0.001); // ejemplo
        return distancia * consumoPorKm;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "matricula='" + matricula + '\'' +
                ", modelo='" + modelo + '\'' +
                ", velocidad=" + velocidad + '\'' +
                ", galosina=" + gasolina +
                '}';
    }
}