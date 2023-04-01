/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FPT_University_Lab_IA_Group2.service;

import FPT_University_Lab_IA_Group2.dao.GradeDAO;
import FPT_University_Lab_IA_Group2.model.Grade;
import FPT_University_Lab_IA_Group2.model.GradeCategory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author chuoiz
 */
@Service
@Transactional
public class GradeService {

    @Autowired
    private GradeDAO gradeDAO;

    public List<Grade> findAll() {
        return gradeDAO.findAll();
    }

    public List<Grade> listGrade(String studentId, String semesterId, String courseId) {
        return gradeDAO.listGrade(studentId, semesterId, courseId);
    }

}
