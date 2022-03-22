public class MyList<T> {
    private T[] elements;
    private int size=0;
    private int maxDim=0;
    public MyList(int dimension){
        elements = (T[])new Object[dimension];
        this.maxDim = dimension;
    }

    public void add(T element){
        if(size+1>maxDim){
            System.out.println("Max dimension reached, element was not added!");
            return;
        }
        elements[size++] = element;
    }

    public void print(){
        System.out.print("[");
        for(int i=0;i<size;i++){
            System.out.print(elements[i].toString());
            if(i<size-1) System.out.print(",");
        }
        System.out.println("]");
    }

    public boolean lookup(T element){
        for(T lookup:elements ){
            if(element.equals(lookup))
                return true;
        }
        return false;
    }
}
