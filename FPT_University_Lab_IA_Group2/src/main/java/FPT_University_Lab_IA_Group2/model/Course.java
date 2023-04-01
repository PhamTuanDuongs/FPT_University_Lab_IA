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
@Table(name = "Course")
public class Course {

    @Id
    @Column(name = "courseId")
    private String courseId;

    @Column(name = "courseName")
    private String courseName;

    @OneToMany(targetEntity = Group.class, mappedBy = "course")
    private List<Group> groups;

    @OneToMany(targetEntity = GradeCategory.class, mappedBy = "course")
    private List<GradeCategory> gradeCategorys;

    @ManyToMany(targetEntity = Curriculum.class, mappedBy = "courses")
    private List<Curriculum> curriculums;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<GradeCategory> getGradeCategorys() {
        return gradeCategorys;
    }

    public void setGradeCategorys(List<GradeCategory> gradeCategorys) {
        this.gradeCategorys = gradeCategorys;
    }

    public List<Curriculum> getCurriculums() {
        return curriculums;
    }

    public void setCurriculums(List<Curriculum> curriculums) {
        this.curriculums = curriculums;
    }

}
