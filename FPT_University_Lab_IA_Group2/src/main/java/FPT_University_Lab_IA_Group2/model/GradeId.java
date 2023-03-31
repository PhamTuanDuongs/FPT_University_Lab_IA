/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FPT_University_Lab_IA_Group2.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

/**
 *
 * @author kmd
 */
@Embeddable
public class GradeId implements Serializable {

    @Column(name = "gradeCategoryId")
    private int gradeCategoryId;

    @Column(name = "studentId")
    private String studentId;
    
    @Column(name = "semesterId")
    private String semesterId;

    public int getGradeCategoryId() {
        return gradeCategoryId;
    }

    public void setGradeCategoryId(int gradeCategoryId) {
        this.gradeCategoryId = gradeCategoryId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(String semesterId) {
        this.semesterId = semesterId;
    }

}
