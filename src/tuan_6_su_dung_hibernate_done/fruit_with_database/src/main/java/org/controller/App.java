package org.controller;

import org.dao.FruitDAO;
import org.dao.OrderDAO;
import org.model.*;
import org.utills.Validator;
import org.view.Menu1;
import org.view.Solution;

import java.sql.SQLException;

public class App extends Menu1 {
    Solution so = new Solution();
    User_Maganement m = new User_Maganement();
    public App(){
        super("FRUIT SHOP SYSTEM",new String[]{
                "Create Fruit",
                "View orders",
                "Shopping (for buyer)",
                "Exit"
        });
        m.load();
    }

    @Override
    public void execute(int n) throws SQLException {
        switch (n){
            case 1:
                int choice = 0;
                do{
                    System.out.println("Create a fruit! Please enter information!");
                    Fruit f = Validator.enterFruit();
                    FruitDAO.getInstance().add(f);
                    m.load();
                    choice = Validator.checkNumInWhile("Do you want continue? Please choice 1 or 2?\n 1.Yes \n 2.No");
                    if(choice==2) System.out.println("Back to menu");
                }while(choice==1);
                break;
            case 3:
                System.out.println("Shopping");
                double tong = 0;
                String name = Validator.checkString("Hello.What's your name?");
                Orders o = new Orders(name,0);
                m.addOrder(o);
                int check = 0;
                do{

                    so.displayFruit(m);
                    System.out.println("Enter your choice: ");
                    int tmp = Validator.checkInt("Integer only");
                    int quatity = Validator.checkInt("Number of fruit: ");
                    if(m.increaseQuality(m.getFruitList().get(tmp-1),quatity)){
                        m.addOrderDetail(new OrderDetail(o.getOrder_id(),m.getFruitList().get(tmp-1).getFruit_id(),quatity,m.getFruitList().get(tmp-1).getPrice()*quatity));
                        tong+=m.getFruitList().get(tmp-1).getPrice()*quatity;
                    }
                    check = Validator.checkNumInWhile("\"Do you want continue? (Please choose 1 or 2) \\n 1. Yes\\n 2. No\"");
                    if(check==2) System.out.println("Back to menu");
                }while(check==1);
                o.setTotal_amount(tong);
                OrderDAO.getInstance().update(o);

                break;
            case 2:
                System.out.println("\n=== Orders List ===");

                // 1. Duyệt qua TẤT CẢ các đơn hàng (Orders)
                for (Orders o1 : m.getOrdersList()) {

                    // Lấy order_id của đơn hàng hiện tại
                    int currentOrderId = o1.getOrder_id();

                    // In thông tin chung của đơn hàng
                    System.out.println("Customer: " + o1.getCustomerName());
                    System.out.println("Product | Quantity | Price | Amount");

                    int i = 1;

                    // 2. Duyệt qua TẤT CẢ OrderDetail trong hệ thống
                    for (OrderDetail od : m.getOrderDetailList()) {

                        // 3. LỌC: Chỉ xử lý OrderDetail có order_id khớp với đơn hàng hiện tại
                        if (od.getOrder_id() == currentOrderId) {

                            // 4. Tìm thông tin Fruit tương ứng
                            Fruit fruit = m.getFruitList().stream()
                                    .filter(f -> f.getFruit_id() == od.getFruit_id())
                                    .findFirst().orElse(null);

                            if (fruit != null) {
                                // 5. In chi tiết của từng loại quả trong đơn hàng này
                                System.out.printf("%d. %s | %d | %.2f$ | %.2f$\n",
                                        i++, fruit.getName(), od.getQuantity(), fruit.getPrice(), od.getAmount());
                            }
                        }
                    }

                    // In tổng tiền của đơn hàng hiện tại
                    System.out.printf("Total: %.2f$\n\n", o1.getTotal_amount());
                }
                break;
            case 4:

                System.out.println("Exit");
                break;
            default:
                System.out.println("Not valid");
        }
    }

    public static void main(String[] args) throws SQLException {
        App a = new App();
        a.run();
    }
}
