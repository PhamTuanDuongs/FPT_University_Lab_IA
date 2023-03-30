/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FPT_University_Lab_IA_Group2.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

    @OneToOne()
    @JoinColumn(name = "username", nullable = false)
    private Account account;

    @OneToOne()
    @JoinColumn(name = "curriculumId", nullable = false)
    private Curriculum curriculum;

    @ManyToMany(targetEntity = Group.class, cascade = {CascadeType.ALL})
    @JoinTable(name = "Account_Role",
            joinColumns = {
                @JoinColumn(name = "roleId")},
            inverseJoinColumns = {
                @JoinColumn(name = "username")})
    private List<Account> accounts;

}
