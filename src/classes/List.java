package classes;

// Classe que estende LinkedList para adicionar, definir e remover elementos em posições específicas
public class List<T> extends LinkedList<T> {

    // Adiciona um elemento em uma posição específica na lista
    public void add(T element, int index) throws Exception {
        validIndex(index);  // Verifica se o índice é válido

        Node<T> toInsertNode = new Node<T>(element);  // Cria um novo nó com o elemento a ser inserido

        Node<T> toMoveNode = getNode(index);  // Obtém o nó existente na posição
        Node<T> previousNode = toMoveNode.previous;  // Obtém o nó anterior ao nó existente

        previousNode.next = toInsertNode;  // Atualiza as referências para inserir o novo nó
        toInsertNode.previous = previousNode;

        toInsertNode.next = toMoveNode;
        toMoveNode.previous = toInsertNode;

        length++;  // Incrementa o tamanho da lista
    }

    // Define um elemento em uma posição específica na lista
    public void set(T element, int index) throws Exception {
        getNode(index).data = element;  // Define o valor do nó na posição fornecida
    }

    // Remove um elemento em uma posição específica na lista
    public T remove(int index) throws Exception {
        return super.remove(index);  // Chama o método remove da classe base
    }
}
