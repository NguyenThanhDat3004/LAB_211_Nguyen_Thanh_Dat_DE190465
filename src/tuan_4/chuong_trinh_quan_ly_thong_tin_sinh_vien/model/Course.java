package tuan_4.chuong_trinh_quan_ly_thong_tin_sinh_vien.model;

public enum Course {
    JAVA("Java"),
    DOT_NET(".Net"),
    C_CPP("C/C++");

    private String courseName;

    Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public String toString() {
        return courseName;
    }
}
