package DoubleLinkedList;

public class CycleDoubleLinkedList<T> extends DoubleLinkedList<T> {
    @Override
    public void add(T element){
        super.add(element);
        cycleList();
    }

    @Override
    public void addBefore(int index, T value){
        super.addBefore(index, value);
        cycleList();
    }

    @Override
    public void remove(int index){
        super.remove(index);
        cycleList();
    }

    @Override
    protected boolean ifIndexIllegal(int index){
        return size == 0 || index < 0;
    }

    private void cycleList(){
        if(size != 0){
            tail.next = head;
            head.prev = tail;
        }
    }
}
