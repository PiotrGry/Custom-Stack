package stack;

public class StackRS {

    private Character [] arr;
    private int pointer;

    public StackRS() {
        this.arr = new Character[50];
        this.pointer = -1;
    }

    public StackRS(int size) {
        this.arr = new Character[size];
        this.pointer = -1;
    }

    public void push(String text) {
        if (checkIfStackHasEnoughSpace()) {
            throw new ArrayIndexOutOfBoundsException("Stack if full");
        }
        char[] charArray = text.toCharArray();
        int lastIndex = charArray.length - 1;
        for (int i = 0; i <= lastIndex; i++) {
            pointer++;
            arr[pointer] = charArray[i];
        }
    }


    public String pop(){
        if(checkIfPointerIsNotToLow()){
            throw new NegativeArraySizeException("Stack pointer is negative");
        }
        if(isEmpty()){
            throw new IllegalStateException("pop on empty stack");
        }
        return String.valueOf(arr[pointer--]);
    }

    private boolean isEmpty() {
        return pointer  == -1;
    }


    public String StringReverser(String text){
        push(text);
        StringBuilder sb = new StringBuilder("");
        for(int i = 0 ; i < text.length(); i ++){
            sb.append(pop());
        }
        return String.valueOf(sb);
    }

    private boolean checkIfStackHasEnoughSpace(){
        return pointer > arr.length-1;
        }

    private boolean checkIfPointerIsNotToLow(){
        return pointer < -1;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i <= pointer; i++) {
            Character letter = arr[i];
            sb.append(letter);
        }
        return String.valueOf(sb);
    }
}
