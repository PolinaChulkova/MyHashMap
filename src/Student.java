import java.util.Objects;

public class Student {
    private int id;
    private String name;
    private String depart;

    public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.depart = course;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name) && Objects.equals(depart, student.depart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, depart);
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return depart;
    }

    public void setCourse(String course) {
        this.depart = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", depart='" + depart + '\'' +
                '}';
    }
}
