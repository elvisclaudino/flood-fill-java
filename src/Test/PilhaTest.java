package Test;

public class PilhaTest {
    int elementos[];
    int topo;

    public PilhaTest(){
        elementos = new int[10];
        topo      = -1;
    }

    public void push(int e){
        topo++;
        elementos[topo] = e;
    }
    public int pop(){
        int e;
        e = elementos[topo];
        topo--;
        return e;
    }
    public boolean isEmpty(){
        return (topo == -1);
    }
    public boolean isFull(){
        return topo == elementos.length;
    }
    public int top(){
        return elementos[topo];
    }
}
