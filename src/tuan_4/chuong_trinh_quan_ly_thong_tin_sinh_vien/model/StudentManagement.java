package tuan_4.chuong_trinh_quan_ly_thong_tin_sinh_vien.model;

import java.util.*;
import java.util.function.Predicate;

public class StudentManagement {
    private List<Student> list = new ArrayList<>();
    private List<Student> listSearch = new ArrayList<>();
    
    public StudentManagement() {
        // Dữ liệu mẫu
        list.add(new Student("1", "Nguyen Van A", 1, Course.JAVA));
        list.add(new Student("1", "Nguyen Van A", 1, Course.JAVA));
        list.add(new Student("2", "Nguyen Van B", 2, Course.DOT_NET));
        list.add(new Student("2", "Nguyen Van B", 2, Course.JAVA));
        list.add(new Student("3", "Nguyen Van C", 3, Course.JAVA));
    }
    
    public List<Student> getList() {
        return list;
    }

    public List<Student> getListSearch() {
        return listSearch;
    }
    
    
    // Thêm sinh viên
    public void addStudent(Student s) {
        list.add(s);
    }
    
    // Tìm theo ID
    public List<Student> searchById(String id) {
        Predicate<Student> searchById = a -> a.getId().equalsIgnoreCase(id);
        listSearch =  list.stream().filter(searchById).toList();
        return listSearch;
    }
    
    // Tìm theo tên (tìm một phần)
    public List<Student> searchByName(String name) {
        Predicate<Student> searchByName = a -> 
        a.getName().toLowerCase().contains(name.toLowerCase());
        listSearch = list.stream().filter(searchByName).toList();
        return listSearch;
    }
    
    // Cập nhật sinh viên
    public void update(Student oldStudent, Student newStudent) {
        int index = list.indexOf(oldStudent);
        if (index != -1) {
            list.set(index, newStudent);
        }
    }
    
    // Xóa sinh viên
    public void removeStudent(Student student) {
        list.remove(student);
    }
    
    // Sắp xếp theo tên
    public void sortStudent() {
        list.sort(Comparator.comparing(Student::getName));
    }
    
    // Báo cáo
    public Map<String, Integer> getReport() {
        Map<String, Integer> report = new HashMap<>();
        for (Student st : list) {
            String key = st.getName() + "|" + st.getCourse().getCourseName();
            report.put(key, report.getOrDefault(key, 0) + 1);
        }
        return report;
    }
}
//    public void sortStudent(){
//        list.sort(Comparator.comparing(Student::getName));
//    }
//    // ham report
//    public void report(){
//        Map<String, Integer> report = new HashMap<>();
//        for(Student st: list){
//            String key = st.getId()+"|"+st.getName()+"|"+st.getCourse();
//            report.put(key, report.getOrDefault(key, 0)+1);
//        }
//        for(Map.Entry<String, Integer> st : report.entrySet()){
//            System.out.println(st.getKey() + ": " + st.getValue());
//        }
//    }

