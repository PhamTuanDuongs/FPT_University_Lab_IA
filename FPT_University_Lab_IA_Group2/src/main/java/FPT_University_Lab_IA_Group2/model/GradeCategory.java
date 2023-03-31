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
    
    @ManyToOne(targetEntity = GradeCategory.class)
    @JoinColumn(name = "courseId")
    private Course course;
}
