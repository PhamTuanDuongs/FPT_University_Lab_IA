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
@Table(name = "Student")
public class Student {

    @Id
    @Column(name = "studentId")
    private String studentId;

    @Column(name = "studentName")
    private String studentName;

    @OneToOne
    @JoinColumn(name = "accountId", referencedColumnName = "username")// accountId = username
    private Account account;

    @ManyToOne
    @JoinColumn(name = "curriculumId")
    private Curriculum curriculum;

    @ManyToMany
    @JoinTable(name = "Participate",
            joinColumns = @JoinColumn(name = "studentId"),
            inverseJoinColumns = @JoinColumn(name = "groupId"))
    private List<Group> groups;

    @OneToMany(targetEntity = Grade.class, mappedBy = "student")
    private List<Grade> grades;

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

}
