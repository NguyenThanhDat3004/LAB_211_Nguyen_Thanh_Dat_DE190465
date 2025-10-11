package tuan_4.chuong_trinh_quan_ly_thong_tin_sinh_vien.controller;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import tuan_4.chuong_trinh_quan_ly_thong_tin_sinh_vien.model.Student;
import tuan_4.chuong_trinh_quan_ly_thong_tin_sinh_vien.model.StudentManagement;
import tuan_4.chuong_trinh_quan_ly_thong_tin_sinh_vien.utils.Validator;
import tuan_4.chuong_trinh_quan_ly_thong_tin_sinh_vien.view.Menu1;

public class App extends Menu1{
    // pk la id sem va course
    // update thi phai khac so voi ban dau
    StudentManagement m  = new StudentManagement();
    Scanner sc = new Scanner(System.in);
    public App(){
        super("Menu", new String[]{
            "Create","Find and Sort","Update/Delete","Report","Exit"
        });
    }
    //

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                Student s = Validator.inputStudent();
                Predicate<Student> checkKey = su ->(su.getId().equalsIgnoreCase(s.getId())&&su.getSemester()==s.getSemester()&&su.getCourse()==s.getCourse());
                if(m.getList().stream().filter(checkKey).toList().isEmpty()){
                    String check = Validator.checkAgree("Do you want add in list?");
                    if(check.equalsIgnoreCase("Y")){
                        m.addStudent(s);
                    }else{
                        System.out.println("Cancel");
                    }
                }else{
                    System.out.println("Contain in list.");
                }
                break;
            case 2:
                // tim sinh vien theo ten
                String name = Validator.checkName("Enter your name: ");
                m.sortStudent();
                for (Student student : m.searchByName(name)) {
                    System.out.println(student.getName()+"|"+student.getSemester()+"|"+student.getCourse().getCourseName());
                }
                break;
            case 3:
                //xoa hoac delete
                System.out.println("Enter id: ");
                    if(m.searchById(sc.nextLine()).isEmpty()){
                        System.out.println("Not available student");
                    }else{
                        int i = 1;
                        for (Student su  : m.getListSearch()) {
                            System.out.println(i+"."+su);
                            i++;
                        }
                        int a = Validator.checkNum("Enter your student you want edit");
                        System.out.println("1.Update \n 2.Delete");
                        int choice = Validator.checkNum("Enter your choice: ");
                        if(choice == 1){
                            Student p = Validator.updateStudent();
                            p.setId(m.getListSearch().get(a-1).getId());
                            m.update(m.getListSearch().get(a-1), p);
                        }else if(choice==2){
                            m.removeStudent(m.getListSearch().get(a-1));
                        }else{
                        System.out.println("Only 1 or 2");
                }
                        
                    }
                   
                break;
            case 4:
                for(Map.Entry<String, Integer> st : m.getReport().entrySet()){
                System.out.println(st.getKey() + ": " + st.getValue());
                }
                break;
            case 5:
                System.out.println("Exit...");
                break;
            default:
                System.out.println("Not valid");
                break;
        }
    }
    public static void main(String[] args) {
        App a = new App();
        a.run();
    }
    
    
}
