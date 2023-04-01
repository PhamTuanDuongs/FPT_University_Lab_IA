/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FPT_University_Lab_IA_Group2.model;

import javax.persistence.*;

/**
 *
 * @author chuoiz
 */
@Entity
@Table(name = "Grade")
public class Grade {

    @EmbeddedId
    GradeId gradeId;

    @Column
    private float gradeValue;

    @ManyToOne
    @MapsId("gradeCategoryId")
    @JoinColumn(name = "gradeCategoryId")
    GradeCategory gradeCategory;

    @ManyToOne
    @MapsId("semesterId")
    @JoinColumn(name = "semesterId")
    Semester semester;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "studentId")
    Student student;

    public GradeId getGradeId() {
        return gradeId;
    }

    public void setGradeId(GradeId gradeId) {
        this.gradeId = gradeId;
    }

    public float getGradeValue() {
        return gradeValue;
    }

    public void setGradeValue(float gradeValue) {
        this.gradeValue = gradeValue;
    }

    public GradeCategory getGradeCategory() {
        return gradeCategory;
    }

    public void setGradeCategory(GradeCategory gradeCategory) {
        this.gradeCategory = gradeCategory;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
