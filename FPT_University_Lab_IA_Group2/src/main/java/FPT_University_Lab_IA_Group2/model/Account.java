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
@Table(name = "Account")
public class Account {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER, mappedBy = "accounts")
    private List<Role> roles;

    @OneToOne(targetEntity = Student.class, fetch = FetchType.LAZY, mappedBy = "account")
    private Student student;

    @OneToOne(targetEntity = Instructor.class, fetch = FetchType.LAZY, mappedBy = "account")
    private Instructor instructor;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Account{" + "username=" + username + ", password=" + password + ", roles=" + roles + ", student=" + student + ", instructor=" + instructor + '}';
    }
    
    

}
