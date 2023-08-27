package classes;

// Classe que representa uma coordenada com valores x e y
public class Coordinate implements Cloneable {

    private int x;  // Coordenada x
    private int y;  // Coordenada y

    // Construtor que recebe valores x e y e inicializa a coordenada
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Obtém o valor da coordenada x
    public int getX() {
        return x;
    }

    // Define o valor da coordenada x
    public void setX(int x) {
        this.x = x;
    }

    // Obtém o valor da coordenada y
    public int getY() {
        return y;
    }

    // Define o valor da coordenada y
    public void setY(int y) {
        this.y = y;
    }

    // Retorna uma representação de string da coordenada
    @Override
    public String toString() {
        return "Coordinate{ " + "x = " + x + ", y = " + y + " }";
    }

    // Sobrescreve o método clone para criar uma cópia da coordenada
    @Override
    public Coordinate clone() {
        try {
            return (Coordinate) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
