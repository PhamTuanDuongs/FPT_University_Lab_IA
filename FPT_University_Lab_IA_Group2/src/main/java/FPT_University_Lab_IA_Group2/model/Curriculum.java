/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FPT_University_Lab_IA_Group2.model;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author chuoiz
 */
@Entity
@Table(name = "Curriculum")
public class Curriculum {

    @Id
    @Column(name = "curriculumId")
    private String curriculumId;

    @Column(name = "curriculumName")
    private String curriculumName;

    @OneToMany(targetEntity = Student.class, fetch = FetchType.LAZY, mappedBy = "curriculum")
    private List<Student> students;

    @ManyToMany(targetEntity = Course.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(name = "Curriculum_Course",
            joinColumns = {
                @JoinColumn(name = "curriculumId")},
            inverseJoinColumns = {
                @JoinColumn(name = "courseId")})
    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(String curriculumId) {
        this.curriculumId = curriculumId;
    }

    public String getCurriculumName() {
        return curriculumName;
    }

    public void setCurriculumName(String curriculumName) {
        this.curriculumName = curriculumName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Curriculum{" + "curriculumId=" + curriculumId + ", curriculumName=" + curriculumName + '}';
    }

}
