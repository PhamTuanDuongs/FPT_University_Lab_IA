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
@Table(name = "GradeCategory")
public class GradeCategory {

    @Id
    @Column(name = "gradeCategoryId")
    private int gradeCategoryId;

    @Column(name = "gradeCateogryName")
    private String gradeCateogryName;

    @Column(name = "gradeItemName")
    private String gradeItemName;

    @Column(name = "weight")
    private float weight;

    @ManyToOne(targetEntity = Course.class)
    @JoinColumn(name = "courseId")
    private Course course;

    @OneToMany(targetEntity = Grade.class, mappedBy = "gradeCategory")
    private List<Grade> grades;

    public int getGradeCategoryId() {
        return gradeCategoryId;
    }

    public void setGradeCategoryId(int gradeCategoryId) {
        this.gradeCategoryId = gradeCategoryId;
    }

    public String getGradeCateogryName() {
        return gradeCateogryName;
    }

    public void setGradeCateogryName(String gradeCateogryName) {
        this.gradeCateogryName = gradeCateogryName;
    }

    public String getGradeItemName() {
        return gradeItemName;
    }

    public void setGradeItemName(String gradeItemName) {
        this.gradeItemName = gradeItemName;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

}
