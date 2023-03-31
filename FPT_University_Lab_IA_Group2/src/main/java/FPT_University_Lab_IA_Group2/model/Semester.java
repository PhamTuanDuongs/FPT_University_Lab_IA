///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package FPT_University_Lab_IA_Group2.model;
//
//import java.sql.Date;
//import java.util.List;
//import javax.persistence.*;
//
///**
// *
// * @author chuoiz
// */
//@Entity
//@Table(name = "Semester")
//public class Semester {
//
//    @Id
//    @Column(name = "semesterId")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int semesterId;
//
//    @Column(name = "semesterName")
//    private String semesterName;
//
//    @Column(name = "year")
//    private int year;
//    
//    @Column(name = "startDate")
//    private Date startDate;
//    
//    @Column(name = "endDate")
//    private Date endDate;
//
//        
//    @OneToMany
//    private List<Grade> grades;
//}
