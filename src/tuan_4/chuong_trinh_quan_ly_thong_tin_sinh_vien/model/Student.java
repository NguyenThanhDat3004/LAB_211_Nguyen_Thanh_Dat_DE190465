package tuan_4.chuong_trinh_quan_ly_thong_tin_sinh_vien.model;
public class Student {
    private String id;
    private String name;
    private int semester;
    private Course course;
    public Student(String id, String name, int semester, Course course){
        this.course = course;
        this.name = name;
        this.id = id;
        this.semester = semester;
    }
    public Student(){

    }
    // get set


    public Course getCourse() {
        return course;
    }

    public String getId() {
        return id;
    }

    public int getSemester() {
        return semester;
    }

    public String getName() {
        return name;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", semester=" + semester + ", course=" + course + "]";
    }
    
}
