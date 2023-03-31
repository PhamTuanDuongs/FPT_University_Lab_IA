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
@Table(name = "Group")
public class Group {

    @Id
    @Column(name = "groupId")
    private int groupId;

    @Column(name = "groupName")
    private String groupName;

    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;

    @OneToOne
    @JoinColumn(name = "instructorId")
    private Instructor instructor;

    @ManyToMany(targetEntity = Student.class, cascade = {CascadeType.ALL})
    @JoinTable(name = "Participate",
            joinColumns = {
                @JoinColumn(name = "groupId")},
            inverseJoinColumns = {
                @JoinColumn(name = "studentId")})
    private List<Student> students;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
