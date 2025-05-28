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