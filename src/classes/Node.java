package classes;

// Classe que representa um nó em uma estrutura de dados encadeada
public class Node<T> {

    Node<T> previous;  // Referência ao nó anterior
    Node<T> next;      // Referência ao próximo nó
    T data;            // Dado armazenado no nó

    // Construtor que inicializa o nó com um valor
    public Node(T value) {
        data = value;
    }

    // Retorna uma representação de string do nó
    @Override
    public String toString() {
        return "Node [ previous = " + (previous != null ? previous.data : null) + ", data = " + data + ", next = " + (next != null ? next.data : null) + " ]";
    }
}
