package classes;

@SuppressWarnings("ALL")
public class FloodFiller<T> {

    private T[][] currentMatrix;  // Matriz atual sendo processada
    private final T[][] matrixOrigin;  // Matriz original fornecida
    private Queue<Coordinate> queue = new Queue<>();  // Fila de coordenadas para operações futuras
    private Stack<Coordinate> stack = new Stack<>();  // Pilha de coordenadas para operações atuais

    public FloodFiller(T[][] matrixOrigin) {
        this.matrixOrigin = matrixOrigin;  // Inicializa a matriz original
    }

    // Retorna a matriz atual (se existir) ou a matriz original
    private T[][] matrix() {
        return currentMatrix == null ? matrixOrigin : currentMatrix;
    }

    // Atualiza um elemento da matriz com um valor específico
    protected void matrix(int x, int y, T value) {
        matrix()[x][y] = value;
    }

    // Imprime a matriz atual no console
    public void printImage() {
        System.out.println("{");
        for (int x = 0; x < matrix().length; x++) {
            System.out.print(" { ");
            for (int y = 0; y < matrix()[x].length; y++)
                System.out.print(matrix()[x][y] + (y < matrix()[x].length - 1 ? ", " : ""));
            System.out.println(" }" + (x < matrix()[x].length - 1 ? ", " : ""));
        }
        System.out.println("}");
    }

    // Inicia a operação de preenchimento a partir de uma coordenada específica
    public void paint(int x, int y, T value) throws Exception {
        Coordinate coord = new Coordinate(x, y);
        printImage();
        T toFind = matrix()[coord.getX()][coord.getY()];
        stack.add(coord);
        fill(toFind, value);
        printImage();
    }

    // Algoritmo principal de preenchimento recursivo
    private void fill(T find, T replace) throws Exception {
        if (stack.isEmpty()) {
            return;
        }

        Coordinate coordinate = stack.remove();
        if (coordinate.getX() < matrix().length && coordinate.getY() < matrix()[coordinate.getX()].length) {
            matrix()[coordinate.getX()][coordinate.getY()] = replace;

            if (!checkY(coordinate.clone(), find) && !checkX(coordinate.clone(), find) && stack.isEmpty())
                return;

            fill(find, replace);

        } else throw new Exception("Coordenada inválida!");
    }

    // Verifica vizinhos na direção X
    private boolean checkX(Coordinate coordinate, T find) {
        boolean found = true;

        coordinate = new Coordinate(coordinate.getX() + 1, coordinate.getY());
        if (checkBottom(coordinate)) {
            if (matrix()[coordinate.getX()][coordinate.getY()] == find) {
                stack.add(coordinate);
            } else
                found = false;
        }

        coordinate = new Coordinate(coordinate.getX() - 2, coordinate.getY());
        if (checkTop(coordinate)) {
            if (matrix()[coordinate.getX()][coordinate.getY()] == find) {
                stack.add(coordinate);
            } else
                found = false;
        }
        return found;
    }

    // Verifica vizinhos na direção Y
    private boolean checkY(Coordinate coordinate, T find) {
        boolean found = true;

        coordinate = new Coordinate(coordinate.getX(), coordinate.getY() - 1);
        if (checkLeft(coordinate)) {
            if (matrix()[coordinate.getX()][coordinate.getY()] == find) {
                stack.add(coordinate);
            } else
                found = false;
        }

        coordinate = new Coordinate(coordinate.getX(), coordinate.getY() + 2);
        if (checkRight(coordinate)) {
            if (matrix()[coordinate.getX()][coordinate.getY()] == find) {
                stack.add(coordinate);
            } else
                found = false;
        }
        return found;
    }

    // Verifica se a coordenada está dentro dos limites superiores
    private boolean checkTop(Coordinate coordinate) {
        return coordinate.getX() >= 0;
    }

    // Verifica se a coordenada está dentro dos limites inferiores
    private boolean checkBottom(Coordinate coordinate) {
        return coordinate.getX() < matrix().length;
    }

    // Verifica se a coordenada está dentro dos limites à direita
    private boolean checkRight(Coordinate coordinate) {
        return coordinate.getY() < matrix()[coordinate.getX()].length;
    }

    // Verifica se a coordenada está dentro dos limites à esquerda
    private boolean checkLeft(Coordinate coordinate) {
        return coordinate.getY() >= 0;
    }

}
