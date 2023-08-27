package classes;

// Classe que estende LinkedList para implementar uma estrutura de pilha
public class Stack<T> extends LinkedList<T> {

    private int top = -1;  // Posição do topo da pilha

    // Retorna o primeiro elemento da pilha (último elemento adicionado)
    public T first() throws Exception {
        return !isEmpty() ? super.get(0) : null;
    }

    // Retorna o último elemento da pilha (elemento no topo)
    public T last() throws Exception {
        return !isEmpty() ? super.get(top) : null;
    }

    // Adiciona um elemento ao topo da pilha
    public void add(T element) {
        super.add(element);  // Chama o método add da classe base para adicionar o elemento
        top++;               // Incrementa a posição do topo
    }

    // Remove e retorna o elemento no topo da pilha
    public T remove() throws Exception {
        T deletedElement = null;

        // Se houver apenas um elemento na pilha, remove-o e limpa a pilha
        if (top == 0) {
            deletedElement = super.get(top);
            this.clear();
            return deletedElement;
        }

        // Se a pilha não estiver vazia, remove o elemento do topo
        if (!isEmpty()) {
            deletedElement = super.remove();
        }

        top--;  // Decrementa a posição do topo
        return deletedElement;
    }

    // Limpa a pilha
    public void clear() {
        super.clear();  // Chama o método clear da classe base para limpar a lista
        top = -1;       // Redefine a posição do topo para -1
    }

}
