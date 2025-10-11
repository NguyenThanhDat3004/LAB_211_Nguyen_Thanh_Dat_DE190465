package tuan_3.stack;


public class MyStack<T> {
    private Object[] stack;
    private int top; // vi tri dau stack
    private int capacity; // dung luong stack
    // constructor
    public MyStack(int size) {
        stack = new Object[size];
        capacity = size;
        top = -1;
    }
    // get set

    public Object[] getStack() {
        return stack;
    }

    public void setStack(Object[] stack) {
        this.stack = stack;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    // tang dung luong
    public void upSize(){
        try{
            if(top == stack.length-1){
            Object[] newStack = new Object[capacity*2];
            for (int i = 0; i < stack.length;i++){
                newStack[i] = stack[i];
            }
            stack = newStack;
            capacity = capacity*2; // cap nhat bien vi dung luong tang nma bien nay chua tang
        }
        }catch(OutOfMemoryError e){ // no nem ra error chu khong phai exception dau ma dung exception la khong bat ra dau:))
            System.out.println("Memory full"); // maybe het dung luong
        }
    }
    // check mang rong
    public boolean isEmpty() {
    return top == -1;
    }
    // check mang day
    public boolean isFull() {
    return top == stack.length - 1;
    }
    // check size
    public int size(){
        return top+1;
    }
    //push(): Thêm một giá trị vào ngăn xếp.
    public boolean push(T element){
        // check mang day chua neu day thi phai cap them dung luong
        if(this.isFull()){
            this.upSize();
        }
        // cap nhat tai index size
        stack[this.size()] = element;
        top++; // cap nhat top
        return true;
    }
    //pop(): Lấy một giá trị ra khỏi ngăn xếp.
    public boolean pop(){
        // kiem tra rong
        if(this.isEmpty()) return false; // mang rong
        stack[top] = null;
        top--;
        return true;
    }
    //get(): lay nma khong xoa
    public  Object get(){
        if(this.isEmpty()) return null;
        return stack[top];
    }
    
}
