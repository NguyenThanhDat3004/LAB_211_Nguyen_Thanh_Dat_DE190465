/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_3.stack;


/**
 *
 * @author nguye
 */
public class Test {
    MyStack<Integer> stack = new MyStack<>(3);
        
    public static void main(String[] args) {
        Test t = new Test();
        t.execute();
    }
    // duyet va lay ra
    public void layMang(){
        for(int i = 0; i<stack.size();i++){
            System.out.print(stack.getStack()[i]+" ");
        }
    }
    public void execute(){
        stack.push(1);
        layMang();
        System.out.println("");
        stack.push(2);
        layMang();
        System.out.println("");
        stack.pop();
        layMang();
        System.out.println("");
        System.out.println(stack.get());
        layMang();
        
    }
    
}


// note kien thuc
/*
Generic trong Java thực chất là compile-time feature
Lúc biên dịch (compile), compiler sẽ kiểm tra type để đảm bảo an toàn
Nhưng khi vào runtime, toàn bộ thông tin về T sẽ bị xóa (type erasure). JVM chỉ thấy Object
Khi bạn dùng push()Ở compile-time, T = Integer nên compiler cho phép bạn truyền 1.
Khi chạy thật, 1 được autoboxing thành Integer, và push(Object element) nhận vào → lưu trong Object[].
Khi bạn dùng get()
Compile-time và runtime đều hiểu là trả về Object.
Nên nếu hàm get mà lấy ra theo T nguyên mảng thì vỡ mồm với runtime
*/