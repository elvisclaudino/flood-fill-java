package classes;

// Classe que estende LinkedList para implementar uma estrutura de fila
public class Queue<T> extends LinkedList<T> {

    private final int base = 0;  // Posição base da fila
    private int top = -1;       // Posição do topo da fila

    //#region members 'API'

    // Retorna o primeiro elemento da fila
    public T first() throws Exception {
        return super.get(base);
    }

    // Retorna o último elemento da fila
    public T last() throws Exception {
        return !isEmpty() ? super.get(top) : null;
    }

    // Adiciona um elemento à fila
    public void add(T element) {
        super.add(element);  // Chama o método add da classe base para adicionar o elemento
        top++;               // Incrementa a posição do topo
    }

    // Remove e retorna o elemento da frente da fila
    public T remove() throws Exception {
        T element = null;

        // Se houver apenas um elemento na fila, remove-o e limpa a fila
        if (top == base) {
            element = super.get(top);
            this.clear();
        }

        // Se a fila não estiver vazia, remove o primeiro elemento
        if (!isEmpty()) {
            element = super.remove(base);
        }

        top--;  // Decrementa a posição do topo

        return element;
    }

    // Limpa a fila
    public void clear() {
        super.clear();  // Chama o método clear da classe base para limpar a lista
        top = 0;        // Redefine a posição do topo para a base
    }

    //#endregion
}
